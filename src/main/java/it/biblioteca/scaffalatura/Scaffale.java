package main.java.it.biblioteca.scaffalatura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scaffale {

    private final ArrayList<Mensola> mensole;

    public Scaffale() {
        this.mensole = new ArrayList<>();
    }

    public void aggiungiMensola(Mensola m) {
        if (m == null) {
            throw new IllegalArgumentException("La mensola non può essere nulla.");
        }
        mensole.add(m);
    }

    public List<Mensola> getMensole() {
        return Collections.unmodifiableList(mensole);
    }
}
