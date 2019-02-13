
package golorins.test.jmxtrans.embedded;

import java.net.*;

public class StatsdUDPDummyListner implements Runnable {

    private final static int MAXSIZE = 1500;
    private volatile boolean _canRun = true;

    public StatsdUDPDummyListner() {

    }

    public void run() {

        try {
            int port = 8125;
            // Construct the socket
            DatagramSocket socket = new DatagramSocket(port);

            System.out.println("Listening...");
            while (_canRun) {
                DatagramPacket packet = new DatagramPacket(new byte[MAXSIZE], MAXSIZE);
                socket.receive(packet);
                System.out.println(new String(packet.getData()));
            }
            
            socket.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void stop () {
        _canRun = false;
    }
}