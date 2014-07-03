/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author stefano
 */
public class IntroGame extends javax.swing.JFrame {

    ArrayList<String> color = new ArrayList<>();
    ArrayList<String> symbol = new ArrayList<>();
    String checkcolor;
    String oval, wave, heart, hexagon, rectangle, star;
    String player, computer, red, blue, yellow, purple, green;
    String easy = "easy";
    String normal = "normal";
    int players;

    ButtonGroup group = new ButtonGroup();
    ButtonGroup against = new ButtonGroup();

    public IntroGame() {
        initComponents();
        setLocationRelativeTo(null);
        group.add(jRadioEasy);
        group.add(jRadioNormal);
        against.add(jRadioComputer);
        against.add(jRadioPlayer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButtonPlay = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jCheckRed = new javax.swing.JCheckBox();
        jCheckBlue = new javax.swing.JCheckBox();
        jCheckYellow = new javax.swing.JCheckBox();
        jCheckPurple = new javax.swing.JCheckBox();
        jCheckGreen = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCheckOval = new javax.swing.JCheckBox();
        jCheckWave = new javax.swing.JCheckBox();
        jCheckRectangle = new javax.swing.JCheckBox();
        jCheckHeart = new javax.swing.JCheckBox();
        jCheckHexagon = new javax.swing.JCheckBox();
        jCheckStar = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboPlayers = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jRadioEasy = new javax.swing.JRadioButton();
        jRadioNormal = new javax.swing.JRadioButton();
        jRadioPlayer = new javax.swing.JRadioButton();
        jRadioComputer = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jComboColor = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/stefano/Dropbox/Lerngruppe/Java/SET_logo.png")); // NOI18N

        jButtonPlay.setText("Play");
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });

        jLabel2.setText("Choose the color:");

