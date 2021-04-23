package com.irfanvarren.belajarandroidapi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class detailActivity extends Activity {
    private TextView nameView,usernameView,emailView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        String name = getIntent().getStringExtra("name");
        String username = getIntent().getStringExtra("username");
        String email = getIntent().getStringExtra("email");
        nameView = (TextView) findViewById(R.id.name);
        nameView.setText(name);
        nameView = (TextView) findViewById(R.id.username);
        nameView.setText(username);
        nameView = (TextView) findViewById(R.id.email);
        nameView.setText(email);

    }
}
