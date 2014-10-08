/**
 * Created by Werner on 9/10/2014.
 * http://ipsit.bu.edu/sc546/sc546Fall2002/RIP2/RIP/
 */
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Enumeration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Forwarder implements Runnable {
    //instance variables
    String packet;
    InetAddress sender;

    //constructor
    public Forwarder(InetAddress sender, String packet) {
        this.packet = packet;
        this.sender = sender;
    }

    /**
     * run method services each request in a separate thread.
     */
    public void run() {
        String msg = "Received UDP from " + sender.getHostAddress() + ": " + packet;
        System.out.println(msg);
        Ruteador.ruteadorWindow.log(msg);
    }

    private void sendPacket(String sender, String recipient, String message) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        String sentence = String.format("%s|%s|%s", sender, recipient, message);
        byte[] sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, Ruteador.address, Ruteador.PORT);
        clientSocket.send(sendPacket);
        String msg = "Sent packet: " + sentence;
        System.out.println(msg);
        Ruteador.ruteadorWindow.log(msg);
        clientSocket.close();
    }
}
