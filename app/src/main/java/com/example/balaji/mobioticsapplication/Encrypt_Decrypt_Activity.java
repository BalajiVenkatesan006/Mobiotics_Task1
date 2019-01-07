package com.example.balaji.mobioticsapplication;

import android.content.Intent;
import android.media.ExifInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Encrypt_Decrypt_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt__decrypt_);
        final EditText charsequence = (EditText) findViewById(R.id.txt_entered);
        final TextView displaytext =(TextView)findViewById(R.id.txt_result);
        final Button submit_button = (Button)findViewById(R.id.submit_btn);
        submit_button.setEnabled(false);
        charsequence.addTextChangedListener(new TextWatcher()
        {
            public void afterTextChanged(Editable s){

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                displaytext.setText("");
                if(s.length() > 0) {
                    submit_button.setEnabled(true);
                }
                else {
                    submit_button.setEnabled(false);
                }
            }
        });
    }

    public  String encrypt(String s){
        String Result="";
        int count=1;
        char check=s.charAt(0);
        for(int i=1;i<s.length();i++) {
            char c =s.charAt(i);
            if(check==c) {
                count++;
            }
            else {
                Result+=""+check;
                Result+=""+count;
                check=c;
                count=1;
            }
        }
        Result+=""+check;
        Result+=""+count;
        return Result;
    }

    public  String decrypt(String s){
        String Result="";
        char c =s.charAt(0);
        int count=0;
        for(int i=1;i<s.length();i+=2) {
            if(i!=s.length())
                count= Integer.parseInt(""+s.charAt(i));
            for(int j=0;j<count;j++) {
                Result+=""+c;
            }
            if(i!=s.length()-1) {
                c=s.charAt(i+1);
            }

        }
        return Result;

    }
    public  void onclick_submit(View view){
        Intent intent = getIntent();
        Bundle action = intent.getExtras();
        final TextView charsequence = (TextView)findViewById(R.id.txt_entered);
        final TextView displaytext =(TextView)findViewById(R.id.txt_result);
        String resultantString="";
        try {
            if (((String) action.get("Action")).equals("Encryption")) {
                resultantString = encrypt(charsequence.getText().toString());
            } else {
                resultantString = decrypt(charsequence.getText().toString());
            }
            displaytext.setText(resultantString);
        }
        catch (Exception e){
            Toast.makeText(this,"Invalid Encrypted String",Toast.LENGTH_SHORT).show();
        }
    }
}
