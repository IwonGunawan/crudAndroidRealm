package com.crud.realm;

import android.content.Intent;
import android.os.Bundle;

import com.crud.realm.utils.MainAdapter;
import com.crud.realm.utils.RealmHelper;
import com.crud.realm.utils.StudentModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RealmHelper realmHelper;
    TextView today, noData;
    ArrayList<StudentModel> studentModel = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateActivity.class));
            }
        });

        // initialize
        today   = findViewById(R.id.today);
        noData  = findViewById(R.id.no_data);
        recyclerView = findViewById(R.id.recycler_view);

        // call realm
        realmHelper = new RealmHelper(MainActivity.this);

        setData();
        setToday();
    }

    public void setData() {
        recyclerView.setAdapter(new MainAdapter(MainActivity.this, studentModel));
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        studentModel = realmHelper.listData();
        if (studentModel.size() == 0) {
            noData.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
        else {
            noData.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(new MainAdapter(MainActivity.this, studentModel));
        }
    }

    public void setToday() {

        String dayNow  = getDay();
        String dateNow = getDate();

        String result = dayNow + ", " + dateNow;
        today.setText(result);
    }

    public String getDay() {
        String result = "";
        Date date = Calendar.getInstance().getTime();
        String dateNow =  (String) DateFormat.format("EEEE", date);
        if (dateNow.equalsIgnoreCase("sunday")) {
            result = "Minggu";
        }
        else if (dateNow.equalsIgnoreCase("monday")) {
            result = "Senin";
        }
        else if (dateNow.equalsIgnoreCase("tuesday")) {
            result = "Selasa";
        }
        else if (dateNow.equalsIgnoreCase("wednesday")) {
            result = "Rabu";
        }
        else if (dateNow.equalsIgnoreCase("thursday")) {
            result = "Kamis";
        }
        else if (dateNow.equalsIgnoreCase("friday")) {
            result = "Jumat";
        }
        else if (dateNow.equalsIgnoreCase("saturday")) {
            result = "Sabtu";
        }
        else {
            result = "";
        }

        return result;
    }

    public String getDate() {
        String result   = "";
        Date date   = Calendar.getInstance().getTime();
        String tgl  = (String) DateFormat.format("d", date);
        String month= (String) DateFormat.format("M", date);
        String year = (String) DateFormat.format("yyyy", date);

        int monthInt = Integer.parseInt(month);
        if (monthInt == 1) {
            month = "Januari";
        }
        else if (monthInt == 2) {
            month = "Februari";
        }
        else if (monthInt == 3) {
            month = "Maret";
        }
        else if (monthInt == 4) {
            month = "April";
        }
        else if (monthInt == 5) {
            month = "Mei";
        }
        else if (monthInt == 6) {
            month = "Juni";
        }
        else if (monthInt == 7) {
            month = "Juli";
        }
        else if (monthInt == 8) {
            month = "Agustus";
        }
        else if (monthInt == 9) {
            month = "September";
        }
        else if (monthInt == 10) {
            month = "Oktober";
        }
        else if (monthInt == 11) {
            month = "November";
        }
        else if (monthInt == 12) {
            month = "Desember";
        }

        result = tgl + " " + month + " " + year;

        return result;
    }

    @Override
    protected void onResume() {
        super.onResume();
        setData();
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
