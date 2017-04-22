package com.example.jedrzej.komunikator_platformy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    private ListView list ;
    private ArrayAdapter<Person> adapter;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating a new listView
        list = (ListView) findViewById(R.id.listView1);
        Person people[] = {new Person("A"),new Person("B"),new Person("C"),new Person("D"),new Person("E"),new Person("F")};
        ArrayList<Person> kontakty = new ArrayList<Person>();
        kontakty.addAll( Arrays.asList(people) );

        adapter = new ArrayAdapter<Person>(this, R.layout.row, kontakty);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {
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
        });

        //button dodaj kontakt
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AddPersonActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}
