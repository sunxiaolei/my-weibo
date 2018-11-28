package sunxl8.my_weibo.ui.main;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jakewharton.rxbinding2.view.RxView;
import com.trello.rxlifecycle2.android.ActivityEvent;

import butterknife.BindView;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.ui.base.BaseCommonActivity;
import sunxl8.my_weibo.ui.base.IPresenter;
import sunxl8.my_weibo.ui.discover.DiscoverFragment;
import sunxl8.my_weibo.ui.home.HomeFragment;
import sunxl8.my_weibo.ui.message.MessageFragment;
import sunxl8.my_weibo.ui.profile.ProfileFragment;
import sunxl8.my_weibo.widget.AddView;

public class MainActivity extends BaseCommonActivity {

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
    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFragment;
    private DiscoverFragment mDiscoverFragment;
    private ProfileFragment mProfileFragment;

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

    }

    @Override
    protected void initView() {
        fm = getSupportFragmentManager();
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

    private int selected = -1;

    private void setTabSelection(int position) {
        resetBtn();
        FragmentTransaction ft = fm.beginTransaction();
        hideFragments(ft);
        switch (position) {
            case 0:
                if (selected == position) {
                    mHomeFragment.getHomeTimeLine(true);
                    return;
                }
                mViewHome.setImageResource(R.drawable.tabbar_home_highlighted);
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    ft.add(mLayout.getId(), mHomeFragment);
                } else {
                    ft.show(mHomeFragment);
                }
                break;
            case 1:
                mViewMessage.setImageResource(R.drawable.tabbar_message_center_highlighted);
                if (mMessageFragment == null) {
                    mMessageFragment = new MessageFragment();
                    ft.add(mLayout.getId(), mMessageFragment);
                } else {
                    ft.show(mMessageFragment);
                }
                break;
            case 2:
                mViewDiscover.setImageResource(R.drawable.tabbar_discover_highlighted);
                if (mDiscoverFragment == null) {
                    mDiscoverFragment = new DiscoverFragment();
                    ft.add(mLayout.getId(), mDiscoverFragment);
                } else {
                    ft.show(mDiscoverFragment);
                }
                break;
            case 3:
                mViewProfile.setImageResource(R.drawable.tabbar_profile_highlighted);
                if (mProfileFragment == null) {
                    mProfileFragment = new ProfileFragment();
                    ft.add(mLayout.getId(), mProfileFragment);
                } else {
                    ft.show(mProfileFragment);
                }
                break;
        }
        selected = position;
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

}
