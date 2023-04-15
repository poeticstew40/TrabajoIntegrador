package utn.tp.integrador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorPronosticos {

    private ArrayList<Pronostico> pronosticos = new ArrayList<Pronostico>();
    private Pronostico pronostico;

    /**
     * Metodo que lee el archivo de pronosticos y los carga en un ArrayList de
     * Pronosticos
     *
     * @return pronosticos
     */
    public ArrayList<Pronostico> getPronosticos(String path) {

        try {
            FileReader filePronostico = new FileReader(path);
            BufferedReader brPronostico = new BufferedReader(filePronostico);
            String unPronostico = brPronostico.readLine();
            while (unPronostico != null) {

                pronostico = getDatosPronostico(unPronostico);
                if (pronostico != null) {
                    pronosticos.add(pronostico);
                }
                unPronostico = brPronostico.readLine();
            }
            brPronostico.close();
        } catch (IOException e) {
            System.out.println("Error al leer un archivo: " + path);
        }
        return pronosticos;

    }

    /**
     * Metodo privado de la clase Se pasa por parametro un String que representa
     * todos los datos de un pronostico, lo convierte y devuelve un Pronostico En
     * caso de inconsistencia con los datos devuelve un null
     *
     * @param unPronostico
     * @return Pronostico
     *
     */
    private Pronostico getDatosPronostico(String unPronostico) {
        String[] datosUnPronostico = unPronostico.split(",");
        try {
            int id = Integer.parseInt(datosUnPronostico[0]);
            String nombre = datosUnPronostico[1];
            EnumResultado resultado = EnumResultado.valueOf(datosUnPronostico[2].toUpperCase());

            pronostico = new Pronostico(id, nombre, resultado);

        } catch (Exception e) {
            System.out.println("Entrada de datos no valida, error en la linea: " + unPronostico);
            pronostico = null;
        }
        return pronostico;
    }

}
