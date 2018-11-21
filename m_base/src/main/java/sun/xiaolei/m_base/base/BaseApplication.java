package sun.xiaolei.m_base.base;

import android.app.Application;
import android.content.Context;

import sunxl8.myutils.Utils;

/**
 * Created by sunxl8 on 2016/12/21.
 */

public class BaseApplication extends Application {

    private static Context mContext;

    public static String account;

    public static String token;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Utils.init(this);
    }

    public static Context getContext() {
        return mContext;
    }

}
