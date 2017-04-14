package sunxl8.my_weibo.utils;

import sunxl8.my_weibo.Constant;
import sunxl8.myutils.SPUtils;

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
        return SPUtils.getInstance(Constant.SP_USER).getLong("id");
    }

    public void setUserId(long userId) {
        SPUtils.getInstance(Constant.SP_USER).put("id", userId);
    }

    public String getUserName() {
        return SPUtils.getInstance(Constant.SP_USER).getString("name");
    }

    public void setUserName(String userName) {
        SPUtils.getInstance(Constant.SP_USER).put("name", userName);
    }

    public String getUserIcon() {
        return SPUtils.getInstance(Constant.SP_USER).getString("icon");
    }

    public void setUserIcon(String userIcon) {
        SPUtils.getInstance(Constant.SP_USER).put("icon", userIcon);
    }
}
