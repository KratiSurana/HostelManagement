package com.example.cdgi_hostel.admin.enter.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class Register_Warden extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText etFirstName,etLastName,etPassword,etConfirmPassword,etAddress,etPincode,
            etDOB,etEmail,etContact,etEmergencyContactNumber,etCollegeId,etExperience,etId;

    Spinner spinnerState,spinnerCity,spinnerHostelType,spinnerIdProof;

    Button btn_cancel,btn_submit;
    RadioGroup radioGroup;
    RadioButton radiobtnMale,radiobtnFemale,radioButton;

    DatabaseHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__warden);
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
        etEmergencyContactNumber = (EditText) findViewById(R.id.etAnother_Contact_Number);
        etCollegeId = (EditText) findViewById(R.id.etCollegeId);
        etExperience =(EditText) findViewById(R.id.etExperience);
        etId =(EditText) findViewById(R.id.etId);

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


        spinnerHostelType = (Spinner) findViewById(R.id.spinnerHostelType);
        ArrayAdapter<CharSequence> adapterHostelType= ArrayAdapter.createFromResource(this,
                R.array.HostelType, R.layout.support_simple_spinner_dropdown_item);
        adapterHostelType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerHostelType.setAdapter(adapterHostelType);
        spinnerHostelType.setOnItemSelectedListener(this);

        spinnerIdProof = (Spinner) findViewById(R.id.spinnerIDProof);
        ArrayAdapter<CharSequence> adapterIdProof= ArrayAdapter.createFromResource(this,
                R.array.IdProof, R.layout.support_simple_spinner_dropdown_item);
        adapterIdProof.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerIdProof.setAdapter(adapterIdProof);
        spinnerIdProof.setOnItemSelectedListener(this);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radiobtnMale = (RadioButton) findViewById(R.id.male);
        radiobtnFemale = (RadioButton) findViewById(R.id.female);
        final int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);


        btn_submit = (Button) findViewById(R.id.Submit);

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
                String EmergencyContactNumber = etEmergencyContactNumber.getText().toString();
                String CollegeId = etCollegeId.getText().toString();
                String Experience = etExperience.getText().toString();
                String Id = etId.getText().toString();

                String State = spinnerState.getSelectedItem().toString();
                String City= spinnerCity.getSelectedItem().toString();
                String HostelType= spinnerHostelType.getSelectedItem().toString();
                String IdProof= spinnerIdProof.getSelectedItem().toString();

                String Gender = radioButton.getText().toString();

                String ConfirmPassword = etConfirmPassword.getText().toString();

                if(FirstName.isEmpty()||Contact.isEmpty())
                    Toast.makeText(Register_Warden.this, "Fill Name and Contact", Toast.LENGTH_SHORT).show();
                else {
                    if (Password.equals(ConfirmPassword))
                    {
                        Boolean checkWarden = DB.checkWarden(Contact);
                        if (!checkWarden) {
                            Boolean insert = DB.insertWardenData(FirstName, LastName, Password
                                    , Address, Pincode, DOB, Email
                                    , Contact, EmergencyContactNumber, CollegeId, Experience,Id,State,City,HostelType,IdProof,Gender);

                            if (insert) {
                                Toast.makeText(Register_Warden.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Register_Warden.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(Register_Warden.this, "Already registered", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Register_Warden.this, "Password do not match", Toast.LENGTH_SHORT).show();
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