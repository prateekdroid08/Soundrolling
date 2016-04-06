package android.com.soundrolling.WebApi;

import android.com.soundrolling.R;
import android.content.Context;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class RestClient {

    private static WebApi REST_CLIENT;

    static Context ctx;

    public RestClient(Context ctx) {
        this.ctx = ctx;
        setupRestClient();
    }

    public static WebApi get() {
        if (REST_CLIENT != null) {
            return REST_CLIENT;
        } else {
            setupRestClient();
            return REST_CLIENT;
        }
    }

    private static void setupRestClient() {

        OkHttpClient ok = new OkHttpClient();
        ok.setReadTimeout(30, TimeUnit.SECONDS);
        ok.setWriteTimeout(30, TimeUnit.SECONDS);
        ok.setConnectTimeout(10, TimeUnit.SECONDS);
        ok.setRetryOnConnectionFailure(true);
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(ctx.getResources().getString(R.string.base_url_staging))
                .setClient(new OkClient(ok))
                .setErrorHandler(new CustomErrorHandler(ctx))
                .setLogLevel(RestAdapter.LogLevel.FULL);

        RestAdapter restAdapter = builder.build();

        REST_CLIENT = restAdapter.create(WebApi.class);
    }
}