


import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


/**
 *
 * @author sujeet
 */
public class logintoindulge extends javax.swing.JFrame {
private static logintoindulge ob3=null;
    /**
     * Creates new form logintoindulge
     */
    public logintoindulge() {
        initComponents();
        setTitle("login page");
        initialize();
        setLocation(200,100);
        setSize(999,535);  
        setResizable(false);
        verifyadmincreateusermgmt.setTitle("Create New Cashier");
        verifyadmincreateusermgmt.setModal(true);
        verifyadmincreateusermgmt.setSize(357,189);
        verifyadmincreateusermgmt.setLocation(450,250);
    }
private void initialize() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
        verifyadmincreateusermgmt.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
    }
public static logintoindulge getObj(){
   if(ob3==null){
       ob3=new logintoindulge();
   } 
   return ob3;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        verifyadmincreateusermgmt = new javax.swing.JDialog();
        passsss = new javax.swing.JPasswordField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        closeeee = new javax.swing.JButton();
        loginnn = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        verifyadmincreateusermgmt.setMinimumSize(new java.awt.Dimension(360, 200));
        verifyadmincreateusermgmt.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                verifyadmincreateusermgmtWindowClosing(evt);
            }
        });
        verifyadmincreateusermgmt.getContentPane().setLayout(null);

        passsss.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        passsss.setOpaque(false);
        passsss.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passsssKeyPressed(evt);
            }
        });
        verifyadmincreateusermgmt.getContentPane().add(passsss);
        passsss.setBounds(120, 80, 150, 30);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Password");
        verifyadmincreateusermgmt.getContentPane().add(jLabel29);
        jLabel29.setBounds(40, 80, 70, 30);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Verify Yourself ");
        verifyadmincreateusermgmt.getContentPane().add(jLabel30);
        jLabel30.setBounds(30, 20, 104, 17);

        closeeee.setText("Cancel");
        closeeee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeeeeActionPerformed(evt);
            }
        });
        verifyadmincreateusermgmt.getContentPane().add(closeeee);
        closeeee.setBounds(140, 120, 80, 30);

        loginnn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Key-icon.png"))); // NOI18N
        loginnn.setBorderPainted(false);
        loginnn.setContentAreaFilled(false);
        loginnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginnnActionPerformed(evt);
            }
        });
        verifyadmincreateusermgmt.getContentPane().add(loginnn);
        loginnn.setBounds(270, 80, 57, 33);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Enter Admin password to perform this administrative task.");
        jLabel31.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        verifyadmincreateusermgmt.getContentPane().add(jLabel31);
        jLabel31.setBounds(10, 40, 350, 30);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/37169943-blur-images.png"))); // NOI18N
        verifyadmincreateusermgmt.getContentPane().add(jLabel32);
        jLabel32.setBounds(0, 0, 360, 190);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(999, 498));
        getContentPane().setLayout(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Login ");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(12, 13, 100, 50);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/adminbutton.png"))); // NOI18N
        jButton1.setText("\n");
        jButton1.setToolTipText("Click here to login as Admin.");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(67, 46, 271, 272);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/cahsier.png"))); // NOI18N
        jButton2.setToolTipText("Click here to login as Cashier.");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(356, 46, 279, 272);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/createcashier.png"))); // NOI18N
        jButton4.setText("\n");
        jButton4.setToolTipText("Click here to create a cashier account");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(653, 58, 272, 260);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Actions-window-close-icon (1).png"))); // NOI18N
        jButton3.setText("Exit");
        jButton3.setToolTipText("exit");
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(827, 434, 113, 51);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/loginwallpmain.jpeg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-7, -2, 1010, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      adminlogintest1.getObj().setVisible(true);
      this.setVisible(false);
      this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       userlogintest1.getObj().setVisible(true);
       this.setVisible(false);
     this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       System.exit(0);
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      //verifyadmincreateusermgmt f1=new verifyadmintocreateuser();
      // f1.setVisible(true);
        //this.setVisible(false);
        verifyadmincreateusermgmt.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void passsssKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passsssKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
            String sql ="Select * from admin where password = ? ";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,passsss.getText());

            ResultSet rs;
            rs = ps.executeQuery();
            if(rs.next())
            {

                useractmgmt_1 m1=new useractmgmt_1();
                this.dispose();
                m1.setVisible(true);
                m1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                verifyadmincreateusermgmt.dispose();
            }
            else if(passsss.getText().isEmpty())
            {
                String error="you did't enter ypur password  ";
                JOptionPane.showMessageDialog(null,error,"passwordfield empty",JOptionPane.ERROR_MESSAGE);
                passsss.setText("");
            }
            else
            JOptionPane.showMessageDialog(null,"passwrod is incorrect");
            passsss.setText("");

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,e);
        }
    }//GEN-LAST:event_passsssKeyPressed

    private void closeeeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeeeeActionPerformed
       verifyadmincreateusermgmt.dispose();
    }//GEN-LAST:event_closeeeeActionPerformed

    private void loginnnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginnnActionPerformed
        if(passsss.getText().isEmpty())
        {
            String error="you did't enter your password  ";
            JOptionPane.showMessageDialog(null,error,"passwordfield empty",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn;
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
                String sql ="Select * from admin where password =?";
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1,passsss.getText());

                ResultSet rs;
                rs = ps.executeQuery();
                if(rs.next())
                {

                    useractmgmt_1 m1=new useractmgmt_1();
                    this.dispose();
                    m1.setVisible(true);

                    m1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                    verifyadmincreateusermgmt.dispose();
                }
                else
                JOptionPane.showMessageDialog(null," password does not match");
                passsss.setText("");

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null ,e);
            }
        }
    }//GEN-LAST:event_loginnnActionPerformed

    private void verifyadmincreateusermgmtWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_verifyadmincreateusermgmtWindowClosing
        passsss.setText("");
    }//GEN-LAST:event_verifyadmincreateusermgmtWindowClosing

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
            java.util.logging.Logger.getLogger(logintoindulge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(logintoindulge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(logintoindulge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(logintoindulge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new logintoindulge().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeeee;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton loginnn;
    private javax.swing.JPasswordField passsss;
    private javax.swing.JDialog verifyadmincreateusermgmt;
    // End of variables declaration//GEN-END:variables
}
