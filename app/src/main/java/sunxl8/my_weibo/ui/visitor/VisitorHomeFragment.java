package sunxl8.my_weibo.ui.visitor;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.BindView;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.ui.base.BaseFragment;
import sunxl8.my_weibo.ui.base.IPresenter;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class VisitorHomeFragment extends BaseFragment {

    @BindView(R.id.iv_visitor_home_smallicon)
    ImageView iv;

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
