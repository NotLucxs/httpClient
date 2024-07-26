package org.example;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class WriteDataThread implements Runnable{

    private static final String GET_REQUEST = "GET /docs/tutorials/linux/shellscripts/howto.html HTTP/1.1\n"+
                                                "Host: Linode.com\n"+
                                                "User-Agent: Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.1.8) Gecko/20091102 Firefox/3.5.5\n"+
                                                "Accept: text/html,application/xhtml+xml,\n"+
                                                "Accept-Language: en-us\n"+
                                                "Accept-Encoding: gzip,deflate\n"+
                                                "Accept-Charset: ISO-8859-1,utf-8\n"+
                                                "Cache-Control: no-cache";

    SocketChannel socketChannel;

    public WriteDataThread(SocketChannel client) {
        this.socketChannel = client;
    }


    public void run() {
        try{
            byte [] message = GET_REQUEST.getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(message);
            socketChannel.write(buffer);
            System.out.println(GET_REQUEST);
            buffer.clear();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
