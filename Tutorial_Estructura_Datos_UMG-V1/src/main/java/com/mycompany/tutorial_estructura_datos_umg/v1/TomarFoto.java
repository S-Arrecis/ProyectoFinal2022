
package com.mycompany.tutorial_estructura_datos_umg.v1;


import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class TomarFoto extends javax.swing.JFrame {
    int largocamara = 170;//ancho
    int anchocamara = 110;//largo
    BufferedImage ruta;
    int contador = 0;
    Dimension dimension = new Dimension(largocamara, anchocamara);
    Dimension dimension1 = WebcamResolution.VGA.getSize();
    Webcam webcam = Webcam.getDefault();
    WebcamPanel webcamPanel = new WebcamPanel(webcam, dimension, false);
     Icon iconoFoto;
    public TomarFoto() {
        initComponents();
        this.setLocationRelativeTo(null);
        webcam.setViewSize(dimension1);
        webcamPanel.setFitArea(true);
        panelfoto.setLayout(new FlowLayout());
        panelfoto.add(webcamPanel);
         ImageIcon AddUser = new ImageIcon("AddUser.png");
         iconoFoto=AddUser;
    EncenderCamara();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panelfoto = new javax.swing.JPanel();
        lblfoto = new javax.swing.JLabel();
        TOMARFOTO = new javax.swing.JButton();
        GUARDARFOTO = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(0, 0, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelfoto.setBackground(new java.awt.Color(255, 255, 255));
        panelfoto.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 102)));

        javax.swing.GroupLayout panelfotoLayout = new javax.swing.GroupLayout(panelfoto);
        panelfoto.setLayout(panelfotoLayout);
        panelfotoLayout.setHorizontalGroup(
            panelfotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 166, Short.MAX_VALUE)
        );
        panelfotoLayout.setVerticalGroup(
            panelfotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        jPanel3.add(panelfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 110));

        lblfoto.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 255, 255)));
        jPanel3.add(lblfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 160, 110));

        TOMARFOTO.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        TOMARFOTO.setText("TOMAR FOTO");
        TOMARFOTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TOMARFOTOActionPerformed(evt);
            }
        });
        jPanel3.add(TOMARFOTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, 30));

        GUARDARFOTO.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        GUARDARFOTO.setText("CONFIRMAR FOTO");
        GUARDARFOTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUARDARFOTOActionPerformed(evt);
            }
        });
        jPanel3.add(GUARDARFOTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 170, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 380, 200));

        btnCerrar.setBackground(new java.awt.Color(204, 204, 204));
        btnCerrar.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 0, 51));
        btnCerrar.setText("x");
        btnCerrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 51), new java.awt.Color(204, 0, 0), new java.awt.Color(204, 0, 51)));
        btnCerrar.setBorderPainted(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 40, 30));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setText("Tomar una Fotografía");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncenderActionPerformed
    Thread hilo = new Thread() {
            @Override
            public void run() {
                webcamPanel.start();
              }
        };
        hilo.setDaemon(true);
        hilo.start();
    
    }//GEN-LAST:event_btnEncenderActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        webcamPanel.stop();
        lblfoto.setIcon(null);
       
    }//GEN-LAST:event_btnApagarActionPerformed

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
     
   
    }//GEN-LAST:event_btnFotoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
      int pregunta = JOptionPane.showConfirmDialog(this, "¿Guardar Fotografia?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (pregunta == 0) {
            File salidaimagen = new File("C:\\Users\\armando\\Pictures\\Foto" + contador + ".jpg");
            try {
                ImageIO.write(ruta, "jpg", salidaimagen);
                JOptionPane.showMessageDialog(null, "Guardado en:" + salidaimagen.getAbsolutePath());
            } catch (IOException e) {

                System.out.println("Error " + e);
            }
            lblfoto.setIcon(null);
           }
        contador++;
    }//GEN-LAST:event_btnGuardarActionPerformed
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
   ApagarCamara();
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed
File salidaimagen;
    private void GUARDARFOTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUARDARFOTOActionPerformed
    int pregunta = JOptionPane.showConfirmDialog(this, "¿Quiero esta Fotografia?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (pregunta == 0) {
       salidaimagen = new File("FOTOS/"+ contador + ".jpg");
            try {
                ImageIO.write(ruta, "jpg", salidaimagen);
              //  JOptionPane.showMessageDialog(null, "Guardado en:" + salidaimagen.getAbsolutePath());
            } catch (IOException e) {

                System.out.println("Error " + e);
            }
            lblfoto.setIcon(null);
           }
        contador++;
        System.out.println(salidaimagen);
         webcamPanel.stop();
        this.dispose();
        
    }//GEN-LAST:event_GUARDARFOTOActionPerformed
private void EncenderCamara(){
  Thread hilo = new Thread() {
            @Override
            public void run() {
                webcamPanel.start();
              }
        };
        hilo.setDaemon(true);
        hilo.start();
}
    
 private void ApagarCamara(){
   webcamPanel.stop();
        lblfoto.setIcon(null);
 }   
    
   
    
    private void TOMARFOTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TOMARFOTOActionPerformed
    NuevoUsuario NUv = null;
    
        
        TOMARFOTO.setText("Tomar Otra");
        GUARDARFOTO.setEnabled(true);
        ImageIcon foto;
        foto = new ImageIcon(webcam.getImage());
        iconoFoto = new ImageIcon(foto.getImage().getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_SMOOTH));
        lblfoto.setIcon(iconoFoto);
        ruta = webcam.getImage();
        NUv.RI((ImageIcon) iconoFoto);

        
    }//GEN-LAST:event_TOMARFOTOActionPerformed

ImageIcon ventan(){

ImageIcon img = (ImageIcon)iconoFoto;
        return img;


}

File ruta(){
System.out.println(salidaimagen.getAbsolutePath());
        return salidaimagen.getAbsoluteFile();
    
}
    
    
    
    
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
            java.util.logging.Logger.getLogger(TomarFoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TomarFoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TomarFoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TomarFoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TomarFoto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GUARDARFOTO;
    private javax.swing.JButton TOMARFOTO;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JPanel panelfoto;
    // End of variables declaration//GEN-END:variables
}
