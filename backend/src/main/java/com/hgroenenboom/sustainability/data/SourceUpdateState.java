package com.hgroenenboom.sustainability.data;

import java.util.ArrayList;

public enum SourceUpdateState {
    PENDING,
    APPROVED,
    DENIED;

    public ArrayList<String> getStateTypes() {
        ArrayList<String> types = new ArrayList<>();
        for(SourceUpdateState s : SourceUpdateState.values())
            types.add(s.name());
        return types;
    }
}
