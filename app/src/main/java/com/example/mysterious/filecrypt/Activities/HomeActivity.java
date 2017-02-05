package com.example.mysterious.filecrypt.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;

import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mysterious.filecrypt.Adapters.NavDrawAdapter;
import com.example.mysterious.filecrypt.Models.NavDrawItemModel;
import com.example.mysterious.filecrypt.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {


    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    String[] titles = {"About App","Feedback","Settings","The Team","Contact Us"};
    private CharSequence mTitle;
    private CharSequence mDrawerTitle;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar topToolBar;

    private com.getbase.floatingactionbutton.FloatingActionButton fab_files,fab_notes,fab_todo;
    private com.getbase.floatingactionbutton.FloatingActionButton RateApp;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = this;

        fab_files = (com.getbase.floatingactionbutton.FloatingActionButton)findViewById(R.id.fab_files);
        fab_files.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, AddToVaultActivity.class);
                startActivity(intent);
            }
        });

        fab_notes = (com.getbase.floatingactionbutton.FloatingActionButton)findViewById(R.id.fab_notes);
        fab_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CreateNoteActivity.class);
                startActivity(intent);
            }
        });

        fab_todo = (com.getbase.floatingactionbutton.FloatingActionButton)findViewById(R.id.fab_todo);
        fab_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CreateTodoActivity.class);
                startActivity(intent);
            }
        });

        RateApp = (com.getbase.floatingactionbutton.FloatingActionButton)findViewById(R.id.RateApp);
        RateApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog db = new Dialog(context);
                db.setContentView(R.layout.dialograteapp);
                db.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                db.show();
            }
        });

        mTitle = mDrawerTitle = getTitle();

        topToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);
        //topToolBar.setLogo(R.drawable.imagetwo);
        topToolBar.setLogoDescription("File Crypt");

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        List<NavDrawItemModel> listViewItems = new ArrayList<NavDrawItemModel>();
        listViewItems.add(new NavDrawItemModel("About App", R.drawable.ic_info_black_24dp));
        listViewItems.add(new NavDrawItemModel("Feedback", R.drawable.ic_feedback_black_24dp));
        listViewItems.add(new NavDrawItemModel("Settings", R.drawable.ic_settings_black_24dp));
        listViewItems.add(new NavDrawItemModel("The Team", R.drawable.ic_group_work_black_24dp));
        listViewItems.add(new NavDrawItemModel("Contact Us", R.drawable.ic_settings_phone_black_24dp));


        mDrawerList.setAdapter(new NavDrawAdapter(this, listViewItems));

        mDrawerToggle = new ActionBarDrawerToggle(HomeActivity.this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.setDrawerIndicatorEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View vw, int position, long id) {

                selectOptionFromNav(position);
            }
        });

    }


    private void selectOptionFromNav(int position){


        switch(position) {
            case 0:
                startActivity(new Intent(this,WelcomeActivity.class));
                break;
            case 1:
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                String uriText = "mailto:" + Uri.encode("abcdef@gmail.com") + "?subject=" + Uri.encode("Reporting A Bug/Feedback") + "&body=" + Uri.encode("Hello, \nI want to report a bug/give feedback corresponding to the app FileCrypt App.\n.....\n\n-Your name");
                Uri uri = Uri.parse(uriText);
                intent.setData(uri);
                startActivity(Intent.createChooser(intent, "Send Email"));
                break;
            case 2:
                startActivity(new Intent(this,SettingsActivity.class));
                break;
            case 3:
                startActivity(new Intent(this,TeamActivity.class));
                break;
            case 4:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setTitle("Contact Us");
                alertDialog.setMessage("\nReach us at : \n\n\nContact No. : 9898xxxxxx \n\n\nEmail Id : abcdef@gmail.com\n\n");
                alertDialog.setIcon(android.R.drawable.sym_contact_card);
                alertDialog.show();
                break;

        }


        mDrawerList.setItemChecked(position, true);
        setTitle(titles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(this,SettingsActivity.class));
            return true;
        }

        if (id == R.id.lock){
            Intent intent = new Intent(this,CheckInActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        if (id == R.id.exit){

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("Exit App");
            alertDialog.setMessage("Are you sure you want to exit ?");
            alertDialog.setIcon(android.R.drawable.ic_menu_close_clear_cancel);
            alertDialog.setPositiveButton("Leave", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }

            });
            alertDialog.setNegativeButton("Stay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialog.show();
            return true;
        }

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Notes(View view)
    {
        Intent intent = new Intent(HomeActivity.this,ViewNotesActivity.class);
        startActivity(intent);
    }

    public void Todo(View view)
    {
        Intent intent = new Intent(HomeActivity.this,ViewTodoActivity.class);
        startActivity(intent);
    }

    public void Vault(View view)
    {
        Intent intent = new Intent(HomeActivity.this,VaultActivity.class);
        startActivity(intent);
    }


}
