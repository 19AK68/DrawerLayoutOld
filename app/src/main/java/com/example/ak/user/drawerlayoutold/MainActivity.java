package com.example.ak.user.drawerlayoutold;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.example.ak.user.ExpandableList.MenuExpandableList;

public class MainActivity extends AppCompatActivity
{
    private static MenuExpandableList menuExpandableList;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (menuExpandableList==null)
        {
            menuExpandableList = new MenuExpandableList(this);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



}
