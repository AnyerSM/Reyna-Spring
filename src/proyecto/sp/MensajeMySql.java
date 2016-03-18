package proyecto.sp;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class MensajeMySql extends Mensaje implements  ComportamientoMensaje{
    public SessionFactory sessionFactory;
    public Session session;
    public Transaction transaction;

    public MensajeMySql() {
        sessionFactory = HibernateUtilidades.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }
    public void cerrarTodo(){
        transaction.commit();
        session.close();
    }
    @Override
    public ArrayList<Mensaje> leerTodosLosMensajes() {
//Aqui va el DAOMensaje
        ArrayList<Mensaje> m = (ArrayList<Mensaje>) session.createCriteria(Mensaje.class).list();
        cerrarTodo();
        return m;
    }

    @Override
    public void guardar(Mensaje m) {
        session.save(m);
        cerrarTodo();
    }
    
}
