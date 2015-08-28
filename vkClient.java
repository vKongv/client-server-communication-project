 /** Version 2.0
 **/

import java.io.*;
import java.net.*;

public class vkClient {
    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.err.println(
                "Usage: java vkClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        String errorMessage = "Invalid input! Please try again!";
        String previousMessage = ""; // To display again the message if any error in input.

        try (
            Socket kkSocket = new Socket(hostName, portNumber); //Connect to server
            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true); //Message that want to send to server
            BufferedReader in = new BufferedReader(
                new InputStreamReader(kkSocket.getInputStream()));
        ) {
          //Input from user
            BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;
            int stateCounter = 0; //To identify the state of the server

            while ((fromServer = in.readLine()) != null) {
              String [] messageFromServer = fromServer.split("_");
              int stateOfServer = Integer.parseInt(messageFromServer[0]);
              fromServer = messageFromServer[1];

              if (fromServer.equalsIgnoreCase(errorMessage)){
                System.out.println("\nServer: " + fromServer );
                System.out.println("Server: " + previousMessage + "\n");
              }
              else{
              //If the server send back the resource list, tokenize it and display it to the user
                if (stateOfServer == 2){
                  fromServer = "\n";
                  int counter = 1;
                  for(int i=1;i<messageFromServer.length - 1;i+=2){
                    fromServer = fromServer + Integer.toString(counter) + ". " + messageFromServer[i] + " " + messageFromServer[i+1] + "\n"  ; //Combine the message
                    counter ++;
                  }
                }

                previousMessage = fromServer;
                //Show server's message
                System.out.println("\nServer: " + fromServer + "\n");
                if (fromServer.equals("Bye."))
                    break;

                //If the state is downloading, wait for awhile for the program to finish download and send a message to the server.
                //HARDCODE
                if(stateOfServer == 3){
                  System.out.println("\nServer: Downloading.. Please wait...\n");
                  try{
                    Thread.sleep(1000);
                  }
                  catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                  }
                  out.println("Finished downloading.");
                  continue;
                }
              }

                //Read user input
                System.out.print("Client: ");
                fromUser = stdIn.readLine();

                if (fromUser != null) {
                    //System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    }
}
