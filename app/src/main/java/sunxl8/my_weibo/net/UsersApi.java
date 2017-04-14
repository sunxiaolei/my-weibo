package sunxl8.my_weibo.net;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by sunxl8 on 2017/4/13.
 */

public interface UsersApi {

    @GET("show.json")
    Observable<String> show(@QueryMap Map<String, String> params);
}