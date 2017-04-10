package sunxl8.my_weibo.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import sunxl8.my_weibo.R;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class GroupPopWindow extends PopupWindow {

    public GroupPopWindow(Context context) {
        super(context);
        View mView = LayoutInflater.from(context).inflate(R.layout.view_popwindow_group, null);
        setContentView(mView);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        setFocusable(true);
    }
}
