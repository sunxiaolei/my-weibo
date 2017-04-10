package sunxl8.my_weibo.ui.message;

import sunxl8.my_weibo.R;
import sunxl8.my_weibo.ui.base.BaseFragment;
import sunxl8.my_weibo.ui.home.HomePresenter;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class MessageFragment extends BaseFragment<MessagePresenter> implements MessageContract.View {

    @Override
    protected MessagePresenter createPresenter() {
        return new MessagePresenter(mActivity);
    }

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_message;
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
