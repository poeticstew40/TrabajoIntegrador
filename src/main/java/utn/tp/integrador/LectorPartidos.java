package utn.tp.integrador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * le y almacena desde un archivo csv
 */

public class LectorPartidos {

    private Map<Integer, Partido> partidos = new HashMap<Integer, Partido>();
    private Partido partido;

    /**
     * Metodo que lee el archivo de pronosticos y los carga en un HashMap<Integer,
     * Partido>
     *
     * @return partido
     */
    public Map<Integer, Partido> cargarPartidosDesdeArchivo(String path) {
        try {
            FileReader filePartidos = new FileReader(path);
            BufferedReader brPartidos = new BufferedReader(filePartidos);
            String unPartido = brPartidos.readLine();
            while (unPartido != null) {

                partido = getDatosPartido(unPartido);
                if (partido != null) {
                    partidos.put(partido.getId(), partido);
                }
                unPartido = brPartidos.readLine();
            }
            brPartidos.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + path);
        }

        return partidos;
    }

    /**
     * Metodo privado de la clase Se pasa por parametro un String que representa
     * todos los datos de un partido, lo convierte y devuelve un Partido En caso de
     * inconsistencia con los datos devuelve un null
     *
     * @param unPartido
     * @return Partido
     *
     */
    private Partido getDatosPartido(String unPartido) {
        String[] datosUnPartido = unPartido.split(",");
        Equipo equipo1;
        Equipo equipo2;
        try {
            int id = Integer.parseInt(datosUnPartido[0]);
            String eq1 = datosUnPartido[1];
            String eq2 = datosUnPartido[2];
            int goles1 = Integer.parseInt(datosUnPartido[3]);
            int goles2 = Integer.parseInt(datosUnPartido[4]);
            equipo1 = new Equipo(eq1);
            equipo2 = new Equipo(eq2);

            partido = new Partido(id, equipo1, equipo2, goles1, goles2);

        } catch (Exception e) {
            System.out.println("Entrada de datos no valida, error en la linea: " + unPartido);
            partido = null;
        }
        return partido;
    }
}
