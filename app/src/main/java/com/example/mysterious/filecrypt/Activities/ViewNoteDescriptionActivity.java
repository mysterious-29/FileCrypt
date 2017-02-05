package com.example.mysterious.filecrypt.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mysterious.filecrypt.R;

public class ViewNoteDescriptionActivity extends AppCompatActivity {

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewnotedescription);

        tvResult = (TextView)findViewById(R.id.tvResult);

        Intent incomingintent = this.getIntent();
        Bundle bd = incomingintent.getBundleExtra("IdPassed");

        String Id = bd.getString("noteid");
        tvResult.setText(Id);
    }
}
