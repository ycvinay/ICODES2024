package com.example.icodes2024;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class ContactsActivity extends AppCompatActivity {
    private TextInputEditText etTitle, etSubject, etMessage;
    MaterialButton btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etTitle = findViewById(R.id.editTextTitle);
        etSubject = findViewById(R.id.editTextSubject);
        etMessage = findViewById(R.id.editTextBody);

        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> sendEmal());

    }

    private void sendEmal() {
        String title = etTitle.getText().toString();
        String subject = etSubject.getText().toString();
        String body = etMessage.getText().toString();

        if (title.isEmpty() || subject.isEmpty() || body.isEmpty()) {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
//        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"vinayyc99@gmail.com"});
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"icodem2024@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, "Title: " + title + "\n\n" + body);
        
        try {
            startActivity(Intent.createChooser(intent, "send email..."));

        } catch (android.content.ActivityNotFoundException e) {
            Toast.makeText(this, "No email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }
}