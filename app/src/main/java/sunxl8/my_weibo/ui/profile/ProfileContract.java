package sunxl8.my_weibo.ui.profile;

import sunxl8.my_weibo.entity.UserInfo;
import sunxl8.my_weibo.ui.base.IPresenter;
import sunxl8.my_weibo.ui.base.IView;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public interface ProfileContract {

    interface View extends IView {
        void setUserInfo(UserInfo info);
    }

    interface Presenter extends IPresenter<View> {
        void getUserInfo();
    }
}
