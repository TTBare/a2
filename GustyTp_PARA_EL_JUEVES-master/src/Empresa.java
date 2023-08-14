import java.util.List;
import java.util.Scanner;
public class Empresa {
    public Evento evento;
    public Scanner scanner;
    public CompraEntradas compraEntradas;
    public ConsoleUtils clear;
    public int numerodelaultimaentrada;
    public Empresa(Evento evento) {
        this.evento = evento;
        this.scanner = new Scanner(System.in);
        this.compraEntradas = new CompraEntradas(evento);
    }
    /**
     * 
     */
    public void mostrarMenuEmpresa() {   
        String opcionMenuEmpresa;
        do {
            System.out.println("=== Menú Empresa ===");
            System.out.println("1. Ver entradas ocupadas");
            System.out.println("2. Agregar entradas");
            System.out.println("0. Volver");
            System.out.print("Ingrese una opción: ");
            opcionMenuEmpresa = scanner.nextLine();
            scanner.nextLine();
            
    switch (opcionMenuEmpresa) {
        case "1":
            List<Entrada> ocupadas = evento.getEntradasOcupadas();
            System.out.println("Entradas ocupadas:");
            int cantidad_de_entradas_ocupadas = ocupadas.size();
                //boolean claveCorrecta = SeguridadAdmin.requestPassword();         
                //if (claveCorrecta) {
                //System.out.println("Clave correcta. Acceso concedido.");
                // Resto del código para el acceso autorizado
            if(cantidad_de_entradas_ocupadas == 0){
                System.out.println("No se vendio ninguna entrada");
                System.out.println("Para continuar apretar la tecla enter...");
                scanner.nextLine(); 
                }
            else{
                System.out.println("Se vendieron un total de : " + cantidad_de_entradas_ocupadas + " entradas");
                for (Entrada entrada : ocupadas) 
                    {System.out.println(entrada.getNumero() + " - " + entrada.getUbicacion()+" - $"+ entrada.getPrecio());}
                System.out.println("Para continuar apretar la tecla enter...");
                    scanner.nextLine(); 
                }
        
            //}
            // else {
            //     System.out.println("Clave incorrecta. Acceso denegado.");
            //     System.out.println("Para continuar apretar la tecla enter...");
            //     scanner.nextLine(); 
            //     }
           break;
    case "2":        
           List<Entrada> disponibles = evento.getEntradasDisponibles();
           int cantidad_de_entradas_disponibles = disponibles.size();
        if (cantidad_de_entradas_disponibles==0)
           {numerodelaultimaentrada = 0;}
        else{
           Entrada ultimoElemento = disponibles.get((cantidad_de_entradas_disponibles-1));
           numerodelaultimaentrada= ultimoElemento.getNumero();}
        System.out.println("Ingrese el valor de las entradas:");
        String precioEntrada= scanner.nextLine();
        System.out.println("Ingrese la platea donde se van a ubicar");
        String platea =scanner.nextLine();
        System.out.println("Ingrese el numero de entradas que desea ingresar (tenga en cuenta que el valor que les asigne sera asi para toda esa cantidad)");
        int nuevas = scanner.nextInt();
        for(int i=1;i==nuevas;i++){
            int nuevonumero=(numerodelaultimaentrada+i);
            evento.agregarEntrada(new Entrada(nuevonumero, platea+"- Asiento "+nuevonumero, precioEntrada));
            }
           scanner.nextLine();
           break;
    case "0":
           ConsoleUtils.clearConsole();
           System.out.println("Volviendo...");
           scanner.nextLine(); 
    default:
            ConsoleUtils.clearConsole();
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            scanner.nextLine();
            break;
        }
    } while (!opcionMenuEmpresa.equals("0"));
    
    scanner.close();
}}