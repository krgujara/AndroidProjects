package com.example.android.customlistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.PublicKey;

public class Adapter extends ArrayAdapter<String> {

    //DECLARATOINS
    int[] imgs={};
    String[] team={};
    String[] names={};
    String[] goals={};
    Context c;
    LayoutInflater inflater;
   public Adapter(Context context, String[] names,String goals[],String team[], int[] imgs){
       super(context,R.layout.model,names);

       this.c=context;
       this.names=names;
       this.goals=goals;
       this.team=team;
       this.imgs=imgs;

   }

    //INNER CLASS SHALL HOLD OUR VIEWS FOR EACH ROW
    public class ViewHolder
    {
        TextView nameTv,teamTv,goalTv;
        ImageView img;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //same like setContentView
            convertView = inflater.inflate(R.layout.model,null);
        }

        //After creating view holder class, create view holder object
        final ViewHolder holder= new ViewHolder();

        //INITIALIZE
        holder.nameTv=(TextView) convertView.findViewById(R.id.nameTv);
        holder.teamTv=(TextView)convertView.findViewById(R.id.teamTv);
        holder.goalTv=(TextView)convertView.findViewById(R.id.goalsTv);
        holder.img = (ImageView)convertView.findViewById(R.id.imageView1);


        //ASSIGN DATA TO VIEWS
        holder.img.setImageResource(imgs[position]);
        holder.nameTv.setText(names[position]);
        holder.teamTv.setText(team[position]);
        holder.goalTv.setText("Goals : "+ goals[position]);

        //Return convert view
        return convertView;
    }
}
