package com.hgroenenboom.sustainability.data;

import java.util.ArrayList;

public enum State {
    PENDING,
    APPROVED,
    DENIED;

    public ArrayList<String> getStateTypes() {
        ArrayList<String> types = new ArrayList<>();
        for(State s : State.values())
            types.add(s.name());
        return types;
    }
}
