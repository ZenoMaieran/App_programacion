package Backend_Logica_Facturas;

import Backend_Logica_Reservas.Reserva;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FacturaGenerator {

    public static void generarFactura(Reserva reserva) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = sdf.format(new java.util.Date());
        String nombreArchivo = "facturas/factura_" +
                reserva.getCliente().getNombre().replaceAll(" ", "_") +
                "_" + timestamp + ".txt";

        try {
            File carpeta = new File("facturas");
            if (!carpeta.exists()) {
                carpeta.mkdirs(); // crear carpeta si no existe
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));
            writer.write("----- FACTURA -----\n");
            writer.write("Cliente: " + reserva.getCliente().getNombre() + "\n");
            writer.write("Correo: " + reserva.getCliente().getCorreo() + "\n");
            writer.write("Evento: " + reserva.getEvento().getTitulo() + "\n");
            writer.write("Fecha del evento: " + reserva.getEvento().getFecha().toString() + "\n");
            writer.write("Fecha de reserva: " + reserva.getFechaReserva().toString() + "\n");
            writer.write("Cantidad: " + reserva.getCantidad() + "\n");
            writer.write("Precio total: " + reserva.getTotal() + " €\n");
            writer.write("-------------------\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
