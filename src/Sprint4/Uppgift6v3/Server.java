package Sprint4.Uppgift6v3;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// This is a step-by-steg basic TCP server-client implementation of serialization, otherwise identical to 'Uppgift6v2'
// Here, server only has an out and client only has an in as it is a basic example

public class Server {

    public static void main(String[] args) {
        Database db = new Database();

        try (ServerSocket serverSocket = new ServerSocket(5577)) {
            System.out.println("Server is running and waiting for a client connection...");

            //Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            //Get a Person object from the database
            Person person = db.getPersonData();

            //Send (serialize) the object to the client
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.writeObject(person);
            System.out.println("Person object sent to the client: " + person);

            // Clean up
            out.close();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
