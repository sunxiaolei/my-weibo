package sunxl8.my_weibo.ui.profile;

import com.orhanobut.logger.Logger;
import com.sina.weibo.sdk.auth.sso.AccessTokenKeeper;
import com.trello.rxlifecycle.android.ActivityEvent;

import java.util.HashMap;
import java.util.Map;

import rx.functions.Action1;
import sunxl8.my_weibo.entity.UserInfo;
import sunxl8.my_weibo.net.WeiboRequest;
import sunxl8.my_weibo.ui.base.BaseActivity;
import sunxl8.my_weibo.ui.base.BasePresenter;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class ProfilePresenter extends BasePresenter<ProfileContract.View> implements ProfileContract.Presenter {

    protected ProfilePresenter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public void getUserInfo() {
        long uid = Long.parseLong(AccessTokenKeeper.readAccessToken(mActivity).getUid());
        Map<String, String> params = new HashMap<>();
        params.put("uid", uid + "");
        WeiboRequest.show(params)
                .compose(mActivity.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(info -> {
                    mView.setUserInfo(info);
                }, throwable -> {
                    Logger.e(throwable, "UserInfo");
                    mView.error(throwable.getMessage());
                });
    }
}
