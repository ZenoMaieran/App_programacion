package InterfazVisual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import Backend_Logica_Eventos.Evento;
import Backend_Logica.Direccion;

public class CrearEventoFrame extends JFrame {

    private JTextField txtTitulo, txtCalle, txtNumero, txtCiudad, txtCodigoPostal, txtFechaHora, txtPrecio;
    private JComboBox<String> comboTipo, comboCalificacion;
    private JButton btnGuardar;
    private DefaultTableModel modelo;
    private ArrayList<Evento> listaEventos;

public CrearEventoFrame(DefaultTableModel modelo, ArrayList<Evento> listaEventos) {
    this.modelo = modelo; // Guarda el modelo en el atributo de clase
    this.listaEventos = listaEventos;
    setTitle("Añadir Nuevo Evento - JavaEvents");
    setSize(400, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    initComponents();
}


    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(10, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Componentes
        txtTitulo = new JTextField();
        comboTipo = new JComboBox<>(new String[]{"Concierto", "Deporte", "Musical", "Teatro"});
        txtCalle = new JTextField();
        txtNumero = new JTextField();
        txtCiudad = new JTextField();
        txtCodigoPostal = new JTextField();
        txtFechaHora = new JTextField(); // yyyy-MM-dd HH:mm
        txtPrecio = new JTextField();
        comboCalificacion = new JComboBox<>(new String[]{"1", "2", "3", "4", "5"});

        btnGuardar = new JButton("Guardar");

        // Añadir al panel
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

        panel.add(new JLabel()); // espacio vacío
        panel.add(btnGuardar);

        add(panel);

        // Acción del botón
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

        Evento nuevo = new Evento(
            titulo,
            tipo,
            new Direccion(calle, numero, ciudad, Integer.parseInt(codigoPostal)),
            java.time.LocalDateTime.parse(fechaHora.replace(" ", "T")),
            precio,
            calificacion
        );

        listaEventos.add(nuevo);

        modelo.addRow(new Object[]{
            titulo,
            tipo,
            ciudad,
            fechaHora,
            precio
        });

        // 💾 Guardar en archivo
        Backend_Logica_Eventos.GestorArchivosEventos.guardarEventos(listaEventos);

        JOptionPane.showMessageDialog(this, "Evento guardado correctamente.");
        dispose();

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al guardar el evento: " + ex.getMessage());
    }
}


}
