package com.example.myapplication;

import android.widget.Toast;

public class Operations {
    static String sum(String str1, String str2){
        int n1,n2;
        if ( !str1.isEmpty()) {
            n1 = Integer.parseInt(str1);
        }
        else n1 = 0;
        if (!str2.isEmpty()) {
            n2 = Integer.parseInt(str2);
        }
        else n2 = 0;
        int result = n1 + n2;
        String strRes = "Result: " + Integer.toString(result);
        return strRes;
    }
}
