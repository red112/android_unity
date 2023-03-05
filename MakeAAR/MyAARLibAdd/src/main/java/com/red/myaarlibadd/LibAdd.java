package com.red.myaarlibadd;

import android.app.Activity;
import android.widget.Toast;

public class LibAdd {
    private static Activity unityActivity;
    public  static void receiveUnityActivity(Activity tActivity){
        unityActivity = tActivity;
    }

    //
    public LibAdd(){

    }

    public int AddInt(int val1, int val2){
        return val1+val2;
    }

    public static int AddIntStatic(int val1, int val2) {
        return val1+val2;
    }
    public void Toast(String msg) {
        Toast.makeText(unityActivity, msg, Toast.LENGTH_SHORT).show();
    }
}
