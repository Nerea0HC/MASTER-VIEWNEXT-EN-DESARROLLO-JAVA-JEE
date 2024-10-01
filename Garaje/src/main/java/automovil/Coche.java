package automovil;

import vehiculo.Vehiculo;

public class Coche extends Vehiculo {

	public Coche(int matricula, int plazas, Double velocidad, Double trayecto, String responsable) {
		super(matricula, plazas, velocidad, trayecto, responsable);
	}

	@Override
    public void avanzar(Double km) {
        super.avanzar(km);
    }
}
