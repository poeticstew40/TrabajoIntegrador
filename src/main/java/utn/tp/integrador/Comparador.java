package utn.tp.integrador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Comparador {

    private Map<Integer, Partido> partidos = new HashMap<Integer, Partido>();
    private ArrayList<Pronostico> pronosticos = new ArrayList<Pronostico>();
    private Map<String, Integer> puntuacion = new HashMap<String, Integer>();

    /**
     * Metodo que recorre el arraylist de pronosticos.
     * Obtiene un partido de HasHMap de partidos usando el nro de partido como key
     * Compara el pronostico con el resultado del partido
     * Cuenta los aciertos y muestra por consola la catidad de puntos de los participantes
     *
     */
    public void compararPronosticos() {

        LectorPartidos gsPartidos = new LectorPartidos();
        LectorPronosticos gsPronosticos = new LectorPronosticos();
        String pathPartidos = "C:/Users/nicol/OneDrive/Escritorio/UTN Curso Java Inicial/TrabajoIntegrador/src/main/java/archivosCSV/resultados.csv";
        String pathPronosticos = "C:/Users/nicol/OneDrive/Escritorio/UTN Curso Java Inicial/TrabajoIntegrador/src/main/java/archivosCSV/pronostico.csv";

        Partido partido;
        int puntos = 0;

        partidos = gsPartidos.cargarPartidosDesdeArchivo(pathPartidos);
        pronosticos = gsPronosticos.getPronosticos(pathPronosticos);

        try {

            // Recorre el arraylist de pronostico comparando
            for (Pronostico pronostico : pronosticos) {

                //Obtiene un Partido del HashMap paridos
                // key = nro de partido
                partido = partidos.get(pronostico.getId());

                if (partido.getId() == pronostico.getId()
                        && partido.getEnumResultado().equals(pronostico.getResultado())) {

                    // Si ha coincidencia entre el pronostico y el resultado del partido
                    // Si el nombre ya existe como key en el HashMap lee value (puntos)
                    // le suma uno y actualiza el HashMap

                    if (puntuacion.containsKey(pronostico.getNombre())) {

                        puntos = puntuacion.get(pronostico.getNombre());
                        puntos++;
                        puntuacion.put(pronostico.getNombre(), puntos);

                        // Si es la primera vez que aparece el nombre, lo agrega como
                        // key y al value (puntos) lo inicializa con 1 punto
                    } else {
                        puntuacion.put(pronostico.getNombre(), 1);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Recorre el HashMap y lo muestra. no esta ordenado

        for (String key : puntuacion.keySet()) {
            System.out.println("Participante: " + key + " Puntos = " + puntuacion.get(key));
        }
    }

}
