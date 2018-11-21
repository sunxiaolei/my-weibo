package sun.xiaolei.m_base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import sunxl8.myutils.TimeUtils;

/**
 * Created by sunxl8 on 2017/4/17.
 */

public class WeiboTimeUtils {

    public static String convertTime(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
        Date date = TimeUtils.string2Date(time, sdf);
        return getFriendlyTimeSpanByNow(date.getTime());
    }

    public static String getFriendlyTimeSpanByNow(long millis) {
        long now = System.currentTimeMillis();
        long span = now - millis;
        if (span < 0L) {
            return String.format("%tc", new Object[]{Long.valueOf(millis)});
        } else if (span < 1000L) {
            return "刚刚";
        } else if (span < 60000L) {
            return String.format("%d秒前", new Object[]{Long.valueOf(span / 1000L)});
        } else if (span < 3600000L) {
            return String.format("%d分钟前", new Object[]{Long.valueOf(span / 60000L)});
        } else if (span < 86400000L) {
            return String.format("%d小时前", new Object[]{Long.valueOf(span / 3600000L)});
        } else {
            return String.format("%d天前", new Object[]{Long.valueOf(span / 86400000L)});

        }
    }
}
