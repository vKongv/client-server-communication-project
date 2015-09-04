 /** Version 3.0
 **/

import java.io.*;
import java.net.*;
import javax.swing.*;

public class vkClient {
    private static Socket kkSocket;
    private static PrintWriter out;
    private static BufferedReader in;
    private static mainPage loginPage;
    private static mainPage downloadPage;
    private static mainPage continuePage;
    private static String fromUser = "";
    public static String fromServer = "";
    public static String errorMessage[] = {"Invalid input! Please try again!", "Bye.", "Server Error"};
    public static int serverState = -1;
    public static String resourceList [];

    /**
    Function name : connectToServer
    Return type : void
    Paremeters : hostName, strPortNumber

    hostName = The server's host name
    strPortNumber = The server's port number

    Purpose : used to connect to server
    **/
    public static void connectToServer(String hostName, String strPortNumber){
      int portNumber = -1;

      //Check for any error occur when converting to integer
      try {
         portNumber = Integer.parseInt(strPortNumber);
      } catch (Exception e){
        fromServer = errorMessage[0];
      }

      //Check can connect to server or not.
      try {
          kkSocket = new Socket(hostName, portNumber); //Connect to server
          out = new PrintWriter(kkSocket.getOutputStream(), true); //Message that want to send to server
          in = new BufferedReader(
              new InputStreamReader(kkSocket.getInputStream()));
              serverState = 0;
              fromServer = in.readLine();
              String [] messageFromServer = fromServer.split("_");
              serverState = Integer.parseInt(messageFromServer[0]);
              fromServer = messageFromServer[1];
      } catch (Exception e){
        fromServer = errorMessage[0];
        return;
      }
    }

    /**
    Function Name : sendUserInput
    Retrun type : void
    Parementer : int decision , int type

    decision = User's decision (Yes or No)
    type = Which message type is this? (Dispaly TC, etc.)

    Purpose : Used to send user input to server from GUI
    **/
    public static void sendUserInput(int decision, int type){

      switch (type){
        case 0 :
          fromUser = "";
          break;
        case 1:
          if (decision == JOptionPane.YES_OPTION){
            fromUser = "Yes";
          }
          else if (decision == JOptionPane.NO_OPTION){
            fromUser = "No";
          }
          else {
            fromUser = "UNKNOWN INPUT";
          }
          break;
        case 2:
          fromUser = Integer.toString(decision);
          break;
        case 3:
          fromUser = "";
          break;
        case 4:
          if (decision == 0){
            fromUser = "bye";
          }
          else if (decision == 1){
            fromUser = "enter";
            //If user return to this page through continue page.
              continuePage.setVisible(false);
          }
          else {
            fromUser = "UNKNOWN INPUT";
          }
      } //Switch
      out.println(fromUser);

      try {
      if((fromServer = in.readLine()) != null){
        String [] messageFromServer = fromServer.split("_");
        serverState = Integer.parseInt(messageFromServer[0]);
        fromServer = messageFromServer[1];
        if (fromServer.equalsIgnoreCase(errorMessage[0]) || fromServer.equalsIgnoreCase(errorMessage[1]) || fromServer.equalsIgnoreCase(errorMessage[2])){
          return;
        }
        else{
        //If the server send back the resource list, tokenize it and display it to the user
          if (serverState == 2){
            fromServer = "";
            int counter = 1;
            for(int i=1;i<messageFromServer.length - 1;i+=2){
              fromServer = fromServer + messageFromServer[i] + " " + messageFromServer[i+1] + "\n"  ; //Combine the message
              counter ++;
            }
            resourceList = fromServer.split("\n");
            loginPage.setVisible(false);
            downloadPage = new mainPage(1);
          }

          if(serverState == 4){
            downloadPage.setVisible(false);
            continuePage = new mainPage(2);
          }
        }
      }else{
        fromServer = errorMessage[2];
      }// Outest if
    } catch (IOException e){
           fromServer = "Server Error";
      }
    }  //function

    /**
    Function name : disconnect
    Return type : void
    Parameter : None

    used to disconnect client from server. To exit the program
    **/
    public static void disconnect (){
      System.exit(0);
    }

    /**
    Function name : getUserInput
    Return type : String
    Parameter : None

    used to retrieve the user input.
    **/

    public static String getUserInput(){
      return fromUser;
    }

    public static void main(String[] args) {
        loginPage = new mainPage(0);
    }
}
