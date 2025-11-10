# Diagramma di Classe UML — La Biblioteca Dinamica

```mermaid
classDiagram
    class Libro {
      - String titolo
      - String autore
      - int numeroPagine
      + Libro(String titolo, String autore, int numeroPagine)
      + getTitolo() String
      + getAutore() String
      + getNumeroPagine() int
      + toString() String
    }

    class Romanzo {
      - String genere
      + Romanzo(String titolo, String autore, int numeroPagine, String genere)
      + getGenere() String
    }

    class ManualeScolastico {
      - String materia
      - int anno
      + ManualeScolastico(String titolo, String autore, int numeroPagine, String materia, int anno)
      + getMateria() String
      + getAnno() int
    }

    class Mensola {
      - int capienzaMassima
      - ArrayList~Optional~<Libro>~~ posizioni
      + Mensola(int capienzaMassima)
      + getCapienzaMassima() int
      + getPosizioni() List~Optional~<Libro>~~
    }

    class Scaffale {
      - ArrayList<Mensola> mensole
      + Scaffale()
      + aggiungiMensola(Mensola m) void
      + getMensole() List<Mensola>
    }

    Libro <|-- Romanzo
    Libro <|-- ManualeScolastico

    Scaffale *-- Mensola : composizione
    Mensola o-- Libro : contiene 0..capienza
```

Note:
- La composizione Scaffale–Mensola indica che le mensole sono parte integrante dello scaffale.
- `Mensola.posizioni` è modellata come `ArrayList<Optional<Libro>>` per rappresentare posizioni fisse che possono essere vuote (`Optional.empty()`).
