package com.example.laba_4.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.laba_4.R;
import com.example.laba_4.model.Photo;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    private final Context context;
    private final List<Photo> photos;

    public PhotoAdapter(Context context, List<Photo> photos) {
        this.context = context;
        this.photos = photos;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View photoItems = LayoutInflater.from(context).inflate(R.layout.photo_item, parent, false);
        return new PhotoViewHolder(photoItems);
    }

    @Override
    public int getItemCount() {
        return photos.size() / 2;
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        String imageUrl = photos.get(position * PhotoViewHolder.i).getLargeImageURL();
        try {
            Glide.with(context)
                    .load(imageUrl)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            // Повторить загрузку изображения, если она не удалась
                            new Handler(context.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    Glide.with(context)
                                            .load(imageUrl)
                                            .into(holder.imageViewLarge_1);
                                }
                            });
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .into(holder.imageViewLarge_1);
        } catch (IndexOutOfBoundsException e) {
            Log.d("IndexOutOfBounds", e.getMessage());
        }

        try {
            String imageUrl2 = photos.get(position * PhotoViewHolder.i + 1).getLargeImageURL();
            Glide.with(context)
                    .load(imageUrl2)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            // Повторить загрузку изображения, если она не удалась
                            new Handler(context.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    Glide.with(context)
                                            .load(imageUrl2)
                                            .into(holder.imageViewLarge_2);
                                }
                            });
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .into(holder.imageViewLarge_2);
        } catch (IndexOutOfBoundsException e) {
            Log.d("IndexOutOfBounds", e.getMessage());
        }
    }

    public static final class PhotoViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageViewLarge_1;
        private final ImageView imageViewLarge_2;
        private static final int i = 2;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewLarge_1 = itemView.findViewById(R.id.imageViewLarge_1);
            imageViewLarge_2 = itemView.findViewById(R.id.imageViewLarge_2);
        }
    }
}
