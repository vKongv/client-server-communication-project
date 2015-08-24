/**  Version 1.0
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


    public String processInput(String theInput) {
        String theOutput = null;

        if (state == WAITING) {
            theOutput = "Here are the terms of reference. Do you accept? Yes or No";
            state = DISPLAYINGTC;
        }

        else if (state == DISPLAYINGTC) {
            if (theInput.equalsIgnoreCase("Yes")) {
                theOutput = "";
                for(int i=0; i< resources.length; i ++){

                  theOutput = theOutput + resources[i] + "_";
                }
                state = DISPLAYINGRESOURCES;
            }
            else if (theInput.equalsIgnoreCase("No")){
              theOutput = "Bye.";
              state = WAITING;
            }
            else{
              theOutput = "Wrong input. Type Yes or No ONLY.";
            }
        }

        else if (state == DISPLAYINGRESOURCES) {
          boolean found = false; //To identify whethere the resource had been found
          int resourceLocation = Integer.parseInt(theInput) -1;
          for (int i=0; i<resources.length; i++){
            if (resources[resourceLocation] == resources[i]) {
                theOutput = "You are downloading " + resources[i];
                state = DOWNLOADING;
                found = true;
                break;
              }
            }

            if (!found){
                theOutput = "Invalid selection! Please choose again.";
          }

        }

        else if (state == DOWNLOADING) {
          theOutput = "Enter BYE to exit, and ENTER to continue.";
          state = FINISHED;
        }
        else if (state == FINISHED) {
            if (theInput.equalsIgnoreCase("enter")) {
              theOutput = "";
              for(int i=0; i< resources.length; i ++){
                theOutput = theOutput + resources[i] + "_";
              }
                state = DISPLAYINGRESOURCES;
            }
            else {
                theOutput = "Bye.";
                state = WAITING;
            }
        }
        return theOutput;
    }
}
