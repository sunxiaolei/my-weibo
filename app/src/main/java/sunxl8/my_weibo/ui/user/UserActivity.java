package sunxl8.my_weibo.ui.user;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import sunxl8.my_weibo.R;
import sun.xiaolei.m_common.RouteTable;
import sun.xiaolei.m_common.base.BaseCommonActivity;
import sunxl8.myutils.StatusBarUtils;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
@Route(path = RouteTable.USER)
public class UserActivity extends BaseCommonActivity<UserPresenter> implements UserContract.View {

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
        StatusBarUtils.from(this)
                .setTransparentNavigationbar(true)
                .process(this);
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

    }

    @Override
    public void setUserInfo() {

    }

    @Override
    public void error(String msg) {

    }
}
