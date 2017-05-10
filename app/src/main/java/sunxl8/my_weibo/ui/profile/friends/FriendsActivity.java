package sunxl8.my_weibo.ui.profile.friends;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.trello.rxlifecycle.android.ActivityEvent;

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

    @BindView(R.id.rv_friends)
    RecyclerView rvFriends;

    private FriendsAdapter mAdapter;

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
        params.put("cursor", "0");
        params.put("trim_status", "0");
        mPresenter.getFriends(params);
    }

    @Override
    protected void initView() {
        rvFriends.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new FriendsAdapter(this);
        rvFriends.setAdapter(mAdapter);
    }

    @Override
    public void error(String msg) {

    }

    @Override
    public void setFriends(Friends friends) {
        mAdapter.addData(friends.getUsers());
    }
}
