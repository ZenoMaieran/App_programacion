package InterfazVisual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import Backend_Logica_Eventos.Evento;
import Backend_Logica.Direccion;

public class CrearEventoFrame extends JFrame {

    private JTextField txtTitulo, txtCalle, txtNumero, txtCiudad, txtCodigoPostal, txtFechaHora, txtPrecio, txtMaxEntradas;
    private JComboBox<String> comboTipo, comboCalificacion;
    private JButton btnGuardar;
    private DefaultTableModel modelo;
    private ArrayList<Evento> listaEventos;
    private Evento eventoEditar = null;
    private int indexEditar = -1;

    public CrearEventoFrame(DefaultTableModel modelo, ArrayList<Evento> listaEventos) {
        this.modelo = modelo;
        this.listaEventos = listaEventos;
        setTitle("Añadir Nuevo Evento - JavaEvents");
        setSize(400, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
    }

    public CrearEventoFrame(DefaultTableModel modelo, ArrayList<Evento> listaEventos, Evento eventoEditar, int indexEditar) {
        this(modelo, listaEventos);
        this.eventoEditar = eventoEditar;
        this.indexEditar = indexEditar;
        if (eventoEditar != null) {
            rellenarCamposConEvento();
        }
    }

    private void rellenarCamposConEvento() {
        txtTitulo.setText(eventoEditar.getTitulo());
        comboTipo.setSelectedItem(eventoEditar.getTipo());
        txtCalle.setText(eventoEditar.getDireccion().getCalle());
        txtNumero.setText(String.valueOf(eventoEditar.getDireccion().getNumero()));
        txtCiudad.setText(eventoEditar.getDireccion().getCiudad());
        txtCodigoPostal.setText(String.valueOf(eventoEditar.getDireccion().getCodigoPostal()));
        txtFechaHora.setText(eventoEditar.getFecha().toString().replace("T", " "));
        txtPrecio.setText(String.valueOf(eventoEditar.getPrecio()));
        comboCalificacion.setSelectedItem(String.valueOf(eventoEditar.getCalificacion()));
        txtMaxEntradas.setText(String.valueOf(eventoEditar.getMaxEntradas()));
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(11, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        txtTitulo = new JTextField();
        comboTipo = new JComboBox<>(new String[]{"Concierto", "Deporte", "Musical", "Teatro"});
        txtCalle = new JTextField();
        txtNumero = new JTextField();
        txtCiudad = new JTextField();
        txtCodigoPostal = new JTextField();
        txtFechaHora = new JTextField(); // yyyy-MM-dd HH:mm
        txtPrecio = new JTextField();
        comboCalificacion = new JComboBox<>(new String[]{"1", "2", "3", "4", "5"});
        txtMaxEntradas = new JTextField();

        btnGuardar = new JButton("Guardar");

        panel.add(new JLabel("Título del evento:"));
        panel.add(txtTitulo);
        panel.add(new JLabel("Tipo:"));
        panel.add(comboTipo);
        panel.add(new JLabel("Calle:"));
        panel.add(txtCalle);
        panel.add(new JLabel("Número:"));
        panel.add(txtNumero);
        panel.add(new JLabel("Ciudad:"));
        panel.add(txtCiudad);
        panel.add(new JLabel("Código Postal:"));
        panel.add(txtCodigoPostal);
        panel.add(new JLabel("Fecha y hora (yyyy-MM-dd HH:mm):"));
        panel.add(txtFechaHora);
        panel.add(new JLabel("Precio:"));
        panel.add(txtPrecio);
        panel.add(new JLabel("Calificación:"));
        panel.add(comboCalificacion);
        panel.add(new JLabel("Máx. entradas:"));
        panel.add(txtMaxEntradas);

        panel.add(new JLabel()); // espacio vacío
        panel.add(btnGuardar);

        add(panel);

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarEvento();
            }
        });
    }

    private void guardarEvento() {
        try {
            String titulo = txtTitulo.getText();
            String tipo = comboTipo.getSelectedItem().toString();
            String calle = txtCalle.getText();
            int numero = Integer.parseInt(txtNumero.getText());
            String ciudad = txtCiudad.getText();
            String codigoPostal = txtCodigoPostal.getText();
            String fechaHora = txtFechaHora.getText(); // formato yyyy-MM-dd HH:mm
            double precio = Double.parseDouble(txtPrecio.getText());
            int calificacion = Integer.parseInt(comboCalificacion.getSelectedItem().toString());
            int maxEntradas = Integer.parseInt(txtMaxEntradas.getText());

            Evento nuevo = new Evento(
                titulo,
                tipo,
                new Direccion(calle, numero, ciudad, Integer.parseInt(codigoPostal)),
                java.time.LocalDateTime.parse(fechaHora.replace(" ", "T")),
                precio,
                calificacion,
                maxEntradas
            );

            if (eventoEditar != null && indexEditar >= 0) {
                listaEventos.set(indexEditar, nuevo);
                modelo.setValueAt(titulo, indexEditar, 0);
                modelo.setValueAt(tipo, indexEditar, 1);
                modelo.setValueAt(ciudad, indexEditar, 2);
                modelo.setValueAt(fechaHora, indexEditar, 3);
                modelo.setValueAt(precio, indexEditar, 4);
            } else {
                listaEventos.add(nuevo);
                modelo.addRow(new Object[]{
                    titulo,
                    tipo,
                    ciudad,
                    fechaHora,
                    precio
                });
            }

            Backend_Logica_Eventos.GestorArchivosEventos.guardarEventos(listaEventos);
            JOptionPane.showMessageDialog(this, "Evento guardado correctamente.");
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el evento: " + ex.getMessage());
        }
    }
}
