package sunxl8.my_weibo.ui.home;

import sunxl8.my_weibo.R;
import sunxl8.my_weibo.ui.base.BaseFragment;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter(mActivity);
    }

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_home;
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
