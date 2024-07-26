package org.example;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Heartbeat {

    SocketChannel socketChannel;

    private final String HEARTBEAT = "heartbeat";

    public Heartbeat(SocketChannel client) throws IOException {
        this.socketChannel = client;
        socketChannel.configureBlocking(false);
    }


    public void run() {
        try{
            byte [] message = HEARTBEAT.getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(message);
            socketChannel.write(buffer);
            System.out.println("Sending heartbeat...");
            buffer.clear();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
