package com.example.bakingapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakingapp.R;
import com.example.bakingapp.activities.RecipeDetailActivity;
import com.example.bakingapp.model.IngredientModel;

import java.util.ArrayList;

public class RecipeDetailIngredientsAdapter extends RecyclerView.Adapter<RecipeDetailIngredientsAdapter.ViewHolder> {
    Activity mParentActivity;
    Context mContext;
    ArrayList<IngredientModel> mIngredients;

    public RecipeDetailIngredientsAdapter(RecipeDetailActivity activity, Context context, ArrayList<IngredientModel> ingredientModels) {
        mParentActivity = activity;
        mContext = context;
        mIngredients = ingredientModels;
    }

    @NonNull
    @Override
    public RecipeDetailIngredientsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View ingredientRow = inflater.inflate(R.layout.recipe_detail_ingredient_row, parent, false);
        return new RecipeDetailIngredientsAdapter.ViewHolder(ingredientRow);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeDetailIngredientsAdapter.ViewHolder holder, int position) {
        IngredientModel ingredientModel = mIngredients.get(position);
        holder.name.setText(ingredientModel.getIngredient());
        holder.quantity.setText(ingredientModel.getQuantity() + " " + ingredientModel.getMeasure());
    }

    @Override
    public int getItemCount() {
        return mIngredients == null ? 0 : mIngredients .size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View itemView;
        public TextView name;
        public TextView quantity;

        public ViewHolder(View view) {
            super(view);
            itemView = view;
            name = itemView.findViewById(R.id.ingredient_name);
            quantity = itemView.findViewById(R.id.ingredient_quantity);
        }
    }
}
