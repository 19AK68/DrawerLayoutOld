package com.example.ak.user.drawerlayoutold;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class Content extends Activity
{

    private TextView txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        txtContent = (TextView)findViewById(R.id.txt_content);
        txtContent.setText(String.valueOf(getIntent().getLongExtra("TEST_CONTENT", -1)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.content, menu);
        return true;
    }

}
