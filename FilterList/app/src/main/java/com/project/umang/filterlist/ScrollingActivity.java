package com.project.umang.filterlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static android.support.v7.appcompat.R.styleable.Toolbar;


public class ScrollingActivity extends AppCompatActivity {

    int[] images = new int[]{R.drawable.arvind,R.drawable.par,R.drawable.sport,R.drawable.hockey};
    //  LinearLayout ll = (LinearLayout)findViewById(R.id.ll);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent intent = getIntent();

        getSupportActionBar().setTitle(intent.getStringExtra("title"));

        int imageNumber = intent.getIntExtra("image",0);
        ImageView im1 = (ImageView)findViewById(R.id.scroll_im);
        im1.setImageResource(imageNumber);
      /*  for(int i:images)
        {
            ImageView ii = new ImageView(this);
            ii.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            ii.setImageResource(i);
            ii.setPadding(10,10,10,10);
            ii.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ll.addView(ii);

        }*/
        /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }
}
