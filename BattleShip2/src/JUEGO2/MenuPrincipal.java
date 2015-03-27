package JUEGO2;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.BorderFactory;

public class MenuPrincipal extends javax.swing.JFrame {
	
	 /** Creates new form NewJFrame */
    public MenuPrincipal() {
        initComponents();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = getSize();
        setLocation((pantalla.width - ventana.width) / 2,(pantalla.height - ventana.height) / 2);
        //this.BATTLESHIP.setBorder(BorderFactory.createRaisedBevelBorder());
       }
	
	
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BtnJugadores = new javax.swing.JButton();
        BtnCargarPartida = new javax.swing.JButton();
        BtnJugar = new javax.swing.JButton();
        //BATTLESHIP = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        BtnReportes = new javax.swing.JButton();
        BtnReportes1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	
        jLabel1.setText("jLabel1");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Dificultad");

        BtnJugadores.setText("Jugadores");
        BtnJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnJugadoresActionPerformed(evt);
            }
        });
        BtnCargarPartida.setText("Cargar Partida");
        BtnCargarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCargarPartidaActionPerformed(evt);
            }
        });

        BtnJugar.setText("Jugar");
        BtnJugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnJugarMouseClicked(evt);
            }
        });
        BtnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnJugarActionPerformed(evt);
            }
        });
       // BATTLESHIP.setBorder(new javax.swing.border.MatteBorder(null));

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Easy", "Normal", "Pro", "Expert", "Insane" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        BtnReportes.setText("Reportes");
        BtnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReportesActionPerformed(evt);
            }
        });

        BtnReportes1.setText("Salir");
        BtnReportes1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnReportes1MouseClicked(evt);
            }
        });
	
        BtnReportes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReportes1ActionPerformed(evt);
            }
        });
        

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(BtnReportes1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        //.addComponent(BATTLESHIP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(BtnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(BtnCargarPartida)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(BtnJugadores)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BtnReportes))))))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
               // .addComponent(BATTLESHIP, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE)
                    .addComponent(BtnReportes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnJugadores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnCargarPartida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnReportes1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void BtnCargarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCargarPartidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCargarPartidaActionPerformed

    private void BtnReportes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReportes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnReportes1ActionPerformed

    private void BtnReportes1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnReportes1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_BtnReportes1MouseClicked

    private void BtnJugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnJugarMouseClicked
        
    }//GEN-LAST:event_BtnJugarMouseClicked

    private void BtnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnJugarActionPerformed
        new Juego().setVisible(true);
    }//GEN-LAST:event_BtnJugarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void BtnJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnJugadoresActionPerformed
        FrameJugadores FrameJugadores=new FrameJugadores();
        FrameJugadores.setVisible(true);
    }//GEN-LAST:event_BtnJugadoresActionPerformed

    private void BtnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReportesActionPerformed
        Reportes form=new Reportes();
        form.setVisible(true);
    }//GEN-LAST:event_BtnReportesActionPerformed
        
    /**
     * @param args the command line arguments
     */

	 public static void main(String args[]) {
	        java.awt.EventQueue.invokeLater(new Runnable() {

	        	
	            public void run() {
	                new MenuPrincipal().setVisible(true);
	            }
	        });
	    }
	    // Variables declaration - do not modify//GEN-BEGIN:variables
	  //  private javax.swing.JLabel BATTLESHIP;
	    private javax.swing.JButton BtnCargarPartida;
	    private javax.swing.JButton BtnJugadores;
	    private javax.swing.JButton BtnJugar;
	    private javax.swing.JButton BtnReportes;
	    private javax.swing.JButton BtnReportes1;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JList jList1;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPopupMenu jPopupMenu1;
	    private javax.swing.JScrollPane jScrollPane1;
	    // End of variables declaration//GEN-END:variables
	}

