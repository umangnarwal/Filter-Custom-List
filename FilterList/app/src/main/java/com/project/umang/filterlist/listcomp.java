package com.project.umang.filterlist;

/**
 * Created by UMANG on 3/12/2017.
 */

/**
 * Created by UMANG on 11/11/2016.
 */
public class listcomp {
    private String text;
    private String text2;
    private int id;
    // private Class cl;
    public listcomp(String x, String y,int id)
    {   this.id=id;
        text=x;
        text2=y;
        //  this.cl=cl;
    }
    public String gettext1()
    {
        return text;
    }
    public  String gettext2()
    {
        return text2;
    }
    public int getim(){return id;}
    // public Class getCl(){return cl;}

}
