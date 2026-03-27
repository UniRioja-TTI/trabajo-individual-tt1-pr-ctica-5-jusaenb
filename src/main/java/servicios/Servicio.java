package servicios;

import interfaces.InterfazContactoSim;
import modelo.DatosSimulation;
import modelo.DatosSolicitud;
import modelo.Entidad;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class Servicio implements InterfazContactoSim {

    private final RestTemplate restTemplate = new RestTemplate();
    // Usamos el nombre del servicio definido en el Docker Compose
    private final String URL_BASE = "http://servicio-consumible:9000";

    @Override
    public int solicitarSimulation(DatosSolicitud sol) {
        // Llamada al endpoint del servicio externo para obtener el token
        DatosSolicitud respuesta = restTemplate.postForObject(URL_BASE + "/Solicitud", sol, DatosSolicitud.class);
        return (int) respuesta.getTokenSolicitud();
    }

    @Override
    public DatosSimulation descargarDatos(int ticket) {
        String url = URL_BASE + "/Resultados?nombreUsuario=jusaenb&tok=" + ticket;
        DatosSolicitud respuesta = restTemplate.getForObject(url, DatosSolicitud.class);

        if (respuesta != null && respuesta.getData() != null) {
            return DatosSimulation.desdeString(respuesta.getData());
        }
        return null;
    }

    @Override
    public List<Entidad> getEntities() {
        return new ArrayList<>();
    }

    @Override
    public boolean isValidEntityId(int id) {
        return true;
    }
}