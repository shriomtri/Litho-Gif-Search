package com.example.lithogif.models.api;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GifApi {

	String ENDPOINT = "https://api.giphy.com/v1/gifs/";
	String API_KEY = "GQCr7gLiHr07kHdDHdtwTNWceaI9xVqc";

	@GET("search")
	Call<JsonObject> search(@Query("q") String query, @Query("api_key") String key);
}
