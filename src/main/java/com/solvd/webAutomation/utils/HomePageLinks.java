package com.solvd.webAutomation.utils;

public enum HomePageLinks {
    LOGIN ("Form Authentication"),
    SHIFT_CONTENT ("Shifting Content");
    private String linkText;
    HomePageLinks(String linkText) {
        this.linkText = linkText;
    }
    public String getLinkText(){
        return this.linkText;
    }
}
