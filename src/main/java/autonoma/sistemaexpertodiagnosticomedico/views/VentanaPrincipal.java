/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package autonoma.sistemaexpertodiagnosticomedico.views;

import autonoma.sistemaexpertodiagnosticomedico.models.Enfermedad;
import autonoma.sistemaexpertodiagnosticomedico.models.Paciente;
import autonoma.sistemaexpertodiagnosticomedico.models.PacienteDAO;
import autonoma.sistemaexpertodiagnosticomedico.models.PrologQueryExecutor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    private PacienteDAO pacienteDAO;
    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        pacienteDAO = new PacienteDAO();
    }
    
    private List<String> listaSintomas(){
        List<String> sintomas = new ArrayList<>();
        if (this.fiebre.isSelected()) {
            sintomas.add("fiebre");
        }
        if (this.tos.isSelected()) {
            sintomas.add("tos");
        }
        if (this.dolorcabeza.isSelected()) {
            sintomas.add("dolor_cabeza");
        }
        if (this.dolorMuscular.isSelected()) {
            sintomas.add("dolor_muscular");
        }
        if (this.estornudos.isSelected()) {
            sintomas.add("estornudos");
        }
        if (this.dolorGarganta.isSelected()) {
            sintomas.add("dolor_garganta");
        }
        if (this.congestionNasal.isSelected()) {
            sintomas.add("congestion_nasal");
        }
        if (this.fatiga.isSelected()) {
            sintomas.add("fatiga");
        }
        if (this.escalofrios.isSelected()) {
            sintomas.add("escalofrios");
        }
        if (this.dolorCuerpo.isSelected()) {
            sintomas.add("dolor_en_el_cuerpo");
        }
        if (this.secrecionNasal.isSelected()) {
            sintomas.add("secrecion_nasal");
        }
        if (this.ojosLlorosos.isSelected()) {
            sintomas.add("ojos_llorosos");
        }       
        if (this.txtOtrosintoma.getText() != null && !this.txtOtrosintoma.getText().trim().isEmpty()) {
            sintomas.add(this.txtOtrosintoma.getText().trim());
        }
        return sintomas;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNombreP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEdadP = new javax.swing.JTextField();
        btnPacienteNuevoCrear = new javax.swing.JButton();
        btnSalirApp = new javax.swing.JButton();
        btonVerInfoPacintes = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        fiebre = new javax.swing.JCheckBox();
        tos = new javax.swing.JCheckBox();
        dolorcabeza = new javax.swing.JCheckBox();
        dolorMuscular = new javax.swing.JCheckBox();
        estornudos = new javax.swing.JCheckBox();
        congestionNasal = new javax.swing.JCheckBox();
        ojosLlorosos = new javax.swing.JCheckBox();
        secrecionNasal = new javax.swing.JCheckBox();
        dolorCuerpo = new javax.swing.JCheckBox();
        escalofrios = new javax.swing.JCheckBox();
        fatiga = new javax.swing.JCheckBox();
        dolorGarganta = new javax.swing.JCheckBox();
        txtOtrosintoma = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(102, 0, 102));

        jLabel1.setFont(new java.awt.Font("Stencil", 0, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema Experto de Diagnotico Medico");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(102, 0, 102));
        jButton1.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        jButton1.setText("Generar diagnostico");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Juan Sebastian Lopez Guzman");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese el nombre del paciente");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingrese la edad del paciente");

        btnPacienteNuevoCrear.setText("Crear nuevo paciente");
        btnPacienteNuevoCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacienteNuevoCrearActionPerformed(evt);
            }
        });

        btnSalirApp.setText("Salir");
        btnSalirApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirAppActionPerformed(evt);
            }
        });

        btonVerInfoPacintes.setBackground(new java.awt.Color(102, 0, 102));
        btonVerInfoPacintes.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        btonVerInfoPacintes.setText("Ver info pacientes");
        btonVerInfoPacintes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonVerInfoPacintesActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sintomas");

        fiebre.setBackground(new java.awt.Color(0, 0, 0));
        fiebre.setForeground(new java.awt.Color(255, 255, 255));
        fiebre.setText("Fiebre");
        fiebre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiebreActionPerformed(evt);
            }
        });

        tos.setBackground(new java.awt.Color(0, 0, 0));
        tos.setForeground(new java.awt.Color(255, 255, 255));
        tos.setText("Tos");

        dolorcabeza.setBackground(new java.awt.Color(0, 0, 0));
        dolorcabeza.setForeground(new java.awt.Color(255, 255, 255));
        dolorcabeza.setText("dolor de cabeza");

        dolorMuscular.setBackground(new java.awt.Color(0, 0, 0));
        dolorMuscular.setForeground(new java.awt.Color(255, 255, 255));
        dolorMuscular.setText("dolor muscular");

        estornudos.setBackground(new java.awt.Color(0, 0, 0));
        estornudos.setForeground(new java.awt.Color(255, 255, 255));
        estornudos.setText("estornudos");

        congestionNasal.setBackground(new java.awt.Color(0, 0, 0));
        congestionNasal.setForeground(new java.awt.Color(255, 255, 255));
        congestionNasal.setText("congestion nasal");

        ojosLlorosos.setBackground(new java.awt.Color(0, 0, 0));
        ojosLlorosos.setForeground(new java.awt.Color(255, 255, 255));
        ojosLlorosos.setText("ojos llorosos");

        secrecionNasal.setBackground(new java.awt.Color(0, 0, 0));
        secrecionNasal.setForeground(new java.awt.Color(255, 255, 255));
        secrecionNasal.setText("secrecional nasal");

        dolorCuerpo.setBackground(new java.awt.Color(0, 0, 0));
        dolorCuerpo.setForeground(new java.awt.Color(255, 255, 255));
        dolorCuerpo.setText("dolor en el cuerpo");

        escalofrios.setBackground(new java.awt.Color(0, 0, 0));
        escalofrios.setForeground(new java.awt.Color(255, 255, 255));
        escalofrios.setText("escalofrios");

        fatiga.setBackground(new java.awt.Color(0, 0, 0));
        fatiga.setForeground(new java.awt.Color(255, 255, 255));
        fatiga.setText("fatiga");

        dolorGarganta.setBackground(new java.awt.Color(0, 0, 0));
        dolorGarganta.setForeground(new java.awt.Color(255, 255, 255));
        dolorGarganta.setText("dolor de garganta");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Otro Sintoma: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 1059, Short.MAX_VALUE)
                                .addComponent(jLabel3))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombreP, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEdadP))
                            .addComponent(btnPacienteNuevoCrear)
                            .addComponent(btnSalirApp))
                        .addGap(139, 139, 139)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dolorcabeza)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(dolorMuscular)
                                                .addComponent(dolorGarganta, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(estornudos))
                                            .addComponent(tos))
                                        .addGap(45, 45, 45))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(fiebre)
                                        .addGap(109, 109, 109)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(congestionNasal)
                                    .addComponent(ojosLlorosos)
                                    .addComponent(fatiga)
                                    .addComponent(escalofrios)
                                    .addComponent(dolorCuerpo)
                                    .addComponent(secrecionNasal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(13, 13, 13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOtrosintoma, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btonVerInfoPacintes)
                                .addGap(30, 30, 30)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPacienteNuevoCrear)
                            .addComponent(btonVerInfoPacintes, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalirApp)
                        .addGap(85, 85, 85)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fiebre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(congestionNasal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(tos)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEdadP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dolorcabeza)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dolorMuscular)))
                                .addGap(32, 32, 32))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fatiga)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(escalofrios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dolorCuerpo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(secrecionNasal)
                                    .addComponent(estornudos))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dolorGarganta)
                            .addComponent(ojosLlorosos))
                        .addGap(49, 49, 49)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOtrosintoma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombre = txtNombreP.getText().trim();
        String edadTexto = txtEdadP.getText().trim();

        if (nombre.isEmpty() || edadTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor ingrese nombre y edad del paciente",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener síntomas
        List<String> sintomas = listaSintomas();

        if (sintomas.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor seleccione al menos un síntoma",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Hacer consulta a Prolog
        List<Enfermedad> diagnosticos = PrologQueryExecutor.getDiagnosticos(sintomas);

        if (diagnosticos.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No se encontraron enfermedades con esos síntomas",
                    "Sin resultados",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Mostrar resultados de forma simple
        String mensaje = "DIAGNÓSTICOS POSIBLES:\n\n";

        for (Enfermedad enf : diagnosticos) {
            mensaje += "Enfermedad: " + enf.getNombre() + "\n";
            mensaje += "Categoría: " + enf.getNombreCategoria() + "\n";
            mensaje += "Recomendación: " + enf.getRecomendacion_basica() + "\n";
            mensaje += "-------------------\n";
        }

        JOptionPane.showMessageDialog(this,
                mensaje,
                "Diagnósticos para " + nombre,
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPacienteNuevoCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacienteNuevoCrearActionPerformed
        crearNuevoPaciente();
    }//GEN-LAST:event_btnPacienteNuevoCrearActionPerformed

    private void btnSalirAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirAppActionPerformed
        salirAplicacion();
    }//GEN-LAST:event_btnSalirAppActionPerformed

    private void btonVerInfoPacintesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonVerInfoPacintesActionPerformed
        VentanaMostrarInfoPacientes ventanaInfo = new VentanaMostrarInfoPacientes(this, true);
        ventanaInfo.setVisible(true);
    }//GEN-LAST:event_btonVerInfoPacintesActionPerformed

    private void fiebreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiebreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fiebreActionPerformed
    private void crearNuevoPaciente() {
        // Obtener datos de los campos de texto
        String nombre = txtNombreP.getText().trim();
        String edadTexto = txtEdadP.getText().trim();

        // Validar que los campos no estén vacíos
        if (nombre.isEmpty() || edadTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor complete todos los campos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar la edad
        int edad;
        try {
            edad = Integer.parseInt(edadTexto);
            if (edad <= 0 || edad > 120) {
                JOptionPane.showMessageDialog(this,
                        "La edad debe estar entre 1 y 120 años.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "La edad debe ser un número válido.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Crear objeto Paciente
            Paciente paciente = new Paciente();
            paciente.setNombre(nombre);
            paciente.setEdad(edad);

            // Verificar si el paciente ya existe
            Paciente existente = pacienteDAO.buscarPorNombre(nombre);
            if (existente != null) {
                int respuesta = JOptionPane.showConfirmDialog(this,
                        "Ya existe un paciente con ese nombre.\n¿Desea continuar de todos modos?",
                        "Paciente existente",
                        JOptionPane.YES_NO_OPTION);

                if (respuesta != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            // Insertar paciente en la base de datos
            int pacienteId = pacienteDAO.insertarPaciente(paciente);

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this,
                    "Paciente creado exitosamente!\n"
                    + "ID: " + pacienteId + "\n"
                    + "Nombre: " + nombre + "\n"
                    + "Edad: " + edad,
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

            // Limpiar campos después del registro
            limpiarCampos();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al guardar el paciente en la base de datos:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error inesperado: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // Método para limpiar los campos del formulario
    private void limpiarCampos() {
        txtNombreP.setText("");
        txtEdadP.setText("");
        txtNombreP.requestFocus(); // Colocar el cursor en el campo de nombre
    }

    // Método para salir de la aplicación
    private void salirAplicacion() {
        int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea salir de la aplicación?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPacienteNuevoCrear;
    private javax.swing.JButton btnSalirApp;
    private javax.swing.JButton btonVerInfoPacintes;
    private javax.swing.JCheckBox congestionNasal;
    private javax.swing.JCheckBox dolorCuerpo;
    private javax.swing.JCheckBox dolorGarganta;
    private javax.swing.JCheckBox dolorMuscular;
    private javax.swing.JCheckBox dolorcabeza;
    private javax.swing.JCheckBox escalofrios;
    private javax.swing.JCheckBox estornudos;
    private javax.swing.JCheckBox fatiga;
    private javax.swing.JCheckBox fiebre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JCheckBox ojosLlorosos;
    private javax.swing.JCheckBox secrecionNasal;
    private javax.swing.JCheckBox tos;
    private javax.swing.JTextField txtEdadP;
    private javax.swing.JTextField txtNombreP;
    private javax.swing.JTextField txtOtrosintoma;
    // End of variables declaration//GEN-END:variables
}
