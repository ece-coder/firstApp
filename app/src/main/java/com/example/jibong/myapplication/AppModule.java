package com.example.jibong.myapplication;


/**
 * Created by jibong on 01/12/2017.
 */


import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Singleton;

import dagger.*;
import dagger.Component;

@Module
public class AppModule {

    protected final AppCompatActivity mApplication;

    public AppModule(AppCompatActivity application){
        mApplication = application;
    }

    @Provides
    ApiManager provideApiInstance() { return ApiManager.Factory.create(mApplication);}




}


