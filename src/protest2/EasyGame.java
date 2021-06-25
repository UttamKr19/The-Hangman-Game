package protest2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JFrame;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Uttam
 */
public class EasyGame extends javax.swing.JFrame {

    public static int score=0;
    public static int heartLives=3;
    
    String str[];
    String word,temp;
    char ch[];
    ArrayList<Integer> al=new ArrayList<>();
    HashSet<Integer> hash=new HashSet<>();
    char butt;
    String show;
    String hint;
    int chances;
    EasyGame ref=this;
    
    Home homeRef;
    
    public void setWordsFromFile(){
        String t="";
        String st[];
        int ch;
        try{
           
           FileReader fr=new FileReader("src\\data\\easyWords.txt");
           while ((ch=fr.read())!=-1){
               t=t+(""+(char)ch);
           }
           st=t.split("\r\n");
           str=st;
           
        }catch(IOException e){
            setWords();
        }
    }
    
    public void setWords(){
        
        String tempStr[]={
"abruptly" ,
"absurd" ,
"abyss" ,
"affix" ,
"avenue" ,
"awkward" ,
"axiom" ,

"bagpipes" ,
"bandwagon" ,
"beekeeper" ,
"bikini" ,
"blitz" ,
"blizzard" ,
"boggle" ,
"bookworm" ,
"boxcar" ,
"boxful" ,
"buffalo" ,
"buffoon" ,
"buzzing" ,
"buzzwords" ,

"cockiness" ,
"croquet" ,
"crypt" ,
"cycle" ,

"dizzying" ,
"duplex" ,
"dwarves" ,

"embezzle" ,
"equip" ,
"espionage" ,
"exodus" ,
"faking" ,
"fishhook" ,
"fixable" ,
"flopping" ,
"fluffiness" ,
"frizzled" ,
"fuchsia" ,"funny" ,

"gabby" ,"galaxy" ,"galvanize" ,
"glowworm" ,
"gnarly" ,
"gossip" ,
"grogginess" ,

"haphazard" ,
"hyphen" ,

"iatrogenic" ,
"icebox" ,
"injury" ,
"ivory" ,
"ivy" ,

"jackpot" ,
"jaundice" ,
"jawbreaker" ,
"jazziest" ,
"jazzy" ,
"jelly" ,
"jigsaw" ,
"jinx" ,
"jiujitsu" ,
"jockey" ,
"jogging" ,
"joking" ,
"jovial" ,
"joyful" ,
"juicy" ,
"jukebox" ,
"jumbo" ,


"keyhole" ,
"khaki" ,
"kilobyte" ,
"knapsack" ,

"larynx" ,
"lengths" ,
"lucky" ,
"luxury" ,
"lymph" ,

"matrix" ,
"megahertz" ,
"microwave" ,
"mnemonic" ,
"mystify" ,

"nightclub" ,
"nowadays" ,
"numbskull" ,
"nymph" ,

"ovary" ,
"oxidize" ,
"oxygen" ,

"pajama" ,
"peekaboo" ,
"phlegm" ,
"pixel" ,
"pneumonia" ,
"psyche" ,
"puppy" ,
"puzzling" ,

"quartz" ,
"queue" ,
"quixotic" ,
"quiz" ,
"quizzes" ,

"rhythm" ,
"rickshaw" ,

"squawk" ,
"staff" ,
"strength" ,
"strengths" ,
"stretch" ,
"subway" ,
"syndrome" ,

"thriftless" ,
"thumbscrew" ,
"transcript" ,
"transplant" ,

"unknown" ,
"unworthy" ,
"unzip" ,
"uptown" ,
"vaporize" ,
"vixen" ,
"vodka" ,
"voodoo" ,
"vortex" ,

"wave" ,
"waxy" ,
"wellspring" ,
"wheezy" ,
"whiskey" ,
"whizzing" ,
"whomever" ,
"witchcraft" ,
"wizard" ,
"wristwatch" ,

"xylophone" ,

"yachtsman" ,
"youthful" ,
"yummy" ,

"zigzag" ,
"zigzagging" ,
"zipper" ,
"zodiac" ,
"zombie"
    };
       str=tempStr; 
 }
    
    public EasyGame() {
        initComponents();
        setWordsFromFile();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        dispose();
        setUndecorated(true);
        newGame();
    }
    
    public EasyGame(Home home) {
        homeRef=home;
        initComponents();
        heartLives=3;
        setWordsFromFile();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        dispose();
        setUndecorated(true);
        newGame();
    }
    
    static AudioStream audioStream;
    
    static void playWinLoseSound(){
        try{
            String gongFile = "src/sounds/menu.wav";
            InputStream in = new FileInputStream(gongFile);
            audioStream = new AudioStream(in);
            AudioPlayer.player.start(audioStream);
        }catch(Exception e){
            
        }
    }
    
    public void newGame(){
        timerReset();
        setInitialElements();
    }
    
