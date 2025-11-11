package main.java.it.biblioteca.libri;

public class Libro {

    private final String titolo;
    private final String autore;
    private final int numeroPagine;

    public Libro(String titolo, String autore, int numeroPagine) {
        if (titolo == null || titolo.isBlank()) {
            throw new IllegalArgumentException("Il titolo non può essere nullo o vuoto.");
        }
        if (autore == null || autore.isBlank()) {
            throw new IllegalArgumentException("L'autore non può essere nullo o vuoto.");
        }
        if (numeroPagine < 1) {
            throw new IllegalArgumentException("Il numero di pagine deve essere >= 1.");
        }
        this.titolo = titolo;
        this.autore = autore;
        this.numeroPagine = numeroPagine;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    @Override
    public String toString() {
        return "Titolo: " + titolo + ", Autore: " + autore + ", Pagine: " + numeroPagine;
    }
}
