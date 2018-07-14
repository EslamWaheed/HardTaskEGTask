package com.eslamwaheed.www.hardtaskegtask.mainscreen.detailscreen;

import android.support.annotation.Nullable;

import org.greenrobot.eventbus.EventBus;

public class DetailPresenter implements DetailMVP.Presenter {

    @Nullable
    private DetailMVP.View view;

    public DetailPresenter() {
//        EventBus.getDefault().register(this);
    }

    @Override
    public void setView(DetailMVP.View view) {
        this.view = view;
    }

    @Override
    public void register() {
//        if (!EventBus.getDefault().isRegistered(this))
//            EventBus.getDefault().register(this);
    }

    @Override
    public void terminate() {
//        EventBus.getDefault().unregister(this);
    }
}
