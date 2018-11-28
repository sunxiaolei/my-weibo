package sunxl8.my_weibo.ui.user;

import android.text.TextUtils;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import sunxl8.my_weibo.R;
import sun.xiaolei.m_base.RouteTable;
import sunxl8.my_weibo.ui.base.BaseCommonActivity;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
@Route(path = RouteTable.USER)
public class UserActivity extends BaseCommonActivity<UserPresenter> implements UserContract.View {

    @BindView(R.id.tv_name)
    TextView tvName;

    @Autowired(name = "user")
    String userName;

    @Override
    protected UserPresenter createPresenter() {
        return new UserPresenter(this);
    }

    @Override
    protected int setContentViewId() {
        return R.layout.activity_user;
    }

    @Override
    protected void initView() {
        tvName.setText(TextUtils.isEmpty(userName) ? "" : userName);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void setUserInfo() {

    }

    @Override
    public void error(String msg) {

    }
}
