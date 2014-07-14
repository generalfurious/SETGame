package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class IntroGame extends javax.swing.JFrame {

    //f
    String a = null;
    ArrayList<String> color = new ArrayList<>();
    ArrayList<String> symbol = new ArrayList<>();
    String checkcolor;
    String oval, wave, heart, hexagon, rectangle, star;
    String computer, red, blue, yellow, purple, green;
    String easy = "easy";
    String normal = "normal";
    int players, player;

    JFileChooser fileChooser = null;
    
    //Menubar reference variables declaration
    JMenuBar menuBar = null;
    JMenu menuFile = null;

    //Submenu reference variable declaration
    JMenuItem menuItemFileLoad = null;
    JMenuItem menuItemFileSave = null;
    JMenuItem menuItemFileExit = null;
    
    
    
    ButtonGroup group = new ButtonGroup();
    ButtonGroup against = new ButtonGroup();

    public IntroGame() {
        initComponents();
        setLocationRelativeTo(null);
        group.add(jRadioEasy);
        group.add(jRadioNormal);
        against.add(jRadioComputer);
        against.add(jRadioPlayer);
        jLabelBild.setIcon(new ImageIcon("src/main/SET_logo.png"));
        jRadioPlayer.setSelected(true);
        
        ///MenÃ¼leiste
        menuBar = new JMenuBar();
        //HinzufÃ¼gen von MenÃ¼s
        menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);

        menuBar.add(menuFile);

        //Add menu entries into in FileMenu
        menuItemFileSave = new JMenuItem("Save", KeyEvent.VK_S);
        menuItemFileSave.setEnabled(false);
        menuItemFileLoad = new JMenuItem("Load", KeyEvent.VK_L);
        menuItemFileExit = new JMenuItem("Exit", KeyEvent.VK_E);

        //registry by FileListener
        menuItemFileSave.addActionListener(new MenuBarListener());
        menuItemFileLoad.addActionListener(new MenuBarListener());
        menuItemFileExit.addActionListener(new MenuBarListener());

        menuFile.add(menuItemFileSave);
        menuFile.add(menuItemFileLoad);
        menuFile.add(menuItemFileExit);
        
        this.setJMenuBar(menuBar);
        
        
        
        
        
        
        
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
        jLabelBild = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jRadioEasy)
                            .addComponent(jRadioNormal)))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                                    .addComponent(jLabel12))
                                                .addGap(56, 56, 56)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabelBild, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(108, 108, 108)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(178, 178, 178))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(268, 268, 268)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(35, 35, 35)
                                        .addComponent(jRadioComputer))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jRadioPlayer)
                                        .addGap(210, 210, 210)))))))
                .addGap(21, 21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(313, 313, 313))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabelBild, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jRadioPlayer)
                            .addComponent(jRadioComputer)
                            .addComponent(jLabel9))
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
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButtonPlay)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public int getPlayer(int number) {
        switch (number) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 4;
            default:
                return 0;
        }

    }

    public void colorCheck() {
        if (color.isEmpty()) {
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
    }

    public void symbolCheck() {
        // Symbole
        if (symbol.isEmpty()) {
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
    }

    public void oneColorCheck() {
        symbolCheck();
        if(symbol.size() == 3){
        checkcolor = (String) jComboColor.getSelectedItem();
        color.clear();
        color.add(checkcolor);

        try {
            // Player vs. Player oder Computer
            if (jRadioPlayer.isSelected()) {
                player = jComboPlayers.getSelectedIndex();
                players = getPlayer(player);
                new Game(symbol, color, players);
                // dispose();
            } else {
                if (!(jRadioEasy.isSelected()) && !(jRadioNormal.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Please choose a difficulty");
                } else {

                    if (jRadioEasy.isSelected()) {
                        new Game(symbol, color, easy);
                        dispose();
                    } else {
                        new Game(symbol, color, normal);
                        dispose();

                    }

                }
            }

        } catch (RemoteException | InterruptedException ex) {
            Logger.getLogger(IntroGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(IntroGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
        JOptionPane.showMessageDialog(null, "Please choose 3 colors and 3 symbols or only 1 color.");
        symbol.clear();
        }
    }
    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed

        if (jComboColor.getSelectedIndex() == 0) {
            symbolCheck();
            colorCheck();

            if (color.size() != 3 || symbol.size() != 3) {
                color.clear();
                symbol.clear();
                JOptionPane.showMessageDialog(null, "Please choose 3 colors and 3 symbols or only 1 color.");
            } else {

                try {
                    // Player vs. Player oder Computer
                    if (jRadioPlayer.isSelected()) {
                        player = jComboPlayers.getSelectedIndex();
                        players = getPlayer(player);
                        new Game(symbol, color, players);
                        // dispose();
                    } else {
                        if (!(jRadioEasy.isSelected()) && !(jRadioNormal.isSelected())) {
                            JOptionPane.showMessageDialog(null, "Please choose a difficulty");
                        } else {

                            if (jRadioEasy.isSelected()) {
                                new Game(symbol, color, easy);
                                dispose();
                            } else {
                                new Game(symbol, color, normal);
                                dispose();

                            }

                        }
                    }

                } catch (RemoteException | InterruptedException ex) {
                    Logger.getLogger(IntroGame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(IntroGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
        oneColorCheck();
        }
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
            java.util.logging.Logger.getLogger(IntroGame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntroGame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntroGame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntroGame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntroGame().setVisible(true);

            }
        });
    }

    private class MenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //Listens to Sub-Menu "Save"
            if (e.getSource() == menuItemFileSave) {
                fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
                    try {
                        Game.saveGame(String.valueOf(fileChooser.getSelectedFile()));
                        // save to file
                    } catch (IOException ex) {
                        Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } //Listens to Sub-Menu "Load"
                else if (e.getSource() == menuItemFileLoad) {
                    System.out.println("load");
                    fileChooser = new JFileChooser();
                    if (fileChooser.showOpenDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
                        try {
                            Game.loadGame(String.valueOf(fileChooser.getSelectedFile()));
                            // save to file
                        } catch (IOException | ClassNotFoundException ex) {
                            Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(IntroGame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } //Listens to Sub-Menu "Exit"
                else if (e.getSource() == menuItemFileExit) {
                    System.exit(0);
                } //Listens to Sub-Menu "Help-ShowManual"
            }
        }

        
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
    private javax.swing.JLabel jLabelBild;
    private javax.swing.JRadioButton jRadioComputer;
    private javax.swing.JRadioButton jRadioEasy;
    private javax.swing.JRadioButton jRadioNormal;
    private javax.swing.JRadioButton jRadioPlayer;
    // End of variables declaration//GEN-END:variables
}
