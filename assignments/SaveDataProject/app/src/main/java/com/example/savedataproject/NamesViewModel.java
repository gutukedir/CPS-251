package com.example.savedataproject;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class NamesViewModel extends ViewModel {

    private final List<String> savedNames = new ArrayList<>();

    public void addName(String name) {
        savedNames.add(name);
    }

    public List<String> getSavedNames() {
        return savedNames;
    }
}
