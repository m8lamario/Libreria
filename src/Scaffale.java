import java.util.ArrayList;
import java.util.List;

public class Scaffale {
    private List<Mensola> mensole;

    public Scaffale(int numeroMensole, int capienzaMensola) {
        mensole = new ArrayList<>();
        for (int i = 0; i < numeroMensole; i++) {
            mensole.add(new Mensola(capienzaMensola));
        }
    }

    public boolean addLibro(Libro libro, int numMensola, int posizione) {
        if (numMensola < 0 || numMensola >= mensole.size()) {
            System.out.println("Numero mensola non valido!");
            return false;
        }
        return mensole.get(numMensola).addLibro(libro, posizione);
    }

    public boolean removeLibro(int numMensola, int posizione) {
        if (numMensola < 0 || numMensola >= mensole.size()) {
            System.out.println("Numero mensola non valido!");
            return false;
        }
        return mensole.get(numMensola).removeLibro(posizione);
    }

    public boolean spostaLibro(int mensolaOrigine, int posOrigine, int mensolaDestinazione, int posDestinazione) {
        if (mensolaOrigine < 0 || mensolaOrigine >= mensole.size() ||
                mensolaDestinazione < 0 || mensolaDestinazione >= mensole.size()) {
            System.out.println("Numero mensola non valido!");
            return false;
        }

        Mensola origine = mensole.get(mensolaOrigine);
        Mensola destinazione = mensole.get(mensolaDestinazione);

        Libro libroDaSpostare = origine.getLibro(posOrigine);
        if (libroDaSpostare == null || libroDaSpostare.isVuoto()) {
            System.out.println("Nessun libro da spostare in quella posizione!");
            return false;
        }

        if (!destinazione.getLibro(posDestinazione).isVuoto()) {
            System.out.println("La posizione di destinazione è occupata!");
            return false;
        }

        destinazione.addLibro(libroDaSpostare, posDestinazione);
        origine.removeLibro(posOrigine);
        System.out.println("Libro spostato con successo!");
        return true;
    }

    public void mostraScaffale() {
        for (int i = 0; i < mensole.size(); i++) {
            System.out.print("Mensola " + (i + 1) + ": ");
            mensole.get(i).mostraMensola();
        }
    }
}
