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
    }
    
    public HowToPlay(Home ref) {
        temp=ref;
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        animation.setVisible(false);
        animation.doClick();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JButton();
        animation = new javax.swing.JButton();
        HowToPlayText = new javax.swing.JLabel();
        HowToPlayText1 = new javax.swing.JLabel();
        HowToPlayText2 = new javax.swing.JLabel();
        HowToPlayText3 = new javax.swing.JLabel();
        HowToPlayText4 = new javax.swing.JLabel();
        HowToPlayText5 = new javax.swing.JLabel();
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
        back.setBounds(-100, 0, 270, 60);

        animation.setText("AnimButt");
        animation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animationActionPerformed(evt);
            }
        });
        getContentPane().add(animation);
        animation.setBounds(510, 130, 90, 23);

        HowToPlayText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/HowToPlayText.png"))); // NOI18N
        getContentPane().add(HowToPlayText);
        HowToPlayText.setBounds(410, 10, 489, 130);

        HowToPlayText1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dragon33.gif"))); // NOI18N
        getContentPane().add(HowToPlayText1);
        HowToPlayText1.setBounds(570, 280, 680, 370);

        HowToPlayText2.setBackground(new java.awt.Color(51, 0, 0));
        HowToPlayText2.setFont(new java.awt.Font("Ink Free", 1, 24)); // NOI18N
        HowToPlayText2.setForeground(new java.awt.Color(255, 255, 255));
        HowToPlayText2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Live6.png"))); // NOI18N
        HowToPlayText2.setText("Number of guesses");
        HowToPlayText2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(HowToPlayText2);
        HowToPlayText2.setBounds(130, 330, 440, 60);

        HowToPlayText3.setBackground(new java.awt.Color(51, 0, 0));
        HowToPlayText3.setFont(new java.awt.Font("Ink Free", 1, 24)); // NOI18N
        HowToPlayText3.setForeground(new java.awt.Color(255, 255, 255));
        HowToPlayText3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/musicMute.png"))); // NOI18N
        HowToPlayText3.setText("                     Play/Mute music");
        HowToPlayText3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(HowToPlayText3);
        HowToPlayText3.setBounds(130, 510, 440, 60);

        HowToPlayText4.setBackground(new java.awt.Color(51, 0, 0));
        HowToPlayText4.setFont(new java.awt.Font("Ink Free", 1, 24)); // NOI18N
        HowToPlayText4.setForeground(new java.awt.Color(255, 255, 255));
        HowToPlayText4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/heart3.png"))); // NOI18N
        HowToPlayText4.setText("           Number of lives left");
        HowToPlayText4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(HowToPlayText4);
        HowToPlayText4.setBounds(130, 390, 440, 60);

        HowToPlayText5.setBackground(new java.awt.Color(51, 0, 0));
        HowToPlayText5.setFont(new java.awt.Font("Ink Free", 1, 24)); // NOI18N
        HowToPlayText5.setForeground(new java.awt.Color(255, 255, 255));
        HowToPlayText5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/change.png"))); // NOI18N
        HowToPlayText5.setText("                     Change the word");
        HowToPlayText5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(HowToPlayText5);
        HowToPlayText5.setBounds(130, 450, 440, 60);

        bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/HowToPlayBG.jpg"))); // NOI18N
        getContentPane().add(bgImage);
        bgImage.setBounds(0, -30, 1370, 794);

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
    int wHowToPlay=500;
    int hHowToPlay=140;
    
    private void animationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animationActionPerformed
        // TODO add your handling code here:
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(yHowToPlay<10){
                    yHowToPlay+=5;
                    HowToPlayText.setBounds(xHowToPlay, yHowToPlay, wHowToPlay, hHowToPlay);
                }
                else {
                    yHowToPlay=-100;
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
    private javax.swing.JLabel HowToPlayText1;
    private javax.swing.JLabel HowToPlayText2;
    private javax.swing.JLabel HowToPlayText3;
    private javax.swing.JLabel HowToPlayText4;
    private javax.swing.JLabel HowToPlayText5;
    private javax.swing.JButton animation;
    private javax.swing.JButton back;
    private javax.swing.JLabel bgImage;
    // End of variables declaration//GEN-END:variables
}
