/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaschat;

import chat.frames.Chat;
import chat.frames.Chat2;
import chat.frames.Formulario;
import chat.frames.Login;
import chat.modelo.DetalleMensaje;
import edd.Multilista;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Usuario
 */
public class SistemasChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Chat chat = new Chat();
        chat.setVisible(true);
        Chat2 chat2 = new Chat2();
        chat2.setVisible(true);
        Server servidor = new Server();
        /*Multilista ml = new Multilista();
        ml.leerArchivo();*/
        
        /*Login login = new Login();
        login.setVisible(true);*/
        
      /* try {
    // create a reader
    FileInputStream fis = new FileInputStream(new File("output.dat"));

    // read one byte at a time
    int ch;
    while ((ch = fis.read()) != -1) {
        System.out.print((char) ch);
    }

    // close the reader
    fis.close();

} catch (IOException ex) {
    ex.printStackTrace();
}*/
        
        
        
        
        
        
        
    }
  
    
}
