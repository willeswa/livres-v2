package com.wilies.livre20.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.wilies.livre20.di.Repository;
import com.wilies.livre20.models.VolumeResponse;

public class BookViewModel extends AndroidViewModel {
    private LiveData<VolumeResponse> mVolumeResponseLiveData;
    private Repository mRepository;

    public BookViewModel(@NonNull Application application) {
        super(application);
    }

    public void  init(){
        mRepository = new Repository();
        mVolumeResponseLiveData = mRepository.getSearchResponse();
    }

    public void searchBooks(String query, String author){
        mRepository.searchBooks(query, author);
    }

    public LiveData<VolumeResponse> getVolumeResponse(){
        return mVolumeResponseLiveData;
    }
}
