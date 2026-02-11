package com.ro;



import com.ro.model.ResponseModel;
import com.ro.model.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService<UserModel>
{
    @POST("/api/auth/signup")
    Call<UserModel> signupApi(@Body UserModel usermodel);

    @POST("/api/auth/login")
    <ResponseModel>
    Call<ResponseModel> loginApi(@Body UserModel userModel);



}
