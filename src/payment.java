import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


public class payment extends javax.swing.JFrame {
 // public static payment obj44=null;  
   
    
    public payment() {
        initComponents();
        initialize();
        tbno.setEditable(false);
        setSize(769,549);
        //vtextfield();
        setLocation(300,60);
        setResizable(false);
    }
    private void initialize() {
    this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
    } 
    public void close(){
    WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
}
        public void getCashRtn(){               
        int one=Integer.parseInt(tamtval.getText());
        int two=Integer.parseInt(cashrc.getText());
        String answer=String.valueOf(one-two);
        cashrd.setText(answer);
     }
    /*public static payment getObj(){
   if(obj44==null){
       obj44=new payment();
   } 
   return obj44;
}*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cashcard = new javax.swing.ButtonGroup();
        cardn = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        rbcash = new javax.swing.JRadioButton();
        rbcard = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cashrc = new javax.swing.JTextField();
        cashrd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tamtval = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tbno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invval = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Payment");
        setLocation(new java.awt.Point(1010, 200));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        cardn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cardn.setOpaque(false);
        cardn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cardnKeyTyped(evt);
            }
        });
        getContentPane().add(cardn);
        cardn.setBounds(497, 232, 200, 31);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("CARD NO:");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(410, 230, 80, 30);

        rbcash.setBackground(new java.awt.Color(102, 255, 102));
        cashcard.add(rbcash);
        rbcash.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        rbcash.setText("CASH");
        rbcash.setToolTipText("Cash");
        rbcash.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        rbcash.setBorderPainted(true);
        rbcash.setIconTextGap(80);
        rbcash.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/checkcircle.png"))); // NOI18N
        rbcash.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbcashItemStateChanged(evt);
            }
        });
        rbcash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbcashActionPerformed(evt);
            }
        });
        getContentPane().add(rbcash);
        rbcash.setBounds(77, 95, 290, 109);

        rbcard.setBackground(new java.awt.Color(255, 102, 102));
        cashcard.add(rbcard);
        rbcard.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        rbcard.setText(" CARD");
        rbcard.setToolTipText("Card");
        rbcard.setActionCommand("CARD");
        rbcard.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        rbcard.setBorderPainted(true);
        rbcard.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/circle.png"))); // NOI18N
        rbcard.setIconTextGap(70);
        rbcard.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/checkcircle.png"))); // NOI18N
        getContentPane().add(rbcard);
        rbcard.setBounds(407, 95, 290, 109);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("CASH RECIEVED:");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(40, 350, 140, 28);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("CASH RETURNED:");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(40, 390, 150, 30);

        cashrc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cashrc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cashrc.setOpaque(false);
        cashrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashrcActionPerformed(evt);
            }
        });
        cashrc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cashrcKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cashrcKeyTyped(evt);
            }
        });
        getContentPane().add(cashrc);
        cashrc.setBounds(191, 349, 152, 31);

        cashrd.setEditable(false);
        cashrd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cashrd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cashrd.setOpaque(false);
        cashrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashrdActionPerformed(evt);
            }
        });
        getContentPane().add(cashrd);
        cashrd.setBounds(191, 391, 152, 31);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Select a Payment Method:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(23, 33, 717, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Payment checkout");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(279, 459, 217, 42);

        tamtval.setEditable(false);
        tamtval.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tamtval.setAutoscrolls(false);
        tamtval.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tamtval.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tamtval.setFocusable(false);
        tamtval.setOpaque(false);
        tamtval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamtvalActionPerformed(evt);
            }
        });
        getContentPane().add(tamtval);
        tamtval.setBounds(191, 310, 152, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("TOTAL AMOUNT:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 310, 140, 28);

        tbno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tbno.setToolTipText("");
        tbno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbno.setOpaque(false);
        getContentPane().add(tbno);
        tbno.setBounds(191, 269, 152, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("TABLE NO:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(39, 269, 120, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("INVOICE NO:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 230, 120, 26);

        invval.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        invval.setToolTipText("");
        invval.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(invval);
        invval.setBounds(191, 228, 152, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/data2.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 770, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cardnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cardnKeyTyped
       try{ char c=evt.getKeyChar();
       
        if(!Character.isDigit(c) || c==KeyEvent.VK_BACKSPACE||c==KeyEvent.VK_DELETE){
            evt.consume();
            getToolkit().beep();
        }
       }
        catch(Exception e)
                {
                JOptionPane.showMessageDialog((null), "please enter your card no");
                }
                
    }//GEN-LAST:event_cardnKeyTyped

    private void rbcashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbcashActionPerformed
       
    }//GEN-LAST:event_rbcashActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          if(rbcash.isSelected()==false&&rbcard.isSelected()==false)
        {
            JOptionPane.showMessageDialog(null, "Select mode of payment");
        }
       
        else if (rbcard.isSelected()==true&&cardn.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(null, "Provide card no. for card payment");       
        }
        else if (rbcash.isSelected()==true&&cashrc.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(null, "Enter amount of cash recieved");       
        }
        else if (rbcash.isSelected()==true&&cardn.getText().isEmpty())
        {
         try {
            int one=Integer.parseInt(tamtval.getText());
            int two=Integer.parseInt(cashrc.getText());
            if(one<=two){
            String a=invval.getText();
            String b=cashrc.getText();
            String c=cashrd.getText();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
      
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
        String sql = "Update tblvalue set cash_recd='"+b+"',cash_retd='"+c+"' where invoice_no='"+a+"'";
        String sql1= "Update bkptblvalue set cash_recd='"+b+"',cash_retd='"+c+"' where invoice_no='"+a+"'";

           PreparedStatement ps=conn.prepareStatement(sql);
           PreparedStatement ps1=conn.prepareStatement(sql1);
           ps.execute();
           ps1.execute();
           JOptionPane.showMessageDialog(null,"Thank you");
            this.dispose();
         }
            else{
            JOptionPane.showMessageDialog(null,"Cash received cannot be less than Total Amount!");
            cashrc.setText("");
        }
            }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Something went wrong!");
        }}
        else if (rbcard.isSelected()==true&&cashrc.getText().isEmpty())
        {
         try {
        String a=invval.getText();
        String d=cardn.getText();
            Class.forName("com.mysql.jdbc.Driver");
       Connection conn = null;
      
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
        String sql = "Update tblvalue set card_no='"+d+"'where invoice_no='"+a+"'";
        String sql1= "Update bkptblvalue set card_no='"+d+"'where invoice_no='"+a+"'";

           PreparedStatement ps=conn.prepareStatement(sql);
           PreparedStatement ps1=conn.prepareStatement(sql1);
           ps.execute();
           ps1.execute();
            this.dispose();
         }
        
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Something went wrong!");
        }}
            else
        {
           
            this.dispose();
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    
    }//GEN-LAST:event_formWindowOpened

    private void cashrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashrdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cashrdActionPerformed

    private void cashrcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashrcKeyTyped
        try{
            char c=evt.getKeyChar();

            if(!(Character.isDigit(c) || c==KeyEvent.VK_BACKSPACE)||c==KeyEvent.VK_DELETE){
                evt.consume();
                getToolkit().beep();
            }}
            catch(Exception e){
                JOptionPane.showMessageDialog((null), e);
            }
    }//GEN-LAST:event_cashrcKeyTyped

    private void cashrcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashrcKeyReleased
        try{
            getCashRtn();
        }catch(Exception e)
        {

        }
    }//GEN-LAST:event_cashrcKeyReleased

    private void cashrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashrcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cashrcActionPerformed

    private void tamtvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamtvalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamtvalActionPerformed

    private void rbcashItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbcashItemStateChanged
    
    }//GEN-LAST:event_rbcashItemStateChanged

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
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField cardn;
    private javax.swing.ButtonGroup cashcard;
    private javax.swing.JTextField cashrc;
    private javax.swing.JTextField cashrd;
    public static javax.swing.JLabel invval;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton rbcard;
    private javax.swing.JRadioButton rbcash;
    public static javax.swing.JTextField tamtval;
    public static javax.swing.JTextField tbno;
    // End of variables declaration//GEN-END:variables
}
