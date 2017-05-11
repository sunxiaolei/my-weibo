package sunxl8.my_weibo.net;

import java.util.Map;

import rx.Observable;
import sunxl8.my_weibo.Constant;
import sunxl8.my_weibo.entity.Friends;
import sunxl8.my_weibo.entity.HomeTimeline;
import sunxl8.my_weibo.entity.Token;
import sunxl8.my_weibo.entity.TokenInfo;
import sunxl8.my_weibo.entity.UserInfo;

/**
 * Created by sunxl8 on 2017/4/13.
 */

public class WeiboRequest {

    public static Observable<Token> getToken(Map<String, String> params) {
        return NetworkManager.getCommonClient(Constant.API_SERVER_OAUTH, false)
                .create(WeiboApi.class)
                .getToken(params)
                .compose(SchedulersCompat.applyIoSchedulers());
    }

    public static Observable<TokenInfo> getTokenInfo() {
        return NetworkManager.getCommonClient(Constant.API_SERVER_OAUTH)
                .create(WeiboApi.class)
                .getTokenInfo()
                .compose(SchedulersCompat.applyIoSchedulers());
    }

    public static Observable<UserInfo> show(Map<String, String> params) {
        return NetworkManager.getCommonClient(Constant.API_SERVER)
                .create(WeiboApi.class)
                .show(params)
                .compose(SchedulersCompat.applyIoSchedulers());
    }

    public static Observable<HomeTimeline> getHomeTimeline(Map<String, String> params) {
        return NetworkManager.getCommonClient(Constant.API_SERVER)
                .create(WeiboApi.class)
                .getHomeTimeline(params)
                .compose(SchedulersCompat.applyIoSchedulers());
    }

    public static Observable<Friends> getFriends(Map<String, String> params) {
        return NetworkManager.getCommonClient(Constant.API_SERVER)
                .create(WeiboApi.class)
                .getFriends(params)
                .compose(SchedulersCompat.applyIoSchedulers());
    }
}
