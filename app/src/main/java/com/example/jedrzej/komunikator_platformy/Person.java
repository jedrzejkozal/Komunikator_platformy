package com.example.jedrzej.komunikator_platformy;

/**
 * Created by jedrzej on 22.04.17.
 */

public class Person {
    private String name;
    private String serverIP;
    private int portNumber;

    public Person(String _name, String _serverIP, int _portNumber) {
        name = _name;
        serverIP = _serverIP;
        portNumber = _portNumber;
    }
    public Person(String _name) {
        name = _name;
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getIP() {
        return serverIP;
    }

    public int getPortNumber() {
        return portNumber;
    }
}
