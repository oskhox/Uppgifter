package Sprint4.Uppgift10_TCPMultiUser;

import java.io.*;
import java.net.Socket;

public class Server extends Thread {
    Socket s;
    Database db = new Database();

    public Server(Socket s) {
        this.s = s;
    }

    public void run() {
        try (
                ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream()); //OOS for objects, printWriter for strings
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream())); //not used currently but here for future reference
        ) {
            //Get a Person object from the database
            Person person = db.getPersonData();
            //Send (serialize) the object to the client
            out.writeObject(person);
            System.out.println("Person object sent to the client: " + person);
            // Clean up
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

