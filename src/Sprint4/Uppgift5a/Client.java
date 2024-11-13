package Sprint4.Uppgift5a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    Scanner input = new Scanner(System.in);

    Client() {
        try (Socket socket = new Socket("127.0.0.1", 55556);
             //Wrap the outstream in a PrintWriter
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             //Wrap the instream in a BufferedReader
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String fromServer;
            String fromUser;
            boolean exit = false;

            //First read from server
            while ((fromServer = in.readLine()) != null && !exit) {
                System.out.println(fromServer);

                //Then take in user input and check for exit
                fromUser = input.nextLine();
                if (fromUser.equalsIgnoreCase("exit")) {
                    exit = true;
                }
                //Send entered name to server
                out.println(fromUser);
            }
        } catch (IOException e) {
            System.out.println("There was an error on the client-side.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client c1 = new Client();
    }
}