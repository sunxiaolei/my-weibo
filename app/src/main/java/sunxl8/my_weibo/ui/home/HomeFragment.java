package sunxl8.my_weibo.ui.home;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.trello.rxlifecycle.android.FragmentEvent;

import butterknife.BindView;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.ui.base.BaseFragment;
import sunxl8.my_weibo.widget.GroupPopWindow;
import sunxl8.my_weibo.widget.RadarPopWindow;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.layout_navigation)
    RelativeLayout layoutNavigation;
    @BindView(R.id.iv_navigation_friendattention)
    ImageView ivNavigationFriend;
    @BindView(R.id.iv_navigation_radar)
    ImageView ivNavigationRadar;
    @BindView(R.id.tv_navigation_name)
    TextView tvNavigationName;

    private RadarPopWindow radarPopWindow;
    private GroupPopWindow groupPopWindow;

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter(mActivity);
    }

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        RxView.clicks(ivNavigationFriend)
                .compose(this.bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(aVoid -> {

                });
        RxView.clicks(tvNavigationName)
                .compose(this.bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(aVoid -> {
                    showGroupView();
                });
        RxView.clicks(ivNavigationRadar)
                .compose(this.bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(aVoid -> {
                    showRadarView();
                });
    }

    @Override
    public void error(String msg) {

    }

    private void showRadarView() {
        if (radarPopWindow == null) {
            radarPopWindow = new RadarPopWindow(mActivity);
        }
        radarPopWindow.showAsDropDown(ivNavigationRadar);
    }

    private void showGroupView() {
        if (groupPopWindow == null) {
            groupPopWindow = new GroupPopWindow(mActivity);
        }
        groupPopWindow.showAsDropDown(tvNavigationName);
    }
}
