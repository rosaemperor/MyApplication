package com.myapplication.Interface;

import com.myapplication.bean.LoginBean;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/8/24.
 */

public interface APIHelp {
    @FormUrlEncoded
    @POST("api/v1/auth")
    Call<LoginBean> getLoginString(@Field("username") String username, @Field("password") String s1, @Field("terminal")
            String android);
    @POST("api/v1/users")
    Call<LoginBean> reginst(@Body String username,@Body String password,
                            @Body String referral,@Body String terminal,
                            @Body String url_from,
                            @Body String phone,@Body String code);


}
