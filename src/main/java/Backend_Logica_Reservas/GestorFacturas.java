package Backend_Logica_Reservas;

import java.awt.Desktop;
import java.io.*;
import java.time.format.DateTimeFormatter;

public class GestorFacturas {

    public static void generarFacturaTxt(Reserva reserva) {
        try {
            System.out.println("Iniciando generación de factura...");

            DateTimeFormatter formatterArchivo = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String fechaFormateada = reserva.getFechaReserva().format(formatterArchivo);
            String correoLimpio = reserva.getCliente().getCorreo().replaceAll("[^a-zA-Z0-9]", "_");

            String nombreArchivo = "Factura_" + correoLimpio + "_" + fechaFormateada + ".txt";
            File carpeta = new File("facturas");
            if (!carpeta.exists()) {
                System.out.println("Carpeta 'facturas' no existe. Creándola...");
                carpeta.mkdirs();
            }

            File archivoFactura = new File(carpeta, nombreArchivo);
            System.out.println("Ruta completa del archivo: " + archivoFactura.getAbsolutePath());

            try (PrintWriter writer = new PrintWriter(archivoFactura)) {
                writer.println("----- FACTURA -----");
                writer.println("Cliente: " + reserva.getCliente().getCorreo());
                writer.println("Evento: " + reserva.getEvento().getTitulo());
                writer.println("Fecha de reserva: " + reserva.getFechaReserva().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                writer.println("Cantidad de entradas: " + reserva.getCantidad());
                writer.println("Precio total: " + reserva.getPrecioFinal() + "€");
                writer.println("--------------------");
            }

            System.out.println("Factura escrita con éxito.");
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(archivoFactura);
                System.out.println("Factura abierta con el programa predeterminado.");
            }

        } catch (IOException e) {
            System.err.println("Error al generar o abrir la factura: " + e.getMessage());
            e.printStackTrace();
        }
    }



}
