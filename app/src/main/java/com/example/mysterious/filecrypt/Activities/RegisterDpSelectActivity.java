package com.example.mysterious.filecrypt.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.mysterious.filecrypt.Extras.PrefManager;
import com.example.mysterious.filecrypt.R;

public class RegisterDpSelectActivity extends AppCompatActivity {

    ImageButton male,female;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        male = (ImageButton)findViewById(R.id.dpmale);
        female = (ImageButton)findViewById(R.id.dpfemale);


        prefManager = new PrefManager(this);

        Log.v("check##",prefManager.isFirstTimeLaunch()+"");

        if (!prefManager.isFirstTimeLaunch()) {


            launchHomeScreen();
            finish();
        }else{
            prefManager.setFirstTimeLaunch(false);
        }

        setContentView(R.layout.activity_registerdpselect);



    }

    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(RegisterDpSelectActivity.this, CheckInActivity.class));
        finish();
    }

    public void Male(View view)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("pic","male");
        editor.commit();

        Intent intent = new Intent(this,RegisterSetNameActivity.class);
        startActivity(intent);

    }

    public void Female(View view)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("pic","female");
        editor.commit();

        Intent intent = new Intent(this,RegisterSetNameActivity.class);
        startActivity(intent);
    }

}
