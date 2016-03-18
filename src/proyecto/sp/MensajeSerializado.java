package proyecto.sp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MensajeSerializado extends Mensaje implements ComportamientoMensaje{
    public void guardarUsuario(Mensaje m) throws Exception{
        ArrayList<Mensaje> mensaje= new ArrayList();
        File f = new File("Mensajes");
        try{
            if(f.exists()) mensaje = leerTodosLosMensajes();
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            mensaje.add(m);
            oos.writeObject(mensaje);
            System.out.println("Mensaje Guardado");
        }catch(Exception e){
            System.out.println("Hubo un error al guardar el mensaje");
        }
    }
    @Override
    public ArrayList<Mensaje> leerTodosLosMensajes() {
        
        ArrayList<Mensaje> m = new ArrayList();
        try{
            File f = new File("Mensajes");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            m = (ArrayList<Mensaje>) ois.readObject();
            
        }catch(IOException | ClassNotFoundException e ){
            System.out.println("hubo un error al leer el mensaje"+e.getMessage());
        }
        return m;
    }

    @Override
    public void guardar(Mensaje m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
