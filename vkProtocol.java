/**  Version 2.0
**/

import java.net.*;
import java.io.*;

public class vkProtocol {
    private static final int WAITING = 0;
    private static final int DISPLAYINGTC = 1;
    private static final int DISPLAYINGRESOURCES = 2;
    private static final int DOWNLOADING = 3;
    private static final int FINISHED = 4;


    private static final int NUMRESOURCES = 4;

    private int state = WAITING;

    private String[] resources = { "iTune", "ZoneAlarm", "WinRar", "Audacity" };
    private int[] downloadCounter = {0,0,0,0}; // Download counter for all resources

    private String errorMessage = "Invalid input! Please try again!";

    public String processInput(String theInput) {
        String theOutput = null;
        String theMessage = "";
        switch(state){
        case WAITING :
            theMessage = "Here are the terms of reference. Do you accept? Yes or No";
            state = DISPLAYINGTC;
            theOutput = Integer.toString(state) + "_" + theMessage;
            break;


        case DISPLAYINGTC :
            if (theInput.equalsIgnoreCase("Yes")) {
                theOutput = "";
                for(int i=0; i< resources.length; i ++){
                  theMessage = theMessage + resources[i] + "_" + Integer.toString(downloadCounter[i]) + "_";
                }
                state = DISPLAYINGRESOURCES;
                theOutput = Integer.toString(state) + "_" + theMessage;
            }
            else if (theInput.equalsIgnoreCase("No")){
              theMessage = "Bye.";
              state = WAITING;
              theOutput = Integer.toString(state) + "_" + theMessage;
            }
            else{
              theMessage = errorMessage;
              theOutput = Integer.toString(state) + "_" + theMessage;
            }
            break;

        case (DISPLAYINGRESOURCES) :
          boolean found = false; //To identify whethere the resource had been found.
          try{
            int resourceLocation = Integer.parseInt(theInput) - 1; //The resource that the user want.
            for (int i=0; i< resources.length; i++){
              if (resources[resourceLocation] == resources[i]) {
                  downloadCounter[i] += 1; // Increase counter by 1
                  theMessage   = "You are downloading " + resources[i];
                  state = DOWNLOADING;
                  theOutput = Integer.toString(state) + "_" + theMessage ;
                  found = true;
                  break;
                }
              }

              if (!found){
                  theMessage = errorMessage;
                  theOutput = Integer.toString(state) + "_" + theMessage;
            }
            break;
          }catch (Exception e){
            theMessage = errorMessage;
            theOutput = theOutput = Integer.toString(state) + "_" + theMessage;
            break;
          }


        case (DOWNLOADING) :
          theMessage = "Enter BYE to exit, and ENTER to continue.";
          state = FINISHED;
          theOutput = Integer.toString(state) + "_" + theMessage;
          break;

        case (FINISHED) :
            if (theInput.equalsIgnoreCase("enter")) {
              for(int i=0; i< resources.length; i ++){
                theMessage = theMessage + resources[i] + "_" + Integer.toString(downloadCounter[i]) + "_";
              }
                state = DISPLAYINGRESOURCES;
                theOutput = Integer.toString(state) + "_" + theMessage;
            }
            else if (theInput.equalsIgnoreCase("bye")){
                theMessage = "Bye.";
                state = WAITING;
                theOutput = Integer.toString(state) + "_" + theMessage;
            }
            else {
              theMessage= errorMessage;
              theOutput = Integer.toString(state) + "_" + theMessage;
            }
            break;
        }
        return theOutput;
    }
}
