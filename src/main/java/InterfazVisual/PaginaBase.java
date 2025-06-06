/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazVisual;
import Backend_Logica.GestorDatosSerializador;
import Backend_Logica.GestionDatos;
import Backend_Logica_Eventos.GestorArchivosEventos;
/**
 *
 * @author anton
 */
public class PaginaBase extends javax.swing.JFrame {
    
    private GestionDatos gestor;
    
    /**
     * Creates new form PaginaBase
     */
    public PaginaBase(GestionDatos gestor) {
        this.setLocationRelativeTo(null);
        this.gestor = gestor;
        initComponents();
        
    }

    private PaginaBase() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        BusquedaEvento = new javax.swing.JButton();
        ConsultarReservas = new javax.swing.JButton();
        miPerfil = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuEventos = new javax.swing.JMenuItem();
        menuReservas = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaEvents - Pagina Principal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        BusquedaEvento.setText("Buscar Eventos");
        BusquedaEvento.setAlignmentX(0.5F);
        BusquedaEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaEventoActionPerformed(evt);
            }
        });

        ConsultarReservas.setText("Consultar Reservas");
        ConsultarReservas.setAlignmentX(0.5F);
        ConsultarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarReservasActionPerformed(evt);
            }
        });

        miPerfil.setText("MI PERFIL");
        miPerfil.setAlignmentX(0.5F);
        miPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPerfilActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setText("JavaEvents");
        jLabel3.setAlignmentX(0.5F);

        jMenu1.setText("Eventos");

        menuEventos.setText("Ir a Eventos");
        menuEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEventosActionPerformed(evt);
            }
        });
        jMenu1.add(menuEventos);

        jMenuBar1.add(jMenu1);

        menuReservas.setText("Reservas");

        jMenuItem2.setText("Ir a reservas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuReservas.add(jMenuItem2);

        jMenuBar1.add(menuReservas);

        jMenu7.setText("Cerrar Sesion");

        jMenuItem3.setText("Cerrar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem3);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(miPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BusquedaEvento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ConsultarReservas, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(miPerfil)))
                .addGap(38, 38, 38)
                .addComponent(BusquedaEvento)
                .addGap(18, 18, 18)
                .addComponent(ConsultarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BusquedaEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaEventoActionPerformed
        // TODO add your handling code here:
        Eventos eventos = new Eventos(gestor, this);
        eventos.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_BusquedaEventoActionPerformed

    private void menuEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEventosActionPerformed
        // TODO add your handling code here:
        Eventos eventos = new Eventos(gestor, this);
        eventos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuEventosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        GestorDatosSerializador.guardarUsuarios(gestor);
        GestorDatosSerializador.guardarClientes(gestor);
        GestorArchivosEventos.guardarEventos(gestor.getListaEventos());

    }//GEN-LAST:event_formWindowClosing

    private void miPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPerfilActionPerformed
        // TODO add your handling code here:
        if (gestor.getClienteLogeado() == null){
            PerfilUsuario perfil = new PerfilUsuario(gestor, this);
            this.setVisible(false);
            perfil.setVisible(true);
        }
    }//GEN-LAST:event_miPerfilActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        gestor.setClienteLogeado(null);
        VentanaPrincipal inicio = new VentanaPrincipal();
        this.setVisible(false);
        inicio.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        ReservasClientes reservas = new ReservasClientes(gestor, this);
        this.setVisible(false);
        reservas.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void ConsultarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarReservasActionPerformed
        // TODO add your handling code here:
        ReservasClientes reservas = new ReservasClientes(gestor, this);
        this.setVisible(false);
        reservas.setVisible(true);
    }//GEN-LAST:event_ConsultarReservasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaginaBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaBase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BusquedaEvento;
    private javax.swing.JButton ConsultarReservas;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem menuEventos;
    private javax.swing.JMenu menuReservas;
    private javax.swing.JButton miPerfil;
    // End of variables declaration//GEN-END:variables
}
