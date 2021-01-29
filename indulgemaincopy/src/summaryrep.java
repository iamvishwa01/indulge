
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
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
public class summaryrep extends javax.swing.JFrame {
private static summaryrep objsumm=null;
     public summaryrep() {
        initComponents();
        initialize();
        setSize(818,458);
        setTitle("Summary Report");
        setLocation(300,150);
        time();
        date();
        setResizable(false);
          
    }
private void initialize() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
    }
    public void date()
    {
       String tdate =new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH).format(new Date());
       date.setText(""+tdate);
    }
    public static summaryrep getObj(){
   if(objsumm==null){
       objsumm=new summaryrep();
   } 
   return objsumm;
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
             sum=sum+Integer.parseInt(jTable1.getValueAt(i,1).toString());
         }
         tamt.setText(Integer.toString(sum));
     }
        private void summaryprint(){
        int rows=jTable1.getRowCount();
                for(int row = 0; row<rows; row++)
               {
    
    Date dateno = (Date)jTable1.getValueAt(row,0);
    BigDecimal amt = (BigDecimal)jTable1.getValueAt(row,1);
            String dateget=String.format(date.getText());
            String timeget=String.format(time.getText());
            String dateno1=String.valueOf(dateno);
            String item_amt=String.valueOf(amt);
            String total_amount=new Integer(tamt.getText()).toString();
           
        String billbody=("\n\t\tVISHWA RESTAURANT\n" +
            "\t\t          LAVASA\n"+
            "\t\tART FOOD FACTORY\n"+   
            "DATE: "+dateget+"\t\t   TIME: "+timeget+
            "\n=======================================================\t"+
            "\nDATE\t\t\tAMOUNT\t"+
            "\n=======================================================\t"+
            "\n=======================================================\t"+
            "\nTOTAL\t\t\tRs. "+total_amount+"/-"+
            "\n\t        THANK YOU \n");
        summarytext.setText(billbody);
        summarybody.append("\n"+dateno1+"\t\t\t"+item_amt);
        summarytext.insert(summarybody.getText(),223);

    }}
             public void viewreport(){
              Date date11;
              Date date1;
              
              date11=stdate.getDate();
              date1=eddate.getDate();
              if (date11 == null||date1==null) { 
                  JOptionPane.showMessageDialog(null, "You must select both Start and End date first.", "Error", JOptionPane.ERROR_MESSAGE); 
                  stdate.grabFocus(); 
                  eddate.grabFocus();
}
              else{
              DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
              
        sttf.setText(df.format(stdate.getDate()));
        edtf.setText(df.format(eddate.getDate()));
        String a=sttf.getText();
        String b=edtf.getText();
            
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=(Connection) DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/login","root","admin");
            Statement stmt=(Statement) conn.createStatement();
        String query1;
        query1 = "SELECT tblvalue.date as DATE,sum(amt)as AMOUNT FROM tblvalue WHERE date BETWEEN '"+a+"' AND '"+b+"' group by date;";
        ResultSet rs1=stmt.executeQuery(query1);
        if (!rs1.isBeforeFirst() ) {    
        JOptionPane.showMessageDialog(null, "No Records!");
        tamt.setText("");
        summarytext.setText("");
        summarybody.setText("");
        date.setText("");
        time.setText("");
        sttf.setText("");
        edtf.setText("");
        stdate.setCalendar(null);
        eddate.setCalendar(null);
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
        }}
           
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        stdate = new com.toedter.calendar.JDateChooser();
        eddate = new com.toedter.calendar.JDateChooser();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tamt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        summarytext = new javax.swing.JTextArea();
        summarybody = new javax.swing.JTextArea();
        sttf = new javax.swing.JTextField();
        edtf = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        time = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(811, 445));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Enter Start Date:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 40, 120, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Enter End Date:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 90, 110, 30);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/print-icon (1).png"))); // NOI18N
        jButton4.setText("Print");
        jButton4.setToolTipText("Print the summary report.");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(90, 300, 140, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Actions-view-list-details-icon (2).png"))); // NOI18N
        jButton3.setText("View Report");
        jButton3.setToolTipText("click here to view the report.");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(90, 250, 140, 40);

        stdate.setToolTipText("Select Start date.");
        getContentPane().add(stdate);
        stdate.setBounds(150, 50, 150, 30);

        eddate.setToolTipText("Select End date.");
        getContentPane().add(eddate);
        eddate.setBounds(150, 90, 150, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DATE", "AMOUNT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("Summary report of total sales.");
        jScrollPane5.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(320, 20, 460, 360);

        tamt.setToolTipText("total sale.");
        tamt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(tamt);
        tamt.setBounds(150, 170, 150, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Total Sale:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 170, 68, 16);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Actions-window-close-icon (1).png"))); // NOI18N
        jButton7.setText("Close");
        jButton7.setToolTipText("Close this window.");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(680, 390, 100, 33);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/37169943-blur-images.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 820, 470);

        summarytext.setEditable(false);
        summarytext.setColumns(20);
        summarytext.setRows(5);
        summarytext.setAutoscrolls(false);
        summarytext.setFocusable(false);
        summarytext.setOpaque(false);
        summarytext.setRequestFocusEnabled(false);
        summarytext.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(summarytext);
        summarytext.setBounds(170, 390, 20, 20);

        summarybody.setEditable(false);
        summarybody.setColumns(20);
        summarybody.setRows(5);
        summarybody.setAutoscrolls(false);
        summarybody.setFocusable(false);
        summarybody.setOpaque(false);
        summarybody.setRequestFocusEnabled(false);
        summarybody.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(summarybody);
        summarybody.setBounds(200, 390, 20, 20);

        sttf.setEditable(false);
        sttf.setAutoscrolls(false);
        sttf.setEnabled(false);
        sttf.setFocusable(false);
        sttf.setOpaque(false);
        sttf.setRequestFocusEnabled(false);
        sttf.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(sttf);
        sttf.setBounds(130, 360, 20, 20);

        edtf.setEnabled(false);
        edtf.setFocusable(false);
        edtf.setOpaque(false);
        edtf.setRequestFocusEnabled(false);
        edtf.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(edtf);
        edtf.setBounds(130, 390, 20, 20);

        date.setEditable(false);
        date.setAutoscrolls(false);
        date.setFocusable(false);
        date.setOpaque(false);
        date.setRequestFocusEnabled(false);
        date.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(date);
        date.setBounds(130, 390, 30, 30);

        time.setEditable(false);
        time.setAutoscrolls(false);
        time.setFocusable(false);
        time.setOpaque(false);
        time.setRequestFocusEnabled(false);
        time.setVerifyInputWhenFocusTarget(false);
        time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeActionPerformed(evt);
            }
        });
        getContentPane().add(time);
        time.setBounds(130, 390, 30, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       tamt.setText("");
        summarytext.setText("");
        summarybody.setText("");
        date.setText("");
        time.setText("");
        sttf.setText("");
        edtf.setText("");
        stdate.setCalendar(null);
        eddate.setCalendar(null);
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        while(model.getRowCount() >0){
            for(int i=0; i<model.getRowCount();i++){
                model.removeRow(i);
            }
        }
        close();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        viewreport();
        getAmtSum();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void eddateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_eddateFocusLost

    }//GEN-LAST:event_eddateFocusLost

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      if(sttf.getText().isEmpty()&&edtf.getText().isEmpty())
      {
        JOptionPane.showMessageDialog(null,"please specify both start & end date");
      }
      else{
        summaryprint();
         try{         
          // sendmail1();              
         summarytext.print();
         tamt.setText("");
        summarytext.setText("");
        summarybody.setText("");
        date.setText("");
        time.setText("");
        sttf.setText("");
        edtf.setText("");
        stdate.setCalendar(null);
        eddate.setCalendar(null);
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        while(model.getRowCount() >0){
            for(int i=0; i<model.getRowCount();i++){
                model.removeRow(i);
            }
        }
         }
        catch (java.awt.print.PrinterException e){
        System.err.format("No printer found" ,e);
        }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         tamt.setText("");
        summarytext.setText("");
        summarybody.setText("");
        date.setText("");
        time.setText("");
        sttf.setText("");
        edtf.setText("");
        stdate.setCalendar(null);
        eddate.setCalendar(null);
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
            java.util.logging.Logger.getLogger(summaryrep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(summaryrep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(summaryrep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(summaryrep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new summaryrep().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date;
    private com.toedter.calendar.JDateChooser eddate;
    private javax.swing.JTextField edtf;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser stdate;
    private javax.swing.JTextField sttf;
    private javax.swing.JTextArea summarybody;
    private javax.swing.JTextArea summarytext;
    private javax.swing.JTextField tamt;
    private javax.swing.JTextField time;
    // End of variables declaration//GEN-END:variables
}
