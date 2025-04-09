public class Candidatos {
    protected String nombre, numeral;

    public Candidatos() {
    }

    public Candidatos(String numeral, String nombre) {
        this.numeral = numeral;
        this.nombre = nombre;
    }

    public String getNumeral() {
        return numeral;
    }

    public void setNumeral(String numeral) {
        this.numeral = numeral;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", numeral = " + numeral;
    }
}
