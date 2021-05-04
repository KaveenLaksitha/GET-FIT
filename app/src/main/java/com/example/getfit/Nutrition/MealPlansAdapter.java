package com.example.getfit.Nutrition;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getfit.R;

import java.util.ArrayList;

public class MealPlansAdapter extends RecyclerView.Adapter<MealPlansAdapter.MealsViewHolder> {

    private Context context;
    private ArrayList mealID,mealName;
    int position;

    MealPlansAdapter(Context context, ArrayList mealID, ArrayList mealName){

        this.context = context;
        this.mealID = mealID;
        this.mealName = mealName;

    }

    @NonNull
    @Override
    public MealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.activity_meals_recycler,parent,false);
        return  new MealsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealPlansAdapter.MealsViewHolder holder, int position) {
        this.position = position;

        holder.mealID.setText(String.valueOf(mealID.get(position)));
        holder.mealName.setText(String.valueOf(mealName.get(position)));

        //show delete popup acivity
        holder.nutrition_button_deleteMeal.setOnClickListener((view) ->{
            //Log.d("clicked on id",String.valueOf(mealID.get(position)));

            Intent intent = new Intent(context,DeletePopUp.class);
            intent.putExtra("mealID",String.valueOf(mealID.get(position)));
            intent.putExtra("mealName",String.valueOf(mealName.get(position)));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mealID.size();
    }

    public class MealsViewHolder extends RecyclerView.ViewHolder {

        TextView mealID, mealName;
        Button nutrition_button_deleteMeal;

        public MealsViewHolder(@NonNull View itemView) {

            super(itemView);
            mealID = itemView.findViewById(R.id.R_mealID);
            mealName = itemView.findViewById(R.id.R_mealName);
            nutrition_button_deleteMeal = itemView.findViewById(R.id.nutrition_button_deleteMeal);
        }

    }
}
