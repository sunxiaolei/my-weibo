package sunxl8.my_weibo.net;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;
import sunxl8.my_weibo.entity.Friends;
import sunxl8.my_weibo.entity.HomeTimeline;
import sunxl8.my_weibo.entity.TokenInfo;
import sunxl8.my_weibo.entity.UserInfo;

/**
 * Created by sunxl8 on 2017/4/13.
 */

public interface WeiboApi {


    /**
     * 获取token信息
     *
     * @return
     */
    @POST("get_token_info")
    Observable<TokenInfo> getTokenInfo();

    /**
     * 获取用户信息
     *
     * @param params
     * @return
     */
    @GET("users/show.json")
    Observable<UserInfo> show(@QueryMap Map<String, String> params);

    /**
     * 获取当前登录用户及其所关注用户的最新微博
     *
     * @param params
     * @return
     */
    @GET("statuses/home_timeline.json")
    Observable<HomeTimeline> getHomeTimeline(@QueryMap Map<String, String> params);


    /**
     * 获取用户的关注列表
     *
     * @param params
     * @return
     */
    @GET("friendships/friends.json")
    Observable<Friends> getFriends(@QueryMap Map<String, String> params);
}
