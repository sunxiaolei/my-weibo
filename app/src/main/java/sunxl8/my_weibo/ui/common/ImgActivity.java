package sunxl8.my_weibo.ui.common;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

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
            Glide.with(ImgActivity.this).load(mPicUrls.get(position).getOriginal_pic()).into(photoView);
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
