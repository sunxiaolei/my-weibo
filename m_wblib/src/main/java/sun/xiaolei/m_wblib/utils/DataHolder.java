package sun.xiaolei.m_wblib.utils;

import sunxl8.myutils.KvUtils;

/**
 * Created by sunxl8 on 2017/4/14.
 */

public class DataHolder {

    private static volatile DataHolder mHolder;

    public static DataHolder getInstanse() {
        if (mHolder == null) {
            synchronized (DataHolder.class) {
                if (mHolder == null) {
                    mHolder = new DataHolder();
                }
            }
        }
        return mHolder;
    }

    private long userId;
    private String userName;
    private String userIcon;

    public long getUserId() {
        return KvUtils.getLong("id", 0);
    }

    public void setUserId(long userId) {
        KvUtils.setLong("id", userId);
    }

    public String getUserName() {
        return KvUtils.getString("name", "");
    }

    public void setUserName(String userName) {
        KvUtils.setString("name", userName);
    }

    public String getUserIcon() {
        return KvUtils.getString("icon", "");
    }

    public void setUserIcon(String userIcon) {
        KvUtils.setString("icon", userIcon);
    }
}
