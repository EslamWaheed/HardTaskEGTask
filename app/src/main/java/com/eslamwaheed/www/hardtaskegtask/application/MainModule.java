package com.eslamwaheed.www.hardtaskegtask.application;


import com.eslamwaheed.www.hardtaskegtask.apimodels.modelinterfaces.CategoriesInt;
import com.eslamwaheed.www.hardtaskegtask.apimodels.modelsimplementations.CategoriesImpl;
import com.eslamwaheed.www.hardtaskegtask.mainscreen.MainMVP;
import com.eslamwaheed.www.hardtaskegtask.mainscreen.MainPresenter;
import com.eslamwaheed.www.hardtaskegtask.mainscreen.detailscreen.DetailMVP;
import com.eslamwaheed.www.hardtaskegtask.mainscreen.detailscreen.DetailPresenter;

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

    @Provides
    public DetailMVP.Presenter provideDetailPresenter() {
        return new DetailPresenter();
    }
}
