package model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.SerializedName;

import java.net.URL;

public class Product {
    @SerializedName("data.first_name")
    private String first_name;
    @SerializedName("data.last_name")
    private String last_name;
    @SerializedName("data.email")
    private String email;
    @SerializedName("data.avatar")
    private String  avatar;
    @SerializedName("data.id")
    private int id;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Product (){}

    public Product(String first_name, String last_name){

        setFirst_name(first_name);
        setLast_name(last_name);

    }

    public Product(int id , String first_name, String last_name , String email , String avatar){
        setId(id);
        setAvatar(avatar);
        setEmail(email);
        setFirst_name(first_name);
        setLast_name(last_name);

    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
