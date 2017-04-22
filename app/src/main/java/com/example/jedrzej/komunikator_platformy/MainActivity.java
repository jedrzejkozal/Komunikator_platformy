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

        //button dodaj kontakt
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AddPersonActivity.class);
                //myIntent.putExtra("key",1); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}
