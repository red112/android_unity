package com.red.unitypluginaddtoast;

import android.content.Context;
import android.widget.Toast;

public class UnityPluginAARClass {

    // Instance
    private static UnityPluginAARClass m_instance;
    public static UnityPluginAARClass instance() {
        if(m_instance == null) {
            m_instance = new UnityPluginAARClass();
        }
        return m_instance;
    }

    // Context
    private Context context;
    public  void setContext(Context ct) {
        context = ct;
    }
    public void ShowToast(String msg, int length) {

        if( length == 0) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        }

    }
}
