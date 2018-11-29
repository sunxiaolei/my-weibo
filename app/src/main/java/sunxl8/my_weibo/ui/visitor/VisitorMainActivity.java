package sunxl8.my_weibo.ui.visitor;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jakewharton.rxbinding2.view.RxView;
import com.trello.rxlifecycle2.android.ActivityEvent;

import sun.xiaolei.m_wblib.AuthorizeListener;
import sun.xiaolei.m_wblib.WbManager;
import sunxl8.my_weibo.R;
import sun.xiaolei.m_common.base.BaseCommonActivity;
import sun.xiaolei.m_common.base.IPresenter;
import sunxl8.my_weibo.ui.main.MainActivity;
import sunxl8.my_weibo.widget.AddView;

public class VisitorMainActivity extends BaseCommonActivity {

    private FrameLayout mLayout;
    private LinearLayout layoutHome;
    private LinearLayout layoutMessage;
    private LinearLayout layoutDiscover;
    private LinearLayout layoutProfile;
    private ImageView mViewHome;
    private ImageView mViewMessage;
    private ImageView mViewDiscover;
    private ImageView mViewProfile;
    private ImageView mViewAdd;
    private AddView viewAdd;


    private FragmentManager fm;
    private VisitorHomeFragment mHomeFragment;
    private VisitorMessageFragment mMessageFragment;
    private VisitorDiscoverFragment mDiscoverFragment;
    private VisitorProfileFragment mProfileFragment;

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

        fm = getSupportFragmentManager();
    }

    @Override
    protected void initView() {
        mLayout = findViewById(R.id.layout_container);
        layoutHome = findViewById(R.id.layout_tabbar_home);
        layoutMessage = findViewById(R.id.layout_tabbar_message);
        layoutDiscover = findViewById(R.id.layout_tabbar_discover);
        layoutProfile = findViewById(R.id.layout_tabbar_profile);
        mViewHome = findViewById(R.id.iv_tabbar_home);
        mViewMessage = findViewById(R.id.iv_tabbar_message);
        mViewDiscover = findViewById(R.id.iv_tabbar_discover);
        mViewProfile = findViewById(R.id.iv_tabbar_profile);
        mViewAdd = findViewById(R.id.iv_tabbar_add);
        viewAdd = findViewById(R.id.view_add);
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
        WbManager.authorizeCallBack(requestCode, resultCode, data);
    }

    public void login() {
        WbManager.authorize(this, new AuthorizeListener() {
            @Override
            public void onSuccess() {
                showToast(getString(R.string.login_success));
                finish();
                startActivity(new Intent(VisitorMainActivity.this, MainActivity.class));
            }

            @Override
            public void onFail(String code) {
                showToast(getString(R.string.login_fail) + "-code:" + code);
            }

            @Override
            public void onException(Exception e) {

            }

            @Override
            public void onCancel() {

            }
        });
    }

}
