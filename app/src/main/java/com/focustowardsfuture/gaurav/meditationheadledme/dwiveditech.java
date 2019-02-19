package com.focustowardsfuture.gaurav.meditationheadledme;

import com.google.firebase.database.core.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by Gaurav Dwivedi on 18-02-2019.
 */
public interface dwiveditech {
    String BASE_URL ="https://dwiveditech.000webhostapp.com/";

    @Headers("Content-Type:application/json")
    @GET("json_get_data.php")
    Call<Content> getData();
}
