package com.example.bakingapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipesModel {
    @SerializedName("recipes")
    public List<RecipeModel> recipes = null;
}
