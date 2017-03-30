/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import Analisis.ArchivoDot;
import Analisis.Graphik.*;
import Analisis.HaskellArchivo.*;
import Analisis.HaskellTerminal.*;
import Analisis.MemoriaHaskell;
import Analisis.Recorrido;
import Analisis.RecorridoHT;
import Analisis.SemanticoGraphik;
import Reportes.HTML;
import Reportes.TablaErrores;
import TablaSimbolos.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jenny
 */
public class FormInicio extends javax.swing.JFrame {
    public static String texto_salida="";
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
        bCargarHK = new javax.swing.JButton();
        bCargarGK = new javax.swing.JButton();
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
        tbArchivo.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        tbArchivo.setRows(5);
        tbArchivo.setText("importar Nodo.gk?\nincluir_HK FormCuadraticaPositiva?\nincluir_HK FormCuadraticaNegativa?\nincluir_HK Permutacion?\nincluir_HK FuncionPolinomial1?\n\nALS obj1 : publico {\nvar entero c,b,d?\nvar Nodo a:publico=nuevo Nodo()?\n\tvacio inicio(){\n\ta.nombre = 4?\n\timprimir(llamar FormCuadraticaPositiva())?\n\timprimir(llamar FormCuadraticaNegativa())?\n\tllamar Funcionalidad6()?\n\t}\n\n\tcadena FormCuadraticaPositiva(){\n\ta = (5*2)^2 - 4?\n\tvar entero b = 3?\n\tvar entero c = 8?\n\n\tretornar \"Primer función ejecutada con éxito\"?\n\t}\n\n\tcadena FormCuadraticaNegativa():privado{\n\tvar decimal arreglo[3] = {96, 3, 8}?\n\t\n\tretornar \"Segunda función ejecutada con éxito\"?\n\t}\n\n\tvacio FuncionPolinomial1(entero valor_entrada){\n\tvar entero arreglo[5]?\n\tvar entero i?\n\tPara(i=0: i<5: i++){\n\n\timprimir(\"polinomial: \" + i)?\n\t}\n\t}\n\n\tentero Permutacion_gk(entero n, entero r){\n\tMientras(r>0){\n\tsi(r == n){\n\t\tretornar n?\n\t\t\n\t}\n\timprimir(r)?\n\tr=r - 1?\n\t}\n\t}\n\n\tNodo creacion_nodos(){\n\tvar Nodo nod1 = nuevo Nodo()?\n\tnod1.nombre = \"primero\"?\n\tnod1.numero = 1?\n\tretornar nod1?\n\t}\n}\nALS Nodo : publico{\n\tvar cadena nombre : publico = \"\"?\n\tvar entero numero :publico = 0?\n\tvar bool bandera : publico = verdadero?\n\tvar Nodo2 n=nuevo Nodo2()?\n\tbool cambiar_bandera(){\n\t\tSi(bandera == falso){\n\t\t\tbandera = verdadero?\n\t\t\t}Sino{\n\t\t\tSi(bandera == verdadero){\n\t\t\tbandera = false?\n\t\t\t}\n\t\t}\n\tretornar bandera?\n\t}\n}\nALS Nodo2 : publico{\n\tvar cadena nombre2 : publico = \"\"?\n\tvar entero numero2 :publico = 2?\n\tvar bool bandera2 : publico = falso?\n\tvacio cambiar_bandera(){\n\t\tSi(bandera == falso){\n\t\t\tbandera = verdadero?\n\t\t\t}Sino{\n\t\t\tSi(bandera == verdadero){\n\t\t\tbandera = false?\n\t\t\t}\n\t\t}\n\t}\n}\n");
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

