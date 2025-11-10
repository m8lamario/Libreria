public class Libro {
    protected String titolo;

    public Libro(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }

    public boolean isVuoto() {
        return false; // sarà ridefinito in LibroVuoto
    }

    @Override
    public String toString() {
        return titolo;
    }
}
