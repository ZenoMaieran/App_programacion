package Backend_Logica_Reservas;

import Backend_Logica_Eventos.Evento;
import Backend_Logica_Clientes.Cliente;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Reserva implements Serializable {
    private Cliente cliente;
    private Evento evento;
    private LocalDateTime fechaReserva;
    private double precioFinal;

    public Reserva(Cliente cliente, Evento evento, LocalDateTime fechaReserva, double precioFinal) {
        this.cliente = cliente;
        this.evento = evento;
        this.fechaReserva = fechaReserva;
        this.precioFinal = precioFinal;
    }

    public Cliente getCliente() { return cliente; }
    public Evento getEvento() { return evento; }
    public LocalDateTime getFechaReserva() { return fechaReserva; }
    public double getPrecioFinal() { return precioFinal; }
}
