package sunxl8.my_weibo.net;

import com.orhanobut.logger.Logger;
import com.sina.weibo.sdk.auth.sso.AccessTokenKeeper;

import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import sunxl8.my_weibo.Constant;
import sunxl8.my_weibo.ui.base.BaseApplication;

/**
 * Created by sunxl8 on 2016/12/21.
 */

public class NetworkManager {

    public static final int HTTP_CONNECT_TIMEOUT = 5000;
    public static final int HTTP_WRITE_TIMEOUT = 5000;
    public static final int HTTP_READ_TIMEOUT = 5000;

    private static Retrofit commonClient;
    private static Retrofit.Builder commonBuilder;

    public static Retrofit getCommonClient(String baseUrl) {
        return getCommonClient(baseUrl, null);
    }

    public static Retrofit getCommonClient(String baseUrl, Map<String, String> headers) {
        if (commonClient == null) {
            commonClient = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(getHttpClient(headers))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return commonClient;
    }

    private static OkHttpClient getHttpClient(final Map<String, String> headers) {

        Interceptor interceptor = chain -> {
            Request request = chain.request();
            Logger.d("Request==>" + request.toString());
            long t1 = System.nanoTime();
            if (headers != null) {
                request.newBuilder()
                        .headers(setHeaders(headers))
                        .build();
            }

            Response response = chain.proceed(chain.request());
            long t2 = System.nanoTime();
            Logger.d(String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers(), response.code()));
            okhttp3.MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            Logger.d("Response==>" + content);
            return response.newBuilder()
                    .body(okhttp3.ResponseBody.create(mediaType, content))
                    .build();
        };

        Interceptor addTokenInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();


                HttpUrl originalHttpUrl = original.url();

                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter(Constant.KEY_ACCESS_TOKEN, BaseApplication.token)
                        .build();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
//                        .header("Accept"," text/html; charset=UTF-8")
                        .url(url);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(HTTP_WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(HTTP_READ_TIMEOUT, TimeUnit.MILLISECONDS);

        builder.addInterceptor(interceptor)
                .addInterceptor(addTokenInterceptor);

        return builder.build();
    }

    private static Headers setHeaders(Map<String, String> headersParams) {
        Headers headers;
        Headers.Builder headersbuilder = new Headers.Builder();

        if (headersParams != null) {
            Iterator<String> iterator = headersParams.keySet().iterator();
            String key = "";
            while (iterator.hasNext()) {
                key = iterator.next().toString();
                headersbuilder.add(key, headersParams.get(key));
            }
        }
        headers = headersbuilder.build();
        return headers;
    }

}
