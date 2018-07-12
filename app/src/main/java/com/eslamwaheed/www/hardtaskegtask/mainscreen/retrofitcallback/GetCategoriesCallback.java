package com.eslamwaheed.www.hardtaskegtask.mainscreen.retrofitcallback;

import com.eslamwaheed.www.hardtaskegtask.pojos.Category;
import com.eslamwaheed.www.hardtaskegtask.utils.CustomEvent;
import com.eslamwaheed.www.hardtaskegtask.utils.CustomEventType;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GetCategoriesCallback implements retrofit2.Callback<java.util.List<com.eslamwaheed.www.hardtaskegtask.pojos.Category>> {
    @Override
    public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
        if (response.body() != null) {
            EventBus.getDefault().post(new CustomEvent(CustomEventType.GETCATEGORIES, response.body()));
        } else {
            System.out.println("GetCategoriesCallback Nulllllllllll");
        }
    }

    @Override
    public void onFailure(Call<List<Category>> call, Throwable t) {
        System.out.println("GetCategoriesCallback Eroooorrrrrrr/n");
        System.out.println("Error Message >>> " + t.getMessage());
    }
}
