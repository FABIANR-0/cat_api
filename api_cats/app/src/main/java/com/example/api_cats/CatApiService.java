package com.example.api_cats;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface CatApiService {
    @GET("breeds?api_key=bda53789-d59e-46cd-9bc4-2936630fde39")
    Call<List<Cat>> getBreeds();
}