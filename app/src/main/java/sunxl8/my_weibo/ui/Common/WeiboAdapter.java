package sunxl8.my_weibo.ui.Common;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.entity.HomeTimeline;
import sunxl8.my_weibo.ui.base.BaseFragment;
import sunxl8.my_weibo.utils.WeiboTimeUtils;
import sunxl8.myutils.StringUtils;

/**
 * Created by sunxl8 on 2017/4/17.
 */

public class WeiboAdapter extends RecyclerView.Adapter<WeiboAdapter.ViewHolder> {

    private BaseFragment mFragment;
    private List<HomeTimeline.StatusesBean> mBeanList;

    public WeiboAdapter(BaseFragment fragment) {
        mFragment = fragment;
    }

    public void setData(List<HomeTimeline.StatusesBean> list) {
        if (mBeanList != null) {
            mBeanList.addAll(list);
        } else {
            mBeanList = list;
        }
        notifyDataSetChanged();
    }

    public void clean() {
        if (mBeanList != null) {
            mBeanList.clear();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(mFragment.getContext()).inflate(R.layout.item_weibo, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final HomeTimeline.StatusesBean bean = mBeanList.get(position);
        Glide.with(mFragment).load(bean.getUser().getProfile_image_url()).into(holder.ivIcon);
        holder.tvName.setText(bean.getUser().getName());
        String from = Html.fromHtml(bean.getSource()).toString();
        holder.tvFrom.setText(WeiboTimeUtils.convertTime(bean.getCreated_at()) + "   " +
                (StringUtils.isEmpty(from) ? "" : mFragment.getString(R.string.from) + "  " + from));
        holder.tvContent.setText(bean.getText());
        holder.rvImg.addItemDecoration(new GridItemDecoration(15));
        holder.rvImg.setLayoutManager(new GridLayoutManager(mFragment.getContext(), 3));
        holder.rvImg.setAdapter(new ImgAdapter(mFragment.getContext(), bean.getPic_urls()));
    }

    @Override
    public int getItemCount() {
        return mBeanList == null ? 0 : mBeanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_item_user_icon)
        CircleImageView ivIcon;
        @BindView(R.id.tv_item_name)
        TextView tvName;
        @BindView(R.id.tv_item_from)
        TextView tvFrom;
        @BindView(R.id.tv_item_content)
        TextView tvContent;
        @BindView(R.id.rv_item_img)
        RecyclerView rvImg;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
