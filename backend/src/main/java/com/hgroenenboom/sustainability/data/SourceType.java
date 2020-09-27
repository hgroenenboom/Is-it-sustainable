package com.hgroenenboom.sustainability.data;

import java.util.ArrayList;

public enum SourceType {
    Paper,
    Newspaper,
    Article,
    Book,
    Website;

    public static ArrayList<String> getTypes() {
        ArrayList<String> types = new ArrayList<String>();
        for(SourceType t : SourceType.values())
            types.add(t.name());

        return types;
    }
}
