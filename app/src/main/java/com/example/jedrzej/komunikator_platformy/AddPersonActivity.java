package com.example.jedrzej.komunikator_platformy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.xmlpull.v1.XmlSerializer;
import java.io.StringWriter;

import android.content.*;

import java.io.File;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Scanner;



/**
 * Created by jedrzej on 22.04.17.
 */

public class AddPersonActivity extends AppCompatActivity {

    public Button button;
    String Hello = "HelloWorld";
    EditText e1, e2;
    TextView textview;
    File plik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        e1 = (EditText) findViewById(R.id.editText3);
        e2 = (EditText) findViewById(R.id.editText2);
        textview = (TextView) findViewById(R.id.textview);
        plik = new File("user.xml");

        //button dodaj kontakt
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                FileWriter wriete;
                BufferedWriter output = null;
                String content = null;
//                try {
//                    XmlSerializer xmlSerializer = Xml.newSerializer();
//                    StringWriter writer = new StringWriter();
//                    xmlSerializer.setOutput(writer);
//
//                    xmlSerializer.startDocument("UTF-8", true);
//
//                    xmlSerializer.startTag("", "port");
//                    xmlSerializer.text(e1.getText().toString());
//                    xmlSerializer.endTag("", "port");
//
//                    xmlSerializer.startTag("", "ip");
//                    xmlSerializer.text(e2.getText().toString());
//                    xmlSerializer.endTag("", "ip");
////
//                    xmlSerializer.endDocument();

//                    String FILENAME = "user.xml";
//
                    textview.setText("Dziala "+e1.getText()+" "+e2.getText());

                    Intent cel = new Intent(getApplicationContext(), MainActivity.class);
                    cel.putExtra("dane",e1.getText()+" "+e2.getText());
                    startActivity(cel);

//                    Intent myIntent = new Intent(AddPersonActivity.this, MainActivity.class);
//                    AddPersonActivity.this.startActivity(myIntent);
//                } catch (Exception e) {
//                    textview.setText("BŁAD"+e);
//                }
            }
        });
    }
}
