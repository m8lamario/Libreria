# ANALISI DELLA PROGETTAZIONE — La Biblioteca Dinamica

## Relazione Scaffale–Mensola
Lo Scaffale è composto da una collezione di Mensole. La relazione è di composizione: la vita delle mensole è legata allo scaffale. Per rappresentare l’insieme di mensole si utilizza `ArrayList<Mensola>`:
- Motivi: ordine stabile (l’ordine di aggiunta può contare), operazioni di accesso indicizzato efficienti, semplicità d’uso.
- Il metodo `aggiungiMensola(Mensola m)` consente di costruire lo scaffale incrementando il numero di mensole già istanziate esternamente (aderendo ai requisiti).

## Gestione delle posizioni della Mensola
Scelta: `ArrayList<Optional<Libro>> posizioni`, popolata nel costruttore con `capienzaMassima` elementi iniziali tutti `Optional.empty()`.

Motivazioni e vantaggi:
- Posizioni fisse: l’indice nella lista corrisponde a una posizione fisica sulla mensola. Pre-riempire con `Optional.empty()` evita ridimensionamenti e shift interni.
- Espressività: `Optional<Libro>` comunica esplicitamente l’assenza di un libro. È più chiaro e sicuro di usare `null`, riducendo il rischio di `NullPointerException`.
- Distinzione semantica: con un semplice `ArrayList<Libro>` sarebbe difficile distinguere una posizione “vuota” da una “non ancora creata” (lista più corta); qui invece tutte le posizioni esistono fin dall’inizio.
- Operazioni tipiche semplificate: cercare la “prima posizione libera” equivale a trovare il primo `Optional.empty()`; inserire/rimuovere non cambia la dimensione della lista.

Alternative considerate:
- `ArrayList<Libro>` con `null`: meno espressiva e più soggetta a errori.
- `Map<Integer, Libro>`: adatta a posizioni sparse, ma più verbosa e non necessaria per capienze tipicamente compatte e fisse.

## Gerarchia dei libri
`Romanzo` e `ManualeScolastico` sono sottoclassi di `Libro`:
- Polimorfismo: lo scaffale e la mensola gestiscono riferimenti a `Libro`, ma possono contenere istanze di sottotipi diversi e invocare comportamenti specifici se necessari.
- Estendibilità: nuove tipologie (es. `Saggio`, `Fumetto`) possono essere aggiunte senza modificare il codice delle collezioni.
- Dati specifici: ogni sottoclasse può aggiungere attributi propri (es. `genere` per `Romanzo`, `materia` e `anno` per `ManualeScolastico`) mantenendo un’interfaccia comune.

Queste scelte allineano il modello con i requisiti, migliorando chiarezza, sicurezza e manutenibilità del codice.
