package com.ridwanfbnr.ridwan_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ridwanfbnr.ridwan_uts.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent getAllData = getIntent();
        String dataNama = getAllData.getStringExtra("nama");
        String dataEmail = getAllData.getStringExtra("email");
        String dataPassword = getAllData.getStringExtra("password");

        binding.tvDataNama.setText("Nama: " + dataNama);
        binding.tvDataEmail.setText("Email: " + dataEmail);
        binding.tvDataPassword.setText("Password: " + dataPassword);

        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToLogin = new Intent(MainActivity.this, LoginActivity.class);

                backToLogin.putExtra("nama", dataNama);
                backToLogin.putExtra("email", dataEmail);
                backToLogin.putExtra("password", dataPassword);

                startActivity(backToLogin);
                finishAffinity();
            }
        });
    }
}