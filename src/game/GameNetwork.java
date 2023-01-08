package game;
import java.io.*;
import java.net.*;
import java.awt.*;

public class GameNetwork {

    Socket socketOfClient = new Socket();
    BufferedWriter os = null;
    BufferedReader is = null;

    public void sendmove(Point move) {
        try {
            System.out.println("Sending move : " + move.x + "," + move.y);
            os.write(String.valueOf(move.y) +  String.valueOf(move.x));
            os.newLine();
            os.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public int getgamedata() {
        String responseLine;
        int mymark = 0;
        try {
            while ((responseLine = is.readLine()) != null) {
                System.out.println("Server: " + responseLine);
                if (responseLine.equals("X")) {
                    mymark = 2;
                } else if (responseLine.equals("O")) {
                    mymark = 1;
                }
                break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return mymark;
    }

    public Point get_move() {
        String responseLine;
        Point target_point = new Point();
        try {
            System.out.println("Waiting for server move...");
            while ((responseLine = is.readLine()) != null) {
                System.out.println("Server: " + responseLine);
                String splited[] = responseLine.split(",");
                target_point.y = Integer.parseInt(splited[0]);
                target_point.x = Integer.parseInt(splited[1]);
                break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return target_point;
    }

    public void initSocket() {

        // Server Host
        final String serverHost = "localhost";
        try {

            // Send a request to connect to the server is listening
            // on machine 'localhost' port 9999.
            socketOfClient = new Socket(serverHost, 9999);
            os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
            is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + serverHost);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + serverHost);
        }
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