package servicios;

import interfaces.InterfazContactoSim;
import modelo.DatosSimulation;
import modelo.DatosSolicitud;
import modelo.Entidad;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class Servicio implements InterfazContactoSim {
    private final List<Entidad> entidades;
    private final Random random = new Random();

    public Servicio() {
        this.entidades = new ArrayList<>();
        // Entidad 1
        Entidad e1 = new Entidad();
        e1.setId(1);
        e1.setName(" Entidad 1");
        e1.setDescripcion("Simulación de una entidad");
        entidades.add(e1);
        // Entidad 2
        Entidad e2 = new Entidad();
        e2.setId(2);
        e2.setName(" Entidad 2");
        e2.setDescripcion("Simulación de una entidad");
        entidades.add(e2);
    }
    @Override
    public int solicitarSimulation(DatosSolicitud sol) {
        return random.nextInt(10000) + 1;
    }

    @Override
    public DatosSimulation descargarDatos(int ticket) {
        return null;
    }

    @Override
    public List<Entidad> getEntities() {
        return this.entidades;
    }

    @Override
    public boolean isValidEntityId(int id) {
        return true;
    }

}
