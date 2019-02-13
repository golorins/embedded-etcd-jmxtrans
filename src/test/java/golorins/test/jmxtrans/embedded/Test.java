package golorins.test.jmxtrans.embedded;

import golorins.jmxtrans.embedded.EtcdEmbeddedJmxTrans;

public class Test {

    public Test() {

    }

    public static void main(String[] args) {

        // Start UDP listener for Statsd port 8125
        StatsdUDPDummyListner listener = new StatsdUDPDummyListner();
        Thread lt = new Thread(listener);
        lt.start();

        System.setProperty(EtcdEmbeddedJmxTrans.JMXTRANS_CONFIG, "file:./jmxtrans-config-test.json,file:./frequency-10sec.json,file:./out-statsd.json");
        EtcdEmbeddedJmxTrans jmxt = new EtcdEmbeddedJmxTrans();
        jmxt.init();
        
        // Wait for a while
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jmxt.stop();
        
        listener.stop();
        
    }

}
