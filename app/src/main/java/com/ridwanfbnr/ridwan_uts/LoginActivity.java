package com.ridwanfbnr.ridwan_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.ridwanfbnr.ridwan_uts.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent getDataRegisterFromSuccess = getIntent();
        String dataRegisterNama = getDataRegisterFromSuccess.getStringExtra("nama");
        String dataRegisterEmail = getDataRegisterFromSuccess.getStringExtra("email");
        String dataRegisterPassword = getDataRegisterFromSuccess.getStringExtra("password");

        binding.btnLoginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = binding.edtNamaLogin.getText().toString().trim();
                String password = binding.edtPasswordLogin.getText().toString().trim();

                if (TextUtils.isEmpty(nama)) {
                    binding.edtNamaLogin.setError("Nama harus di isi!");
                } else if (TextUtils.isEmpty(password)) {
                    binding.edtPasswordLogin.setError("Password harus di isi!");
                } else {
                    if (TextUtils.equals(nama, dataRegisterNama) && TextUtils.equals(password, dataRegisterPassword)) {
                        Intent login = new Intent(LoginActivity.this, MainActivity.class);

                        login.putExtra("nama", dataRegisterNama);
                        login.putExtra("email", dataRegisterEmail);
                        login.putExtra("password", dataRegisterPassword);

                        startActivity(login);
                        finishAffinity();
                    } else {
                        Toast.makeText(LoginActivity.this, "Nama atau Password tidak sesuai!\nSilahkan Register atau lupa password", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        binding.btnRegisterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toRegister = new Intent(LoginActivity.this, RegisterActivity.class);

                startActivity(toRegister);
            }
        });

        binding.tvLupaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toLupaPassword = new Intent(LoginActivity.this, LupaPasswordActivity.class);

                toLupaPassword.putExtra("nama", dataRegisterNama);
                toLupaPassword.putExtra("email", dataRegisterEmail);
                toLupaPassword.putExtra("password", dataRegisterPassword);

                startActivity(toLupaPassword);
            }
        });
    }
}