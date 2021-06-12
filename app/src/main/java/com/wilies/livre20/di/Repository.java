package com.wilies.livre20.di;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.wilies.livre20.WebService;
import com.wilies.livre20.models.VolumeResponse;;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Repository {
    private static final String BOOK_SEARCH_BASE_URL = "https://www.googleapis.com/";
    private static final String KEY = "GOOGLE_API_KEY";
    private String searchTerm;

    private WebService webService;
    private MutableLiveData<VolumeResponse> mVolumeResponseMutableLiveData;

    public Repository(){
        mVolumeResponseMutableLiveData = new MutableLiveData<>();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
         OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

         webService = new Retrofit.Builder()
                 .baseUrl(BOOK_SEARCH_BASE_URL)
                 .client(client)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build()
         .create(WebService.class);
    }

    public void searchBooks(String query, String author){
        if(searchTerm.equals(query)){
            fetchFromDatabase();
        } else {
            searchTerm = query;
            fetchFromServer(query, author);
        }
    }

    private void fetchFromServer(String query, String author) {
        webService.searchResponse(query, author, KEY)
                .enqueue(new Callback<VolumeResponse>() {

                    @Override
                    public void onResponse(Call<VolumeResponse> call, Response<VolumeResponse> response) {
                        if(response.body() != null){
                            mVolumeResponseMutableLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<VolumeResponse> call, Throwable t) {
                        mVolumeResponseMutableLiveData.postValue(null);
                    }
                });

    }

    private void fetchFromDatabase() {
    }

    public LiveData<VolumeResponse> getSearchResponse(){
        return mVolumeResponseMutableLiveData;
    }
    
}

