package com.ridwanfbnr.ridwan_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ridwanfbnr.ridwan_uts.databinding.ActivityLupaPasswordSuccessBinding;

public class LupaPasswordSuccessActivity extends AppCompatActivity {

    ActivityLupaPasswordSuccessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLupaPasswordSuccessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent dataFromLupaPassword = getIntent();
        String dataNama = dataFromLupaPassword.getStringExtra("nama");
        String dataEmail = dataFromLupaPassword.getStringExtra("email");
        String dataPassword = dataFromLupaPassword.getStringExtra("password");

        binding.btnLoginLupaSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fromLupaPasswordToLogin = new Intent(LupaPasswordSuccessActivity.this, LoginActivity.class);

                fromLupaPasswordToLogin.putExtra("nama", dataNama);
                fromLupaPasswordToLogin.putExtra("email", dataEmail);
                fromLupaPasswordToLogin.putExtra("password", dataPassword);

                startActivity(fromLupaPasswordToLogin);
                finishAffinity();
            }
        });
    }
}