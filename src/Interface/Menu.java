package Interface;
/**
 *
 * @author S.C.C.
 */
public class Menu extends javax.swing.JFrame {
    public Menu() {
        initComponents();
        EscFazenda faze = new EscFazenda(this,true);
        faze.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenuItem();
        jMenuAnimais = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuConMas = new javax.swing.JMenu();
        jMenuConSan = new javax.swing.JMenu();
        jMenuAmor = new javax.swing.JMenu();
        jMenuFin = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 700));

        Desktop.setOpaque(false);

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 827, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );

        jMenuFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1481527886_notes.png"))); // NOI18N
        jMenuFile.setText("File");

        jMenuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1481528191_logout.png"))); // NOI18N
        jMenuSair.setText("Sair");
        jMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSairActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuSair);

        jMenuBar1.add(jMenuFile);

        jMenuAnimais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1481526126_cow.png"))); // NOI18N
        jMenuAnimais.setText("Animais");
        jMenuAnimais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuAnimaisMouseClicked(evt);
            }
        });
        jMenuAnimais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAnimaisActionPerformed(evt);
            }
        });

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1481650391_magnifyingglass.png"))); // NOI18N
        jMenuItem1.setText("Procurar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuAnimais.add(jMenuItem1);

        jMenuBar1.add(jMenuAnimais);

        jMenuConMas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1481527641_medical-58.png"))); // NOI18N
        jMenuConMas.setText("Controle de Mastite");
        jMenuBar1.add(jMenuConMas);

        jMenuConSan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1481527628_medical-51.png"))); // NOI18N
        jMenuConSan.setText("Controle Sanitário");
        jMenuBar1.add(jMenuConSan);

        jMenuAmor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/genetic.png"))); // NOI18N
        jMenuAmor.setText("Reprodução");
        jMenuBar1.add(jMenuAmor);

        jMenuFin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1481530188_23.png"))); // NOI18N
        jMenuFin.setText("Financeiro");
        jMenuBar1.add(jMenuFin);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuSairActionPerformed

    private void jMenuAnimaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAnimaisActionPerformed
        // TODO add your handling code here:
                
    }//GEN-LAST:event_jMenuAnimaisActionPerformed

    private void jMenuAnimaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuAnimaisMouseClicked
        // TODO add your handling code here:ProcurarAnimais Ani = new ProcurarAnimais();
        
    }//GEN-LAST:event_jMenuAnimaisMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        ProcurarAnimais ProAni = new ProcurarAnimais();
        Desktop.add(ProAni);
        ProAni.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenu jMenuAmor;
    private javax.swing.JMenu jMenuAnimais;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuConMas;
    private javax.swing.JMenu jMenuConSan;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuFin;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuSair;
    // End of variables declaration//GEN-END:variables
}
