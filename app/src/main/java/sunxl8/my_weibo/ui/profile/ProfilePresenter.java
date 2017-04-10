package sunxl8.my_weibo.ui.profile;

import sunxl8.my_weibo.ui.base.BaseActivity;
import sunxl8.my_weibo.ui.base.BasePresenter;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class ProfilePresenter extends BasePresenter<ProfileContract.View> implements ProfileContract.Presenter {

    protected ProfilePresenter(BaseActivity activity) {
        super(activity);
    }
}
