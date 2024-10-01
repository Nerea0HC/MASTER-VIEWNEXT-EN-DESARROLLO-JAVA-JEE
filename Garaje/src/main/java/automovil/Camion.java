package automovil;

import java.util.ArrayList;
import java.util.List;

import vehiculo.Vehiculo;
public class Camion extends Vehiculo {

    private final List<Double> tacometro;

    public Camion(int matricula, int plazas, Double velocidad, Double trayecto, String responsable) {
        super(matricula, plazas, velocidad, trayecto, responsable);
        this.tacometro = new ArrayList<Double>();
    }

    @Override
    public void avanzar(Double km) {
        super.avanzar(km);
        tacometro.add(getVelocidad());
    }

    public List<Double> getTacometro() {
        return tacometro;
    }
}
