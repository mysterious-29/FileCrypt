package com.example.mysterious.filecrypt.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mysterious.filecrypt.R;

import java.util.ArrayList;

/**
 * Created by jaykay12 on 4/2/17.
 */
public class NotesAdapter extends ArrayAdapter {
    ArrayList idlist,titlelist,contentlist;
    Context context;

    public NotesAdapter(Context context, ArrayList idlist, ArrayList titlelist,ArrayList contentlist) {
        super(context, R.layout.customlayout_notes,idlist);
        this.context = context;
        this.idlist = idlist;
        this.titlelist = titlelist;
        this.contentlist = contentlist;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customview = inflator.inflate(R.layout.customlayout_notes,null);

        TextView tvNoteId = (TextView)customview.findViewById(R.id.tvNoteId);
        tvNoteId.setText("Note Id:"+ idlist.get(position));

        TextView tvNoteTitle = (TextView)customview.findViewById(R.id.tvNoteTitle);
        tvNoteTitle.setText("Title:"+ titlelist.get(position));

        TextView tvNoteContent = (TextView)customview.findViewById(R.id.tvNoteContent);
        tvNoteContent.setText("Content:"+ contentlist.get(position));

        return customview;
    }
}