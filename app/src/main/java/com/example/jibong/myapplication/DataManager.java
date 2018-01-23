package com.example.jibong.myapplication;


import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by jibong on 04/12/2017.
 */


public class DataManager {

    private ApiManager apiManager;

    @Inject
    public DataManager(ApiManager apiManager){
        this.apiManager = apiManager;
    }



    public Observable<Profile> getProfile(String profile) {
        return apiManager.getUserProfile();
    }

    public void doNothing(){

        Log.e("Trial", "do nothing");

    }

}
