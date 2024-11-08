package Sprint4.Uppgift0;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class printLocalNetwork {

    public printLocalNetwork() {
        printLocalIP();
        printLocalInterface();
    }

    public void printLocalIP() {
        //Prints my local IP etc
        try {
            InetAddress myLocalHost = InetAddress.getLoopbackAddress(); //this one because of mac
            System.out.println("-- Local IP and related information --");
            System.out.println("All of LocalHost is: " + myLocalHost);
            System.out.println("LocalHost address is: " + myLocalHost.getHostAddress());
            System.out.println("LocalHost name is: " + myLocalHost.getHostName());
            System.out.println("Is LocalHost multicast?: " + myLocalHost.isMulticastAddress());

        } catch (Exception e) {
            System.out.println("There was an error printing the local ip.");
            e.printStackTrace();
        }
    }

    public void printLocalInterface() {
        //Prints my network interfaces
        try {
            //gets the interface
            System.out.println("-- Local interface information --");
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface intface = interfaces.nextElement(); //gets the next one
                //filters out 127.0.0.1 and inactive interfaces
                if (intface.isLoopback() || !intface.isUp())
                    continue;

                //prints the interface
                Enumeration<InetAddress> intAddresses = intface.getInetAddresses();
                while (intAddresses.hasMoreElements()) {
                    InetAddress addr = intAddresses.nextElement();
                    String ip = addr.getHostAddress();
                    System.out.println("Interface display name and ip is: " + intface.getDisplayName() + " and " + ip);
                    System.out.println("Interface system name is: " + intface.getName());

                }
            }
        } catch (SocketException e) {
            System.out.println("There was an error printing the network interfaces.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new printLocalNetwork();
    }
}