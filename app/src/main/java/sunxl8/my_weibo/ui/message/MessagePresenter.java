package sunxl8.my_weibo.ui.message;

import sun.xiaolei.m_common.base.BaseCommonActivity;
import sun.xiaolei.m_common.base.BasePresenter;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class MessagePresenter extends BasePresenter<MessageContract.View> implements MessageContract.Presenter {

    protected MessagePresenter(BaseCommonActivity activity) {
        super(activity);
    }
}
