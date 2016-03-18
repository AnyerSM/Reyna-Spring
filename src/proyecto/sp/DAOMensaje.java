package proyecto.sp;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Component;

public class DAOMensaje {
    
    public  SessionFactory sessionFactory;
    public  Session session;
    public  Transaction transaction;
    public DAOMensaje(){
     sessionFactory=   HibernateUtilidades.getSessionFactory();
     session=sessionFactory.openSession();
     transaction=session.beginTransaction();
    }
    private void cerrarTodo(){
        transaction.commit();
        session.close();
    }
    //GUARDAR
    public void guardar(Mensaje obj)throws Exception{
        session.save(obj);
        cerrarTodo();
    }
    //BUSCAR TODOS
    ArrayList<Mensaje> buscarTodos() throws Exception{
        ArrayList<Mensaje>objs=  (ArrayList<Mensaje>) session.createCriteria(Mensaje.class).list();
        cerrarTodo();
        return objs;
    }
 //BUSCAR POR ID
      public Mensaje buscarPorId(Integer id) throws Exception{
      Mensaje c=(Mensaje) session.createCriteria(Mensaje.class).add(Restrictions.idEq(id)).uniqueResult();
  cerrarTodo();
         //c=(Mensaje) session.createCriteria(Mensaje.class).add(Restrictions.idEq(c.getIdCliente())).uniqueResult();
    return c;
    }
  //ACTUALIZAR
    public void actualizar(Mensaje c)throws Exception{
         session.update(c);
         cerrarTodo();
    }
//BORRAR
    public void   borrar(Integer id)throws Exception{
        Mensaje c=new Mensaje();
            c.setId(id); 
            session.delete(c);
            cerrarTodo();    
    }
}   