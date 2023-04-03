package utn.tp.integrador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // leer resultados
        Path pathResultados = Paths.get("src/main/java/archivosCSV/resultados.csv");
        List<String> lineasResultados = null;
        try {
            lineasResultados = Files.readAllLines(pathResultados);
        } catch (IOException e) {
            System.out.println("No se puede leer la linea de resultados");
            System.exit(1);
        }
        boolean primera = true;
        for (String lineaResultados: lineasResultados) {
            if (primera){
                primera = false;
            }else {
                System.out.println(lineaResultados);
            }

        }

        // leer pronosticos

        // calcular y mostrar puntos



    }
}