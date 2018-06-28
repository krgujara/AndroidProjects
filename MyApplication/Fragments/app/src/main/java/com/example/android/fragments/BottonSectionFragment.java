package com.example.android.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BottonSectionFragment extends Fragment {

    TextView tv1 , tv2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_botton_section_fragment,container,false);
        tv1=(TextView)view.findViewById(R.id.tv1);
        tv2=(TextView)view.findViewById(R.id.tv2);

        return view;
    }


    public void setValues(String top, String bottom){
        tv1.setText(top);
        tv2.setText(bottom);
    }

}
