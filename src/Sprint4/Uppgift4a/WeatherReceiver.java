package Sprint4.Uppgift4a;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class WeatherReceiver {

    WeatherReceiver() {
        try {
            int toPort = 44446;
            DatagramSocket ds = new DatagramSocket(44446);
            byte[] bytes = new byte[254];

            //Receive all DatagramPackets and convert to String
            while (true) {
                DatagramPacket dgp = new DatagramPacket(bytes, bytes.length);
                ds.receive(dgp);
                System.out.println("Received from IP " + dgp.getAddress() + ":");
                String s = new String(dgp.getData(), 0, dgp.getLength());
                System.out.println(s);

                if (s.equalsIgnoreCase("exit"))
                    System.exit(0);
            }
        } catch (IOException e) {
            System.out.println("There was an error receiving the quotes.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WeatherReceiver wr = new WeatherReceiver();
    }
}