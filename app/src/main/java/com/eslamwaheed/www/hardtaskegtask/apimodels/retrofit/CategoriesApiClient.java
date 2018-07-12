package com.eslamwaheed.www.hardtaskegtask.apimodels.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoriesApiClient {

    private static String Base_URL = "http://souq.hardtask.co/app/app.asmx/";

    private static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder().addInterceptor(interceptor);

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build());

    private static Retrofit retrofit = builder.build();

    public static <S> S buildeService(Class<S> serviceType) {
        return retrofit.create(serviceType);
    }
}
