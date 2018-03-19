/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NMEAProxy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class LastSettings {
    
//Writing and Saving Configurations
public static void setPreference(String Key, String Value) {
    Properties configFile = new Properties();
    try {
        InputStream f = new FileInputStream("configNMEAProxy.xml");
        configFile.loadFromXML(f);
        f.close();
    }
    catch(IOException e) {
    }
    catch(Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    configFile.setProperty(Key, Value);
    //configFile.setProperty("mega", "cool");
    //configFile.clear();
    try {
        OutputStream f = new FileOutputStream("configNMEAProxy.xml");
        configFile.storeToXML(f,"Configuration file for the NMEA Proxy");
        
    }
    catch(Exception e) {
    }
}
//Reading Configurations    
public static String getPreference(String Key) {
    Properties configFile = new Properties();
    try {
        InputStream f = new FileInputStream("configNMEAProxy.xml");
        configFile.loadFromXML(f);
        f.close();
    }
    catch(IOException e) {
    }
    catch(Exception e) {
        JOptionPane.showMessageDialog(null , e.getMessage());
    }
    return (configFile.getProperty(Key));
}
    
}
