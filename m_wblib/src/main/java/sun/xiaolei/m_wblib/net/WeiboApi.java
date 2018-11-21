package sun.xiaolei.m_wblib.net;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import sun.xiaolei.m_wblib.entity.Token;
import sun.xiaolei.m_wblib.entity.Friends;
import sun.xiaolei.m_wblib.entity.HomeTimeline;
import sun.xiaolei.m_wblib.entity.TokenInfo;
import sun.xiaolei.m_wblib.entity.UserInfo;

/**
 * Created by sunxl8 on 2017/4/13.
 */

public interface WeiboApi {

    /**
     * 获取token
     *
     * @return
     */
    @POST("access_token")
    Flowable<Token> getToken(@QueryMap Map<String, String> params);

    /**
     * 获取token信息
     *
     * @return
     */
    @POST("get_token_info")
    Flowable<TokenInfo> getTokenInfo();

    /**
     * 获取用户信息
     *
     * @param params
     * @return
     */
    @GET("users/show.json")
    Flowable<UserInfo> show(@QueryMap Map<String, String> params);

    /**
     * 获取当前登录用户及其所关注用户的最新微博
     *
     * @param params
     * @return
     */
    @GET("statuses/home_timeline.json")
    Flowable<HomeTimeline> getHomeTimeline(@QueryMap Map<String, String> params);


    /**
     * 获取用户的关注列表
     *
     * @param params
     * @return
     */
    @GET("friendships/friends.json")
    Flowable<Friends> getFriends(@QueryMap Map<String, String> params);
}
