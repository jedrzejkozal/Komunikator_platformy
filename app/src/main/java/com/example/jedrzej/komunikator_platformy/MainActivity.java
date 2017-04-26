package com.example.jedrzej.komunikator_platformy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView list ;
    private ArrayAdapter<String> adapter;
    public Button button;
    public Button button_send;
    EditText mEdit;
    ArrayList<String> conv_history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating a new listView
        list = (ListView) findViewById(R.id.listView2);
        String messages[] = {new String("Me: Hello World"),new String("You: Wanna talk about our Lord and Savior Donald Trump?")};
        conv_history = new ArrayList<String>();
        conv_history.addAll( Arrays.asList(messages) );

        adapter = new ArrayAdapter<String>(this, R.layout.row, conv_history);
        list.setAdapter(adapter);

        /*list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                Intent myIntent = new Intent(MainActivity.this, SendMessageActivity.class);
                //myIntent.putExtra("Person", position); //Optional parameters
                myIntent.putExtra("name",adapter.getItem(position).getName());
                myIntent.putExtra("IP",adapter.getItem(position).getIP());
                myIntent.putExtra("port",adapter.getItem(position).getPortNumber());
                MainActivity.this.startActivity(myIntent);
            }
        });*/

        //button dodaj kontakt
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AddPersonActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        //button wyślij
        mEdit   = (EditText)findViewById(R.id.editText4);
        button_send = (Button) findViewById(R.id.button2);
        button_send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /*Intent myIntent = new Intent(MainActivity.this, AddPersonActivity.class);
                MainActivity.this.startActivity(myIntent);*/
                String tmp = mEdit.getText().toString();
                conv_history.add("Me: " + tmp);
                //mEdit.clearComposingText();
                mEdit.setText("");
            }
        });

    }
}
