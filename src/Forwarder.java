/**
 * Created by Werner on 9/10/2014.
 * http://ipsit.bu.edu/sc546/sc546Fall2002/RIP2/RIP/
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Forwarder implements Runnable {
    static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected int serverPort;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;
    protected Thread runningThread = null;
    protected ExecutorService threadPool = Executors.newFixedThreadPool(10);
    protected InetAddress address;

    static Forwarder server;

    public static void stop() {
        server.stopServer();
        server = null;
    }

    public static void start(InetAddress address, int port) {
        Ruteador.ruteadorWindow.println("Listenning for connections on " + address + ":" + port);
        server = new Forwarder(address, port);
        new Thread(server).start();

    }

    public Forwarder(InetAddress address, int port) {
        this.serverPort = port;
        this.address = address;
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort, 0, address);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port " + serverPort, e);
        }
    }

    public void run() {
        synchronized (this) {
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();
        while (!isStopped()) {
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if (isStopped()) {
                    Ruteador.ruteadorWindow.println("Server Stopped.");
                    return;
                }
                throw new RuntimeException(
                        "Error accepting client connection", e);
            }
            this.threadPool.execute(
                    new WorkerRunnable(clientSocket,
                            "Thread Pooled Server"));
        }
        this.threadPool.shutdown();
        Ruteador.ruteadorWindow.println("Server Stopped.");
    }


    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stopServer() {
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    class WorkerRunnable implements Runnable {

        protected Socket clientSocket = null;
        protected String serverText = null;

        public WorkerRunnable(Socket clientSocket, String serverText) {
            this.clientSocket = clientSocket;
            this.serverText = serverText;
            Ruteador.ruteadorWindow.println("Connection opened from: " +
                    clientSocket.getRemoteSocketAddress() + " (" + DVServer.df.format(new Date()) + ")");
        }

        public void run() {
            try {
                InputStream input = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();
                long time = System.currentTimeMillis();
                output.write(("HTTP/1.1 200 OK\n\nWorkerRunnable: " +
                        this.serverText + " - " +
                        time +
                        "").getBytes());
                output.close();
                input.close();
                Ruteador.ruteadorWindow.println("Request processed: " + time);
            } catch (IOException e) {
                //report exception somewhere.
                e.printStackTrace();
            }
        }
    }
}
