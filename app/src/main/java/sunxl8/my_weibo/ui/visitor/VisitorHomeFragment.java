package sunxl8.my_weibo.ui.visitor;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.trello.rxlifecycle2.android.FragmentEvent;

import sunxl8.my_weibo.R;
import sun.xiaolei.m_common.base.BaseFragment;
import sun.xiaolei.m_common.base.IPresenter;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class VisitorHomeFragment extends BaseFragment {

    private ImageView iv;
    private TextView tvRegister;
    private TextView tvLogin;

    @Override
    protected IPresenter createPresenter() {
        return null;
    }

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_visitor_home;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        iv = (ImageView) findViewById(R.id.iv_visitor_home_smallicon);
        tvRegister = (TextView) findViewById(R.id.tv_navigation_register);
        tvLogin = (TextView) findViewById(R.id.tv_navigation_login);
        Animation animation = AnimationUtils.loadAnimation(mActivity, R.anim.rotate);
        iv.startAnimation(animation);
        RxView.clicks(tvLogin)
                .compose(this.bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(aVoid -> {
                    ((VisitorMainActivity) mActivity).login();
                });
    }

    @Override
    public void error(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
