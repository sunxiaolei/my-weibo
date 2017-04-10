package sunxl8.my_weibo.ui.message;

import sunxl8.my_weibo.ui.base.BaseActivity;
import sunxl8.my_weibo.ui.base.BasePresenter;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class MessagePresenter extends BasePresenter<MessageContract.View> implements MessageContract.Presenter {

    protected MessagePresenter(BaseActivity activity) {
        super(activity);
    }
}
