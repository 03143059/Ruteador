import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Werner on 10/15/2014.
 */
public class DVServer implements Runnable {

    //static variables
    // static boolean verbose = true;

    //instance variables
    static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected int serverPort;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;
    protected Thread runningThread = null;
    protected ExecutorService threadPool = Executors.newFixedThreadPool(10);
    protected InetAddress address;

    //constructor
//    public DVServer(Socket connect) {
//        this.connect = connect;
//        Ruteador.ruteadorWindow.println("Connection opened from: " +
//                connect.getRemoteSocketAddress() + " (" + df.format(new Date()) + ")");
//    }

    public DVServer(InetAddress address, int port) {
        this.serverPort = port;
        this.address = address;
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort, 0, address);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port " + this.serverPort, e);
        }
    }

    @Override
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
                    new WorkerRunnable(clientSocket));
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

    static DVServer server;

    public static void stop() {
        server.stopServer();
        server = null;
    }

    public static void start(InetAddress address, int port) {
        Ruteador.ruteadorWindow.println("Listenning for connections on " + address + ":" + port);
        server = new DVServer(address, port);
        new Thread(server).start();

    }

}


class WorkerRunnable implements Runnable {

    protected Socket connect = null;

    public WorkerRunnable(Socket clientSocket) {
        this.connect = clientSocket;
        Ruteador.ruteadorWindow.println("Connection opened from: " +
                connect.getRemoteSocketAddress() + " (" + DVServer.df.format(new Date()) + ")");
    }

    public void run() {
        BufferedReader in = null;

        try {
            // set timeout to 10 seconds so the clients don't block the server for ever
            connect.setSoTimeout(10000);
            //get character input stream from client
            in = new BufferedReader(new InputStreamReader(connect.getInputStream()));

            //get first line of request from client
            String input = in.readLine();
            if (input == null || !input.equals("Type:DV")) throw new Exception("Invalid request");
            input = in.readLine(); // get next line: Len:#
            //create StringTokenizer to parse request
            StringTokenizer parse = new StringTokenizer(input, ":");
            parse.nextToken(); // ignore Len
            //parse out length
            int len = Integer.parseInt(parse.nextToken());
            Ruteador.ruteadorWindow.println("Expecting " + len + " targets");
            for (int i = 1; i <= len; i++) {
                //get first line of request from client
                input = in.readLine();
                if (input == null) throw new Exception("Invalid request");
                parse = new StringTokenizer(input, ":");
                String ip = parse.nextToken();
                int dv = Integer.parseInt(parse.nextToken());
                Target t = new Target(ip, dv);
                Ruteador.ruteadorWindow.println("Received target #" + i + ": " + t);
            }
        } catch (SocketTimeoutException ste) {
            Ruteador.ruteadorWindow.println("Connection timeout");
        } catch (Exception ioe) {
            System.err.println("Server Error: " + ioe);
        } finally {
            try {
                in.close(); //close character input stream
                connect.close(); //close socket connection
            } catch (Exception e) {
                System.err.println("Error closing stream: " + e);
            }
            Ruteador.ruteadorWindow.println("Connection closed.");
        }
    }
}
