package sunxl8.my_weibo.ui.weibo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;
import sun.xiaolei.m_wblib.entity.StatusesBean;
import sun.xiaolei.m_common.utils.WeiboTextUtils;
import sun.xiaolei.m_wblib.utils.WeiboTimeUtils;
import sunxl8.my_weibo.R;
import sun.xiaolei.m_common.base.BaseSwipeActivity;
import sunxl8.myutils.ScreenUtils;
import sunxl8.myutils.StringUtils;

/**
 * Created by sunxl8 on 2017/4/20.
 */

public class WeiboActivity extends BaseSwipeActivity<WeiboPresenter> implements WeiboContract.View {

    LinearLayout layout;
    CircleImageView ivIcon;
    TextView tvName;
    TextView tvFrom;
    TextView tvContent;
    RecyclerView rvImg;

    private StatusesBean bean;

    @Override
    protected WeiboPresenter createPresenter() {
        return new WeiboPresenter(this);
    }

    @Override
    protected int setContentViewId() {
        return R.layout.activity_weibo;
    }

    @Override
    protected void initView() {
        layout = (LinearLayout) findViewById(R.id.layout_weibo_item);
        ivIcon = (CircleImageView) findViewById(R.id.iv_weibo_user_icon);
        tvName = (TextView) findViewById(R.id.tv_weibo_name);
        tvFrom = (TextView) findViewById(R.id.tv_weibo_from);
        tvContent = (TextView) findViewById(R.id.tv_weibo_content);
        rvImg = (RecyclerView) findViewById(R.id.rv_weibo_img);
        mTitle.setText(getString(R.string.weibo_body));
    }

    @Override
    protected void initData() {
        bean = (StatusesBean) getIntent().getSerializableExtra("bean");
        Glide.with(this).load(bean.getUser().getAvatar_hd()).into(ivIcon);
        tvName.setText(bean.getUser().getName());
        tvName.setTextColor(bean.getUser().isVerified()
                ? getResources().getColor(R.color.colorTextVip) : getResources().getColor(R.color.colorTextItemPrimary));
        String from = Html.fromHtml(bean.getSource()).toString();
        tvFrom.setText(WeiboTimeUtils.convertTime(bean.getCreated_at()) + "   " +
                (StringUtils.isEmpty(from) ? "" : getString(R.string.from) + "  " + from));
        tvContent.setText(WeiboTextUtils.getWeiBoContent(bean.getText()));
        switch (bean.getPic_urls().size()) {
            case 1:
                rvImg.setLayoutManager(new GridLayoutManager(this, 1));
                rvImg.setAdapter(new ImgAdapter(this, bean.getPic_urls(), 1));
                break;
            case 4:
                LinearLayout.LayoutParams imgLayout = (LinearLayout.LayoutParams) rvImg.getLayoutParams();
                imgLayout.width = ScreenUtils.getScreenWidth() / 3 * 2;
                rvImg.setLayoutManager(new GridLayoutManager(this, 2));
                rvImg.setAdapter(new ImgAdapter(this, bean.getPic_urls(), 3));
                break;
            default:
                rvImg.setLayoutManager(new GridLayoutManager(this, 3));
                rvImg.setAdapter(new ImgAdapter(this, bean.getPic_urls(), 3));
                break;
        }
    }

    @Override
    public void error(String msg) {

    }

    public static void startWeiboActivity(Context context, StatusesBean bean) {
        Intent intent = new Intent(context, WeiboActivity.class);
        intent.putExtra("bean", bean);
        context.startActivity(intent);
    }
}
