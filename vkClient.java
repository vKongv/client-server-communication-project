 /** Version 1.0
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

                //If the server send back the resource list, tokenize it and display it to the user
                if (stateCounter == 1){
                  String [] resources = fromServer.split("_");
                  fromServer = "";
                  for(int i=0;i<resources.length;i++){
                    fromServer = fromServer + Integer.toString(i+1) + ". " + resources[i] + " "; //Combine the message
                  }
                }

                //Show server's message
                System.out.println("Server: " + fromServer + "\n");
                if (fromServer.equals("Bye."))
                    break;

                //If the state is downloading, wait for awhile for the program to finish download and send a message to the server.
                //HARDCODE
                if(stateCounter == 2){
                  System.out.println("Server: Downloading.. Please wait...\n");
                  try{
                    Thread.sleep(1000);
                  }
                  catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                  }
                  out.println("Finished downloading.");
                  stateCounter++;
                  continue;
                }

                //Read user input
                System.out.print("Client: ");
                fromUser = stdIn.readLine();

                if (fromUser != null) {
                    //System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                    //If the user selection is invalid, DO NOT increase the counter or change the state of server.
                    if(fromServer.equals("Invalid selection! Please choose again.")){}
                    else
                      stateCounter++;
                }

                //Reset the counter to 1. Server have only 5 states and user want to download other resources.
                if (stateCounter == 4 && fromUser.equalsIgnoreCase("enter")){
                  stateCounter = 1;
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
