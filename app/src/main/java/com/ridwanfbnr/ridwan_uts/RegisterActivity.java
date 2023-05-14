package com.ridwanfbnr.ridwan_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.ridwanfbnr.ridwan_uts.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegisterRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = binding.edtNamaRegister.getText().toString().trim();
                String email = binding.edtEmailRegister.getText().toString().trim();
                String password = binding.edtPasswordRegister.getText().toString().trim();

                if (TextUtils.isEmpty(nama)) {
                    binding.edtNamaRegister.setError("Nama harus diisi!");
                } else if (TextUtils.isEmpty(email)) {
                    binding.edtEmailRegister.setError("Email harus diisi!");
                } else if (TextUtils.isEmpty(password)) {
                    binding.edtPasswordRegister.setError("Password harus diisi!");
                } else {
                    Intent registerSuccess = new Intent(RegisterActivity.this, RegisterSuccessActivity.class);

                    registerSuccess.putExtra("nama", nama.toLowerCase());
                    registerSuccess.putExtra("email", email);
                    registerSuccess.putExtra("password", password);

                    startActivity(registerSuccess);
                    finishAffinity();
                }
            }
        });

        binding.tvPunyaAkunRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}