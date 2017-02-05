package com.example.mysterious.filecrypt.Activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mysterious.filecrypt.Adapters.NotesAdapter;
import com.example.mysterious.filecrypt.Extras.DatabaseOperations;
import com.example.mysterious.filecrypt.R;

import java.util.ArrayList;

public class ViewNotesActivity extends AppCompatActivity {

    DatabaseOperations dbobj;
    Context context;
    ListView lvMain;
    ArrayList idlist,titlelist,contentlist,datelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewnotes);
        lvMain = (ListView)findViewById(R.id.lvMain);
        idlist = new ArrayList();
        titlelist = new ArrayList();
        contentlist = new ArrayList();
        datelist = new ArrayList();

        context = this;
        dbobj = new DatabaseOperations(context);

        /*idlist.add("12");
        titlelist.add("Jalaz");
        contentlist.add("NIT hamirpur");*/

        Cursor cr = dbobj.ReadAll();
        while(cr.moveToNext())
        {
            idlist.add(cr.getString(0));
            titlelist.add(cr.getString(1));
            contentlist.add(cr.getString(2));
            datelist.add(cr.getString(3));
        }

        NotesAdapter cd = new NotesAdapter(this,titlelist,datelist);
        //NotesAdapter cd = new NotesAdapter(this,idlist,titlelist,contentlist,datelist);
        lvMain.setAdapter(cd);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),ViewNoteDescriptionActivity.class);
                Bundle bd = new Bundle();

                bd.putString("noteid",""+idlist.get(position));
                intent.putExtra("IdPassed",bd);



                startActivity(intent);



            }
        });
    }

}
