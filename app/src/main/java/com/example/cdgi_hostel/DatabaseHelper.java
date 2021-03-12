package com.example.cdgi_hostel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DatabaseName = "cdgi_hostel.db";

    public DatabaseHelper( Context context) {
        super(context, "cdgi_hostel.db", null, 2);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create Table Students(firstName TEXT ,lastName TEXT,password TEXT," +
                "address TEXT, pincode NUMERIC,dob NUMERIC,email TEXT,contactNumber NUMERIC," +
                "emergencyNumber NUMERIC," +
                "motherName TEXT, fatherName TEXT,guardianName TEXT," +
                "motherNumber NUMERIC,fatherNumber NUMERIC,guardianNumber NUMERIC," +
                "startDate NUMERIC,lastDate NUMERIC,rollNumber TEXT,id TEXT," +
                "state TEXT,city TEXT,sem TEXT," +
                "academicYear TEXT,degree TEXT,department TEXT,roomType TEXT,idProof TEXT,gender TEXT)");

        db.execSQL("create Table Manager(firstName TEXT ,lastName TEXT,password TEXT," +
                "address TEXT, pincode NUMERIC,dob NUMERIC,email TEXT,contactNumber NUMERIC," +
                "emergencyNumber NUMERIC," +
                "collegeId TEXT ,experience TEXT,id TEXT," +
                "state TEXT,city TEXT,hostelType TEXT,idProof TEXT," +
                "gender TEXT)");

        db.execSQL("create Table Warden(firstName TEXT ,lastName TEXT,password TEXT," +
                "address TEXT, pincode NUMERIC,dob NUMERIC,email TEXT,contactNumber NUMERIC," +
                "emergencyNumber NUMERIC," +
                "collegeId TEXT ,experience TEXT,id TEXT," +
                "state TEXT,city TEXT,hostelType TEXT,idProof TEXT," +
                "gender TEXT)");

        db.execSQL("create Table Mess(firstName TEXT ,lastName TEXT,password TEXT," +
                "address TEXT, pincode NUMERIC,dob NUMERIC,email TEXT,contactNumber NUMERIC," +
                "emergencyNumber NUMERIC," +
                "collegeId TEXT ,experience TEXT,id TEXT," +
                "state TEXT,city TEXT,idProof TEXT," +
                "gender TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        Log.w(TAG,"Upgrading the database from version" + i + "to"+i1);

        db.execSQL("drop Table if exists Students");
        db.execSQL("drop Table if exists Manager");
        db.execSQL("drop Table if exists Warden");
        db.execSQL("drop Table if exists Mess");
        onCreate(db);
    }
    public Boolean insertData(String firstName, String lastName, String password, String address,
                              String pincode, String dob, String email, String contactNumber, String emergencyNumber,
                              String motherName, String fatherName, String guardianName, String motherNumber,
                              String fatherNumber, String guardianNumber, String startDate,
                              String lastDate, String rollNumber, String id,String state,String city,
                              String sem,String academicYear,
                              String degree,String department,String roomType,String idProof,String gender){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName",firstName);
        contentValues.put("lastName",lastName);
        contentValues.put("password",password);
        contentValues.put("address",address);
        contentValues.put("pincode",pincode);
        contentValues.put("dob",dob);
        contentValues.put("email",email);
        contentValues.put("contactNumber",contactNumber);
        contentValues.put("emergencyNumber",emergencyNumber);
        contentValues.put("motherName",motherName);
        contentValues.put("fatherName",fatherName);
        contentValues.put("guardianName",guardianName);
        contentValues.put("motherNumber",motherNumber);
        contentValues.put("fatherNumber",fatherNumber);
        contentValues.put("guardianNumber",guardianNumber);
        contentValues.put("startDate",startDate);
        contentValues.put("lastDate",lastDate);
        contentValues.put("rollNumber",rollNumber);
        contentValues.put("id",id);

        contentValues.put("state",state);
        contentValues.put("city",city);
        contentValues.put("sem",sem);
        contentValues.put("academicYear",academicYear);
        contentValues.put("degree",degree);
        contentValues.put("department",department);
        contentValues.put("roomType",roomType);
        contentValues.put("idProof",idProof);

        contentValues.put("gender",gender);



        long result = db.insert("Students",null,contentValues);
        if(result==-1) return false;
        else
            return true;
    }


    public Boolean checkStudent(String contactNumber)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select*from Students where contactNumber=?",new String[]{contactNumber});
        if(cursor.getCount()>0) return true;
        else return  false;
    }

    public Boolean checkPassword(String rollNumber,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Students where rollNumber=? and password=?",new String[]{rollNumber,password});
        if(cursor.getCount()>0) return true;
        else return false;
    }

    public Cursor addStudentToRecyclerView(String firstName, String lastName, String rollNumber)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select*from Students where firstName=?,lastName=? and rollNumber=?", new String[]
                {firstName,lastName,rollNumber});
        return cursor;
    }

    public Boolean insertManagerData(String firstName, String lastName, String password, String address,
                                     String pincode, String dob, String email, String contactNumber,
                                     String emergencyNumber, String collegeId,
                                     String experience,String id,String state,String city,
                                     String hostelType,String idProof,String gender){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues managercontentValues = new ContentValues();
        managercontentValues.put("firstName",firstName);
        managercontentValues.put("lastName",lastName);
        managercontentValues.put("password",password);
        managercontentValues.put("address",address);
        managercontentValues.put("pincode",pincode);
        managercontentValues.put("dob",dob);
        managercontentValues.put("email",email);
        managercontentValues.put("contactNumber",contactNumber);
        managercontentValues.put("emergencyNumber",emergencyNumber);
        managercontentValues.put("collegeId",collegeId);
        managercontentValues.put("experience",experience);
        managercontentValues.put("id",id);

        managercontentValues.put("state",state);
        managercontentValues.put("city",city);
        managercontentValues.put("hostelType",hostelType);
        managercontentValues.put("idProof",idProof);
        managercontentValues.put("gender",gender);

        long result = db.insert("Manager",null,managercontentValues);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean checkManager(String contactNumber)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select*from Manager where contactNumber=?",new String[]{contactNumber});
        if(cursor.getCount()>0) return true;
        else return  false;
    }

    public Boolean insertWardenData(String firstName, String lastName, String password, String address,
                                    String pincode, String dob, String email, String contactNumber,
                                    String emergencyNumber, String collegeId,
                                    String experience,String id, String state,String city,
                                    String hostelType,String idProof,String gender){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues wardencontentValues = new ContentValues();
        wardencontentValues.put("firstName",firstName);
        wardencontentValues.put("lastName",lastName);
        wardencontentValues.put("password",password);
        wardencontentValues.put("address",address);
        wardencontentValues.put("pincode",pincode);
        wardencontentValues.put("dob",dob);
        wardencontentValues.put("email",email);
        wardencontentValues.put("contactNumber",contactNumber);
        wardencontentValues.put("emergencyNumber",emergencyNumber);
        wardencontentValues.put("collegeId",collegeId);
        wardencontentValues.put("experience",experience);
        wardencontentValues.put("id",id);

        wardencontentValues.put("state",state);
        wardencontentValues.put("city",city);
        wardencontentValues.put("hostelType",hostelType);
        wardencontentValues.put("idProof",idProof);
        wardencontentValues.put("gender",gender);

        long result = db.insert("Warden",null,wardencontentValues);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean checkWarden(String contactNumber)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select*from Warden where contactNumber=?",new String[]{contactNumber});
        if(cursor.getCount()>0) return true;
        else return  false;
    }

    public Boolean insertMessData(String firstName, String lastName, String password, String address,
                                    String pincode, String dob, String email, String contactNumber,
                                    String emergencyNumber, String collegeId,
                                    String experience,String id,String state,String city
                                  ,String idProof,String gender){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues messcontentValues = new ContentValues();
        messcontentValues.put("firstName",firstName);
        messcontentValues.put("lastName",lastName);
        messcontentValues.put("password",password);
        messcontentValues.put("address",address);
        messcontentValues.put("pincode",pincode);
        messcontentValues.put("dob",dob);
        messcontentValues.put("email",email);
        messcontentValues.put("contactNumber",contactNumber);
        messcontentValues.put("emergencyNumber",emergencyNumber);
        messcontentValues.put("collegeId",collegeId);
        messcontentValues.put("experience",experience);
        messcontentValues.put("id",id);

        messcontentValues.put("state",state);
        messcontentValues.put("city",city);
        messcontentValues.put("idProof",idProof);
        messcontentValues.put("gender",gender);


        long result = db.insert("Mess",null,messcontentValues);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean checkMess(String contactNumber)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select*from Mess where contactNumber=?",new String[]{contactNumber});
        if(cursor.getCount()>0) return true;
        else return  false;
    }
}
