/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NMEAProxy;

import java.io.InputStream;
//import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Bernhard Bagyura
 */
public class MasterServer implements Runnable {
    private Socket mysocket;
    private ServerSocket myserversocket;
    private InputStream myinputstream;
    //private final String ip;
    private final int port;
    private final Starter mystarter;
    private boolean stopme;
    
    public MasterServer(Starter mystarter, int port) {
        this.mystarter = mystarter;
        this.stopme = false;
        this.port = port;
    }
    
     @Override
    public void run() {
        
        connect();    
        
        while (stopme == false){
            try {
                byte z[]= new byte[200]; 
                //System.out.println("Bin in der Schleife bbg" + z);
                int laenge = myinputstream.read(z);
                
                if (laenge == -1) {
                    System.out.println("Master Server Länge ist: "+laenge);
                    mystarter.changeConnectionStatusServer(false);
                    connect();
                }
                for (int i = 0; i < laenge; i++) {
                    mystarter.dowrite(z[i]);
                }
            } catch (Exception e) {
                System.out.println("MasterServer BBG2" + e);
                try{
                    myinputstream.close();
                    mysocket.close();
                    myserversocket.close();
                } catch (Exception f){
                    System.out.println("MasterServer BBG3" + f);
                      }
                mystarter.changeConnectionStatusServer(false);
                connect();
            }
        }
    }
    
    private void connect(){
        try {
 
            myserversocket = new ServerSocket(port);
                    //System.out.println("Socket Port: " + port);
            
            mysocket = myserversocket.accept();
                    //System.out.println("Accept passiert");
                    mystarter.changeConnectionStatusServer(true);
               
            myinputstream = mysocket.getInputStream();
                    //System.out.println("input stream");
                    
            myserversocket.close();
            
        } catch (Exception e) {
            System.out.println("Master Server BBG1" + e);
            //JOptionPane.showMessageDialog(null, "Abbruch!");
            stopme = true;
        }
    }
    
    
    public void setStopme(boolean stopme) {
        
        try {
            myinputstream.close();
                        
        } catch (Exception e) {
            //System.out.println("Master Server Zeile myinputstream" + e);
        }
        try {
            mysocket.close();
            
        } catch (Exception e) {
            //System.out.println("Master Server Zeile mysocket" + e);
        }
        try {
            myserversocket.close();
        } catch (Exception e) {
            //System.out.println("Master Server Zeile myserversocket" + e);
        }
        this.stopme = stopme;
    }
            
}
