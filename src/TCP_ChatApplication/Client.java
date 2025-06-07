package TCP_ChatApplication;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        while(true) {
            try(Socket socket = new Socket("localhost", 3000);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

                System.out.println("Server connected.");

                String clientNumber = in.readLine();
                System.out.println("Your number is "+clientNumber);

                String line;
                while((line = userInput.readLine()) != null) {
                    out.println("["+clientNumber+"] "+line);

                    String serverMessage = in.readLine();
                    System.out.println(serverMessage);
                }
            }
        }
    }
}
