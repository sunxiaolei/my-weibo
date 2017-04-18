package sunxl8.my_weibo.ui.common;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.jakewharton.rxbinding.support.v4.view.RxViewPager;
import com.trello.rxlifecycle.android.ActivityEvent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.entity.PicUrl;
import sunxl8.my_weibo.ui.base.BaseActivity;
import sunxl8.my_weibo.ui.base.IPresenter;

/**
 * Created by sunxl8 on 2017/4/18.
 */

public class ImgActivity extends BaseActivity {

    @BindView(R.id.vp_img)
    ViewPager mViewPager;
    @BindView(R.id.tv_img_page)
    TextView tvPage;
    @BindView(R.id.iv_img_more)
    ImageView ivMore;

    private List<PicUrl> mPicUrls;

    @Override
    protected IPresenter createPresenter() {
        return null;
    }

    @Override
    protected int setContentViewId() {
        return R.layout.activity_img;
    }


    @Override
    protected void initData() {
        mPicUrls = (List<PicUrl>) getIntent().getSerializableExtra("imgs");
    }

    @Override
    protected void initView() {
        RxViewPager.pageSelections(mViewPager)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(integer -> {
                    tvPage.setText(integer + 1 + "/" + mPicUrls.size());
                });
        mViewPager.setAdapter(new ImgPagAdapter(getImgViews(mPicUrls), mPicUrls));
    }

    private List<View> getImgViews(List<PicUrl> imgs) {
        LayoutInflater lf = getLayoutInflater().from(this);
        List<View> viewList = new ArrayList<>();
        for (PicUrl img : imgs) {
            View view = lf.inflate(R.layout.view_img, null);
            viewList.add(view);
        }
        return viewList;
    }

    @Override
    public void error(String msg) {

    }

    public static void startImgActivity(Context context, List<PicUrl> imgs) {
        Intent intent = new Intent(context, ImgActivity.class);
        intent.putExtra("imgs", (Serializable) imgs);
        context.startActivity(intent);
    }

    class ImgPagAdapter extends PagerAdapter {

        private List<View> mListViews;
        private List<PicUrl> mPicUrls;

        public ImgPagAdapter(List<View> listViews, List<PicUrl> picUrls) {
            mListViews = listViews;
            mPicUrls = picUrls;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mListViews.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = mListViews.get(position);
            PhotoView photoView = (PhotoView) view.findViewById(R.id.iv_img);
            photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ProgressBar pb = (ProgressBar) view.findViewById(R.id.progress_img);
            DoubleBounce doubleBounce = new DoubleBounce();
            pb.setIndeterminateDrawable(doubleBounce);
            Glide.with(ImgActivity.this).load(mPicUrls.get(position).getOriginal_pic())
                    .into(new GlideDrawableImageViewTarget(photoView){
                        @Override
                        public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                            super.onResourceReady(resource, animation);
                            pb.setVisibility(View.GONE);
                        }

                        @Override
                        public void onStart() {
                            super.onStart();
                            pb.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onLoadFailed(Exception e, Drawable errorDrawable) {
                            super.onLoadFailed(e, errorDrawable);
                            pb.setVisibility(View.GONE);
                        }
                    });
            container.addView(view, 0);
            return view;
        }

        @Override
        public int getCount() {
            return mListViews.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }
    }
}
