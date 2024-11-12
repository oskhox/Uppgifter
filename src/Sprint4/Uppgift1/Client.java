package Sprint4.Uppgift1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    Client() {

        try (Socket socket = new Socket("127.0.0.1", 55556);
             //Wrap the outstream in a PrintWriter
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            //Send the message
            String message = "This is a message from the client.";
            for (int i = 0; i < 5; i++) {
                out.println(message);
                System.out.println("The client has sent a message.");
                Thread.sleep(2000);
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("There was an error in the client sending the data.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client c1 = new Client();
    }
}