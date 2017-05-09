package sunxl8.my_weibo.ui.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.trello.rxlifecycle.android.FragmentEvent;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.entity.HomeTimeline;
import sunxl8.my_weibo.ui.weibo.WeiboAdapter;
import sunxl8.my_weibo.ui.base.BaseFragment;
import sunxl8.my_weibo.widget.GroupPopWindow;
import sunxl8.my_weibo.widget.RadarPopWindow;
import sunxl8.my_weibo.widget.WrapContentLinearLayoutManager;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.refresh_fragment_home)
    SwipeRefreshLayout layoutRefresh;
    @BindView(R.id.layout_navigation)
    RelativeLayout layoutNavigation;
    @BindView(R.id.iv_navigation_friendattention)
    ImageView ivNavigationFriend;
    @BindView(R.id.iv_navigation_radar)
    ImageView ivNavigationRadar;
    @BindView(R.id.tv_navigation_name)
    TextView tvNavigationName;
    @BindView(R.id.rv_fragment_home)
    RecyclerView xrvHomeTimeline;

    private WeiboAdapter mAdapter;
    private RadarPopWindow radarPopWindow;
    private GroupPopWindow groupPopWindow;

    private int page = 1;

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
        getHomeTimeLine(true);
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
        xrvHomeTimeline.setLayoutManager(new WrapContentLinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        mAdapter = new WeiboAdapter(mActivity);
        xrvHomeTimeline.setAdapter(mAdapter);

        layoutRefresh.setOnRefreshListener(() -> getHomeTimeLine(true));
        mAdapter.setOnLoadMoreListener(() -> {
            page++;
            getHomeTimeLine(false);
        }, xrvHomeTimeline);

        View emptyView = LayoutInflater.from(mActivity).inflate(R.layout.view_empty, (ViewGroup) xrvHomeTimeline.getParent(), false);
        mAdapter.setEmptyView(emptyView);
        RxView.clicks(emptyView)
                .compose(this.bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(aVoid -> {
                    getHomeTimeLine(true);
                });

    }

    public void getHomeTimeLine(boolean refresh) {
        if (refresh) {
            layoutRefresh.setRefreshing(true);
            page = 1;
        }
        Map<String, String> params = new HashMap<>();
        /**
         since_id	false	int64	若指定此参数，则返回ID比since_id大的微博（即比since_id时间晚的微博），默认为0。
         max_id	false	int64	若指定此参数，则返回ID小于或等于max_id的微博，默认为0。
         count	false	int	单页返回的记录条数，最大不超过100，默认为20。
         page	false	int	返回结果的页码，默认为1。
         base_app	false	int	是否只获取当前应用的数据。0为否（所有数据），1为是（仅当前应用），默认为0。
         feature	false	int	过滤类型ID，0：全部、1：原创、2：图片、3：视频、4：音乐，默认为0。
         trim_user	false	int	返回值中user字段开关，0：返回完整user字段、1：user字段仅返回user_id，默认为0。
         */
        params.put("page", String.valueOf(page));
        mPresenter.getHomeTimeline(params);
    }

    @Override
    public void error(String msg) {
        layoutRefresh.setRefreshing(false);
        mAdapter.loadMoreComplete();
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

    @Override
    public void setHomeTimeline(HomeTimeline homeTimeline) {
        layoutRefresh.setRefreshing(false);
        mAdapter.loadMoreComplete();
        mAdapter.addData(homeTimeline.getStatuses());

    }
}
