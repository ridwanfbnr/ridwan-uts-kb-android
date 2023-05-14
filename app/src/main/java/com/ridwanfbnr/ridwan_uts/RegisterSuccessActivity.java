package com.ridwanfbnr.ridwan_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.ridwanfbnr.ridwan_uts.databinding.ActivityRegisterSuccessBinding;

public class RegisterSuccessActivity extends AppCompatActivity {

    ActivityRegisterSuccessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterSuccessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent getDataRegister = getIntent();
        String dataRegisterNama = getDataRegister.getStringExtra("nama");
        String dataRegisterEmail = getDataRegister.getStringExtra("email");
        String dataRegisterPassword = getDataRegister.getStringExtra("password");

        binding.btnLoginRegisterSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent successToLogin = new Intent(RegisterSuccessActivity.this, LoginActivity.class);

                successToLogin.putExtra("nama", dataRegisterNama);
                successToLogin.putExtra("email", dataRegisterEmail);
                successToLogin.putExtra("password", dataRegisterPassword);

                startActivity(successToLogin);
                finishAffinity();
            }
        });
    }
}