package com.eslamwaheed.www.hardtaskegtask.apimodels.retrofit;

import com.eslamwaheed.www.hardtaskegtask.pojos.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CategoriesApiInterface {

    @GET("GetCategories")
    Call<List<Category>> GetCategories(@Query("categoryId") int categoryId, @Query("countryId") int countryId);
}
