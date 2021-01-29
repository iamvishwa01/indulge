import net.proteanit.sql.DbUtils;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
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
/**
 * @author lenovo
 */
public class itemwiserep extends javax.swing.JFrame {
private static itemwiserep objbitemwise=null;

             public itemwiserep() {
        initComponents();
         setTitle("Item Wise Report");
         setLocation(400,100);
          setResizable(false);
          setSize(483,577);
      initialize();
      time();
      date();
      jTable1.setEnabled(false);
    }
 private void initialize() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
    }
        public void date()
    {
       String tdate =new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH).format(new Date());
       date.setText(""+tdate);
    }
        public static itemwiserep getObj(){
   if(objbitemwise==null){
       objbitemwise=new itemwiserep();
   } 
   return objbitemwise;
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
     public void close(){
 WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
   }
         public void getAmtSum()
     {
         int sum=0;
         for(int i=0; i< jTable1.getRowCount();i++)
         {
             sum=sum+Integer.parseInt(jTable1.getValueAt(i,3).toString());
         }
         tamt.setText(Integer.toString(sum));
     }
         public void getQtySum()
     {
         int sum=0;
         for(int i=0; i< jTable1.getRowCount();i++)
         {
             sum=sum+Integer.parseInt(jTable1.getValueAt(i,2).toString());
         }
         totalqty.setText(Integer.toString(sum));
     }

    private void itemwiseprint(){
        int rows=jTable1.getRowCount();
                for(int row = 0; row<rows; row++)
               {
    
    int icod = (int)jTable1.getValueAt(row,0);
    String inam = (String) jTable1.getValueAt(row,1);
    BigDecimal sumqty =(BigDecimal)jTable1.getValueAt(row,2);
    BigDecimal sumamt = (BigDecimal)jTable1.getValueAt(row,3);

            String item_code=Integer.toString(icod);
            String dateget=String.format(date.getText());
            String timeget=String.format(time.getText());
            String item_name=new String(inam);
            String sum_qty=String.valueOf(sumqty);
            String sum_amt=String.valueOf(sumamt);
            String total_amount=new Integer(tamt.getText()).toString();
            String total_qty=new Integer(totalqty.getText()).toString();
           
        String billbody=("\n\t    ITEM WISE REPORT"+
                "\n\t        VISHWA RESTAURANT\n" +
            "\t                  LAVASA\n"+
            "\t        ART FOOD FACTORY"+   
            "\nDATE: "+dateget+"\t\t   TIME: "+timeget+
            "\n=======================================================\t"+
            "\nCODE\t\tNAME\tQTY\tAMOUNT\t"+
            "\n=======================================================\t"+
            "\n=======================================================\t"+
            "\n\t\tTOTAL\t"+total_qty+"\tRs. "+total_amount+"/-"+
            "\n\t        THANK YOU \n");
        allprint.setText(billbody);
        addprint.append("\n"+item_code+"\t"+item_name+"\t"+sum_qty+"\t"+sum_amt);
        allprint.insert(addprint.getText(),275);
    }}
        public void viewreport(){
              Date date1;
              
              date1=iwdate.getDate();
              if (date1==null) { 
                  JOptionPane.showMessageDialog(null, "You must select date first.", "Error", JOptionPane.ERROR_MESSAGE); 
                  iwdate.grabFocus(); 
}
              else{
              DateFormat df=new SimpleDateFormat("\"yyyy-MM-dd\"");
              
        iwtf.setText(df.format(iwdate.getDate()));
        String a=iwtf.getText();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=(Connection) DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/login","root","admin");
            Statement stmt=(Statement) conn.createStatement();
        String query1;
        query1 = "select code,iname, sum(qty) as total_quantity,sum(amt) as total_amount from tblvalue where date like "+a+" group by code;";
        ResultSet rs1=stmt.executeQuery(query1);
        if (!rs1.isBeforeFirst() ) {    
        JOptionPane.showMessageDialog(null, "No Records!");
        tamt.setText("");
        addprint.setText("");
        allprint.setText("");
        iwtf.setText("");
        date.setText("");
        time.setText("");
        iwdate.setCalendar(null);         
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
        getQtySum();
        }
        catch(Exception e){
        }}
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tamt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        iwdate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        totalqty = new javax.swing.JTextField();
        allprint = new javax.swing.JTextArea();
        addprint = new javax.swing.JTextArea();
        iwtf = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        time = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(432, 598));
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
        jLabel1.setText("Preview Item wise report:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(22, 13, 200, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Actions-window-close-icon (1).png"))); // NOI18N
        jButton2.setText("Close");
        jButton2.setToolTipText("Close this window.");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(310, 520, 110, 33);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/print-icon (1).png"))); // NOI18N
        jButton3.setText("Print");
        jButton3.setToolTipText("click here print the report ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(190, 520, 110, 33);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleParent(this);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 90, 460, 370);

        tamt.setEditable(false);
        tamt.setAutoscrolls(false);
        tamt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tamt.setVerifyInputWhenFocusTarget(false);
        tamt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamtActionPerformed(evt);
            }
        });
        getContentPane().add(tamt);
        tamt.setBounds(100, 470, 102, 30);
        tamt.getAccessibleContext().setAccessibleParent(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Total Sale:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 470, 68, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Choose Date:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(34, 46, 93, 33);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Actions-view-list-details-icon.png"))); // NOI18N
        jButton4.setText("View Report");
        jButton4.setToolTipText("click here to view Report.");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(60, 520, 120, 33);

        iwdate.setToolTipText("select a date.");
        getContentPane().add(iwdate);
        iwdate.setBounds(155, 51, 150, 28);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/37169943-blur-images.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 480, 580);

        totalqty.setEditable(false);
        totalqty.setAutoscrolls(false);
        totalqty.setBorder(null);
        totalqty.setEnabled(false);
        totalqty.setFocusable(false);
        totalqty.setOpaque(false);
        totalqty.setRequestFocusEnabled(false);
        totalqty.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(totalqty);
        totalqty.setBounds(235, 20, 30, 14);

        allprint.setEditable(false);
        allprint.setColumns(20);
        allprint.setRows(5);
        allprint.setAutoscrolls(false);
        allprint.setBorder(null);
        allprint.setFocusable(false);
        allprint.setOpaque(false);
        allprint.setRequestFocusEnabled(false);
        allprint.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(allprint);
        allprint.setBounds(155, 10, 30, 30);

        addprint.setEditable(false);
        addprint.setColumns(20);
        addprint.setRows(5);
        addprint.setAutoscrolls(false);
        addprint.setBorder(null);
        addprint.setEnabled(false);
        addprint.setFocusable(false);
        addprint.setOpaque(false);
        addprint.setRequestFocusEnabled(false);
        addprint.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(addprint);
        addprint.setBounds(195, 10, 30, 30);

        iwtf.setEditable(false);
        iwtf.setAutoscrolls(false);
        iwtf.setBorder(null);
        iwtf.setEnabled(false);
        iwtf.setFocusable(false);
        iwtf.setOpaque(false);
        iwtf.setRequestFocusEnabled(false);
        iwtf.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(iwtf);
        iwtf.setBounds(271, 21, 20, 18);

        date.setEditable(false);
        date.setAutoscrolls(false);
        date.setBorder(null);
        date.setEnabled(false);
        date.setFocusable(false);
        date.setOpaque(false);
        date.setRequestFocusEnabled(false);
        date.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(date);
        date.setBounds(314, 10, 30, 14);

        time.setEditable(false);
        time.setAutoscrolls(false);
        time.setBorder(null);
        time.setEnabled(false);
        time.setFocusable(false);
        time.setOpaque(false);
        time.setRequestFocusEnabled(false);
        time.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(time);
        time.setBounds(354, 20, 20, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         tamt.setText("");
        addprint.setText("");
        allprint.setText("");
        iwtf.setText("");
        date.setText("");
        time.setText("");
        iwdate.setCalendar(null);         
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        while(model.getRowCount() >0){
            for(int i=0; i<model.getRowCount();i++){
                model.removeRow(i);
            }
        }
        this.dispose();
        close();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        viewreport();
        try{
            itemwiseprint();
        }
        catch(Exception e){
        }
         try{         
                        
         allprint.print();
         }
        catch (java.awt.print.PrinterException e){
        System.err.format("No printer found" ,e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void tamtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamtActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        viewreport();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void iwdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iwdateMouseReleased
        
    }//GEN-LAST:event_iwdateMouseReleased

    private void iwdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iwdateMouseExited

    }//GEN-LAST:event_iwdateMouseExited

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jTable1.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      tamt.setText("");
        addprint.setText("");
        allprint.setText("");
        iwtf.setText("");
        date.setText("");
        time.setText("");
        iwdate.setCalendar(null);         
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        while(model.getRowCount() >0){
            for(int i=0; i<model.getRowCount();i++){
                model.removeRow(i);
            }
        }
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
            java.util.logging.Logger.getLogger(itemwiserep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(itemwiserep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(itemwiserep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(itemwiserep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new itemwiserep().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addprint;
    private javax.swing.JTextArea allprint;
    private javax.swing.JTextField date;
    private com.toedter.calendar.JDateChooser iwdate;
    private javax.swing.JTextField iwtf;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tamt;
    private javax.swing.JTextField time;
    private javax.swing.JTextField totalqty;
    // End of variables declaration//GEN-END:variables
}
