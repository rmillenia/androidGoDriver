package com.example.meli.projectdriver.adapter;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceDriver {
    public static final String SP_Driver_APP = "spDApp";
    public static final String SP_ID = "spId";
    public static final String SP_NAMA = "spNama";
    public static final String SP_EMAIL = "spEmail";
    public static final String SP_LEVEL = "spLevel";
    public static final String SP_ID_DRIVER = "spIdUser";

    public static final String SP_SUDAH_LOGIN = "spSudahLogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPreferenceDriver(Context context){
        sp = context.getSharedPreferences(SP_Driver_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSPNama(){
        return sp.getString(SP_NAMA, "");
    }

    public String getSPEmail(){
        return sp.getString(SP_EMAIL, "");
    }

    public int getSPId(){
        return sp.getInt(SP_ID,0);
    }

    public String getSPLevel(){
        return sp.getString(SP_LEVEL, "");
    }

    public String getSPIdDriver(){
        return sp.getString(SP_ID_DRIVER, "");
    }

    public Boolean getSPSudahLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }

    public void deleteIdUser(Context context,String keySP){
        SharedPreferences settings = context.getSharedPreferences(SP_Driver_APP, Context.MODE_PRIVATE);
        settings.edit().remove(keySP).commit();
    }

    public void clearSharedPreference(Context context){
        SharedPreferences settings = context.getSharedPreferences(SP_Driver_APP, Context.MODE_PRIVATE);
        settings.edit().clear().commit();
    }
}
