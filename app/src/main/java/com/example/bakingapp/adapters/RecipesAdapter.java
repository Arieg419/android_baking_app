package com.example.bakingapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakingapp.R;
import com.example.bakingapp.activities.RecipeDetailActivity;
import com.example.bakingapp.activities.RecipeListActivity;
import com.example.bakingapp.constants.RecipeDetailConstants;
import com.example.bakingapp.fragments.RecipeDetailFragment;
import com.example.bakingapp.model.RecipeModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {
    Context mContext;
    RecipeListActivity mParentActivity;
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

    public RecipesAdapter(RecipeListActivity parentActivity, Context context, List<RecipeModel> recipes, RecyclerView rv, boolean twoPane) {
        super();
        mParentActivity = parentActivity;
        mContext = context;
        mRecipes = recipes;
        mTwoPane = twoPane;
        mRecyclerView = rv;
        mRecyclerView.setHasFixedSize(true);
        if (mTwoPane) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(context, 1));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        }
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
        String recipeId = recipe.id;
        String recipeImage = recipe.image;
        String recipeName = recipe.name;
        String recipeServings = recipe.servings + " servings";
        holder.name.setText(recipeName);
        holder.servings.setText(recipeServings);
        if (recipeImage != null && !recipeImage.trim().isEmpty()) {
            Picasso.get().load(recipeImage).into(holder.image);
        }
        holder.itemView.setTag(recipe);
        holder.itemView.setOnClickListener(view -> {
            if (mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putString(RecipeDetailConstants.ID, recipeId);
                arguments.putString(RecipeDetailConstants.NAME, recipeName);
                arguments.putString(RecipeDetailConstants.SERVINGS, recipeServings);
                arguments.putString(RecipeDetailConstants.IMAGE, recipeImage);
                RecipeDetailFragment fragment = new RecipeDetailFragment();
                fragment.setArguments(arguments);
                System.out.println("Omer -> tablet detail setting fragment");
                mParentActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.item_detail_container, fragment)
                        .commit();
            } else {
                Context context = view.getContext();
                Intent intent = new Intent(context, RecipeDetailActivity.class);
                intent.putExtra(RecipeDetailConstants.ID, recipeId);
                intent.putExtra(RecipeDetailConstants.NAME, recipeName);
                intent.putExtra(RecipeDetailConstants.SERVINGS, recipeServings);
                intent.putExtra(RecipeDetailConstants.IMAGE, recipeImage);
                context.startActivity(intent);
            }
        });
    }
}
