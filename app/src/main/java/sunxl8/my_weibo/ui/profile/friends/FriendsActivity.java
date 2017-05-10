package sunxl8.my_weibo.ui.profile.friends;

import android.app.Activity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jakewharton.rxbinding.view.RxView;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.trello.rxlifecycle.android.FragmentEvent;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.entity.Friends;
import sunxl8.my_weibo.net.WeiboRequest;
import sunxl8.my_weibo.ui.base.BaseSwipeActivity;
import sunxl8.my_weibo.ui.profile.FriendsAdapter;
import sunxl8.my_weibo.utils.DataHolder;

/**
 * Created by hahaha on 2017/5/9.
 * 我的好友
 */

public class FriendsActivity extends BaseSwipeActivity<FriendsPresenter> implements FriendsContact.View {

    @BindView(R.id.refresh_friends)
    SwipeRefreshLayout layoutRefresh;
    @BindView(R.id.rv_friends)
    RecyclerView rvFriends;

    private FriendsAdapter mAdapter;

    private int page = 1;

    @Override
    protected FriendsPresenter createPresenter() {
        return new FriendsPresenter(this);
    }

    @Override
    protected int setContentViewId() {
        return R.layout.activity_friends;
    }

    @Override
    protected void initData() {
        layoutRefresh.setRefreshing(true);
        getFriends(true);

    }

    private void getFriends(boolean refresh) {
        if (refresh) {
            layoutRefresh.setRefreshing(true);
            page = 1;
        }
        /**
         uid	false	int64	需要查询的用户UID。
         screen_name	false	string	需要查询的用户昵称。
         count	false	int	单页返回的记录条数，默认为5，最大不超过5。
         cursor	false	int	返回结果的游标，下一页用返回值里的next_cursor，上一页用previous_cursor，默认为0。
         trim_status	false	int	返回值中user字段中的status字段开关，0：返回完整status字段、1：status字段仅返回status_id，默认为1。
         */
        Map<String, String> params = new HashMap<>();
        params.put("uid", String.valueOf(DataHolder.getInstanse().getUserId()));
        params.put("count", "20");
        params.put("cursor", String.valueOf(page));
        mPresenter.getFriends(params);
    }

    @Override
    protected void initView() {
        rvFriends.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new FriendsAdapter(this);
        rvFriends.setAdapter(mAdapter);

        layoutRefresh.setOnRefreshListener(() -> getFriends(true));
        mAdapter.setOnLoadMoreListener(() -> {
            page++;
            getFriends(false);
        }, rvFriends);

        View emptyView = LayoutInflater.from(this).inflate(R.layout.view_empty, (ViewGroup) rvFriends.getParent(), false);
        mAdapter.setEmptyView(emptyView);
        RxView.clicks(emptyView)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(aVoid -> {
                    getFriends(true);
                });
    }

    @Override
    public void error(String msg) {
        layoutRefresh.setRefreshing(false);
    }

    @Override
    public void setFriends(Friends friends) {
        layoutRefresh.setRefreshing(false);
        mAdapter.addData(friends.getUsers());
    }
}
