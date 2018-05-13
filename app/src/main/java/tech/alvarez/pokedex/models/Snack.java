package tech.alvarez.pokedex.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Alvarez on 28/7/16.
 * Copyright © 2016 Alvarez.tech. All rights reserved.
 */
public class Snack {

        @SerializedName("id")
        @Expose
        protected String id;
        @SerializedName("name")
        @Expose
        protected String name;
        @SerializedName("ingredients")
        @Expose
        protected ArrayList<String> ingredients;
        @SerializedName("image")
        @Expose
        protected String image;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<String> getIngredients() {
            return ingredients;
        }

        public void setIngredients(ArrayList<String> ingredients) {
            this.ingredients = ingredients;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

}
