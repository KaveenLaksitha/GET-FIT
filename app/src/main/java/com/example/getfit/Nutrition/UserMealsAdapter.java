package com.example.getfit.Nutrition;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getfit.R;

import java.util.ArrayList;

public class UserMealsAdapter extends RecyclerView.Adapter<UserMealsAdapter.MealsViewHolder> {

    private Context context;
    private ArrayList mealID,mealName;
    int position;

    UserMealsAdapter(Context context, ArrayList mealID, ArrayList mealName){

        this.context = context;
        this.mealID = mealID;
        this.mealName = mealName;

        }

    @NonNull
    @Override
    public MealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.activity_user_meals_recycler,parent,false);
        return  new MealsViewHolder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull MealsViewHolder holder, int position) {
        this.position = position;

        //holder.mealID.setText(String.valueOf(mealID.get(position)));
        holder.mealName.setText(String.valueOf(mealName.get(position)));
    }

    @Override
    public int getItemCount() {
        return mealID.size();
        }

    public class MealsViewHolder extends RecyclerView.ViewHolder {

        TextView mealID, mealName;

    public MealsViewHolder(@NonNull View itemView) {

        super(itemView);
        mealID = itemView.findViewById(R.id.user_viewMeal_Id);
        mealName = itemView.findViewById(R.id.user_viewMeal);
    }

}
}