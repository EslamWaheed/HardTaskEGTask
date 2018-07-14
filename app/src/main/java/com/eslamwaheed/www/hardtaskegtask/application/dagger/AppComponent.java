package com.eslamwaheed.www.hardtaskegtask.application.dagger;


import com.eslamwaheed.www.hardtaskegtask.application.MainModule;
import com.eslamwaheed.www.hardtaskegtask.mainscreen.MainActivity;
import com.eslamwaheed.www.hardtaskegtask.mainscreen.detailscreen.DetailFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, MainModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    void inject(DetailFragment detailFragment);
}
