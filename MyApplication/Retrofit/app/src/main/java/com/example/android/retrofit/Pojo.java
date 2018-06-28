package com.example.android.retrofit;


import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Pojo {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("pasword")
    @Expose
    private String pasword;

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The pasword
     */
    public String getPasword() {
        return pasword;
    }

    /**
     * @param pasword The pasword
     */
    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

}