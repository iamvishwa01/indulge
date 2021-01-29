import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author sujeet
 */
public class itemdatabase extends javax.swing.JFrame {
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
            String sql="select icode as Item_code,iname as Item_name,iprice as Item_price from menu";
            ResultSet rs=st.executeQuery(sql);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
            catch(Exception e)
                    {
                    JOptionPane.showMessageDialog(null, e); 
                    fetch_data();
                    
                  }
    }
    public void id_auto(){
    try{
             
        Class.forName("com.mysql.jdbc.Driver");
      
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
          Statement stmt=(Statement) conn.createStatement();
        String sql="SELECT icode from menu ORDER BY icode DESC LIMIT 1; ";
       // String sql="select invoice_no from tblvalue where invoice_no=(Select max(invoice_no) from tblvalue);";
    ResultSet rs=stmt.executeQuery(sql);
    while(rs.next()){
        if(rs.first()==false){
            icode.setText("1000");
        }
        else
        {
            rs.last();
            int set_inv=rs.getInt(1)+1;
            String no=String.valueOf(set_inv);
            int inv_next=no.length();
            for(int a=0;a<1-inv_next;a++){
              no=""+no;
            }
            icode.setText(""+no);
        }
    }
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e);
    }
    }
    public itemdatabase() {
        initComponents();
        fetch_data();
        icode.setEnabled(false);
        iname.setEnabled(false);
        iprice.setEnabled(false);
        id_auto();
        initialize();
        setSize(855,605);
        setLocation(300,50);
        setResizable(false);
    }
