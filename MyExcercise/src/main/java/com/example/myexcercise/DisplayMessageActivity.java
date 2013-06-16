package com.example.myexcercise;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Magnus on 2013-06-11.
 */



public class DisplayMessageActivity extends Activity {
    @SuppressLint("NewApi")
    TextView textView;
    ImageView imageView;
    Drawable photo;
    int clicks;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Resources res = getResources();
        photo = res.getDrawable(R.drawable.imgp7690);
//        setContentView(R.layout.activity_display_message);

        //Make sure we're running honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        clicks = 0;
        textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        imageView = new ImageView(this);
        setContentView(textView);
       textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (clicks == 0) {
                textView.setText("DU KLICKA");
                clicks++;
                }
                else {
                    imageView.setImageDrawable(photo);
                    setContentView(imageView);


                }
                return false;
            }
        });
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                setContentView(textView);

                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
