package com.example.evelina.bookstore;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CongratsActivity extends AppCompatActivity {
    ImageView bookCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);
        bookCover= (ImageView)findViewById(R.id.imageView_bookCoverC);

        String data = getIntent().getExtras().getString("BookCover");
       switch(data){
           case("1"):
            bookCover.setImageResource(R.drawable.download);
               break;
           case("2"):
               bookCover.setImageResource(R.drawable.original);
               break;
           case("3"):
               bookCover.setImageResource(R.drawable.reddog);
               break;
        }

    }
}