        bCargarHK.setBackground(new java.awt.Color(0, 204, 204));
        bCargarHK.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bCargarHK.setText("Cargar HK");
        bCargarHK.setContentAreaFilled(false);
        bCargarHK.setOpaque(true);
        bCargarHK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCargarHKActionPerformed(evt);
            }
        });
        getContentPane().add(bCargarHK);
        bCargarHK.setBounds(952, 351, 139, 31);

        bCargarGK.setBackground(new java.awt.Color(0, 204, 204));
        bCargarGK.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bCargarGK.setText("Cargar GK");
        bCargarGK.setToolTipText("");
        bCargarGK.setContentAreaFilled(false);
        bCargarGK.setOpaque(true);
        bCargarGK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCargarGKActionPerformed(evt);
            }
        });
        getContentPane().add(bCargarGK);
        bCargarGK.setBounds(950, 410, 140, 31);

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
            texto_salida="";            
            if(texto.equals("")){
                JOptionPane.showMessageDialog(null, "Entrada incorrecta");
            }else{
                tbSalida.append(texto+"\n");
                String entrada=texto.substring(1);
                tbEntrada.setText(">");
                LexicoHT lexico = new LexicoHT(new BufferedReader( new StringReader(entrada)));
                SintacticoHT sintactico= new SintacticoHT(lexico);
                try {
                    sintactico.parse();
                    ArchivoDot.graficar(sintactico.raiz, "ASTHaskellT");
                } catch (Exception ex) {
                    System.out.println("Error "+ex.getMessage());
                }
                if(sintactico.raiz!=null){                    
                    if(TablaErrores.error){                        
                        JOptionPane.showMessageDialog(null,"Verifique errores lexio y sintacticos.");
                        HTML.mostrarErrores();
                    }else{                        
                        Ambito a=new Ambito(-1,0);
                        TSH.lista_ambitos.add(a);
                        RecorridoHT.recorrerArbol(sintactico.raiz);
                    }
                    if(TablaErrores.error){
                        JOptionPane.showMessageDialog(null,"Verifique errores semanticos.");
                        HTML.mostrarErrores();
                    }else{                                                
                        //TS.recorrerListaAmbitos();
                        tbSalida.append(texto_salida+"\n");
                    }
                }
            }
            
        }
    }//GEN-LAST:event_tbEntradaKeyPressed

    private void bCargarHKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCargarHKActionPerformed
        // TODO add your handling code here:
        String entrada=tbArchivo.getText();       
        texto_salida="";
            if(entrada.equals("")){
                JOptionPane.showMessageDialog(null, "Entrada incorrecta");
            }else{                
                LexicoH lexico = new LexicoH(new BufferedReader( new StringReader(entrada)));
                SintacticoH sintactico= new SintacticoH(lexico);
                try {
                    sintactico.parse();
                } catch (Exception ex) {
                    System.out.println("Error "+ex.getMessage());
                }
                if(sintactico.raiz!=null){                    
                    if(TablaErrores.error){                        
                        JOptionPane.showMessageDialog(null,"Verifique errores lexicos y sintacticos.");
                        HTML.mostrarErrores();
                    }
                    if(TablaErrores.error){
                        JOptionPane.showMessageDialog(null,"Verifique errores semanticos.");
                        HTML.mostrarErrores();
                    }else{                                                
                        //TS.recorrerListaAmbitos();                        
                        MemoriaHaskell.raiz.hijos.addAll(sintactico.raiz.hijos);
                        texto_salida+="Archivo Haskell ha sido cargado a memoria.";
                        try {
                            ArchivoDot.graficar(MemoriaHaskell.raiz, "ASTHaskell");
                        } catch (IOException ex) {
                            Logger.getLogger(FormInicio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        tbSalida.append(texto_salida+"\n");
                    }
                }
            }
    }//GEN-LAST:event_bCargarHKActionPerformed

    private void bCargarGKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCargarGKActionPerformed
        // TODO add your handling code here:
        String entrada=tbArchivo.getText();           
        texto_salida="";
            if(entrada.equals("")){
                JOptionPane.showMessageDialog(null, "Entrada incorrecta");
            }else{                
                LexicoG lexico = new LexicoG(new BufferedReader( new StringReader(entrada)));
                SintacticoG sintactico= new SintacticoG(lexico);
                try {
                    sintactico.parse();                    
                    ArchivoDot.graficar(sintactico.raiz, "ASTGraphik");
                } catch (Exception ex) {
                    System.out.println("Error "+ex.getMessage());
                }
                if(sintactico.raiz!=null){                    
                    if(TablaErrores.error){                        
                        JOptionPane.showMessageDialog(null,"Verifique errores lexicos y sintacticos.");
                        HTML.mostrarErrores();
                    }else{                        
                        Recorrido.recorrerArbol(sintactico.raiz);
                    }
                    if(TablaErrores.error){
                        JOptionPane.showMessageDialog(null,"Verifique errores semanticos.");
                        HTML.mostrarErrores();
                    }else{                                                
                        TS.recorrerListaAmbitos();
                        tbSalida.setText(texto_salida);
                    }
                }
            }
    }//GEN-LAST:event_bCargarGKActionPerformed

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
    private javax.swing.JButton bCargarGK;
    private javax.swing.JButton bCargarHK;
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
