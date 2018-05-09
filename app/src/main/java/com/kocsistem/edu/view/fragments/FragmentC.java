package com.kocsistem.edu.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kocsistem.edu.R;

/**
 * Created by umutboz on 09,May,2018
 */
public class FragmentC extends MainFragment {
    public FragmentC()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragmentc_layout,container ,false);
        return view;
    }
    @Override
    public String getTitle() {
        return "THREE";
    }
}
