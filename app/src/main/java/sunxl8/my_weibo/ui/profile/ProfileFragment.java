package sunxl8.my_weibo.ui.profile;

import android.content.Intent;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.trello.rxlifecycle.android.FragmentEvent;

import butterknife.BindView;
import rx.functions.Action1;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.ui.base.BaseFragment;
import sunxl8.my_weibo.ui.message.MessagePresenter;
import sunxl8.my_weibo.ui.setting.SettingActivity;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class ProfileFragment extends BaseFragment<ProfilePresenter> implements ProfileContract.View {

    @BindView(R.id.tv_navigation_setting)
    TextView tvSetting;

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
        RxView.clicks(tvSetting)
                .compose(this.bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(aVoid -> {
                    startActivity(new Intent(mActivity, SettingActivity.class));
                });
    }

    @Override
    public void error(String msg) {

    }
}
