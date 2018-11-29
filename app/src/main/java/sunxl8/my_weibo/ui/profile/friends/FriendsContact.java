package sunxl8.my_weibo.ui.profile.friends;

import java.util.Map;

import sun.xiaolei.m_wblib.entity.Friends;
import sun.xiaolei.m_common.base.IPresenter;
import sun.xiaolei.m_common.base.IView;

/**
 * Created by sunxl8 on 2017/5/10.
 */

public interface FriendsContact {

    interface View extends IView {
        void setFriends(Friends friends);
    }

    interface Presenter extends IPresenter<View> {
        void getFriends(Map<String, String> params);
    }
}
