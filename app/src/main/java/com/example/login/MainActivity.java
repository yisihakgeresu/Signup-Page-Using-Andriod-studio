package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText t1, t2;
    RadioGroup rg;
    CheckBox checkBox, checkBox2, checkBox3;
    Button b1, b2;
    String selectedDate = "";
    String gender = "";
    //String courses = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        rg = findViewById(R.id.rg);
        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);

        // Set listener for RadioGroup changes
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Check which RadioButton is checked
                switch (checkedId) {
                    case R.id.btn1:
                        gender = "Male";
                        break;
                    case R.id.btn2:
                        gender = "Female";
                        break;
                }
            }
        });

        // Set listener for "Signup" button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input from EditText fields
                String name = t1.getText().toString();
                String email = t2.getText().toString();

               String course = "";

// Check each checkbox individually to see if it's checked, then append its text to the course string
//                if (checkBox.isChecked()) {
//                    course += checkBox.getText().toString() + ", ";
//                }
//                if (checkBox2.isChecked()) {
//                    course += checkBox2.getText().toString() + ", ";
//                }
//                if (checkBox3.isChecked()) {
//                    course += checkBox3.getText().toString() + ", ";
//                }
//                String course = "";
                if (checkBox.isChecked()) {
                    course += checkBox.getText().toString();
                    if (checkBox2.isChecked() || checkBox3.isChecked()) {
                        course += ", ";
                    }
                }
                if (checkBox2.isChecked()) {
                    course += checkBox2.getText().toString();
                    if (checkBox3.isChecked()) {
                        course += ", ";
                    }
                }
                if (checkBox3.isChecked()) {
                    course += checkBox3.getText().toString();
                }

                // Validate user input
                if (name.isEmpty() || email.isEmpty() || gender.isEmpty() || course.isEmpty() || selectedDate.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Proceed with signup
                    Intent intent = new Intent(MainActivity.this, SecondActivity2.class);
                    intent.putExtra("NAME", name);
                    intent.putExtra("EMAIL", email);
                    intent.putExtra("GENDER", gender);
                    intent.putExtra("COURSE", course);
                    intent.putExtra("BIRTHDATE", selectedDate);
                    startActivity(intent);
                }
            }
        });

        // Set listener for "Birth Date" button
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show DatePickerDialog to select birth date
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                                selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                                b2.setText(selectedDate);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });
    }
}
