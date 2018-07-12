package com.eslamwaheed.www.hardtaskegtask.apimodels.modelsimplementations;

import com.eslamwaheed.www.hardtaskegtask.apimodels.modelinterfaces.CategoriesInt;
import com.eslamwaheed.www.hardtaskegtask.apimodels.retrofit.CategoriesApiClient;
import com.eslamwaheed.www.hardtaskegtask.apimodels.retrofit.CategoriesApiInterface;
import com.eslamwaheed.www.hardtaskegtask.mainscreen.retrofitcallback.GetCategoriesCallback;

public class CategoriesImpl implements CategoriesInt {

    @Override
    public void GetCategories(int categoryId, int countryId) {
        CategoriesApiInterface categoriesApiInterface = CategoriesApiClient.buildeService(CategoriesApiInterface.class);
        categoriesApiInterface.GetCategories(categoryId, countryId).enqueue(new GetCategoriesCallback());
    }
}
