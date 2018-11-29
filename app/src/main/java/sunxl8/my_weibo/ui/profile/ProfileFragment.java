package sunxl8.my_weibo.ui.profile;

import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jakewharton.rxbinding2.view.RxView;
import com.trello.rxlifecycle2.android.FragmentEvent;

import de.hdodenhof.circleimageview.CircleImageView;
import sun.xiaolei.m_wblib.entity.UserInfo;
import sun.xiaolei.m_wblib.utils.DataHolder;
import sunxl8.my_weibo.R;
import sun.xiaolei.m_common.base.BaseFragment;
import sunxl8.my_weibo.ui.profile.friends.FriendsActivity;
import sunxl8.my_weibo.ui.setting.SettingActivity;
import sunxl8.myutils.StringUtils;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class ProfileFragment extends BaseFragment<ProfilePresenter> implements ProfileContract.View {

    private TextView tvSetting;
    private TextView tvName;
    private TextView tvBrief;
    private CircleImageView ivHeadicon;
    private TextView tvIsVip;
    private TextView tvWeibo;
    private TextView tvAttention;
    private TextView tvFans;

    private LinearLayout layoutAttention;

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
        tvSetting = findViewById(R.id.tv_navigation_setting);
        tvName = findViewById(R.id.tv_profile_name);
        tvBrief = findViewById(R.id.tv_profile_brief);
        ivHeadicon = findViewById(R.id.iv_profile_headicon);
        tvIsVip = findViewById(R.id.tv_profile_vip);
        tvWeibo = findViewById(R.id.tv_profile_weibo);
        tvAttention = findViewById(R.id.tv_profile_attention);
        tvFans = findViewById(R.id.tv_profile_fans);
        layoutAttention = findViewById(R.id.layout_profile_attention);
        RxView.clicks(tvSetting)
                .compose(this.bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(aVoid -> {
                    startActivity(new Intent(mActivity, SettingActivity.class));
                });
        RxView.clicks(layoutAttention)
                .compose(this.bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(aVoid -> {
                    startActivity(new Intent(mActivity, FriendsActivity.class));
                });
    }

    @Override
    public void error(String msg) {
        mActivity.showToast(msg);
    }

    @Override
    public void setUserInfo(UserInfo info) {
        tvName.setText(info.getScreen_name());
        tvBrief.setText(StringUtils.isEmpty(info.getDescription()) ? getString(R.string.profile_description_null) : info.getDescription());
        RequestOptions requestOptions = new RequestOptions()
                .error(R.drawable.login_profile_default);
        Glide.with(mActivity)
                .load(info.getProfile_image_url())
                .apply(requestOptions)
                .into(ivHeadicon);
        tvIsVip.setCompoundDrawablesWithIntrinsicBounds(R.drawable.mine_icon_membership, 0, R.drawable.mine_icon_membership_arrow, 0);
        tvIsVip.setText(info.isVerified() ? getString(R.string.profile_membership_vip) : getString(R.string.profile_membership_nomal));
        tvWeibo.setText(info.getStatuses_count() + "");
        tvAttention.setText(info.getFriends_count() + "");
        tvFans.setText(info.getFollowers_count() + "");

        DataHolder.getInstanse().setUserId(info.getId());
        DataHolder.getInstanse().setUserName(info.getScreen_name());
        DataHolder.getInstanse().setUserIcon(info.getProfile_image_url());
    }
}
