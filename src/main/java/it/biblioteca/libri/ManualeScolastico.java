package it.biblioteca.libri;

/**
 * Sottoclasse di Libro che rappresenta un manuale scolastico.
 */
public class ManualeScolastico extends Libro {

    private final String materia;
    private final int anno;

    public ManualeScolastico(String titolo, String autore, int numeroPagine, String materia, int anno) {
        super(titolo, autore, numeroPagine);
        if (materia == null || materia.isBlank()) {
            throw new IllegalArgumentException("La materia non può essere nulla o vuota.");
        }
        if (anno < 1) {
            throw new IllegalArgumentException("L'anno deve essere >= 1.");
        }
        this.materia = materia;
        this.anno = anno;
    }

    public String getMateria() {
        return materia;
    }

    public int getAnno() {
        return anno;
    }
}
