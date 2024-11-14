package Sprint4.Uppgift6v3;

import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;

class Client {

    public static void main(String[] args) {
        InetAddress IP = InetAddress.getLoopbackAddress(); //My own IP in this case, as I also am the server
        System.out.println("The server's IP is " + IP + ".");

        try {
            // Connect to the server
            Socket socket = new Socket(IP, 5577);
            System.out.println("Connected to the server.");

            // Receive (deserialize) the object from the server
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Person person = (Person) in.readObject();
            System.out.println("Received Person object from the server: " + person);

            // Clean up
            in.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
