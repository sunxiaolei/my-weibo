package sunxl8.my_weibo.ui.weibo;

import sunxl8.my_weibo.R;
import sunxl8.my_weibo.ui.base.BaseSwipeActivity;

/**
 * Created by sunxl8 on 2017/4/20.
 */

public class WeiboActivity extends BaseSwipeActivity<WeiboPresenter> implements WeiboContract.View {

    @Override
    protected WeiboPresenter createPresenter() {
        return new WeiboPresenter(this);
    }

    @Override
    protected int setContentViewId() {
        return R.layout.activity_weibo;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTitle.setText(getString(R.string.weibo_body));
    }

    @Override
    public void error(String msg) {

    }
}
