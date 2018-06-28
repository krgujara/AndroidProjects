package com.example.android.fragments;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TopSectionFragment extends Fragment{
    EditText ed1, ed2;
    Button b1;


    TopSectionListener tsl;
    public interface TopSectionListener{
        public void transferData(String top,String bottom);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            tsl=(TopSectionListener)activity;
        }catch (ClassCastException e) {
            throw new ClassCastException(activity.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.activity_top_section_fragment,container,false);
        ed1=(EditText)view.findViewById(R.id.editText1);
        ed2=(EditText)view.findViewById(R.id.editText2);
        b1=(Button)view.findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                        tsl.transferData(ed1.getText().toString(),ed2.getText().toString());
                                  }
                              }
        );
        return view;
    }
}
