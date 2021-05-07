package com.example.getfit.Supplement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getfit.R;

import java.util.ArrayList;

public class SupplementAdapter extends RecyclerView.Adapter<SupplementAdapter.SupplementViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList sup_id, sup_name, sup_price, sup_description;



    public SupplementAdapter(Activity activity,Context context, ArrayList sup_id,
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
    public SupplementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.supplement_recycler, parent, false);
        return new SupplementViewHolder(view);


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull SupplementViewHolder holder, int position) {


        // holder.sup_id_txt.setText((String.valueOf(sup_id.get(position))));
        holder.supplementName.setText((String.valueOf(sup_name.get(position))));
        holder.supplementPrice.setText((String.valueOf(sup_price.get(position))));
        //holder.sup_Description_txt.setText((String.valueOf(sup_description.get(position))));
        holder.mainLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SupplementDetailsView.class);

                Log.d("id<<<<<<<<<<<<<",String.valueOf(sup_id.get(position)));
                Log.d("sup_name<<<<<<<<<<<<<",String.valueOf(sup_name.get(position)));
                Log.d("sup_price<<<<<<<<<<<<<",String.valueOf(sup_price.get(position)));
                Log.d("sup_description<<<<<",String.valueOf(sup_description.get(position)));

                intent.putExtra("id",String.valueOf(sup_id.get(position)));
                intent.putExtra("name",String.valueOf(sup_name.get(position)));
                intent.putExtra("price",String.valueOf(sup_price.get(position)));
                intent.putExtra("description",String.valueOf(sup_description.get(position)));
                //intent.putExtra("image",String.valueOf(sup_image.get(position)));
                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount()
    {
        return sup_id.size();
    }

    public class SupplementViewHolder extends RecyclerView.ViewHolder{

        TextView supplementId, supplementName, supplementPrice;
        LinearLayout mainLayout;


        public SupplementViewHolder(@NonNull View itemView) {
            super(itemView);

            supplementId = itemView.findViewById(R.id.supplementId);

            supplementName = itemView.findViewById(R.id.supplementName);

            supplementPrice = itemView.findViewById(R.id.supplementPrice);

            mainLayout = itemView.findViewById(R.id.supplementLayout);

        }
    }
}

