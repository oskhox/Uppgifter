package Sprint4.Uppgift1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//Simple server that receives data from the client
public class Server {

    public Server() {
        try (ServerSocket serverSocket = new ServerSocket(55556);
             //Start the serverSocket and return a socket when the client has called and a connection is first established
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
            System.out.println("Server error reading the data.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server s1 = new Server();
    }
}