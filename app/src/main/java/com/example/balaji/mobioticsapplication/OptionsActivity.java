package com.example.balaji.mobioticsapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    public void onclick_encrypt(View view){
        Intent intent = new Intent(this,Encrypt_Decrypt_Activity.class);
        intent.putExtra("Action","Encryption");
        startActivity(intent);
    }

    public void onclick_decrypt(View view){
        Intent intent = new Intent(this,Encrypt_Decrypt_Activity.class);
        intent.putExtra("Action","Decryption");
        startActivity(intent);
    }
}
