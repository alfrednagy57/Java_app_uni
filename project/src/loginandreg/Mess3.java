package loginandreg;

//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.text.SimpleDateFormat;
//import javax.swing.JDialog;
import javax.swing.JFrame;
//import javax.swing.Timer;
//import javax.swing.text.SimpleAttributeSet;
//import javax.swing.text.StyleConstants;
//import javax.swing.text.StyledDocument;
import Classes.Glass;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;



public class Mess3 extends javax.swing.JDialog {

    private final JFrame frame;
    private final Glass glass;
    private boolean show;
    private MessageType messageType = MessageType.CANCEL;
    private Animator animator;
    
    public boolean confirmed;
    
    public Mess3(JFrame frame) {
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
        txt.setText(message);
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
        cmdOK = new javaswingdev.swing.ButtonCustom();
        lbTitle = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();
        txt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        background1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

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

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/icon.png"))); // NOI18N

        txt.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txt.setForeground(new java.awt.Color(245, 71, 71));
        txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt.setText("Message Title");

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(background1Layout.createSequentialGroup()
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(background1Layout.createSequentialGroup()
                        .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(background1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(background1Layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(lbIcon)))
                        .addGap(0, 83, Short.MAX_VALUE)))
                .addContainerGap())
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void cmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOKActionPerformed
        messageType = MessageType.OK;
        closeMessage();
        this.confirmed=true;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_cmdOKActionPerformed

    public static enum MessageType {
        CANCEL, OK
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaswingdev.message.Background background1;
    private javaswingdev.swing.ButtonCustom cmdOK;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables
}
