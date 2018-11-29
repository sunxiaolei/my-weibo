package sunxl8.my_weibo.ui.profile;

import sun.xiaolei.m_wblib.entity.UserInfo;
import sun.xiaolei.m_common.base.IPresenter;
import sun.xiaolei.m_common.base.IView;

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
