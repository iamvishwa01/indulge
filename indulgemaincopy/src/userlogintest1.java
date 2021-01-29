import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;



/**
 *
 * @author sujeet
 */
public class userlogintest1 extends javax.swing.JFrame {
private static userlogintest1 objt1=null;
   
    public userlogintest1() {
        initComponents();
        setTitle("Cashier login");
         setLocation(350,100);
         setResizable(false);
         setSize(724,565);
        initialize();
        t1.setBackground(new Color(0,0,0,30));
        t2.setBackground(new Color(0,0,0,30));
    forgotcashier.setModal(true);
    forgotcashier.setLocation(400,180);
    forgotcashier.setTitle("Recover cashier password");
    forgotcashier.setSize(644,360);
    }
private void initialize() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
        forgotcashier.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
    }
public void close(){
 WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
}
   public static userlogintest1 getObj(){
   if(objt1==null){
       objt1=new userlogintest1();
   } 
   return objt1;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        forgotcashier = new javax.swing.JDialog();
        jLabel11 = new javax.swing.JLabel();
        nickname = new javax.swing.JTextField();
        favfood = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        t3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        t4 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        exit1 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        forgotcashier.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                forgotcashierWindowClosing(evt);
            }
        });
        forgotcashier.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("TeamViewer11", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 102));
        jLabel11.setText("No worries! Enter your Nick name and your favourite food below ");
        forgotcashier.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 470, 30));

        nickname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nickname.setToolTipText("Enter your nick name here.");
        nickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicknameActionPerformed(evt);
            }
        });
        forgotcashier.getContentPane().add(nickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 210, 39));

        favfood.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        forgotcashier.getContentPane().add(favfood, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 190, 40));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(10, 7, 97));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Apps-system-software-update-icon (1).png"))); // NOI18N
        jButton4.setText("Generate username & password");
        jButton4.setToolTipText("click here to retrieve username & password");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        forgotcashier.getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 290, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setText("Hey! Forgot your Password?");
        forgotcashier.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 0));
        jLabel14.setText("Username ");
        forgotcashier.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 30));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 0));
        jLabel15.setText("Password");
        forgotcashier.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 68, 30));

        t3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t3.setToolTipText("username");
        t3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t3ActionPerformed(evt);
            }
        });
        forgotcashier.getContentPane().add(t3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 135, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 102));
        jLabel16.setText("we will show you username and Password.");
        forgotcashier.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 330, 30));

        t4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t4.setToolTipText("password");
        forgotcashier.getContentPane().add(t4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 135, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/blur-bg-blurred.jpg"))); // NOI18N
        forgotcashier.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 346));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(172, 247, 170));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Admin-icon (1).png"))); // NOI18N
        jButton1.setText("Not User! click here.");
        jButton1.setToolTipText("If you are not an Cashier then you have to sign in with admin account so click here to go to admin login page.");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/user bg.jpg"))); // NOI18N

        exit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Actions-document-edit-icon.png"))); // NOI18N
        exit1.setToolTipText("Back to main page.");
        exit1.setBorder(null);
        exit1.setBorderPainted(false);
        exit1.setContentAreaFilled(false);
        exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit1ActionPerformed(evt);
            }
        });

        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Key-icon.png"))); // NOI18N
        b1.setToolTipText("login");
        b1.setBorder(null);
        b1.setContentAreaFilled(false);
        b1.setFocusPainted(false);
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/users-icon3.png"))); // NOI18N

        t1.setForeground(new java.awt.Color(136, 229, 120));
        t1.setToolTipText("Enter Username here.");
        t1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        t1.setOpaque(false);
        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });
        t1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t1KeyPressed(evt);
            }
        });

        t2.setForeground(new java.awt.Color(125, 231, 118));
        t2.setToolTipText("Enter password here.");
        t2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        t2.setName("Password"); // NOI18N
        t2.setOpaque(false);
        t2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t2KeyPressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Password:");

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Username:");

        jLabel3.setForeground(new java.awt.Color(147, 242, 175));
        jLabel3.setText("forgot password!");
        jLabel3.setToolTipText("Forgot your password?Click here to recover.");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Actions-window-close-icon (1).png"))); // NOI18N
        jButton3.setToolTipText("Close");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(448, 448, 448)
                                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(223, 223, 223)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(298, 298, 298)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(395, 395, 395)
                                .addComponent(jLabel3)))
                        .addGap(0, 153, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jLabel3)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
 if(t1.getText().isEmpty())
     {
        String error="you did't enter your username  ";
                      JOptionPane.showMessageDialog(null,error,"usernamefield empty",JOptionPane.ERROR_MESSAGE);
                      
     }
 else if(t2.getText().isEmpty())
     {
        String error="you did't enter your password  ";
                      JOptionPane.showMessageDialog(null,error,"passwordfield empty",JOptionPane.ERROR_MESSAGE);
                      t1.setFocusable(true);
     }
 else{
        try {
                   Class.forName("com.mysql.jdbc.Driver");
         Connection conn;
                   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
             String sql ="Select * from user where username=? and password =?";
               PreparedStatement ps=conn.prepareStatement(sql);
                 ps.setString(1,t1.getText());
                 ps.setString(2,t2.getText());
                    ResultSet rs;
                     rs = ps.executeQuery();    
            if(rs.next())
            {
          
                cashierhomepage uhp=new cashierhomepage();
                uhp.setVisible(true);
                uhp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                cashierhomepage.cashier1.setText(t1.getText());
             this.setVisible(false);
            }
            else
                JOptionPane.showMessageDialog(null,"username & password does not match");
        t1.setText("");
        t2.setText("");
               }
        catch(Exception e)
                {
                JOptionPane.showMessageDialog(null ,e);
                }
    
            }
    }//GEN-LAST:event_b1ActionPerformed

    private void exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit1ActionPerformed
        logintoindulge.getObj().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_exit1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        adminlogintest1.getObj().setVisible(true);
        this.dispose();
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        forgotcashier.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        
    }//GEN-LAST:event_formWindowDeactivated

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t1ActionPerformed

    private void t2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t2KeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{

               try {
                   Class.forName("com.mysql.jdbc.Driver");
         Connection conn;
                   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
             String sql ="Select * from user where username=? and password =?";
               PreparedStatement ps=conn.prepareStatement(sql);
                 ps.setString(1,t1.getText());
                 ps.setString(2,t2.getText());
                    ResultSet rs;
                     rs = ps.executeQuery();    
            if(rs.next())
            {
          
                cashierhomepage uhp=new cashierhomepage();
                uhp.setVisible(true);
                cashierhomepage.cashier1.setText(t1.getText());
                this.setVisible(false);
                uhp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
          
            
            }
            else if(t1.getText().isEmpty())
            {
               String error="you did't enter your username  ";
                      JOptionPane.showMessageDialog(null,error,"usernamefield empty",JOptionPane.ERROR_MESSAGE); 
           }
            else if(t2.getText().isEmpty())
            {
                 String error="you did't enter your password  ";
                      JOptionPane.showMessageDialog(null,error,"passwordfield empty",JOptionPane.ERROR_MESSAGE);
            }
            
            else
                JOptionPane.showMessageDialog(null,"username & password does not match");
        t1.setText("");
        t2.setText("");
               }
        catch(Exception e)
                {
              JOptionPane.showMessageDialog(null ,e);
                }
        }       
    }//GEN-LAST:event_t2KeyPressed

    private void t1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{

               try {
                   Class.forName("com.mysql.jdbc.Driver");
         Connection conn;
                   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
             String sql ="Select * from user where username=? and password =?";
               PreparedStatement ps=conn.prepareStatement(sql);
                 ps.setString(1,t1.getText());
                 ps.setString(2,t2.getText());
                    ResultSet rs;
                     rs = ps.executeQuery();    
            if(rs.next())
            {
          
                cashierhomepage uhp=new cashierhomepage();
                uhp.setVisible(true);
                cashierhomepage.cashier1.setText(t1.getText());
                this.setVisible(false);
                uhp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
          
            
            }
            else if(t1.getText().isEmpty())
            {
               String error="you did't enter your username  ";
                      JOptionPane.showMessageDialog(null,error,"usernamefield empty",JOptionPane.ERROR_MESSAGE); 
           }
            else if(t2.getText().isEmpty())
            {
                 String error="you did't enter your password  ";
                      JOptionPane.showMessageDialog(null,error,"passwordfield empty",JOptionPane.ERROR_MESSAGE);
            }
            
            else
                JOptionPane.showMessageDialog(null,"username & password does not match");
        t1.setText("");
        t2.setText("");
       
               }
        catch(Exception e)
                {
                JOptionPane.showMessageDialog(null ,e);
                }
        }
    }//GEN-LAST:event_t1KeyPressed

    private void nicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicknameActionPerformed

    }//GEN-LAST:event_nicknameActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(nickname.getText().isEmpty()&&favfood.getText().isEmpty()){
            String err="you did not provide nickname and favourite food";
            JOptionPane.showMessageDialog(null,err,"empty textfields",JOptionPane.WARNING_MESSAGE);
        }
        else if(nickname.getText().isEmpty())
        {
            String err="Please entere your nick name";
            JOptionPane.showMessageDialog(null,err,"empty textfields",JOptionPane.WARNING_MESSAGE);
        }
        else if(favfood.getText().isEmpty()){
            String err="Please entere your favourite food";
            JOptionPane.showMessageDialog(null,err,"empty textfields",JOptionPane.WARNING_MESSAGE);
        }
        else{
            String a=nickname.getText();
            String b=favfood.getText();

            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=(Connection) DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/login","root","admin");
                Statement stmt=(Statement) conn.createStatement();
                String query1="select username,password from user where Nick_name='"+a+"' and Fav_food='"+b+"'";

                ResultSet rs1=stmt.executeQuery(query1);

                if(rs1.first())
                {
                    t3.setText(rs1.getString("username"));
                    t4.setText(rs1.getString("password"));
                    this.setVisible(true);

                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Nick_name is incorrect");
                    nickname.setText("");
                    favfood.setText("");
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void t3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t3ActionPerformed

    private void forgotcashierWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_forgotcashierWindowClosing
        t3.setText("");
        t4.setText("");
        nickname.setText("");
        favfood.setText("");
    }//GEN-LAST:event_forgotcashierWindowClosing

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
            java.util.logging.Logger.getLogger(adminlogintest1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminlogintest1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminlogintest1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminlogintest1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userlogintest1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton exit1;
    private javax.swing.JTextField favfood;
    private javax.swing.JDialog forgotcashier;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nickname;
    private javax.swing.JTextField t1;
    private javax.swing.JPasswordField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    // End of variables declaration//GEN-END:variables
}
