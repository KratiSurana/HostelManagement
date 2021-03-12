package com.example.cdgi_hostel.admin.enter.register;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cdgi_hostel.DatabaseHelper;
import com.example.cdgi_hostel.MainActivity;
import com.example.cdgi_hostel.R;

public class Register_Student extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText etFirstName,etLastName,etPassword,etConfirmPassword,etAddress,etPincode,
            etDOB,etEmail,etContact,etEmergencyContactNUmber, etMothersName,
            etfathersName,etGuardiansName,etMothersNumber,etFathersNumber,etGuradiansNumber
            ,etStartDate,etLastDate,etRollNumber,etId;

    Spinner spinnerState,spinnerCity,spinnerSem,spinnerAcademicYear,spinnerDegree,spinnerDepartment,spinnerRoomType,spinnerIdProof;

    Button btn_cancel,btn_submit;
    RadioGroup radioGroup;
    RadioButton radiobtnMale,radiobtnFemale,radioButton;
    DatabaseHelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__student);

         DB = new DatabaseHelper(this);

        etFirstName = (EditText) findViewById(R.id.etFirst_Name);
        etLastName = (EditText) findViewById(R.id.etLast_Name);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPassword = (EditText) findViewById(R.id.etConfirm_Password);
        etAddress = (EditText) findViewById(R.id.etAddress);
        etPincode = (EditText) findViewById(R.id.etPincode);
        etDOB = (EditText) findViewById(R.id.etDateOfBirth);
        etEmail = (EditText) findViewById(R.id.etMail);
        etContact = (EditText) findViewById(R.id.etContactNumber);
        etEmergencyContactNUmber = (EditText) findViewById(R.id.etEmergency_Contact_Number);
        etMothersNumber = (EditText) findViewById(R.id.etMotherNumber);
        etFathersNumber = (EditText) findViewById(R.id.etFatherNumber);
        etGuardiansName = (EditText) findViewById(R.id.etGuardianName);
        etGuradiansNumber = (EditText) findViewById(R.id.etGuardianNumber);
        etMothersName = (EditText) findViewById(R.id.etMother);
        etfathersName = (EditText) findViewById(R.id.etFatherName);
        etStartDate = (EditText) findViewById(R.id.etStartDate);
        etLastDate = (EditText) findViewById(R.id.etEndDate);
        etRollNumber = (EditText) findViewById(R.id.etRollNumber);
        etId = (EditText) findViewById(R.id.etId);

        spinnerState = (Spinner) findViewById(R.id.spinnerState);
        ArrayAdapter<CharSequence> adapterState = ArrayAdapter.createFromResource(this,
                R.array.States, R.layout.support_simple_spinner_dropdown_item);
        adapterState.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerState.setAdapter(adapterState);
        spinnerState.setOnItemSelectedListener(this);

        spinnerCity = (Spinner) findViewById(R.id.spinnerCity);
        ArrayAdapter<CharSequence> adapterCity= ArrayAdapter.createFromResource(this,
                R.array.City, R.layout.support_simple_spinner_dropdown_item);
        adapterCity.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerCity.setAdapter(adapterCity);
        spinnerCity.setOnItemSelectedListener(this);

        spinnerAcademicYear = (Spinner) findViewById(R.id.spinnerAcademicYear);
        ArrayAdapter<CharSequence> adapterAcademicYear= ArrayAdapter.createFromResource(this,
                R.array.AcademicYear, R.layout.support_simple_spinner_dropdown_item);
        adapterAcademicYear.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerAcademicYear.setAdapter(adapterAcademicYear);
        spinnerAcademicYear.setOnItemSelectedListener(this);

        spinnerDegree = (Spinner) findViewById(R.id.spinnerDegree);
        ArrayAdapter<CharSequence> adapterDegree= ArrayAdapter.createFromResource(this,
                R.array.Degree, R.layout.support_simple_spinner_dropdown_item);
        adapterDegree.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerDegree.setAdapter(adapterDegree);
        spinnerDegree.setOnItemSelectedListener(this);

        spinnerDepartment = (Spinner) findViewById(R.id.spinnerDepartment);
        ArrayAdapter<CharSequence> adapterDepartment= ArrayAdapter.createFromResource(this,
                R.array.Department, R.layout.support_simple_spinner_dropdown_item);
        adapterDepartment.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerDepartment.setAdapter(adapterDepartment);
        spinnerDepartment.setOnItemSelectedListener(this);

        spinnerSem = (Spinner) findViewById(R.id.spinnerSem);
        ArrayAdapter<CharSequence> adapterSem= ArrayAdapter.createFromResource(this,
                R.array.Sem, R.layout.support_simple_spinner_dropdown_item);
        adapterSem.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerSem.setAdapter(adapterSem);
        spinnerSem.setOnItemSelectedListener(this);

        spinnerIdProof = (Spinner) findViewById(R.id.spinnerIDProof);
        ArrayAdapter<CharSequence> adapterIdProof= ArrayAdapter.createFromResource(this,
                R.array.IdProof, R.layout.support_simple_spinner_dropdown_item);
        adapterIdProof.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerIdProof.setAdapter(adapterIdProof);
        spinnerIdProof.setOnItemSelectedListener(this);

        spinnerRoomType = (Spinner) findViewById(R.id.spinnerRoomType);
        ArrayAdapter<CharSequence> adapterRoomType= ArrayAdapter.createFromResource(this,
                R.array.RoomType, R.layout.support_simple_spinner_dropdown_item);
        adapterRoomType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerRoomType.setAdapter(adapterRoomType);
        spinnerRoomType.setOnItemSelectedListener(this);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radiobtnMale = (RadioButton) findViewById(R.id.male);
        radiobtnFemale = (RadioButton) findViewById(R.id.female);
        final int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        //btn_cancel = (Button) findViewById(R.id.Cancle);
        btn_submit = (Button) findViewById(R.id.Submit);


