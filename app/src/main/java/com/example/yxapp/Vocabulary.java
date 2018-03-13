package com.example.yxapp;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

/**
 * Created by waderwu on 18-3-12.
 */

public class Vocabulary extends DataSupport{
    @Column(unique = true,defaultValue = "unknown")
    private String word;
    private String translate;


    public String getWord(){
        return word;
    }

}
