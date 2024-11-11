package loginandreg;

import javax.swing.JFrame;
import Classes.Glass;
import java.awt.Desktop;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;


public class mail extends javax.swing.JDialog {

    private final JFrame frame;
    private final Glass glass;
    private boolean show;
    private MessageType messageType = MessageType.CANCEL;
    private Animator animator;
    
    public boolean confirmed;
    
    public mail(JFrame frame) {
        super(frame, true);
        this.frame = frame;
        initComponents();
        init();
        glass = new Glass();
    }
    private void openEmailClient(String emailAddress) {
            if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.MAIL)) {
                try {
                    URI mailtoUri = new URI(emailAddress);
                    desktop.mail(mailtoUri);
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Failed to open email client: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Email client is not supported on this system.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Desktop is not supported on this system.", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        lbIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        background1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        cmdOK.setText("Mail");
        cmdOK.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        cmdOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOKActionPerformed(evt);
            }
        });

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/icon.png"))); // NOI18N

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(background1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(lbIcon)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOKActionPerformed
        openEmailClient("mailto:easy.bank23@gmail.com");

    // Set message type
    messageType = MessageType.OK;

    // Close message
    closeMessage();

    // Set confirmed to true
    this.confirmed = true;

    // Hide and dispose of the window
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
    // End of variables declaration//GEN-END:variables
}
