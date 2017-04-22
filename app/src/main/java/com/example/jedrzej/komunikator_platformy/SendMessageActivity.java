package com.example.jedrzej.komunikator_platformy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.widget.TextView;

/**
 * Created by jedrzej on 22.04.17.
 */

public class SendMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        Bundle extras = getIntent().getExtras();
        int port = 0;
        String name = " ", IP = " ";
        if (extras != null) {
            port = extras.getInt("Person");
            name = extras.getString("name");
            IP = extras.getString("IP");
        }
        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText(name + " " + IP + " " + Integer.toString(port));
    }
}
