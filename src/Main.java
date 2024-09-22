import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Library library = new Library(new ArrayList<>(0), new ArrayList<>(0));
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("1. Agregar libro");
            System.out.println("2. Agregar usuario");
            System.out.println("3. Agregar DVD");
            System.out.println("4. Prestar item");
            System.out.println("5. Mostrar items disponibles");
            System.out.println("6. Mostrar items prestados");
            System.out.println("7. Retornar item");
            int option = scanner.nextInt();
            System.out.println("________________________________");
            System.out.println("Opcion seleccionada: " + option);
            if (option == 1) {

                System.out.println("Ingrese el ID del libro");
                int id = scanner.nextInt();
                System.out.println("Ingrese el titulo del libro");
                String title = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Ingrese el autor del libro");
                String author = scanner.nextLine();
                Book book = new Book(title, id, false, author);
                library.addItem(book);
                System.out.println("Presione enter para continuar");
            } else if (option == 2) { // implementar metodo
                System.out.println("Ingrese el ID del usuario");
                int id = scanner.nextInt();
                System.out.println("Ingrese el username del usuario");
                String username = scanner.nextLine();
                scanner.nextLine();
                LibraryUser libraryUser = new LibraryUser(username, id, new ArrayList<>(0));
                library.addUsuario(libraryUser);
                System.out.println("Presione enter para continuar");
            } else if (option == 3) {
                System.out.println("Ingrese el ID del DVD");
                int id = scanner.nextInt();
                System.out.println("Ingrese el titulo del DVD");
                String title = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Ingrese el director del DVD");
                String director = scanner.nextLine();
                System.out.println("Ingrese la duracion del DVD");
                int duration = scanner.nextInt();
                scanner.nextLine();
                Dvd dvd = new Dvd(title, id, false, director, duration);
                library.addItem(dvd);
                System.out.println("Presione enter para continuar");
            } else if (option == 4) {
                System.out.println("Ingrese el ID del usuario");
                int userId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Ingrese el ID del item");
                int itemId = scanner.nextInt();
                scanner.nextLine();
                library.loanItem(userId, itemId);
                System.out.println("Presione enter para continuar");
            } else if (option == 5) {
                library.showAvailableItems();
            } else if (option == 6) {
                library.showLoanedItems();
            } else if (option == 7) {
                System.out.println("Ingrese el ID del item");
                int itemId = scanner.nextInt();
                System.out.println("Ingrese el ID del usuario");
                int userId = scanner.nextInt();
                scanner.nextLine();
                library.returnItem(itemId, userId);
                System.out.println("Presione enter para continuar");
            }
            // clean the buffer
            scanner.nextLine();
            // clean console
            System.out.println("\033[H\033[2J");
        }
    }
}