package org.example;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class WriteDataThread implements Runnable{

    private static final String GET_REQUEST = "GET /docs/tutorials/linux/shellscripts/howto.html HTTP/1.1\r\n"+
                                                "Host: Linode.com\r\n"+
                                                "User-Agent: Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.1.8) Gecko/20091102 Firefox/3.5.5\r\n"+
                                                "Accept: text/html,application/xhtml+xml,\r\n"+
                                                "Accept-Language: en-us\r\n"+
                                                "Accept-Encoding: gzip,deflate\r\n"+
                                                "Accept-Charset: ISO-8859-1,utf-8\r\n"+
                                                "Cache-Control: no-cache\r\n\r\n";

    private static final String POST_REQUEST = "POST /test HTTP/1.1\r\n" +
            "Host: foo.example\r\n" +
            "Content-Type: application/x-www-form-urlencoded\r\n" +
            "Content-Length: 27\r\n" +
            "\r\n\r\n" +
            "field1=value1&field2=value2";

    SocketChannel socketChannel;

    public WriteDataThread(SocketChannel client) {
        this.socketChannel = client;
    }


    public void run() {
        try{
            byte [] message = POST_REQUEST.getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(message);
            socketChannel.write(buffer);
            System.out.println(POST_REQUEST);
            buffer.clear();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