//        btn_cancel.setOnClickListener(new View.OnClickListener() {
  //          @Override
    //        public void onClick(View v) {

      //      }
        //});

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String FirstName = etFirstName.getText().toString();
                String LastName =  etLastName.getText().toString();
                String Password =  etPassword.getText().toString();
                String Address = etAddress.getText().toString();
                String Pincode = etPincode.getText().toString();
                String DOB = etDOB.getText().toString();
                String Email = etEmail.getText().toString();
                String Contact = etContact.getText().toString();
                String EmergencyContactNUmber = etEmergencyContactNUmber.getText().toString();
                String MothersNumber = etMothersNumber.getText().toString();
                String FathersNumber = etFathersNumber.getText().toString();
                String GuardiansName = etGuardiansName.getText().toString();
                String GuradiansNumber = etGuradiansNumber.getText().toString();
                String MothersName = etMothersName.getText().toString();
                String fathersName = etfathersName.getText().toString();
                String StartDate = etStartDate.getText().toString();
                String LastDate = etLastDate.getText().toString();
                String RollNumber = etRollNumber.getText().toString();
                String Id = etId.getText().toString();
                String State = spinnerState.getSelectedItem().toString();
                String City  = spinnerCity.getSelectedItem().toString();
                String Sem  = spinnerSem.getSelectedItem().toString();
                String AcademicYear  = spinnerAcademicYear.getSelectedItem().toString();
                String Degree  = spinnerDegree.getSelectedItem().toString();
                String Department  = spinnerDepartment.getSelectedItem().toString();
                String RoomType  = spinnerRoomType.getSelectedItem().toString();
                String IdProof = spinnerIdProof.getSelectedItem().toString();

               String Gender = radioButton.getText().toString();

                String ConfirmPassword = etConfirmPassword.getText().toString();

                if(FirstName.isEmpty()||Contact.isEmpty())
                    Toast.makeText(Register_Student.this, "Fill Name and Contact", Toast.LENGTH_SHORT).show();
                else
                {
                    if(Password.equals(ConfirmPassword))
                    {
                        Boolean checkStudent = DB.checkStudent(Contact);
                        if(!checkStudent)
                        {
                            Boolean insert = DB.insertData(FirstName,LastName,Password,Address,Pincode,DOB,Email
                            , Contact, EmergencyContactNUmber, MothersName, fathersName, GuardiansName,
                                    MothersNumber, FathersNumber, GuradiansNumber, StartDate, LastDate, RollNumber, Id,
                                  State,City,Sem,AcademicYear,Degree,Department,RoomType,IdProof,Gender);

                            if(insert)
                            {
                                Toast.makeText(Register_Student.this, "Registered Succesfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(Register_Student.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else
                        {
                            Toast.makeText(Register_Student.this,"Already registered",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(Register_Student.this, "Password do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void rbClick(View v)
    {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
    }
}