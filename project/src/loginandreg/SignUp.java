/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginandreg;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;   
import Classes.PatternChecker;
import Classes.ValMail;
import Classes.ReceiveMail;
import java.awt.HeadlessException;

/**
 *
 * @author OmarKandeel
 */
public class SignUp extends javax.swing.JFrame {

    boolean VerifiedEmail=false;
    String RandomCode=ValMail.generateRandomCode(6);
    int Cou=0;
    boolean confirmedpassword=false;
    
     private void addPasswordListener() {
        Document doc = Password.getDocument();
        doc.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handlePasswordChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handlePasswordChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                handlePasswordChange();
            }
        });
    }
    
    private void addPassword2Listener() {
        Document doc = Password2.getDocument();
        doc.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handlePassword2Change();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handlePassword2Change();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                handlePassword2Change();
            }
        });
    }
    
      private void handlePassword2Change(){
        char[] passChars = Password2.getPassword();
        String pass = new String(passChars).trim();
        pass=pass.trim();
        
        
        char[] passChars2 = Password.getPassword();
        String pass2 = new String(passChars2).trim();
        pass2=pass2.trim();
        
        System.out.println("password : "+pass2+"\n");

        System.out.println("confirm password : "+pass+"\n");
        if(pass.equals(pass2))
        {
            mess.setText("password mathced");
            confirmedpassword=true;
        }
        else
        {
            mess.setText("password are not matched");
            confirmedpassword=false;
        }
        System.out.println(confirmedpassword);
      }
      
      
    private void handlePasswordChange() {
        char[] passChars = Password.getPassword();
        String pass = new String(passChars).trim();
        System.out.println("password : " +pass+"\n");
        pass=pass.trim();
       if(PatternChecker.MatchPattern(pass))
       {
           Bar.setColor(Color.GREEN); // Set the color of the progress bar
           mess.setText("password accepted");
           Bar.setValue(100);
       }
       else if(!PatternChecker.MatchPatternSchars(pass)&&PatternChecker.MatchPatternchars(pass)&&PatternChecker.MatchPattern8Num(pass))
       {
           Bar.setColor(new java.awt.Color(255, 0, 51));
           mess.setText("password must contain 1 special char");
           Bar.setValue(68);
       }
       else if(!PatternChecker.MatchPatternSchars(pass)&&!PatternChecker.MatchPatternchars(pass)&&PatternChecker.MatchPattern8Num(pass))
       {
           mess.setText("password must contain 1 upper case and 1 lower case");
           Bar.setColor(new java.awt.Color(255, 0, 51));
           Bar.setValue(34);
       }
       else if(!PatternChecker.MatchPatternSchars(pass)&&!PatternChecker.MatchPatternchars(pass)&&!PatternChecker.MatchPattern8Num(pass))
       {
    //                nums.setBackground(new java.awt.Color(204, 0, 0));
            Bar.setColor(new java.awt.Color(255, 0, 51));
            mess.setText("password must contain 8 numbers");
       }
       else {
    //                System.out.println("color changed");
           Bar.setColor(Color.GREEN); // Set the color of the progress bar
           mess.setText("password accepted");
           Bar.setValue(100);
       }

       if(pass.isEmpty())
       {
           Bar.setValue(0);
       }
    }
    /**
     * Creates new form SignUp
     */
    public SignUp() {
        initComponents();


        addPasswordListener();
        addPassword2Listener();
    }
    public boolean isNumeric(String str) {
    // Check if the string is empty
    if (str == null || str.isEmpty()) {
        return false;
    }

    // Loop through each character in the string
    for (int i = 0; i < str.length(); i++) {
        // Check if the character is not a digit
        if (!Character.isDigit(str.charAt(i))) {
            return false;
        }
    }

    // If all characters are digits, return true
    return true;
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Left = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Lname = new javax.swing.JTextField();
        Fname = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        ID = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        togbtn1 = new javax.swing.JToggleButton();
        mess = new javax.swing.JLabel();
        Verify = new com.k33ptoo.components.KButton();
        verifo = new javax.swing.JTextField();
        Verify1 = new com.k33ptoo.components.KButton();
        mess1 = new javax.swing.JLabel();
        Password2 = new javax.swing.JPasswordField();
        togbtn2 = new javax.swing.JToggleButton();
        jLabel14 = new javax.swing.JLabel();
        Bar = new Classes.ProgressBarCustom();
        lefttt = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jXHyperlink1 = new org.jdesktop.swingx.JXHyperlink();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        expire_date = new org.jdesktop.swingx.JXDatePicker();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        signup = new com.k33ptoo.components.KButton();
        jLabel22 = new javax.swing.JLabel();
        atm_pin = new javax.swing.JTextField();
        card_no = new javax.swing.JTextField();
        cvv = new javax.swing.JTextField();
        mob_no = new javax.swing.JTextField();
        add = new javax.swing.JTextField();
        AccountType = new java.awt.Choice();
        Gender = new java.awt.Choice();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        city = new java.awt.Choice();
        country = new java.awt.Choice();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign Up");
        setMinimumSize(new java.awt.Dimension(780, 630));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setPreferredSize(new java.awt.Dimension(800, 500));
        Left.setLayout(null);

        Right.setBackground(new java.awt.Color(0, 102, 102));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("© 2024 EasyPay All rights reserved. ");

        jLabel7.setFont(new java.awt.Font("Mistral", 0, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("EasyPay");

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SIGN UP");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("First Name");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Last Name");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Email");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("National ID:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password");

        Lname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        Lname.setDisabledTextColor(new java.awt.Color(204, 204, 0));
        Lname.setSelectedTextColor(new java.awt.Color(242, 242, 242));

        Fname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        Fname.setDisabledTextColor(new java.awt.Color(204, 204, 0));
        Fname.setSelectedTextColor(new java.awt.Color(242, 242, 242));

        Email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        Email.setDisabledTextColor(new java.awt.Color(204, 204, 0));
        Email.setSelectedTextColor(new java.awt.Color(242, 242, 242));

        ID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        ID.setDisabledTextColor(new java.awt.Color(204, 204, 0));
        ID.setSelectedTextColor(new java.awt.Color(242, 242, 242));

        Password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        Password.setSelectedTextColor(new java.awt.Color(242, 242, 242));
        Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasswordKeyPressed(evt);
            }
        });

        togbtn1.setText("Show");
        togbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                togbtn1MouseClicked(evt);
            }
        });

        mess.setForeground(new java.awt.Color(153, 153, 153));

        Verify.setText("Verify");
        Verify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VerifyMouseClicked(evt);
            }
        });

        //verifo.setText("Verification Code");
        verifo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                verifoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                verifoFocusLost(evt);
            }
        });

        Verify1.setText("Confirm");
        Verify1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Verify1MouseClicked(evt);
            }
        });

        mess1.setForeground(new java.awt.Color(153, 153, 153));

        Password2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        Password2.setSelectedTextColor(new java.awt.Color(242, 242, 242));

        togbtn2.setText("Show");
        togbtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                togbtn2MouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Confirm password");

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RightLayout.createSequentialGroup()
                                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(mess1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(verifo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Fname, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Lname, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Verify, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Verify1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel18)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(RightLayout.createSequentialGroup()
                                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(togbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14)
                            .addComponent(mess, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(RightLayout.createSequentialGroup()
                                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Bar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Password2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(togbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(RightLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(Fname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(0, 0, 0)
                .addComponent(Lname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel9)
                .addGap(0, 0, 0)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Verify, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verifo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Verify1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mess1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel18)
                .addGap(0, 0, 0)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel10)
                .addGap(0, 0, 0)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(togbtn1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Password2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(togbtn2))
                .addGap(15, 15, 15)
                .addComponent(Bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mess, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(120, 120, 120))
        );

        Left.add(Right);
        Right.setBounds(0, 0, 410, 720);

        lefttt.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel4.setText("Already have an account? ");

        jXHyperlink1.setForeground(new java.awt.Color(0, 102, 102));
        jXHyperlink1.setText("Log In");
        jXHyperlink1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHyperlink1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Account Type:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Card Number:");

        jLabel11.setFont(new java.awt.Font("Sitka Display", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("(Your 16-digit Card number)");

        jLabel15.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Expiry Date:");

        expire_date.setToolTipText("Cvv");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
        expire_date.setFormats(dateFormat);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("CVV:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("ATM PIN:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 102));
        jLabel19.setText("Gender:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setText("Mobile Number:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setText("Address:");

        signup.setForeground(new java.awt.Color(204, 102, 0));
        signup.setText("Sign Up");
        signup.setkBackGroundColor(new java.awt.Color(255, 102, 102));
        signup.setkBorderRadius(25);
        signup.setkEndColor(new java.awt.Color(255, 255, 51));
        signup.setkHoverEndColor(new java.awt.Color(0, 102, 102));
        signup.setkSelectedColor(new java.awt.Color(0, 102, 102));
        signup.setkStartColor(new java.awt.Color(0, 102, 102));
        signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupMouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setText("X");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        atm_pin.setBackground(new Color(0,0,0,0));
        atm_pin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        atm_pin.setDisabledTextColor(new java.awt.Color(204, 204, 0));
        atm_pin.setSelectedTextColor(new java.awt.Color(242, 242, 242));

        card_no.setBackground(new Color(0,0,0,0));
        card_no.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        card_no.setDisabledTextColor(new java.awt.Color(204, 204, 0));
        card_no.setSelectedTextColor(new java.awt.Color(242, 242, 242));

        cvv.setBackground(new Color(0,0,0,0));
        cvv.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        cvv.setDisabledTextColor(new java.awt.Color(204, 204, 0));
        cvv.setSelectedTextColor(new java.awt.Color(242, 242, 242));

        mob_no.setBackground(new Color(0,0,0,0));
        mob_no.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        mob_no.setDisabledTextColor(new java.awt.Color(204, 204, 0));
        mob_no.setSelectedTextColor(new java.awt.Color(242, 242, 242));

        add.setBackground(new Color(0,0,0,0));
        add.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        add.setDisabledTextColor(new java.awt.Color(204, 204, 0));
        add.setSelectedTextColor(new java.awt.Color(242, 242, 242));

        AccountType.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        AccountType.add("Saving Account");
        AccountType.add("Fixed Deposit Account");
        AccountType.add("Current Account");
        AccountType.add("recurring Deposit Account");

        Gender.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        Gender.addItem("Female");
        Gender.addItem("Male");
        Gender.addItem("Prefer Not to say");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("City:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Country:");

        city.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        city.add("Cairo");
        city.add("Alexandria");
        city.add("Aswan");
        city.add("Giza");
        city.add("Luxor");
        city.add("Faiyoum");
        city.add("Mansoura");
        city.add("Port saied");

        country.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        country.add("Egypt");
        country.add("Spain");
        country.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                countryItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout leftttLayout = new javax.swing.GroupLayout(lefttt);
        lefttt.setLayout(leftttLayout);
        leftttLayout.setHorizontalGroup(
            leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftttLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftttLayout.createSequentialGroup()
                .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, leftttLayout.createSequentialGroup()
                        .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, leftttLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, leftttLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(leftttLayout.createSequentialGroup()
                                        .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(AccountType, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(card_no, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel11))))
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(leftttLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(leftttLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jXHyperlink1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, leftttLayout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(leftttLayout.createSequentialGroup()
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(expire_date, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(leftttLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(leftttLayout.createSequentialGroup()
                                            .addComponent(jLabel21)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(leftttLayout.createSequentialGroup()
                                            .addComponent(jLabel20)
                                            .addGap(18, 18, 18)
                                            .addComponent(mob_no, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(leftttLayout.createSequentialGroup()
                                            .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel17)
                                                .addComponent(jLabel16))
                                            .addGap(62, 62, 62)
                                            .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cvv, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                                .addComponent(atm_pin, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))))))))
                .addGap(59, 59, 59))
            .addGroup(leftttLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftttLayout.setVerticalGroup(
            leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftttLayout.createSequentialGroup()
                .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftttLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(leftttLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AccountType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)))
                .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card_no, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expire_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cvv, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftttLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftttLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(atm_pin, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mob_no, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(28, 28, 28)
                .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(leftttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jXHyperlink1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(162, 162, 162))
        );

        Left.add(lefttt);
        lefttt.setBounds(410, -30, 390, 750);

        getContentPane().add(Left);
        Left.setBounds(0, 0, 800, 640);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jXHyperlink1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHyperlink1ActionPerformed
        // TODO add your handling code here:  Login LoginFrame = new Login();
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);

        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jXHyperlink1ActionPerformed

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void signupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupMouseClicked
        // TODO add your handling code here:
        LocalDate selectedDate = expire_date.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String expireDateString = selectedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String fname=Fname.getText();
        String lname=Lname.getText();
        String email=Email.getText();
        char[] passChars = Password.getPassword();
        String pass = new String(passChars);
        String Nation_no=ID.getText();
        String Country =country.getSelectedItem();
        String City=city.getSelectedItem();
        String AccType=AccountType.getSelectedItem();
        String Card_no=card_no.getText();
        String Cvv=cvv.getText();
        String AtmPin=atm_pin.getText();
        String FullAddress=add.getText();
        String Mob_Num=mob_no.getText();
        String Sex=Gender.getSelectedItem();
        

        if(Sex.isEmpty()||Mob_Num.isEmpty()||FullAddress.isEmpty()||AtmPin.isEmpty()||Cvv.isEmpty()||expireDateString.isEmpty()||fname.isEmpty()||Card_no.isEmpty()||lname.isEmpty()||email.isEmpty()||pass.isEmpty()||Nation_no.isEmpty()||Country.isEmpty()||City.isEmpty()||AccType.isEmpty())
        {
             Mess mass=new Mess(this);
            mass.showMessage("Missing data","please enter the required fields");
        }
        else if(!isNumeric(Nation_no))
        {
             Mess mass=new Mess(this);
            mass.showMessage("National id","national id is not valid");
        }
        else if(!isNumeric(Card_no))
        {
             Mess mass=new Mess(this);
            mass.showMessage("card number","please assure that you entered a valid card number");
        }
        else if(!isNumeric(Cvv))
        {
             Mess mass=new Mess(this);
            mass.showMessage("cvv","please assure that you entered a valid cvv");
        }
        else if(!isNumeric(Mob_Num))
        {
             Mess mass=new Mess(this);
            mass.showMessage("Moblie number","please assure that you entered a valid mobile number");
        }
        else if(!isNumeric(AtmPin))
        {
             Mess mass=new Mess(this);
            mass.showMessage("Atm Pin","please assure that you entered a valid atm pin");
        }
        else if((Mob_Num.length())>12)
        {
             Mess mass=new Mess(this);
            mass.showMessage("Moblie number","entered mobile number is too long");
            mob_no.setText(" ");
        }
        else if((email.length())>29)
        {
             Mess mass=new Mess(this);
            mass.showMessage("email","long email please provide me with a different one");
            Email.setText(" ");
        }
        else if((fname.length())>10 || (lname.length())>10)
        {
             Mess mass=new Mess(this);
            mass.showMessage("name","name too long");
            Fname.setText(" ");
            Lname.setText(" ");
        }
        else if((Nation_no.length()) >15)
        {
            Mess mass=new Mess(this);
            mass.showMessage("national id","enter Egyptian national ids only");
            ID.setText(" ");
        }
        else if(FullAddress.length()>15)
        {
            Mess mass=new Mess(this);
            mass.showMessage("full address","enter a real address");
            add.setText(" ");
        }
        else if((Cvv.length()) >3)
        {
            Mess mass=new Mess(this);
            mass.showMessage("name","name too long");
            cvv.setText(" ");
        }
        else if((AtmPin.length())>6)
        {
            Mess mass=new Mess(this);
            mass.showMessage("atm pin","enter a pin for atm of 6 digits");
            atm_pin.setText(" ");
        }
        else if((Card_no.length())>16)
        {
            Mess mass=new Mess(this);
            mass.showMessage("card number","enter a card num of 6 digits");
            card_no.setText(" ");
        }
        else if((pass.length())>50)
        {
            Mess mass=new Mess(this);
            mass.showMessage("password","password limit is 50 chars");
            Password.setText(" ");
        }
        else
        {
                StringTokenizer token =new StringTokenizer(email,"@");
                String fullmail=Email.getText();
                String domain = new String();
                if(token.hasMoreTokens())
                {
                    email=(String)token.nextElement();//user ie before @
                }
                while(token.hasMoreTokens())
                {
                    domain = token.nextToken();//@gmail????
                }
                StringTokenizer token2=new StringTokenizer(domain,".");
                if(token2.hasMoreTokens())
                {
                    domain=token2.nextToken();
                }

                /***************************************************************************/

                domain=domain.toLowerCase();

            if(fname.length()<4||lname.length()<4)
            {
                Mess mass=new Mess(this);
            mass.showMessage("name","name too short");
            }
            else if(!ValMail.EmailVal(fullmail))
            {
                 Mess mass=new Mess(this);
            mass.showMessage("email","email does not meet our standards");
            }
            else if(!domain.equals("gmail"))
            {
                 Mess mass=new Mess(this);
            mass.showMessage("mail","only google accounts are accepted");
            }
            else if(!VerifiedEmail)
            {
                 Mess mass=new Mess(this);
                 mass.showMessage("mail","You must verify your mail firstly");
            }
            else if(!confirmedpassword)
            {
                 Mess mass=new Mess(this);
            mass.showMessage("password","passwords should be matched before signing up");
            }
            else
            {


                int rs=0;
                boolean fq=false;
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://mysql-java-project.mysql.database.azure.com:3306/bankdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "alfredo", "A8d84H.>5V@%k}9");

                    Statement stmt = con.createStatement();
                    String sqlCommand ="insert into customers(fname,lname,national_id,mobile_no,email,Address,country,city,sex) VALUES(?,?,?,?,?,?,?,?,?);";
                    PreparedStatement pstmt = con.prepareStatement(sqlCommand);
                    Mob_Num=Mob_Num.substring(2,Mob_Num.length());
                    Mob_Num=Mob_Num.trim();
                    if(Sex.equals("Female"))
                    {
                        Sex="f";
                    }
                    else if(Sex.equals("Male"))
                    {
                        Sex="m";
                    }
                    else if(Sex.equals("Prefer not to say"))
                    {
                        Sex="o";
                    }
                    else
                    {
                        Sex="s";
                    }
                    pstmt.setString(1, fname);
                    pstmt.setString(2, lname);
                    pstmt.setString(3, Nation_no);
                    pstmt.setString(4, Mob_Num);
                    pstmt.setString(5, email);
                    pstmt.setString(6, FullAddress);
                    pstmt.setString(7, Country);
                    pstmt.setString(8, City);
                    pstmt.setString(9, Sex);

                    rs = pstmt.executeUpdate();


                    fq=true;
                // Close the ResultSet, Statement, and Connection
                }
                catch (ClassNotFoundException | SQLException e)
                {
                   
                    JOptionPane.showMessageDialog(this,e);
                    System.out.println(e.getMessage());
                    System.out.println("first");
                }


                boolean tt=false;
                /************************************************************************************************/
                if(fq)
                {
                    try
                    {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://mysql-java-project.mysql.database.azure.com:3306/bankdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "alfredo", "A8d84H.>5V@%k}9");

                        Statement stmt = con.createStatement();
                        String sqlCommand = "INSERT INTO account (card_number, cvv, national_no, acc_pass, atm_pin, acc_category, expire_date, balance) VALUES (?, ?, ?, ?, ?, ?, ?,?);";
                        PreparedStatement pstmt = con.prepareStatement(sqlCommand);

                        String accType=new String();

                        if(AccType.equals("Saving Account"))
                        {
                            accType="s";
                        }
                        else if(AccType.equals("Fixed Deposit Account"))
                        {
                            accType="f";
                        }
                        else if(AccType.equals("Current Account"))
                        {
                            accType="c";
                        }
                        else if(AccType.equals("recurring Deposit Account"))
                        {
                            accType="r";
                        }

                        pstmt.setString(1, Card_no);
                        pstmt.setString(2, Cvv);
                        pstmt.setString(3, Nation_no);
                        pstmt.setString(4, pass);
                        pstmt.setString(5, AtmPin);
                        pstmt.setString(6, accType);
                        pstmt.setString(7,expireDateString);
                        pstmt.setString(8, "0");


                        pstmt.executeUpdate();

                        // Close resources
                        pstmt.close();
                        con.close();

                        tt=true;


                    // Close the ResultSet, Statement, and Connection
                    }
                    catch (HeadlessException | ClassNotFoundException | SQLException e)
                    {
                        JOptionPane.showMessageDialog(this,e);
                        System.out.println(e.getMessage());
                        System.out.println("second");
                    }
                    if(tt){
                        try{
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://mysql-java-project.mysql.database.azure.com:3306/bankdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "alfredo", "A8d84H.>5V@%k}9");

                        String sqlCommand = "INSERT INTO cards (card_no, cvv, national_no, atm_pin, expire_date, balance,locked) VALUES ( ?,?, ?, ?, ?, ?, ?);";
                        PreparedStatement pstmt = con.prepareStatement(sqlCommand);

                        String accType = new String();

                        pstmt.setString(1, Card_no);
                        pstmt.setString(2, Cvv);
                        pstmt.setString(3, Nation_no);
                        pstmt.setString(4, AtmPin);
                        pstmt.setObject(5, expireDateString);
                        pstmt.setString(6, "0");
                        pstmt.setString(7, "0");

                        pstmt.executeUpdate();
                        
                        // Close resources
                        pstmt.close();
                        con.close();

                           JOptionPane.showMessageDialog(this,"Signed up successfully");

                       }
                       catch(HeadlessException | ClassNotFoundException | SQLException e)
                       {
                           JOptionPane.showMessageDialog(this,e);
                           System.out.println(e.getMessage());
                           System.out.println("third");
                       }
                    }
                    else
                    {
                         try{
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://mysql-java-project.mysql.database.azure.com:3306/bankdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "alfredo", "A8d84H.>5V@%k}9");

                        Statement stmt = con.createStatement();
                        String sqlCommand ="delete from cards where national_no=?;";
                        PreparedStatement pstmt = con.prepareStatement(sqlCommand);
                        pstmt.setString(1, Nation_no);
                        int rsss=pstmt.executeUpdate();
                        }
                        catch (ClassNotFoundException | SQLException ex)
                         {
                             JOptionPane.showMessageDialog(this,ex);
                            System.out.println(ex.getMessage());
                            System.out.println("first");
                         }
                    }
                    
                }
                else
                {
                  try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                 Connection con = DriverManager.getConnection("jdbc:mysql://mysql-java-project.mysql.database.azure.com:3306/bankdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "alfredo", "A8d84H.>5V@%k}9");

                Statement stmt = con.createStatement();
                String sqlCommand ="delete from customers where national_id=?;";
                PreparedStatement pstmt = con.prepareStatement(sqlCommand);
                pstmt.setString(1, Nation_no);
                int rss=pstmt.executeUpdate();
                }
                catch (ClassNotFoundException | SQLException ex)
                 {
                     JOptionPane.showMessageDialog(this,ex);
                    System.out.println(ex.getMessage());
                    System.out.println("first");
                 }   
                }
                       this.dispose();
                       Login LoginFrame = new Login();
                       LoginFrame.setVisible(true);
                       LoginFrame.pack();
                       LoginFrame.setLocationRelativeTo(null);
            }
        }
    }//GEN-LAST:event_signupMouseClicked

    private void togbtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_togbtn1MouseClicked
        // TODO add your handling code here:
        if(togbtn1.isSelected())
        {
            Password.setEchoChar((char)0);
            togbtn1.setText("Hide");
        }
        else
        {
            Password.setEchoChar('*');
            togbtn1.setText("Show");
        }
    }//GEN-LAST:event_togbtn1MouseClicked

    private void VerifyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerifyMouseClicked
        // TODO add your handling code here:
        boolean flag=true;
        StringTokenizer email = new StringTokenizer(Email.getText().trim(),"@");
        String emailo=new String();
        if(email.hasMoreElements())
        {
            emailo=(String)email.nextToken();
        }
        try{
           // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql-java-project.mysql.database.azure.com:3306/bankdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "alfredo", "A8d84H.>5V@%k}9");


            // Prepare SQL statement
            String sqlCommand = "SELECT email FROM customers;";
            PreparedStatement pstmt = con.prepareStatement(sqlCommand);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                // Retrieve the email from the ResultSet
                String emailFromDB = rs.getString("email");

                // Perform the comparison
                if (emailFromDB.equals(emailo)) {
                    // If the email from the database matches emailo, set flag to false and exit the loop
                    flag = false;
                    break;
                }
            }

            // Close resources
            rs.close();
            pstmt.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
             Mess mass=new Mess(this);
                 mass.showMessage("error",e.getMessage());
        }
        if(flag){
            ValMail.sendEmail(Email.getText().trim(),"Verification",RandomCode);
            if(ReceiveMail.receivemail()==1){
                Mess mass=new Mess(this);
                 mass.showMessage("Email","Please enter a valid email because this email is not on gmail database");
            }
            else{
                Mess mass=new Mess(this);
                 mass.showMessage("Verification code Sent","Check your inbox");
            }
        }
        else
        {
            Mess mass=new Mess(this);
            mass.showMessage("Email","please enter a different email as this email is already used");
        }
    }//GEN-LAST:event_VerifyMouseClicked

    private void Verify1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Verify1MouseClicked
        // TODO add your handling code here:
        String EnteredCode=verifo.getText().trim();
        
        if(Cou<3)
        {
            if(!EnteredCode.equals(RandomCode))
            {
                mess1.setText("wrong code");
                Cou++;
            }
            else
            {
                mess1.setText("right code");
                VerifiedEmail=true;
            }
        }
        else
        {
            mess1.setText("Please enter a different mail as you entered the code worng for 3 times");
        }
    }//GEN-LAST:event_Verify1MouseClicked

    private void togbtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_togbtn2MouseClicked
        // TODO add your handling code here:
        if(togbtn2.isSelected())
        {
            Password2.setEchoChar((char)0);
            togbtn2.setText("Hide");
        }
        else
        {
            Password2.setEchoChar('*');
            togbtn2.setText("Show");
        }
    }//GEN-LAST:event_togbtn2MouseClicked

    private void countryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_countryItemStateChanged
        // TODO add your handling code here:
            if (evt.getStateChange() == ItemEvent.SELECTED) {
            String selectedOption = country.getSelectedItem();
           
            if(selectedOption.equals("Egypt"))
            {   
                 while (city.getItemCount() > 0) {
                    city.remove(0); // Remove the item at index 0
                }
                city.add("Cairo");
                city.add("Alexandria");
                city.add("Aswan");
                city.add("Giza");
                city.add("Luxor");
                city.add("Faiyoum");
                city.add("Mansoura");
                city.add("Port saied");
            }
            else if(selectedOption.equals("Spain"))
            {
                while (city.getItemCount() > 0) {
                    city.remove(0); // Remove the item at index 0
                }
                city.add("Madrid");
                city.add("Barcelona");
                city.add("Seville");
                city.add("Valencia");
                city.add("Bilbao");
                city.add("Córdoba");
                city.add("Málaga");
                city.add("Zaragoza");
            }
            
         }
    }//GEN-LAST:event_countryItemStateChanged

    private void verifoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_verifoFocusGained
        // TODO add your handling code here:
        if (verifo.getText().equals("verification code")) {
        verifo.setText("");
        setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_verifoFocusGained

    private void verifoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_verifoFocusLost
        // TODO add your handling code here:
        if (verifo.getText().isEmpty()) {
            verifo.setText("verification code");
            setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_verifoFocusLost

    private void PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordKeyPressed

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
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice AccountType;
    private Classes.ProgressBarCustom Bar;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Fname;
    private java.awt.Choice Gender;
    private javax.swing.JTextField ID;
    private javax.swing.JPanel Left;
    private javax.swing.JTextField Lname;
    private javax.swing.JPasswordField Password;
    private javax.swing.JPasswordField Password2;
    private javax.swing.JPanel Right;
    private com.k33ptoo.components.KButton Verify;
    private com.k33ptoo.components.KButton Verify1;
    private javax.swing.JTextField add;
    private javax.swing.JTextField atm_pin;
    private javax.swing.JTextField card_no;
    private java.awt.Choice city;
    private java.awt.Choice country;
    private javax.swing.JTextField cvv;
    private org.jdesktop.swingx.JXDatePicker expire_date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private org.jdesktop.swingx.JXHyperlink jXHyperlink1;
    private javax.swing.JPanel lefttt;
    private javax.swing.JLabel mess;
    private javax.swing.JLabel mess1;
    private javax.swing.JTextField mob_no;
    private com.k33ptoo.components.KButton signup;
    private javax.swing.JToggleButton togbtn1;
    private javax.swing.JToggleButton togbtn2;
    private javax.swing.JTextField verifo;
    // End of variables declaration//GEN-END:variables
}
