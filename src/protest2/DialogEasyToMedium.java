
package protest2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Uttam
 */
public class DialogEasyToMedium extends javax.swing.JDialog {
    public DialogEasyToMedium(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        dispose();
        setUndecorated(true);
        timerCall();
    }
    
    Home homeRef;
    EasyGame easyRef;
    int heartLives;
    int scoreTotal;
    public DialogEasyToMedium(java.awt.Frame parent,EasyGame eRef,Home hRef, boolean modal,
            int heart,int score) {
        super(parent, modal);
        dispose();
        setUndecorated(true);
        initComponents();
        homeRef=hRef;
        easyRef=eRef;
        heartLives=heart;
        scoreTotal=score;
        timerCall();   
    }
    
    static Timer time;
    int t;
    public void timerCall(){
        t=4;
        time = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(t>0){
                t--;
                if(t==0){
                    timeText.setText("GO");
                }
                else
                    timeText.setText(""+t);
            }else{
                
                ((Timer) (e.getSource())).stop(); 
                dispose();
                new MediumGame(homeRef,easyRef,heartLives,scoreTotal).show();
                
                
            }
        }
    });
    
    time.setInitialDelay(1000);
    time.start();
    }
    
    
    public static void menuSound(){
        
        try{
            String gongFile = "src/sounds/menu.wav";
            InputStream in = new FileInputStream(gongFile);
            AudioStream audioStream = new AudioStream(in);
            AudioPlayer.player.start(audioStream);
            
        }catch(Exception e){
            
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeText = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BackImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(350, 250, 600, 450));
        setLocation(new java.awt.Point(400, 200));
        setMaximumSize(new java.awt.Dimension(538, 400));
        setMinimumSize(new java.awt.Dimension(538, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(538, 400));
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        getContentPane().setLayout(null);

        timeText.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        timeText.setForeground(new java.awt.Color(255, 255, 0));
        timeText.setText("3");
        getContentPane().add(timeText);
        timeText.setBounds(180, 100, 150, 80);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Task: Save the panda from the dark knight.");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 30, 410, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Level: Medium");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 0, 140, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Starts in...");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 110, 100, 60);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Help: Wrong guesses drags panda back a bit.");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 60, 410, 30);

        BackImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/A2B.png"))); // NOI18N
        BackImage.setMaximumSize(new java.awt.Dimension(538, 400));
        BackImage.setMinimumSize(new java.awt.Dimension(538, 400));
        BackImage.setPreferredSize(new java.awt.Dimension(538, 400));
        getContentPane().add(BackImage);
        BackImage.setBounds(0, -20, 570, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog

    }//GEN-LAST:event_closeDialog

        
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogEasyToMedium dialog = new DialogEasyToMedium(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel timeText;
    // End of variables declaration//GEN-END:variables

}
