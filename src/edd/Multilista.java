/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

import chat.frames.Cliente1Enviados;
import chat.frames.Cliente2Enviados;
import chat.frames.Cliente2Recibidos;
import chat.frames.Cliente3Enviados;
import chat.frames.Cliente3Recibidos;
import chat.frames.ClienteRecibidos;
import chat.modelo.DetalleMensaje;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauro
 */
public class Multilista implements java.io.Serializable{

    Cliente1Enviados cli = null;
    ClienteRecibidos cliRec = null;
    
    Cliente2Enviados cli2 = null;
    Cliente2Recibidos cliRec2 = null;
    
    Cliente3Enviados cli3 = null;
    Cliente3Recibidos cliRec3 = null;

    public Multilista() {

    }

    public Nodo inserta(Nodo r, int nivel, String s[], Nodo n) {
        if (s.length - 1 == nivel) {
            Listas obj = new Listas(); // técnico
            obj.r = r;
            obj.insertaLista(n);
            return obj.r;
        } else {
            Nodo aux = busca(r, s[nivel]);
            if (aux != null) {
                aux.setAbj(inserta(aux.getAbj(), nivel + 1, s, n));
            }
            return r;
        }
    }

    public Nodo busca(Nodo r, String s) {
        Listas obj = new Listas();
        obj.r = r;
        return obj.busca(s);
    }

    public void llamarDespligar(Nodo r, String s, Cliente1Enviados cli) throws IOException {
        this.cli = cli;
        this.despligar(r, s);
       
    }

    public void despligar(Nodo r, String s) {
        while (r != null) {

            if (r.getD().equals("Recibidos")) {
                break;
            }
            if (!r.getD().equals("Enviados")) {
                cli.setText(s + r.getD());
              
            }
            despligar(r.getAbj(), s);

            r = r.getSig();

        }
    }

    public void llamarDespligarRecibidos(Nodo r, String s, ClienteRecibidos cli) throws IOException, Exception {
        this.cliRec = cli;
        this.despligarRecibidos(r, s);
        
    }

    public void despligarRecibidos(Nodo r, String s) throws IOException, Exception {
        try {
            //FileOutputStream fos = new FileOutputStream(new File("output.dat"));
            //List<Object> listaRecibidos = new ArrayList<>();
           
            while (r != null) {
            if (r.getD().equals("Enviados")) {
                r = r.getSig();
            }
            
            if (!r.getD().equals("Recibidos")) {
                cliRec.setText(s + r.getD());
                //listaRecibidos.add(r.getD());
                //guardarEnArchivo(listaRecibidos , 1);

            }

            //System.out.println(s + r.getD());
            despligarRecibidos(r.getAbj(), s );
            r = r.getSig();

        }
          
     
             //fos.close();
            
        } catch (IOException ex) {
               ex.printStackTrace();
        }
        
    }
    
    public void llamarDespligar3(Nodo r, String s, Cliente3Enviados cli) {
        this.cli3 = cli;
        this.despligar3(r, s);
    }

    public void despligar3(Nodo r, String s) {
        List<Object> listaRecibidos = new ArrayList<>();
        while (r != null) {

            if (r.getD().equals("Recibidos")) {
                break;
            }
            if (!r.getD().equals("Enviados")) {
                cli3.setText(s + r.getD());
                
                //guardarEnArchivo(listaRecibidos , 3);
            }
            despligar3(r.getAbj(), s);

            r = r.getSig();

        }
    }

    public void llamarDespligarRecibidos3(Nodo r, String s, Cliente3Recibidos cli) throws IOException {
        this.cliRec3 = cli;
        this.despligarRecibidos3(r, s);
    }

    public void despligarRecibidos3(Nodo r, String s) throws IOException {
        while (r != null) {
            if (r.getD().equals("Enviados")) {
                r = r.getSig();
            }
            
            if (!r.getD().equals("Recibidos")) {
                cliRec3.setText(s + r.getD());
                //guardarEnArchivo(r, s, 3);
            }
            
            
            System.out.println(s + r.getD());
            despligarRecibidos3(r.getAbj(), s );

            r = r.getSig();
        }
    }
    
