package sunxl8.my_weibo.ui.setting;

import sunxl8.my_weibo.R;
import sunxl8.my_weibo.ui.base.BaseActivity;
import sunxl8.my_weibo.ui.base.IPresenter;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class SettingActivity extends BaseActivity {

    @Override
    protected IPresenter createPresenter() {
        return null;
    }

    @Override
    protected int setContentViewId() {
        return R.layout.activity_setting;
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