private void initialize() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
    }
    public void close(){
 WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        icode = new javax.swing.JTextField();
        iname = new javax.swing.JTextField();
        iprice = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        t1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Item Database");
        setAlwaysOnTop(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Item code");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(31, 114, 94, 34);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Search Items");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(470, 30, 100, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Item Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(31, 158, 94, 50);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(315, 80, 510, 430);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Price");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(35, 223, 90, 40);

        icode.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        icode.setToolTipText("Enter Item code.");
        getContentPane().add(icode);
        icode.setBounds(143, 114, 150, 34);

        iname.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        iname.setToolTipText("Enter Item Name.");
        getContentPane().add(iname);
        iname.setBounds(143, 166, 150, 36);

        iprice.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        iprice.setToolTipText("Enter price of the Item.");
        iprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipriceActionPerformed(evt);
            }
        });
        getContentPane().add(iprice);
        iprice.setBounds(143, 226, 150, 37);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Button-Add-icon.png"))); // NOI18N
        jButton1.setText("Insert");
        jButton1.setToolTipText("click here to insert.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 350, 110, 39);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/system-software-update-icon.png"))); // NOI18N
        jButton2.setText("Update");
        jButton2.setToolTipText("click here to update.");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(160, 350, 110, 39);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Trash-empty-icon (1).png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.setToolTipText("click here to delete.");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(40, 400, 110, 39);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Repeat-22-icon.png"))); // NOI18N
        jButton4.setText("Reset");
        jButton4.setToolTipText("click here to clear all textfields.");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(160, 400, 110, 39);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Actions-document-edit-icon (1).png"))); // NOI18N
        jButton5.setText("Edit");
        jButton5.setToolTipText("click to enable the below textfields.");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(184, 80, 80, 25);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setText("Close");
        jButton6.setToolTipText("close");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(745, 535, 80, 30);

        t1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        t1.setToolTipText("search in menu");
        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });
        t1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t1KeyReleased(evt);
            }
        });
        getContentPane().add(t1);
        t1.setBounds(588, 32, 121, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/37169943-blur-images.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 850, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ipriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipriceActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       icode.setEnabled(true);
        iname.setEnabled(true);
        iprice.setEnabled(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
            if(icode.getText().isEmpty()||iname.getText().isEmpty()||iprice.getText().isEmpty()){
                String err="One of the mendatory field is empty or all the fields are empty";
                JOptionPane.showMessageDialog(null,err, "Please fill all the fields ",JOptionPane.WARNING_MESSAGE);
            }
            else{
            int p= JOptionPane.showConfirmDialog(null, "Do you really want to insert?","Insert",JOptionPane.YES_NO_OPTION);
            if(p==0){
            String sql ="Insert into menu(icode,iname,iprice)values(?,?,?)";

            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,icode.getText());
            ps.setString(2,iname.getText());
            ps.setString(3,iprice.getText());
           

            ps.execute();
            fetch_data();
            id_auto();
            JOptionPane.showMessageDialog(null, "inserted successfully");
            //icode.setText("");
            iname.setText("");
            iprice.setText("");
        }
            }
        }
        catch(Exception e)
        {
            
            JOptionPane.showMessageDialog(null,"error in inserting into database");
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       //icode.setText("");
       iname.setText("");
       iprice.setText("");
       id_auto();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
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
           if(icode.getText().isEmpty()||iname.getText().isEmpty()||iprice.getText().isEmpty()){
                String err="One of the mendatory field is empty or all the fields are empty";
                JOptionPane.showMessageDialog(null,err, "Please fill all the fields ",JOptionPane.WARNING_MESSAGE);
            }
            else{
                int p= JOptionPane.showConfirmDialog(null, "Do you really want to delete?","Insert",JOptionPane.YES_NO_OPTION);
                if(p==0){
            String sql ="delete from menu where icode=?";

            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,icode.getText());

            ps.execute();
            fetch_data();
            JOptionPane.showMessageDialog(null, "deleted successfully");
            id_auto();
            //icode.setText("");
            iname.setText("");
            iprice.setText("");
        }
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          String a=icode.getText();
         String b=iname.getText();
         String c=iprice.getText();
        
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
            if(icode.getText().isEmpty()||iname.getText().isEmpty()||iprice.getText().isEmpty()){
                String err="One of the mendatory field is empty or all the fields are empty";
                JOptionPane.showMessageDialog(null,err, "Please fill all the fields ",JOptionPane.WARNING_MESSAGE);
            }
            else{
            int p= JOptionPane.showConfirmDialog(null, "Are you sure?","update",JOptionPane.YES_NO_OPTION);
            {
                if(p==0){
            String sql = "Update menu set iname='"+b+"',iprice='"+c+"' where icode='"+a+"'";

            PreparedStatement ps=conn.prepareStatement(sql);
           ps.execute();
            fetch_data();
            id_auto();
            JOptionPane.showMessageDialog(null, "updated successfully");
           // icode.setText("");
            iname.setText("");
            iprice.setText("");
        }
            }
        }}
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            //JOptionPane.showMessageDialog(null, "please check the number of product item. If one item code is already in the database then you can not save another record to database.");
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        close();        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         int SelectedRow =jTable1.getSelectedRow();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        icode.setText(model.getValueAt(SelectedRow, 0).toString());
        iname.setText(model.getValueAt(SelectedRow, 1).toString());
        iprice.setText(model.getValueAt(SelectedRow, 2).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void t1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyReleased
         String one=t1.getText();
        try {
                   Class.forName("com.mysql.jdbc.Driver");
         Connection conn;
                   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
        Statement st = conn.createStatement();
        String query = "SELECT  icode,iname,iprice  FROM menu WHERE iname LIKE '" + one + "%'";
      ResultSet rs;
        rs = st.executeQuery(query);
      jTable1.setModel(DbUtils.resultSetToTableModel(rs)); 

    conn.close();

}
     catch (Exception e) { 
        JOptionPane.showMessageDialog(null,"Got an exception!");
       
    }    
    }//GEN-LAST:event_t1KeyReleased

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t1ActionPerformed

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
            java.util.logging.Logger.getLogger(itemdatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(itemdatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(itemdatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(itemdatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new itemdatabase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField icode;
    private javax.swing.JTextField iname;
    private javax.swing.JTextField iprice;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField t1;
    // End of variables declaration//GEN-END:variables
}
