/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NMEAProxy;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Bernhard Bagyura
 */
public class ClientConnection implements Runnable {
    
    private final ServerSocket myServerSocket;
    private final Starter starter;
    private final int akt;
    private Socket mysocket;
    private OutputStream myoutputstream;
    private boolean isRestart;
    
    /**
     *
     * @param myServerSocket
     * @param akt
     * @param starter
     * @param isRestart
     * 
     * Stellt einen Server Thread für eine Client Verbindung da.
     * Server Socket ist der allg. gültige Serversocket
     * akt ist der array index der client connections
     * Starter den Verwie auf die Instanz von Starter
     * 
     */
    public ClientConnection(ServerSocket myServerSocket, int akt, Starter starter, boolean isRestart) {
        this.myServerSocket = myServerSocket;
        this.akt = akt;
        this.starter = starter;
        this.isRestart = isRestart;
    }
    
    @Override
    public synchronized void run() {
        try {
            mysocket = myServerSocket.accept();
            //System.out.println("Verbindung akzeptiert: " + this.toString());
            myoutputstream = mysocket.getOutputStream();
            
            starter.incrementAktive();
        
        // Startet eine neu Instanz von Client Connection
        // wenn sich ein Client verbunden hat und es kein Restart ist
            if (isRestart == false) {
                starter.nextclient(akt + 1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            //System.out.println("Thread waiting: " + akt);
            wait(); 
            
        } catch (Exception e) {
        }
        System.out.println("Thread finished: " + akt);
    }
 
    /**
     *
     * @param a
     * byte a wird in myoutputstream geschrieben. bei exception wird der thread gestoppt
     * die anzeige für die aktiven Verbindungen decrementiert unt eine neue instanz gestartet
     */
    public void write (byte a){
        
        //myoutputstream.write(a);
        
        try {
            myoutputstream.write(a);
        } catch (IOException e) {
            //System.out.println("Akt: "+ akt + "ClientConnection Exception in Write: " + e);
            stopme();
            starter.decrementAktive();
            starter.restartConnection(akt);
        } catch (Exception e) {
            //System.out.println("Was auch immer");
        }
    }
    
    /**
     * Stoppt die Instanz der Client Connection
     */
    public synchronized void stopme(){
        try {
             mysocket.close();
             myoutputstream.close();
             //System.out.println("Class ClientConnection Socket close for Thread: " + this.toString());
             notify();
             
        } catch (Exception e) {
            //System.out.println("Class ClientConnection exception Close Socket Connection: " +  e);
        }
    }
    
}