    public void llamarDespligar2(Nodo r, String s, Cliente2Enviados cli) throws IOException {
        this.cli2 = cli;
        this.despligar2(r, s);
    }

    public void despligar2(Nodo r, String s) throws IOException {
        while (r != null) {

            if (r.getD().equals("Recibidos")) {
                break;
            }
            if (!r.getD().equals("Enviados")) {
                cli2.setText(s + r.getD());
               
            }
            despligar2(r.getAbj(), s);

            r = r.getSig();

        }
    }

    public void llamarDespligarRecibidos2(Nodo r, String s, Cliente2Recibidos cli) throws FileNotFoundException, IOException {
        this.cliRec2 = cli;
        this.despligarRecibidos2(r, s);
    }

    public void despligarRecibidos2(Nodo r, String s) throws FileNotFoundException, IOException {
        while (r != null) {
            if (r.getD().equals("Enviados")) {
                r = r.getSig();
            }
            
            if (!r.getD().equals("Recibidos")) {
                cliRec2.setText(s + r.getD());
                //guardarEnArchivo(r, s, 2);
                //recorrido(r);
            }
            
            
            System.out.println(s + r.getD());
            despligarRecibidos2(r.getAbj(), s );

            r = r.getSig();
        }
    }
    
    public void guardarEnArchivo(List<Object> listaRecibidos, int i) throws FileNotFoundException, IOException{
        
        try {
    // create a writer
FileOutputStream file = new FileOutputStream("MensajesRecibidos"+i+".dat", true);
DataOutputStream escritura = new DataOutputStream(file);
   

    // write data to file
            for (int j = 0; j < listaRecibidos.size() ; j++) {
                //fos.write((int) listaRecibidos.get(i));
                escritura.writeUTF((String) listaRecibidos.get(j));
                
            }
  escritura.close();
       
       
   
    
    
    


} catch (IOException ex) {
    ex.printStackTrace();
}
        
      
        /*FileOutputStream file = new FileOutputStream("MensajesRecibidos"+i+".dat");
	ObjectOutputStream escritura = new ObjectOutputStream(file);
        escritura.writeObject( s + r.getD());
        
        
	escritura.close();
        System.out.println("si entra");*/
        
        
        
    }
    public  void leerArchivo(int i){
       
        try {
    // create a reader
    FileInputStream fis = new FileInputStream(new File("MensajesRecibidos"+i+".dat"));

    // read one byte at a time
    int ch;
    while ((ch = fis.read()) != -1) {
        System.out.print((char) ch);
    }

    // close the reader
    fis.close();

} catch (IOException ex) {
    ex.printStackTrace();
}
        
        	
        
      
    }
    public  void writeDatFile(Nodo r, String s)
			throws Exception {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("nuevo.dat");
			oos = new ObjectOutputStream(fos);
                         Nodo aux = r;
        while (aux !=null)
        {
            //System.out.println(aux);
            //System.out.println(aux.getD() + "-");
            oos.writeObject(s + aux.getD());
				oos.flush();
			
            
            aux = aux.getSig();                 
        }
			
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (oos != null) {
				oos.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
	}

    
     public void recorrido(Nodo r, String s, int i) throws IOException, Exception
     {
         List<Object> listaRecibidos = new ArrayList<>();

        Integer a = 0;
        System.out.println("jdhdfjsh");
         while (r != null) {
            if (r.getD().equals("Enviados")) {
                r = r.getSig();
            }
            if (!r.getD().equals("Recibidos")) {
                a++;
                Node rootRecibidos = new Node(0);
                rootRecibidos.add(a);
                System.out.println("--" + s + r.getD());
               listaRecibidos.add(r.getD());
                System.out.println("lista" + listaRecibidos);
                guardarEnArchivo(listaRecibidos, i);
                
            }

            //System.out.println(s + r.getD());
            recorrido(r.getAbj(), s , i);
            r = r.getSig();
            
            

        }
    }
     
     
     

    public void recorrido(Nodo r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

}
