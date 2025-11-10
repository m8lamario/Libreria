package it.biblioteca.scaffalatura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Rappresenta uno scaffale composto da più mensole.
 */
public class Scaffale {

    private final ArrayList<Mensola> mensole;

    /**
     * Costruttore di default: inizializza la lista delle mensole.
     */
    public Scaffale() {
        this.mensole = new ArrayList<>();
    }

    /**
     * Aggiunge una mensola già creata allo scaffale.
     *
     * @param m mensola da aggiungere
     */
    public void aggiungiMensola(Mensola m) {
        if (m == null) {
            throw new IllegalArgumentException("La mensola non può essere nulla.");
        }
        mensole.add(m);
    }

    /**
     * Restituisce la lista delle mensole come vista non modificabile.
     */
    public List<Mensola> getMensole() {
        return Collections.unmodifiableList(mensole);
    }
}
