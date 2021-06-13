package com.wilies.livre20.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wilies.livre20.R;
import com.wilies.livre20.models.Volume;
import com.wilies.livre20.models.VolumeImageLinks;
import com.wilies.livre20.models.VolumeInfo;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{
    private static final String TAG = BookAdapter.class.getSimpleName();
    private LayoutInflater mLayoutInflater;
    private List<Volume> bookVolumes = new ArrayList<>();




    public BookAdapter(Context context){
        mLayoutInflater = LayoutInflater.from(context);
        Log.i(TAG, "in constructor");
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.recycler_item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Volume bookVolume = bookVolumes.get(position);
        String link = bookVolume.getVolumeInfo().getImageLinks().getSmall();

        Log.i(TAG, ""+bookVolume.getVolumeInfo().getImageLinks().toString());

        holder.getTitleTextView().setText(bookVolume.getVolumeInfo().getTitle());
        Glide.with(holder.itemView).load(link).into(holder.getImageView());

    }

    @Override
    public int getItemCount() {
        Log.i(TAG, ""+bookVolumes.size());
        return bookVolumes.size();
    }

    public void setBookVolumes(List<Volume> bookVolumes) {
        this.bookVolumes = bookVolumes;
        notifyDataSetChanged();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{
        private TextView titleTextView;
        private ImageView imageView;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            imageView = itemView.findViewById(R.id.book_image_view);

        }

        public ImageView getImageView() {
            return imageView;
        }


        public TextView getTitleTextView() {
            return titleTextView;
        }


    }
}
