package sunxl8.my_weibo.ui.weibo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.jakewharton.rxbinding2.support.v4.view.RxViewPager;
import com.jakewharton.rxbinding2.view.RxView;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import sun.xiaolei.m_wblib.entity.PicUrl;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.ui.base.BaseCommonActivity;
import sunxl8.my_weibo.ui.base.IPresenter;

/**
 * Created by sunxl8 on 2017/4/18.
 */

public class ImgActivity extends BaseCommonActivity {

    @BindView(R.id.vp_img)
    ViewPager mViewPager;
    @BindView(R.id.tv_img_page)
    TextView tvPage;
    @BindView(R.id.iv_img_more)
    ImageView ivMore;
    @BindView(R.id.bottomsheet_img)
    BottomSheetLayout bottomSheetLayout;

    private List<PicUrl> mPicUrls;
    private int mPosition;
    private ImgPagAdapter mAdapter;

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
        mPosition = getIntent().getIntExtra("mPosition", 0);
    }

    @Override
    protected void initView() {
        mAdapter = new ImgPagAdapter(getImgViews(mPicUrls), mPicUrls);
        RxViewPager.pageSelections(mViewPager)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(integer -> {
                    tvPage.setText(integer + 1 + "/" + mPicUrls.size());
                });
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(mPosition);
        RxView.clicks(ivMore)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(aVoid -> {
                    new ImgMenuFragment().show(getSupportFragmentManager(), R.id.bottomsheet_img);
                });
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

    public static void startImgActivity(Context context, List<PicUrl> imgs, int position) {
        Intent intent = new Intent(context, ImgActivity.class);
        intent.putExtra("imgs", (Serializable) imgs);
        intent.putExtra("mPosition", position);
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
            SubsamplingScaleImageView siv = (SubsamplingScaleImageView) view.findViewById(R.id.siv_img);
            siv.setMaxScale(5f);
            ProgressBar pb = (ProgressBar) view.findViewById(R.id.progress_img);
            DoubleBounce doubleBounce = new DoubleBounce();
            pb.setIndeterminateDrawable(doubleBounce);
            pb.setVisibility(View.VISIBLE);
            RequestBuilder<File> mRequestBuilder = Glide.with(ImgActivity.this)
                    .downloadOnly()
                    .load(mPicUrls.get(position).getOriginal_pic())
                    .listener(new RequestListener<File>() {


                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<File> target, boolean isFirstResource) {
                            pb.setVisibility(View.GONE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(File resource, Object model, Target<File> target, DataSource dataSource, boolean isFirstResource) {
                            pb.setVisibility(View.GONE);
                            siv.setImage(ImageSource.uri(resource.getAbsolutePath()), new ImageViewState(0, new PointF(0, 0), 0));
                            siv.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_INSIDE);
//                            if (isLong(resource)) {
//                                siv.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP);
//                            } else {
//                                siv.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_INSIDE);
//                            }
                            return false;
                        }
                    });
            mRequestBuilder.preload();
            RxView.clicks(siv)
                    .subscribe(aVoid -> {
                        ImgActivity.this.finish();
                    });
            container.addView(view, 0);
            return view;
        }

        private boolean isLong(Bitmap bitmap) {
            if (bitmap.getHeight() > bitmap.getWidth() * 3) {
                return true;
            }
            return false;
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
