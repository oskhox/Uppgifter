package Sprint4.Uppgift2a;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class QuoteReceiver {

    QuoteReceiver() {
        try {
            int toPort = 44445;
            DatagramSocket ds = new DatagramSocket(44445);
            byte[] bytes = new byte[254];

            //Receive all DatagramPackets and convert to String
            for (int i = 0; i < 5; i++) {
                DatagramPacket dgp = new DatagramPacket(bytes, bytes.length);
                ds.receive(dgp);
                System.out.println("Received from IP " + dgp.getAddress() + ":");
                String s = new String(dgp.getData(), 0, dgp.getLength());
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("There was an error receiving the quotes.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new QuoteReceiver();
    }
}