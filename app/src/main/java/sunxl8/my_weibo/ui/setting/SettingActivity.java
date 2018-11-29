package sunxl8.my_weibo.ui.setting;

import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jakewharton.rxbinding2.view.RxView;
import com.trello.rxlifecycle2.android.ActivityEvent;

import sunxl8.my_weibo.R;
import sun.xiaolei.m_common.base.BaseSwipeActivity;
import sun.xiaolei.m_common.base.IPresenter;
import sunxl8.myutils.CleanUtils;
import sunxl8.myutils.FileUtils;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class SettingActivity extends BaseSwipeActivity {

    private RelativeLayout layoutAccountManage;
    private RelativeLayout layoutCleanCache;
    private TextView tvCache;

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
        layoutAccountManage = (RelativeLayout) findViewById(R.id.layout_setting_account_manage);
        layoutCleanCache = (RelativeLayout) findViewById(R.id.layout_setting_clean_cache);
        tvCache = (TextView) findViewById(R.id.tv_setting_cache);
        mTitle.setText(getString(R.string.navigation_setting));
        RxView.clicks(layoutAccountManage)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(aVoid -> {
                    startActivity(new Intent(SettingActivity.this, AccountManagerActivity.class));
                });
        tvCache.setText(FileUtils.getDirSize(Glide.getPhotoCacheDir(this).getPath()));
        RxView.clicks(layoutCleanCache)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(aVoid -> {
                    showDialog(getString(R.string.sure_clean_cache), (dialog, which) -> {
                        CleanUtils.cleanExternalCache();
                        CleanUtils.cleanInternalCache();
                        showToast(getString(R.string.clean_cache_already));
                        tvCache.setText(FileUtils.getDirSize(Glide.getPhotoCacheDir(this).getPath()));
                    });
                });
    }

    @Override
    public void error(String msg) {

    }
}
