package sunxl8.my_weibo.ui.profile.friends;

import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.Map;

import sun.xiaolei.m_wblib.net.WeiboRequest;
import sun.xiaolei.m_common.base.BaseActivity;
import sun.xiaolei.m_common.base.BasePresenter;

/**
 * Created by sunxl8 on 2017/5/10.
 */

public class FriendsPresenter extends BasePresenter<FriendsContact.View> implements FriendsContact.Presenter {

    protected FriendsPresenter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public void getFriends(Map<String, String> params) {
        WeiboRequest.getFriends(params)
                .compose(mActivity.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(friends -> {
                    mView.setFriends(friends);
                }, throwable -> {
                    mView.error(throwable.getMessage());
                });
    }
}
