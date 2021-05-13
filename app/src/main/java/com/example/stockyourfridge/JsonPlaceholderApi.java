package com.example.stockyourfridge;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface JsonPlaceholderApi {

    @POST()
    Call<user> addUser(@Body user user);

}
