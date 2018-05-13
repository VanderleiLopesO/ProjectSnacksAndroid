package tech.alvarez.pokedex.models;

import java.util.ArrayList;

/**
 * Created by Daniel Alvarez on 28/7/16.
 * Copyright © 2016 Alvarez.tech. All rights reserved.
 */
public class SnackResponse {

    private ArrayList<Snack> results;

    public ArrayList<Snack> getResults() {
        return results;
    }

    public void setResults(ArrayList<Snack> results) {
        this.results = results;
    }
}
