package sunxl8.my_weibo.ui.user;

import sunxl8.my_weibo.ui.base.BaseActivity;
import sunxl8.my_weibo.ui.base.BasePresenter;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
public class UserPresenter extends BasePresenter<UserContract.View> implements UserContract.Presenter {

    protected UserPresenter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public void getUserInfo() {

    }
}
