package com.crud.realm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

public class CreateActivity extends AppCompatActivity {

    TextView studentName, studentAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        // toolbar
        Toolbar toolbar = findViewById(R.id.tbAdd);
        toolbar.setTitle("New Data");
        setSupportActionBar(toolbar);

        // initialize
        studentName = findViewById(R.id.student_name);
        studentAddress = findViewById(R.id.student_address);


    }
}
