package com.example.api_cats;

import java.util.ArrayList;

public class CatResponse {
    private ArrayList<Cat> results;

    public ArrayList<Cat> getResult() {
        return results;
    }

    public void setResult(ArrayList<Cat> result) {
        this.results = result;
    }
}

