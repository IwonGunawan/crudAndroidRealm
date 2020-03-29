package com.crud.realm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.crud.realm.utils.RealmHelper;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    RealmHelper realmHelper;
    TextView studentName, studentAddress;
    Button btnUpdate;
    Button btnDelete;

    int studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // toolbar
        Toolbar toolbar = findViewById(R.id.tbAdd);
        toolbar.setTitle("Edit Data");
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
        btnUpdate = findViewById(R.id.btn_update);
        btnDelete = findViewById(R.id.btn_delete);

        // get intent data
        studentId = getIntent().getIntExtra("student_id", 0);
        String name = getIntent().getStringExtra("student_name");
        String address = getIntent().getStringExtra("student_address");

        // set value
        studentName.setText(name);
        studentAddress.setText(address);

        realmHelper = new RealmHelper(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnUpdate) {
            update();
        }
        else if (v == btnDelete) {
            delete();
        }
    }

    public void update() {
        String name = studentName.getText().toString();
        String address = studentAddress.getText().toString();

        realmHelper.update(studentId, name, address);
        finish();
    }

    public void delete() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Are You sure delete this message");

        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                realmHelper.delete(studentId);
                finish();
            }
        });

        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //
            }
        });

        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }
}
