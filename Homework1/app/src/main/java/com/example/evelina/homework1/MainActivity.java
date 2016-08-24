package com.example.evelina.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView label;
    private  Button helloButton;
    private EditText nameText;
    private Button registerButton;
    private EditText passwordText;
    private EditText userAge;

    HashMap<String,String> users= new HashMap<String,String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloButton= (Button) findViewById(R.id.button_Hello);
        nameText= (EditText)findViewById(R.id.username);
        passwordText=(EditText)findViewById(R.id.password);
        registerButton=(Button)findViewById(R.id.button_register);
        final String username=nameText.getText().toString();
        final  String password= passwordText.getText().toString();
        label=(TextView) findViewById(R.id.label_text);
        userAge=(EditText)findViewById(R.id.age_text);
        final String age=userAge.getText().toString();


        helloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(age.matches("")){
                Toast toast=Toast.makeText(MainActivity.this,"Hello, "+nameText.getText().toString() ,Toast.LENGTH_SHORT);
                toast.show();
                checkForUser(username,password);
                }
                if(age.matches("^[0-9]")){
//                    int years=Integer.parseInt(age);
//                    int result= 2016-years;
                    Toast t= Toast.makeText(MainActivity.this,"Hello, "+nameText.getText().toString()+(2016-Integer.parseInt(userAge.getText().toString()))+" ",Toast.LENGTH_SHORT);
                    t.show();
                    checkForUser(username,password);
                }
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                users.put(username,password);
            }
        }) ;
    }

        public void checkForUser(String username,String password) {
        if (users.containsKey(username) && users.containsValue(password)) {
            label.setText("Existing user");
        } else {
            label.setText("Not existing user.Please register.");
        }


    }
}
