package Sprint4.Uppgift5a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    Database d = new Database();

    public Server() {
        //Create and start ServerSocket, returning a socket when client has called and a connection is established
        try (ServerSocket serverSocket = new ServerSocket(55556);
             Socket socket = serverSocket.accept();
             //Wrap the outstream in a PrintWriter
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             //Wrap the instream in a BufferedReader
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            //Send the initial question to the client
            out.println("Enter both first- and last name of the person you are searching for, one person at a time. Type 'exit' to end:");

            String inputLine; //Data from the client
            String outputLine; //Data to the client

            //Listen for requests from the client, then search
            while ((inputLine = in.readLine()) != null) {
                outputLine = d.search(inputLine.trim());
                if (outputLine == null) {
                    out.println("This person cannot be found in the database.");
                } else {
                    //Return response to the client
                    out.println(outputLine);
                }
            }

        } catch (IOException e) {
            System.out.println("There was an error on the server-side.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server s1 = new Server();
    }
}