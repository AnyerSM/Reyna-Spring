package proyecto.sp;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//uri
@RequestMapping("/")
public class ControladorMensaje {

    @RequestMapping(value="/mensaje/{id}", method=RequestMethod.GET, headers = {"Accept=application/json"})
    @ResponseBody String buscarPorId(@PathVariable Integer id)throws Exception{
        DAOMensaje dao = new DAOMensaje();
        Mensaje m = dao.buscarPorId(id);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(m);
    }
    @CrossOrigin
    @RequestMapping(value = "/menshje/{titulo}/{cuerpo}", method = RequestMethod.POST, headers ={"Accetpt=text/html"})
    @ResponseBody String guardarMensaje(@PathVariable String titulo, @PathVariable String cuerpo) throws Exception{
        Mensaje m= new Mensaje();
        m.setTitulo(titulo);
        m.setCuerpo(cuerpo);
        miServicioMensaje.guardar(m);
        return "Mensaje gusrdado con exito";
    }
    @Autowired ComportamientoMensaje miServicioMensaje;
    @RequestMapping(value="/mensaje",method=RequestMethod.GET,headers={"Accept=application/json"})
    @ResponseBody String buscartodosp() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        
        ArrayList<Mensaje> mensaje = miServicioMensaje.leerTodosLosMensajes();
        return mapper.writeValueAsString(mensaje);
    }
}
