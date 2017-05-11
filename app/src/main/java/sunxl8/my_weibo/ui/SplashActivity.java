package sunxl8.my_weibo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.sina.weibo.sdk.auth.sso.AccessTokenKeeper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;
import sunxl8.my_weibo.Constant;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.entity.Token;
import sunxl8.my_weibo.entity.TokenInfo;
import sunxl8.my_weibo.net.WeiboRequest;
import sunxl8.my_weibo.ui.base.BaseApplication;
import sunxl8.my_weibo.ui.main.MainActivity;
import sunxl8.my_weibo.ui.visitor.VisitorMainActivity;
import sunxl8.my_weibo.utils.DataHolder;

/**
 * Created by sunxl8 on 2017/4/12.
 */

public class SplashActivity extends AppCompatActivity {

    private Intent mStartIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView img = new ImageView(this);
        img.setBackgroundResource(R.drawable.surprise_background_default);
        setContentView(img);

        if (AccessTokenKeeper.readAccessToken(this).isSessionValid()) {
            getToken();
            BaseApplication.token = AccessTokenKeeper.readAccessToken(this).getToken();
            mStartIntent = new Intent(this, MainActivity.class);
        } else {
            mStartIntent = new Intent(this, VisitorMainActivity.class);
        }

        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .subscribe(aLong -> {
                    finish();
                    startActivity(mStartIntent);
                });
    }

    private void getToken() {
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
        params.put("refresh_token", AccessTokenKeeper.readAccessToken(this).getRefreshToken());
        WeiboRequest.getToken(params)
                .subscribe(new Action1<Token>() {
                    @Override
                    public void call(Token info) {

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
    }

}
