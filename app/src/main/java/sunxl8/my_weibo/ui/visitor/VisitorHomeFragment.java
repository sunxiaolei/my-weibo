package sunxl8.my_weibo.ui.visitor;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.trello.rxlifecycle.android.FragmentEvent;

import butterknife.BindView;
import rx.functions.Action1;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.ui.base.BaseFragment;
import sunxl8.my_weibo.ui.base.IPresenter;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class VisitorHomeFragment extends BaseFragment {

    @BindView(R.id.iv_visitor_home_smallicon)
    ImageView iv;
    @BindView(R.id.tv_navigation_register)
    TextView tvRegister;
    @BindView(R.id.tv_navigation_login)
    TextView tvLogin;

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
        Animation animation = AnimationUtils.loadAnimation(mActivity, R.anim.rotate);
        iv.startAnimation(animation);
        RxView.clicks(tvLogin)
                .compose(this.bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(aVoid -> {
                    ((VisitorMainActivity)mActivity).login();
                });
    }

    @Override
    public void error(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        iv.clearAnimation();
    }
}
