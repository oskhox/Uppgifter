package Sprint4.Uppgift4b;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class WeatherSensorMulticast {

    WeatherSensorMulticast() {
        try {
            //Create IP, port, socket and initial logic
            InetAddress ip = InetAddress.getByName("234.234.234.234"); //Made up IP within allowed range
            int toPort = 44446;
            MulticastSocket ms = new MulticastSocket();
            Scanner input = new Scanner(System.in);
            boolean keepAsking = true;

            //User enters city and current temperature as usual
            while (keepAsking) {
                System.out.println("What city are you in?:");
                String city = input.nextLine();
                System.out.println("What is the current temperature?:");
                String temperature = input.nextLine();
                String cityAndTemperature = "The city is: " + city + ". And it is " + temperature + " degrees right now.";

                //Convert to a byte-array and send as a DatagramPacket
                byte[] bytes = cityAndTemperature.getBytes();
                DatagramPacket dgp = new DatagramPacket(bytes, bytes.length, ip, toPort);
                ms.send(dgp);

                //Exit this program and the receiver program or add more cities
                System.out.println("Enter 'exit' to exit the program, or press enter to add more cities:");
                String exitInput = input.nextLine();
                if (exitInput.equalsIgnoreCase("exit")) {
                    keepAsking = false;
                    byte[] exitBytes = exitInput.getBytes();
                    DatagramPacket dgpExit = new DatagramPacket(exitBytes, exitBytes.length, ip, toPort);
                    ms.send(dgpExit);
                }
            }

        } catch (IOException e) {
            System.out.println("There was an error sending the weather data.");
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        new WeatherSensorMulticast();
    }
}