package server;
import javax.xml.ws.Endpoint;
/**
 * @author Torri
 */
public class ServerPublisher {
    static String port = "5335";//TODO: add filereader to get the ip/intput
    public static void go(){
        ServerImpl si = new ServerImpl(2);
        System.out.println("Started on 127.0.0.1:"+port);
        Endpoint.publish("http://127.0.0.1:"+port+"/RogueRerezzed", si);
    }
}
