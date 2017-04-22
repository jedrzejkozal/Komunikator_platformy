package com.example.jedrzej.komunikator_platformy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    private ListView list ;
    private ArrayAdapter<Person> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView1);

        Person people[] = {new Person("A"),new Person("B"),new Person("C"),new Person("D"),new Person("E"),new Person("F")};
        ArrayList<Person> kontakty = new ArrayList<Person>();
        kontakty.addAll( Arrays.asList(people) );

        adapter = new ArrayAdapter<Person>(this, R.layout.row, kontakty);

        list.setAdapter(adapter);
    }
}
