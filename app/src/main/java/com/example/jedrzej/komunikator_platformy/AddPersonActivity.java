package com.example.jedrzej.komunikator_platformy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.xmlpull.v1.XmlSerializer;
import java.io.StringWriter;

import android.content.Context;

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

        e1 = (EditText) findViewById(R.id.editText);
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
                try {
                    XmlSerializer xmlSerializer = Xml.newSerializer();
                    StringWriter writer = new StringWriter();
                    xmlSerializer.setOutput(writer);

                    xmlSerializer.startDocument("UTF-8", true);

                    xmlSerializer.startTag("", "username");
                    xmlSerializer.text(e1.getText().toString());
                    xmlSerializer.endTag("", "username");

                    xmlSerializer.startTag("", "ip");
                    xmlSerializer.text(e2.getText().toString());
                    xmlSerializer.endTag("", "ip");

                    xmlSerializer.endDocument();

                    String FILENAME = "user.xml";

                    FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_APPEND);
                    fos.write(writer.toString().getBytes());
                    fos.close();
//                    File file = new File("example.txt");
//                    output = new BufferedWriter(new FileWriter(file));
//                    output.write(writer.toString());
//                    output.close();
//                    zapis.print(writer.toString());
//                    zapis.close();

                    textview.setText("Dziala"+writer.toString());

                    File file = new File(FILENAME); //for ex foo.txt
                    FileReader reader = null;

                    reader = new FileReader(file);
                    char[] chars = new char[(int) file.length()];
                    reader.read(chars);
                    content = new String(chars);
                    reader.close();
//
                    textview.setText("Wyjdzie"+content.toString());

                } catch (Exception e) {
                    textview.setText("BŁAD"+e);
                }
            }
        });
    }
}
