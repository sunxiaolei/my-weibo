package sun.xiaolei.m_wblib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.orhanobut.logger.Logger;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.functions.Consumer;
import sun.xiaolei.m_base.Constant;
import sun.xiaolei.m_wblib.entity.Token;
import sun.xiaolei.m_wblib.net.WeiboRequest;
import sunxl8.myutils.KvUtils;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
public class WbManager {

    public static SsoHandler mSsoHandler;

    public static void checkTokenValid(Context context, WbAccessToken listener) {
        if (AccessTokenKeeper.readAccessToken(context).isSessionValid()) {
//            getToken(context);
            KvUtils.setString("wbtoken", AccessTokenKeeper.readAccessToken(context).getToken());
            listener.result(true);
        } else {
            listener.result(false);
        }
    }

    private static void getToken(Context context) {
        /**
         client_id	true	string	申请应用时分配的AppKey。
         client_secret	true	string	申请应用时分配的AppSecret。
         grant_type	true	string	请求的类型，填写authorization_code
         redirect_uri	true	string	回调地址，需需与注册应用里的回调地址一致。
         */
        Map<String, String> params = new HashMap<>();
        params.put("client_id", Constant.APP_KEY);
        params.put("client_secret", Constant.APP_SECRET);
        params.put("grant_type", "refresh_token");
        params.put("refresh_token", AccessTokenKeeper.readAccessToken(context).getRefreshToken());
        WeiboRequest.getToken(params)
                .subscribe(new Consumer<Token>() {

                    @Override
                    public void accept(Token token) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    public static String getUid(Context context) {
        return AccessTokenKeeper.readAccessToken(context).getUid();
    }

    public static void authorize(Activity activity, AuthorizeListener listener) {
        AuthInfo mAuthInfo = new AuthInfo(activity, Constant.APP_KEY, Constant.REDIRECT_URL, Constant.SCOPE);
        mSsoHandler = new SsoHandler(activity, mAuthInfo);
        mSsoHandler.authorize(new WeiboAuthListener() {
            @Override
            public void onComplete(Bundle bundle) {
                Oauth2AccessToken mAccessToken = Oauth2AccessToken.parseAccessToken(bundle);
                if (mAccessToken.isSessionValid()) {
                    // 保存 Token 到 SharedPreferences
                    AccessTokenKeeper.writeAccessToken(activity, mAccessToken);
                    KvUtils.setString("wbtoken", mAccessToken.getToken());
                    listener.onSuccess();

                } else {
                    // 会收到 Code：
                    // 1. 当您未在平台上注册的应用程序的包名与签名时；
                    // 2. 当您注册的应用程序包名与签名不正确时；
                    // 3. 当您在平台上注册的包名和签名与您当前测试的应用的包名和签名不匹配时。
                    String code = bundle.getString("code");
                    listener.onFail(code);
                }
            }

            @Override
            public void onWeiboException(WeiboException e) {
                Logger.e(e, "onWeiboException()");
                listener.onException(e);
            }

            @Override
            public void onCancel() {
                listener.onCancel();
            }
        });
    }

    public static void authorizeCallBack(int requestCode, int resultCode, Intent data) {
        if (mSsoHandler != null) {
            mSsoHandler.authorizeCallBack(requestCode, resultCode, data);
        }
    }
}

