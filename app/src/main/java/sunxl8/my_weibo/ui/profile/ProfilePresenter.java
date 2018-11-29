package sunxl8.my_weibo.ui.profile;

import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.HashMap;
import java.util.Map;

import sun.xiaolei.m_wblib.WbManager;
import sun.xiaolei.m_wblib.net.WeiboRequest;
import sun.xiaolei.m_common.base.BaseCommonActivity;
import sun.xiaolei.m_common.base.BasePresenter;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class ProfilePresenter extends BasePresenter<ProfileContract.View> implements ProfileContract.Presenter {

    protected ProfilePresenter(BaseCommonActivity activity) {
        super(activity);
    }

    @Override
    public void getUserInfo() {
        long uid = Long.parseLong(WbManager.getUid(mActivity));
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
