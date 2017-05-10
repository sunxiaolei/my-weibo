package sunxl8.my_weibo.ui.profile.friends;

import com.trello.rxlifecycle.android.ActivityEvent;

import java.util.Map;

import rx.functions.Action1;
import sunxl8.my_weibo.entity.Friends;
import sunxl8.my_weibo.net.WeiboRequest;
import sunxl8.my_weibo.ui.base.BaseActivity;
import sunxl8.my_weibo.ui.base.BasePresenter;

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
