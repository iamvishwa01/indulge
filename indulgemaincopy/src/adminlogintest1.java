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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sujeet
 */
public class adminlogintest1 extends javax.swing.JFrame {
 
    private static adminlogintest1 obj22=null;
    public adminlogintest1() {
        initComponents();
        setTitle("Admin login");
         setLocation(330,80);
        setResizable(false);
        initialize();
        t1.setBackground(new Color(0,0,0,30));
        t2.setBackground(new Color(0,0,0,30));
        forgotadmin1.setSize(650,360);
        forgotadmin1.setLocation(400,150);
    forgotadmin1.setModal(true);
    forgotadmin1.setTitle("Recover admin password");
    }
private void initialize() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
        forgotadmin1.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
    }
public void close(){
 WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
}
   
public static adminlogintest1 getObj(){
   if(obj22==null){
       obj22=new adminlogintest1();
   } 
   return obj22;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        forgotadmin1 = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        nickname = new javax.swing.JTextField();
        favfood = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        t3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        t4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        exit1 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        forgotadmin1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                forgotadmin1WindowClosing(evt);
            }
        });
        forgotadmin1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("TeamViewer11", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("No worries! Enter your Nick name and your favourite food below ");
        forgotadmin1.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 470, 30));

        nickname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nickname.setToolTipText("Enter your nick name here.");
        nickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicknameActionPerformed(evt);
            }
        });
        forgotadmin1.getContentPane().add(nickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 210, 39));

        favfood.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        forgotadmin1.getContentPane().add(favfood, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 190, 40));

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
        forgotadmin1.getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 290, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Hey! Forgot your Password?");
        forgotadmin1.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Username ");
        forgotadmin1.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 30));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("Password");
        forgotadmin1.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 68, 30));

        t3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t3.setToolTipText("username");
        t3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t3ActionPerformed(evt);
            }
        });
        forgotadmin1.getContentPane().add(t3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 135, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 102));
        jLabel9.setText("we will show you username and Password.");
        forgotadmin1.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 330, 30));

        t4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t4.setToolTipText("password");
        forgotadmin1.getContentPane().add(t4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 135, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/blur-bg-blurred.jpg"))); // NOI18N
        forgotadmin1.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 346));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Login");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(154, 240, 242));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Admin-icon (1).png"))); // NOI18N
        jButton1.setText("Not Admin! click here.");
        jButton1.setToolTipText("If you are not an admin user then you have tosign in with user account so click here to go to user login page.");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/blur-bg-blurred.jpg"))); // NOI18N

        jButton2.setForeground(new java.awt.Color(154, 240, 242));
        jButton2.setText("forgot password!");
        jButton2.setToolTipText("forgot password click here.");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setDefaultCapable(false);
        jButton2.setFocusPainted(false);
        jButton2.setRequestFocusEnabled(false);
        jButton2.setRolloverEnabled(false);
        jButton2.setVerifyInputWhenFocusTarget(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        exit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Actions-document-edit-icon.png"))); // NOI18N
        exit1.setToolTipText("Back ");
        exit1.setBorder(null);
        exit1.setBorderPainted(false);
        exit1.setContentAreaFilled(false);
        exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit1ActionPerformed(evt);
            }
        });

        b1.setBackground(new java.awt.Color(225, 225, 225));
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
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Admin-icon (4).png"))); // NOI18N

        t1.setForeground(new java.awt.Color(131, 236, 214));
        t1.setToolTipText("username");
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

        t2.setForeground(new java.awt.Color(131, 228, 214));
        t2.setToolTipText("password");
        t2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        t2.setName("Password"); // NOI18N
        t2.setOpaque(false);
        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });
        t2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t2KeyPressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Password:");

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Username:");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(241, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 750, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel1)
                                .addGap(7, 7, 7)
                                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel2)
                                .addGap(3, 3, 3)
                                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(211, 211, 211)
                                .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 590, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
     }
 else{
        try {
                   Class.forName("com.mysql.jdbc.Driver");
         Connection conn;
                   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
             String sql ="Select * from admin where username=? and password =?";
               PreparedStatement ps=conn.prepareStatement(sql);
                 ps.setString(1,t1.getText());
                 ps.setString(2,t2.getText());
                    ResultSet rs;
                     rs = ps.executeQuery();    
            if(rs.next())
            {
                first m1=new first();
                m1.setVisible(true);
                m1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
               // t1.setText(rs.getString("username"));
                first.cashier1.setText(t1.getText());
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
        userlogintest1.getObj().setVisible(true);
        this.dispose();
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
             String sql ="Select * from admin where username=? and password =?";
               PreparedStatement ps=conn.prepareStatement(sql);
                 ps.setString(1,t1.getText());
                 ps.setString(2,t2.getText());
                    ResultSet rs;
                     rs = ps.executeQuery();    
            if(rs.next())
            {
          
                first m1=new first();
                m1.setVisible(true);
                first.cashier1.setText(t1.getText());
                this.setVisible(false);
                m1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
          
            
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
        }        // TODO add your handling code here:
    }//GEN-LAST:event_t2KeyPressed

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t2ActionPerformed

    private void t1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER)
{

               try {
                   Class.forName("com.mysql.jdbc.Driver");
         Connection conn;
                   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
             String sql ="Select * from admin where username=? and password =?";
               PreparedStatement ps=conn.prepareStatement(sql);
                 ps.setString(1,t1.getText());
                 ps.setString(2,t2.getText());
                    ResultSet rs;
                     rs = ps.executeQuery();    
            if(rs.next())
            {
          
                first m1=new first();
                m1.setVisible(true);
                first.cashier1.setText(t1.getText());
                this.setVisible(false);
                m1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
          
            
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       forgotadmin1.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            String query1="select username,password from admin where Nick_name='"+a+"' and Fav_food='"+b+"'";

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

    private void forgotadmin1WindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_forgotadmin1WindowClosing
        t3.setText("");
        t4.setText("");
        nickname.setText("");
        favfood.setText("");
    }//GEN-LAST:event_forgotadmin1WindowClosing

    private void t3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t3ActionPerformed

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
                new adminlogintest1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton exit1;
    private javax.swing.JTextField favfood;
    private javax.swing.JDialog forgotadmin1;
    public static javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nickname;
    private javax.swing.JTextField t1;
    private javax.swing.JPasswordField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    // End of variables declaration//GEN-END:variables
}
