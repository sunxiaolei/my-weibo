package sunxl8.my_weibo.ui.user;

import sunxl8.my_weibo.ui.base.IPresenter;
import sunxl8.my_weibo.ui.base.IView;

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
