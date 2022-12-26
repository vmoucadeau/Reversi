package game;
import java.io.*;
import java.net.*;
import java.awt.*;

public class GameNetwork {

    public static void sendmove(Point move, Socket socketOfClient) {
        os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
        os.write(move.x);
        os.write(move.y);
    }
    public static Socket initSocket() {

        // Server Host
        final String serverHost = "localhost";
        Socket socketOfClient = null;
        BufferedWriter os = null;
        BufferedReader is = null;


        try {

            // Send a request to connect to the server is listening
            // on machine 'localhost' port 9999.
            socketOfClient = new Socket(serverHost, 9999);

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + serverHost);
            return null;
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + serverHost);
            return null;
        }
        return socketOfClient;
        /*try {

            // Write data to the output stream of the Client Socket.
            os.write("HELO");

            // End of line
            os.newLine();

            // Flush data.
            os.flush();
            os.write("I am Tom Cat");
            os.newLine();
            os.flush();
            os.write("QUIT");
            os.newLine();
            os.flush();



            // Read data sent from the server.
            // By reading the input stream of the Client Socket.
            String responseLine;
            while ((responseLine = is.readLine()) != null) {
                System.out.println("Server: " + responseLine);
                if (responseLine.indexOf("OK") != -1) {
                    break;
                }
            }

            os.close();
            is.close();
            socketOfClient.close();
        } catch (UnknownHostException e) {
            System.err.println("Trying to connect to unknown host: " + e);
        } catch (IOException e) {
            System.err.println("IOException:  " + e);
        }*/
    }

}