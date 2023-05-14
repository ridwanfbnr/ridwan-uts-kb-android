package com.ridwanfbnr.ridwan_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.ridwanfbnr.ridwan_uts.databinding.ActivityLupaPasswordBinding;

public class LupaPasswordActivity extends AppCompatActivity {

    ActivityLupaPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLupaPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent dataLupaPassword = getIntent();
        String dataNama = dataLupaPassword.getStringExtra("nama");
        String dataEmail = dataLupaPassword.getStringExtra("email");
        String dataPassword = dataLupaPassword.getStringExtra("password");

        binding.btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = binding.edtNamaLupaPass.getText().toString().trim();
                String oldPassword = binding.edtOldPassword.getText().toString().trim();
                String newPassword = binding.edtNewPassword.getText().toString().trim();

                if (TextUtils.isEmpty(nama)) {
                    binding.edtNamaLupaPass.setError("Nama harus di isi!");
                } else if (TextUtils.isEmpty(oldPassword)) {
                    binding.edtOldPassword.setError("Old Password harus di isi!");
                } else if (TextUtils.isEmpty(newPassword)) {
                    binding.edtNewPassword.setError("New Password harus di isi!");
                } else  {
                    if (TextUtils.equals(newPassword, dataPassword)) {
                        Toast.makeText(LupaPasswordActivity.this, "Old Password dan New Password tidak boleh sama!", Toast.LENGTH_LONG).show();
                    } else if (TextUtils.equals(nama, dataNama) && TextUtils.equals(oldPassword, dataPassword)) {
                        Intent fromLupaToLupaSuccess = new Intent(LupaPasswordActivity.this, LupaPasswordSuccessActivity.class);

                        fromLupaToLupaSuccess.putExtra("nama", nama);
                        fromLupaToLupaSuccess.putExtra("email", dataEmail);
                        fromLupaToLupaSuccess.putExtra("password", newPassword);

                        startActivity(fromLupaToLupaSuccess);
                        finishAffinity();
                    } else {
                        Toast.makeText(LupaPasswordActivity.this, "Nama atau Old Password tidak sesuai!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        binding.tvLupaPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}