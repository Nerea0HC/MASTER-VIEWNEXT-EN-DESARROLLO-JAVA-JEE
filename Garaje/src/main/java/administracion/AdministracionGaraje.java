package administracion;

import automovil.Camion;
import automovil.Coche;

public class AdministracionGaraje {

	public static void main(String[] args) {
		// Creamos Coche
        Coche coche = new Coche(123456, 5, 60.0, 200.0, "Luis DFGDFG");
        System.out.println(coche.toString());
        
        // Avanzamos el coche
        coche.avanzar(10.0);
        coche.avanzar(50.0);
        coche.setVelocidad(80.0);
        coche.avanzar(40.0);
        coche.avanzar(30.0);
		System.out.println("****************************************************************************");
		
		 // Creamo Camion
        Camion camion = new Camion(732947, 3, 50.0, 100.0, "Juan Awsrasr");
        System.out.println(camion.toString());
        
        // Avanzamos el camión
        camion.avanzar(5.0);
        camion.setVelocidad(30.0);
        camion.avanzar(20.0);
        camion.avanzar(5.0);
        camion.avanzar(5.0);
        camion.setVelocidad(10.0);
        camion.avanzar(5.0);

        // Mostramos el tacómetro
        System.out.println("Tacómetro:");
        for (Double velocidad : camion.getTacometro()) {
            System.out.println("Velocidad: " + velocidad);
        }
	}
}
