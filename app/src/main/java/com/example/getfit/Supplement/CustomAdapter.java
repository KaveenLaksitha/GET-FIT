package com.example.getfit.Supplement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getfit.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList sup_id, sup_name, sup_price, sup_description;




    CustomAdapter(Activity activity,Context context, ArrayList sup_id,
                  ArrayList sup_name, ArrayList sup_price,
                  ArrayList sup_description){

        this.activity = activity;
        this.context = context;
        this.sup_id = sup_id;
        this.sup_name = sup_name;
        this.sup_price = sup_price;
        this.sup_description = sup_description;

    }


    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {


        holder.sup_id_txt.setText((String.valueOf(sup_id.get(position))));
        holder.sup_name_txt.setText((String.valueOf(sup_name.get(position))));
        holder.sup_price_txt.setText((String.valueOf(sup_price.get(position))));
        holder.sup_description_txt.setText((String.valueOf(sup_description.get(position))));
        holder.mainLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateSupplement.class);
                intent.putExtra("id",String.valueOf(sup_id.get(position)));
                intent.putExtra("name",String.valueOf(sup_name.get(position)));
                intent.putExtra("price",String.valueOf(sup_price.get(position)));
                intent.putExtra("description",String.valueOf(sup_description.get(position)));
                activity.startActivityForResult(intent, 1);

            }
        });



    }

    @Override
    public int getItemCount()
    {
        return sup_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView sup_id_txt, sup_name_txt, sup_price_txt, sup_description_txt;
        LinearLayout mainLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sup_id_txt = itemView.findViewById(R.id.sup_id_txt);

            sup_price_txt = itemView.findViewById(R.id.sup_Price_txt);

            mainLayout = itemView.findViewById(R.id.mainLayout);



        }
    }
}

