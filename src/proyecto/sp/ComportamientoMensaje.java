package proyecto.sp;

import java.util.ArrayList;

public interface ComportamientoMensaje {
    ArrayList<Mensaje>leerTodosLosMensajes();
    public void guardar (Mensaje m);
}
