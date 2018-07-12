package com.eslamwaheed.www.hardtaskegtask.mainscreen;

import android.support.annotation.Nullable;


import com.eslamwaheed.www.hardtaskegtask.apimodels.modelinterfaces.CategoriesInt;
import com.eslamwaheed.www.hardtaskegtask.pojos.Category;
import com.eslamwaheed.www.hardtaskegtask.utils.CustomEvent;
import com.eslamwaheed.www.hardtaskegtask.utils.CustomEventType;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;


public class MainPresenter implements MainMVP.Presenter {

    @Nullable
    private MainMVP.View view;
    private CategoriesInt categoriesInt;

    public MainPresenter(CategoriesInt categoriesInt) {
        this.categoriesInt = categoriesInt;
        EventBus.getDefault().register(this);
    }

    @Override
    public void setView(MainMVP.View view) {
        this.view = view;
    }

    @Override
    public void goToDetailActivity() {

    }

    @Override
    public void loadCategories(int categoryId, int countryId) {
        categoriesInt.GetCategories(categoryId, countryId);
    }


    @Override
    public void register() {
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    @Override
    public void terminate() {
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void MoviesListOnLoad(CustomEvent event) {
        if (event.getEventType() == CustomEventType.GETCATEGORIES)
            view.setResultList((List<Category>) event.getObject());
    }
}
