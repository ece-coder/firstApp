package com.example.jibong.myapplication;


import android.content.Context;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by jibong on 04/12/2017.
 */

public interface ApiManager {

    //@GET("/profiles/{profileId}")
    //Observable<Profile> getUserProfile(@Path("profileId") String profileId
    String BASE_URL = "http://private-d3430-profiletest.apiary-mock.com/";

    @GET("/profiles")
    Observable<Profile> getUserProfile();

    class Factory{

        public static ApiManager create (Context context){

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

          return retrofit.create(ApiManager.class);
        }

    }




}
