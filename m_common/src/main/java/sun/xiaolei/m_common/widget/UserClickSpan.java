package sun.xiaolei.m_common.widget;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

import sun.xiaolei.m_common.RouteTable;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
public class UserClickSpan extends ClickableSpan {

    private String userName;

    public UserClickSpan(String userName) {
        this.userName = userName;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setColor(Color.parseColor("#507daf"));
        ds.setUnderlineText(false);
    }

    @Override
    public void onClick(View widget) {
        if (!TextUtils.isEmpty(userName)) {
            ARouter.getInstance()
                    .build(RouteTable.USER)
                    .withString("user", userName)
                    .navigation();
        }
    }

}
