package com.univer.serverANDclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class ClientRun implements Runnable{

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 1234;



    public static void startClientRun() throws IOException {
        Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        byte[] data = "hello from client".getBytes();
        /**
         * Socket socket(InetAdress iA, int remotePort)
         * Socket socket(InetAdress iA, int remotePort, IntAdress localAdress, int localPort)
         * Socket();
         *
         */

        System.out.println("Starting sending data to server.... ");
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();



        int totalDataGot = 0;
        int bytesResived = 0; // Bytes recived in last read

        while (bytesResived < data.length) {
            if (
                    (bytesResived = in.read(
                            data,
                            totalDataGot,
                            data.length - bytesResived)) == -1) {
                throw new SocketException("Connection closed forcfully");
            }

            totalDataGot += bytesResived;
        }

        System.out.println("Got info from server = " + new String(data));


        socket.close();


    }


    @Override
    public void run() {
        try {
            startClientRun();
        } catch (IOException e) {
            System.out.println("Помилка запуску клієнт-сервера");
        }
    }
}
