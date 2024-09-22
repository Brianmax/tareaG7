import java.util.ArrayList;

public class Library {
    private ArrayList<LibraryItem> libraryItems;
    private ArrayList<LibraryUser> libraryUsers;

    public Library(ArrayList<LibraryItem> libraryItems, ArrayList<LibraryUser> libraryUser) {
        this.libraryItems = libraryItems;
        this.libraryUsers = libraryUser;
    }

    public void addItem(LibraryItem libraryItem) {
        // no se aceptan repeticiones
        // verificar si existe algun elemento repetido
        boolean isFound = verifyId(libraryItem.itemId);

        if (isFound) {
            System.out.println("El item ya existe");
            return;
        }
        libraryItems.add(libraryItem);
        System.out.println("Item agregado correctamente");
    }

    public void loanItem(int idUsuario, int idItem) {
        LibraryUser libraryUser = findUsuarioById(idUsuario);
        LibraryItem libraryItem = findItemById(idItem);
        if(libraryItem == null || libraryUser == null) {
            System.out.println("No existe usuario o item");
        } else {
            ArrayList<LibraryItem> loanedItems = libraryUser.getLoanedItems();
            loanedItems.add(libraryItem);
            libraryItem.setLoaned(true);
            System.out.println("Item prestado correctamente");
        }
    }
    public void addUsuario(LibraryUser libraryUser) {
        // implementar la logica para agregar un usuario
        // verificar si el usuario ya existe
        // si el usuario ya existe, mostrar un mensaje de error
        // si el usuario no existe, agregarlo al array de usuarios
        // cree un metodo privado para verificar si el usuario ya existe
        // boolean verifyUser(int idUser)
    }
    public void showAvailableItems() {
        // implementar la logica para mostrar los items disponibles
        // recorrer el array de items y mostrar solo los items que no estan prestados
        // si no hay items disponibles, mostrar un mensaje de error
    }

    public void showLoanedItems() {
        // implementar la logica para mostrar los items prestados
        // recorrer el array de items y mostrar solo los items que estan prestados
        // si no hay items prestados, mostrar un mensaje de error
    }

    public void returnItem(int idUsuario, int idItem) {
        // implementar la logica para retornar un item
        // verificar si el usuario existe
        // verificar si el item existe
        // verificar si el item esta prestado
        // si el item esta prestado, retornarlo
        // si el item no esta prestado, mostrar un mensaje de error
        // eliminar el item de la lista de items prestados del usuario
    }

    private boolean verifyId(int idNewItem) {
        for(LibraryItem item: libraryItems) {
            if (idNewItem == item.itemId) {
                return true;
            }
        }
        return false;
    }
    private LibraryUser findUsuarioById(int idUsuario) {

        for (LibraryUser libraryUser: libraryUsers) {
            if (idUsuario == libraryUser.getUserId()) {
                return libraryUser;
            }
        }
        return null;
    }
    // modificar el metodo para que tenga en cuenta
    // si el libro se encuentra disponible
    private LibraryItem findItemById(int idItem) {
        for (LibraryItem libraryItem: libraryItems) {
            if (idItem == libraryItem.itemId) {
                return libraryItem;
            }
        }
        return null;
    }

    // returnItem
    // desarrollar el metodo para poder retornar un item
    // (int idUsuario, int idItem)
}
