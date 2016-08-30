package com.example.evelina.bookstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.evelina.bookstore.book.Book;

public class ViewActivity extends AppCompatActivity {
    ImageView bookCover;
    // TODO Book one= new Book(...);
    Book one= new Book("Paraic O` Donnel","Maker of swans",345);
    Book two= new Book("Charles Ferner","Pieces of light",233);
    Book three= new Book("Louis Bell", "Red dog",678);
    TextView title;
    TextView author;
    TextView pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        bookCover = (ImageView) findViewById(R.id.imageView_bookCover);
        title=(TextView)findViewById(R.id.editText_Title) ;
        author=(TextView)findViewById(R.id.editText_author);
        pages= (TextView)findViewById(R.id.editText_pages);
        String data = getIntent().getExtras().getString("BookCover");
        switch (data) {
            case ("1"):
                bookCover.setImageResource(R.drawable.download);
                title.setText(title.getText().toString()+one.getTitle());
                author.setText(author.getText().toString()+one.getAuthor());
                pages.setText(pages.getText().toString()+one.getPages());

                break;
            case ("2"):
                bookCover.setImageResource(R.drawable.original);
                title.setText(title.getText().toString()+two.getTitle());
                author.setText(author.getText().toString()+two.getAuthor());
                pages.setText(pages.getText().toString()+two.getPages());
                break;
            case ("3"):
                bookCover.setImageResource(R.drawable.reddog);
                title.setText(title.getText().toString()+three.getTitle());
                author.setText(author.getText().toString()+three.getAuthor());
                pages.setText(pages.getText().toString()+three.getPages());
                break;
        }
     }
    }
