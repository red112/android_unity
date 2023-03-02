package com.red.useaarlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.red.myaarlibadd.LibAdd;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Member function of an Instance
        LibAdd _adder = new LibAdd();
        int result = _adder.AddInt(2,4);
        Log.d("RED", "onCreate: Member Add result = " + result);

        //Static function
        result = LibAdd.AddIntStatic(3,6);
        Log.d("RED", "onCreate: Static Add result = " + result);
    }
}