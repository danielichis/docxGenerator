package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDetails {
    public static HashMap<String, String> userDetails = new HashMap<String, String>();
    public static List<String>  createUsers=new ArrayList<>();
    public static String tipoCuenta="";
    public static String documento="";

    public String getUserDetails(String key) {
        return this.userDetails.get(key);
    }
    public void setUserDetails(String key, String value) {
        this.userDetails.put(key,value);
    }
    public void clearUserDetails(){ this.userDetails.clear(); }

    public List<String> getCreateUsers (){ return this.createUsers; }
    public void setCreateUsers (String values){  this.createUsers.add(values); }
    public void clearCreateUsers (){ this.createUsers.clear(); }





}
