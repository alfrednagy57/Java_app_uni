package loginandreg;

//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
//import javax.swing.JDialog;
import javax.swing.JFrame;
//import javax.swing.Timer;
//import javax.swing.text.SimpleAttributeSet;
//import javax.swing.text.StyleConstants;
//import javax.swing.text.StyledDocument;
import Classes.Glass;
import javax.swing.JOptionPane;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;



public class PaneAddCard extends javax.swing.JDialog {

    private final JFrame frame;
    private final Glass glass;
    private boolean show;
    private MessageType messageType = MessageType.CANCEL;
    private Animator animator;
    
    public boolean confirmed;
    
    public PaneAddCard(JFrame frame) {
        super(frame, true);
        this.frame = frame;
        initComponents();
        init();
        glass = new Glass();
    }

       private void init() {
        animator = new Animator(350, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                float f = show ? fraction : 1f - fraction;
                glass.setAlpha(f - f * 0.3f);
                setOpacity(f);
            }

            @Override
            public void end() {
                if (!show) {
                    dispose();
                    glass.setVisible(false);
                }
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        setOpacity(0f);
    }

    private void startAnimator(boolean show) {
        if (animator.isRunning()) {
            float f = animator.getTimingFraction();
            animator.stop();
            animator.setStartFraction(1f - f);
        } else {
            animator.setStartFraction(0f);
        }
        this.show = show;
        animator.start();
    }

   public void showMessage(String title, String message) {
        frame.setGlassPane(glass);
        glass.setVisible(true);
        lbTitle.setText(title);
        setLocationRelativeTo(frame);
        show = true;
        animator.start();
        setVisible(true);
    }

    public void closeMessage() {
        show = false;
        animator.start();
    }

    public MessageType getMessageType() {
        return messageType;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new javaswingdev.message.Background();
        cmdCancel = new javaswingdev.swing.ButtonCustom();
        cmdOK = new javaswingdev.swing.ButtonCustom();
        lbTitle = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        togbtn1 = new javax.swing.JToggleButton();
        Password2 = new javax.swing.JPasswordField();
        togbtn2 = new javax.swing.JToggleButton();
        CardNum = new javax.swing.JTextField();
        cvv = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        expire_date = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        background1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        cmdCancel.setBackground(new java.awt.Color(245, 71, 71));
        cmdCancel.setText("Cancel");
        cmdCancel.setColorHover(new java.awt.Color(255, 74, 74));
        cmdCancel.setColorPressed(new java.awt.Color(235, 61, 61));
        cmdCancel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        cmdOK.setText("OK");
        cmdOK.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        cmdOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOKActionPerformed(evt);
            }
        });

        lbTitle.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(245, 71, 71));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Message Title");

        Password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        Password.setSelectedTextColor(new java.awt.Color(242, 242, 242));

        togbtn1.setText("Show");
        togbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                togbtn1MouseClicked(evt);
            }
        });

        Password2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 102)));
        Password2.setSelectedTextColor(new java.awt.Color(242, 242, 242));

        togbtn2.setText("Show");
        togbtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                togbtn2MouseClicked(evt);
            }
        });

        jLabel1.setText("CVV");

        expire_date.setToolTipText("Cvv");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
        expire_date.setFormats(dateFormat);

        jLabel2.setText("Expire date");

        jLabel3.setText("Atm pin");

        jLabel4.setText("Cinfirm atm pin");

        jLabel5.setText("Card_number");

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/icon.png"))); // NOI18N

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(background1Layout.createSequentialGroup()
                .addComponent(cmdCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(cmdOK, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(background1Layout.createSequentialGroup()
                        .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(background1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(expire_date, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Password2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(background1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CardNum, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, background1Layout.createSequentialGroup()
                        .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addComponent(cvv)))
                .addGap(6, 6, 6)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(togbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(togbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
            .addGroup(background1Layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(lbIcon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CardNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(togbtn1)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Password2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(togbtn2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expire_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cvv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        messageType = MessageType.CANCEL;
        closeMessage();
        this.confirmed=false;
        this.setVisible(false);
        //this.dispose();
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void cmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOKActionPerformed

        char[] passChars = Password.getPassword();
        String pass = new String(passChars);
        char[] passChars2 = Password2.getPassword();
        String pass2 = new String(passChars2);
        if(pass2.equals(pass))
        {
            messageType = MessageType.OK;
            closeMessage();
            this.confirmed=true;
            this.setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"password are not matched\nmatch passwords.");
            
        }
    }//GEN-LAST:event_cmdOKActionPerformed

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

    public static enum MessageType {
        CANCEL, OK
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField CardNum;
    public javax.swing.JPasswordField Password;
    public javax.swing.JPasswordField Password2;
    private javaswingdev.message.Background background1;
    private javaswingdev.swing.ButtonCustom cmdCancel;
    private javaswingdev.swing.ButtonCustom cmdOK;
    public javax.swing.JTextField cvv;
    public org.jdesktop.swingx.JXDatePicker expire_date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JToggleButton togbtn1;
    private javax.swing.JToggleButton togbtn2;
    // End of variables declaration//GEN-END:variables
}
