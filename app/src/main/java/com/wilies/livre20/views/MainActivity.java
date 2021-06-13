package com.wilies.livre20.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.wilies.livre20.R;
import com.wilies.livre20.adapters.BookAdapter;
import com.wilies.livre20.models.VolumeResponse;
import com.wilies.livre20.viewmodel.BookViewModel;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private BookViewModel mBookViewModel;
    private BookAdapter mAdapter;
    private TextInputLayout titleInputLayout;
    private TextInputLayout authorInputLayout;
    private Button submitButton;
    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.main_recyclerview);
        titleInputLayout = findViewById(R.id.title_input_layout);
        authorInputLayout = findViewById(R.id.author_input_layout);
        submitButton = findViewById(R.id.submit);

        mAdapter = new BookAdapter(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);



        submitButton.setOnClickListener(view -> {
            String title = titleInputLayout.getEditText().getText().toString();
            String author = authorInputLayout.getEditText().getText().toString();




            mBookViewModel = new BookViewModel(getApplication());
            mBookViewModel.init();
            mBookViewModel.searchBooks(title, author);
            mBookViewModel.getVolumeResponse().observe(this, new Observer<VolumeResponse>() {
                @Override
                public void onChanged(VolumeResponse volumeResponse) {
                    if(volumeResponse != null){
                        Log.i(TAG, "main>>>>" + volumeResponse.getItems().size());
                        mAdapter.setBookVolumes(volumeResponse.getItems());
                    }
                }
            });

        });

    }
}