package sunxl8.my_weibo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import sunxl8.my_weibo.R;

/**
 * Created by sunxl8 on 2017/4/14.
 */

public class ProfileItemView extends RelativeLayout {

    private String title = "";
    private String subhead = "";
    private int iconResource = 0;

    private TextView tvTitle, tvSubhead;
    private ImageView ivIcon, ivDot;

    public ProfileItemView(Context context) {
        super(context);
        init();
    }

    public ProfileItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.ProfileItemView);
        title = ta.getString(R.styleable.ProfileItemView_title);
        subhead = ta.getString(R.styleable.ProfileItemView_subhead);
        iconResource = ta.getResourceId(R.styleable.ProfileItemView_icon, 0);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_profile_item, this);
        tvTitle = (TextView) findViewById(R.id.tv_view_profile_item_title);
        tvSubhead = (TextView) findViewById(R.id.tv_view_profile_item_subhead);
        ivIcon = (ImageView) findViewById(R.id.iv_view_profile_item_icon);
        ivDot = (ImageView) findViewById(R.id.iv_view_profile_item_arrow);
        tvTitle.setText(title);
        tvSubhead.setText(subhead);
        ivIcon.setImageResource(iconResource);
    }


}
