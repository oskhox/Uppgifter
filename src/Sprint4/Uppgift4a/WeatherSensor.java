package Sprint4.Uppgift4a;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class WeatherSensor {

    WeatherSensor() {
        try {
            InetAddress toIP = InetAddress.getLocalHost();
            int toPort = 44446;
            DatagramSocket ds = new DatagramSocket();
            Scanner input = new Scanner(System.in);
            boolean keepAsking = true;

            //User enters city and current temperature
            while (keepAsking) {
                System.out.println("What city are you in?:");
                String city = input.nextLine();
                System.out.println("What is the current temperature?:");
                String temperature = input.nextLine();
                String cityAndTemperature = "The city is: " + city + ". And it is " + temperature + " degrees right now.";

                //Convert to a byte-array and send as a DatagramPacket
                byte[] bytes = cityAndTemperature.getBytes();
                DatagramPacket dgp = new DatagramPacket(bytes, bytes.length, toIP, toPort);
                ds.send(dgp);

                //Exit this program and the receiver program or add more cities
                System.out.println("Enter 'exit' to exit the program, or press enter to add more cities:");
                String exitInput = input.nextLine();
                if (exitInput.equalsIgnoreCase("exit")) {
                    keepAsking = false;
                    byte[] exitBytes = exitInput.getBytes();
                    DatagramPacket dgpExit = new DatagramPacket(exitBytes, exitBytes.length, toIP, toPort);
                    ds.send(dgpExit);
                }
            }

        } catch (IOException e) {
            System.out.println("There was an error sending the quotes.");
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        WeatherSensor ws = new WeatherSensor();
    }
}