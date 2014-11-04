
import java.util.HashMap;

/**
 * Created by Jose on 02/11/2014.
 */

// on String[] of distance vector
// [0] = name of adjacent gate
// [1] = cost to send
public class DistanceVectorTable {
    private HashMap<String,String[]> distanceVectorRoutes = new HashMap<String, String[]>();
    private HashMap<String,String> adjacent = new HashMap<String, String>();

    //Methods to set, delete and get distanceVectorRoutes
    //Method isFaster used to compare if the new cost is faster than old

    public void setRoute(String peerName, String adjacentName, String peerCost){
        String[] distanceVectorArray = {adjacentName, peerCost};
        distanceVectorRoutes.put(peerName,distanceVectorArray);
    }

    public void deleteRoute(String peerName){
        distanceVectorRoutes.remove(peerName);
    }

    public String getRouteCost(String peerName){
        return(distanceVectorRoutes.get(peerName)[1]);
    }

    public String getRouteGate(String peerName){
        return (distanceVectorRoutes.get(peerName)[0]);
    }

    public boolean isFaster(String peerName, int cost){
        if(distanceVectorRoutes.containsKey(peerName)){
            String costTemp = distanceVectorRoutes.get(peerName)[1];
            int costToSend = Integer.parseInt(costTemp);
            if(costToSend < cost){
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    //methods to set,delete and get adjacent Nodes

    public void setGate(String gateName, String adjacentIp){
        adjacent.put(gateName,adjacentIp);
    }

    public void deleteGate(String gateName){
        adjacent.remove(gateName);
    }

    public String getGate(String adjacentName){
        return(adjacent.get(adjacentName));
    }

    //methor to get the complete Distance Vector table

    public HashMap getDistanceVectorTable(){
        return distanceVectorRoutes;
    }
}