        jCheckRed.setText("Red");
        jCheckRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckRedActionPerformed(evt);
            }
        });

        jCheckBlue.setText("Blue");

        jCheckYellow.setText("Yellow");

        jCheckPurple.setText("Purple");

        jCheckGreen.setText("Green");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel3.setText("(Please Choose 3 Colors)");

        jLabel4.setText("Choose the symbols:");

        jCheckOval.setText("Oval");
        jCheckOval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckOvalActionPerformed(evt);
            }
        });

        jCheckWave.setText("Wave");

        jCheckRectangle.setText("Rectangle");

        jCheckHeart.setText("Heart");

        jCheckHexagon.setText("Hexagon");

        jCheckStar.setText("Star");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel5.setText("(Please Choose 3 Symbols)");

        jLabel6.setText("Choose the difficulty: ");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel7.setText("(Please Choose one difficulty)");

        jComboPlayers.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4" }));

        jLabel8.setText("Number of Players:");

        jRadioEasy.setText("Easy");

        jRadioNormal.setText("Normal");

        jRadioPlayer.setText("Player vs. Player");

        jRadioComputer.setText("Against computer");

        jLabel9.setText("or");

        jComboColor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Color", "Red", "Blue", "Yellow", "Purple", "Green" }));

        jLabel10.setText("Choose one:");

        jLabel11.setText("or");

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel12.setText("(For an easier game)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jRadioEasy)
                                    .addComponent(jRadioNormal)
                                    .addComponent(jRadioComputer)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jRadioPlayer)
                                .addGap(242, 242, 242))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckHexagon)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckStar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckRectangle)
                                    .addComponent(jCheckOval))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckWave)
                                    .addComponent(jCheckHeart)))
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckGreen)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckYellow)
                                            .addComponent(jCheckRed))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckPurple)
                                            .addComponent(jCheckBlue)))
                                    .addComponent(jLabel3)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11))
                                .addGap(56, 56, 56)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12))
                        .addGap(178, 178, 178)))
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGap(368, 368, 368)
                .addComponent(jButtonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1)
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioPlayer)
                                    .addComponent(jRadioComputer)
                                    .addComponent(jLabel9))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckOval)
                            .addComponent(jCheckWave)
                            .addComponent(jLabel8)
                            .addComponent(jComboPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckRectangle)
                            .addComponent(jCheckHeart)
                            .addComponent(jRadioEasy))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckHexagon)
                            .addComponent(jCheckStar)
                            .addComponent(jRadioNormal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckRed)
                            .addComponent(jCheckBlue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckYellow)
                            .addComponent(jCheckPurple))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckGreen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(35, 35, 35)
                .addComponent(jButtonPlay)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public int getPlayer(String number) {
        switch (number) {
            case "2":
                return 2;
            case "3":
                return 3;
            default:
                return 4;
        }

    }
    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed

        // Farben
        if (color.size() == 0) {
            if (jCheckRed.isSelected()) {
                red = jCheckRed.getText();
                color.add(red);
            }
            if (jCheckBlue.isSelected()) {
                blue = jCheckBlue.getText();
                color.add(blue);
            }
            if (jCheckYellow.isSelected()) {
                yellow = jCheckYellow.getText();
                color.add(yellow);
            }
            if (jCheckPurple.isSelected()) {
                purple = jCheckPurple.getText();
                color.add(purple);
            }
            if (jCheckGreen.isSelected()) {
                green = jCheckGreen.getText();
                color.add(green);
            }
        }
        // Symbole
        if (symbol.size() == 0) {
            if (jCheckOval.isSelected()) {
                oval = jCheckOval.getText();
                symbol.add(oval);
            }
            if (jCheckWave.isSelected()) {
                wave = jCheckWave.getText();
                symbol.add(wave);
            }
            if (jCheckHeart.isSelected()) {
                heart = jCheckHeart.getText();
                symbol.add(heart);
            }
            if (jCheckHexagon.isSelected()) {
                hexagon = jCheckHexagon.getText();
                symbol.add(hexagon);
            }
            if (jCheckStar.isSelected()) {
                star = jCheckStar.getText();
                symbol.add(star);
            }
            if (jCheckRectangle.isSelected()) {
                rectangle = jCheckRectangle.getText();
                symbol.add(rectangle);
            }
        }
        if (jComboColor.getSelectedIndex() > 0) {
            checkcolor = (String) jComboColor.getSelectedItem();
            color.clear();
            color.add(checkcolor);
            System.out.println("color:"+color.size()+","+color.toString());
        }else if (color.size() != 3) {
            JOptionPane.showMessageDialog(null, "Please choose 3 colors.");
            color.clear();
        }
        if (symbol.size() != 3) {
            JOptionPane.showMessageDialog(null, "Please choose 3 kinds of symbols.");
            System.out.println("size symbol" + symbol.size());
            symbol.clear();
            System.out.println("after clear" + symbol);
        }

        
        // Farbe für einfaches Spiel
        
        if (!(jRadioPlayer.isSelected()) && !(jRadioComputer.isSelected())) {
            JOptionPane.showMessageDialog(null, "Please Select vs. player or computer");

        } else {
            // Player vs. Player oder Computer
            if (jRadioPlayer.isSelected()) {
                player = jRadioPlayer.getText();
                players = getPlayer(player);
                try {
                    new Game(symbol, color,players);
                } catch (InterruptedException ex) {
                    Logger.getLogger(IntroGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (!(jRadioEasy.isSelected()) && !(jRadioNormal.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Please choose a difficulty");
                      
                } else {
                    if(jRadioEasy.isSelected()){
                    new Game(symbol,color,easy);
                    }else{
                    new Game(symbol,color, normal);
                    }
                    
                    

                }

            }

        }
        System.out.println("symbol :" + symbol.size() + ", color" + color.size());
    }//GEN-LAST:event_jButtonPlayActionPerformed

    private void jCheckRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckRedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckRedActionPerformed

    private void jCheckOvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckOvalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckOvalActionPerformed

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
            java.util.logging.Logger.getLogger(IntroGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntroGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntroGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntroGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntroGame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JCheckBox jCheckBlue;
    private javax.swing.JCheckBox jCheckGreen;
    private javax.swing.JCheckBox jCheckHeart;
    private javax.swing.JCheckBox jCheckHexagon;
    private javax.swing.JCheckBox jCheckOval;
    private javax.swing.JCheckBox jCheckPurple;
    private javax.swing.JCheckBox jCheckRectangle;
    private javax.swing.JCheckBox jCheckRed;
    private javax.swing.JCheckBox jCheckStar;
    private javax.swing.JCheckBox jCheckWave;
    private javax.swing.JCheckBox jCheckYellow;
    private javax.swing.JComboBox jComboColor;
    private javax.swing.JComboBox jComboPlayers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioComputer;
    private javax.swing.JRadioButton jRadioEasy;
    private javax.swing.JRadioButton jRadioNormal;
    private javax.swing.JRadioButton jRadioPlayer;
    // End of variables declaration//GEN-END:variables
}
