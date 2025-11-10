package it.biblioteca.scaffalatura;

import it.biblioteca.libri.Libro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Rappresenta una mensola con posizioni fisse per i libri.
 * Le posizioni sono modellate come Optional<Libro>, inizialmente tutte vuote.
 */
public class Mensola {

    private final int capienzaMassima;
    private final ArrayList<Optional<Libro>> posizioni;

    /**
     * Crea una mensola con capienza fissa. Tutte le posizioni vengono
     * inizializzate a Optional.empty() per simulare slot fissi.
     *
     * @param capienzaMassima numero di posizioni (deve essere >= 1)
     */
    public Mensola(int capienzaMassima) {
        if (capienzaMassima < 1) {
            throw new IllegalArgumentException("La capienza massima deve essere >= 1.");
        }
        this.capienzaMassima = capienzaMassima;
        this.posizioni = new ArrayList<>(capienzaMassima);
        for (int i = 0; i < capienzaMassima; i++) {
            this.posizioni.add(Optional.empty());
        }
    }

    public int getCapienzaMassima() {
        return capienzaMassima;
    }

    /**
     * Restituisce una vista non modificabile delle posizioni.
     * Ogni elemento è un Optional<Libro>: Optional.empty() indica slot vuoto.
     */
    public List<Optional<Libro>> getPosizioni() {
        return Collections.unmodifiableList(posizioni);
    }

    /* Metodi operativi (opzionali per fasi successive)
    public boolean posizionaLibro(int indice, Libro libro) {
        if (indice < 0 || indice >= capienzaMassima) return false;
        if (libro == null) throw new IllegalArgumentException("Libro nullo.");
        if (posizioni.get(indice).isPresent()) return false; // già occupato
        posizioni.set(indice, Optional.of(libro));
        return true;
    }

    public Optional<Libro> rimuoviLibro(int indice) {
        if (indice < 0 || indice >= capienzaMassima) return Optional.empty();
        Optional<Libro> precedente = posizioni.get(indice);
        posizioni.set(indice, Optional.empty());
        return precedente;
    }
    */
}
