package sunxl8.my_weibo.ui.user;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import sun.xiaolei.m_wblib.entity.UserInfo;
import sunxl8.my_weibo.R;
import sun.xiaolei.m_common.RouteTable;
import sun.xiaolei.m_common.base.BaseCommonActivity;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
@Route(path = RouteTable.USER)
public class UserActivity extends BaseCommonActivity<UserPresenter> implements UserContract.View {

    private ImageView ivUserBackground;//背景
    private ImageView ivUserAvatar;//头像
    private TextView tvUserName;//用户名
    private RecyclerView rvWb;

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
        StatusBarUtil.setTranslucentForCoordinatorLayout(this, 0);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserActivity.this, "返回", Toast.LENGTH_LONG).show();
            }
        });
        ivUserBackground = findViewById(R.id.iv_user_background);
        ivUserAvatar = findViewById(R.id.iv_avatar);
        tvUserName = findViewById(R.id.tv_user_name);
        rvWb = findViewById(R.id.rv_wb);
        rvWb.setLayoutManager(new LinearLayoutManager(this));
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("==>" + i + "<==");
        }
        rvWb.setAdapter(new BaseQuickAdapter<String, BaseViewHolder>(android.R.layout.simple_list_item_1, list) {

            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(android.R.id.text1, item);
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.getUserInfo(userName);
    }

    @Override
    public void error(String msg) {

    }

    @Override
    public void setUserInfo(UserInfo userInfo) {
        RequestOptions optionsAvatar = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.login_profile_default)
                .error(R.drawable.login_profile_default);
        Glide.with(this)
                .load(userInfo.getAvatar_large())
                .apply(optionsAvatar)
                .into(ivUserAvatar);
        Glide.with(this)
                .load(userInfo.getCover_image_phone())
                .into(ivUserBackground);
        tvUserName.setText(userInfo.getScreen_name());
    }
}
