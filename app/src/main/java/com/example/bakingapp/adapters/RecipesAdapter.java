package com.example.bakingapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakingapp.R;
import com.example.bakingapp.model.RecipeModel;

import java.util.List;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {
    Context mContext;
    RecyclerView mRecyclerView;
    List<RecipeModel> mRecipes;
    boolean mTwoPane;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View itemView;
        public TextView name;
        public TextView servings;
        public ImageView image;
        public int id;

        public ViewHolder(View view) {
            super(view);
            itemView = view;
            name = itemView.findViewById(R.id.id_text);
            servings = itemView.findViewById(R.id.content);
        }
    }

    public RecipesAdapter(Context context, List<RecipeModel> recipes, RecyclerView rv, boolean twoPane) {
        super();
        mRecipes = recipes;
        mContext = context;
        mRecyclerView = rv;
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));
    }

    @Override
    public int getItemCount() {
        return mRecipes == null ? 0 : mRecipes.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View recipeView = inflater.inflate(R.layout.recipe_list_item, parent, false);
        return new ViewHolder(recipeView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RecipeModel recipe = mRecipes.get(position);
        System.out.println("found recipe!");
        System.out.println(recipe);
        holder.name.setText(recipe.name);
        holder.servings.setText(recipe.servings);
        holder.itemView.setTag(mRecipes.get(position));
    }
}
