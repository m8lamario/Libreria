package main.java.it.biblioteca.scaffalatura;

import main.java.it.biblioteca.libri.Libro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Mensola {

    private final int capienzaMassima;
    private final ArrayList<Optional<Libro>> posizioni;

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
    public List<Optional<Libro>> getPosizioni() {
        return Collections.unmodifiableList(posizioni);
    }

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

    public Optional<Libro> getLibro(int posizione) {
        if (posizione < 0 || posizione >= capienzaMassima) {
            return Optional.empty();
        }
        return posizioni.get(posizione);
    }

    public Optional<Libro> rimuoviLibro(int posizione) {
        if (posizione < 0 || posizione >= capienzaMassima) {
            return Optional.empty();
        }
        Optional<Libro> precedente = posizioni.get(posizione);
        posizioni.set(posizione, Optional.empty());
        return precedente;
    }
}