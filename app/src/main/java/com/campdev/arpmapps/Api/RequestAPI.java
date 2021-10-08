package com.campdev.arpmapps.Api;

import com.campdev.arpmapps.Model.JSONResponse;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

public interface RequestAPI {

    @GET("view.php")
    Call<JSONResponse> view();

    @FormUrlEncoded
    @POST("search.php")
    Call<JSONResponse> search(@Field( "search" )String search);

    @GET("update.php")
    Call<JSONResponse> update();

    @GET("update_daihatsu.php")
    Call<JSONResponse> update_daihatsu();

    @GET("update_honda.php")
    Call<JSONResponse> update_honda();

    @GET("update_toyota.php")
    Call<JSONResponse> update_toyota();

    @GET("view_daihatsu.php")
    Call<JSONResponse> view_daihatsu();

    @GET("view_toyota.php")
    Call<JSONResponse> view_toyota();

    @GET("view_honda.php")
    Call<JSONResponse> view_honda();

    @FormUrlEncoded
    @POST("search_daihatsu.php")
    Call<JSONResponse> search_daihatsu(@Field( "search" )String search);

    @FormUrlEncoded
    @POST("search_honda.php")
    Call<JSONResponse> search_honda(@Field( "search" )String search);

    @FormUrlEncoded
    @POST("search_toyota.php")
    Call<JSONResponse> search_toyota(@Field( "search" )String search);
}
