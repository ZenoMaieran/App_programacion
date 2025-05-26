package InterfazVisual;

import Backend_Logica_Reservas.*;
import Backend_Logica_Eventos.Evento;
import Backend_Logica_Clientes.Cliente;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Backend_Logica.Direccion;
import Backend_Logica.TarjetaCredito;
import Backend_Logica_Facturas.FacturaGenerator;
import java.io.IOException;

public class CrearReservaFrame extends javax.swing.JFrame {

    private final DefaultTableModel modeloTabla;
    private final ArrayList<Reserva> listaReservas;
    private final Reserva reservaEditada;   
    private final int filaEditar;
    private final ArrayList<Cliente> listaClientes;
    private final ArrayList<Evento> listaEventos;

    public CrearReservaFrame(DefaultTableModel modeloTabla,
                             ArrayList<Reserva> listaReservas,
                             ArrayList<Cliente> listaClientes,
                             ArrayList<Evento> listaEventos,
                             Reserva reservaEditada,
                             int filaEditar) {
       this.modeloTabla = modeloTabla;
       this.listaReservas = listaReservas;
       this.listaClientes = listaClientes;
       this.listaEventos = listaEventos;
       this.reservaEditada = reservaEditada;
       this.filaEditar = filaEditar;

       initComponents();
       cargarCombosDesdeSistema(); // aquí usamos los datos reales

       if (reservaEditada != null) {
           comboCliente.setSelectedItem(reservaEditada.getCliente());
           comboEvento.setSelectedItem(reservaEditada.getEvento());
           txtPrecio.setText(String.valueOf(reservaEditada.getPrecioFinal()));
           setTitle("Editar reserva");
       } else {
           setTitle("Añadir reserva");
       }
    }

    private void cargarCombosDesdeSistema() {
        comboCliente.removeAllItems();
        for (Cliente c : listaClientes) {
            comboCliente.addItem(c);
        }

        comboEvento.removeAllItems();
        for (Evento e : listaEventos) {
            comboEvento.addItem(e);
        }
    }

    /* Botón Guardar --------------------------- */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Cliente cli = (Cliente) comboCliente.getSelectedItem();
            Evento ev = (Evento) comboEvento.getSelectedItem();
            double precio = Double.parseDouble(txtPrecio.getText());

            // Fecha actual
            Reserva nueva = new Reserva(cli, ev, LocalDateTime.now(), precio);

            if (reservaEditada == null) {              // Alta
                listaReservas.add(nueva);
                modeloTabla.addRow(new Object[]{
                    cli.getNombre(), ev.getTitulo(),
                    nueva.getFechaReserva().toString(),
                    precio
                });
            } else {                                   // Modificación
                listaReservas.set(filaEditar, nueva);
                modeloTabla.setValueAt(cli.getNombre(), filaEditar, 0);
                modeloTabla.setValueAt(ev.getTitulo(), filaEditar, 1);
                modeloTabla.setValueAt(nueva.getFechaReserva().toString(), filaEditar, 2);
                modeloTabla.setValueAt(precio, filaEditar, 3);
            }

            GestorArchivosReservas.guardarReservas(listaReservas);

            // ✅ Generar la factura usando FacturaGenerator
            FacturaGenerator.generarFactura(nueva);

            JOptionPane.showMessageDialog(this, "Reserva y factura generadas con éxito.");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Precio no válido.");
        }
    }

    /* ========== GUI ========== */
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboCliente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comboEvento = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Cliente:");
        jPanel1.add(jLabel1);
        jPanel1.add(comboCliente);

        jLabel2.setText("Evento:");
        jPanel1.add(jLabel2);
        jPanel1.add(comboEvento);

        jLabel3.setText("Precio (€):");
        jPanel1.add(jLabel3);

        txtPrecio.setColumns(6);
        jPanel1.add(txtPrecio);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        jPanel1.add(btnGuardar);

        getContentPane().add(jPanel1);
        pack();
        setLocationRelativeTo(null);
    }

    /* Variables GUI */
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Cliente> comboCliente;
    private javax.swing.JComboBox<Evento> comboEvento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtPrecio;
}
