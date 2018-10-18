package com.example.ak.user.ExpandableList;

import android.app.Activity;


import android.app.FragmentTransaction;
import android.os.Bundle;

import android.app.Fragment;
import android.app.FragmentManager;

import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;


import com.example.ak.user.drawerlayoutold.ContentFragment;
import com.example.ak.user.drawerlayoutold.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuExpandableList   {

    private Activity context;

    private DrawerLayout navDrawer;

    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;

    private List<String> listGroup;
    private HashMap<String, List<String>> mapChild;
    ContentFragment contentFragment = new ContentFragment();


    public MenuExpandableList(final Activity context) {
        this.context = context;
        expListView = (ExpandableListView) context.findViewById(R.id.expLvMenu);
        navDrawer = (DrawerLayout) context.findViewById(R.id.drawer_layout);

        fillMenu();//

        listAdapter = new ExpandableListAdapter(context, listGroup, mapChild);

        expListView.setAdapter(listAdapter);




        expListView.setOnGroupClickListener(new OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {return false;}
        });


        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {}
        });



        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {}
        });


        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
//                ContentFragment fragment = new ContentFragment();
                Bundle args = new Bundle();
                args.putInt("TEST_CONTENT", childPosition);
                contentFragment.setArguments(args);

                FragmentTransaction fragmentTransaction = context.getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_frame,  contentFragment).commit();


                navDrawer.closeDrawer(Gravity.LEFT);
                return true;
            }
        });


    }

    private void fillMenu() {
        listGroup = new ArrayList<String>();
        mapChild = new HashMap<String, List<String>>();

        listGroup.add(context.getResources().getString(R.string.menu1));
        listGroup.add(context.getResources().getString(R.string.menu2));
        listGroup.add(context.getResources().getString(R.string.menu3));


        List<String> menu1 = new ArrayList<String>();
        for (String child : context.getResources().getStringArray(R.array.menu1_childs)) {
            menu1.add(child);
        }

        List<String> menu2 = new ArrayList<String>();
        for (String child : context.getResources().getStringArray(R.array.menu2_childs)) {
            menu2.add(child);
        }

        List<String> menu3 = new ArrayList<String>();
        for (String child : context.getResources().getStringArray(R.array.menu3_childs)) {
            menu3.add(child);
        }



        mapChild.put(listGroup.get(0), menu1);
        mapChild.put(listGroup.get(1), menu2);
        mapChild.put(listGroup.get(2), menu3);
    }


}