    public void setInitialElements(){
            BackImage.setIcon(new javax.swing.ImageIcon("src\\Images\\easyBack.jpg"));
            pandaAlive.setIcon(new javax.swing.ImageIcon("src\\Images\\panda60.png"));
            lives.setIcon(new javax.swing.ImageIcon("src\\Images\\live6.png"));
            xPanda=1050;
            yPanda=-350;
            chances=6;
            
            pandaAlive.setBounds(xPanda, yPanda, 230, 730);
            wordspace.setBounds(400,30,490,90);
            dragon4.setBounds(200,-110,500,320);
            fireDragon1.setBounds(750,510,530,270);
            
            ProgressBar.setForeground(Color.green);
            wordspace.setForeground(Color.white);
            clockText.setForeground(Color.WHITE);
            
            pandaAlive.setVisible(true);
            pandaDead.setVisible(false);
            fire1.setVisible(true);
            chancesValue.setVisible(false);
            clockText.setVisible(false);
            timerResetButton.setVisible(false);
            
            switch (heartLives) {
                case 3:
                    heartsRed.setIcon(new javax.swing.ImageIcon("src\\Images\\heart3.png"));
                    break;
                case 2:
                    heartsRed.setIcon(new javax.swing.ImageIcon("src\\Images\\heart2.png"));
                    break;
                case 1:
                    heartsRed.setIcon(new javax.swing.ImageIcon("src\\Images\\heart1.png"));
                    break;
                default:
                    heartsRed.setIcon(new javax.swing.ImageIcon("src\\Images\\heart0.png"));
                    Another.setEnabled(false);
                    break;
            }
                
            
            ProgressBar.setValue(100);
            chancesValue.setText(String.valueOf(chances));
            
            int r=0;
            do{
                r=(int)(Math.random() * (str.length-1));
                
            }while(hash.contains(r));
            
            hash.add(r);
            word= str[r];
            word=word.toUpperCase();
            int len=word.length();
            int compLen=15;
            while(len<compLen){
                wordspace.setBounds(wordspace.getX()+30, wordspace.getY(),
                        wordspace.getWidth(), wordspace.getHeight());
                compLen-=3;
            }
            
            temp="";
            
            temp=temp+word.charAt(0);
            for(int i=0;i<len-2;i++)
                temp=temp+"-";
            temp=temp+word.charAt(word.length()-1);
            ch=temp.toCharArray();
            wordspace.setText(temp);
            show=temp;
            timerResetButton.doClick();
    }
    
