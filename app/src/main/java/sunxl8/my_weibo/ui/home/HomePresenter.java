package sunxl8.my_weibo.ui.home;

import sunxl8.my_weibo.ui.base.BaseActivity;
import sunxl8.my_weibo.ui.base.BasePresenter;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    protected HomePresenter(BaseActivity activity) {
        super(activity);
    }
}
