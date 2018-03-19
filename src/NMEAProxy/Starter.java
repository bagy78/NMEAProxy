/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NMEAProxy;

import java.net.ServerSocket;


 /**   
 *
 * @author Bernhard Bagyura
 */
public class Starter {
    
    
    private ClientConnection[] clients;
    private final int index;
    private ServerSocket myServerSocket;
    private int verbindungen;
    private Thread tclients[];
    private MasterClient mymasterclient;
    private Thread tmasterclient;
    private MasterServer mymasterserver;
    private Thread tmymasterserver;
    private int serverport; 
    private int aktiveverbindungen;
    private final GUI gui;

    /**
     *
     * @param index
     * @param serverport
     * @param gui
     * 
     * index Anzahl der Client Verbindungen
     * Serverport ist klar
     * gui die Instanz des GUI
     */
    public Starter(int index, int serverport, GUI gui) {
        this.index = index;
        this.verbindungen = 0;
        this.tclients = new Thread[index];
        this.serverport = serverport;
        this.aktiveverbindungen = 0;
        this.gui = gui;
    }

    /**
     *
     * @param ip
     * @param port
     * 
     * Startet die Instanz von Masterclient mit ip und port
     */
    public void startMasterClient(String ip, int port){
        mymasterclient = new MasterClient(this, ip, port);
        tmasterclient = new Thread(mymasterclient);
        tmasterclient.start();
    }
    
    public void startMasterServer(int port){
        mymasterserver = new MasterServer(this, port);
        tmymasterserver = new Thread(mymasterserver);
        tmymasterserver.start();
    }
    
    /**
     * Wird direkt beim drücken von Start aufgerufen 
     * Diese Funktion erstellt die multiple Serverinstanz 
     */
    public void begin(){
        try {
            myServerSocket = new ServerSocket(serverport);
        } catch (Exception e) {
            System.out.println("in Main try ServerSocket " + e);
        }
        clients = new ClientConnection[index];
        nextclient(verbindungen);
    }
    
    /**
     *
     * @param akt
     * wenn eine clientverbindung abbrcht wird diese instanz beendet und 
     * ene neue geöffnet
     */
    public void restartConnection(int akt){
        if (myServerSocket.isClosed() == true){
            try {
                myServerSocket = new ServerSocket(serverport);  
                System.out.println("wird der socket neu geöffnet?: ja");
            } catch (Exception e) {
            }
        }
        tclients[akt].interrupt();
        clients[akt] = new ClientConnection(myServerSocket, akt, this, true);
        tclients[akt] = new Thread(clients[akt]);
        tclients[akt].start(); 
       
        
    }
        
    

    /**
     *
     * @param akt
     * erstellt neue client connection iinerhalb des arrays thread 
     */
    public void nextclient(int akt){
        
         if (akt < index) {
            clients[akt] = new ClientConnection(myServerSocket, akt, this, false);
            tclients[akt] = new Thread(clients[akt]);
            tclients[akt].start();
            
            System.out.println("Erstellung: " + tclients[akt].getId() +" "+ tclients[akt].getName());
            verbindungen++;
            System.out.println(verbindungen + ": Verbindunge geöffnet" );
         }else {
             System.out.println("maximale Verbindungen erreicht");
             //Dieser Zweig darf nicht fehlen, weil sonst verbindungen++ fehlt und die letzte instant nicht beschrieben wird.
             verbindungen ++;
             try {
                 myServerSocket.close();
             } catch (Exception e) {
                 System.out.println("Starter Zeile 121" + e);
             }
             
         }
 
        
    }
    
    // Schreibt ein Byte an alle geöffneten Clients die Verbindung haben

    /**
     *
     * @param a
     * byte a wird an alle offenen threads geschrieben
     */
    public void dowrite(byte a){
        for (int i = 0; i < (verbindungen + 1); i++) {
            if (i < (verbindungen - 1)) {
                clients[i].write(a);  
                //System.out.println("i ist:" + i +" Verbindungen:" + verbindungen + " Index:" + index);
            }
        }
    }
    
    /** Stoppt in der Schleife alle geöffneten Sockets
     * 
     */ 
    public void stopmyclients(){
        for (int i = 0; i < (verbindungen -1); i++) {
            //System.out.println("Thread Status " + tclients[i].isAlive());
            clients[i].stopme();
            //notify wird in der Funktion selbst gesendet. 
        }
        
        try {
            myServerSocket.close();
            System.out.println("Starter stopmyclients Zeile 116 Server Socket close");
        } catch (Exception e) {
            System.out.println("Server Socket Close Error: Starter Zeile 118 " + e);
        }
    }
    
    /** Stoppt den Masterclient
     * 
     */
    public void stopmasterconnection(){
        System.out.println("xy");
        try {
           
            mymasterserver.setStopme(true);
        } catch (Exception e) {
            System.out.println("scheinbar kein masterserver aktiv: " + e);
        }
        try {
            mymasterclient.setStopme(true);
        } catch (Exception e) {
            System.out.println("scheinbar kein masterserver aktiv: " + e);
        }
        
    }
    
    /**
     * Beendet das geöffnente Serversocket mit der Methode .close()
     */
    public void stopmyServerSocket(){
        try {
            myServerSocket.close();
        } catch (Exception e) {
        }
    }

    /**
     *
     * @return
     * gibt die anzahl der aktiven verbindungen zurück
     */
    public int getAktiveverbindungen() {
        return aktiveverbindungen;
    }

    /**
     *erhöht die anzahl der aktiven verbindungen
     */
    public void incrementAktive() {
        aktiveverbindungen++;
        System.out.println("Aktive Verbindungen: " + aktiveverbindungen);
        gui.setActiveVerbindungen(aktiveverbindungen);
        if (aktiveverbindungen == index) {
            System.out.println("Max Verbindungen");
            try {
                myServerSocket.close();
            } catch (Exception e) {
                System.out.println("Starter incrementAvtice Line 152: " + e);
            }
        }
    }
    
    /**
     *verringert die anzahl der aktiven verbindugnen
     */
    public void decrementAktive() {
        aktiveverbindungen--;
        System.out.println("Aktive Verbindungen: " + aktiveverbindungen);
        gui.setActiveVerbindungen(aktiveverbindungen);
    }
    
}


