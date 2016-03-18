package proyecto.sp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfiguracionServicios {
    @Bean
    public ComportamientoMensaje miServicioMensaje(){
        return new MensajeMySql();
    }
}
