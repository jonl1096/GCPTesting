package com.example.jliu.gcp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String IMAGE_URL =
            "http://www.wordmstemplates.com/wp-content/uploads/2015/08/Coupon-Template-2154.jpg";

    private static final String PDF_URL =
            "http://www.cs.jhu.edu/~lixints/class/auto/HW1.pdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageLoader im = new ImageLoader();
        im.execute(IMAGE_URL);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get the uri from url string
                Uri docUri = Uri.parse(PDF_URL);

                //Build an intent to launch to print
                Intent printIntent = new Intent(MainActivity.this, PrintDialogActivity.class);
                printIntent.setDataAndType(docUri, "application/pdf");
                printIntent.putExtra("title", "Test Print");
                startActivity(printIntent);
            }
        });
    }

    private class ImageLoader extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Bitmap b) {
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            imageView.setImageBitmap(b);
        }

        @Override
        protected Bitmap doInBackground(String... params) {

            Bitmap b;
            try {
                InputStream in = (InputStream) new URL(params[0]).getContent();
                b = BitmapFactory.decodeStream(in);
            } catch (IOException e) {
                e.printStackTrace();
                b = null;
            }
            return b;
        }
    }
}
