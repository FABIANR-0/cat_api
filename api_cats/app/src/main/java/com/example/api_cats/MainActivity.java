package com.example.api_cats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recycle;
    private CatAdapter lista;

    private static final String API_KEY = "bda53789-d59e-46cd-9bc4-2936630fde39";
    private static final String API_BASE_URL = "https://api.thecatapi.com/v1/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycle=findViewById(R.id.recyclerCat);
        lista= new CatAdapter(this);
        recycle.setAdapter(lista);
        recycle.setHasFixedSize(true);
        //GridLayoutManager layoutManager= new GridLayoutManager(this,1);
       // recycle.setLayoutManager(layoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CatApiService apiService = retrofit.create(CatApiService.class);
        Call<List<Cat>> call = apiService.getBreeds();
        call.enqueue(new Callback<List<Cat>>() {
            @Override
            public void onResponse(Call<List<Cat>> call, Response<List<Cat>> response) {
                if (response.isSuccessful()) {
                    List<Cat> cats = response.body();
                    /*for (CatBreed breed : cats) {
                        System.out.println(breed.getName());
                    }*/
                    //et1.setText(cats.get(0).getName());

                    lista.adicionarListaCats(cats);
                }
            }

            @Override
            public void onFailure(Call<List<Cat>> call, Throwable t) {

            }
        });
    }
}