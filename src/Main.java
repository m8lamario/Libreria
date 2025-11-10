import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scaffale scaffale = new Scaffale(3, 5); // 3 mensole, 5 posti ciascuna
        boolean continua = true;

        while (continua) {
            System.out.println("\n= MENU BIBLIOTECA =");
            System.out.println("1. Aggiungi un libro");
            System.out.println("2. Rimuovi un libro");
            System.out.println("3. Sposta un libro");
            System.out.println("4. Mostra scaffale");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            int scelta = input.nextInt();
            input.nextLine(); //nextLine() è un metodo della classe Scanner che legge un’intera riga di testo,
                              //cioè tutti i caratteri fino al tasto Invio (Enter).

            switch (scelta) {
                case 1:
                    System.out.print("Titolo del libro: ");
                    String titolo = input.nextLine();
                    System.out.print("Numero mensola (da 1 a 3): ");
                    int numMensolaAdd = input.nextInt() - 1;
                    System.out.print("Posizione (da 1 a 5): ");
                    int posAdd = input.nextInt() - 1;

                    Libro nuovo = new Libro(titolo);
                    scaffale.addLibro(nuovo, numMensolaAdd, posAdd);
                    break;

                case 2:
                    System.out.print("Numero mensola (da 1 a 3): ");
                    int numMensolaRem = input.nextInt() - 1;
                    System.out.print("Posizione (da 1 a 5): ");
                    int posRem = input.nextInt() - 1;
                    scaffale.removeLibro(numMensolaRem, posRem);
                    break;

                case 3:
                    System.out.print("Mensola origine (da 1 a 3): ");
                    int mensolaOrigine = input.nextInt() - 1;
                    System.out.print("Posizione origine (da 1 a 5): ");
                    int posOrigine = input.nextInt() - 1;
                    System.out.print("Mensola destinazione (da 1 a 3): ");
                    int mensolaDest = input.nextInt() - 1;
                    System.out.print("Posizione destinazione (da 1 a 5): ");
                    int posDest = input.nextInt() - 1;
                    scaffale.spostaLibro(mensolaOrigine, posOrigine, mensolaDest, posDest);
                    break;

                case 4:
                    scaffale.mostraScaffale();
                    break;

                case 0:
                    continua = false;
                    System.out.println("Chiusura programma...");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }
        }

        input.close();
    }
}
