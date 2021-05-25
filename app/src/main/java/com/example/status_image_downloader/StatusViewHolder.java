package com.example.status_image_downloader;

import android.os.Environment;
import android.os.FileUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.File;

public class StatusViewHolder extends RecyclerView.ViewHolder {

    private ImageView mImageView;
    private ImageView mPlayImage;
    private ImageView mDownloadImage;

    public StatusViewHolder(@NonNull View itemView) {
        super(itemView);

        mImageView = itemView.findViewById(R.id.imageView);
        mPlayImage = itemView.findViewById(R.id.playImage);
        mDownloadImage = itemView.findViewById(R.id.downloadImage);
    }

    public void setData(StatusModel model) {

        if (model.getUri().toString().endsWith(".mp4")){
            mPlayImage.setVisibility(View.VISIBLE);
        }
        else {
            mPlayImage.setVisibility(View.INVISIBLE);
        }
        Glide.with(mImageView)
                .load(model.getUri())
                .into(mImageView);

        mDownloadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkFolder();

                final String path = model.getPath();

                final File file = new File(path);

                String destinationPath = Environment.getExternalStorageDirectory().getAbsolutePath() + Constant.SAVE_FOLDER_NAME;

                File destinationFile  = new File(destinationPath);

            }
        });

    }

    private void checkFolder() {

        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + Constant.SAVE_FOLDER_NAME;
        File dir = new File(path);

        boolean isDirectoryCreated = dir.exists();

        if (!isDirectoryCreated){
            isDirectoryCreated = dir.mkdir();
        }
        if (isDirectoryCreated){
            Log.d("Folder","Already Created");
        }

    }
}
