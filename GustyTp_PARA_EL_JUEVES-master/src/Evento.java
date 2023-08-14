import java.util.ArrayList;
import java.util.List;

public class Evento {
    public String fecha;             // Fecha del evento
    public String hora;              // Hora del evento
    public String lugar;             // Lugar del evento
    public String tdp;     // partido a ocurrir
    public List<Entrada> entradas;   // Lista de entradas disponibles para el evento

    public Evento(String fecha, String hora, String lugar, String tdp) {
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.tdp = tdp;
        this.entradas = new ArrayList<>();   // Inicializar la lista de entradas vacía
    }

    public void agregarEntrada(Entrada entrada) {
        entradas.add(entrada);   // Agregar una entrada a la lista de entradas disponibles
    }

    public List<Entrada> getEntradasDisponibles() {
        List<Entrada> disponibles = new ArrayList<>();
        for (Entrada entrada : entradas) {
            if (!entrada.isOcupada()) {
                disponibles.add(entrada);   // Agregar a la lista de entradas disponibles si no está ocupada
            }
        }
        return disponibles;
    }

    public List<Entrada> getEntradasOcupadas() {
        List<Entrada> ocupadas = new ArrayList<>();
        for (Entrada entrada : entradas) {
            if (entrada.isOcupada()) {
                ocupadas.add(entrada);   // Agregar a la lista de entradas ocupadas si está ocupada
            }
        }
        return ocupadas;
    }
    public Entrada comprarEntrada(int numeroEntrada, String nombreComprador, String correoComprador, long telefonoComprador) {
        for (Entrada entrada : entradas) {
            if (entrada.getNumero() == numeroEntrada && !entrada.isOcupada()) {
                entrada.setOcupada(true);
                entrada.setNombreComprador(nombreComprador);
                entrada.setCorreoComprador(correoComprador);
                entrada.setTelefonoComprador(telefonoComprador);
                return entrada;   // Devolver la entrada comprada
            }
        }
        return null;   // No hay entradas disponibles o el número de entrada es inválido
    }
}
