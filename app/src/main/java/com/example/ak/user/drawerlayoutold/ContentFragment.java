package com.example.ak.user.drawerlayoutold;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContentFragment extends Fragment
{

    private TextView txtContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_content, container, false);
        txtContent = (TextView)view.findViewById(R.id.txt_content);
        txtContent.setText(String.valueOf(getArguments().getInt("TEST_CONTENT")));

        return view;
    }

}
