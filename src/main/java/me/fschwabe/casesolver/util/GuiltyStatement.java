package me.fschwabe.casesolver.util;

import me.fschwabe.casesolver.Suspect;

public class GuiltyStatement {

    private final Suspect suspect;
    private final boolean isSuspectGuilty;

    public GuiltyStatement(Suspect suspect, boolean isSuspectGuilty) {
        this.suspect = suspect;
        this.isSuspectGuilty = isSuspectGuilty;
    }

    public Suspect getSuspect() {
        return suspect;
    }

    public boolean isSuspectGuilty() {
        return isSuspectGuilty;
    }
}
