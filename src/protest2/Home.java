package protest2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JFrame;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        playBGMusic();
        animation.setVisible(false);
        flare.setVisible(false);
        FlareBlue1.setVisible(false);
        animation.doClick();
    }
    
    public static boolean bgPlay=false;
    public static AudioStream audioStream;
    public static String gongFile = "src/sounds/bgMusic.wav";
    static void playBGMusic(){
        try{
            
            InputStream in = new FileInputStream(gongFile);
            audioStream = new AudioStream(in);
            if(!bgPlay){
                AudioPlayer.player.start(audioStream);
                bgPlay=true;
            }
            //System.out.println(AudioPlayer.player.isAlive());
        }catch(Exception e){
            System.out.println(e);
            
        }
    }
    
    public static void alphabetSound(){
        
        try{
            String gongFile = "src/sounds/alphabet.wav";
            InputStream in = new FileInputStream(gongFile);
            AudioStream audioStream = new AudioStream(in);
            AudioPlayer.player.start(audioStream);
            
        }catch(Exception e){
            //System.out.println(e);
            
        }
        
    }
    public static void menuSound(){
        
        try{
            String gongFile = "src/sounds/menu.wav";
            InputStream in = new FileInputStream(gongFile);
            AudioStream audioStream = new AudioStream(in);
            AudioPlayer.player.start(audioStream);
            
        }catch(Exception e){
            //System.out.println(e);
            
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dashboardDragon = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();
        PlayWorking = new javax.swing.JPanel();
        CreditsWorking = new javax.swing.JPanel();
        QuitWorking = new javax.swing.JPanel();
        HowToPlayWorking = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        skeleton = new javax.swing.JLabel();
        fire4 = new javax.swing.JLabel();
        fire1 = new javax.swing.JLabel();
        animation = new javax.swing.JButton();
        flare = new javax.swing.JLabel();
        FlareBlue1 = new javax.swing.JLabel();
        fire2 = new javax.swing.JLabel();
        fire3 = new javax.swing.JLabel();
        BackImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setLocation(new java.awt.Point(200, 50));
        setMinimumSize(new java.awt.Dimension(1366, 750));
        setResizable(false);
        getContentPane().setLayout(null);

        dashboardDragon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bat_animation.gif"))); // NOI18N
        getContentPane().add(dashboardDragon);
        dashboardDragon.setBounds(360, 180, 390, 320);

        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dash3menu.png"))); // NOI18N
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        getContentPane().add(menu);
        menu.setBounds(510, 330, 330, 440);

        PlayWorking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PlayWorking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayWorkingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                QuitWorkingMouseEntered(evt);
                PlayWorkingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PlayWorkingMouseExited(evt);
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreditsWorkingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CreditsWorkingMouseExited(evt);
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
            public void mouseExited(java.awt.event.MouseEvent evt) {
                QuitWorkingMouseExited(evt);
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HowToPlayWorkingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HowToPlayWorkingMouseExited(evt);
            }
        });
        getContentPane().add(HowToPlayWorking);
        HowToPlayWorking.setBounds(560, 520, 240, 50);

        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/title.png"))); // NOI18N
        title.setText(" ");
        getContentPane().add(title);
        title.setBounds(270, 30, 780, 220);

        skeleton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/birds.gif"))); // NOI18N
        getContentPane().add(skeleton);
        skeleton.setBounds(0, 120, 440, 200);

        fire4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dragon15.gif"))); // NOI18N
        getContentPane().add(fire4);
        fire4.setBounds(1180, 330, 260, 260);

        fire1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fire12.gif"))); // NOI18N
        getContentPane().add(fire1);
        fire1.setBounds(910, 330, 340, 200);

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
        flare.setBounds(518, 98, 660, 160);

        FlareBlue1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FlareBlue2.png"))); // NOI18N
        getContentPane().add(FlareBlue1);
        FlareBlue1.setBounds(290, 260, 680, 800);

        fire2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/littleDragon.gif"))); // NOI18N
        getContentPane().add(fire2);
        fire2.setBounds(30, 10, 160, 250);

        fire3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/panda99.png"))); // NOI18N
        getContentPane().add(fire3);
        fire3.setBounds(800, 110, 220, 260);

        BackImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/homeBack2.jpg"))); // NOI18N
        BackImage.setText("jLabel2");
        getContentPane().add(BackImage);
        BackImage.setBounds(-10, 0, 1390, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QuitWorkingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuitWorkingMouseEntered
        // TODO add your handling code here:
        menu.setIcon(new javax.swing.ImageIcon("src\\Images\\dash3menu_QuitEnter.png"));
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
        menuSound();
        new EasyGame(this).show();
        this.hide();
    }//GEN-LAST:event_PlayWorkingMouseClicked

    private void QuitWorkingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuitWorkingMouseClicked
        // TODO add your handling code here:
        menuSound();
        System.exit(0);
    }//GEN-LAST:event_QuitWorkingMouseClicked

    private void CreditsWorkingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreditsWorkingMouseClicked
        // TODO add your handling code here:
        menuSound();
        new CreditsWindow(this).show();
        this.hide();
    }//GEN-LAST:event_CreditsWorkingMouseClicked
    
    Timer timer;
    
    int xMenu=510;
    int yMenu=600;
    int wMenu=340;
    int hMenu=440;
    
    int yDragon=450;
    
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
                yDragon-=2;
                
                dashboardDragon.setBounds(dashboardDragon.getX(),yDragon,
                        dashboardDragon.getWidth(),dashboardDragon.getHeight());
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
        menuSound();
        new HowToPlay(this).show();
        this.hide();
    }//GEN-LAST:event_HowToPlayWorkingMouseClicked

    private void HowToPlayWorkingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HowToPlayWorkingMouseEntered
        // TODO add your handling code here:
        menu.setIcon(new javax.swing.ImageIcon("src\\Images\\dash3menu_H2PEnter.png"));
    }//GEN-LAST:event_HowToPlayWorkingMouseEntered

    private void CreditsWorkingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreditsWorkingMouseEntered
        // TODO add your handling code here:
        menu.setIcon(new javax.swing.ImageIcon("src\\Images\\dash3menu_creditEnter.png"));
    }//GEN-LAST:event_CreditsWorkingMouseEntered

    private void PlayWorkingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayWorkingMouseEntered
        // TODO add your handling code here:
        menu.setIcon(new javax.swing.ImageIcon("src\\Images\\dash3menu_PlayEnter.png"));
    }//GEN-LAST:event_PlayWorkingMouseEntered

    private void PlayWorkingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayWorkingMouseExited
        // TODO add your handling code here:
        menu.setIcon(new javax.swing.ImageIcon("src\\Images\\dash3menu.png"));
    }//GEN-LAST:event_PlayWorkingMouseExited

    private void HowToPlayWorkingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HowToPlayWorkingMouseExited
        // TODO add your handling code here:
        menu.setIcon(new javax.swing.ImageIcon("src\\Images\\dash3menu.png"));
    }//GEN-LAST:event_HowToPlayWorkingMouseExited

    private void CreditsWorkingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreditsWorkingMouseExited
        // TODO add your handling code here:
        menu.setIcon(new javax.swing.ImageIcon("src\\Images\\dash3menu.png"));
    }//GEN-LAST:event_CreditsWorkingMouseExited

    private void QuitWorkingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuitWorkingMouseExited
        // TODO add your handling code here:
        menu.setIcon(new javax.swing.ImageIcon("src\\Images\\dash3menu.png"));
    }//GEN-LAST:event_QuitWorkingMouseExited

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
    private javax.swing.JLabel dashboardDragon;
    private javax.swing.JLabel fire1;
    private javax.swing.JLabel fire2;
    private javax.swing.JLabel fire3;
    private javax.swing.JLabel fire4;
    private javax.swing.JLabel flare;
    private javax.swing.JLabel menu;
    private javax.swing.JLabel skeleton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
