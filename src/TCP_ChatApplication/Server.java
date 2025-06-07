package TCP_ChatApplication;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {

        Integer clientNumber = 0;

        try (ServerSocket serverSocket = new ServerSocket(3000)) {
            while (true) {
                System.out.println("Waiting for connect...");

                try(Socket socket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                    InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();

                    clientNumber = clientNumber + 1;

                    out.println(clientNumber);

                    System.out.println("Client connected : ["+clientNumber+"] " + isa.getHostName());

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        out.println(inputLine);
                        System.out.println(inputLine);
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
