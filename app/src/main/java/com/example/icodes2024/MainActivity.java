package com.example.icodes2024;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity {

    private static final String SUBMIT_PAPER_AND_PAYMENT_URL = "https://forms.gle/gQJaANkBEkcXNMQq7";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton btnBrochure = findViewById(R.id.btn_brochure);
        MaterialButton btnRegister = findViewById(R.id.btn_register);

        btnBrochure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String brochureLink = "http://www.cmr.edu.in/icodes2024/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(brochureLink));
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // This is For Filling the form in xml layout
//                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
//                startActivity(intent);

                // this is google form
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(SUBMIT_PAPER_AND_PAYMENT_URL));
                startActivity(intent);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }, 2000);



            }
        });

    }
}