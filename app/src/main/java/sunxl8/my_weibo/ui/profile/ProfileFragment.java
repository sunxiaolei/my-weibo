package sunxl8.my_weibo.ui.profile;

import android.content.Intent;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.target.Target;
import com.jakewharton.rxbinding.view.RxView;
import com.orhanobut.logger.Logger;
import com.sina.weibo.sdk.auth.sso.AccessTokenKeeper;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.openapi.UsersAPI;
import com.trello.rxlifecycle.android.FragmentEvent;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import rx.functions.Action1;
import sunxl8.my_weibo.Constant;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.entity.UserInfo;
import sunxl8.my_weibo.net.WeiboRequest;
import sunxl8.my_weibo.ui.base.BaseApplication;
import sunxl8.my_weibo.ui.base.BaseFragment;
import sunxl8.my_weibo.ui.setting.SettingActivity;
import sunxl8.myutils.StringUtils;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class ProfileFragment extends BaseFragment<ProfilePresenter> implements ProfileContract.View {

    @BindView(R.id.tv_navigation_setting)
    TextView tvSetting;
    @BindView(R.id.tv_profile_name)
    TextView tvName;
    @BindView(R.id.tv_profile_brief)
    TextView tvBrief;
    @BindView(R.id.iv_profile_headicon)
    CircleImageView ivHeadicon;
    @BindView(R.id.tv_profile_vip)
    TextView tvIsVip;
    @BindView(R.id.tv_profile_weibo)
    TextView tvWeibo;
    @BindView(R.id.tv_profile_attention)
    TextView tvAttention;
    @BindView(R.id.tv_profile_fans)
    TextView tvFans;

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
        mPresenter.getUserInfo();
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
        mActivity.showToast(msg);
    }

    @Override
    public void setUserInfo(UserInfo info) {
        tvName.setText(info.getScreen_name());
        tvBrief.setText(StringUtils.isEmpty(info.getDescription())?getString(R.string.profile_description_null):info.getDescription());
        Glide.with(mActivity)
                .load(info.getProfile_image_url())
                .error(R.drawable.login_profile_default)
                .into(ivHeadicon);
        tvIsVip.setCompoundDrawablesWithIntrinsicBounds(R.drawable.mine_icon_membership, 0, R.drawable.mine_icon_membership_arrow, 0);
        tvIsVip.setText(info.isVerified() ? getString(R.string.profile_membership_vip) : getString(R.string.profile_membership_nomal));
        tvWeibo.setText(info.getStatuses_count() + "");
        tvAttention.setText(info.getFriends_count() + "");
        tvFans.setText(info.getFollowers_count() + "");
    }
}
