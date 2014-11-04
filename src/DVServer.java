import java.io.BufferedReader;
import java.io.DataOutputStream;
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
    //instance variables
    protected DistanceVectorTable tableOfDistance = new DistanceVectorTable();
    static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected int serverPort;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;
    protected Thread runningThread = null;
    protected ExecutorService threadPool = Executors.newFixedThreadPool(10);
    protected InetAddress address;

    static DVServer server = null;

    public static boolean isServerRunning(){
        return server != null && server.isRunning;
    }

    public static void stop() {
        server.stopServer();
        server = null;
    }

    public static void start(InetAddress address, int port) {
        Ruteador.ruteadorWindow.println("Router iniciado en " + address.getHostAddress() + ":" + port);
        server = new DVServer(address, port);
        new Thread(server).start();
    }

    public DVServer(InetAddress address, int port) {
        this.serverPort = port;
        this.address = address;
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort, 0, address);
            isRunning = true;
        } catch (IOException e) {
            isRunning = false;
            this.serverSocket = null;
            isStopped = true;
            Ruteador.ruteadorWindow.println("Router detenido.");
            throw new RuntimeException("Cannot open port " + this.serverPort, e);
        }
    }

    protected boolean isRunning = false;

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
                    Ruteador.ruteadorWindow.println("Router detenido.");
                    return;
                }
                throw new RuntimeException(
                        "Error accepting client connection", e);
            }
            this.threadPool.execute(
                    new WorkerRunnable(clientSocket,tableOfDistance));
        }
        this.threadPool.shutdown();
        Ruteador.ruteadorWindow.println("Router detenido.");
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

}


class WorkerRunnable implements Runnable {

    protected Socket connect = null;
    protected DistanceVectorTable tableOfDistance = null;

    public WorkerRunnable(Socket clientSocket, DistanceVectorTable distanceTable) {
        this.tableOfDistance = distanceTable;
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

            //get From:<Name Router>
            String nameRouterComplete = in.readLine();
            //tokenizer From
            StringTokenizer parseNameRouter = new StringTokenizer(nameRouterComplete,":");
            //ignore "From"
            parseNameRouter.nextToken();
            //get name of Router
            String nameRouter = parseNameRouter.nextToken();

            //get "Type:<type>"
            String typeMessageComplete = in.readLine();
            //tokenizer Type
            StringTokenizer parseTypeMessage = new StringTokenizer(typeMessageComplete,":");
            //ignore "Type"
            parseTypeMessage.nextToken();
            //get type of message
            String typeMessage = parseTypeMessage.nextToken();

            if(typeMessage.equals("HELLO")){

                String message = "From:" + "name" + System.lineSeparator() + "Type:WELCOME\n";
                DataOutputStream outToClient = new DataOutputStream(connect.getOutputStream());
                outToClient.writeBytes(message + '\n');

            } else if(typeMessage.equals("DV")) {

                //get "Len:<leb>"
                String lengthOfMessage = in.readLine();
                //tokenizer Type
                StringTokenizer parseLengthMessage = new StringTokenizer(lengthOfMessage,":");
                //ignore "Type"
                parseLengthMessage.nextToken();
                //get type of message
                int len = Integer.parseInt(parseTypeMessage.nextToken());
                //for to save distanceVectorTable
                for (int i = 1; i <= len; i++) {
                    //get first line of request from client
                    String input = in.readLine();
                    if (input == null) throw new Exception("Invalid request");
                    StringTokenizer parse = new StringTokenizer(input, ":");
                    String peerName = parse.nextToken();
                    int dv = Integer.parseInt(parse.nextToken());
                    Target t = new Target(nameRouter, dv);
                    if(tableOfDistance.isFaster(peerName,dv)){
                        tableOfDistance.deleteRoute(peerName);
                        tableOfDistance.setRoute(peerName,t);
                    }
                    Ruteador.ruteadorWindow.println("Received target #" + i + ": " + t);
                }

            } else {
                Ruteador.ruteadorWindow.println("Invalid type of message");
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
