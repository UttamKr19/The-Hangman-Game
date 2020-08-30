
package protest2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Uttam
 */
public class LoseDialogMedium extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    /**
     * Creates new form LoseDialog
     */
    
    public LoseDialogMedium(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        initComponents();
        
        

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }
    
    
    MediumGame mediumRef;
    public LoseDialogMedium(java.awt.Frame parent,MediumGame ref, 
            boolean modal,String reason,int heartLives,int score) {
        
        super(parent, modal);
        initComponents();
        mediumRef=ref;
//        tButt.setVisible(false);
//        tButt.doClick();

        if(mediumRef.heartLives<=0){
            playAgainButton.setEnabled(false);
        }
        
        if("noChance".equals(reason))
            reason="                                No Guesses Left!!";
        else if("noTime".equals(reason))
            reason="                                Oops!! Time's Up!";
        else
            reason="                                No lives left";
        
        mediumRef.revealWord(reason);
        ReasonText.setText(reason);
        
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playAgainButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        ReasonText = new javax.swing.JTextField();
        pandaCry = new javax.swing.JLabel();
        BackImage = new javax.swing.JLabel();

        setBounds(new java.awt.Rectangle(350, 250, 600, 450));
        setLocation(new java.awt.Point(350, 200));
        setMinimumSize(new java.awt.Dimension(640, 430));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        getContentPane().setLayout(null);

        playAgainButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LosePlayAgain.png"))); // NOI18N
        playAgainButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playAgainButton.setFocusable(false);
        playAgainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playAgainButtonActionPerformed(evt);
            }
        });
        getContentPane().add(playAgainButton);
        playAgainButton.setBounds(20, 300, 160, 70);
        getRootPane().setDefaultButton(playAgainButton);

        quitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LoseQuit.png"))); // NOI18N
        quitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quitButton.setFocusable(false);
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(quitButton);
        quitButton.setBounds(470, 300, 160, 70);

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
        ReasonText.setBounds(0, 160, 650, 60);

        pandaCry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sad (2).gif"))); // NOI18N
        getContentPane().add(pandaCry);
        pandaCry.setBounds(160, 80, 330, 400);

        BackImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LoseDialog.png"))); // NOI18N
        BackImage.setMaximumSize(new java.awt.Dimension(700, 450));
        BackImage.setMinimumSize(new java.awt.Dimension(700, 450));
        getContentPane().add(BackImage);
        BackImage.setBounds(0, 0, 652, 401);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playAgainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playAgainButtonActionPerformed
        menuSound();
        if(mediumRef.heartLives==0){
            playAgainButton.setEnabled(false);
        }
        else{
            doClose(RET_OK);
            mediumRef.anotherGame();
        }
        
    }//GEN-LAST:event_playAgainButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        menuSound();
        doClose(RET_CANCEL);
        mediumRef.backButton();
        mediumRef.dispose();
        this.dispose();
        
    }//GEN-LAST:event_quitButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        menuSound();
        doClose(RET_CANCEL);
        mediumRef.backButton();
        mediumRef.dispose();
        this.dispose();
    }//GEN-LAST:event_closeDialog

    Timer timer;
    int xSoul=180;
    int ySoul=230;
    int wSoul=280;
    int hSoul=160;
    
    private void ReasonTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReasonTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReasonTextActionPerformed
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

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
            java.util.logging.Logger.getLogger(LoseDialogMedium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoseDialogMedium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoseDialogMedium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoseDialogMedium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoseDialogMedium dialog = new LoseDialogMedium(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel pandaCry;
    private javax.swing.JButton playAgainButton;
    private javax.swing.JButton quitButton;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
}
