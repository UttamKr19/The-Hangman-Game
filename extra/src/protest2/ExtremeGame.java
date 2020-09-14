
package protest2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Uttam
 */
public class ExtremeGame extends javax.swing.JFrame {

    //temporary
    /*
    void setWords(){
        String tempStr[]={"abcde" ,"absurd" ,"xyz"};
        str=tempStr;
    }
    //words
    */
    
    void setWords(){
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
        
    
    // */
    
    String str[];
    
    String word,temp;
    char ch[];
    ArrayList<Integer> al=new ArrayList<>();
    char butt;
    String show;
    String hint;
    int chances;
    String LoseReason;
    ExtremeGame ref=this;
    
    Home homeRef;
    
    
    
    public ExtremeGame() {
        initComponents();
        setWords();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        newGame();
    }
    
    public ExtremeGame(Home home) {
        homeRef=home;
        initComponents();
        setWords();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        newGame();
    }

    
    public void newGame(){
        
        
        timerReset();
        BackImage.setIcon(new javax.swing.ImageIcon("src\\Images\\extBG_Normal.jpg"));
        pandaAlive.setIcon(new javax.swing.ImageIcon("src\\Images\\panda60.png"));
        xPanda=1000;
        yPanda=-350;
        //ySoul=430;
        pandaAlive.setBounds(xPanda, yPanda, 230, 730);
        //pandaSoul.setBounds(980, ySoul, 360, 210);
        
        pandaAlive.setVisible(true);
        pandaDead.setVisible(false);
        //pandaSoul.setVisible(false);
        timerResetButton.doClick();
        clockText.setForeground(Color.WHITE);
        ProgressBar.setValue(100);
        ProgressBar.setForeground(Color.green);
        wordspace.setForeground(Color.black);
        chances=6;
        jLabel7.setText(String.valueOf(chances));
        
        
        word= str[(int) (Math.random() * (str.length-1))];
        word=word.toUpperCase();
        int len=word.length();
        
        temp="";
        hint="";
        
        for(int i=0;i<len;i++)
            temp=temp+"-";
        
        ch=temp.toCharArray();
        
        wordspace.setText(temp);
        
        show=temp;
        
        
    }
    
    void changeValue(){
        //chances--;
        
        //int flag;
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
        jLabel7.setText(String.valueOf(chances));
        
        
        /*/
        if(chances==8){
            //pandaAlive.setIcon(new javax.swing.ImageIcon("src\\Images\\panda60.png"));
            ProgressBar.setValue(100);
        }
        if(chances==7){
            //pandaAlive.setIcon(new javax.swing.ImageIcon("src\\Images\\panda60.png"));
            ProgressBar.setValue(87);
        }
        */
        
        switch (chances) {
            case 6:
                pandaAlive.setIcon(new javax.swing.ImageIcon("src\\Images\\panda60.png"));
                ProgressBar.setValue(100);
                break;
            case 5:
                pandaAlive.setIcon(new javax.swing.ImageIcon("src\\Images\\panda50.png"));
                ProgressBar.setValue(78);
                ProgressBar.setForeground(Color.yellow);
                break;
            case 4:
                pandaAlive.setIcon(new javax.swing.ImageIcon("src\\Images\\panda40.png"));
                ProgressBar.setValue(62);
                ProgressBar.setForeground(Color.yellow);
                break;
            case 3:
                pandaAlive.setIcon(new javax.swing.ImageIcon("src\\Images\\panda30.png"));
                ProgressBar.setValue(50);
                ProgressBar.setForeground(Color.orange);
                break;
            case 2:
                pandaAlive.setIcon(new javax.swing.ImageIcon("src\\Images\\panda20.png"));
                ProgressBar.setValue(32);
                ProgressBar.setForeground(Color.orange);
                break;
            case 1:
                pandaAlive.setIcon(new javax.swing.ImageIcon("src\\Images\\panda10.png"));
                ProgressBar.setValue(16);
                ProgressBar.setForeground(Color.red);
                break;
            default:
                break;
        }
        
        
        
        if(chances<1 && !word.equals(show)){
//            LoseExtreme ob=new LoseExtreme(this);
//            ob.show();
        ProgressBar.setValue(0);
        pandaDead.setVisible(true);
        //pandaSoul.setVisible(true);
        pandaAlive.setVisible(false);
        BackImage.setIcon(new javax.swing.ImageIcon("src\\Images\\extBG_Lose.jpg"));
        
        
            //soulButton.doClick();
            LoseReason="ZeroGuesses";
            timerReset();
            
            revealWord("lose");
            loseWindow();
            
            
        }
        else if(word.equals(show)){
            
            revealWord("win");
            pandaAlive.setVisible(false);
            timerReset();
            BackImage.setIcon(new javax.swing.ImageIcon("src\\Images\\extBG_Win.jpg"));
        E:
            new WinDialog(this,this,true).show();
            
        }
        
        
    }
    
    void revealWord(String result){
        wordspace.setText(word);
        
        if("win".equals(result))
            wordspace.setForeground(Color.green);
        if("lose".equals(result))
            wordspace.setForeground(Color.red);
        
    }
    
    public void anotherGame(){
        
        
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
        
        newGame();
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        wordspace = new javax.swing.JLabel();
        Another = new javax.swing.JButton();
        A = new javax.swing.JButton();
        B = new javax.swing.JButton();
        C = new javax.swing.JButton();
        D = new javax.swing.JButton();
        E = new javax.swing.JButton();
        F = new javax.swing.JButton();
        G = new javax.swing.JButton();
        H = new javax.swing.JButton();
        I = new javax.swing.JButton();
        J = new javax.swing.JButton();
        K = new javax.swing.JButton();
        pandaAlive = new javax.swing.JLabel();
        L = new javax.swing.JButton();
        M = new javax.swing.JButton();
        N = new javax.swing.JButton();
        O = new javax.swing.JButton();
        U = new javax.swing.JButton();
        T = new javax.swing.JButton();
        S = new javax.swing.JButton();
        R = new javax.swing.JButton();
        Q = new javax.swing.JButton();
        P = new javax.swing.JButton();
        V = new javax.swing.JButton();
        W = new javax.swing.JButton();
        X = new javax.swing.JButton();
        Y = new javax.swing.JButton();
        timerResetButton = new javax.swing.JButton();
        Z = new javax.swing.JButton();
        clockText = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        ProgressBar = new javax.swing.JProgressBar();
        pandaDead = new javax.swing.JLabel();
        BackImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 0, 0));
        jLabel6.setText("Guesses left:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(510, 160, 149, 50);

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 0));
        jLabel7.setText("8");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(670, 160, 13, 50);

        wordspace.setBackground(new java.awt.Color(102, 0, 0));
        wordspace.setFont(new java.awt.Font("Batang", 1, 60)); // NOI18N
        wordspace.setText("ABCD");
        wordspace.setName(""); // NOI18N
        getContentPane().add(wordspace);
        wordspace.setBounds(510, 50, 460, 90);

        Another.setBackground(new java.awt.Color(0, 0, 0));
        Another.setForeground(new java.awt.Color(255, 255, 255));
        Another.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/anotherButt1.jpg"))); // NOI18N
        Another.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Another.setBorderPainted(false);
        Another.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Another.setFocusPainted(false);
        Another.setFocusable(false);
        Another.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnotherActionPerformed(evt);
            }
        });
        getContentPane().add(Another);
        Another.setBounds(740, 170, 170, 30);

        A.setBackground(new java.awt.Color(25, 0, 0));
        A.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        A.setForeground(new java.awt.Color(255, 255, 255));
        A.setText("A");
        A.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        A.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        A.setFocusPainted(false);
        A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AActionPerformed(evt);
            }
        });
        getContentPane().add(A);
        A.setBounds(210, 200, 70, 60);

        B.setBackground(new java.awt.Color(25, 0, 0));
        B.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        B.setForeground(new java.awt.Color(255, 255, 255));
        B.setText("B");
        B.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B.setFocusPainted(false);
        B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActionPerformed(evt);
            }
        });
        getContentPane().add(B);
        B.setBounds(40, 340, 70, 60);

        C.setBackground(new java.awt.Color(25, 0, 0));
        C.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        C.setForeground(new java.awt.Color(255, 255, 255));
        C.setText("C");
        C.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        C.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        C.setFocusPainted(false);
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CActionPerformed(evt);
            }
        });
        getContentPane().add(C);
        C.setBounds(110, 270, 70, 60);

        D.setBackground(new java.awt.Color(25, 0, 0));
        D.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        D.setForeground(new java.awt.Color(255, 255, 255));
        D.setText("D");
        D.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        D.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        D.setFocusPainted(false);
        D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DActionPerformed(evt);
            }
        });
        getContentPane().add(D);
        D.setBounds(230, 490, 70, 60);

        E.setBackground(new java.awt.Color(25, 0, 0));
        E.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        E.setForeground(new java.awt.Color(255, 255, 255));
        E.setText("E");
        E.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        E.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        E.setFocusPainted(false);
        E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EActionPerformed(evt);
            }
        });
        getContentPane().add(E);
        E.setBounds(50, 270, 70, 60);

        F.setBackground(new java.awt.Color(25, 0, 0));
        F.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        F.setForeground(new java.awt.Color(255, 255, 255));
        F.setText("F");
        F.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        F.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        F.setFocusPainted(false);
        F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FActionPerformed(evt);
            }
        });
        getContentPane().add(F);
        F.setBounds(350, 420, 70, 60);

        G.setBackground(new java.awt.Color(25, 0, 0));
        G.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        G.setForeground(new java.awt.Color(255, 255, 255));
        G.setText("G");
        G.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G.setFocusPainted(false);
        G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GActionPerformed(evt);
            }
        });
        getContentPane().add(G);
        G.setBounds(350, 340, 70, 60);

        H.setBackground(new java.awt.Color(25, 0, 0));
        H.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        H.setForeground(new java.awt.Color(255, 255, 255));
        H.setText("H");
        H.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        H.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H.setFocusPainted(false);
        H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HActionPerformed(evt);
            }
        });
        getContentPane().add(H);
        H.setBounds(50, 490, 70, 60);

        I.setBackground(new java.awt.Color(25, 0, 0));
        I.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        I.setForeground(new java.awt.Color(255, 255, 255));
        I.setText("I");
        I.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        I.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        I.setFocusPainted(false);
        I.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IActionPerformed(evt);
            }
        });
        getContentPane().add(I);
        I.setBounds(290, 420, 70, 60);

        J.setBackground(new java.awt.Color(25, 0, 0));
        J.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        J.setForeground(new java.awt.Color(255, 255, 255));
        J.setText("J");
        J.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        J.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        J.setFocusPainted(false);
        J.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JActionPerformed(evt);
            }
        });
        getContentPane().add(J);
        J.setBounds(100, 350, 70, 60);

        K.setBackground(new java.awt.Color(25, 0, 0));
        K.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        K.setForeground(new java.awt.Color(255, 255, 255));
        K.setText("K");
        K.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        K.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        K.setFocusPainted(false);
        K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KActionPerformed(evt);
            }
        });
        getContentPane().add(K);
        K.setBounds(290, 260, 70, 60);

        pandaAlive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/panda6.png"))); // NOI18N
        getContentPane().add(pandaAlive);
        pandaAlive.setBounds(1040, -160, 230, 930);

        L.setBackground(new java.awt.Color(25, 0, 0));
        L.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        L.setForeground(new java.awt.Color(255, 255, 255));
        L.setText("L");
        L.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        L.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        L.setFocusPainted(false);
        L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LActionPerformed(evt);
            }
        });
        getContentPane().add(L);
        L.setBounds(110, 430, 70, 60);

        M.setBackground(new java.awt.Color(25, 0, 0));
        M.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        M.setForeground(new java.awt.Color(255, 255, 255));
        M.setText("M");
        M.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        M.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        M.setFocusPainted(false);
        M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MActionPerformed(evt);
            }
        });
        getContentPane().add(M);
        M.setBounds(290, 330, 70, 60);

        N.setBackground(new java.awt.Color(25, 0, 0));
        N.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        N.setForeground(new java.awt.Color(255, 255, 255));
        N.setText("N");
        N.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        N.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        N.setFocusPainted(false);
        N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NActionPerformed(evt);
            }
        });
        getContentPane().add(N);
        N.setBounds(170, 420, 70, 60);

        O.setBackground(new java.awt.Color(25, 0, 0));
        O.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        O.setForeground(new java.awt.Color(255, 255, 255));
        O.setText("O");
        O.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        O.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        O.setFocusPainted(false);
        O.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OActionPerformed(evt);
            }
        });
        getContentPane().add(O);
        O.setBounds(170, 260, 70, 60);

        U.setBackground(new java.awt.Color(25, 0, 0));
        U.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        U.setForeground(new java.awt.Color(255, 255, 255));
        U.setText("U");
        U.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        U.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        U.setFocusPainted(false);
        U.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UActionPerformed(evt);
            }
        });
        getContentPane().add(U);
        U.setBounds(230, 270, 70, 60);

        T.setBackground(new java.awt.Color(25, 0, 0));
        T.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        T.setForeground(new java.awt.Color(255, 255, 255));
        T.setText("T");
        T.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        T.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        T.setFocusPainted(false);
        T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TActionPerformed(evt);
            }
        });
        getContentPane().add(T);
        T.setBounds(230, 350, 70, 60);

        S.setBackground(new java.awt.Color(25, 0, 0));
        S.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        S.setForeground(new java.awt.Color(255, 255, 255));
        S.setText("S");
        S.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        S.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        S.setFocusPainted(false);
        S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SActionPerformed(evt);
            }
        });
        getContentPane().add(S);
        S.setBounds(50, 420, 70, 60);

        R.setBackground(new java.awt.Color(25, 0, 0));
        R.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        R.setForeground(new java.awt.Color(255, 255, 255));
        R.setText("R");
        R.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        R.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        R.setFocusPainted(false);
        R.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RActionPerformed(evt);
            }
        });
        getContentPane().add(R);
        R.setBounds(350, 260, 70, 60);

        Q.setBackground(new java.awt.Color(25, 0, 0));
        Q.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        Q.setForeground(new java.awt.Color(255, 255, 255));
        Q.setText("Q");
        Q.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Q.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Q.setFocusPainted(false);
        Q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QActionPerformed(evt);
            }
        });
        getContentPane().add(Q);
        Q.setBounds(170, 490, 70, 60);

        P.setBackground(new java.awt.Color(25, 0, 0));
        P.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        P.setForeground(new java.awt.Color(255, 255, 255));
        P.setText("P");
        P.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        P.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        P.setFocusPainted(false);
        P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PActionPerformed(evt);
            }
        });
        getContentPane().add(P);
        P.setBounds(110, 500, 70, 60);

        V.setBackground(new java.awt.Color(25, 0, 0));
        V.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        V.setForeground(new java.awt.Color(255, 255, 255));
        V.setText("V");
        V.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        V.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        V.setFocusPainted(false);
        V.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VActionPerformed(evt);
            }
        });
        getContentPane().add(V);
        V.setBounds(230, 430, 70, 60);

        W.setBackground(new java.awt.Color(25, 0, 0));
        W.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        W.setForeground(new java.awt.Color(255, 255, 255));
        W.setText("W");
        W.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        W.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        W.setFocusPainted(false);
        W.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WActionPerformed(evt);
            }
        });
        getContentPane().add(W);
        W.setBounds(290, 490, 70, 60);

        X.setBackground(new java.awt.Color(25, 0, 0));
        X.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        X.setForeground(new java.awt.Color(255, 255, 255));
        X.setText("X");
        X.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        X.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        X.setFocusPainted(false);
        X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XActionPerformed(evt);
            }
        });
        getContentPane().add(X);
        X.setBounds(160, 340, 70, 60);

        Y.setBackground(new java.awt.Color(25, 0, 0));
        Y.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        Y.setForeground(new java.awt.Color(255, 255, 255));
        Y.setText("Y");
        Y.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Y.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Y.setFocusPainted(false);
        Y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YActionPerformed(evt);
            }
        });
        getContentPane().add(Y);
        Y.setBounds(350, 480, 70, 60);

        timerResetButton.setText("timerReset");
        timerResetButton.setFocusable(false);
        timerResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerResetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(timerResetButton);
        timerResetButton.setBounds(1080, 720, 130, 23);

        Z.setBackground(new java.awt.Color(25, 0, 0));
        Z.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        Z.setForeground(new java.awt.Color(255, 255, 255));
        Z.setText("Z");
        Z.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Z.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Z.setFocusPainted(false);
        Z.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZActionPerformed(evt);
            }
        });
        getContentPane().add(Z);
        Z.setBounds(200, 550, 70, 60);

        clockText.setFont(new java.awt.Font("Dialog", 1, 50)); // NOI18N
        clockText.setForeground(new java.awt.Color(255, 255, 255));
        clockText.setText("45");
        getContentPane().add(clockText);
        clockText.setBounds(720, 360, 90, 90);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backbutt.png"))); // NOI18N
        jButton2.setText("Back");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(-120, 10, 300, 60);

        ProgressBar.setBackground(new java.awt.Color(0, 0, 0));
        ProgressBar.setForeground(new java.awt.Color(0, 255, 0));
        ProgressBar.setValue(20);
        ProgressBar.setBorderPainted(false);
        ProgressBar.setFocusable(false);
        getContentPane().add(ProgressBar);
        ProgressBar.setBounds(500, 150, 410, 10);

        pandaDead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/panda0.png"))); // NOI18N
        pandaDead.setText(" ");
        getContentPane().add(pandaDead);
        pandaDead.setBounds(1040, 530, 290, 120);

        BackImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/extBG - Copy2.jpg"))); // NOI18N
        BackImage.setText(".");
        getContentPane().add(BackImage);
        BackImage.setBounds(0, 0, 1380, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HActionPerformed
        // TODO add your handling code here:
        butt=H.getText().charAt(0);
        H.setVisible(false);
        changeValue();
        
    }//GEN-LAST:event_HActionPerformed

    private void GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GActionPerformed
        // TODO add your handling code here:
        butt=G.getText().charAt(0);
        G.setVisible(false);
        changeValue();

        G.setBackground(Color.DARK_GRAY);
        
    }//GEN-LAST:event_GActionPerformed

    private void FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FActionPerformed
        // TODO add your handling code here:
        butt=F.getText().charAt(0);
        
        F.setBackground(Color.DARK_GRAY);
        F.setVisible(false);
        changeValue();
    }//GEN-LAST:event_FActionPerformed

    private void EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EActionPerformed
        // TODO add your handling code here:
        butt=E.getText().charAt(0);
        

        E.setBackground(Color.DARK_GRAY);
        E.setVisible(false);
        changeValue();
    }//GEN-LAST:event_EActionPerformed

    private void CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CActionPerformed
        // TODO add your handling code here:
        butt=C.getText().charAt(0);
        
        C.setBackground(Color.DARK_GRAY);
        C.setVisible(false);
        changeValue();
    }//GEN-LAST:event_CActionPerformed

    private void DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DActionPerformed
        // TODO add your handling code here:
        butt=D.getText().charAt(0);
        

        D.setBackground(Color.DARK_GRAY);
        D.setVisible(false);
        changeValue();
    }//GEN-LAST:event_DActionPerformed

    private void BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActionPerformed
        // TODO add your handling code here:
        butt=B.getText().charAt(0);
        
        B.setBackground(Color.DARK_GRAY);
        B.setVisible(false);
        changeValue();
    }//GEN-LAST:event_BActionPerformed

    private void AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AActionPerformed
        // TODO add your handling code here:
        butt=A.getText().charAt(0);
        
        A.setBackground(Color.DARK_GRAY);
        A.setVisible(false);
        changeValue();

    }//GEN-LAST:event_AActionPerformed

    private void IActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IActionPerformed
        // TODO add your handling code here:
        butt=I.getText().charAt(0);
        

        I.setBackground(Color.DARK_GRAY);
        I.setVisible(false);
        changeValue();
    }//GEN-LAST:event_IActionPerformed

    private void JActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JActionPerformed
        // TODO add your handling code here:
        butt=J.getText().charAt(0);
        

        J.setBackground(Color.DARK_GRAY);
        J.setVisible(false);
        changeValue();
    }//GEN-LAST:event_JActionPerformed

    private void KActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KActionPerformed
        // TODO add your handling code here:
        butt=K.getText().charAt(0);
        

        K.setBackground(Color.DARK_GRAY);
        K.setVisible(false);
        K.setVisible(false);
        changeValue();
    }//GEN-LAST:event_KActionPerformed

    private void LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LActionPerformed
        // TODO add your handling code here:
        butt=L.getText().charAt(0);
        

        L.setBackground(Color.DARK_GRAY);
        L.setVisible(false);
        changeValue();
    }//GEN-LAST:event_LActionPerformed

    private void MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MActionPerformed
        // TODO add your handling code here:
        butt=M.getText().charAt(0);
        

        M.setBackground(Color.DARK_GRAY);
        M.setVisible(false);
        changeValue();
    }//GEN-LAST:event_MActionPerformed

    private void NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NActionPerformed
        // TODO add your handling code here:
        butt=N.getText().charAt(0);
        

        N.setBackground(Color.DARK_GRAY);
        N.setVisible(false);
        changeValue();
    }//GEN-LAST:event_NActionPerformed

    private void OActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OActionPerformed
        // TODO add your handling code here:
        butt=O.getText().charAt(0);
        

        O.setBackground(Color.DARK_GRAY);
        O.setVisible(false);
        changeValue();
    }//GEN-LAST:event_OActionPerformed

    private void QActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QActionPerformed
        // TODO add your handling code here:
        butt=Q.getText().charAt(0);
        
        Q.setBackground(Color.DARK_GRAY);
        Q.setVisible(false);
        changeValue();
    }//GEN-LAST:event_QActionPerformed

    private void PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PActionPerformed
        // TODO add your handling code here:
        butt=P.getText().charAt(0);
        
        P.setBackground(Color.DARK_GRAY);
        P.setVisible(false);
        changeValue();
    }//GEN-LAST:event_PActionPerformed

    private void RActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RActionPerformed
        // TODO add your handling code here:
        butt=R.getText().charAt(0);
        

        R.setBackground(Color.DARK_GRAY);
        R.setVisible(false);
        changeValue();
    }//GEN-LAST:event_RActionPerformed

    private void SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SActionPerformed
        // TODO add your handling code here:
        butt=S.getText().charAt(0);
        

        S.setBackground(Color.DARK_GRAY);
        S.setVisible(false);
        changeValue();
    }//GEN-LAST:event_SActionPerformed

    private void TActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TActionPerformed
        // TODO add your handling code here:
        butt=T.getText().charAt(0);
        

        T.setBackground(Color.DARK_GRAY);
        T.setVisible(false);
        changeValue();
    }//GEN-LAST:event_TActionPerformed

    private void UActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UActionPerformed
        // TODO add your handling code here:
        butt=U.getText().charAt(0);
        

        U.setBackground(Color.DARK_GRAY);
        U.setVisible(false);
        changeValue();
    }//GEN-LAST:event_UActionPerformed

    private void WActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WActionPerformed
        // TODO add your handling code here:
        butt=W.getText().charAt(0);
        

        W.setBackground(Color.DARK_GRAY);
        W.setVisible(false);
        changeValue();
    }//GEN-LAST:event_WActionPerformed

    private void VActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VActionPerformed
        // TODO add your handling code here:
        butt=V.getText().charAt(0);
        
        V.setBackground(Color.DARK_GRAY);
        V.setVisible(false);
        changeValue();
    }//GEN-LAST:event_VActionPerformed

    private void XActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XActionPerformed
        // TODO add your handling code here:
        butt=X.getText().charAt(0);
        

        X.setBackground(Color.DARK_GRAY);
        X.setVisible(false);
        changeValue();
    }//GEN-LAST:event_XActionPerformed

    private void YActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YActionPerformed
        // TODO add your handling code here:
        butt=Y.getText().charAt(0);
       

        Y.setBackground(Color.DARK_GRAY);
        Y.setVisible(false);
         changeValue();
    }//GEN-LAST:event_YActionPerformed

    private void ZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZActionPerformed
        // TODO add your handling code here:
        butt=Z.getText().charAt(0);
        

        Z.setBackground(Color.DARK_GRAY);
        Z.setVisible(false);
        changeValue();
    }//GEN-LAST:event_ZActionPerformed

    private void AnotherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnotherActionPerformed
        anotherGame();
        
    }//GEN-LAST:event_AnotherActionPerformed

    int time=900;
    Timer timer;
    boolean timeFlag=false;
    int timeText;
    //int tlimit=30;
    
    int xPanda=1000;
    int yPanda=-350;
    
    int ySoul=430;
    
    private void timerResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerResetButtonActionPerformed
        // TODO add your handling code here:
        time=900;
        
        timer = new Timer(100, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        timeText=time/20;
        if (timeText > 0 && yPanda<100) {
            clockText.setText(Integer.toString(timeText));
            
            //----------------------------------------
            if(time%2==0)
                yPanda++;
            
            if(yPanda>-350 && yPanda<-300){
                xPanda+=1;
            }
            else if(yPanda>-300 && yPanda<-250){
                xPanda-=1;
            }
            else if(yPanda>-250 && yPanda<-200){
                xPanda+=1;
            }   
            else if(yPanda>-200 && yPanda<-150){
                xPanda-=1;
            }   
            else if(yPanda>-150 && yPanda<-100){
                xPanda+=1;
            }   
            else if(yPanda>-100 && yPanda<-50){
                xPanda-=1;
            }   
            else if(yPanda>-50 && yPanda<0){
                xPanda+=1;
            }
            else if(yPanda>0 && yPanda<50){
                xPanda-=1;
            }
            else if(yPanda>50 && yPanda<100){
                xPanda+=1;
            }
                
            
                
                
            pandaAlive.setBounds(xPanda, yPanda, 230, 730);
            //----------------------------------------
            
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
           LoseReason="Timeout";
           
           
          ((Timer) (e.getSource())).stop();
//          
            timerReset();
            LoseReason="Timeout";
            ProgressBar.setValue(0);
            BackImage.setIcon(new javax.swing.ImageIcon("src\\Images\\extBG_Lose.jpg"));
        
            
            pandaAlive.setVisible(false);
            pandaDead.setVisible(true);
            //pandaSoul.setVisible(true);
            
            revealWord("lose");
            
            //soulButton.doClick();
            loseWindow();
                
        }
      }
    });
      
    timer.setInitialDelay(0);
    timer.start();
    timeFlag=true;
    }//GEN-LAST:event_timerResetButtonActionPerformed
    
    //int timeDead=0;
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        backButton();
    }//GEN-LAST:event_jButton2ActionPerformed

    Timer timer2;
    boolean timer2Flag=false;
    void loseWindow(){
       new LoseDialog(this,this,true,LoseReason).show();
    }    
       
    void backButton(){
        homeRef.show();
        timerReset();
        this.dispose();
    }
    
    void timerReset(){
        if(timeFlag){
                timer.stop();
                timeFlag=false;
                time=900;
                timeText=time/20;
                clockText.setText(Integer.toString(timeText));
        }
        
    }
    
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
            java.util.logging.Logger.getLogger(ExtremeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExtremeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExtremeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExtremeGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExtremeGame().setVisible(true);
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
    private javax.swing.JLabel clockText;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel pandaAlive;
    private javax.swing.JLabel pandaDead;
    private javax.swing.JButton timerResetButton;
    private javax.swing.JLabel wordspace;
    // End of variables declaration//GEN-END:variables
}
