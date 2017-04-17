package sunxl8.my_weibo.net;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;
import sunxl8.my_weibo.entity.HomeTimeline;
import sunxl8.my_weibo.entity.UserInfo;

/**
 * Created by sunxl8 on 2017/4/13.
 */

public interface WeiboApi {

    @GET("users/show.json")
    Observable<UserInfo> show(@QueryMap Map<String, String> params);

    @GET("statuses/home_timeline.json")
    Observable<HomeTimeline> getHomeTimeline(@QueryMap Map<String, String> params);
}