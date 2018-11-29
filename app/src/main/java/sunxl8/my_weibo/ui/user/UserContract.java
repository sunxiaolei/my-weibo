package sunxl8.my_weibo.ui.user;

import sun.xiaolei.m_common.base.IPresenter;
import sun.xiaolei.m_common.base.IView;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
public interface UserContract {

    interface View extends IView {
        void setUserInfo();
    }

    interface Presenter extends IPresenter<View> {
        void getUserInfo();
    }
}
