package Sprint4.Uppgift9;

import java.net.*;
import java.io.*;

public class RiddleServer {
    public static void main(String[] args) throws IOException {
        int portNumber = 44444;

        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine, outputLine;

            // First, initiate protocol logic even when there is no first input, putting the protocol in 'WELCOME' state
            RiddleProtocol rp = new RiddleProtocol();
            outputLine = rp.processInput(null);
            out.println(outputLine); // Protocol results are sent back to client

            // Listening to the client
            // Each new input from the client leads to a new protocol call, further protocol results are sent back to client
            while ((inputLine = in.readLine()) != null) {
                outputLine = rp.processInput(inputLine); // A new looped call to the protocol with each client input
                out.println(outputLine); // Results are sent back to the client
                if (outputLine.equals("Bye.")) // The loop ends when the protocol signals to stop
                    break;
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen "
                    + "on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}