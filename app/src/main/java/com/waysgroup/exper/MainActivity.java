package com.waysgroup.exper;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.os.Environment.getExternalStoragePublicDirectory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt)
    TextView txt;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.imageView)
    ImageView imageView;


    Bitmap bitmapp = null;

    String photoUrl = "https://images.unsplash.com/photo-1566036653839-c66930877168?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjF9&auto=format&fit=crop&w=1000&q=100";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

                Glide.with(this)
                .asBitmap()
                .load(photoUrl)
                .override(Target.SIZE_ORIGINAL)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                        //you can use loaded bitmap here
                        bitmapp = bitmap;
                        imageView.setImageBitmap(bitmapp);
                    }
                });

//        Share share = new Share(this,photoUrl);
//        share.shareImage();
//
//        Share.ShareBuilder builder = new Share.ShareBuilder();
//        builder.withContext(this).withPhotoUrl(photoUrl).startSharing();


//        Glide.with(this)
//                .asBitmap()
//                .load(photoUrl)
//                .override(Target.SIZE_ORIGINAL)
//                .into(new SimpleTarget<Bitmap>() {
//                    @Override
//                    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
//                        //you can use loaded bitmap here
//                        bitmapp = bitmap;
//                        imageView.setImageBitmap(bitmapp);
//                        try {
//                            save(bitmap);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
//        shareImage(photoUrl, getApplicationContext());

//        Share.ShareBuilder builder = new Share.ShareBuilder();
//        builder.withContext(this).withPhotoUrl(photoUrl).startSharing();

        Share share = new Share(this,this,photoUrl,R.layout.loader_view,R.id.custom_loader,R.drawable.tenor);

    }
//
//    private void shareImage(String url, Context context) {
//
//        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
//        StrictMode.setVmPolicy(builder.build());
//
//        Intent i = new Intent(Intent.ACTION_SEND);
//        i.setType("image/*");
//
//        // save the image and get it's uri
//        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//        bitmapp.compress(Bitmap.CompressFormat.PNG, 100, bytes);
//        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmapp, "Title", null);
//        Uri uri = Uri.parse(path);
//
//
//        i.putExtra(Intent.EXTRA_STREAM, uri);
//        startActivity(Intent.createChooser(i, "Share Image"));
//        Toast.makeText(MainActivity.this, "done", Toast.LENGTH_SHORT).show();
//    }
//
//    private Uri getImageUri(Context context, Bitmap inImage) {
//        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//        inImage.compress(Bitmap.CompressFormat.PNG, 100, bytes);
//        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), inImage, "Title", null);
//        return Uri.parse(path);
//    }
//
//    String file_path;
//
//    private void save(Bitmap bmp) throws Exception {
//        file_path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/PhysicsSketchpad";
//        File dir = new File(file_path);
//        if (!dir.exists()) dir.mkdirs();
//        File file = new File(dir, "sketchpad" + ".png");
//        FileOutputStream fOut = new FileOutputStream(file);
//        bmp.compress(Bitmap.CompressFormat.PNG, 85, fOut);
//        fOut.flush();
//        fOut.close();
//    }
}
