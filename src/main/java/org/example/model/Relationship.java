package org.example.model;

public enum Relationship {
    SPOUSE, PARENT, CHILD, FRIEND, GIRLFRIEND, BOYFRIEND, SIBLING;

    public String toString() {
        switch (this) {
            case SPOUSE:
                return "Spouse";
            case PARENT:
                return "Parent";
            case CHILD:
                return "Child";
            case FRIEND:
                return "Friend";
            case GIRLFRIEND:
                return "Girlfriend";
            case BOYFRIEND:
                return "Boyfriend";
            case SIBLING:
                return "Sibling";
            default:
                throw new IllegalArgumentException();
        }
    }
}
