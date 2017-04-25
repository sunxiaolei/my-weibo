package sunxl8.my_weibo.ui.weibo;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jakewharton.rxbinding.view.RxView;
import com.trello.rxlifecycle.android.FragmentEvent;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.entity.StatusesBean;
import sunxl8.my_weibo.ui.base.BaseFragment;
import sunxl8.my_weibo.utils.WeiboTextUtils;
import sunxl8.my_weibo.utils.WeiboTimeUtils;
import sunxl8.myutils.ScreenUtils;
import sunxl8.myutils.StringUtils;

/**
 * Created by sunxl8 on 2017/4/17.
 */

public class WeiboAdapter extends RecyclerView.Adapter<WeiboAdapter.ViewHolder> {

    private BaseFragment mFragment;
    private List<StatusesBean> mBeanList;

    public WeiboAdapter(BaseFragment fragment) {
        mFragment = fragment;
    }

    public void setData(List<StatusesBean> list) {
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
        final StatusesBean bean = mBeanList.get(position);
        Glide.with(mFragment).load(bean.getUser().getAvatar_hd()).into(holder.ivIcon);
        holder.tvName.setText(bean.getUser().getName());
        holder.tvName.setTextColor(bean.getUser().isVerified()
                ? mFragment.getResources().getColor(R.color.colorTextVip) : mFragment.getResources().getColor(R.color.colorTextItemPrimary));
        String from = Html.fromHtml(bean.getSource()).toString();
        holder.tvFrom.setText(WeiboTimeUtils.convertTime(bean.getCreated_at()) + "   " +
                (StringUtils.isEmpty(from) ? "" : mFragment.getString(R.string.from) + "  " + from));
        holder.tvContent.setText(WeiboTextUtils.getWeiBoContent(bean.getText()));
        switch (bean.getPic_urls().size()) {
            case 1:
                holder.rvImg.setLayoutManager(new GridLayoutManager(mFragment.getContext(), 1));
                holder.rvImg.setAdapter(new ImgAdapter(mFragment.getContext(), bean.getPic_urls(), 1));
                break;
            case 4:
                LinearLayout.LayoutParams imgLayout = (LinearLayout.LayoutParams) holder.rvImg.getLayoutParams();
                imgLayout.width = ScreenUtils.getScreenWidth() / 3 * 2;
                holder.rvImg.setLayoutManager(new GridLayoutManager(mFragment.getContext(), 2));
                holder.rvImg.setAdapter(new ImgAdapter(mFragment.getContext(), bean.getPic_urls(), 3));
                break;
            default:
                holder.rvImg.setLayoutManager(new GridLayoutManager(mFragment.getContext(), 3));
                holder.rvImg.setAdapter(new ImgAdapter(mFragment.getContext(), bean.getPic_urls(), 3));
                break;
        }
        holder.tvRetweet.setText(String.valueOf(bean.getReposts_count()));
        holder.tvComment.setText(String.valueOf(bean.getComments_count()));
        holder.tvLike.setText(String.valueOf(bean.getAttitudes_count()));
        RxView.clicks(holder.layout)
                .compose(mFragment.bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(aVoid -> {
                    WeiboActivity.startWeiboActivity(mFragment.getActivity(), bean);
                });
    }

    @Override
    public int getItemCount() {
        return mBeanList == null ? 0 : mBeanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.layout_item_weibo)
        LinearLayout layout;
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
        @BindView(R.id.tv_item_retweet)
        TextView tvRetweet;
        @BindView(R.id.tv_item_comment)
        TextView tvComment;
        @BindView(R.id.tv_item_like)
        TextView tvLike;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
