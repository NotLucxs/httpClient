package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private static final InetSocketAddress server = new InetSocketAddress("localhost", 8080);

    public static void main(String[] args) {
        System.out.println("Starting client!");

        try {
            //  Create client
            SocketChannel client = SocketChannel.open(server);
            WriteDataThread first = new WriteDataThread(client);
            Heartbeat heartbeat = new Heartbeat(client);
            //  Schedule heartbeat on separate thread every 5 seconds
            executor.scheduleAtFixedRate(heartbeat::run, 0, 5, TimeUnit.SECONDS);

            first.run();
            //  Keep commented to maintain heartbeat
            //client.close();

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}