    public void changeValue(){
        
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==butt){
                al.add(i);
            }
        }
        if(al.isEmpty())
            chances--;
        else{
            for(int i=0;i<al.size();i++){
                ch[al.get(i)]=butt;
            }   
        }
        
        
        al.clear();
        
        show=new String(ch);
        wordspace.setText(show);
        chancesValue.setText(String.valueOf(chances));
        
        
        switch (chances) {
            case 6:
                pandaAlive.setIcon(new javax.swing.ImageIcon("src\\Images\\panda60.png"));
                lives.setIcon(new javax.swing.ImageIcon("src\\Images\\live6.png"));
                break;
            case 5:
                pandaAlive.setIcon(new javax.swing.ImageIcon("src\\Images\\panda50.png"));
                lives.setIcon(new javax.swing.ImageIcon("src\\Images\\live5.png"));
                ProgressBar.setForeground(Color.yellow);
                break;
            case 4:
                pandaAlive.setIcon(new javax.swing.ImageIcon("src\\Images\\panda40.png"));
                lives.setIcon(new javax.swing.ImageIcon("src\\Images\\live4.png"));
                ProgressBar.setForeground(Color.yellow);
                break;
            case 3:
                pandaAlive.setIcon(new javax.swing.ImageIcon("src\\Images\\panda30.png"));
                lives.setIcon(new javax.swing.ImageIcon("src\\Images\\live3.png"));
                ProgressBar.setForeground(Color.orange);
                break;
            case 2:
                pandaAlive.setIcon(new javax.swing.ImageIcon("src\\Images\\panda20.png"));
                lives.setIcon(new javax.swing.ImageIcon("src\\Images\\live2.png"));
                ProgressBar.setForeground(Color.orange);
                break;
            case 1:
                pandaAlive.setIcon(new javax.swing.ImageIcon("src\\Images\\panda10.png"));
                lives.setIcon(new javax.swing.ImageIcon("src\\Images\\live1.png"));
                ProgressBar.setForeground(Color.red);
                break;
            case 0:
                lives.setIcon(new javax.swing.ImageIcon("src\\Images\\live0.png"));
                break;
            default:
                break;
        }
        
        
        
        if(chances<1 && !word.equals(show)){

            playWinLoseSound();
            ProgressBar.setValue(0);
            pandaDead.setVisible(true);
            pandaAlive.setVisible(false);
            timerReset();
            revealWord("lose");
            loseWindow("noChance");

        }
        else if(word.equals(show)){
            playWinLoseSound();
            revealWord("win");
            pandaAlive.setVisible(false);
            timerReset();
            fire1.setVisible(false);
            BackImage.setIcon(new javax.swing.ImageIcon("src\\Images\\easyBack.jpg"));
            DialogEasyToMedium e2m=new DialogEasyToMedium(this,this,homeRef,true,heartLives,score);
            e2m.show();
            this.dispose();
        }
        
        
    }
    
    public void revealWord(String result){
        wordspace.setText(word);
        
        if("win".equals(result))
            wordspace.setForeground(Color.green);
        if("lose".equals(result))
            wordspace.setForeground(Color.red);
        
    }
    
    public void setAlphabets(){
        D.setBackground(new java.awt.Color(25, 0, 0));
        D.setVisible(true);
        
        M.setBackground(new java.awt.Color(25, 0, 0));
        M.setVisible(true);
        
        V.setBackground(new java.awt.Color(25, 0, 0));
        V.setVisible(true);
        
        A.setBackground(new java.awt.Color(25, 0, 0));
        A.setVisible(true);
        
        J.setBackground(new java.awt.Color(25, 0, 0));
        J.setVisible(true);
        
        S.setBackground(new java.awt.Color(25, 0, 0));
        S.setVisible(true);
        
        U.setBackground(new java.awt.Color(25, 0, 0));
        U.setVisible(true);
        
        L.setBackground(new java.awt.Color(25, 0, 0));
        L.setVisible(true);
        
        C.setBackground(new java.awt.Color(25, 0, 0));
        C.setVisible(true);
        
        B.setBackground(new java.awt.Color(25, 0, 0));
        B.setVisible(true);
        
        K.setBackground(new java.awt.Color(25, 0, 0));
        K.setVisible(true);
        
        T.setBackground(new java.awt.Color(25, 0, 0));
        T.setVisible(true);
        
        X.setBackground(new java.awt.Color(25, 0, 0));
        X.setVisible(true);
        
        O.setBackground(new java.awt.Color(25, 0, 0));
        O.setVisible(true);
        
        F.setBackground(new java.awt.Color(25, 0, 0));
        F.setVisible(true);
        
        G.setBackground(new java.awt.Color(25, 0, 0));
        G.setVisible(true);
        
        E.setBackground(new java.awt.Color(25, 0, 0));
        E.setVisible(true);
        
        N.setBackground(new java.awt.Color(25, 0, 0));
        N.setVisible(true);
        
        W.setBackground(new java.awt.Color(25, 0, 0));
        W.setVisible(true);
        
        P.setBackground(new java.awt.Color(25, 0, 0));
        P.setVisible(true);
        
        Y.setBackground(new java.awt.Color(25, 0, 0));
        Y.setVisible(true);
        
        R.setBackground(new java.awt.Color(25, 0, 0));
        R.setVisible(true);
        
        
        Z.setBackground(new java.awt.Color(25, 0, 0));
        Z.setVisible(true);
        
        Q.setBackground(new java.awt.Color(25, 0, 0));
        Q.setVisible(true);
        
        H.setBackground(new java.awt.Color(25, 0, 0));
        H.setVisible(true);
        
        I.setBackground(new java.awt.Color(25, 0, 0));
        I.setVisible(true);
    }
    
    public void anotherGame(){
        setAlphabets();
        newGame();
    }
    
    public void loseWindow(String reason){
       heartLives--;
       heartsRed.setIcon(new javax.swing.ImageIcon("src\\Images\\heart0.png"));
       new LoseDialogEasy(this,this,true,reason,heartLives,score).show();
    }    
       
    public void backButton(){
        homeRef.show();
        timerReset();
        this.dispose();
    }
   
    public void alphabetSound(){
        
        try{
            String gongFile = "src/sounds/alphabet.wav";
            InputStream in = new FileInputStream(gongFile);
            AudioStream audioStream = new AudioStream(in);
            AudioPlayer.player.start(audioStream);
            
        }catch(IOException e){
            
        }
        
    }
    
    public void menuSound(){
        
        try{
            String gongFile = "src/sounds/menu.wav";
            InputStream in = new FileInputStream(gongFile);
            AudioStream audioStream = new AudioStream(in);
            AudioPlayer.player.start(audioStream);
            
        }catch(IOException e){
            
        }
        
    }
    
    Timer timer2;
    boolean timer2Flag=false;
    public void timerReset(){
        if(timeFlag){
                timer.stop();
                timeFlag=false;
                time=900;
                timeText=time/20;
                clockText.setText(Integer.toString(timeText));
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dragon4 = new javax.swing.JLabel();
        lives = new javax.swing.JLabel();
        chancesValue = new javax.swing.JLabel();
        wordspace = new javax.swing.JLabel();
        Another = new javax.swing.JButton();
        A = new javax.swing.JButton();
        B = new javax.swing.JButton();
        C = new javax.swing.JButton();
        D = new javax.swing.JButton();
        Z = new javax.swing.JButton();
        E = new javax.swing.JButton();
        F = new javax.swing.JButton();
        G = new javax.swing.JButton();
        H = new javax.swing.JButton();
        I = new javax.swing.JButton();
        J = new javax.swing.JButton();
        pandaAlive = new javax.swing.JLabel();
        L = new javax.swing.JButton();
        M = new javax.swing.JButton();
        K = new javax.swing.JButton();
        N = new javax.swing.JButton();
        T = new javax.swing.JButton();
        S = new javax.swing.JButton();
        O = new javax.swing.JButton();
        U = new javax.swing.JButton();
        R = new javax.swing.JButton();
        Q = new javax.swing.JButton();
        P = new javax.swing.JButton();
        V = new javax.swing.JButton();
        clockText = new javax.swing.JLabel();
        W = new javax.swing.JButton();
        X = new javax.swing.JButton();
        Y = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        ProgressBar = new javax.swing.JProgressBar();
        timerResetButton = new javax.swing.JButton();
        fire1 = new javax.swing.JLabel();
        pandaDead = new javax.swing.JLabel();
        fireDragon1 = new javax.swing.JLabel();
        music = new javax.swing.JButton();
        fireDragon2 = new javax.swing.JLabel();
        heartsRed = new javax.swing.JLabel();
        holderWood = new javax.swing.JLabel();
        fireDragon4 = new javax.swing.JLabel();
        fireDragon5 = new javax.swing.JLabel();
        fire2 = new javax.swing.JLabel();
        bird1 = new javax.swing.JLabel();
        boardWooden = new javax.swing.JLabel();
        bird = new javax.swing.JLabel();
        fireDragon6 = new javax.swing.JLabel();
        BackImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        dragon4.setFont(new java.awt.Font("Dialog", 1, 50)); // NOI18N
        dragon4.setForeground(new java.awt.Color(255, 255, 255));
        dragon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dragon17.gif"))); // NOI18N
        getContentPane().add(dragon4);
        dragon4.setBounds(120, 180, 80, 180);

        lives.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lives.setForeground(new java.awt.Color(51, 0, 0));
        lives.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Live6.png"))); // NOI18N
        getContentPane().add(lives);
        lives.setBounds(0, 70, 200, 40);

        chancesValue.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        chancesValue.setForeground(new java.awt.Color(255, 255, 255));
        chancesValue.setText("8");
        getContentPane().add(chancesValue);
        chancesValue.setBounds(970, 30, 20, 50);

        wordspace.setBackground(new java.awt.Color(102, 0, 0));
        wordspace.setFont(new java.awt.Font("Batang", 1, 60)); // NOI18N
        wordspace.setForeground(new java.awt.Color(255, 255, 255));
        wordspace.setText("ABCD");
        wordspace.setName(""); // NOI18N
        getContentPane().add(wordspace);
        wordspace.setBounds(560, 30, 190, 90);

        Another.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/change.png"))); // NOI18N
        Another.setToolTipText("Change Word");
        Another.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Another.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        Another.setFocusPainted(false);
        Another.setFocusable(false);
        Another.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnotherMouseClicked(evt);
            }
        });
        Another.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnotherActionPerformed(evt);
            }
        });
        getContentPane().add(Another);
        Another.setBounds(1320, 50, 40, 40);

        A.setBackground(new java.awt.Color(25, 0, 0));
        A.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        A.setForeground(new java.awt.Color(255, 255, 255));
        A.setText("A");
        A.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        A.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        A.setFocusPainted(false);
        A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AActionPerformed(evt);
            }
        });
        getContentPane().add(A);
        A.setBounds(460, 460, 50, 50);

        B.setBackground(new java.awt.Color(25, 0, 0));
        B.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        B.setForeground(new java.awt.Color(255, 255, 255));
        B.setText("B");
        B.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        B.setFocusPainted(false);
        B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActionPerformed(evt);
            }
        });
        getContentPane().add(B);
        B.setBounds(330, 560, 50, 50);

        C.setBackground(new java.awt.Color(25, 0, 0));
        C.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        C.setForeground(new java.awt.Color(255, 255, 255));
        C.setText("C");
        C.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        C.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        C.setFocusPainted(false);
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CActionPerformed(evt);
            }
        });
        getContentPane().add(C);
        C.setBounds(380, 410, 50, 50);

        D.setBackground(new java.awt.Color(25, 0, 0));
        D.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        D.setForeground(new java.awt.Color(255, 255, 255));
        D.setText("D");
        D.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        D.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        D.setFocusPainted(false);
        D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DActionPerformed(evt);
            }
        });
        getContentPane().add(D);
        D.setBounds(430, 410, 50, 50);

        Z.setBackground(new java.awt.Color(25, 0, 0));
        Z.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        Z.setForeground(new java.awt.Color(255, 255, 255));
        Z.setText("Z");
        Z.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Z.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        Z.setFocusPainted(false);
        Z.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZActionPerformed(evt);
            }
        });
        getContentPane().add(Z);
        Z.setBounds(480, 410, 50, 50);

        E.setBackground(new java.awt.Color(25, 0, 0));
        E.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        E.setForeground(new java.awt.Color(255, 255, 255));
        E.setText("E");
        E.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        E.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        E.setFocusPainted(false);
        E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EActionPerformed(evt);
            }
        });
        getContentPane().add(E);
        E.setBounds(430, 560, 50, 50);

        F.setBackground(new java.awt.Color(25, 0, 0));
        F.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        F.setForeground(new java.awt.Color(255, 255, 255));
        F.setText("F");
        F.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        F.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        F.setFocusPainted(false);
        F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FActionPerformed(evt);
            }
        });
        getContentPane().add(F);
        F.setBounds(260, 460, 50, 50);

        G.setBackground(new java.awt.Color(25, 0, 0));
        G.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        G.setForeground(new java.awt.Color(255, 255, 255));
        G.setText("G");
        G.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        G.setFocusPainted(false);
        G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GActionPerformed(evt);
            }
        });
        getContentPane().add(G);
        G.setBounds(480, 560, 50, 50);

        H.setBackground(new java.awt.Color(25, 0, 0));
        H.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        H.setForeground(new java.awt.Color(255, 255, 255));
        H.setText("H");
        H.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        H.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        H.setFocusPainted(false);
        H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HActionPerformed(evt);
            }
        });
        getContentPane().add(H);
        H.setBounds(180, 560, 50, 50);

        I.setBackground(new java.awt.Color(25, 0, 0));
        I.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        I.setForeground(new java.awt.Color(255, 255, 255));
        I.setText("I");
        I.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        I.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        I.setFocusPainted(false);
        I.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IActionPerformed(evt);
            }
        });
        getContentPane().add(I);
        I.setBounds(360, 510, 50, 50);

        J.setBackground(new java.awt.Color(25, 0, 0));
        J.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        J.setForeground(new java.awt.Color(255, 255, 255));
        J.setText("J");
        J.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        J.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        J.setFocusPainted(false);
        J.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JActionPerformed(evt);
            }
        });
        getContentPane().add(J);
        J.setBounds(180, 410, 50, 50);

        pandaAlive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/panda60.png"))); // NOI18N
        getContentPane().add(pandaAlive);
        pandaAlive.setBounds(820, 150, 110, 170);

        L.setBackground(new java.awt.Color(25, 0, 0));
        L.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        L.setForeground(new java.awt.Color(255, 255, 255));
        L.setText("L");
        L.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        L.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        L.setFocusPainted(false);
        L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LActionPerformed(evt);
            }
        });
        getContentPane().add(L);
        L.setBounds(230, 560, 50, 50);

        M.setBackground(new java.awt.Color(25, 0, 0));
        M.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        M.setForeground(new java.awt.Color(255, 255, 255));
        M.setText("M");
        M.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        M.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        M.setFocusPainted(false);
        M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MActionPerformed(evt);
            }
        });
        getContentPane().add(M);
        M.setBounds(230, 410, 50, 50);

        K.setBackground(new java.awt.Color(25, 0, 0));
        K.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        K.setForeground(new java.awt.Color(255, 255, 255));
        K.setText("K");
        K.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        K.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        K.setFocusPainted(false);
        K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KActionPerformed(evt);
            }
        });
        getContentPane().add(K);
        K.setBounds(410, 460, 50, 50);

        N.setBackground(new java.awt.Color(25, 0, 0));
        N.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        N.setForeground(new java.awt.Color(255, 255, 255));
        N.setText("N");
        N.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        N.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        N.setFocusPainted(false);
        N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NActionPerformed(evt);
            }
        });
        getContentPane().add(N);
        N.setBounds(210, 460, 50, 50);

        T.setBackground(new java.awt.Color(25, 0, 0));
        T.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        T.setForeground(new java.awt.Color(255, 255, 255));
        T.setText("T");
        T.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        T.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        T.setFocusPainted(false);
        T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TActionPerformed(evt);
            }
        });
        getContentPane().add(T);
        T.setBounds(310, 460, 50, 50);

        S.setBackground(new java.awt.Color(25, 0, 0));
        S.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        S.setForeground(new java.awt.Color(255, 255, 255));
        S.setText("S");
        S.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        S.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        S.setFocusPainted(false);
        S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SActionPerformed(evt);
            }
        });
        getContentPane().add(S);
        S.setBounds(380, 560, 50, 50);

        O.setBackground(new java.awt.Color(25, 0, 0));
        O.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        O.setForeground(new java.awt.Color(255, 255, 255));
        O.setText("O");
        O.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        O.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        O.setFocusPainted(false);
        O.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OActionPerformed(evt);
            }
        });
        getContentPane().add(O);
        O.setBounds(280, 560, 50, 50);

        U.setBackground(new java.awt.Color(25, 0, 0));
        U.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        U.setForeground(new java.awt.Color(255, 255, 255));
        U.setText("U");
        U.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        U.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        U.setFocusPainted(false);
        U.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UActionPerformed(evt);
            }
        });
        getContentPane().add(U);
        U.setBounds(310, 510, 50, 50);

        R.setBackground(new java.awt.Color(25, 0, 0));
        R.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        R.setForeground(new java.awt.Color(255, 255, 255));
        R.setText("R");
        R.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        R.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        R.setFocusPainted(false);
        R.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RActionPerformed(evt);
            }
        });
        getContentPane().add(R);
        R.setBounds(330, 410, 50, 50);

        Q.setBackground(new java.awt.Color(25, 0, 0));
        Q.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        Q.setForeground(new java.awt.Color(255, 255, 255));
        Q.setText("Q");
        Q.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Q.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        Q.setFocusPainted(false);
        Q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QActionPerformed(evt);
            }
        });
        getContentPane().add(Q);
        Q.setBounds(260, 510, 50, 50);

        P.setBackground(new java.awt.Color(25, 0, 0));
        P.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        P.setForeground(new java.awt.Color(255, 255, 255));
        P.setText("P");
        P.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        P.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        P.setFocusPainted(false);
        P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PActionPerformed(evt);
            }
        });
        getContentPane().add(P);
        P.setBounds(210, 510, 50, 50);

        V.setBackground(new java.awt.Color(25, 0, 0));
        V.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        V.setForeground(new java.awt.Color(255, 255, 255));
        V.setText("V");
        V.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        V.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        V.setFocusPainted(false);
        V.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VActionPerformed(evt);
            }
        });
        getContentPane().add(V);
        V.setBounds(460, 510, 50, 50);

        clockText.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        clockText.setForeground(new java.awt.Color(255, 255, 255));
        clockText.setText("45");
        getContentPane().add(clockText);
        clockText.setBounds(930, 5, 50, 30);

        W.setBackground(new java.awt.Color(25, 0, 0));
        W.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        W.setForeground(new java.awt.Color(255, 255, 255));
        W.setText("W");
        W.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        W.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        W.setFocusPainted(false);
        W.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WActionPerformed(evt);
            }
        });
        getContentPane().add(W);
        W.setBounds(360, 460, 50, 50);

        X.setBackground(new java.awt.Color(25, 0, 0));
        X.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        X.setForeground(new java.awt.Color(255, 255, 255));
        X.setText("X");
        X.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        X.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        X.setFocusPainted(false);
        X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XActionPerformed(evt);
            }
        });
        getContentPane().add(X);
        X.setBounds(280, 410, 50, 50);

        Y.setBackground(new java.awt.Color(25, 0, 0));
        Y.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        Y.setForeground(new java.awt.Color(255, 255, 255));
        Y.setText("Y");
        Y.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Y.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        Y.setFocusPainted(false);
        Y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YActionPerformed(evt);
            }
        });
        getContentPane().add(Y);
        Y.setBounds(410, 510, 50, 50);

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backbutt.png"))); // NOI18N
        backButton.setText("Back");
        backButton.setBorder(null);
        backButton.setBorderPainted(false);
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        backButton.setFocusPainted(false);
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(1250, 0, 120, 40);

        ProgressBar.setBackground(new java.awt.Color(0, 0, 0));
        ProgressBar.setForeground(new java.awt.Color(0, 255, 0));
        ProgressBar.setValue(20);
        ProgressBar.setBorderPainted(false);
        ProgressBar.setFocusable(false);
        ProgressBar.setPreferredSize(new java.awt.Dimension(417, 22));
        getContentPane().add(ProgressBar);
        ProgressBar.setBounds(0, 50, 200, 15);

        timerResetButton.setText("timerReset");
        timerResetButton.setFocusable(false);
        timerResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerResetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(timerResetButton);
        timerResetButton.setBounds(610, 490, 130, 23);

        fire1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fire.gif"))); // NOI18N
        fire1.setText(" ");
        getContentPane().add(fire1);
        fire1.setBounds(980, 610, 430, 180);

        pandaDead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/panda0.png"))); // NOI18N
        pandaDead.setText(" ");
        getContentPane().add(pandaDead);
        pandaDead.setBounds(1120, 660, 290, 120);

        fireDragon1.setFont(new java.awt.Font("Dialog", 1, 50)); // NOI18N
        fireDragon1.setForeground(new java.awt.Color(255, 255, 255));
        fireDragon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fireDragon.gif"))); // NOI18N
        getContentPane().add(fireDragon1);
        fireDragon1.setBounds(620, 580, 290, 170);

        music.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/musicPlay.png"))); // NOI18N
        music.setToolTipText("Play/Stop Backgroud Music");
        music.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        music.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        music.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                musicMouseClicked(evt);
            }
        });
        music.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musicActionPerformed(evt);
            }
        });
        getContentPane().add(music);
        music.setBounds(1270, 50, 40, 40);

        fireDragon2.setFont(new java.awt.Font("Dialog", 1, 50)); // NOI18N
        fireDragon2.setForeground(new java.awt.Color(255, 255, 255));
        fireDragon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fire10.gif"))); // NOI18N
        getContentPane().add(fireDragon2);
        fireDragon2.setBounds(1082, 482, 120, 70);

        heartsRed.setFont(new java.awt.Font("Dialog", 1, 50)); // NOI18N
        heartsRed.setForeground(new java.awt.Color(255, 255, 255));
        heartsRed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/heart3.png"))); // NOI18N
        getContentPane().add(heartsRed);
        heartsRed.setBounds(0, 0, 120, 50);

        holderWood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/holderE.png"))); // NOI18N
        holderWood.setText(" ");
        getContentPane().add(holderWood);
        holderWood.setBounds(420, -40, 500, 160);

        fireDragon4.setFont(new java.awt.Font("Dialog", 1, 50)); // NOI18N
        fireDragon4.setForeground(new java.awt.Color(255, 255, 255));
        fireDragon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fire11.gif"))); // NOI18N
        getContentPane().add(fireDragon4);
        fireDragon4.setBounds(1290, 440, 90, 60);

        fireDragon5.setFont(new java.awt.Font("Dialog", 1, 50)); // NOI18N
        fireDragon5.setForeground(new java.awt.Color(255, 255, 255));
        fireDragon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fire10.gif"))); // NOI18N
        getContentPane().add(fireDragon5);
        fireDragon5.setBounds(1255, 335, 190, 120);

        fire2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fire.gif"))); // NOI18N
        fire2.setText(" ");
        getContentPane().add(fire2);
        fire2.setBounds(1010, 600, 430, 190);

        bird1.setFont(new java.awt.Font("Dialog", 1, 50)); // NOI18N
        bird1.setForeground(new java.awt.Color(255, 255, 255));
        bird1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/birds.gif"))); // NOI18N
        bird1.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        getContentPane().add(bird1);
        bird1.setBounds(620, 150, 440, 240);

        boardWooden.setFont(new java.awt.Font("Dialog", 1, 50)); // NOI18N
        boardWooden.setForeground(new java.awt.Color(255, 255, 255));
        boardWooden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/board.png"))); // NOI18N
        boardWooden.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        getContentPane().add(boardWooden);
        boardWooden.setBounds(160, 280, 390, 540);

        bird.setFont(new java.awt.Font("Dialog", 1, 50)); // NOI18N
        bird.setForeground(new java.awt.Color(255, 255, 255));
        bird.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fire10.gif"))); // NOI18N
        bird.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        getContentPane().add(bird);
        bird.setBounds(90, 290, 110, 180);

        fireDragon6.setFont(new java.awt.Font("Dialog", 1, 50)); // NOI18N
        fireDragon6.setForeground(new java.awt.Color(255, 255, 255));
        fireDragon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fire9.gif"))); // NOI18N
        getContentPane().add(fireDragon6);
        fireDragon6.setBounds(1092, 330, 190, 120);

        BackImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/easyBack.jpg"))); // NOI18N
        BackImage.setText(".");
        getContentPane().add(BackImage);
        BackImage.setBounds(0, 0, 1380, 780);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HActionPerformed
        // TODO add your handling code here:
        
        alphabetSound();
        butt=H.getText().charAt(0);
        H.setVisible(false);
        changeValue();
        
    }//GEN-LAST:event_HActionPerformed

    private void GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GActionPerformed
        // TODO add your handling code here:
        
        alphabetSound();
        butt=G.getText().charAt(0);
        
        G.setBackground(Color.DARK_GRAY);
        G.setVisible(false);
        changeValue();

        
        
    }//GEN-LAST:event_GActionPerformed

    private void FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FActionPerformed
        // TODO add your handling code here:
        
        alphabetSound();
        butt=F.getText().charAt(0);
        
        F.setBackground(Color.DARK_GRAY);
        F.setVisible(false);
        changeValue();
    }//GEN-LAST:event_FActionPerformed

    private void EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EActionPerformed
        // TODO add your handling code here:
        
        alphabetSound();
        butt=E.getText().charAt(0);
        

        E.setBackground(Color.DARK_GRAY);
        E.setVisible(false);
        changeValue();
    }//GEN-LAST:event_EActionPerformed

    private void CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CActionPerformed
        // TODO add your handling code here:
        
        alphabetSound();
        butt=C.getText().charAt(0);
        
        C.setBackground(Color.DARK_GRAY);
        C.setVisible(false);
        changeValue();
    }//GEN-LAST:event_CActionPerformed

    private void DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DActionPerformed
        // TODO add your handling code here:
        
        alphabetSound();
        butt=D.getText().charAt(0);
        

        D.setBackground(Color.DARK_GRAY);
        D.setVisible(false);
        changeValue();
    }//GEN-LAST:event_DActionPerformed

    private void BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActionPerformed
        // TODO add your handling code here:
        
        alphabetSound();
        butt=B.getText().charAt(0);
        
        B.setBackground(Color.DARK_GRAY);
        B.setVisible(false);
        changeValue();
    }//GEN-LAST:event_BActionPerformed

    private void AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AActionPerformed
        // TODO add your handling code here:
        
        alphabetSound();
        butt=A.getText().charAt(0);
        A.setBackground(Color.DARK_GRAY);
        A.setVisible(false);
        changeValue();

    }//GEN-LAST:event_AActionPerformed

    private void IActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IActionPerformed
        // TODO add your handling code here:
        alphabetSound();
        butt=I.getText().charAt(0);
        
        I.setBackground(Color.DARK_GRAY);
        I.setVisible(false);
        changeValue();
    }//GEN-LAST:event_IActionPerformed

    private void JActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JActionPerformed
        // TODO add your handling code here:
        alphabetSound();
        butt=J.getText().charAt(0);
        
        J.setBackground(Color.DARK_GRAY);
        J.setVisible(false);
        changeValue();
    }//GEN-LAST:event_JActionPerformed

    private void KActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KActionPerformed
        // TODO add your handling code here:
        alphabetSound();
        butt=K.getText().charAt(0);
        
        K.setBackground(Color.DARK_GRAY);
        K.setVisible(false);
        K.setVisible(false);
        changeValue();
    }//GEN-LAST:event_KActionPerformed

    private void LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LActionPerformed
        // TODO add your handling code here:
        alphabetSound();
        butt=L.getText().charAt(0);
        
        L.setBackground(Color.DARK_GRAY);
        L.setVisible(false);
        changeValue();
    }//GEN-LAST:event_LActionPerformed

    private void MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MActionPerformed
        // TODO add your handling code here:
        alphabetSound();
        butt=M.getText().charAt(0);
        
        M.setBackground(Color.DARK_GRAY);
        M.setVisible(false);
        changeValue();
    }//GEN-LAST:event_MActionPerformed

    private void NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NActionPerformed
        // TODO add your handling code here:
        alphabetSound();
        butt=N.getText().charAt(0);
        
        N.setBackground(Color.DARK_GRAY);
        N.setVisible(false);
        changeValue();
    }//GEN-LAST:event_NActionPerformed

    private void OActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OActionPerformed
        // TODO add your handling code here:
        alphabetSound();
        butt=O.getText().charAt(0);
        
        O.setBackground(Color.DARK_GRAY);
        O.setVisible(false);
        changeValue();
    }//GEN-LAST:event_OActionPerformed

    private void QActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QActionPerformed
        // TODO add your handling code here:
        alphabetSound();
        butt=Q.getText().charAt(0);
        
        Q.setBackground(Color.DARK_GRAY);
        Q.setVisible(false);
        changeValue();
    }//GEN-LAST:event_QActionPerformed

    private void PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PActionPerformed
        // TODO add your handling code here:
        alphabetSound();
        butt=P.getText().charAt(0);
        
        P.setBackground(Color.DARK_GRAY);
        P.setVisible(false);
        changeValue();
    }//GEN-LAST:event_PActionPerformed

    private void RActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RActionPerformed
        // TODO add your handling code here:
        alphabetSound();
        butt=R.getText().charAt(0);
        
        R.setBackground(Color.DARK_GRAY);
        R.setVisible(false);
        changeValue();
    }//GEN-LAST:event_RActionPerformed

    private void SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SActionPerformed
        // TODO add your handling code here:
        alphabetSound();
        butt=S.getText().charAt(0);
        
        S.setBackground(Color.DARK_GRAY);
        S.setVisible(false);
        changeValue();
    }//GEN-LAST:event_SActionPerformed

    private void TActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TActionPerformed
        // TODO add your handling code here:
        alphabetSound();
        butt=T.getText().charAt(0);
        
        T.setBackground(Color.DARK_GRAY);
        T.setVisible(false);
        changeValue();
    }//GEN-LAST:event_TActionPerformed

    private void UActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UActionPerformed
        // TODO add your handling code here:
        alphabetSound();
        butt=U.getText().charAt(0);
        
        U.setBackground(Color.DARK_GRAY);
        U.setVisible(false);
        changeValue();
    }//GEN-LAST:event_UActionPerformed

    private void WActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WActionPerformed
        // TODO add your handling code here:
        
        alphabetSound();
        butt=W.getText().charAt(0);
        
        W.setBackground(Color.DARK_GRAY);
        W.setVisible(false);
        changeValue();
    }//GEN-LAST:event_WActionPerformed

    private void VActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VActionPerformed
        // TODO add your handling code here:
        
        alphabetSound();
        butt=V.getText().charAt(0);
        
        V.setBackground(Color.DARK_GRAY);
        V.setVisible(false);
        changeValue();
    }//GEN-LAST:event_VActionPerformed

    private void XActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XActionPerformed
        // TODO add your handling code here:
        
        alphabetSound();
        butt=X.getText().charAt(0);
        
        X.setBackground(Color.DARK_GRAY);
        X.setVisible(false);
        changeValue();
    }//GEN-LAST:event_XActionPerformed

    private void YActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YActionPerformed
        // TODO add your handling code here:
        
        alphabetSound();
        butt=Y.getText().charAt(0);
       
        Y.setBackground(Color.DARK_GRAY);
        Y.setVisible(false);
         changeValue();
    }//GEN-LAST:event_YActionPerformed

    private void ZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZActionPerformed
        // TODO add your handling code here:
        
        alphabetSound();
        butt=Z.getText().charAt(0);
        
        Z.setBackground(Color.DARK_GRAY);
        Z.setVisible(false);
        changeValue();
    }//GEN-LAST:event_ZActionPerformed

    private void AnotherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnotherActionPerformed
        heartLives--;
        if(heartLives<=1)
            Another.setEnabled(false);
        
        anotherGame();
    }//GEN-LAST:event_AnotherActionPerformed

    int time=0;
    Timer timer;
    boolean timeFlag=false;
    int timeText;
    
    int xPanda=1050;
    int yPanda=-350;
    int ySoul=430;
    
    private void timerResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerResetButtonActionPerformed
        
      time=600;
        
      timer = new Timer(100, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        
        timeText=time/10;
        double temp=1.67 *((double)time/10);
        ProgressBar.setValue((int)temp);
        
        if (yPanda<250) {
            clockText.setText(Integer.toString(timeText));
            
            //----------------------------------------
            int xInc=1;
            
            yPanda+=1;
            
            if(yPanda>-350 && yPanda<-300){
                xPanda+=xInc;
            }
            else if(yPanda>-300 && yPanda<-250){
                xPanda-=xInc;
            }
            else if(yPanda>-250 && yPanda<-200){
                xPanda+=xInc;
            }
            else if(yPanda>-200 && yPanda<-150){
                xPanda-=xInc;
            }   
            else if(yPanda>-150 && yPanda<-100){
                xPanda+=xInc;
            }   
            else if(yPanda>-100 && yPanda<-50){
                xPanda-=xInc;
            }
            else if(yPanda>-50 && yPanda<0){
                xPanda+=xInc;
            }
            else if(yPanda>0 && yPanda<50){
                xPanda-=xInc;
            }
            else if(yPanda>50 && yPanda<100){
                xPanda+=xInc;
            }
            else if(yPanda>100 && yPanda<150){
                xPanda-=xInc;
            }
            else if(yPanda>150 && yPanda<200){
                xPanda+=xInc;
            }
            else if(yPanda>200 && yPanda<250){
                xPanda-=xInc;
            }
            
            pandaAlive.setBounds(xPanda, yPanda, 230, 730);
            
            if(timeText<10){
                clockText.setText(" "+Integer.toString(timeText));
                clockText.setForeground(Color.ORANGE);
                if((timeText)<=3){
                    clockText.setForeground(Color.RED);
                }
            }
            time--;
            
        } else {
           clockText.setText(" 0"); 
           //LoseReason="Timeout";
           
           
          ((Timer) (e.getSource())).stop();          
            timerReset();
            //LoseReason="Timeout";
            ProgressBar.setValue(0);
            //BackImage.setIcon(new javax.swing.ImageIcon("src\\Images\\extBG_Lose.jpg"));
            pandaAlive.setVisible(false);
            pandaDead.setVisible(true);
            revealWord("lose");
            loseWindow("noTime");
        }
      }
    });
      
    timer.setInitialDelay(100);
    timer.start();
    timeFlag=true;
    }//GEN-LAST:event_timerResetButtonActionPerformed
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        
        menuSound();
        backButton();
    }//GEN-LAST:event_backButtonActionPerformed

    private void musicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicActionPerformed
        
        try{
            if(homeRef.bgPlay){
                AudioPlayer.player.stop(homeRef.audioStream);
                homeRef.audioStream.close();
                homeRef.bgPlay=false;
                music.setIcon(new javax.swing.ImageIcon("src\\Images\\musicMute.png"));
            }
            else{
                //System.out.println("dd");
                InputStream in = new FileInputStream(homeRef.gongFile);
                homeRef.audioStream = new AudioStream(in);
                AudioPlayer.player.start(homeRef.audioStream);
                homeRef.bgPlay=true;
                music.setIcon(new javax.swing.ImageIcon("src\\Images\\musicPlay.png"));
            }
        }catch(Exception e){
            
        }
        
            
        
    }//GEN-LAST:event_musicActionPerformed

    private void musicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musicMouseClicked
        
    }//GEN-LAST:event_musicMouseClicked

    private void AnotherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnotherMouseClicked
        menuSound();
    }//GEN-LAST:event_AnotherMouseClicked

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        
    }//GEN-LAST:event_backButtonMouseClicked

   
    
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
            java.util.logging.Logger.getLogger(EasyGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EasyGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EasyGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EasyGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EasyGame ob=new EasyGame();
                ob.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton A;
    private javax.swing.JButton Another;
    private javax.swing.JButton B;
    private javax.swing.JLabel BackImage;
    private javax.swing.JButton C;
    private javax.swing.JButton D;
    private javax.swing.JButton E;
    private javax.swing.JButton F;
    private javax.swing.JButton G;
    private javax.swing.JButton H;
    private javax.swing.JButton I;
    private javax.swing.JButton J;
    private javax.swing.JButton K;
    private javax.swing.JButton L;
    private javax.swing.JButton M;
    private javax.swing.JButton N;
    private javax.swing.JButton O;
    private javax.swing.JButton P;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JButton Q;
    private javax.swing.JButton R;
    private javax.swing.JButton S;
    private javax.swing.JButton T;
    private javax.swing.JButton U;
    private javax.swing.JButton V;
    private javax.swing.JButton W;
    private javax.swing.JButton X;
    private javax.swing.JButton Y;
    private javax.swing.JButton Z;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel bird;
    private javax.swing.JLabel bird1;
    private javax.swing.JLabel boardWooden;
    private javax.swing.JLabel chancesValue;
    private javax.swing.JLabel clockText;
    private javax.swing.JLabel dragon4;
    private javax.swing.JLabel fire1;
    private javax.swing.JLabel fire2;
    private javax.swing.JLabel fireDragon1;
    private javax.swing.JLabel fireDragon2;
    private javax.swing.JLabel fireDragon4;
    private javax.swing.JLabel fireDragon5;
    private javax.swing.JLabel fireDragon6;
    private javax.swing.JLabel heartsRed;
    private javax.swing.JLabel holderWood;
    private javax.swing.JLabel lives;
    private javax.swing.JButton music;
    private javax.swing.JLabel pandaAlive;
    private javax.swing.JLabel pandaDead;
    private javax.swing.JButton timerResetButton;
    private javax.swing.JLabel wordspace;
    // End of variables declaration//GEN-END:variables
}
