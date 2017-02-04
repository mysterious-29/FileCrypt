package com.example.mysterious.filecrypt.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mysterious.filecrypt.R;

public class RegisterSetNameActivity extends AppCompatActivity {
    EditText tbName,tbEmail;
    ImageButton btnNext;
    ImageView imgSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registername);

        tbName = (EditText)findViewById(R.id.tbName);
        tbEmail = (EditText)findViewById(R.id.tbEmail);
        btnNext = (ImageButton)findViewById(R.id.btnNext);
        imgSelected = (ImageView)findViewById(R.id.imgSelected);

        SharedPreferences srpef = getSharedPreferences("UserInfo",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = srpef.edit();
        Integer pic = srpef.getInt("pic",1);
        if(pic==1)
            imgSelected.setImageResource(R.drawable.male);
        else if(pic==2)
            imgSelected.setImageResource(R.drawable.female);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("name", tbName.getText().toString());
                editor.putString("email",tbEmail.getText().toString());
                editor.commit();

                Toast.makeText(getApplicationContext(),"Name & Email Set", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),RegisterGenPassActivity.class);
                startActivity(intent);
            }
        });



    }
}
