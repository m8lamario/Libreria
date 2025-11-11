package main.java.it.biblioteca.scaffalatura;

import main.java.it.biblioteca.libri.Libro;

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

    /**
     * Inserisce un libro in una posizione specifica se l'indice è valido e la posizione è vuota.
     *
     * Requisiti:
     * - posizione deve essere compresa tra 0 (incluso) e capienzaMassima (escluso)
     * - la posizione deve contenere Optional.empty()
     *
     * @param libro     libro da inserire (non deve essere null)
     * @param posizione indice della posizione
     * @return true se l'inserimento è avvenuto, false se posizione non valida o già occupata
     */
    public boolean setLibro(Libro libro, int posizione) {
        if (posizione < 0 || posizione >= capienzaMassima) {
            return false; // indice non valido
        }
        if (libro == null) {
            throw new IllegalArgumentException("Il libro non può essere null.");
        }
        if (posizioni.get(posizione).isPresent()) {
            return false; // già occupata
        }
        posizioni.set(posizione, Optional.of(libro));
        return true;
    }

    /**
     * Restituisce l'Optional<Libro> alla posizione indicata se valida, altrimenti Optional.empty().
     * Non lancia eccezioni per indici non validi.
     *
     * @param posizione indice richiesto
     * @return Optional<Libro> presente oppure Optional.empty() se indice non valido o slot vuoto
     */
    public Optional<Libro> getLibro(int posizione) {
        if (posizione < 0 || posizione >= capienzaMassima) {
            return Optional.empty();
        }
        return posizioni.get(posizione);
    }

    /**
     * Rimuove il libro dalla posizione indicata (se valida), sostituendolo con Optional.empty().
     * Restituisce l'Optional precedentemente presente (vuoto se non c'era libro).
     * Se l'indice non è valido restituisce Optional.empty().
     *
     * @param posizione indice da cui rimuovere
     * @return Optional del libro rimosso, oppure Optional.empty() se indice non valido
     */
    public Optional<Libro> rimuoviLibro(int posizione) {
        if (posizione < 0 || posizione >= capienzaMassima) {
            return Optional.empty();
        }
        Optional<Libro> precedente = posizioni.get(posizione);
        posizioni.set(posizione, Optional.empty());
        return precedente;
    }
}