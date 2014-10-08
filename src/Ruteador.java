/**
 * Created by Werner on 9/10/2014.
 */
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Enumeration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Ruteador {
    public static InetAddress address = null;
    public static int PORT = 5555; //default port
    public static RuteadorWindow ruteadorWindow;

    public static void main(String[] args) throws IOException {
        if (args.length > 0 && args[0].equals("-i")) {
            int num = 0;
            if (args.length == 2)
                try {
                    num = Integer.parseInt(args[1]);
                } catch(NumberFormatException nfe){
                }
            Enumeration nifEnm = NetworkInterface.getNetworkInterfaces();
            while (nifEnm.hasMoreElements()) {
                NetworkInterface nif = (NetworkInterface)nifEnm.nextElement();
                if (!nif.isLoopback() && nif.getInterfaceAddresses().size() > 0) {
                    Enumeration addrEnum = nif.getInetAddresses();
                    int i = 0;
                    while (addrEnum.hasMoreElements()) {
                        InetAddress a = (InetAddress)addrEnum.nextElement();
                        if (a instanceof Inet4Address) {
                            if (i == 0){
                                if (num == 0)// mostrar interfaces?
                                    System.out.println(String.format("%d\t%s\t%s",
                                            nif.getIndex(), nif.getName(), nif.getDisplayName()));
                            }
                            i++;
                            // mostrar interfaces?
                            if (num == 0)
                                System.out.println("\t" + a.getHostAddress());
                            else if (num == nif.getIndex())
                                address = a;
                        }
                    } // end-while address
                }
            } // end-while interfaces
            if (address == null) {
                if (num > 0)
                    System.err.println("El numero de interfaz es invalido!");
                System.exit(2);
            }

            System.out.println("Utilizando IP: " + address.getHostAddress());

            // Start window
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    ruteadorWindow = new RuteadorWindow(address.getHostName());
                }
            });

            // Start server thread
            (new Thread() {
                public void run() {
                    int corePoolSize = 5;
                    int maxPoolSize = 10; // accept 10 clients max by default
                    long keepAliveTime = 5000;

                    // iniciar servidor
                    ExecutorService threadPoolExecutor =
                            new ThreadPoolExecutor(
                                    corePoolSize,
                                    maxPoolSize,
                                    keepAliveTime,
                                    TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>()
                            );

                    try {
                        DatagramSocket serverSocket = new DatagramSocket(PORT, InetAddress.getByName(address.getHostAddress()));
                        byte[] receiveData = new byte[1024];
                        while (true) {
                            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                            serverSocket.receive(receivePacket);
                            String packet = new String(receivePacket.getData()).trim();
                            InetAddress sender = receivePacket.getAddress();
                            Forwarder forwarder = new Forwarder(sender, packet);
                            //create new thread using a thread pool
                            threadPoolExecutor.execute(forwarder);
                        }
                    } catch (Exception e) {
                        threadPoolExecutor.shutdown();
                        System.err.println("Server error: " + e);
                    }
                }
            }).start();


        } else {
            System.out.println("Uso: java Ruteador -i [interface]");
            System.exit(1);
        }
    }

}
