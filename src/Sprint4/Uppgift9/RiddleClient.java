package Sprint4.Uppgift9;

import java.io.*;
import java.net.*;

public class RiddleClient {
    public static void main(String[] args) throws IOException {

        InetAddress IP = InetAddress.getLoopbackAddress(); //localhost
        int portNumber = 44444;

        try (
                Socket rSocket = new Socket(IP, portNumber);
                PrintWriter out = new PrintWriter(rSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(rSocket.getInputStream()));
                BufferedReader stdIn =
                        new BufferedReader(new InputStreamReader(System.in));
        ) {

            String fromServer;
            String fromUser;

            // Listening to the server
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye."))
                    break;

                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    out.println(fromUser);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + IP);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    IP);
            System.exit(1);
        }
    }
}