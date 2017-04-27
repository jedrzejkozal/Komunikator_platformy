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
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.net.*;



/**
 * Created by jedrzej on 22.04.17.
 */

public class AddPersonActivity extends AppCompatActivity {

    public Button button;
    String Hello = "HelloWorld";
    EditText e1, e2;
    TextView textview, textview1;
    File plik;

    //kod ze stack Overflow
    public static String getIPAddress(boolean useIPv4) {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (!addr.isLoopbackAddress()) {
                        String sAddr = addr.getHostAddress();
                        //boolean isIPv4 = InetAddressUtils.isIPv4Address(sAddr);
                        boolean isIPv4 = sAddr.indexOf(':')<0;

                        if (useIPv4) {
                            if (isIPv4)
                                return sAddr;
                        } else {
                            if (!isIPv4) {
                                int delim = sAddr.indexOf('%'); // drop ip6 zone suffix
                                return delim<0 ? sAddr.toUpperCase() : sAddr.substring(0, delim).toUpperCase();
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) { } // for now eat exceptions
        return "";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        e1 = (EditText) findViewById(R.id.editText3);
        e2 = (EditText) findViewById(R.id.editText2);
        textview = (TextView) findViewById(R.id.textview);
        textview1 = (TextView) findViewById(R.id.textView1);
        plik = new File("user.xml");

        /*try {
            InetAddress IP1 = InetAddress.getLocalHost();
            textview1.setText("Twoje IP:" + IP1.getHostAddress());
        } catch(UnknownHostException e) {
            //textview1.setText(e.toString());
        }*/
        textview1.setText("Twoje IP: " + getIPAddress(true));

        /*
        Intent i = getIntent();
        if (i.hasExtra("port")) {
            Bundle przekazanedane = i.getExtras();
            String [] przekazanytekst = przekazanedane.getStringArray("dane");
            e1.setText(przekazanytekst[0]);
            e2.setText(przekazanytekst[1]);
        }*/

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
