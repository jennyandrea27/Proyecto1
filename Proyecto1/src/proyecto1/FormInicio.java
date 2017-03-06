/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import Analisis.HaskellArchivo.LexicoH;
import Analisis.HaskellArchivo.SintacticoH;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jenny
 */
public class FormInicio extends javax.swing.JFrame {

    /**
     * Creates new form FormInicio
     */
    public FormInicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        tpPestanas = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbArchivo = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSalida = new javax.swing.JTextArea();
        tbEntrada = new javax.swing.JTextField();
        bIniciarSesion = new javax.swing.JButton();
        bPublicar = new javax.swing.JButton();
        bImportar = new javax.swing.JButton();
        bCargar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Haskell++ y GraphiK");
        setBackground(new java.awt.Color(153, 255, 153));
        getContentPane().setLayout(null);

        tpPestanas.setBackground(new java.awt.Color(0, 153, 102));
        tpPestanas.setOpaque(true);

        tbArchivo.setColumns(20);
        tbArchivo.setRows(5);
        tbArchivo.setText("IncrementaSegunN n,Val = \n\tif n<=$Calcular 1$ then\n\t\t$Succ $calcular 1$$\n\telse\n\t\t$Succ $IncrementaSegunN {$Calcular n-1 $,Val}$$\n\tend\nend\n\nConjuntoFuncPolinomial i,x = CASE i\n\t\t1: $Polinomial1 {x}$;\n\t\t2: $Polinomial2 {x}$;\n\t\t3: $Polinomial3 {x}$;\n\tend\nend\n\nPolinomial1 x = $Calcular 3 * x'pot'5 - x 'pot'2 + 7 * x -1$ \n\t\t\t\tend\nPolinomial2 x = $Calcular 5 * x'pot'2 - x + 8 * x 'pot'(-1) -1$ \n\t\t\t\tend\nPolinomial3 x = $Calcular x'pot'4 + x 'pot'2 + (9*3) * x +80$ \n\t\t\t\tend\nPolinomial4 x = $Calcular x'pot'3 + x 'pot'2 - 4 * x -4 $ \n\t\t\t\tend\n\nObtenerModa LIST = $Max LIST$ \n\t\t\t\t   end\n\nObtenerPromedio LIST = \t$Calcular $sum LIST$ / $length LIST$ $\n\t\t\t\t\t    end");
        jScrollPane2.setViewportView(tbArchivo);

        tpPestanas.addTab("tab1", jScrollPane2);

        getContentPane().add(tpPestanas);
        tpPestanas.setBounds(12, 92, 889, 410);

        tbSalida.setBackground(new java.awt.Color(0, 0, 0));
        tbSalida.setColumns(20);
        tbSalida.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        tbSalida.setForeground(new java.awt.Color(255, 255, 255));
        tbSalida.setRows(5);
        tbSalida.setName("tbSalida"); // NOI18N
        jScrollPane1.setViewportView(tbSalida);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(12, 520, 1250, 211);

        tbEntrada.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        tbEntrada.setText("> ");
        tbEntrada.setToolTipText("");
        tbEntrada.setName("tbEntrada"); // NOI18N
        tbEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbEntradaKeyPressed(evt);
            }
        });
        getContentPane().add(tbEntrada);
        tbEntrada.setBounds(12, 749, 1250, 43);

        bIniciarSesion.setBackground(new java.awt.Color(0, 204, 204));
        bIniciarSesion.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bIniciarSesion.setText("Iniciar Sesion");
        bIniciarSesion.setContentAreaFilled(false);
        bIniciarSesion.setOpaque(true);
        getContentPane().add(bIniciarSesion);
        bIniciarSesion.setBounds(952, 92, 139, 31);

        bPublicar.setBackground(new java.awt.Color(0, 204, 204));
        bPublicar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bPublicar.setText("Publicar");
        bPublicar.setContentAreaFilled(false);
        bPublicar.setOpaque(true);
        getContentPane().add(bPublicar);
        bPublicar.setBounds(952, 141, 139, 31);

        bImportar.setBackground(new java.awt.Color(0, 204, 204));
        bImportar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bImportar.setText("Importar");
        bImportar.setContentAreaFilled(false);
        bImportar.setOpaque(true);
        getContentPane().add(bImportar);
        bImportar.setBounds(952, 190, 139, 31);

        bCargar.setBackground(new java.awt.Color(0, 204, 204));
        bCargar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bCargar.setText("Cargar");
        bCargar.setContentAreaFilled(false);
        bCargar.setOpaque(true);
        bCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCargarActionPerformed(evt);
            }
        });
        getContentPane().add(bCargar);
        bCargar.setBounds(952, 351, 139, 31);

        jLabel2.setBackground(new java.awt.Color(204, 255, 204));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1280, 810);

        jMenuBar1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jMenuItem4.setText("Nuevo");
        jMenu1.add(jMenuItem4);

        jMenuItem1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jMenuItem1.setText("Abrir");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jMenuItem2.setText("Guardar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jMenuItem5.setText("Guardar Como");
        jMenu1.add(jMenuItem5);

        jMenuItem6.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jMenuItem6.setText("Cerrar Pestaña");
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Reportes");
        jMenu2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1298, 883));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void tbEntradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbEntradaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String texto=tbEntrada.getText();
            String entrada=texto.substring(1);
            if(entrada.equals("")){
                JOptionPane.showMessageDialog(null, "Entrada incorrecta");
            }else{
                System.out.println(entrada);
                tbEntrada.setText(">");
                try {
                    LexicoH lexico = new LexicoH(new BufferedReader( new StringReader(entrada)));
                    SintacticoH sintactico= new SintacticoH(lexico);
                    sintactico.parse();
                } catch (Exception ex) {
                    System.out.println("Error "+ex.getMessage());
                }
            }
            
        }
    }//GEN-LAST:event_tbEntradaKeyPressed

    private void bCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCargarActionPerformed
        // TODO add your handling code here:
        String entrada=tbArchivo.getText();            
            if(entrada.equals("")){
                JOptionPane.showMessageDialog(null, "Entrada incorrecta");
            }else{                
                try {
                    LexicoH lexico = new LexicoH(new BufferedReader( new StringReader(entrada)));
                    SintacticoH sintactico= new SintacticoH(lexico);
                    sintactico.parse();
                } catch (Exception ex) {
                    System.out.println("Error "+ex.getMessage());
                }
            }
    }//GEN-LAST:event_bCargarActionPerformed

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
            java.util.logging.Logger.getLogger(FormInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCargar;
    private javax.swing.JButton bImportar;
    private javax.swing.JButton bIniciarSesion;
    private javax.swing.JButton bPublicar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea tbArchivo;
    private javax.swing.JTextField tbEntrada;
    private javax.swing.JTextArea tbSalida;
    private javax.swing.JTabbedPane tpPestanas;
    // End of variables declaration//GEN-END:variables
}
