package sunxl8.my_weibo.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Date;

import sunxl8.my_weibo.R;
import sunxl8.myutils.TimeUtils;

/**
 * Created by sunxl8 on 2017/4/11.
 */

public class AddView extends RelativeLayout implements View.OnClickListener {

    private Context mContext;
    private RelativeLayout layoutRoot;
    private LinearLayout layoutCompose;
    private ImageView ivClose;
    private TextView tvDay, tvDate, tvWeek;

    private Animation animViewIn, animViewCloseIn, animViewComposeIn;
    private Animation animViewOut, animViewCloseOut, animViewComposeOut;
    private AnimatorSet mSet;

    public AddView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public AddView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(mContext).inflate(R.layout.view_add, this);
        layoutRoot = (RelativeLayout) findViewById(R.id.layout_view_add_root);
        layoutCompose = (LinearLayout) findViewById(R.id.layout_view_add_compose);
        ivClose = (ImageView) findViewById(R.id.iv_view_add_close);
        tvDay = (TextView) findViewById(R.id.tv_view_add_day);
        tvDate = (TextView) findViewById(R.id.tv_view_add_date);
        tvWeek = (TextView) findViewById(R.id.tv_view_add_week);

        Date now = TimeUtils.getNowTimeDate();
        tvDay.setText(now.getDay() + "");
        tvDate.setText(TimeUtils.date2String(now, "MM/yyyy"));
        tvWeek.setText(TimeUtils.getWeek(now));

        findViewById(R.id.tv_view_add_idea).setOnClickListener(this);
        findViewById(R.id.tv_view_add_capture).setOnClickListener(this);
        findViewById(R.id.tv_view_add_picture).setOnClickListener(this);
        findViewById(R.id.tv_view_add_live).setOnClickListener(this);
        ivClose.setOnClickListener(this);

        animViewIn = AnimationUtils.loadAnimation(mContext, R.anim.view_add_in);
        animViewCloseIn = AnimationUtils.loadAnimation(mContext, R.anim.view_add_close_in);
        animViewComposeIn = AnimationUtils.loadAnimation(mContext, R.anim.view_add_compose_in);
        animViewOut = AnimationUtils.loadAnimation(mContext, R.anim.view_add_out);
        animViewCloseOut = AnimationUtils.loadAnimation(mContext, R.anim.view_add_close_out);
        animViewComposeOut = AnimationUtils.loadAnimation(mContext, R.anim.view_add_compose_out);
    }

    public void show() {
        layoutRoot.setVisibility(View.VISIBLE);
        layoutRoot.startAnimation(animViewIn);
        ivClose.startAnimation(animViewCloseIn);
        layoutCompose.startAnimation(animViewComposeIn);
    }

    private void hide() {
        layoutRoot.setVisibility(View.GONE);
        layoutRoot.startAnimation(animViewOut);
        ivClose.startAnimation(animViewCloseOut);
        layoutCompose.startAnimation(animViewComposeOut);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_view_add_close:
                hide();
                break;
            case R.id.tv_view_add_idea:
                startClickAnim(v);
                break;
            case R.id.tv_view_add_capture:
                startClickAnim(v);
                break;
            case R.id.tv_view_add_picture:
                startClickAnim(v);
                break;
            case R.id.tv_view_add_live:
                startClickAnim(v);
                break;
        }
    }


    private void startClickAnim(View view) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.2f, 1.0f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.2f, 1.0f);
        mSet = new AnimatorSet();
        mSet.setDuration(200);
        mSet.playTogether(animatorX, animatorY);
        mSet.start();
    }
}
