package sunxl8.my_weibo.ui.visitor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jakewharton.rxbinding.view.RxView;
import com.orhanobut.logger.Logger;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.trello.rxlifecycle.android.ActivityEvent;

import butterknife.BindView;
import sunxl8.my_weibo.Constant;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.ui.base.BaseCommonActivity;
import sunxl8.my_weibo.ui.base.IPresenter;
import sunxl8.my_weibo.ui.main.MainActivity;
import sunxl8.my_weibo.widget.AddView;

public class VisitorMainActivity extends BaseCommonActivity {

    @BindView(R.id.layout_container)
    FrameLayout mLayout;
    @BindView(R.id.layout_tabbar_home)
    LinearLayout layoutHome;
    @BindView(R.id.layout_tabbar_message)
    LinearLayout layoutMessage;
    @BindView(R.id.layout_tabbar_discover)
    LinearLayout layoutDiscover;
    @BindView(R.id.layout_tabbar_profile)
    LinearLayout layoutProfile;
    @BindView(R.id.iv_tabbar_home)
    ImageView mViewHome;
    @BindView(R.id.iv_tabbar_message)
    ImageView mViewMessage;
    @BindView(R.id.iv_tabbar_discover)
    ImageView mViewDiscover;
    @BindView(R.id.iv_tabbar_profile)
    ImageView mViewProfile;
    @BindView(R.id.iv_tabbar_add)
    ImageView mViewAdd;
    @BindView(R.id.view_add)
    AddView viewAdd;


    private FragmentManager fm;
    private VisitorHomeFragment mHomeFragment;
    private VisitorMessageFragment mMessageFragment;
    private VisitorDiscoverFragment mDiscoverFragment;
    private VisitorProfileFragment mProfileFragment;

    private AuthInfo mAuthInfo;
    private SsoHandler mSsoHandler;
    private Oauth2AccessToken mAccessToken;

    @Override
    protected IPresenter createPresenter() {
        return null;
    }

    @Override
    protected int setContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mAuthInfo = new AuthInfo(this, Constant.APP_KEY, Constant.REDIRECT_URL, Constant.SCOPE);
        mSsoHandler = new SsoHandler(this, mAuthInfo);
        fm = getSupportFragmentManager();
    }

    @Override
    protected void initView() {
        setTabSelection(0);
        RxView.clicks(layoutHome)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(aVoid -> {
                    setTabSelection(0);
                });
        RxView.clicks(layoutMessage)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(aVoid -> {
                    setTabSelection(1);
                });
        RxView.clicks(layoutDiscover)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(aVoid -> {
                    setTabSelection(2);
                });
        RxView.clicks(layoutProfile)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(aVoid -> {
                    setTabSelection(3);
                });
        RxView.clicks(mViewAdd)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(aVoid -> {
                    viewAdd.show();
                });
    }

    @Override
    public void error(String msg) {

    }

    private void setTabSelection(int position) {
        resetBtn();
        FragmentTransaction ft = fm.beginTransaction();
        hideFragments(ft);
        switch (position) {
            case 0:
                mViewHome.setImageResource(R.drawable.tabbar_home_highlighted);
                if (mHomeFragment == null) {
                    mHomeFragment = new VisitorHomeFragment();
                    ft.add(mLayout.getId(), mHomeFragment);
                } else {
                    ft.show(mHomeFragment);
                }
                break;
            case 1:
                mViewMessage.setImageResource(R.drawable.tabbar_message_center_highlighted);
                if (mMessageFragment == null) {
                    mMessageFragment = new VisitorMessageFragment();
                    ft.add(mLayout.getId(), mMessageFragment);
                } else {
                    ft.show(mMessageFragment);
                }
                break;
            case 2:
                mViewDiscover.setImageResource(R.drawable.tabbar_discover_highlighted);
                if (mDiscoverFragment == null) {
                    mDiscoverFragment = new VisitorDiscoverFragment();
                    ft.add(mLayout.getId(), mDiscoverFragment);
                } else {
                    ft.show(mDiscoverFragment);
                }
                break;
            case 3:
                mViewProfile.setImageResource(R.drawable.tabbar_profile_highlighted);
                if (mProfileFragment == null) {
                    mProfileFragment = new VisitorProfileFragment();
                    ft.add(mLayout.getId(), mProfileFragment);
                } else {
                    ft.show(mProfileFragment);
                }
                break;
        }
        ft.commit();
    }

    private void resetBtn() {
        mViewHome.setImageResource(R.drawable.tabbar_home);
        mViewMessage.setImageResource(R.drawable.tabbar_message_center);
        mViewDiscover.setImageResource(R.drawable.tabbar_discover);
        mViewProfile.setImageResource(R.drawable.tabbar_profile);
    }

    private void hideFragments(FragmentTransaction ft) {
        if (mHomeFragment != null) {
            ft.hide(mHomeFragment);
        }
        if (mMessageFragment != null) {
            ft.hide(mMessageFragment);
        }
        if (mDiscoverFragment != null) {
            ft.hide(mDiscoverFragment);
        }
        if (mProfileFragment != null) {
            ft.hide(mProfileFragment);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mSsoHandler != null) {
            mSsoHandler.authorizeCallBack(requestCode, resultCode, data);
        }
    }

    public void login() {
        mSsoHandler.authorize(new WeiboAuthListener() {
            @Override
            public void onComplete(Bundle bundle) {
                mAccessToken = Oauth2AccessToken.parseAccessToken(bundle);
                if (mAccessToken.isSessionValid()) {
                    // 保存 Token 到 SharedPreferences
                    AccessTokenKeeper.writeAccessToken(VisitorMainActivity.this, mAccessToken);
                    showToast(getString(R.string.login_success));
                    finish();
                    startActivity(new Intent(VisitorMainActivity.this, MainActivity.class));
                } else {
                    // 会收到 Code：
                    // 1. 当您未在平台上注册的应用程序的包名与签名时；
                    // 2. 当您注册的应用程序包名与签名不正确时；
                    // 3. 当您在平台上注册的包名和签名与您当前测试的应用的包名和签名不匹配时。
                    String code = bundle.getString("code");
                    showToast(getString(R.string.login_fail) + "-code:" + code);
                }
            }

            @Override
            public void onWeiboException(WeiboException e) {
                Logger.e(e, "onWeiboException()");
            }

            @Override
            public void onCancel() {

            }
        });
    }

}
