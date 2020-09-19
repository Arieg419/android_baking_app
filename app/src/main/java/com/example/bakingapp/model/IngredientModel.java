package com.example.bakingapp.model;

import com.google.gson.annotations.SerializedName;

public class IngredientModel {
    @SerializedName("quantity")
    public Double quantity;
    @SerializedName("measure")
    public String measure;
    @SerializedName("ingredient")
    public String ingredient;
}
