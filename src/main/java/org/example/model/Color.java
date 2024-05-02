package org.example.model;

public enum Color {
    MIXED,RED,YELLOW,GREEN,ORANGE, ANY;

    public String toString() {
        switch(this) {
            case MIXED: return "Mixed";
            case RED: return "Red";
            case YELLOW: return "Yellow";
            case GREEN: return "Green";
            case ORANGE: return "Orange";
            default: throw new IllegalArgumentException();
        }
    }
}
