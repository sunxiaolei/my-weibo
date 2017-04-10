package sunxl8.my_weibo.ui.profile;

import sunxl8.my_weibo.R;
import sunxl8.my_weibo.ui.base.BaseFragment;
import sunxl8.my_weibo.ui.message.MessagePresenter;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class ProfileFragment extends BaseFragment<ProfilePresenter> implements ProfileContract.View {

    @Override
    protected ProfilePresenter createPresenter() {
        return new ProfilePresenter(mActivity);
    }

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_profile;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public void error(String msg) {

    }
}
