package sunxl8.my_weibo.ui.visitor;

import android.content.Intent;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.trello.rxlifecycle2.android.FragmentEvent;

import sunxl8.my_weibo.R;
import sun.xiaolei.m_common.base.BaseFragment;
import sun.xiaolei.m_common.base.IPresenter;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class VisitorProfileFragment extends BaseFragment {

    TextView tvSetting;

    @Override
    protected IPresenter createPresenter() {
        return null;
    }

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_visitor_profile;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        tvSetting = (TextView) findViewById(R.id.tv_navigation_setting);
        RxView.clicks(tvSetting)
                .compose(this.bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(aVoid -> {
                    startActivity(new Intent(mActivity, VisitorSettingActivity.class));
                });
    }

    @Override
    public void error(String msg) {

    }

}
