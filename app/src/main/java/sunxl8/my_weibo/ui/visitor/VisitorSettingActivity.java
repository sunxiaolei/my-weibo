package sunxl8.my_weibo.ui.visitor;

import sunxl8.my_weibo.R;
import sunxl8.my_weibo.ui.base.BaseCommonActivity;
import sunxl8.my_weibo.ui.base.IPresenter;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class VisitorSettingActivity extends BaseCommonActivity {

    @Override
    protected IPresenter createPresenter() {
        return null;
    }

    @Override
    protected int setContentViewId() {
        return R.layout.activity_visitor_setting;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTitle.setText(getString(R.string.navigation_setting));
    }

    @Override
    public void error(String msg) {

    }
}
