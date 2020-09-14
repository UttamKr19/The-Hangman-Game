package protest2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        animation.setVisible(false);
        flare.setVisible(false);
        FlareBlue1.setVisible(false);
        animation.doClick();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JLabel();
        PlayWorking = new javax.swing.JPanel();
        CreditsWorking = new javax.swing.JPanel();
        QuitWorking = new javax.swing.JPanel();
        HowToPlayWorking = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        animation = new javax.swing.JButton();
        flare = new javax.swing.JLabel();
        FlareBlue1 = new javax.swing.JLabel();
        BackImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setLocation(new java.awt.Point(200, 50));
        setMaximumSize(new java.awt.Dimension(1366, 750));
        setMinimumSize(new java.awt.Dimension(1366, 750));
        setResizable(false);
        getContentPane().setLayout(null);

        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dash3menu.png"))); // NOI18N
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(menu);
        menu.setBounds(510, 330, 360, 440);

        PlayWorking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PlayWorking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayWorkingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                QuitWorkingMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PlayWorkingMousePressed(evt);
            }
        });
        getContentPane().add(PlayWorking);
        PlayWorking.setBounds(560, 430, 240, 60);
        //jPanel4.setVisible(false);

        CreditsWorking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CreditsWorking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreditsWorkingMouseClicked(evt);
            }
        });
        getContentPane().add(CreditsWorking);
        CreditsWorking.setBounds(560, 600, 240, 50);
        //jPanel1.setVisible(false);

        QuitWorking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        QuitWorking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QuitWorkingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                QuitWorkingMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                QuitWorkingMousePressed(evt);
            }
        });
        getContentPane().add(QuitWorking);
        QuitWorking.setBounds(560, 670, 240, 50);

        HowToPlayWorking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HowToPlayWorkingMouseClicked(evt);
            }
        });
        getContentPane().add(HowToPlayWorking);
        HowToPlayWorking.setBounds(560, 520, 240, 50);

        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/title.png"))); // NOI18N
        title.setText(" ");
        getContentPane().add(title);
        title.setBounds(270, 30, 780, 220);

        animation.setText("anim");
        animation.setBorderPainted(false);
        animation.setFocusable(false);
        animation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animationActionPerformed(evt);
            }
        });
        animation.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                animationPropertyChange(evt);
            }
        });
        getContentPane().add(animation);
        animation.setBounds(1230, 720, 130, 30);

        flare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FlareRed.png"))); // NOI18N
        getContentPane().add(flare);
        flare.setBounds(700, 50, 620, 220);

        FlareBlue1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FlareBlue2.png"))); // NOI18N
        getContentPane().add(FlareBlue1);
        FlareBlue1.setBounds(280, 190, 920, 850);

        BackImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/HomeBack.jpg"))); // NOI18N
        BackImage.setText("jLabel2");
        getContentPane().add(BackImage);
        BackImage.setBounds(-10, 0, 1390, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QuitWorkingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuitWorkingMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_QuitWorkingMouseEntered

    private void PlayWorkingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayWorkingMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_PlayWorkingMousePressed

    private void QuitWorkingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuitWorkingMousePressed
        // TODO add your handling code here:
        //System.exit(0);
    }//GEN-LAST:event_QuitWorkingMousePressed

    private void PlayWorkingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayWorkingMouseClicked
        // TODO add your handling code here:
        new ExtremeGame(this).show();
        this.hide();
    }//GEN-LAST:event_PlayWorkingMouseClicked

    private void QuitWorkingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuitWorkingMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_QuitWorkingMouseClicked

    private void CreditsWorkingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreditsWorkingMouseClicked
        // TODO add your handling code here:
        new CreditsWindow(this).show();
        this.hide();
    }//GEN-LAST:event_CreditsWorkingMouseClicked
    
    Timer timer;
    
    int xMenu=510;
    int yMenu=600;
    int wMenu=340;
    int hMenu=440;
    
    int xTitle=270;
    int yTitle=-100;
    int wTitle=780;
    int hTitle=220;
    
    
    
    
    private void animationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animationActionPerformed

        timer = new Timer(5, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
           PlayWorking.setVisible(false);
           HowToPlayWorking.setVisible(false);
           CreditsWorking.setVisible(false);
           QuitWorking.setVisible(false);
           
           
        if(yTitle<30|| yMenu>330){
            if(yTitle<30){
                
                yTitle++;
                title.setBounds(xTitle, yTitle, wTitle, hTitle);
            }
            if(yMenu>300){
                yMenu-=2;
                
                menu.setBounds(xMenu, yMenu, wMenu, hMenu);
            }
            
        }
        
        else {
           yTitle=-100;
           yMenu=750;
           PlayWorking.setVisible(true);
           HowToPlayWorking.setVisible(true);
           CreditsWorking.setVisible(true);
           QuitWorking.setVisible(true);
           flare.setVisible(true);
           FlareBlue1.setVisible(true);
           
          ((Timer) (e.getSource())).stop();
          
          
        }
      }
    });
      
    timer.setInitialDelay(0);
    timer.start();
        
    }//GEN-LAST:event_animationActionPerformed

    private void animationPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_animationPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_animationPropertyChange

    private void HowToPlayWorkingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HowToPlayWorkingMouseClicked
        // TODO add your handling code here:
        new HowToPlay(this).show();
        this.hide();
    }//GEN-LAST:event_HowToPlayWorkingMouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackImage;
    private javax.swing.JPanel CreditsWorking;
    private javax.swing.JLabel FlareBlue1;
    private javax.swing.JPanel HowToPlayWorking;
    private javax.swing.JPanel PlayWorking;
    private javax.swing.JPanel QuitWorking;
    private javax.swing.JButton animation;
    private javax.swing.JLabel flare;
    private javax.swing.JLabel menu;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
