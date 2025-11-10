import java.util.ArrayList;
import java.util.List;

public class Mensola {
    private List<Libro> libri;
    private int capienza;

    public Mensola(int capienza) {
        this.capienza = capienza;
        libri = new ArrayList<>();
        // inizializzo ogni posizione con un "libro vuoto"
        for (int i = 0; i < capienza; i++) {
            libri.add(new LibroVuoto());
        }
    }

    public boolean addLibro(Libro libro, int posizione) {
        if (posizione < 0 || posizione >= capienza) {
            System.out.println("Posizione non valida!");
            return false;
        }
        if (!libri.get(posizione).isVuoto()) {
            System.out.println("Posizione già occupata da: " + libri.get(posizione).getTitolo());
            return false;
        }
        libri.set(posizione, libro);
        System.out.println("Libro aggiunto!");
        return true;
    }

    public boolean removeLibro(int posizione) {
        if (posizione < 0 || posizione >= capienza) {
            System.out.println("Posizione non valida!");
            return false;
        }
        if (libri.get(posizione).isVuoto()) {
            System.out.println("La posizione è già vuota.");
            return false;
        }
        libri.set(posizione, new LibroVuoto());
        System.out.println("Libro rimosso!");
        return true;
    }

    public Libro getLibro(int posizione) {
        if (posizione < 0 || posizione >= capienza) {
            System.out.println("Posizione non valida!");
            return null;
        }
        return libri.get(posizione);
    }

    public int getCapienza() {
        return capienza;
    }

    public void mostraMensola() {
        for (Libro libro : libri) {
            System.out.print(libro + " | ");
        }
        System.out.println();
    }
}
