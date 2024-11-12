package vuelos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vuelos.model.Vuelos;
import java.util.List;

public interface VuelosRepository extends JpaRepository<Vuelos, Integer> {
	// Método para obtener vuelos con al menos el número de plazas puesto
    List<Vuelos> findByPlazasDisponiblesGreaterThanEqual(int numeroDePlazas);
}
