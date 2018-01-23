package com.example.jibong.myapplication;


/**
 * Created by jibong on 01/12/2017.
 */

import dagger.Component;


@Component(modules = AppModule.class)
public interface AppComponent {

    void inject (MainActivity mainActivity);

   //DataManager dataManager();
}
