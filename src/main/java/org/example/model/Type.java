package org.example.model;

public enum Type {
    MIXED,ROSES,LILIES,DAISIES,TULIPS,ANY;

    public String toString() {
        switch(this) {
            case MIXED: return "Mixed";
            case ROSES: return "Roses";
            case LILIES: return "Lilies";
            case DAISIES: return "Daisies";
            case TULIPS: return "Tulips";
            default: throw new IllegalArgumentException();
        }
    }
}
