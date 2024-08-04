package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Main {

    private static final InetSocketAddress server = new InetSocketAddress("localhost", 8080);

    public static void main(String[] args) {
        System.out.println("Starting client!");

        try {
            //  Create client
            SocketChannel client = SocketChannel.open(server);
            WriteDataThread first = new WriteDataThread(client);

            first.run();
            //client.close();

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}