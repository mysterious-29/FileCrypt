package com.example.mysterious.filecrypt.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mysterious.filecrypt.Extras.DatabaseOperations;
import com.example.mysterious.filecrypt.R;

public class CreateNoteActivity extends AppCompatActivity {

    Button btnSave;
    EditText tbNoteTitle;
    EditText tbNoteContent;
    EditText tbNoteId;
    DatabaseOperations dbobj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createnotes);

        tbNoteTitle = (EditText)findViewById(R.id.tbNoteTitle);
        tbNoteContent = (EditText)findViewById(R.id.tbNoteContent);
        btnSave = (Button)findViewById(R.id.btnSave);
        tbNoteId = (EditText)findViewById(R.id.tbNoteId);
        dbobj = new DatabaseOperations(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noteid, notetitle, notecontent;

                noteid = tbNoteId.getText().toString();
                notetitle = tbNoteTitle.getText().toString();
                notecontent = tbNoteContent.getText().toString();

                long result = dbobj.AddNotes(noteid, notetitle, notecontent);
                if (result > 0) {
                    Toast.makeText(getApplicationContext(), "Note Saved", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

}
