package com.eslamwaheed.www.hardtaskegtask.application;


import com.eslamwaheed.www.hardtaskegtask.apimodels.modelinterfaces.CategoriesInt;
import com.eslamwaheed.www.hardtaskegtask.apimodels.modelsimplementations.CategoriesImpl;
import com.eslamwaheed.www.hardtaskegtask.mainscreen.MainMVP;
import com.eslamwaheed.www.hardtaskegtask.mainscreen.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    public MainMVP.Presenter provideMainPresenter(CategoriesInt categoriesInt) {
        return new MainPresenter(categoriesInt);
    }

    @Provides
    public CategoriesInt provideCategoriesInt() {
        return new CategoriesImpl();
    }
}
