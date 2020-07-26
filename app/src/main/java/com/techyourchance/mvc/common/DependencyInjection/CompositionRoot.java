package com.techyourchance.mvc.common.DependencyInjection;

import com.techyourchance.mvc.common.Constants;
import com.techyourchance.mvc.networking.StackoverflowApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompositionRoot {
    private Retrofit retrofit;

    private Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public StackoverflowApi getStackoverflowApi() {
        return getRetrofit().create(StackoverflowApi.class);
    }
}
