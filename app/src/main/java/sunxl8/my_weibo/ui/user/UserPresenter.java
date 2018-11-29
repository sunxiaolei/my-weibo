package sunxl8.my_weibo.ui.user;

import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.HashMap;
import java.util.Map;

import sun.xiaolei.m_common.base.BaseActivity;
import sun.xiaolei.m_common.base.BasePresenter;
import sun.xiaolei.m_wblib.WbManager;
import sun.xiaolei.m_wblib.net.WeiboRequest;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
public class UserPresenter extends BasePresenter<UserContract.View> implements UserContract.Presenter {

    protected UserPresenter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public void getUserInfo(String userName) {
        Map<String, String> params = new HashMap<>();
        params.put("screen_name", userName);
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
