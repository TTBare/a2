import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CompraEntradas {
    public Evento evento;
    public Scanner scanner;
    public ConsoleUtils clear;

    public CompraEntradas(Evento evento) {
        this.evento = evento;
        this.scanner = new Scanner(System.in);
    }

    public void realizarCompra() {
        String nombre = obtenerNombre(); // Obtiene el nombre del comprador
        String correoElectronico = obtenerCorreoElectronico(); // Obtiene el correo electrónico del comprador
        long numeroTelefono = obtenerNumeroTelefono(); // Obtiene el número de teléfono del comprador

        List<Entrada> entradasDisponibles = evento.getEntradasDisponibles(); // Obtiene la lista de entradas disponibles del evento
        if (entradasDisponibles.size()==0) {
            System.out.println("Lo sentimos, no hay entradas disponibles.");
            System.out.println("Para continuar apretar la tecla enter...");
            scanner.nextLine();
        } else {
            System.out.println("Entradas disponibles:");
            for (Entrada entrada : entradasDisponibles) {
                System.out.println(entrada.getNumero() + " - " + entrada.getUbicacion() + "- $" + entrada.getPrecio());
            }

            int numeroEntrada = obtenerNumeroEntrada(); // Obtiene el número de entrada seleccionado por el comprador

            Entrada entradaComprada = evento.comprarEntrada(numeroEntrada, nombre, correoElectronico, numeroTelefono); // Realiza la compra de la entrada
            if (entradaComprada != null) {
                ConsoleUtils.clearConsole();
                System.out.println("¡Compra realizada con éxito!");
                System.out.println("Datos de la entrada:");
                System.out.println("Número de entrada: " + entradaComprada.getNumero());
                System.out.println("Ubicación: " + entradaComprada.getUbicacion());
                System.out.println("Precio: " + entradaComprada.getPrecio());
                System.out.println("Nombre del comprador: " + entradaComprada.getNombreComprador());
                System.out.println("Datos del Evento: " +evento.tdp+" (Amistoso) " +evento.lugar+" Fecha: "+evento.fecha+" Horario: "+evento.hora+("hs."));
                System.out.println("Correo electrónico del comprador: " + entradaComprada.getCorreoComprador());
                System.out.println("Número de teléfono del comprador: " + entradaComprada.getTelefonoComprador());
                System.out.println("Para continuar apretar la tecla enter...");
                scanner.nextLine();
            } else {
                System.out.println("El número de entrada seleccionado no está disponible.");
                System.out.println("Para continuar apretar la tecla enter...");
                scanner.nextLine();
            }
        }
    }

    private String obtenerNombre() {
        String nombre = "";
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Ingrese su nombre: ");
            nombre = scanner.nextLine(); // Lee el nombre ingresado por el comprador
            if (nombre.matches(".*\\d.*")) {// verifica que el nombre del comprador no contenga numeros
                System.out.println("Error: El nombre no puede contener números.");
            } else {
                validInput = true;
            }
        }
        return nombre;
    }

    private String obtenerCorreoElectronico() {
        String correoElectronico = "";
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Ingrese su correo electrónico: ");
            correoElectronico = scanner.nextLine(); // Lee el correo electrónico ingresado por el comprador
            if (!correoElectronico.contains("@")) { //verifica que el correo al menos contenga el @
                System.out.println("Error: El correo electrónico debe contener al menos el símbolo @.");
            } else {
                validInput = true;
            }
        }
        return correoElectronico;
    }

    private long obtenerNumeroTelefono() {
        long numeroTelefono = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Ingrese su número de teléfono móvil:");
                String inputTelefono = scanner.nextLine(); // Lee el número de teléfono ingresado por el comprador
                if (inputTelefono.length() < 10) {  //verifica que el numero sea valido a un numero argentino
                    throw new InputMismatchException();
                }
                numeroTelefono = Long.parseLong(inputTelefono);
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número de teléfono válido ");
            }
        }
        return numeroTelefono;
    }

    private int obtenerNumeroEntrada() {
        int numeroEntrada = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Seleccione el número de entrada que desea comprar: ");
                numeroEntrada = scanner.nextInt(); // Lee el número de entrada seleccionado por el comprador
                scanner.nextLine(); // Limpiar Buffer
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número de entrada válido.");
                scanner.nextLine(); // Limpiar el Buffer
            }
        }
        return numeroEntrada;
    }
}
