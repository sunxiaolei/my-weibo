package sun.xiaolei.m_base.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.xiaolei.m_base.base.BaseApplication;
import sunxl8.myutils.SizeUtils;
import sunxl8.myutils.StringUtils;

/**
 * Created by sunxl8 on 2017/4/18.
 */

public class WeiboTextUtils {

    private static final String AT = "@[\\w\\p{InCJKUnifiedIdeographs}-]{1,26}";// @人
    private static final String TOPIC = "#[\\p{Print}\\p{InCJKUnifiedIdeographs}&&[^#]]+#";// ##话题
    private static final String URL = "http://[a-zA-Z0-9+&@#/%?=~_\\-|!:,\\.;]*[a-zA-Z0-9+&@#/%=~_|]";// url
    private static final String EMOJI = "\\[(\\S+?)\\]";//emoji 表情

    private static final String ALL = "(" + AT + ")" + "|" + "(" + TOPIC + ")" + "|" + "(" + URL + ")" + "|" + "(" + EMOJI + ")";

    public static SpannableStringBuilder getWeiBoContent(String content) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(content);
        Pattern pattern = Pattern.compile(ALL);
        Matcher matcher = pattern.matcher(spannableStringBuilder);
        while (matcher.find()) {
            final String at = matcher.group(1);
            final String topic = matcher.group(2);
            final String url = matcher.group(3);
            final String emoji = matcher.group(4);
            if (at != null) {
                int start = matcher.start(1);
                int end = start + at.length();
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#507daf")), start, end, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            }
            if (emoji != null) {
                int start = matcher.start(4);
                int end = start + emoji.length();
                String imgName = Emoticons.getImgName(emoji);
                if (!StringUtils.isEmpty(imgName)) {
                    int resId = BaseApplication.getContext().getResources().getIdentifier(imgName, "drawable", BaseApplication.getContext().getPackageName());
                    if (resId != 0) {
                        Drawable emojiDrawable = BaseApplication.getContext().getResources().getDrawable(resId);
                        if (emojiDrawable != null) {
                            emojiDrawable.setBounds(0, 0, SizeUtils.sp2px(17), SizeUtils.sp2px(17));
                            ImageSpan imageSpan = new ImageSpan(emojiDrawable, ImageSpan.ALIGN_BOTTOM) {
                                public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
                                    Drawable b = getDrawable();
                                    canvas.save();
                                    int transY = bottom - b.getBounds().bottom;
                                    transY -= paint.getFontMetricsInt().descent / 2;
                                    canvas.translate(x, transY);
                                    b.draw(canvas);
                                    canvas.restore();
                                }
                            };
                            spannableStringBuilder.setSpan(imageSpan, start, end, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        }
                    }
                }
            }
        }
        return spannableStringBuilder;
    }
}
