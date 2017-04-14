package sunxl8.my_weibo.ui.setting;

import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.ui.base.BaseActivity;
import sunxl8.my_weibo.ui.base.IPresenter;
import sunxl8.my_weibo.utils.DataHolder;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class AccountManagerActivity extends BaseActivity {

    @BindView(R.id.iv_account_icon)
    CircleImageView ivIcon;
    @BindView(R.id.tv_account_name)
    TextView tvName;

    @Override
    protected IPresenter createPresenter() {
        return null;
    }

    @Override
    protected int setContentViewId() {
        return R.layout.activity_setting_account;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTitle.setText(getString(R.string.setting_account_manage));
        Glide.with(this).load(DataHolder.getInstanse().getUserIcon()).into(ivIcon);
        tvName.setText(DataHolder.getInstanse().getUserName());
    }

    @Override
    public void error(String msg) {

    }
}
