
import java.awt.Color;
import java.sql.Connection;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
/**
 *
 * @author sujeet
 */
public class useractmgmt_1 extends javax.swing.JFrame {
String host="jdbc:mysql://localhost:3306/login";
String username="root";
String password="admin";
Statement st=null;
public void connection() throws ClassNotFoundException
{
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
}
    public void connection1()
    {
        try{
            connection();
            Connection conn=DriverManager.getConnection(host,username,password);
            st=conn.createStatement();
        }
        catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e);
    }
    }
    public void fetch_data()
    {
        try{
            
            connection1();
            String sql="select * from user";
            ResultSet rs=st.executeQuery(sql);
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        }
            catch(Exception e)
                    {
                    JOptionPane.showMessageDialog(null, e); 
                    fetch_data();
                  }
    }
    public useractmgmt_1() {
        initComponents();
        setResizable(false);
        setTitle("Cashier Account Management");
        initialize();
        setLocation(150,40);
        setSize(1067,660);
   }
private void initialize() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        upass = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        eid = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        ufood = new javax.swing.JTextField();
        uname = new javax.swing.JTextField();
        spin = new javax.swing.JTextField();
        nname = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        mono = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        address1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1070, 657));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Button-Add-icon.png"))); // NOI18N
        jButton1.setText("Insert");
        jButton1.setToolTipText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 560, 110, 31);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Trash-empty-icon (1).png"))); // NOI18N
        jButton2.setText("Delete");
        jButton2.setToolTipText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(130, 560, 110, 31);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/system-software-update-icon.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.setToolTipText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(20, 590, 110, 31);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/User-New-icon.png"))); // NOI18N
        jButton4.setText("New");
        jButton4.setToolTipText("Reset all field .");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(130, 590, 110, 31);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Password", "fav_food", "emailID", "PIN", "Name", "Nick name", "Mobile No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setToolTipText("User Accounts Database Table");
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(6).setResizable(false);
            jTable2.getColumnModel().getColumn(7).setResizable(false);
            jTable2.getColumnModel().getColumn(8).setResizable(false);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(350, 110, 680, 430);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Email-ID");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(20, 320, 70, 14);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Id");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 160, 40, 20);

        upass.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        upass.setToolTipText("Enter password here.");
        getContentPane().add(upass);
        upass.setBounds(130, 230, 194, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 200, 70, 14);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Mobile No");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(20, 480, 80, 14);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 240, 70, 14);

        eid.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        eid.setToolTipText("Enter EmailID here.");
        getContentPane().add(eid);
        eid.setBounds(130, 310, 194, 30);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setText("Back to main page");
        jButton7.setToolTipText("Click here to go to main page");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(890, 583, 140, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Favourite food");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 280, 90, 14);

        id.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        id.setToolTipText("Enter  ID here.");
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });
        getContentPane().add(id);
        id.setBounds(130, 150, 194, 30);

        ufood.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ufood.setToolTipText("Enter favourite food here.");
        getContentPane().add(ufood);
        ufood.setBounds(130, 270, 194, 30);

        uname.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        uname.setToolTipText("Enter  Username here.");
        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });
        getContentPane().add(uname);
        uname.setBounds(130, 190, 194, 30);

        spin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        spin.setToolTipText("Enter security PIN.");
        spin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spinActionPerformed(evt);
            }
        });
        spin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spinKeyTyped(evt);
            }
        });
        getContentPane().add(spin);
        spin.setBounds(130, 350, 194, 30);

        nname.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nname.setToolTipText("Enter NIck name here");
        nname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nnameActionPerformed(evt);
            }
        });
        getContentPane().add(nname);
        nname.setBounds(130, 430, 194, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("security PIN");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(20, 360, 80, 14);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Name");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 400, 80, 14);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Nick name");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(20, 440, 80, 14);

        name.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        name.setToolTipText("Enter full name here");
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        getContentPane().add(name);
        name.setBounds(130, 390, 194, 30);

        mono.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mono.setToolTipText("Enter Mobile no.");
        mono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                monoKeyTyped(evt);
            }
        });
        getContentPane().add(mono);
        mono.setBounds(130, 470, 194, 30);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Provide details below.");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(12, 123, 132, 14);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/users-icon (2).png"))); // NOI18N
        jLabel5.setText("User Account Management");
        jLabel5.setToolTipText("Create user account and manage users.");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(36, 33, 410, 48);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Address");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 520, 70, 20);

        address1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        address1.setToolTipText("Enter address here.");
        getContentPane().add(address1);
        address1.setBounds(130, 510, 200, 30);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/37169943-blur-images.png"))); // NOI18N
        jLabel20.setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().add(jLabel20);
        jLabel20.setBounds(0, 0, 1070, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if(id.getText().isEmpty()||ufood.getText().isEmpty()||uname.getText().isEmpty()||
        spin.getText().isEmpty()||upass.getText().isEmpty()||nname.getText().isEmpty()||mono.getText().isEmpty()||
        name.getText().isEmpty()||eid.getText().isEmpty()||address1.getText().isEmpty())
{
    JOptionPane.showMessageDialog(null,"some of the field is empty. please fill all the field");
}
    else{
            
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
           
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
        } catch (SQLException ex) {
            
        }
        try{
            int p=JOptionPane.showConfirmDialog(null, "Is that right ?","Insert",JOptionPane.YES_NO_OPTION);
            if(p==0)
            {
            String sql ="Insert into user(id,username,password,Fav_food,emailID,SPIN,Name,Nick_name,mobileNO,address)values(?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,id.getText());
            ps.setString(2,uname.getText());
            ps.setString(3,upass.getText());
            ps.setString(4,ufood.getText());
            ps.setString(5,eid.getText());
            ps.setString(6,spin.getText());
            ps.setString(7,name.getText());
            ps.setString(8,nname.getText());
            ps.setString(9,mono.getText());
            ps.setString(10,address1.getText());
            ps.execute();
            fetch_data();
            
            JOptionPane.showMessageDialog(null, "inserted successfully");
        }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            fetch_data();
        }
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
           
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
        } catch (SQLException ex) {
          
        }
        try{
            int p=JOptionPane.showConfirmDialog(null, "Is that right ?","Insert",JOptionPane.YES_NO_OPTION);
            if(p==0)
            {
            String sql ="delete from user where id=?";

            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,id.getText());

            ps.execute();
            fetch_data();
            
            JOptionPane.showMessageDialog(null, "deleted successfully");
        }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            fetch_data();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         String a=id.getText();
         String b=uname.getText();
         String c=upass.getText();
         String d=ufood.getText();
         String e=eid.getText();
         String f=spin.getText();
         String g=name.getText();
         String h=nname.getText();
         String i=mono.getText();
         String j=address1.getText();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
           
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
        } catch (SQLException ex) {
            Logger.getLogger(adminactmgmt.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            int p= JOptionPane.showConfirmDialog(null, "Are you sure?","update",JOptionPane.YES_NO_OPTION);
            {
                if(p==0){
            String sql = "Update user set username='"+b+"',password='"+c+"',Fav_food='"+d+"',emailID='"+e+"',SPIN='"+f+"',Name='"+g+"',Nick_name='"+h+"',mobileNO='"+i+"',address='"+j+"' where id='"+a+"'";

            PreparedStatement ps=conn.prepareStatement(sql);
           ps.execute();
            fetch_data();
            JOptionPane.showMessageDialog(null, "updated successfully");
        }
                        fetch_data();

        }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex);
            //JOptionPane.showMessageDialog(null, "please check the number of product item. If one item code is already in the database then you can not save another record to database.");
        
        }
  fetch_data();
    
    }//GEN-LAST:event_jButton3ActionPerformed
