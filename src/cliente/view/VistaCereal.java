/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.view;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JPanel;
import servidor.bitacora.Bitacora;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author rafael
 */
public class VistaCereal extends javax.swing.JFrame {
    
    private final String NOMBRE_CLASE = "VistaCereal";
    private Bitacora bitacora;

    /**
     * Creates new form viewCereal
     */
    public VistaCereal() {
        
        initComponents();
        //this.panelGraficos.setLayout(new GridLayout(1,2));
        this.bitacora = new Bitacora();
        this.bitacora.guardarRegistro("VistaCereal()", NOMBRE_CLASE);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelVotos = new javax.swing.JPanel();
        labelCerealA = new javax.swing.JLabel();
        labelCerealC = new javax.swing.JLabel();
        labelCerealB = new javax.swing.JLabel();
        labelVotosCerealB = new javax.swing.JLabel();
        labelVotosCerealC = new javax.swing.JLabel();
        buttonCerealA = new javax.swing.JButton();
        buttonCerealB = new javax.swing.JButton();
        buttonCerealC = new javax.swing.JButton();
        labelVotosCerealA = new javax.swing.JLabel();
        panelGraficos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cereales");
        setResizable(false);

        labelCerealA.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelCerealA.setText("Corn Flakes");

        labelCerealC.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelCerealC.setText("Zucaritas");

        labelCerealB.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelCerealB.setText("Choco Krispis");

        labelVotosCerealB.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelVotosCerealB.setText("0");

        labelVotosCerealC.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelVotosCerealC.setText("0");

        buttonCerealA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonCerealA.setText("Votar");

        buttonCerealB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonCerealB.setText("Votar");

        buttonCerealC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonCerealC.setText("Votar");

        labelVotosCerealA.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelVotosCerealA.setText("0");

        javax.swing.GroupLayout panelVotosLayout = new javax.swing.GroupLayout(panelVotos);
        panelVotos.setLayout(panelVotosLayout);
        panelVotosLayout.setHorizontalGroup(
            panelVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVotosLayout.createSequentialGroup()
                .addContainerGap(566, Short.MAX_VALUE)
                .addGroup(panelVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCerealB)
                    .addComponent(labelVotosCerealB)
                    .addGroup(panelVotosLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(buttonCerealB)))
                .addGap(561, 561, 561))
            .addGroup(panelVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelVotosLayout.createSequentialGroup()
                    .addGap(132, 132, 132)
                    .addGroup(panelVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelCerealA)
                        .addComponent(labelVotosCerealA)
                        .addGroup(panelVotosLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(buttonCerealA)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 782, Short.MAX_VALUE)
                    .addGroup(panelVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelCerealC)
                        .addComponent(labelVotosCerealC)
                        .addGroup(panelVotosLayout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(buttonCerealC)))
                    .addGap(133, 133, 133)))
        );
        panelVotosLayout.setVerticalGroup(
            panelVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVotosLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(labelCerealB)
                .addGap(18, 18, 18)
                .addComponent(labelVotosCerealB)
                .addGap(27, 27, 27)
                .addComponent(buttonCerealB)
                .addContainerGap())
            .addGroup(panelVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelVotosLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(panelVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelCerealA)
                        .addComponent(labelCerealC))
                    .addGap(18, 18, 18)
                    .addGroup(panelVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelVotosCerealC)
                        .addComponent(labelVotosCerealA))
                    .addGap(27, 27, 27)
                    .addGroup(panelVotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonCerealA)
                        .addComponent(buttonCerealC))
                    .addContainerGap(17, Short.MAX_VALUE)))
        );

        panelGraficos.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelGraficos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelVotos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGraficos, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelVotos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VistaCereal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCereal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCereal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCereal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCereal().setVisible(true);
            }
        });
                
    }
    
    public void actualizarCereales(
            String cerealA, 
            String cerealB, 
            String cerealC,
            int votosCerealA, 
            int votosCerealB, 
            int votosCerealC) {
        
        
        panelGraficos.setVisible(true);
        bitacora.guardarRegistro("actualizarCereales()", NOMBRE_CLASE);
        
        labelCerealA.setText(cerealA);
        labelVotosCerealA.setText(String.valueOf(votosCerealA));
        
        labelCerealB.setText(cerealB);
        labelVotosCerealB.setText(String.valueOf(votosCerealB));
        
        labelCerealC.setText(cerealC);
        labelVotosCerealC.setText(String.valueOf(votosCerealC));
        
    }
    
    public void actualizarVotosA(int votosCerealA) {
        bitacora.guardarRegistro("actualizarVotosA()", NOMBRE_CLASE);
        labelVotosCerealA.setText(String.valueOf(votosCerealA));
    }
    
    public void actualizarVotosB(int votosCerealB) {
        bitacora.guardarRegistro("actualizarVotosB()", NOMBRE_CLASE);
        labelVotosCerealB.setText(String.valueOf(votosCerealB));
    }
    
    public void actualizarVotosC(int votosCerealC) {
        bitacora.guardarRegistro("actualizarVotosC()", NOMBRE_CLASE);
        labelVotosCerealC.setText(String.valueOf(votosCerealC));        
    }

    public JButton getButtonCerealA() {
        bitacora.guardarRegistro("getButtonCerealA()", NOMBRE_CLASE);
        return buttonCerealA;
    }

    public JButton getButtonCerealB() {
        bitacora.guardarRegistro("getButtonCerealB()", NOMBRE_CLASE);
        return buttonCerealB;
    }

    public JButton getButtonCerealC() {
        bitacora.guardarRegistro("getButtonCerealC()", NOMBRE_CLASE);
        return buttonCerealC;
    }

    public JPanel getPanelGraficos() {
        return panelGraficos;
    }

    public void setPanelGraficos(JPanel panelGraficos) {
        this.panelGraficos = panelGraficos;
        
    }
    public void showPanelGraficos(){
        this.panelGraficos.setVisible(true);
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCerealA;
    private javax.swing.JButton buttonCerealB;
    private javax.swing.JButton buttonCerealC;
    private javax.swing.JLabel labelCerealA;
    private javax.swing.JLabel labelCerealB;
    private javax.swing.JLabel labelCerealC;
    private javax.swing.JLabel labelVotosCerealA;
    private javax.swing.JLabel labelVotosCerealB;
    private javax.swing.JLabel labelVotosCerealC;
    private javax.swing.JPanel panelGraficos;
    private javax.swing.JPanel panelVotos;
    // End of variables declaration//GEN-END:variables
}
