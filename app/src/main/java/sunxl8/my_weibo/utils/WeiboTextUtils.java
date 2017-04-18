package sunxl8.my_weibo.utils;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            if (at != null) {
                int start = matcher.start(1);
                int end = start + at.length();
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#507daf")), start, end, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            }
        }
        return spannableStringBuilder;
    }
}
