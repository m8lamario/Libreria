public class LibroVuoto extends Libro {

    public LibroVuoto() {
        super("(vuoto)");
    }

    @Override
    public boolean isVuoto() {
        return true;
    }
}
