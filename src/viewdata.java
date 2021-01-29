
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sujeet
 */
public class viewdata extends javax.swing.JFrame {
    private static viewdata obj1=null;
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
            String sql="select * from menu";
            ResultSet rs=st.executeQuery(sql);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
            catch(Exception e)
                    {
                    JOptionPane.showMessageDialog(null, e); 
                    fetch_data();
                  }
    }
    public viewdata() {
        initComponents();
         setTitle("View Item Data");
         setLocation(350,100);
                 setSize(652, 551);

        initialize();
        setResizable(false);
    }
 private void initialize() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
    }
    public void close(){
 WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

    }
public static viewdata getObj(){
   if(obj1==null){
       obj1=new viewdata();
   } 
   return obj1;
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 518));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jTable1.setToolTipText("Menu database table.");
        jTable1.setOpaque(false);
        jTable1.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 50, 610, 410);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(530, 470, 90, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("SEARCH");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 10, 60, 30);

        t1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t1.setToolTipText("Search in database.");
        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });
        t1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t1KeyTyped(evt);
            }
        });
        getContentPane().add(t1);
        t1.setBounds(260, 10, 200, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/37169943-blur-images.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 660, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
fetch_data();
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       t1.setText("");
        close();
    }//GEN-LAST:event_jButton1ActionPerformed

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
        /* DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
       String search=t1.getText().toLowerCase();
       TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(model);
       jTable1.setRowSorter(tr);
       tr.setRowFilter(RowFilter.regexFilter(search));*/
    }//GEN-LAST:event_t1KeyReleased

    private void t1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyTyped
       /* String one=t1.getText();
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
       
    }  */  
    }//GEN-LAST:event_t1KeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       t1.setText("");
       this.dispose();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(viewdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewdata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField t1;
    // End of variables declaration//GEN-END:variables
}
