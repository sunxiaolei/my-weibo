package sunxl8.my_weibo.ui.user;

import sun.xiaolei.m_common.base.IPresenter;
import sun.xiaolei.m_common.base.IView;
import sun.xiaolei.m_wblib.entity.UserInfo;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
public interface UserContract {

    interface View extends IView {
        void setUserInfo(UserInfo userInfo);
    }

    interface Presenter extends IPresenter<View> {
        void getUserInfo(String userName);
    }
}
