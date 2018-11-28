package sunxl8.my_weibo;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import sunxl8.myutils.Utils;

/**
 * Created by sunxl8 on 2016/12/21.
 */

public class BaseApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Utils.init(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    public static Context getContext() {
        return mContext;
    }

}
