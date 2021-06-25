
package protest2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Uttam
 */
public class DialogHomeToEasy extends javax.swing.JDialog {
    public DialogHomeToEasy(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getRootPane().setOpaque(false);
        dispose();
        setUndecorated(true);
        timerCall();
    }
    
    Home homeRef;
    public DialogHomeToEasy(java.awt.Frame parent,Home ref, boolean modal) {
        super(parent, modal);
        dispose();
        setUndecorated(true);
        initComponents();
        homeRef=ref;
        timerCall();   
    }
    
    static Timer time;
    int t;
    EasyGame eg;
    public void timerCall(){
        t=5;
        time = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(t>0){
                t--;
                if(t==0){
                    timeText.setText("GO");
                    eg=new EasyGame(homeRef);
                }
                else
                    timeText.setText(""+t);
            }else{
                
                ((Timer) (e.getSource())).stop(); 
                dispose();
                eg.show(); 
               
            }
        }
    });
    
    time.setInitialDelay(300);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        timeText.setText("5");
        getContentPane().add(timeText);
        timeText.setBounds(150, 120, 120, 80);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Starts in...");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 130, 100, 60);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Help: Each wrong guess bursts one balloon.");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 80, 410, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Task: Save the panda from the fire dragon.");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 50, 410, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Level: Easy");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 0, 140, 60);

        BackImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/A2B.png"))); // NOI18N
        BackImage.setMaximumSize(new java.awt.Dimension(538, 400));
        BackImage.setMinimumSize(new java.awt.Dimension(538, 400));
        BackImage.setPreferredSize(new java.awt.Dimension(538, 400));
        getContentPane().add(BackImage);
        BackImage.setBounds(0, -20, 750, 440);

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
                DialogHomeToEasy dialog = new DialogHomeToEasy(new javax.swing.JFrame(), true);
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
