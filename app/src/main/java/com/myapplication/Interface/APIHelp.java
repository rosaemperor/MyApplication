package com.myapplication.Interface;

import com.myapplication.bean.LoginBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/8/24.
 */

public interface APIHelp {
     String terminal="ANDROID";
    @FormUrlEncoded
    @POST("api/v1/auth?terminal="+terminal)
    Call<LoginBean> getLoginString(@Field("username") String username, @Field("password") String s1);
    @FormUrlEncoded
    @POST("api/v1/auth?terminal="+terminal)
    Call<LoginBean> getLoginString(@FieldMap HashMap<String,String> Map);
    @POST("api/v1/users")
    Call<LoginBean> reginst(@Body String username,@Body String password,
                            @Body String referral,@Body String terminal,
                            @Body String url_from,
                            @Body String phone,@Body String code);


}
