package Sprint4.Uppgift1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() {

        try (ServerSocket serverSocket = new ServerSocket(55556);
             //Start the server socket and return a socket when the client has calls and a connection is established
             Socket socket = serverSocket.accept();
             //Wrap the instream in a BufferedReader
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            //Receive the message
            String temp;
            while ((temp = br.readLine()) != null) {
                System.out.println(temp);
            }

        } catch (IOException e) {
            System.out.println("There was an error in the server reading the data.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server s1 = new Server();
    }
}