package com.rusin.kupandatest;

import android.app.Application;
import android.content.Context;

import com.rusin.kupandatest.model.ManagerModel;


public class KuApp extends Application {

    private static ManagerModel managerModel;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        context = getApplicationContext();
        managerModel = ManagerModel.getInstance();
    }

    public static Context getContext() {
        return context;
    }

    public static ManagerModel getManagerModel() {
        return managerModel;
    }
}
