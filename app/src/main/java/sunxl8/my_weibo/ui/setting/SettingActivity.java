package sunxl8.my_weibo.ui.setting;

import android.content.Intent;
import android.widget.RelativeLayout;

import com.jakewharton.rxbinding.view.RxView;
import com.trello.rxlifecycle.android.ActivityEvent;

import butterknife.BindView;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.ui.base.BaseSwipeActivity;
import sunxl8.my_weibo.ui.base.IPresenter;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class SettingActivity extends BaseSwipeActivity {

    @BindView(R.id.layout_setting_account_manage)
    RelativeLayout layoutAccountManage;

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
        RxView.clicks(layoutAccountManage)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(aVoid -> {
                    startActivity(new Intent(SettingActivity.this, AccountManagerActivity.class));
                });
    }

    @Override
    public void error(String msg) {

    }
}
