package com.myapplication.http;

import com.myapplication.Interface.APIHelp;

import okhttp3.OkHttpClient;
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
        client=new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
//        client.interceptors().add(loggingInterceptor);
        retrofit=new Retrofit.Builder()
                .baseUrl( "http://api.ih2ome.cn/")
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
