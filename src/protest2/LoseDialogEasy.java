
package protest2;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Uttam
 */
public class LoseDialogEasy extends javax.swing.JDialog {
    public LoseDialogEasy(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        dispose();
        setUndecorated(true);
    }
    
    EasyGame easyRef;
    public LoseDialogEasy(java.awt.Frame parent,EasyGame ref, 
            boolean modal,String reason,int heartLives,int score) {
        
        super(parent, modal);
        initComponents();
        easyRef=ref;
        
        if(easyRef.heartLives<=0){
            playAgainButton.setEnabled(false);
        }
        
        if("noChance".equals(reason))
            reason="                                No Guesses Left!!";
        else if("noTime".equals(reason))
            reason="                                Oops!! Time's Up!";
        else
            reason="                                No lives left";
        
        easyRef.revealWord(reason);
        ReasonText.setText(reason);
        ReasonText.setVisible(false);
        
        
        dispose();
        setUndecorated(true);
    }
    
    public static void alphabetSound(){
        
        try{
            String gongFile = "src/sounds/alphabet.wav";
            InputStream in = new FileInputStream(gongFile);
            AudioStream audioStream = new AudioStream(in);
            AudioPlayer.player.start(audioStream);
            
        }catch(IOException e){
            
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

        playAgainButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        ReasonText = new javax.swing.JTextField();
        BackImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(350, 250, 600, 450));
        setLocation(new java.awt.Point(350, 200));
        setMaximumSize(new java.awt.Dimension(720, 410));
        setMinimumSize(new java.awt.Dimension(720, 410));
        setPreferredSize(new java.awt.Dimension(720, 410));
        setResizable(false);
        setSize(new java.awt.Dimension(720, 410));
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        getContentPane().setLayout(null);

        playAgainButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/yesButton.png"))); // NOI18N
        playAgainButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playAgainButton.setFocusable(false);
        playAgainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playAgainButtonActionPerformed(evt);
            }
        });
        getContentPane().add(playAgainButton);
        playAgainButton.setBounds(120, 240, 160, 70);
        getRootPane().setDefaultButton(playAgainButton);

        quitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/noButton.png"))); // NOI18N
        quitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quitButton.setFocusable(false);
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(quitButton);
        quitButton.setBounds(420, 240, 160, 70);

        ReasonText.setEditable(false);
        ReasonText.setBackground(new java.awt.Color(140, 0, 0));
        ReasonText.setFont(new java.awt.Font("Trebuchet MS", 3, 24)); // NOI18N
        ReasonText.setForeground(new java.awt.Color(255, 255, 255));
        ReasonText.setText("                                       Reason");
        ReasonText.setBorder(null);
        ReasonText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReasonTextActionPerformed(evt);
            }
        });
        getContentPane().add(ReasonText);
        ReasonText.setBounds(10, 130, 130, 60);

        BackImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LoseDialog.png"))); // NOI18N
        BackImage.setMaximumSize(new java.awt.Dimension(720, 410));
        BackImage.setMinimumSize(new java.awt.Dimension(720, 410));
        BackImage.setPreferredSize(new java.awt.Dimension(720, 410));
        getContentPane().add(BackImage);
        BackImage.setBounds(0, 0, 720, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playAgainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playAgainButtonActionPerformed
        menuSound();
        this.dispose();
        easyRef.anotherGame();
        
    }//GEN-LAST:event_playAgainButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        menuSound();
        easyRef.backButton();
        easyRef.dispose();
        this.dispose();
        
    }//GEN-LAST:event_quitButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
//        menuSound();
//        doClose(RET_CANCEL);
//        easyRef.backButton();
//        easyRef.dispose();
//        this.dispose();
    }//GEN-LAST:event_closeDialog

    
    private void ReasonTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReasonTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReasonTextActionPerformed
    
    

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
            java.util.logging.Logger.getLogger(LoseDialogEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoseDialogEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoseDialogEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoseDialogEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoseDialogEasy dialog = new LoseDialogEasy(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackImage;
    private javax.swing.JTextField ReasonText;
    private javax.swing.JButton playAgainButton;
    private javax.swing.JButton quitButton;
    // End of variables declaration//GEN-END:variables

}
