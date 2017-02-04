package com.example.mysterious.filecrypt.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mysterious.filecrypt.R;

public class RegisterGenPassActivity extends AppCompatActivity {
    EditText tbPassword,tbConfirmPassword;
    Button btnStart;
    TextView tvWelcome;
    TextView tvNameSelected;
    TextView tvMessage;
    ImageView imgSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registergenpass);

        tbPassword = (EditText)findViewById(R.id.tbPassword);
        tbConfirmPassword = (EditText)findViewById(R.id.tbConfirmPassword);
        btnStart = (Button)findViewById(R.id.btnStart);
        tvNameSelected = (TextView)findViewById(R.id.tvNameSelected);
        imgSelected = (ImageView)findViewById(R.id.imgSelected);

        SharedPreferences spref = getSharedPreferences("UserInfo",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = spref.edit();
        String pic = spref.getString("pic","");
        if(pic.equals("male"))
            imgSelected.setImageResource(R.drawable.male);
        else if(pic.equals("female"))
            imgSelected.setImageResource(R.drawable.female);

        String Name = spref.getString("name","");
        tvNameSelected.setText(Name);


    }

    public void Start(View view)
    {
        String password1,password2;
        password1 = tbPassword.getText().toString();
        password2 = tbConfirmPassword.getText().toString();
        if(password1.equals(password2)) {
            SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("password",password1);

            editor.commit();

            Toast.makeText(getApplicationContext(),"Successful Registered",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"Both Password Entries Doesn't Match",Toast.LENGTH_LONG).show();
        }

    }



}
