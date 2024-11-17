package Sprint4.Uppgift10_TCPMultiUser;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener {

    public ServerListener() {

        try (ServerSocket ss = new ServerSocket(5577)) {

            while (true) {
                Socket s = ss.accept();
                Server srvr = new Server(s);
                srvr.start(); // Starts a new thread
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerListener serverListener = new ServerListener();
    }
}