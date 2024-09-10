package com.example.icodes2024;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;

public class HomeActivity extends AppCompatActivity {
    private static final String BROCHURE_URL = "https://drive.google.com/uc?export=download&id=1Dt8zf8zj32v4jZb8xambgEKUc-7m1x5x";
    private static final String SUBMIT_PAPER_URL = "https://drive.google.com/uc?export=download&id=1Dt8zf8zj32v4jZb8xambgEKUc-7m1x5x";
    MaterialButton btnBrochure, btnSubmitPaper, btnPayment, btnCheckPaperStatus, btnMessages, btnContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnBrochure = findViewById(R.id.btn_brochure);
        btnSubmitPaper = findViewById(R.id.btn_submit_paper);
        btnPayment = findViewById(R.id.btn_payment);
        btnCheckPaperStatus = findViewById(R.id.btn_check_paper_status);
        btnMessages = findViewById(R.id.btn_messages);
        btnContact = findViewById(R.id.btn_contacts);

        btnBrochure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(BROCHURE_URL));
                startActivity(intent);
            }
        });

        btnSubmitPaper.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://example.com/submit_paper")); // Replace with your submission URL
            startActivity(intent);
        });

        btnPayment.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://example.com/fee_payment")); // Replace with your payment URL
            startActivity(intent);
        });

        btnCheckPaperStatus.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://example.com/check_status")); // Replace with your status check URL
            startActivity(intent);
        });

        btnMessages.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MessagesActivity.class);
            startActivity(intent);
        });

        btnContact.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ContactsActivity.class);
            startActivity(intent);
        });

    }
}