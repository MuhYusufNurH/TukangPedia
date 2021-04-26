package com.example.registerdanlogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;

    public static final String PREF NAME = "LOGIN";
    public static final String LOGIN = "IS LOGIN";
    public static final String NAME = "NAME";
    public static final String EMAIL = "EMAIL";


    public SessionManager(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSession(String name, String email){
        editor.putBoolean("LOGIN" , true);
        editor.putString("NAME", name);
        editor.putString(EMAIL, email);
        editor.apply();
    }
    public boolean isLoggin(){
        return sharedPreferences.getBoolean(LOGIN, false);
    }

    public void checkLogin(){
        if (!this.isLoggin()){
            Intent i = new Intent(context, LoginActivity.class);
            context.startActivity(i);
            ((HomeActivity)context).finish();
        }
    }

    public HashMap<String, String> GetUserDetail(){

        HashMap<String, String> user = new HashMap<>();
        user.put(NAME, sharedPreferences.getString(NAME, null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));

        return user
    }

    public void logout(){
        editor.clear();
        editor.commit();
        Intent i = new Intent(context, LoginActivity.class);
        context.startActivity(i);
        ((HomeActivity)context).finish();
    }
    public HashMap<String, String> getUserDetail() {
    }
}