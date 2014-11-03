import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Werner on 10/15/2014.
 */
public class UpdateService {

//    //public static InetAddress address = null;
//    //public static int FORWARD_PORT = 9080; //default port
//    //public static boolean verbose = false;
//
//    public static void main2(String[] args) throws Exception {
//        if (args.length > 0) {
//            int num = 0; // numero de interface
//            FileInputStream fin = null; // archivo de entrada
//            for (int i = 0; i < args.length; i++) {
//                if (args[i].equals("-v") || args[i].equals("-verbose")) {
//                    verbose = true; //print status to standard out
//                } else if (args[i].equals("-?") || args[i].equals("-help") || args[i].equals("-h")) {
//                    showHelp();
//                } else if (args[i].equals("-i")) {
//                    if (args.length > (i + 1) && !args[i+1].startsWith("-") ){
//                        // hay interface seleccionada
//                        try {
//                            num = Integer.parseInt(args[i+1]);
//                        } catch (NumberFormatException nfe) {
//                        }
//                        i++;
//                    }
//                } else if (args[i].equals("-f")) {
//                    if (args.length > (i + 1) && !args[i+1].startsWith("-") ){
//                        // hay archivo de entrada
//                        try {
//                            fin = new FileInputStream(args[i+1]);
//                        } catch (IOException nfe) {
//                        }
//                        i++;
//                    } else showHelp();
//                } else showHelp();
//            } // end-for
//
//            selectInterface(num); // mostrar interfaces o la interfaz seleccionada
//
//              // iniciar thread del servicio
//
//            Thread.sleep(500); // esperar un momento
//
//DistanceVectorMessage message = new DistanceVectorMessage();
//    BufferedReader in = new BufferedReader(new InputStreamReader((fin == null)?System.in:fin));
//    if (fin == null) {
//        System.out.println("Ingrese los destinos y los distance vectors en la forma: IP_ADDRESS:DV");
//        System.out.println("Ingrese una linea en blanco para terminar.");
//    } else {
//        System.out.println("Leyendo destinos del archivo de entrada.");
//    }
//    String l;
//    while ((l = in.readLine()) != null && l.length() > 0) {
//        StringTokenizer st = new StringTokenizer(l, ":");
//        String ip = st.nextToken();
//        int dv = Integer.parseInt(st.nextToken());
//        message.add(new Target(ip, dv));
//    }
//    in.close();
//    if (fin != null) fin.close();
//    System.out.println();
//    System.out.println("Mensaje a enviar:");
//    System.out.println("------------------");
//    System.out.println(message);
//    DVClient client = new DVClient(FORWARD_PORT);
//    System.out.print("Enviando mensaje a los adyacentes: ");
//    client.send(message);
//
//            System.out.println();
//            System.out.println("El servidor sigue ejecutandose.");
//            System.out.println("Presione Ctrl+C para interrumpir el programa.");
//            System.out.println();
//
//        } else {
//            showHelp();
//        }
//    }

    /**
     * los destinos y los distance vectors en la forma: IP_ADDRESS:DV
     * @param list
     */
    public void SendMessage(List<String> list, int port){
        DistanceVectorMessage message = new DistanceVectorMessage();

        for (String l : list) {
            StringTokenizer st = new StringTokenizer(l, ":");
            String ip = st.nextToken();
            int dv = Integer.parseInt(st.nextToken());
            message.add(new Target(ip, dv));
        }
        DVClient client = new DVClient(port);
        //Enviando mensaje a los adyacentes
        client.send(message);
    }

}

