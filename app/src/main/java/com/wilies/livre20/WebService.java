package com.wilies.livre20;

import com.wilies.livre20.models.VolumeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {
    @GET("/books/v1/volumes")
    Call<VolumeResponse> searchResponse(
            @Query("q") String query,
            @Query("inauthor") String author,
            @Query("key") String apiKey
    );
}
