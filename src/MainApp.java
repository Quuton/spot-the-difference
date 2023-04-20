/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
import Core.Pair;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.formdev.flatlaf.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Font;
import java.io.File;
import java.awt.Dimension;

public class MainApp extends javax.swing.JFrame {
    int tempChoice = 0;
    int found = 0;
    int total = 0;
    int time = 0;
    int imageWidth;
    int windowHeight;
    boolean debug = false;
    int debugX = 0;
    int debugY = 0;
    int intRand = -2;
    ArrayList<Pair> pairList;
    Timer timerCounter = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            increaseTime();
        }
    });

    /**
     * Creates new form MainApp
     */

    public MainApp() {

        initComponents();
        windowHeight = getHeight();
        setResizable(false);
        setupGame();
        updateProgress();
    }

    public void loadImagePack(String path) {
        pairList = new ArrayList<Pair>();
        try {
            Scanner tempScanner = new Scanner(new File(path + "/data.txt"));
            tempScanner.nextLine();
            int loop = (Integer.parseInt(tempScanner.nextLine()));
            for (int i = 0; i < loop; i++) {
                String[] data = tempScanner.nextLine().split(",");
                pairList.add(new Pair(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
            }
            tempScanner.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Some error Occured, Oh no");
            return;
        }

        jLabel1.setIcon(new ImageIcon(path + "/a.png"));
        jLabel2.setIcon(new ImageIcon(path + "/b.png"));

    }

    public ArrayList<String> getImagePackTitles() {
        File file = new File("src/ImagePacks");
        String[] tempDirs = file.list();
        ArrayList<String> imageTitles = new ArrayList<String>();
        for (String dirStr : tempDirs) {
            try {
                Scanner tempScanner = new Scanner(new File("src/ImagePacks/" + dirStr + "/data.txt"));
                imageTitles.add(tempScanner.nextLine());
                tempScanner.close();
            } catch (Exception e) {
            }

        }
        return imageTitles;
    }

    public void setupGame() {
        resetTime();
        int intTemp = -1;
        timerCounter.start();
        Random rand = new Random();
        do {
            intTemp = rand.nextInt(getImagePackTitles().size());
        } while (intTemp == intRand);
        intRand = intTemp;

        loadImagePack("src/ImagePacks/" + Integer.toString(intRand));
        setSize(jLabel1.getIcon().getIconWidth() * 2, windowHeight + jLabel1.getIcon().getIconHeight());
        imageWidth = jLabel1.getIcon().getIconWidth();
        found = 0;
        total = pairList.size();

        updateProgress();
        repaint();
    }

    public void setupGame(int num) {
        resetTime();
        timerCounter.start();
        loadImagePack("src/ImagePacks/" + Integer.toString(num));
        setSize(jLabel1.getIcon().getIconWidth() * 2, windowHeight + jLabel1.getIcon().getIconHeight());
        imageWidth = jLabel1.getIcon().getIconWidth();
        found = 0;
        total = pairList.size();

        updateProgress();
        repaint();
    }

    public void resetTime() {
        timerCounter.restart();
        timerCounter.stop();
        time = 0;
        jLabel4.setText(String.format("Time: %s", time));
    }

    public void results() {
        timerCounter.restart();
        timerCounter.stop();
        JPanel tempPanel = new JPanel();
        tempPanel.setLayout(new GridLayout(1, 2));
        tempPanel.add(new JLabel(String.format("You found all differences at %s seconds", time)));

        JPanel tempPanelRight = new JPanel();
        JLabel tempLabel = new JLabel("Rank:");

        JLabel tempRank;
        if (time <= 30) {
            tempRank = new JLabel(" P", JLabel.CENTER);
            tempRank.setForeground(Color.white);
        } else if (time <= 40) {
            tempRank = new JLabel(" S", JLabel.CENTER);
            tempRank.setForeground(Color.red);
        } else if (time <= 60) {
            tempRank = new JLabel(" A", JLabel.CENTER);
            tempRank.setForeground(Color.orange);
        } else if (time <= 90) {
            tempRank = new JLabel(" B", JLabel.CENTER);
            tempRank.setForeground(Color.yellow);
        } else if (time <= 120) {
            tempRank = new JLabel(" C", JLabel.CENTER);
            tempRank.setForeground(Color.green);
        } else {
            tempRank = new JLabel(" D", JLabel.CENTER);
            tempRank.setForeground(Color.BLUE);
        }
        tempRank.setFont(new Font("Yu Gothic Semibold", Font.BOLD, 52));

        tempPanelRight.add(tempLabel);
        tempPanelRight.add(tempRank);
        tempPanel.add(tempPanelRight);

        JOptionPane.showMessageDialog(null, tempPanel, "Results", JOptionPane.PLAIN_MESSAGE);
        time = 0;
        setupGame();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spot The Diffrence Game");
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel1MouseMoved(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, java.awt.BorderLayout.WEST);
        getContentPane().add(jLabel2, java.awt.BorderLayout.EAST);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jProgressBar1.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar1.setForeground(new java.awt.Color(0, 204, 51));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("0/0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jProgressBar1.getAccessibleContext().setAccessibleName("");

        jPanel1.add(jPanel2);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Time:");
        jLabel4.setToolTipText("");
        jPanel3.add(jLabel4);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jMenu1.setText("Game");

        jMenuItem4.setText("Change Picture");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Skip");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem3.setText("Debug Mode");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");

        jMenuItem1.setText("How to play");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("About");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Exit");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        System.exit(1);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel1MouseClicked
        boolean penalty = false;
        for (Pair pair : pairList) {
            if (evt.getX() >= pair.getXPos() && evt.getX() <= pair.getXEnd() && evt.getY() >= pair.getYPos()
                    && evt.getY() <= pair.getYEnd()) {
                if (!pair.isFound()) {

                    pair.setFound(true);

                    if (found < total) {
                        found++;
                        updateProgress();
                        repaint();
                    }

                    if (found == total) {
                        results();
                        break;
                    }
                }
                penalty = false;
                break;
            } else {
                penalty = true;
            }
        }
        if (penalty) {
            increaseTime();
        }

    }// GEN-LAST:event_jLabel1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem1ActionPerformed
        JOptionPane.showMessageDialog(null,
                "How to Play:\nFind differences between the left and right picture\nUse the mouse to click on the left image with differences\nEach missed click penalizes one second to your time\nThe faster you find the differences, the better rank you get",
                "About", JOptionPane.INFORMATION_MESSAGE);
    }// GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem3ActionPerformed
        debug = !debug;
        if (debug) {
            setTitle("Spot The Difference Game (Debug Mode On)");
        } else {
            setTitle("Spot The Difference Game");

            updateProgress();
        }
        repaint();
    }// GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem2ActionPerformed
        JOptionPane.showMessageDialog(null, "Spot The Difference App\nMade by David, Mark, Miguel\nVersion: V 1.0.0",
                "About", JOptionPane.INFORMATION_MESSAGE);
    }// GEN-LAST:event_jMenuItem2ActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_formMouseMoved
        debugX = evt.getX();
        debugY = evt.getY();

        if (debug) {
            updateProgress();
            repaint();
        }
    }// GEN-LAST:event_formMouseMoved

    private void jLabel1MouseMoved(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel1MouseMoved
        debugX = evt.getX();
        debugY = evt.getY();

        if (debug) {
            updateProgress();
            repaint();
        }
    }// GEN-LAST:event_jLabel1MouseMoved

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem5ActionPerformed
        setupGame();
    }// GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem4ActionPerformed
        JPanel tempPanel = new JPanel();

        JComboBox<String> imageChooser = new JComboBox<String>();
        for (String name : getImagePackTitles()) {
            imageChooser.addItem(name);
        }
        imageChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                tempChoice = imageChooser.getSelectedIndex();
            }
        });
        
        tempPanel.add(imageChooser);
        if (JOptionPane.showOptionDialog(null, tempPanel, "Choose a level", JOptionPane.OK_OPTION,JOptionPane.PLAIN_MESSAGE, null, null, null) == 0) {
            setupGame(tempChoice);
        }
    }// GEN-LAST:event_jMenuItem4ActionPerformed

    public void updateProgress() {
        jProgressBar1.setValue((int) (((float) found / total) * 100));

        if (debug) {
            jLabel3.setText(String.format("Mouse Position: %s, %s", debugX, debugY));
        } else {
            jLabel3.setText(String.format("Found: %s/%s", found, total));
        }
    }

    public void increaseTime() {
        time++;
        jLabel4.setText(String.format("Time: %s", time));
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        super.paint(g);
        for (Pair pair : pairList) {
            if (pair.isFound() || debug) {
                g.drawRect(pair.getXPos() + getInsets().left, pair.getYPos() + 32, pair.getXEnd() - pair.getXPos(),
                        pair.getYEnd() - pair.getYPos());
                g.drawRect(pair.getXPos() + imageWidth - getInsets().left, pair.getYPos() + 32,
                        pair.getXEnd() - pair.getXPos(), pair.getYEnd() - pair.getYPos());
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        try {
            FlatDarkLaf.setup();
        } catch (Exception e){}
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
