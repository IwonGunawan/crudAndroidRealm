package com.crud.realm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.crud.realm.utils.RealmHelper;

public class CreateActivity extends AppCompatActivity implements View.OnClickListener {

    RealmHelper realmHelper;
    TextView studentName, studentAddress;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        // toolbar
        Toolbar toolbar = findViewById(R.id.tbAdd);
        toolbar.setTitle("New Data");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // initialize
        studentName = findViewById(R.id.student_name);
        studentAddress = findViewById(R.id.student_address);
        btnAdd = findViewById(R.id.btn_add);

        realmHelper = new RealmHelper(this);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnAdd) {
            save();
        }
    }

    public void save() {
        String name = studentName.getText().toString();
        String address = studentAddress.getText().toString();

        realmHelper.create(name, address);
        finish();
    }
}
