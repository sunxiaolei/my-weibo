package sunxl8.my_weibo.ui.weibo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sun.xiaolei.m_wblib.entity.PicUrl;
import sunxl8.my_weibo.R;

/**
 * Created by sunxl8 on 2017/4/17.
 */

public class ImgAdapter extends RecyclerView.Adapter<ImgAdapter.ViewHolder> {

    private Context mContext;
    private List<PicUrl> mImgList;
    private int mType;

    public ImgAdapter(Context context, List<PicUrl> imgList, int type) {
        mContext = context;
        mImgList = imgList;
        mType = type;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_img, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PicUrl img = mImgList.get(position);
        img.setPic();
        holder.ivImg1.setVisibility(View.GONE);
        holder.ivImg3.setVisibility(View.GONE);
        RequestOptions options = new RequestOptions().centerCrop();
        switch (mType) {
            case 1:
                holder.ivImg1.setVisibility(View.VISIBLE);
                Glide.with(mContext).load(img.getBmiddle_pic()).apply(options).into(holder.ivImg1);
                break;
            case 3:
                holder.ivImg3.setVisibility(View.VISIBLE);
                Glide.with(mContext).load(img.getBmiddle_pic()).apply(options).into(holder.ivImg3);
                break;
        }
        RxView.clicks(holder.ivImg1)
                .subscribe(aVoid -> {
                    ImgActivity.startImgActivity(mContext, mImgList, position);
                });
        RxView.clicks(holder.ivImg3)
                .subscribe(aVoid -> {
                    ImgActivity.startImgActivity(mContext, mImgList, position);
                });
    }

    @Override
    public int getItemCount() {
        return mImgList == null ? 0 : mImgList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_item_img1)
        ImageView ivImg1;
        @BindView(R.id.iv_item_img3)
        ImageView ivImg3;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
