package sunxl8.my_weibo.ui.base;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import sunxl8.myutils.Utils;

/**
 * Created by sunxl8 on 2016/12/21.
 */

public class BaseApplication extends Application {

    private static Context mContext;

    public static String account;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Utils.init(this);
        Logger.init("my-weibo")
                .methodCount(3)
                .hideThreadInfo()
                .logLevel(LogLevel.FULL)
                .methodOffset(2);
    }

    public static Context getContext() {
        return mContext;
    }

}
