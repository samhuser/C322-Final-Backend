package org.example.model;

public enum Occasion {
    BIRTHDAY,MOTHERSDAY,THANKYOU, ANY;

    public String toString(){
        switch(this){
            case BIRTHDAY:
                return "Birthday";
            case MOTHERSDAY:
                return "Mother's Day";
            case THANKYOU:
                return "Thank You";
            default:
                return "Unspecified";
        }
    }
}
