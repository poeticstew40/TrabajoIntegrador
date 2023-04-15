package utn.tp.integrador;

public class Pronostico {

    private int id;
    private String nombre;
    private EnumResultado resultado;

    public Pronostico(int id, String nombre, EnumResultado resultado) {
        this.id = id;
        this.nombre = nombre;
        this.resultado = resultado;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public EnumResultado getResultado() {
        return resultado;
    }
}
