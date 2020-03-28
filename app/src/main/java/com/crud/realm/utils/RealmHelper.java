package com.crud.realm.utils;

import android.content.Context;
import android.provider.Settings;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class RealmHelper {

    private Context context;
    private Realm realm;
    private RealmResults<StudentModel> realmResults;

    // logt
    private static final String TAG = "RealmHelper";

    public RealmHelper(Context context) {
        this.context = context;
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

//    public void inputDataAwal() {
//        StudentModel siswa = new StudentModel();
//        siswa.setStudentId(1);
//        siswa.setStudentName("Azhar");
//        siswa.setStudentAddress("Pondok Indah");
//
//        realm.beginTransaction();
//        realm.copyToRealm(siswa);
//        realm.commitTransaction();
//
//        Toast.makeText(context, "Data berhasil ditambah", Toast.LENGTH_LONG).show();
//    }

    /* LISTING */
    public ArrayList<StudentModel> listData() {

        ArrayList<StudentModel> data = new ArrayList<>();
        realmResults = realm.where(StudentModel.class).findAll();
        realmResults.sort("studentId", Sort.ASCENDING);

        if (realmResults.size() > 0) {

            for (int i=0; i < realmResults.size(); i++) {
                StudentModel studentModel = new StudentModel();

                studentModel.setStudentId(realmResults.get(i).getStudentId());
                studentModel.setStudentName(realmResults.get(i).getStudentName());
                studentModel.setStudentAddress(realmResults.get(i).getStudentAddress());

                data.add(studentModel);
            }
        }

        return data;
    }

    /* CREATE */
    public void create(String studentName, String studentAddress) {
        int id = (int) (System.currentTimeMillis() / 1000);

        StudentModel studentModel = new StudentModel();
        studentModel.setStudentId(id);
        studentModel.setStudentName(studentName);
        studentModel.setStudentAddress(studentAddress);

        realm.beginTransaction();
        realm.copyToRealm(studentModel);
        realm.commitTransaction();

        Toast.makeText(context, "Success save Data", Toast.LENGTH_LONG).show();
    }

    /* UPDATE */
    public void update(int studentId, String studentName, String studentAddress){
        realm.beginTransaction();
        StudentModel studentModel = realm.where(StudentModel.class).equalTo("studentId", studentId).findFirst();

        studentModel.setStudentName(studentName);
        studentModel.setStudentAddress(studentAddress);
        realm.copyToRealm(studentModel);
        realm.commitTransaction();

        Toast.makeText(context, "Data has been update !", Toast.LENGTH_LONG).show();
    }

    /* DELETE */
    public void delete(int studentId) {
        realm.beginTransaction();
        RealmResults<StudentModel> studentModel = realm.where(StudentModel.class).equalTo("studentId", studentId).findAll();

        studentModel.deleteAllFromRealm();
        realm.commitTransaction();

        Toast.makeText(context, "DELETED !", Toast.LENGTH_LONG).show();
    }
}
