package sunxl8.my_weibo.ui.weibo;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import sun.xiaolei.m_base.utils.WeiboTextUtils;
import sun.xiaolei.m_base.utils.WeiboTimeUtils;
import sun.xiaolei.m_wblib.entity.StatusesBean;
import sunxl8.my_weibo.R;
import sunxl8.myutils.ScreenUtils;
import sunxl8.myutils.StringUtils;

/**
 * Created by sunxl8 on 2017/5/9.
 */

public class WeiboAdapter extends BaseQuickAdapter<StatusesBean, BaseViewHolder> {

    private Context mContext;

    public WeiboAdapter(Context context) {
        super(R.layout.item_weibo);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, StatusesBean bean) {
        Glide.with(mContext).load(bean.getUser().getAvatar_hd()).into((ImageView) holder.getView(R.id.iv_item_user_icon));
        String from = Html.fromHtml(bean.getSource()).toString();
        holder.setText(R.id.tv_item_name, bean.getUser().getName())
                .setTextColor(R.id.tv_item_name, bean.getUser().isVerified()
                        ? mContext.getResources().getColor(R.color.colorTextVip) : mContext.getResources().getColor(R.color.colorTextItemPrimary))
                .setText(R.id.tv_item_from, WeiboTimeUtils.convertTime(bean.getCreated_at()) + "   " +
                        (StringUtils.isEmpty(from) ? "" : mContext.getString(R.string.from) + "  " + from))
                .setText(R.id.tv_item_content, WeiboTextUtils.getWeiBoContent(bean.getText()))
                .setText(R.id.tv_item_retweet, String.valueOf(bean.getReposts_count()))
                .setText(R.id.tv_item_comment, String.valueOf(bean.getComments_count()))
                .setText(R.id.tv_item_like, String.valueOf(bean.getAttitudes_count()));
        RecyclerView rv = holder.getView(R.id.rv_item_img);
        switch (bean.getPic_urls().size()) {
            case 1:
                rv.setLayoutManager(new GridLayoutManager(mContext, 1));
                rv.setAdapter(new ImgAdapter(mContext, bean.getPic_urls(), 1));
                break;
            case 4:
                LinearLayout.LayoutParams imgLayout = (LinearLayout.LayoutParams) rv.getLayoutParams();
                imgLayout.width = ScreenUtils.getScreenWidth() / 3 * 2;
                rv.setLayoutManager(new GridLayoutManager(mContext, 2));
                rv.setAdapter(new ImgAdapter(mContext, bean.getPic_urls(), 3));
                break;
            default:
                rv.setLayoutManager(new GridLayoutManager(mContext, 3));
                rv.setAdapter(new ImgAdapter(mContext, bean.getPic_urls(), 3));
                break;
        }

        if (bean.getRetweeted_status() != null) {
            holder.getView(R.id.layout_item_source).setVisibility(View.VISIBLE);
            holder.setText(R.id.tv_item_source_content, WeiboTextUtils.getWeiBoContent(
                    "@" + bean.getRetweeted_status().getUser().getName() + ":" + bean.getRetweeted_status().getText()));
            RecyclerView rvSource = holder.getView(R.id.rv_item_source_img);
            switch (bean.getRetweeted_status().getPic_urls().size()) {
                case 1:
                    rvSource.setLayoutManager(new GridLayoutManager(mContext, 1));
                    rvSource.setAdapter(new ImgAdapter(mContext, bean.getRetweeted_status().getPic_urls(), 1));
                    break;
                case 4:
                    LinearLayout.LayoutParams imgLayout = (LinearLayout.LayoutParams) rvSource.getLayoutParams();
                    imgLayout.width = ScreenUtils.getScreenWidth() / 3 * 2;
                    rvSource.setLayoutManager(new GridLayoutManager(mContext, 2));
                    rvSource.setAdapter(new ImgAdapter(mContext, bean.getRetweeted_status().getPic_urls(), 3));
                    break;
                default:
                    rvSource.setLayoutManager(new GridLayoutManager(mContext, 3));
                    rvSource.setAdapter(new ImgAdapter(mContext, bean.getRetweeted_status().getPic_urls(), 3));
                    break;
            }
        } else {
            holder.getView(R.id.layout_item_source).setVisibility(View.GONE);
        }

    }

}
