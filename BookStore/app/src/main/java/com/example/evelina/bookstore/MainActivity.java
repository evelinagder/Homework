package com.example.evelina.bookstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String bgn= "BGN";
    public static final String usd="USD";
    public static final String eu="EU";

    TextView count1;
    TextView count2;
    TextView count3;
    Button plus1;
    Button plus2;
    Button plus3;
    Button minus1;
    Button minus2;
    Button minus3;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Button view1;
    Button buy1;
    Button view2;
    Button buy2;
    Button view3;
    Button buy3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count1=(TextView)findViewById(R.id.textView_count1);
        count2=(TextView)findViewById(R.id.textView_count2);
        count3=(TextView)findViewById(R.id.textView_count3);
        plus1=(Button)findViewById(R.id.button_plus1);
        plus2=(Button)findViewById(R.id.button_plus2);
        plus3=(Button)findViewById(R.id.button_plus3);
        minus1=(Button)findViewById(R.id.button_minus1);
        minus2=(Button)findViewById(R.id.button_minus2);
        minus3=(Button)findViewById(R.id.button_minus3);
        spinner1=(Spinner)findViewById(R.id.spinner_1);
        spinner2=(Spinner)findViewById(R.id.spinner_2);
        spinner3=(Spinner)findViewById(R.id.spinner_3);
        buy1=(Button)findViewById(R.id.button_buy1);
        buy2=(Button)findViewById(R.id.button_buy2);
        buy3=(Button)findViewById(R.id.button_buy3);
        view1=(Button)findViewById(R.id.button_view1);
        view2=(Button)findViewById(R.id.button_view2);
        view3=(Button)findViewById(R.id.button_view3);

        count1.setText("0");
        count2.setText("0");
        count3.setText("0");

        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String count_1=count1.getText().toString();
                int bookCount=Integer.parseInt(count_1);
                bookCount++;
                count1.setText(bookCount+"");
            }
        });
        plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String count_2=count2.getText().toString();
                int bookCount=Integer.parseInt(count_2);
                bookCount++;
                count1.setText(bookCount+"");
            }
        });
        plus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String count_3=count3.getText().toString();
                int bookCount=Integer.parseInt(count_3);
                bookCount++;
                count1.setText(bookCount+"");
            }
        });
        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String count_1=count1.getText().toString();
                int bookCount=Integer.parseInt(count_1);
                bookCount--;
                count1.setText(bookCount+"");
            }
        });
        minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String count_2=count2.getText().toString();
                int bookCount=Integer.parseInt(count_2);
                bookCount--;
                count1.setText(bookCount+"");
            }
        });
        minus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String count_3=count3.getText().toString();
                int bookCount=Integer.parseInt(count_3);
                bookCount--;
                count1.setText(bookCount+"");
            }
        });
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,ViewActivity.class);
                intent.putExtra("BookCover","1");
                startActivity(intent);
            }
        });
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,ViewActivity.class);
                intent.putExtra("BookCover","2");
                startActivity(intent);
            }
        });
        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,ViewActivity.class);
                intent.putExtra("BookCover","3");
                startActivity(intent);
            }
        });
        ArrayAdapter adapter1= ArrayAdapter.createFromResource(this,R.array.currency,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        ArrayAdapter adapter2= ArrayAdapter.createFromResource(this,R.array.currency,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        ArrayAdapter adapter3= ArrayAdapter.createFromResource(this,R.array.currency,android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter3);

        buy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,CongratsActivity.class);
                intent.putExtra("BookCover","1");
                startActivity(intent);
            }
        });
        buy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,CongratsActivity.class);
                intent.putExtra("BookCover","2");
                startActivity(intent);
            }
        });
        buy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,CongratsActivity.class);
                intent.putExtra("BookCover","3");
                startActivity(intent);
            }
        });
    }
}
