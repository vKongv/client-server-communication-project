/** Version 3.0
**/


import java.net.*;
import java.io.*;

public class vkServer {
    public static void main(String[] args) throws IOException {

        int portNumber;
        if (args.length != 1) {
            System.out.println("Automatic assigned to port number 4444");
            portNumber = 4444;

        }
        else{
          portNumber = Integer.parseInt(args[0]);
        }



        try (
            //Initialize the port number
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept(); //Connection from client

            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true); //Message that want to send to client
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())); //Message that received from client
        ) {
            System.out.println("Successful connect to port " + portNumber);
            String inputLine, outputLine;
            // Initiate conversation with client
            vkProtocol protocol = new vkProtocol();
            outputLine = protocol.processInput(null);
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                outputLine = protocol.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye."))
                    break;
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
