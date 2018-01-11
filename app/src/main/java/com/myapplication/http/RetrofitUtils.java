package com.myapplication.http;

import android.util.Log;
import com.myapplication.Interface.APIHelp;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/8/25.
 */

public class RetrofitUtils {
    private Retrofit retrofit;
    private APIHelp OkHelp;
    private OkHttpClient client;
    private HttpLoggingInterceptor loggingInterceptor;
    private static final RetrofitUtils utils = new RetrofitUtils();
    private RetrofitUtils(){
        init();
    }

    private void init() {
        loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client=new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                Log.d("AAA",""+response.body().string());
                ResponseBody responseBody= response.body();

                Request request = chain.request().newBuilder()
                        .addHeader("Content-Type", "text/html; charset=UTF-8")
                        .build();
                Log.d("AAA",""+request.url().toString());
                return chain.proceed(request);
            }
        })
                .retryOnConnectionFailure(true)
                .connectTimeout(3, TimeUnit.SECONDS)
                .build();

        retrofit=new Retrofit.Builder()
//                .baseUrl( "http://api.ih2ome.cn/")
                .baseUrl("http://10.0.6.47:9090/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        OkHelp=retrofit.create(APIHelp.class);

    }

    public static RetrofitUtils getInstance(){
        return utils;
    }
    public <T> T createService(final Class<T> service){
        return retrofit.create(service);
    }


    public APIHelp getHelp() {
        return OkHelp;
    }
}
