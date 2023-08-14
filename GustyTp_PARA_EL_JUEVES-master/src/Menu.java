import java.util.List;
import java.util.Scanner;

public class Menu {
    public Evento evento;
    public Scanner scanner;
    public CompraEntradas compraEntradas;
    public ConsoleUtils clear;
    public String opcion;
    public Menu(Evento evento) {
        this.evento = evento;
        this.scanner = new Scanner(System.in);
        this.compraEntradas = new CompraEntradas(evento);
    }
    /**
     * 
     */
    public void mostrarMenu() {
        
        do {
            ConsoleUtils.clearConsole();
            System.out.println("=== MENÚ ===");
            System.out.println("1. Mostrar entradas disponibles");
            System.out.println("2. Entrar en el menu empresa");
            System.out.println("3. Comprar entrada");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();
            //scanner.nextLine(); // Limpiar el salto de línea
            
            switch (opcion) {
                case "1":
                    ConsoleUtils.clearConsole();
                    List<Entrada> disponibles = evento.getEntradasDisponibles();
                    System.out.println("Entradas disponibles:");
                    if(disponibles.size()!=0){
                    for (Entrada entrada : disponibles) {
                        System.out.println(entrada.getNumero() + " - " + entrada.getUbicacion()+" - $"+ entrada.getPrecio());
                    }
                    System.out.println("Para continuar apretar la tecla enter...");
                    scanner.nextLine(); }
                    else{
                        System.out.println("Las entradas estan agotadas");
                        System.out.println("Para continuar apretar la tecla enter...");
                        scanner.nextLine(); 
                    }
                    break;
                case "2":
                    ConsoleUtils.clearConsole();
                    boolean claveCorrecta = SeguridadAdmin.requestPassword();
                    Empresa menuEmpresa = new Empresa(evento);
                    ConsoleUtils.clearConsole();
                        if (claveCorrecta) {
                            System.out.println("Clave correcta. Acceso concedido.");
                            menuEmpresa.mostrarMenuEmpresa();
                            System.out.println("Para continuar apretar la tecla enter...");
                            scanner.nextLine(); 
                            break;

                        }
                    
                        else {
                            System.out.println("Clave incorrecta. Acceso denegado.");
                            System.out.println("Para continuar apretar la tecla enter...");
                            scanner.nextLine(); 
                            }
                       break;
                case "3":
                    ConsoleUtils.clearConsole();
                    compraEntradas.realizarCompra();
                    break;
                case "4":
                    ConsoleUtils.clearConsole();
                    System.out.println("¡Hasta luego!");
                    break;
                case"0":
                break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.MENU");
                    scanner.nextLine();
                    break;
            }

            System.out.println();
        } while (!opcion.equals("4"));
    }

}
