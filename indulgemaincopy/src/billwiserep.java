
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author sujeet
 */
public class billwiserep extends javax.swing.JFrame {
private static billwiserep objbillwise=null;

    public billwiserep() {
        initComponents();
        setTitle("Bill Wise Report");
        setLocation(400,100);
         setSize(461,600);
        setResizable(false);
       
        initialize();
        date();
        time();
       
jTable1.setEnabled(false);
    }
 private void initialize() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
        
    }
    public void close(){
 WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
   }
    public void date()
    {
       String tdate =new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH).format(new Date());
       date.setText(""+tdate);
    }
    //time
     public void time()
   {
   new Timer(0,new ActionListener(){
       @Override
       public void actionPerformed(ActionEvent ae) {
          java.text.SimpleDateFormat ad = new java.text.SimpleDateFormat("HH:mm:ss");
          String ttime = ad.format(new Date());
       time.setText("" + ttime);
       }
           }).start();
   }
public static billwiserep getObj(){
   if(objbillwise==null){
       objbillwise=new billwiserep();
   } 
   return objbillwise;
}
     public void getAmtSum()
     {
         int sum=0;
         for(int i=0; i< jTable1.getRowCount();i++)
         {
             sum=sum+Integer.parseInt(jTable1.getValueAt(i,1).toString());
         }
         tamt.setText(Integer.toString(sum));
     }
        private void billwiseprint(){
        int rows=jTable1.getRowCount();
                for(int row = 0; row<rows; row++)
               {
    
    int invno = (int)jTable1.getValueAt(row,0);
    int amt = (int)jTable1.getValueAt(row,1);
            String dateget=String.format(date.getText());
            String timeget=String.format(time.getText());
            String invoiceno=new Integer(invno).toString();
            String item_amt=new Integer(amt).toString();
            String total_amount=new Integer(tamt.getText()).toString();
           
        String billbody=("\n\t\tVISHWA RESTAURANT\n" +
            "\t\t          LAVASA\n"+
            "\t\tART FOOD FACTORY\n"+   
            "DATE: "+dateget+"\t\t   TIME: "+timeget+
            "\n=======================================================\t"+
            "\nBILL NO\t\t\tAMOUNT\t"+
            "\n=======================================================\t"+
            "\n=======================================================\t"+
            "\nTOTAL\t\t\tRs. "+total_amount+"/-"+
            "\n\t        THANK YOU \n");
        billpreview.setText(billbody);
        billtextar.append("\n"+invoiceno+"\t\t\t"+item_amt);
        billpreview.insert(billtextar.getText(),224);

    }}
            public void viewreport(){
              Date date1;
              
              date1=bwdate.getDate();
              if (date1==null) { 
                  JOptionPane.showMessageDialog(null, "You must select date first.", "Error", JOptionPane.ERROR_MESSAGE); 
                  bwdate.grabFocus(); 
}
              else{
              DateFormat df=new SimpleDateFormat("\"yyyy-MM-dd\"");
              
        bwtf.setText(df.format(bwdate.getDate()));
        String a=bwtf.getText();
            
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=(Connection) DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/login","root","admin");
            Statement stmt=(Statement) conn.createStatement();
        String query1;
        query1 = "select invoice_no,total_amt from tblvalue where date like "+a+" group by invoice_no;";
        ResultSet rs1=stmt.executeQuery(query1);
        if (!rs1.isBeforeFirst() ) {    
        JOptionPane.showMessageDialog(null, "No Records!");
        tamt.setText("");
        billtextar.setText("");
        billpreview.setText("");
        bwtf.setText("");
        date.setText("");
        time.setText("");
        bwdate.setCalendar(null);         
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        while(model.getRowCount() >0){
            for(int i=0; i<model.getRowCount();i++){
                model.removeRow(i);
            }
        }
        
        }
        else{
        jTable1.setModel(DbUtils.resultSetToTableModel(rs1));
        
        }}
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        }
            try{
        getAmtSum();
        }
        catch(Exception e){
        }}
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tamt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        bwdate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        billpreview = new javax.swing.JTextArea();
        date = new javax.swing.JTextField();
        time = new javax.swing.JTextField();
        billtextar = new javax.swing.JTextArea();
        bwtf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BIll");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Preview BIll wise report:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 180, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Actions-window-close-icon (1).png"))); // NOI18N
        jButton2.setText("Close");
        jButton2.setToolTipText("close this window.");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(290, 520, 100, 33);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/print-icon (1).png"))); // NOI18N
        jButton3.setText("Print");
        jButton3.setToolTipText("click to print Report.");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(190, 520, 100, 33);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(12, 89, 430, 375);

        tamt.setEditable(false);
        tamt.setToolTipText("");
        tamt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(tamt);
        tamt.setBounds(94, 476, 130, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Total Sale:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(22, 470, 68, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Choose Date:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(36, 40, 93, 31);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Actions-view-list-details-icon.png"))); // NOI18N
        jButton4.setText("View Report");
        jButton4.setToolTipText("click to view Report.");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(70, 520, 120, 33);

        bwdate.setToolTipText(" select a date.");
        getContentPane().add(bwdate);
        bwdate.setBounds(150, 40, 150, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/37169943-blur-images.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 460, 580);

        billpreview.setEditable(false);
        billpreview.setColumns(20);
        billpreview.setRows(5);
        billpreview.setAutoscrolls(false);
        billpreview.setBorder(null);
        billpreview.setEnabled(false);
        billpreview.setFocusable(false);
        billpreview.setOpaque(false);
        billpreview.setRequestFocusEnabled(false);
        billpreview.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(billpreview);
        billpreview.setBounds(178, 13, 25, 21);

        date.setEditable(false);
        date.setAutoscrolls(false);
        date.setBorder(null);
        date.setEnabled(false);
        date.setFocusable(false);
        date.setOpaque(false);
        date.setRequestFocusEnabled(false);
        date.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(date);
        date.setBounds(261, 13, 26, 14);

        time.setEditable(false);
        time.setAutoscrolls(false);
        time.setBorder(null);
        time.setEnabled(false);
        time.setFocusable(false);
        time.setOpaque(false);
        time.setRequestFocusEnabled(false);
        time.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(time);
        time.setBounds(294, 13, 21, 14);

        billtextar.setEditable(false);
        billtextar.setColumns(20);
        billtextar.setRows(5);
        billtextar.setAutoscrolls(false);
        billtextar.setBorder(null);
        billtextar.setEnabled(false);
        billtextar.setFocusable(false);
        billtextar.setOpaque(false);
        billtextar.setRequestFocusEnabled(false);
        billtextar.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(billtextar);
        billtextar.setBounds(206, 10, 20, 20);

        bwtf.setEditable(false);
        bwtf.setAutoscrolls(false);
        bwtf.setBorder(null);
        bwtf.setEnabled(false);
        bwtf.setFocusable(false);
        bwtf.setOpaque(false);
        bwtf.setRequestFocusEnabled(false);
        bwtf.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(bwtf);
        bwtf.setBounds(236, 13, 19, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            viewreport();
        try{
            billwiseprint();
        }
        catch(Exception e){
        }
         try{         
                        
         billpreview.print();
         }
        catch (java.awt.print.PrinterException e){
        System.err.format("No printer found" ,e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      tamt.setText("");
        billtextar.setText("");
        billpreview.setText("");
        bwtf.setText("");
        date.setText("");
        time.setText("");
        bwdate.setCalendar(null);         
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        while(model.getRowCount() >0){
            for(int i=0; i<model.getRowCount();i++){
                model.removeRow(i);
            }
        } 
        close();
       this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        viewreport();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     
    }//GEN-LAST:event_jTable1MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      tamt.setText("");
        billtextar.setText("");
        billpreview.setText("");
        bwtf.setText("");
        date.setText("");
        time.setText("");
        bwdate.setCalendar(null);         
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        while(model.getRowCount() >0){
            for(int i=0; i<model.getRowCount();i++){
                model.removeRow(i);
            }
        } 
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(billwiserep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(billwiserep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(billwiserep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(billwiserep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new billwiserep().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea billpreview;
    private javax.swing.JTextArea billtextar;
    private com.toedter.calendar.JDateChooser bwdate;
    private javax.swing.JTextField bwtf;
    private javax.swing.JTextField date;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tamt;
    private javax.swing.JTextField time;
    // End of variables declaration//GEN-END:variables
}