public void close(){
 WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
}
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        id.setText("");
        ufood.setText("");
        uname.setText("");
        spin.setText("");
        upass.setText("");
        nname.setText("");
        mono.setText("");
        name.setText("");
        eid.setText("");
        address1.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int SelectedRow =jTable2.getSelectedRow();
        DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
        id.setText(model.getValueAt(SelectedRow, 0).toString());
        uname.setText(model.getValueAt(SelectedRow, 1).toString());
        upass.setText(model.getValueAt(SelectedRow, 2).toString());
        ufood.setText(model.getValueAt(SelectedRow, 3).toString());
        eid.setText(model.getValueAt(SelectedRow, 4).toString());
        spin.setText(model.getValueAt(SelectedRow, 5).toString());
        name.setText(model.getValueAt(SelectedRow,6).toString());
        nname.setText(model.getValueAt(SelectedRow, 7).toString());
        mono.setText(model.getValueAt(SelectedRow, 8).toString());
         address1.setText(model.getValueAt(SelectedRow, 9).toString());
         
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameActionPerformed

    }//GEN-LAST:event_unameActionPerformed

    private void spinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spinActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        fetch_data();
    }//GEN-LAST:event_formWindowOpened

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void nnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nnameActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
        char c=evt.getKeyChar();
        if(!Character.isDigit(c)||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE)
        {
            evt.consume();
        }
    }//GEN-LAST:event_idKeyTyped

    private void monoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_monoKeyTyped
        char c=evt.getKeyChar();
        if(!Character.isDigit(c)||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE)
        {
            evt.consume();
        }
    }//GEN-LAST:event_monoKeyTyped

    private void spinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spinKeyTyped
       char c=evt.getKeyChar();
        if(!Character.isDigit(c)||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE)
        {
            evt.consume();
        }
    }//GEN-LAST:event_spinKeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        logintoindulge.getObj().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(useractmgmt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(useractmgmt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(useractmgmt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(useractmgmt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new useractmgmt_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address1;
    private javax.swing.JTextField eid;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField mono;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nname;
    private javax.swing.JTextField spin;
    private javax.swing.JTextField ufood;
    private javax.swing.JTextField uname;
    private javax.swing.JTextField upass;
    // End of variables declaration//GEN-END:variables
}
