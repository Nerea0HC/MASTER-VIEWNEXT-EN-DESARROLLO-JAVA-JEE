package vehiculo;

import interfaz.Conducible;

public abstract class Vehiculo implements Conducible {

    private final int matricula;
    private static int plazas;
    private Double velocidad;
    private Double trayecto;
    private String responsable;

    public Vehiculo(int matricula, int plazas, Double velocidad, Double trayecto, String responsable) {
        super();
        this.matricula = matricula;
        // Encapsulamos el numero de plazas del vehiculo
        Vehiculo.setPlazas(plazas);
        this.velocidad = velocidad;
        this.trayecto = trayecto;
        this.responsable = responsable;
    }

    // Getters and setters
    public static int getPlazas() {
        return plazas;
    }

    public static void setPlazas(int plazas) {
        Vehiculo.plazas = plazas;
    }

    public Double getVelocidad() {
        return velocidad;
    }
    
    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public Double getTrayecto() {
        return trayecto;
    }

    public void setTrayecto(Double trayecto) {
        this.trayecto = trayecto;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Vehiculo [matricula=" + matricula + ", velocidad=" + velocidad + "Km/h, trayecto=" + trayecto
                + "Km, responsable=" + responsable + "]";
    }

    // Métodos de la interfaz
    public double recorridoRestante() {
        return trayecto;
    }

    public double tiempoLlegada() {
        // Solo calcular el tiempo restante si hay distancia por recorrer
        if (trayecto > 0 && velocidad > 0) {
            return trayecto / velocidad;
        } else {
            return 0;
        }
    }

    public void avanzar(Double km) {
        trayecto -= km;
        if (trayecto < 0) {
            trayecto = 0.0;
        }
        System.out.println("===========================================================");
        System.out.println("Recorrido restante: " + recorridoRestante() + "km");
        System.out.println("Tiempo restante: " + tiempoLlegada() + " horas");
        System.out.println("Velocidad actual: " + getVelocidad());
    }
}

