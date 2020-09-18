package com.example.bakingapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeModel {
    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;
    @SerializedName("ingredients")
    public List<IngredientModel> ingredients = null;
    @SerializedName("steps")
    public List<StepModel> steps = null;
    @SerializedName("servings")
    public String servings;
    @SerializedName("image")
    public String image;
}