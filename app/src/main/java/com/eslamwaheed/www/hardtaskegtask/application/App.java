package com.eslamwaheed.www.hardtaskegtask.application;

import android.app.Application;

import com.eslamwaheed.www.hardtaskegtask.application.dagger.AppComponent;
import com.eslamwaheed.www.hardtaskegtask.application.dagger.AppModule;
import com.eslamwaheed.www.hardtaskegtask.application.dagger.DaggerAppComponent;


public class App extends Application {
    private AppComponent component;

    public AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .mainModule(new MainModule())
                .build();

    }
}
