package Sprint4.Uppgift2a;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class QuoteSender {

    String[] quotes = {"Be tolerant with others and strict with yourself. – Marcus Aurelius",
            "Life is very short and anxious for those who forget the past, neglect the present, and fear the future. – Seneca",
            "Don't seek for everything to happen as you wish it would, but rather wish that everything happens as it actually will — then your life will flow well. – Epictetus",
            "Choose not to be harmed — and you won't feel harmed. Don't feel harmed — and you haven't been.” – Marcus Aurelius",
            "When we are no longer able to change a situation, we are challenged to change ourselves.” – Viktor Frankl"};

    QuoteSender() {
        try {
            InetAddress toIP = InetAddress.getLocalHost();
            int toPort = 44445;
            DatagramSocket ds = new DatagramSocket();

            //Convert each quote-string to a byte-array and send as a DatagramPackets every 5 seconds
            for (int i = 0; i < quotes.length; i++) {
                byte[] bytes = quotes[i].getBytes();
                DatagramPacket dgp = new DatagramPacket(bytes, bytes.length, toIP, toPort);
                Thread.sleep(5000);
                ds.send(dgp);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("There was an error sending the quotes.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new QuoteSender();
    }
}