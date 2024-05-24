package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity2 extends AppCompatActivity {
Button btn3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        TextView txt1=findViewById(R.id.txt1);
        btn3=findViewById(R.id.btn3);

        Intent intent=getIntent();
        String name=intent.getStringExtra("NAME");
        String email=intent.getStringExtra("EMAIL");
        String gender=intent.getStringExtra("GENDER");
        String course=intent.getStringExtra("COURSE");
        String selectedDate=intent.getStringExtra("BIRTHDATE");
        txt1.setText("Name:"+name+"\n\nEmail:"+email+"\n\nGender:"+gender+"\n\nCourse:"+course+"\n\nDate Of Birth:"+selectedDate);



        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}