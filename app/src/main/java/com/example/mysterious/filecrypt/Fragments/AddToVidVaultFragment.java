package com.example.mysterious.filecrypt.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mysterious.filecrypt.R;

/**
 * Created by mysterious on 4/2/17.
 */
public class AddToVidVaultFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_addvidtovault, container, false);

    }
}
