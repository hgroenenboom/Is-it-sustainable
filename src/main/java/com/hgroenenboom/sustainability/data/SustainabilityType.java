package com.hgroenenboom.sustainability.data;

import java.util.ArrayList;

public enum SustainabilityType {
    Climate,
    Animals,
    People;

    public ArrayList<String> getTypes() {
        ArrayList<String> types = new ArrayList<>();
        for(SustainabilityType s : values())
            types.add(s.name());
        return types;
    }
}
