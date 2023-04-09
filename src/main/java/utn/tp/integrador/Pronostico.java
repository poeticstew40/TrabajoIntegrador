package utn.tp.integrador;

public class Pronostico {

    private Partido partido;
    private Equipo equipo;
    private String resultado;

    public Pronostico(Partido partido, Equipo equipo, String resultado) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }

    public Partido getPartido() {
        return partido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public String getResultado() {
        return resultado;
    }

    public int puntos(){
        //TODO terminar la implementacion
        String resultadoReal = partido.resultado(equipo);
        if (resultado.equals(resultadoReal)){
            return 1;
        }else
            return 0;
    }
}
