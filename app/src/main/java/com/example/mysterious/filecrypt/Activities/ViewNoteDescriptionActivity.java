package com.example.mysterious.filecrypt.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mysterious.filecrypt.Extras.DatabaseOperations;
import com.example.mysterious.filecrypt.R;

import java.util.ArrayList;

public class ViewNoteDescriptionActivity extends AppCompatActivity {

    DatabaseOperations dbobj;
    String notetitle,notecontent,notedate;
    TextView tvTitle,tvContent,tvDate;
    ImageView btnEditNote,btnDeleteNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewnotedescription);

        tvTitle = (TextView)findViewById(R.id.tvTitle);
        tvContent = (TextView)findViewById(R.id.tvContent);
        tvDate = (TextView)findViewById(R.id.tvDate);
        dbobj = new DatabaseOperations(this);

        Intent incomingintent = this.getIntent();
        Bundle bd = incomingintent.getBundleExtra("IdPassed");

        String Id = bd.getString("noteid");
        Integer noteid = Integer.parseInt(Id);

        ArrayList noteinfo = dbobj.ReadNote(noteid);
        if(noteinfo.size()>0)
        {
            notetitle = noteinfo.get(1).toString();
            notecontent = noteinfo.get(2).toString();
            notedate = noteinfo.get(3).toString();
        }

        tvTitle.setText(notetitle);
        tvContent.setText(notecontent);
        tvDate.setText(notedate);

    }
}
