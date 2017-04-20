package sunxl8.my_weibo.ui.weibo;

import sunxl8.my_weibo.ui.base.BaseActivity;
import sunxl8.my_weibo.ui.base.BasePresenter;

/**
 * Created by sunxl8 on 2017/4/20.
 */

public class WeiboPresenter extends BasePresenter<WeiboContract.View> implements WeiboContract.Presenter {

    protected WeiboPresenter(BaseActivity activity) {
        super(activity);
    }
}
