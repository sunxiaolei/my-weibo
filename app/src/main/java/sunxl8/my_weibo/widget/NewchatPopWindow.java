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

public class NewchatPopWindow extends PopupWindow {

    public NewchatPopWindow(Context context) {
        super(context);
        View mView = LayoutInflater.from(context).inflate(R.layout.view_popwindow_newchat, null);
        setContentView(mView);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        setFocusable(true);
    }
}
