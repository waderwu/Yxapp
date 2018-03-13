package com.example.yxapp;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.example.yxapp.Translate;

/**
 * Created by waderwu on 18-3-9.
 */

public class WebAppInterface {
    Context mContext;
    Translate translate;

    WebAppInterface(Context c){
        mContext = c;
        translate = new Translate(c);
    }

    @JavascriptInterface
    public void showToast(String toast){
        if (toast.length() > 0){
            Log.i("word",toast);
            Toast.makeText(mContext,translate.getTraslation(toast),Toast.LENGTH_SHORT).show();
        }
        return;

    }
}