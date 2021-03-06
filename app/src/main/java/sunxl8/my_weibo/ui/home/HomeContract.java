package sunxl8.my_weibo.ui.home;

import java.util.Map;

import sun.xiaolei.m_wblib.entity.HomeTimeline;
import sun.xiaolei.m_common.base.IPresenter;
import sun.xiaolei.m_common.base.IView;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public interface HomeContract {

    interface View extends IView {
        void setHomeTimeline(HomeTimeline homeTimeline);
    }

    interface Presenter extends IPresenter<View> {
        void getHomeTimeline(Map<String, String> params);
    }
}
