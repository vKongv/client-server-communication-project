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
