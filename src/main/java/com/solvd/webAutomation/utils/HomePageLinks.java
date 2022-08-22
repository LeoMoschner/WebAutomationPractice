package com.solvd.webAutomation.utils;

public enum HomePageLinks {
    LOGIN ("Form Authentication"),
    SHIFT_CONTENT ("Shifting Content"),
    FORGOT_PASSWORD ("Forgot Password"),
    HORIZONTAL_SLIDER ("Horizontal Slider"),
    CONTEXT_MENU("Context Menu");
    private String linkText;
    HomePageLinks(String linkText) {
        this.linkText = linkText;
    }
    public String getLinkText(){
        return this.linkText;
    }
}