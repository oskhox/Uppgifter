package Sprint4.Uppgift4b;

import java.io.IOException;
import java.net.*;

public class WeatherReceiverMulticast {

    WeatherReceiverMulticast() {
        try {
            //Create socket, IP, group and network interface and then the receiver's socket joins the group
            int port = 44446;
            MulticastSocket ms = new MulticastSocket(port);
            byte[] bytes = new byte[256];
            InetAddress ip = InetAddress.getByName("234.234.234.234"); //Made up IP within allowed range
            InetSocketAddress group = new InetSocketAddress(ip, port); //Provided the group with IP and port number
            NetworkInterface netIf = NetworkInterface.getByName("en0"); //Provided the name of the local network interface
            ms.joinGroup(group, netIf);

            //Receive all DatagramPackets and convert to String
            while (true) {
                DatagramPacket dgp = new DatagramPacket(bytes, bytes.length);
                ms.receive(dgp);
                System.out.println("Received from IP " + dgp.getAddress() + ":");
                String s = new String(dgp.getData(), 0, dgp.getLength());
                System.out.println(s);

                //Ends the program on the user's request
                if (s.equalsIgnoreCase("exit"))
                    System.exit(0);
            }
        } catch (IOException e) {
            System.out.println("There was an error receiving the quotes.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WeatherReceiverMulticast wrm = new WeatherReceiverMulticast();
    }
}