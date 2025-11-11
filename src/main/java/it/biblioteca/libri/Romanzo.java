package main.java.it.biblioteca.libri;

public class Romanzo extends Libro {
    private final String genere;

    public Romanzo(String titolo, String autore, int numeroPagine, String genere) {
        super(titolo, autore, numeroPagine);
        if (genere == null || genere.isBlank()) {
            throw new IllegalArgumentException("Il genere non può essere nullo o vuoto.");
        }
        this.genere = genere;
    }

    public String getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        // Include anche il genere come richiesto dalla Parte 3
        return super.toString() + ", Genere: " + genere;
    }
}