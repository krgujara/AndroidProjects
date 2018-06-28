package com.example.android.laundarysystem.Networking.dto;
public class UserDetails {
    public String name, pasword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDetails(String name,String pasword) {

        this.name = name;
        this.pasword = pasword;
    }


    public String getPasword() {

        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    @Override
    public String toString() {
        return "FeedObjects [name=" + name + ", pasword=" + pasword + "]";
    }


}
