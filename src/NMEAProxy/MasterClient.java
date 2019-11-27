/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NMEAProxy;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Bernhard Bagyura
 */
public class MasterClient implements Runnable {
    private Socket mysocket;
    private InputStream myinputstream;
    private final String ip;
    private final int port;
    private final Starter mystarter;
    private boolean stopme;
    private boolean tryreconnect;
    
    public MasterClient(Starter mystarter, String ip, int port) {
        this.mystarter = mystarter;
        this.stopme = false;
        this.ip = ip;
        this.port = port;
        this.tryreconnect = true;
    }
    
     @Override
    public void run() {
        
        connect();
              
        while (stopme == false){
            try {
                byte z[]= new byte[200]; 
                int laenge = myinputstream.read(z);
                System.out.println("Laenge: " + laenge);
                if (laenge == -1){
                    tryreconnect = true;
                    connect();
                }
                for (int i = 0; i < laenge; i++) {
                    mystarter.dowrite(z[i]);
                }
            } catch (Exception e) {
                System.out.println("neue Meldung xyz: " + e);
            }
        }
    }
    
    
     private void connect(){    
        while (tryreconnect == true && stopme == false){
            try {
              mysocket = new Socket(InetAddress.getByName(ip), port);
              mysocket.setSoTimeout(5000);
              myinputstream = mysocket.getInputStream();
              tryreconnect = false;
              
            
           } catch (Exception e) {
             System.out.println("Keine Verbindung" + e);
              //JOptionPane.showMessageDialog(null, "Verbidung fehlgeschlagen!");
              tryreconnect = true;
              //stopme = true;
          }
        }
    }
    
    public void setStopme(boolean stopme) {
        
        try {
            myinputstream.close();
            mysocket.close();
        } catch (Exception e) {
            System.out.println("Master Client Zeile 67" + e);
        }
        this.stopme = stopme;
    }
            
}
