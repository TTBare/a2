import java.util.Scanner;

public class SeguridadAdmin {
    
static Scanner scanner = new Scanner(System.in);

    public static boolean requestPassword() {
        System.out.print("Ingrese la contraseña: ");
        String input = scanner.nextLine();
        
        // Verificar si la contraseña es correcta
        if (input.equals("Bandeja123")) {
            return true; // Contraseña correcta
        } 
        else {
            return false; // Contraseña incorrecta
        }
    }
}