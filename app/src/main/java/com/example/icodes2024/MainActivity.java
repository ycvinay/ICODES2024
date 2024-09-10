package com.example.icodes2024;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton btnBrochure = findViewById(R.id.btn_brochure);
        MaterialButton btnRegister = findViewById(R.id.btn_register);

        btnBrochure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String brochureLink = "https://drive.google.com/uc?export=download&id=1Dt8zf8zj32v4jZb8xambgEKUc-7m1x5x";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(brochureLink));
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

    }
}