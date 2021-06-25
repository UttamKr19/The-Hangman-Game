/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protest2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JFrame;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Uttam
 */
public class HowToPlay extends javax.swing.JFrame {

    /**
     * Creates new form HowToPlay
     */
    Home temp;
    public HowToPlay() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        dispose();
        setUndecorated(true);
    }
    
    public HowToPlay(Home ref) {
        temp=ref;
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        animation.setVisible(false);
        animation.doClick();
        
        dispose();
        setUndecorated(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JButton();
        animation = new javax.swing.JButton();
        HowToPlayText = new javax.swing.JLabel();
        HowToPlayText2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bgImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(null);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backbutt.png"))); // NOI18N
        back.setText("back");
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        back.setFocusPainted(false);
        back.setFocusable(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(1250, 0, 120, 40);

        animation.setText("AnimButt");
        animation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animationActionPerformed(evt);
            }
        });
        getContentPane().add(animation);
        animation.setBounds(320, 570, 90, 23);

        HowToPlayText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/HowToPlayText.png"))); // NOI18N
        HowToPlayText.setMaximumSize(new java.awt.Dimension(560, 130));
        HowToPlayText.setMinimumSize(new java.awt.Dimension(560, 130));
        HowToPlayText.setPreferredSize(new java.awt.Dimension(560, 130));
        getContentPane().add(HowToPlayText);
        HowToPlayText.setBounds(400, -10, 560, 140);

        HowToPlayText2.setBackground(new java.awt.Color(51, 0, 0));
        HowToPlayText2.setFont(new java.awt.Font("Ink Free", 1, 24)); // NOI18N
        HowToPlayText2.setForeground(new java.awt.Color(255, 255, 255));
        HowToPlayText2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/howtoplay2.png"))); // NOI18N
        getContentPane().add(HowToPlayText2);
        HowToPlayText2.setBounds(410, 250, 540, 510);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" has to guess the word within time limit to save the panda from monsters & help him reach home.");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 180, 1070, 80);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("The rules of the game are as simple as the Classic Hangman game's rule.  In each level, the player");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 140, 1110, 80);

        bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/HowToPlayBG.jpg"))); // NOI18N
        getContentPane().add(bgImage);
        bgImage.setBounds(0, -30, 1370, 820);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        menuSound();
        backButton();
    }//GEN-LAST:event_backActionPerformed
    public static void menuSound(){
        
        try{
            String gongFile = "src/sounds/menu.wav";
            InputStream in = new FileInputStream(gongFile);
            AudioStream audioStream = new AudioStream(in);
            AudioPlayer.player.start(audioStream);
            
        }catch(IOException e){
            
        }
        
    }
    void backButton(){
        temp.show();
        this.dispose();
    }
    
    Timer timer;
    
    int xHowToPlay=400;
    int yHowToPlay=-100;
    int wHowToPlay=560;
    int hHowToPlay=130;
    
    private void animationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animationActionPerformed
        // TODO add your handling code here:
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(yHowToPlay<-10){
                    yHowToPlay+=5;
                    HowToPlayText.setBounds(xHowToPlay, yHowToPlay, wHowToPlay, hHowToPlay);
                }
                else {
                    ((Timer) (e.getSource())).stop();
                }
            }
        });

        timer.setInitialDelay(0);
        timer.start();

    }//GEN-LAST:event_animationActionPerformed

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
            java.util.logging.Logger.getLogger(HowToPlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HowToPlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HowToPlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HowToPlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HowToPlay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HowToPlayText;
    private javax.swing.JLabel HowToPlayText2;
    private javax.swing.JButton animation;
    private javax.swing.JButton back;
    private javax.swing.JLabel bgImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
