package com.jzy.game.ai.nav.triangle.ui;

import java.util.ArrayList;

import com.jzy.game.ai.nav.node.TriangleBlock;
import com.jzy.game.engine.math.Vector3;

/**
 * navmesh主界面
 *
 * @author CruiseDing
 */
public class TriangleNavStart extends javax.swing.JFrame {

    /**
     * @param mapWindow the mapWindow to set
     */
    public void setMapWindow(TriangleNavMeshWindow mapWindow) {
        this.mapWindow = mapWindow;
    }

    private TriangleNavMeshWindow mapWindow;

    /**
     * Creates new form Main
     */
    public TriangleNavStart() {
        initComponents();
    }

    public void setPosition(Vector3 pos) {
        position.setText(pos.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        position = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        randomPointButton = new javax.swing.JButton();
        showRandomPointButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        triangleIndexButton = new javax.swing.JButton();
        vectorIndexButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        scaleComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("当前坐标：");

        randomPointButton.setText("随机坐标");
        randomPointButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomPointButtonActionPerformed(evt);
            }
        });

        showRandomPointButton.setText("显示随机点");
        showRandomPointButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRandomPointButtonActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("R键：重置坐标\nP键：暂停\n\n");
        jScrollPane1.setViewportView(jTextArea1);

        triangleIndexButton.setText("三角形序号");
        triangleIndexButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triangleIndexButtonActionPerformed(evt);
            }
        });

        vectorIndexButton.setText("坐标序号");
        vectorIndexButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vectorIndexButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("缩放倍数：");

        scaleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "15", "20", "25", "30" }));
        scaleComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                scaleComboBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(randomPointButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(showRandomPointButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(triangleIndexButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(vectorIndexButton)
                            .addGap(19, 19, 19))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scaleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(randomPointButton)
                    .addComponent(showRandomPointButton)
                    .addComponent(triangleIndexButton)
                    .addComponent(vectorIndexButton))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(scaleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void randomPointButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomPointButtonActionPerformed
        mapWindow.randMove();
    }//GEN-LAST:event_randomPointButtonActionPerformed

    static TriangleBlock addPolygons = null;

    private void showRandomPointButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRandomPointButtonActionPerformed
        mapWindow.triangleViewPane.changeShowRandomPoint();
    }//GEN-LAST:event_showRandomPointButtonActionPerformed

    private void triangleIndexButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triangleIndexButtonActionPerformed
        // 显示隐藏三角形序号
        this.mapWindow.triangleViewPane.changeShowTriangleIndex();
    }//GEN-LAST:event_triangleIndexButtonActionPerformed

    private void vectorIndexButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vectorIndexButtonActionPerformed
        this.mapWindow.triangleViewPane.changeShowVectorIndex();
    }//GEN-LAST:event_vectorIndexButtonActionPerformed

    private void scaleComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_scaleComboBoxItemStateChanged
          if (this.mapWindow == null) {
            return;
        }
        this.mapWindow.loadMap(TriangleNavMeshWindow.lastFilePath, Integer.parseInt(scaleComboBox.getSelectedItem().toString()));
    }//GEN-LAST:event_scaleComboBoxItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(TriangleNavStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TriangleNavStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TriangleNavStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TriangleNavStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TriangleNavStart main = new TriangleNavStart();
                main.setVisible(true);
                TriangleNavMeshWindow map = new TriangleNavMeshWindow(main);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField position;
    private javax.swing.JButton randomPointButton;
    private javax.swing.JComboBox<String> scaleComboBox;
    private javax.swing.JButton showRandomPointButton;
    private javax.swing.JButton triangleIndexButton;
    private javax.swing.JButton vectorIndexButton;
    // End of variables declaration//GEN-END:variables
}
