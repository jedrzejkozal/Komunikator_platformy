package com.example.jedrzej.komunikator_platformy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jedrzej on 22.04.17.
 */

public class SendMessageActivity extends AppCompatActivity {

    private ListView list ;
    private ArrayAdapter<String> adapter;

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
        //textView.setText(name + " " + IP + " " + Integer.toString(port));
        textView.setText(" ");

        //creating a new listView
        list = (ListView) findViewById(R.id.listView2);
        String messages[] = {new String("Me: Hello World"),new String("You: Wanna talk about our Lord and Savior Donald Trump?")};
        ArrayList<String> conv_history = new ArrayList<String>();
        conv_history.addAll( Arrays.asList(messages) );

        adapter = new ArrayAdapter<String>(this, R.layout.row, conv_history);
        list.setAdapter(adapter);
    }
}
