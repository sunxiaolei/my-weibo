package sunxl8.my_weibo.ui.weibo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jakewharton.rxbinding.view.RxView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.entity.PicUrl;

/**
 * Created by sunxl8 on 2017/4/17.
 */

public class ImgAdapter extends RecyclerView.Adapter<ImgAdapter.ViewHolder> {

    private Context mContext;
    private List<PicUrl> mImgList;

    public ImgAdapter(Context context, List<PicUrl> imgList) {
        mContext = context;
        mImgList = imgList;
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
        Glide.with(mContext).load(img.getBmiddle_pic()).centerCrop().into(holder.ivImg);
        RxView.clicks(holder.ivImg)
                .subscribe(aVoid -> {
                    ImgActivity.startImgActivity(mContext, mImgList);
                });
    }

    @Override
    public int getItemCount() {
        return mImgList == null ? 0 : mImgList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_item_img)
        ImageView ivImg;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
