package com.example.jedrzej.komunikator_platformy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.util.Xml;
import org.xmlpull.v1.XmlSerializer;
import java.io.StringWriter;
import java.util.StringTokenizer;
import java.net.*;

public class MainActivity extends AppCompatActivity {

    private ListView list ;
    private ArrayAdapter<String> adapter;
    public Button button;
    public Button button_send;
    EditText mEdit;
    ArrayList<String> conv_history;
    String przekazanytekst;
    //Networking
    DatagramSocket soc;
    String ServerIP;
    int port;
    int SIZE;

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


        Intent i = getIntent();
        if (i.hasExtra("dane")) {
//
            Bundle przekazanedane = i.getExtras();
//
            przekazanytekst = przekazanedane.getString("dane");
//
        }

        //setting up an internet connection
        ServerIP = "192.168.1.14";
        port = 6000;
        SIZE = 200;
        try {
            soc = new DatagramSocket(port);
        }
        catch(java.net.SocketException e) {
            conv_history.add("Error: " + e);
        }

        //button dodaj kontakt
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                soc.close();
                Intent myIntent = new Intent(MainActivity.this, AddPersonActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        //button odśwież
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//
//                XMLe
//
            }
        });

        //button wyślij
        mEdit   = (EditText)findViewById(R.id.editText4);
        button_send = (Button) findViewById(R.id.button2);
        button_send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String tmp = mEdit.getText().toString();
                conv_history.add("Me: " + tmp);
                mEdit.setText("");

                //create XML
                try {
                    StringTokenizer tokenizer = new StringTokenizer(przekazanytekst, " ");
                    XmlSerializer xmlSerializer = Xml.newSerializer();
                    StringWriter writer = new StringWriter();
                    xmlSerializer.setOutput(writer);

                    xmlSerializer.startDocument("UTF-8", true);

                    xmlSerializer.startTag("", "port");
                    xmlSerializer.text(tokenizer.nextElement().toString());
                    xmlSerializer.endTag("", "port");

                    xmlSerializer.startTag("", "ip");
                    xmlSerializer.text(tokenizer.nextElement().toString());
                    xmlSerializer.endTag("", "ip");

                    xmlSerializer.startTag("", "message");
                    xmlSerializer.text(tmp.toString());
                    xmlSerializer.endTag("", "message");

                    xmlSerializer.endDocument();

                    conv_history.add("XML: " + writer.toString());

                //send
                    DatagramPacket p = new DatagramPacket(new byte[SIZE], SIZE);
                    p.setAddress(InetAddress.getByName(ServerIP));
                    p.setPort(port);
                    p.setData(writer.toString().getBytes());
                    soc.send(p);
                } catch(Exception e) {
                    conv_history.add("Error click "+e);
                }
            }
        });
    }
}
