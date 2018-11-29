package sun.xiaolei.m_wblib.net;

import java.util.Map;

import io.reactivex.Flowable;
import sun.xiaolei.m_base.net.SchedulersCompat;
import sun.xiaolei.m_wblib.Constant;
import sun.xiaolei.m_wblib.entity.Friends;
import sun.xiaolei.m_wblib.entity.HomeTimeline;
import sun.xiaolei.m_wblib.entity.Token;
import sun.xiaolei.m_wblib.entity.TokenInfo;
import sun.xiaolei.m_wblib.entity.UserInfo;

/**
 * Created by sunxl8 on 2017/4/13.
 */

public class WeiboRequest {

    public static Flowable<Token> getToken(Map<String, String> params) {
        return NetworkManager.getCommonClient(Constant.API_SERVER_OAUTH, false)
                .create(WeiboApi.class)
                .getToken(params)
                .compose(SchedulersCompat.scheduleTnansform());
    }

    public static Flowable<TokenInfo> getTokenInfo() {
        return NetworkManager.getCommonClient(Constant.API_SERVER_OAUTH)
                .create(WeiboApi.class)
                .getTokenInfo()
                .compose(SchedulersCompat.scheduleTnansform());
    }

    public static Flowable<UserInfo> show(Map<String, String> params) {
        return NetworkManager.getCommonClient(Constant.API_SERVER)
                .create(WeiboApi.class)
                .show(params)
                .compose(SchedulersCompat.scheduleTnansform());
    }

    public static Flowable<HomeTimeline> getHomeTimeline(Map<String, String> params) {
        return NetworkManager.getCommonClient(Constant.API_SERVER)
                .create(WeiboApi.class)
                .getHomeTimeline(params)
                .compose(SchedulersCompat.scheduleTnansform());
    }

    public static Flowable<Friends> getFriends(Map<String, String> params) {
        return NetworkManager.getCommonClient(Constant.API_SERVER)
                .create(WeiboApi.class)
                .getFriends(params)
                .compose(SchedulersCompat.scheduleTnansform());
    }
}
