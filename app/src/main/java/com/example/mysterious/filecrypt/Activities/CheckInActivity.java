package com.example.mysterious.filecrypt.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mysterious.filecrypt.R;

public class CheckInActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    EditText tbInputPassword;
    Button btnGo;
    TextView tvNameSelected,tvForgotPassword,tvNotice;
    ImageView imgLockCondition;
    Integer counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);
        tbInputPassword = (EditText)findViewById(R.id.tbInputPassword);
        btnGo = (Button)findViewById(R.id.btnGo);
        tvNameSelected = (TextView)findViewById(R.id.tvNameSelected);
        imgLockCondition = (ImageView)findViewById(R.id.imgLockCondition);
        tvForgotPassword = (TextView)findViewById(R.id.tvForgotPassword);
        tvNotice = (TextView)findViewById(R.id.tvNotice);
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinatorLayout);

        SharedPreferences spref = getSharedPreferences("UserInfo",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = spref.edit();
        String Name = spref.getString("name", "");
        tvNameSelected.setText(Name);

        imgLockCondition.setImageResource(R.drawable.lock_closed_outline);
    }

    public void Go(View view)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        String userpassword = sharedPreferences.getString("password","");

        if(userpassword.equals(tbInputPassword.getText().toString()))
        {
            //Toast.makeText(this,"Loading your Account", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,HomeActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            counter++;
            if(counter<3)
            {
                imgLockCondition.setImageResource(R.drawable.lock_closed_black);
                Snackbar snackbar = Snackbar.make(coordinatorLayout,"Incorrect Password...!!!!",Snackbar.LENGTH_LONG);
                snackbar.show();
                //tvNotice.setText("Incorrect Password...!!!!");
            }
            else
            {
                btnGo.setEnabled(false);
                imgLockCondition.setImageResource(R.drawable.phonelink_lock_);
                Snackbar snackbar = Snackbar.make(coordinatorLayout,"Locker Locked...!!!",Snackbar.LENGTH_LONG);
                snackbar.show();
                //tvNotice.setText("Locker Locked...!!!");
            }
            tvForgotPassword.setTextColor(0xFFF06D2F);
        }
    }

    public void ForgotPassword(View view)
    {
        Intent intent = new Intent(this,ForgotPasswordActivity.class);
        startActivity(intent);
    }
}
