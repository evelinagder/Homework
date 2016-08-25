package com.example.evelina.calculateprice;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button dollarButton;
    Button euroButton;
    Button bgnButton;
    TextView soupTextView;
    TextView mainDTextView;
    TextView dessertTextView;
    TextView soupCountTextView;
    TextView mainCountTextView;
    TextView dessertCountTextView;
    Button soupPlusButton;
    Button mainPlusbButton;
    Button dessertPlusbButton;
    Button soupMinusButton;
    Button mainMinusButton;
    Button dessertMinusButton;
    SeekBar cockeSeekBar;
    CheckBox deliveryCheckBox;
    Button calculateButton;
    TextView totalPrice;
    int totalSum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dollarButton = (Button)findViewById(R.id.button_dollar);
        euroButton= (Button)findViewById(R.id.button_euro);
        bgnButton=(Button)findViewById(R.id.button_bgn);
        bgnButton=(Button)findViewById(R.id.button_bgn);

        soupCountTextView=(TextView)findViewById(R.id.textView_soupCount);
        mainCountTextView=(TextView) findViewById(R.id.textView_mainDCount);
        dessertCountTextView= (TextView)findViewById(R.id.textView_dessertCount);

        soupPlusButton=(Button)findViewById(R.id.button_soupPlus);
        mainPlusbButton=(Button)findViewById(R.id.button_mainPlus);
        dessertPlusbButton= (Button)findViewById(R.id.button_dessertPlus);

        soupMinusButton=(Button)findViewById(R.id.button_soupMinus);
        mainMinusButton=(Button)findViewById(R.id.button_mainMinus);
        dessertMinusButton=(Button)findViewById(R.id.button_dessertMinus);

        deliveryCheckBox=(CheckBox)findViewById(R.id.checkBox_homeDelivery);
        calculateButton=(Button)findViewById(R.id.button_calculate);
        totalPrice= (TextView)findViewById(R.id.textView_totalP);

        cockeSeekBar=(SeekBar)findViewById(R.id.seekBar);
        cockeSeekBar.setMax(2);
        cockeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress=0;

            // progress= value of seekBar!!!!
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
            progress=i;
                Toast.makeText(getApplicationContext(), "Progress "+progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        deliveryCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
            if(checked){
                totalSum +=10;
                Toast.makeText(getApplicationContext(),"Sum "+totalSum,Toast.LENGTH_SHORT).show();
            }
                else{
                totalSum -=10;
                Toast.makeText(getApplicationContext(),"Sum "+totalSum,Toast.LENGTH_SHORT).show();
            }
            }
        });
        soupPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soupCount=soupCountTextView.getText().toString();
                int soups=Integer.parseInt(soupCount);
                soups++;
                soupCountTextView.setText(soups+"");
            }
        });
        mainPlusbButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String mainCount=mainCountTextView.getText().toString();
                int main=Integer.parseInt(mainCount);
                main++;
                mainCountTextView.setText(main+"");
            }
        });
        dessertPlusbButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View vi) {
                String dessertCount=dessertCountTextView.getText().toString();
                int dessert=Integer.parseInt(dessertCount);
                dessert++;
                dessertCountTextView.setText(dessert+"");

            }
        });
            calculateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    totalPrice.setText("Total Price:"+totalSum);
                }
            });

    }

}
