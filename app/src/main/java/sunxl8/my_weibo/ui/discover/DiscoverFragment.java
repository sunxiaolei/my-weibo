package sunxl8.my_weibo.ui.discover;

import sunxl8.my_weibo.R;
import sun.xiaolei.m_common.base.BaseFragment;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class DiscoverFragment extends BaseFragment<DiscoverPresenter> implements DiscoverContract.View {

    @Override
    protected DiscoverPresenter createPresenter() {
        return new DiscoverPresenter(mActivity);
    }

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_discover;
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
