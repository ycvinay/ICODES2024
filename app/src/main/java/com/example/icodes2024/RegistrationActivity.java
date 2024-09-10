package com.example.icodes2024;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;


public class RegistrationActivity extends AppCompatActivity {
    private EditText etEmail, etTitle, etName, etMobile, etCompany;
    private MaterialButton btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etEmail = findViewById(R.id.email);
        etTitle = findViewById(R.id.title);
        etName = findViewById(R.id.name);
        etMobile = findViewById(R.id.mobile);
        etCompany = findViewById(R.id.company);

        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> validateAndSubmit());
    }
    
    private void validateAndSubmit() {
        String email = etEmail.getText().toString();
        String title = etTitle.getText().toString();
        String name = etName.getText().toString();
        String mobile = etMobile.getText().toString();
        String company = etCompany.getText().toString();
        
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return;
        }
        
        if (TextUtils.isEmpty(title)) {
            etTitle.setError("Title is required");
            etTitle.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(name)) {
            etName.setError("Name is required");
            etName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(mobile)) {
            etMobile.setError("Mobile number is required");
            etMobile.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(company)) {
            etCompany.setError("Mobile number is required");
            etCompany.requestFocus();
            return;
        }

        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(RegistrationActivity.this, HomeActivity.class);
        startActivity(intent);

    }
}