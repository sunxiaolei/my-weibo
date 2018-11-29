package sunxl8.my_weibo.ui.setting;

import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;
import sun.xiaolei.m_wblib.utils.DataHolder;
import sunxl8.my_weibo.R;
import sun.xiaolei.m_common.base.BaseSwipeActivity;
import sun.xiaolei.m_common.base.IPresenter;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class AccountManagerActivity extends BaseSwipeActivity {

    private CircleImageView ivIcon;
    private TextView tvName;

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
        ivIcon = (CircleImageView) findViewById(R.id.iv_account_icon);
        tvName = (TextView) findViewById(R.id.tv_account_name);
        mTitle.setText(getString(R.string.setting_account_manage));
        Glide.with(this).load(DataHolder.getInstanse().getUserIcon()).into(ivIcon);
        tvName.setText(DataHolder.getInstanse().getUserName());
    }

    @Override
    public void error(String msg) {

    }
}
