

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Desktop;
import java.util.Locale;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;
import java.net.URL;
import javax.swing.JFrame;
public class first extends javax.swing.JFrame {
//public static first obj44=null;
    
    public first() {
        initComponents();
        datentime();
        date();
      setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
       time();
        getQtySum();
        getAmtSum();
        getInameSum();
       id_auto();
       showtable();
        setTitle("Vishwa Billing System");
        setResizable(true);
        setLocation(250,30);
        setSize(741,720);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
 initialize();
 
      version.setSize(477,290);
    version.setTitle("version");
        version.setResizable(false);
        version.setLocation(450,200);
        version.setModal(true);
        dupbill.setSize(261,150);
        dupbill.setResizable(false);
        dupbill.setLocation(550,300);
        dupbill.setModal(true);
        verifywaiter.setModal(true);
        verifywaiter.setTitle("Waiter Account");
        verifydatabaseadmin.setTitle("Item Database");
        verifyadminusermgmt.setTitle("Cashier Account");
        verifyadmin.setTitle("Admin Account");
        erasealldata.setTitle("Erase Data");
        verifydatabaseadmin.setModal(true);
        verifyadminusermgmt.setModal(true);
        verifyadmin.setModal(true);
        verifyadmin.setLocation(500,250);
        verifywaiter.setLocation(500,250);
        erasealldata.setLocation(500,250);
        verifydatabaseadmin.setLocation(500,250);
        verifyadminusermgmt.setLocation(500,250);
        erasealldata.setModal(true);
      // inv.setText("001");
      dupinvno.setFocusable(true);
 JTableHeader head=jTable1.getTableHeader();
  head.setBackground(Color.yellow);
  head.setForeground(Color.red);
    }
    
   public void close(){
 WindowEvent winClosingEvent =new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
   }
    public void datentime()
   {
   new Timer(0,new ActionListener(){
       @Override
       public void actionPerformed(ActionEvent ae) {
          SimpleDateFormat ad = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String ttime = ad.format(new Date());
       date.setText(""+ttime);
       }
           }).start();
   }
     private void initialize() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
        version.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
        verifywaiter.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
        verifydatabaseadmin.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
        verifyadminusermgmt.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
        verifyadmin.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
        erasealldata.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
        dupbill.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("final logo.PNG")));
    } 
     public static boolean isEmpty(JTable jTable2dup) {
        if (jTable2dup != null && jTable2dup.getModel() != null) {
            return jTable2dup.getModel().getRowCount()<=0?true:false;
        }
        
        return false;
    }
     public void close22(){
      
     }
     public void clean() {
    parcel.setSelected(false);
    inrest.setSelected(false);
    }
    public void date()
    {
       String tdate =new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH).format(new Date());
       date1.setText(""+tdate);
    }
     public void showtable(){
    try{
            
            Class.forName("com.mysql.jdbc.Driver");
      
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
         Statement stmt=(Statement) conn.createStatement();
            String sql="select icode as ITEM_CODE,iname as ITEM_PRICE,iprice as ITEM_PRICE from menu";
            ResultSet rs=stmt.executeQuery(sql);
            itemData.setModel(DbUtils.resultSetToTableModel(rs));
        }
            catch(Exception e)
                    {
                    JOptionPane.showMessageDialog(null, e); 
                    
                  }
    }
    public void close1(){
        
    }
     public void id_auto(){
    try{
             
        Class.forName("com.mysql.jdbc.Driver");
      
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
          Statement stmt=(Statement) conn.createStatement();
        String sql="SELECT invoice_no from tblvalue ORDER BY invoice_no DESC LIMIT 1; ";
       // String sql="select invoice_no from tblvalue where invoice_no=(Select max(invoice_no) from tblvalue);";
    ResultSet rs=stmt.executeQuery(sql);
    while(rs.next()){
        if(rs.first()==false){
            inv.setText("1000");
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
            inv.setText(""+no);
        }
    }
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e);
    }
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
     public void getQtySum()
     {
         int sum=0;
         for(int i=0; i< jTable1.getRowCount();i++)
         {
             sum=sum+Integer.parseInt(jTable1.getValueAt(i,2).toString());
         }
         tqty.setText(Integer.toString(sum));
     }
     public void getAmtSum()
     {
         int sum=0;
         for(int i=0; i< jTable1.getRowCount();i++)
         {
             sum=sum+Integer.parseInt(jTable1.getValueAt(i,4).toString());
         }
         tamt.setText(Integer.toString(sum));
     }
     public void getInameSum()
     {
         int rows=jTable1.getRowCount();
         titem.setText(Integer.toString(rows));
     }
     /*public static payment getObj(){
   if(obj44==null){
       obj44=new payment();
   } 
   return obj44;
}*/
     public void save()
     {
         if(parcel.isSelected()==true&&inrest.isSelected()==false){
           try{
              int rows=jTable1.getRowCount();
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
        conn.setAutoCommit(false);
       
        String sql = "Insert into tblvalue(code,iname,qty,rate,amt,Date_time,invoice_no,table_no,noOfppl,wname,total_item,total_qty,total_amt,date,cashier,ordertype)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         String sql1 = "Insert into bkptblvalue(code,iname,qty,rate,amt,Date_time,invoice_no,table_no,noOfppl,wname,total_item,total_qty,total_amt,date,cashier,ordertype)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        PreparedStatement pst1 = conn.prepareStatement(sql1);
        for(int row = 0; row<rows; row++)
    {
    String icode = (String)jTable1.getValueAt(row, 0);
    String inam = (String)jTable1.getValueAt(row, 1);
    String iqty = (String)jTable1.getValueAt(row, 2);
    String irate = (String)jTable1.getValueAt(row, 3);
    String iamt = (String)jTable1.getValueAt(row, 4);
    pst.setString(6,date.getText());
    pst.setString(7,inv.getText());
    pst.setString(8,tblno.getText());
    pst.setString(9,ppl.getText());
    pst.setString(10,wname.getText());
    pst.setString(11,titem.getText());
    pst.setString(12,tqty.getText());
    pst.setString(13,tamt.getText());
    pst.setString(14,date1.getText());
     pst.setString(15,cashier1.getText());
     pst.setString(16,parc.getText());
    pst.setString(1, icode);
    pst.setString(2, inam);
    pst.setString(3, iqty);
    pst.setString(4, irate);
    pst.setString(5, iamt);
    pst1.setString(6,date.getText());
    pst1.setString(7,inv.getText());
    pst1.setString(8,tblno.getText());
    pst1.setString(9,ppl.getText());
    pst1.setString(10,wname.getText());
    pst1.setString(11,titem.getText());
    pst1.setString(12,tqty.getText());
    pst1.setString(13,tamt.getText());
    pst1.setString(14,date1.getText());
     pst1.setString(15,cashier1.getText());
    pst1.setString(16,parc.getText());
     pst1.setString(1, icode);
    pst1.setString(2, inam);
    pst1.setString(3, iqty);
    pst1.setString(4, irate);
    pst1.setString(5, iamt);
       
         pst.addBatch();
         pst1.addBatch();
        }
     
        pst.executeBatch();
         pst1.executeBatch();
        conn.commit();
       // JOptionPane.showMessageDialog(null," saved successfully");
        
        }catch(Exception e)
           {
               JOptionPane.showMessageDialog(null,e);
           }
         }
         else
         {
            try{
              int rows=jTable1.getRowCount();
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
        conn.setAutoCommit(false);
       
        String sql = "Insert into tblvalue(code,iname,qty,rate,amt,Date_time,invoice_no,table_no,noOfppl,wname,total_item,total_qty,total_amt,date,cashier,ordertype)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         String sql1 = "Insert into bkptblvalue(code,iname,qty,rate,amt,Date_time,invoice_no,table_no,noOfppl,wname,total_item,total_qty,total_amt,date,cashier,ordertype)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        PreparedStatement pst1 = conn.prepareStatement(sql1);
        for(int row = 0; row<rows; row++)
    {
    String icode = (String)jTable1.getValueAt(row, 0);
    String inam = (String)jTable1.getValueAt(row, 1);
    String iqty = (String)jTable1.getValueAt(row, 2);
    String irate = (String)jTable1.getValueAt(row, 3);
    String iamt = (String)jTable1.getValueAt(row, 4);
    pst.setString(6,date.getText());
    pst.setString(7,inv.getText());
    pst.setString(8,tblno.getText());
    pst.setString(9,ppl.getText());
    pst.setString(10,wname.getText());
    pst.setString(11,titem.getText());
    pst.setString(12,tqty.getText());
    pst.setString(13,tamt.getText());
    pst.setString(14,date1.getText());
     pst.setString(15,cashier1.getText());
     pst.setString(16,parc.getText());
    pst.setString(1, icode);
    pst.setString(2, inam);
    pst.setString(3, iqty);
    pst.setString(4, irate);
    pst.setString(5, iamt);
    pst1.setString(6,date.getText());
    pst1.setString(7,inv.getText());
    pst1.setString(8,tblno.getText());
    pst1.setString(9,ppl.getText());
    pst1.setString(10,wname.getText());
    pst1.setString(11,titem.getText());
    pst1.setString(12,tqty.getText());
    pst1.setString(13,tamt.getText());
    pst1.setString(14,date1.getText());
     pst1.setString(15,cashier1.getText());
    pst1.setString(16,parc.getText());
     pst1.setString(1, icode);
    pst1.setString(2, inam);
    pst1.setString(3, iqty);
    pst1.setString(4, irate);
    pst1.setString(5, iamt);
       
         pst.addBatch();
         pst1.addBatch();
        }
     
        pst.executeBatch();
         pst1.executeBatch();
        conn.commit();
       // JOptionPane.showMessageDialog(null," saved successfully");
        
        }catch(Exception e)
           {
               JOptionPane.showMessageDialog(null,"error in saving records");
           } 
         }
         }
          public void dupwork() {        
        String dinv=dupinvno.getText();
               try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
            Statement st = conn.createStatement();
            String sql = "select iname,qty,rate,amt,total_amt from tblvalue where invoice_no= '"+dinv+"'";
            ResultSet rs;
            rs = st.executeQuery(sql);
            if(rs.isBeforeFirst())
            {
            jTable2dup.setModel(DbUtils.resultSetToTableModel(rs));

            conn.close();
            }
            else{
                JOptionPane.showMessageDialog(null,"This bill does not Exist!");
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Got an exception!");

        }}
        private void dupbillprint(){
        int rows1=jTable2dup.getRowCount();
                for(int row1 = 0; row1<rows1; row1++)
               {    
        String inam = (String)jTable2dup.getValueAt(row1,0);
        int iqty = (int)jTable2dup.getValueAt(row1,1);
        int irate =(int)jTable2dup.getValueAt(row1,2);
        int iamt = (int)jTable2dup.getValueAt(row1,3);
            String invoiceno=String.format(dupinvno.getText());
            String dateget=String.format(date1.getText());
            String timeget=String.format(time.getText());
            String item_name=String.format(inam);
            String item_qty=String.valueOf(iqty);
            String item_price=String.valueOf(irate);
            String item_amt=String.valueOf(iamt);
            int total_amount=(int)jTable2dup.getValueAt(row1,4);           
        String billbody1=("\n\t\tDUPLICATE BILL\n" +
                "\n\t\tVISHWAV RESTAURANT\n" +
            "\t\t          VASAI\n"+
            "\t\tART FOOD FACTORY\n"+   
            "BILL NO: " + invoiceno +"\tDATE: "+dateget+"   TIME: "+timeget+
            "\n=======================================================\t"+
            "\nITEM:\t\tQTY\tPRICE\tAMOUNT\t"+
            "\n=======================================================\t"+
            "\n=======================================================\t"+
            "\nTOTAL\t\t\tRs. "+total_amount+"/-"+
            "\n\t             THANK YOU \n");
        dupbilltextar.setText(billbody1);
        dupbillbody.append("\n"+item_name+"\t"+item_qty+"\t"+item_price+"\t"+item_amt);
        dupbilltextar.insert(dupbillbody.getText(),263);
    }}


        private void billprint(){
        int rows=jTable1.getRowCount();
                for(int row = 0; row<rows; row++)
               {
    
    String inam = (String)jTable1.getValueAt(row,1);
    String iqty = (String)jTable1.getValueAt(row,2);
    String irate =(String)jTable1.getValueAt(row,3);
    String iamt = (String)jTable1.getValueAt(row,4);

            String invoiceno=String.format(inv.getText());
            String dateget=String.format(date1.getText());
            String timeget=String.format(time.getText());
            String item_name=String.format(inam);
            String item_qty=String.format(iqty);
            String item_price=String.format(irate);
            String item_amt=String.format(iamt);
            String total_amount=String.format(tamt.getText());
           
        String billbody=("\n\t\tVISHWAV RESTAURANT\n" +
            "\t\t          VASAI\n"+
            "\t\tART FOOD FACTORY\n"+   
            "BILL NO: " + invoiceno +"\tDATE: "+dateget+"   TIME: "+timeget+
            "\n=======================================================\t"+
            "\nITEM:\t\tQTY\tPRICE\tAMOUNT\t"+
            "\n=======================================================\t"+
            "\n=======================================================\t"+
            "\nTOTAL\t\t\tRs. "+total_amount+"/-"+
            "\n\t        THANK YOU \n");
        billpreview.setText(billbody);
        billtextar.append("\n"+item_name+"\t"+item_qty+"\t"+item_price+"\t"+item_amt);
        if(inv.getText().length()==4){
        billpreview.insert(billtextar.getText(),245);
        }
        else if(inv.getText().length()==5){
         billpreview.insert(billtextar.getText(),246);   
        }
    }}
public void sendmail1(){
     try{
            String host ="smtp.gmail.com" ;
            String user = "indulgebillupdates@gmail.com";
            String pass = "adminmujeeb";
            String to = "vishwakarmasujeet97@gmail.com";
           // String to = "mayur7030345542@gmail.com";
            String from = "indulgebillupdates@gmail.com";
            String subject = "Updates from Vishwa Restaurent.  ";
            String messageText = "New bill:"+billpreview.getText()+"";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
           JOptionPane.showMessageDialog(null,"Email sent!");
        }catch(Exception ex)
        {
            System.out.println(ex);
           // JOptionPane.showMessageDialog(null,"Emailid or password in incorrect",ex);
        }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dupreciept = new javax.swing.ButtonGroup();
        erasealldata = new javax.swing.JDialog();
        jLabel17 = new javax.swing.JLabel();
        t1 = new javax.swing.JPasswordField();
        jLabel18 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        verifyadmin = new javax.swing.JDialog();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        verifyadminusermgmt = new javax.swing.JDialog();
        usermgmt = new javax.swing.JPasswordField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        login = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        verifydatabaseadmin = new javax.swing.JDialog();
        databaseveri = new javax.swing.JPasswordField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        loggg = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        verifywaiter = new javax.swing.JDialog();
        jtext = new javax.swing.JPasswordField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jbut = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        version = new javax.swing.JDialog();
        jButton7 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        dupbill = new javax.swing.JDialog();
        jLabel41 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        dupinvno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        dupbilltextar = new javax.swing.JTextArea();
        dupbillbody = new javax.swing.JTextArea();
        jTable2dup = new javax.swing.JTable();
        jLabel43 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel8 = new javax.swing.JLabel();
        cashier1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        wno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tblno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        signout = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        ppl = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ic = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        addRow = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        inrest = new javax.swing.JRadioButton();
        parcel = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        itemData = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tqty = new javax.swing.JTextField();
        titem = new javax.swing.JTextField();
        tamt = new javax.swing.JTextField();
        wname = new javax.swing.JLabel();
        delRow = new javax.swing.JButton();
        itemdbb = new javax.swing.JTextField();
        pbtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        billpreview = new javax.swing.JTextArea();
        billtextar = new javax.swing.JTextArea();
        amt = new javax.swing.JTextField();
        iprice1 = new javax.swing.JTextField();
        iname = new javax.swing.JTextField();
        iprice = new javax.swing.JTextField();
        amt1 = new javax.swing.JTextField();
        iname1 = new javax.swing.JTextField();
        parc = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();

        erasealldata.setMinimumSize(new java.awt.Dimension(368, 225));
        erasealldata.setResizable(false);
        erasealldata.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                erasealldataWindowClosing(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Password");

        t1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Verify Yourself ");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Key-icon.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Enter Admin password to perform this administrative task.");
        jLabel19.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/37169943-blur-images.png"))); // NOI18N

        javax.swing.GroupLayout erasealldataLayout = new javax.swing.GroupLayout(erasealldata.getContentPane());
        erasealldata.getContentPane().setLayout(erasealldataLayout);
        erasealldataLayout.setHorizontalGroup(
            erasealldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(erasealldataLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(erasealldataLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(erasealldataLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(erasealldataLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(erasealldataLayout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(erasealldataLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        erasealldataLayout.setVerticalGroup(
            erasealldataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(erasealldataLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(erasealldataLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(erasealldataLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(erasealldataLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(erasealldataLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(erasealldataLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        verifyadmin.setMinimumSize(new java.awt.Dimension(360, 200));
        verifyadmin.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                verifyadminWindowClosing(evt);
            }
        });
        verifyadmin.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPasswordField2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPasswordField2.setOpaque(false);
        jPasswordField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField2KeyPressed(evt);
            }
        });
        verifyadmin.getContentPane().add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 60, 151, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Password");
        verifyadmin.getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 59, 70, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Verify Yourself ");
        verifyadmin.getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        verifyadmin.getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 80, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Key-icon.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        verifyadmin.getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 41, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Enter Admin password to perform this administrative task.");
        jLabel23.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        verifyadmin.getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, 24));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/37169943-blur-images.png"))); // NOI18N
        verifyadmin.getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 190));

        verifyadminusermgmt.setMinimumSize(new java.awt.Dimension(360, 200));
        verifyadminusermgmt.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                verifyadminusermgmtWindowClosing(evt);
            }
        });
        verifyadminusermgmt.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usermgmt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        usermgmt.setOpaque(false);
        usermgmt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usermgmtKeyPressed(evt);
            }
        });
        verifyadminusermgmt.getContentPane().add(usermgmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 160, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Password");
        verifyadminusermgmt.getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 70, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("Verify Yourself ");
        verifyadminusermgmt.getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jButton10.setText("Cancel");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        verifyadminusermgmt.getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 90, 30));

        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Key-icon.png"))); // NOI18N
        login.setBorderPainted(false);
        login.setContentAreaFilled(false);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        verifyadminusermgmt.getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 40, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Enter Admin password to perform this administrative task.");
        jLabel35.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        verifyadminusermgmt.getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, 30));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/37169943-blur-images.png"))); // NOI18N
        verifyadminusermgmt.getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 190));

        verifydatabaseadmin.setMinimumSize(new java.awt.Dimension(360, 200));
        verifydatabaseadmin.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                verifydatabaseadminWindowClosing(evt);
            }
        });
        verifydatabaseadmin.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        databaseveri.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        databaseveri.setOpaque(false);
        databaseveri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                databaseveriKeyPressed(evt);
            }
        });
        verifydatabaseadmin.getContentPane().add(databaseveri, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 140, 30));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Password");
        verifydatabaseadmin.getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 70, 30));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setText("Verify Yourself ");
        verifydatabaseadmin.getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton12.setText("Cancel");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        verifydatabaseadmin.getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 80, 30));

        loggg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Key-icon.png"))); // NOI18N
        loggg.setBorderPainted(false);
        loggg.setContentAreaFilled(false);
        loggg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logggActionPerformed(evt);
            }
        });
        verifydatabaseadmin.getContentPane().add(loggg, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 30, -1));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Enter Admin password to perform this administrative task.");
        jLabel39.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        verifydatabaseadmin.getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, 20));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/37169943-blur-images.png"))); // NOI18N
        verifydatabaseadmin.getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 190));

        verifywaiter.setMinimumSize(new java.awt.Dimension(360, 200));
        verifywaiter.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                verifywaiterWindowClosing(evt);
            }
        });
        verifywaiter.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtext.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtext.setOpaque(false);
        jtext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextKeyPressed(evt);
            }
        });
        verifywaiter.getContentPane().add(jtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 160, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Password");
        verifywaiter.getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 70, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Verify Yourself ");
        verifywaiter.getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        verifywaiter.getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 80, -1));

        jbut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Key-icon.png"))); // NOI18N
        jbut.setBorderPainted(false);
        jbut.setContentAreaFilled(false);
        jbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutActionPerformed(evt);
            }
        });
        verifywaiter.getContentPane().add(jbut, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 40, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Enter Admin password to perform this administrative task.");
        jLabel27.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        verifywaiter.getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, 20));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/37169943-blur-images.png"))); // NOI18N
        verifywaiter.getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 190));

        version.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        version.getContentPane().setLayout(null);

        jButton7.setText("Close");
        jButton7.setOpaque(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        version.getContentPane().add(jButton7);
        jButton7.setBounds(379, 230, 80, 23);

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Fantasia Painting2(1).jpg"))); // NOI18N
        version.getContentPane().add(jLabel29);
        jLabel29.setBounds(0, 0, 480, 270);

        dupbill.setTitle("Duplicate bill");
        dupbill.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dupbillWindowClosing(evt);
            }
        });
        dupbill.getContentPane().setLayout(null);

        jLabel41.setText("Bill no");
        dupbill.getContentPane().add(jLabel41);
        jLabel41.setBounds(30, 10, 40, 35);

        jButton8.setText("Print");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        dupbill.getContentPane().add(jButton8);
        jButton8.setBounds(90, 60, 94, 34);

        dupinvno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dupinvnoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dupinvnoKeyTyped(evt);
            }
        });
        dupbill.getContentPane().add(dupinvno);
        dupinvno.setBounds(70, 10, 149, 35);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/37169943-blur-images.png"))); // NOI18N
        dupbill.getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 270, 140);

        jLabel42.setEnabled(false);
        jLabel42.setFocusable(false);
        jLabel42.setInheritsPopupMenu(false);
        jLabel42.setRequestFocusEnabled(false);
        jLabel42.setVerifyInputWhenFocusTarget(false);
        dupbill.getContentPane().add(jLabel42);
        jLabel42.setBounds(24, 11, 11, 35);

        dupbilltextar.setEditable(false);
        dupbilltextar.setColumns(20);
        dupbilltextar.setRows(5);
        dupbilltextar.setAutoscrolls(false);
        dupbilltextar.setFocusable(false);
        dupbilltextar.setOpaque(false);
        dupbilltextar.setRequestFocusEnabled(false);
        dupbilltextar.setVerifyInputWhenFocusTarget(false);
        dupbill.getContentPane().add(dupbilltextar);
        dupbilltextar.setBounds(45, 64, 7, 37);

        dupbillbody.setEditable(false);
        dupbillbody.setColumns(20);
        dupbillbody.setRows(5);
        dupbillbody.setAutoscrolls(false);
        dupbillbody.setEnabled(false);
        dupbillbody.setFocusable(false);
        dupbillbody.setOpaque(false);
        dupbillbody.setRequestFocusEnabled(false);
        dupbillbody.setVerifyInputWhenFocusTarget(false);
        dupbill.getContentPane().add(dupbillbody);
        dupbillbody.setBounds(58, 64, 7, 35);

        jTable2dup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2dup.setAutoscrolls(false);
        jTable2dup.setEnabled(false);
        jTable2dup.setFocusable(false);
        jTable2dup.setOpaque(false);
        jTable2dup.setRequestFocusEnabled(false);
        jTable2dup.setVerifyInputWhenFocusTarget(false);
        dupbill.getContentPane().add(jTable2dup);
        jTable2dup.setBounds(222, 50, 17, 37);

        jLabel43.setEnabled(false);
        jLabel43.setFocusable(false);
        jLabel43.setInheritsPopupMenu(false);
        jLabel43.setRequestFocusEnabled(false);
        jLabel43.setVerifyInputWhenFocusTarget(false);
        dupbill.getContentPane().add(jLabel43);
        jLabel43.setBounds(257, 11, 9, 35);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome To Vishwa Restaurant");
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel8.setText("Hello!");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 20, 40, 20);

        cashier1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(cashier1);
        cashier1.setBounds(60, 20, 90, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("DATE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 70, 40, 20);

        date1.setBackground(new java.awt.Color(255, 255, 255));
        date1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        date1.setToolTipText("date");
        date1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        date1.setOpaque(true);
        getContentPane().add(date1);
        date1.setBounds(60, 60, 87, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("INOVICE NO.");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(169, 64, 80, 23);

        inv.setEditable(false);
        inv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        inv.setText("1000");
        inv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        inv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invActionPerformed(evt);
            }
        });
        inv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                invKeyTyped(evt);
            }
        });
        getContentPane().add(inv);
        inv.setBounds(250, 60, 50, 23);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("WAITER NO.");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(170, 100, 80, 23);

        wno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        wno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        wno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wnoActionPerformed(evt);
            }
        });
        wno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                wnoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                wnoKeyTyped(evt);
            }
        });
        getContentPane().add(wno);
        wno.setBounds(250, 100, 47, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("TABLE NO.");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(610, 63, 70, 20);

        tblno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblnoActionPerformed(evt);
            }
        });
        tblno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblnoKeyTyped(evt);
            }
        });
        getContentPane().add(tblno);
        tblno.setBounds(685, 57, 33, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("TIME");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(22, 101, 40, 23);

        time.setBackground(new java.awt.Color(255, 255, 255));
        time.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        time.setToolTipText("time");
        time.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        time.setOpaque(true);
        getContentPane().add(time);
        time.setBounds(60, 100, 89, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("WAITER NAME");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(310, 100, 90, 30);

        signout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Apps-logout-icon.png"))); // NOI18N
        signout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signoutActionPerformed(evt);
            }
        });
        getContentPane().add(signout);
        signout.setBounds(1290, 20, 40, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("NO. OF PEOPLE");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(590, 104, 90, 20);

        ppl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ppl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ppl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pplActionPerformed(evt);
            }
        });
        ppl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pplKeyTyped(evt);
            }
        });
        getContentPane().add(ppl);
        ppl.setBounds(685, 98, 33, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("ITEM CODE");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(20, 140, 70, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("ENTER QTY.");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(170, 140, 70, 28);

        ic.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ic.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                icFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                icFocusLost(evt);
            }
        });
        ic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                icKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                icKeyTyped(evt);
            }
        });
        getContentPane().add(ic);
        ic.setBounds(90, 140, 50, 28);

        qty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        qty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyActionPerformed(evt);
            }
        });
        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                qtyKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qtyKeyTyped(evt);
            }
        });
        getContentPane().add(qty);
        qty.setBounds(250, 140, 80, 30);

        addRow.setBackground(new java.awt.Color(255, 255, 0));
        addRow.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addRow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Button-Add-icon.png"))); // NOI18N
        addRow.setText("ADD");
        addRow.setToolTipText("add an item to list.");
        addRow.setBorder(new javax.swing.border.MatteBorder(null));
        addRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowActionPerformed(evt);
            }
        });
        getContentPane().add(addRow);
        addRow.setBounds(590, 180, 91, 28);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("BILL PREVIEW:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(22, 185, 105, 30);

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE", "ITEM NAME", "QTY.", "RATE", "AMT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 220, 612, 290);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("ITEMS");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(250, 520, 40, 24);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("QTY.");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(370, 520, 40, 20);

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Search Items");
        getContentPane().add(jLabel45);
        jLabel45.setBounds(930, 60, 100, 30);

        buttonGroup1.add(inrest);
        inrest.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        inrest.setText("SERVE ON TABLE");
        inrest.setContentAreaFilled(false);
        inrest.setFocusPainted(false);
        inrest.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inrestItemStateChanged(evt);
            }
        });
        inrest.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inrestStateChanged(evt);
            }
        });
        inrest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inrestMouseClicked(evt);
            }
        });
        getContentPane().add(inrest);
        inrest.setBounds(460, 60, 130, 23);

        buttonGroup1.add(parcel);
        parcel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        parcel.setText("PARCEL");
        parcel.setContentAreaFilled(false);
        parcel.setFocusPainted(false);
        parcel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                parcelItemStateChanged(evt);
            }
        });
        parcel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                parcelStateChanged(evt);
            }
        });
        parcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parcelMouseClicked(evt);
            }
        });
        getContentPane().add(parcel);
        parcel.setBounds(390, 60, 80, 23);

        itemData.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(itemData);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(730, 102, 610, 550);

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("ORDER TYPE");
        getContentPane().add(jLabel44);
        jLabel44.setBounds(310, 60, 80, 20);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("TOTAL");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(520, 520, 52, 31);

        tqty.setEditable(false);
        tqty.setBackground(new java.awt.Color(255, 255, 255));
        tqty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tqty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tqtyActionPerformed(evt);
            }
        });
        getContentPane().add(tqty);
        tqty.setBounds(410, 520, 47, 24);

        titem.setEditable(false);
        titem.setBackground(new java.awt.Color(255, 255, 255));
        titem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        titem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        titem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titemActionPerformed(evt);
            }
        });
        getContentPane().add(titem);
        titem.setBounds(300, 520, 43, 24);

        tamt.setEditable(false);
        tamt.setBackground(new java.awt.Color(255, 255, 255));
        tamt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tamt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(tamt);
        tamt.setBounds(580, 520, 100, 27);

        wname.setBackground(new java.awt.Color(255, 255, 255));
        wname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        wname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        wname.setOpaque(true);
        getContentPane().add(wname);
        wname.setBounds(400, 100, 170, 30);

        delRow.setBackground(new java.awt.Color(255, 255, 102));
        delRow.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        delRow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Trash-empty-icon (1).png"))); // NOI18N
        delRow.setText("Delete");
        delRow.setToolTipText("Delete an item form list.");
        delRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delRowActionPerformed(evt);
            }
        });
        getContentPane().add(delRow);
        delRow.setBounds(70, 515, 101, 30);

        itemdbb.setToolTipText("search in menu");
        itemdbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemdbbActionPerformed(evt);
            }
        });
        itemdbb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemdbbKeyReleased(evt);
            }
        });
        getContentPane().add(itemdbb);
        itemdbb.setBounds(1030, 60, 140, 30);

        pbtn.setBackground(new java.awt.Color(14, 217, 14));
        pbtn.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 13)); // NOI18N
        pbtn.setForeground(new java.awt.Color(255, 255, 255));
        pbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/print-icon.png"))); // NOI18N
        pbtn.setText("PRINT");
        pbtn.setToolTipText("print bill.");
        pbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        pbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbtnActionPerformed(evt);
            }
        });
        getContentPane().add(pbtn);
        pbtn.setBounds(190, 570, 167, 70);

        jButton1.setBackground(new java.awt.Color(245, 34, 34));
        jButton1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Button-Close-icon.png"))); // NOI18N
        jButton1.setText("CANCEL");
        jButton1.setToolTipText("cancel order and clear all fields.");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(370, 570, 167, 70);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/37169943-blur-images.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1380, 740);

        date.setEnabled(false);
        date.setFocusable(false);
        date.setRequestFocusEnabled(false);
        date.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(date);
        date.setBounds(41, 11, 21, 19);

        billpreview.setEditable(false);
        billpreview.setColumns(20);
        billpreview.setRows(5);
        billpreview.setAutoscrolls(false);
        billpreview.setFocusable(false);
        billpreview.setOpaque(false);
        billpreview.setRequestFocusEnabled(false);
        billpreview.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(billpreview);
        billpreview.setBounds(422, 173, 30, 30);

        billtextar.setEditable(false);
        billtextar.setColumns(20);
        billtextar.setRows(5);
        billtextar.setAutoscrolls(false);
        billtextar.setFocusable(false);
        billtextar.setOpaque(false);
        billtextar.setRequestFocusEnabled(false);
        billtextar.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(billtextar);
        billtextar.setBounds(288, 179, 30, 20);

        amt.setEditable(false);
        amt.setAutoscrolls(false);
        amt.setBorder(null);
        amt.setEnabled(false);
        amt.setFocusable(false);
        amt.setOpaque(false);
        amt.setRequestFocusEnabled(false);
        amt.setVerifyInputWhenFocusTarget(false);
        amt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amtActionPerformed(evt);
            }
        });
        getContentPane().add(amt);
        amt.setBounds(385, 158, 23, 14);

        iprice1.setEditable(false);
        iprice1.setAutoscrolls(false);
        iprice1.setBorder(null);
        iprice1.setEnabled(false);
        iprice1.setFocusable(false);
        iprice1.setOpaque(false);
        iprice1.setRequestFocusEnabled(false);
        iprice1.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(iprice1);
        iprice1.setBounds(356, 168, 29, 14);

        iname.setEditable(false);
        iname.setAutoscrolls(false);
        iname.setBorder(null);
        iname.setEnabled(false);
        iname.setFocusable(false);
        iname.setOpaque(false);
        iname.setRequestFocusEnabled(false);
        iname.setVerifyInputWhenFocusTarget(false);
        iname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inameActionPerformed(evt);
            }
        });
        getContentPane().add(iname);
        iname.setBounds(307, 158, 33, 14);

        iprice.setEditable(false);
        iprice.setAutoscrolls(false);
        iprice.setBorder(null);
        iprice.setEnabled(false);
        iprice.setFocusable(false);
        iprice.setOpaque(false);
        iprice.setRequestFocusEnabled(false);
        iprice.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(iprice);
        iprice.setBounds(346, 158, 29, 14);

        amt1.setEditable(false);
        amt1.setAutoscrolls(false);
        amt1.setBorder(null);
        amt1.setEnabled(false);
        amt1.setFocusable(false);
        amt1.setOpaque(false);
        amt1.setRequestFocusEnabled(false);
        amt1.setVerifyInputWhenFocusTarget(false);
        amt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amt1ActionPerformed(evt);
            }
        });
        getContentPane().add(amt1);
        amt1.setBounds(395, 168, 23, 14);

        iname1.setEditable(false);
        iname1.setAutoscrolls(false);
        iname1.setBorder(null);
        iname1.setEnabled(false);
        iname1.setFocusable(false);
        iname1.setOpaque(false);
        iname1.setRequestFocusEnabled(false);
        iname1.setVerifyInputWhenFocusTarget(false);
        iname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iname1ActionPerformed(evt);
            }
        });
        getContentPane().add(iname1);
        iname1.setBounds(317, 168, 33, 14);

        parc.setEditable(false);
        parc.setAutoscrolls(false);
        parc.setBorder(null);
        parc.setEnabled(false);
        parc.setFocusable(false);
        parc.setOpaque(false);
        parc.setRequestFocusEnabled(false);
        parc.setVerifyInputWhenFocusTarget(false);
        parc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parcActionPerformed(evt);
            }
        });
        getContentPane().add(parc);
        parc.setBounds(630, 150, 70, 14);

        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(450, 140, 59, 20);

        jLabel30.setText("jLabel30");
        getContentPane().add(jLabel30);
        jLabel30.setBounds(380, 20, 150, 14);

        jMenuBar1.setOpaque(false);

        jMenu5.setText("File");

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/settings-icon.png"))); // NOI18N
        jMenu6.setText("Manage");

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Database-Active-icon.png"))); // NOI18N
        jMenuItem10.setText("Item Database");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Misc-Delete-Database-icon.png"))); // NOI18N
        jMenuItem7.setText("Erase Records");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenu5.add(jMenu6);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Duplicate-Layer-icon.png"))); // NOI18N
        jMenuItem9.setText("Duplicate Bill");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);
        jMenu5.add(jSeparator1);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Apps-session-logout-icon.png"))); // NOI18N
        jMenuItem13.setText("SignOut");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem13);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Actions-application-exit-icon.png"))); // NOI18N
        jMenuItem14.setText("Exit");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem14);

        jMenuBar1.add(jMenu5);

        jMenu1.setText("View");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Plates-icon.png"))); // NOI18N
        jMenuItem1.setText("Restaurant menu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Report");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Sales-report-icon.png"))); // NOI18N
        jMenuItem3.setText("Bill-wise Report");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Distributor-report-icon.png"))); // NOI18N
        jMenuItem4.setText("Item-wise Report");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Actions-view-calendar-month-icon.png"))); // NOI18N
        jMenuItem8.setText("Summary");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Account ");

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Admin-icon (1).png"))); // NOI18N
        jMenuItem15.setText("Manage Admin Acoount");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem15);

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Users-icon (1).png"))); // NOI18N
        jMenuItem16.setText("Manage User Account");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem16);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Occupations-Waiter-Male-Light-icon.png"))); // NOI18N
        jMenuItem6.setText("Manage Waiter Account");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Help");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Emotes-face-laugh-icon.png"))); // NOI18N
        jMenuItem2.setText("Version");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/Utilities-Feedback-Assistant-icon.png"))); // NOI18N
        jMenuItem12.setText("Give Feedback");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void wnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wnoActionPerformed

    private void tblnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblnoActionPerformed

    private void pplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pplActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pplActionPerformed

    private void tqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tqtyActionPerformed
       
    }//GEN-LAST:event_tqtyActionPerformed

    private void titemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titemActionPerformed
       
    }//GEN-LAST:event_titemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
      version.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void invActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invActionPerformed
        
    }//GEN-LAST:event_invActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
     itemwiserep.getObj().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        viewdata.getObj().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        verifydatabaseadmin.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
     verifyadminusermgmt.setVisible(true);
        
        
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
       verifyadmin.setVisible(true);
       
      
        
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        billwiserep.getObj().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void addRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRowActionPerformed
         if(parcel.isSelected()==false&&inrest.isSelected()==false)
        {
            JOptionPane.showMessageDialog(null, "Select mode of order");
        }
         else if (parcel.isSelected()==true&&ic.getText().isEmpty()&&qty.getText().isEmpty())
         {
          JOptionPane.showMessageDialog(null," item code & item can not be empty");
         }
         else if(inrest.isSelected()==true &&tblno.getText().isEmpty()&&ppl.getText().isEmpty())
         {
             JOptionPane.showMessageDialog(null, "Provide table no and people");       
         }
         else if(ic.getText().isEmpty()|| qty.getText().isEmpty())
    {
        JOptionPane.showMessageDialog(null, "Item code and quantity cannot be blank");
    }
        else{
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.addRow(new Object[]{ic.getText(),iname.getText(),qty.getText(),iprice.getText(),amt.getText()});
        ic.setText("");
        qty.setText("");
        iname.setText("");
        iprice.setText("");
        amt.setText("");
        getQtySum();
        getAmtSum();
        getInameSum();
       }
    }//GEN-LAST:event_addRowActionPerformed

    private void inameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inameActionPerformed

    private void amtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amtActionPerformed

    private void delRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delRowActionPerformed
        
        
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            try{
                int setSelectedRowIndex=jTable1.getSelectedRow();
                model.removeRow(setSelectedRowIndex);
                getQtySum();
                getAmtSum();
                getInameSum();
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"No rows selected.");
            }
            
       
        
    }//GEN-LAST:event_delRowActionPerformed

    private void icFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_icFocusLost
        String a=ic.getText();
       
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=(Connection) DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/login","root","admin");
            Statement stmt=(Statement) conn.createStatement();
            String query1="select * from menu where icode='"+a+"';";

            ResultSet rs1=stmt.executeQuery(query1);

            if(rs1.first())
            {
                iname.setText(rs1.getString("iname"));
                iprice.setText(rs1.getString("iprice"));
                
               this.setVisible(true);
           }
           else if(ic.getText().isEmpty())
       {
           JOptionPane.showMessageDialog(null, "please enter a valid item code");
           qty.setText("");
           ic.setText("");
           iname.setText("");
           iprice.setText("");
           amt.setText("");
       }
            else
            {
                JOptionPane.showMessageDialog(this,"Item code does not match with the database");
            }
        }
        catch(ClassNotFoundException | SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
   
    }//GEN-LAST:event_icFocusLost

    private void icKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_icKeyTyped
        char c=evt.getKeyChar();
        if(!Character.isDigit(c) || c==KeyEvent.VK_BACKSPACE||c==KeyEvent.VK_DELETE){
         evt.consume();
         getToolkit().beep();
        }
    }//GEN-LAST:event_icKeyTyped

    private void qtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyTyped
        char c=evt.getKeyChar();
        if(!Character.isDigit(c) || c==KeyEvent.VK_BACKSPACE||c==KeyEvent.VK_DELETE||ic.getText().isEmpty()){
         evt.consume();
         getToolkit().beep();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_qtyKeyTyped

    private void qtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyPressed
           
    }//GEN-LAST:event_qtyKeyPressed

    private void qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyReleased
        
        try{
            int one=Integer.parseInt(qty.getText());
        
        int two=Integer.parseInt(iprice.getText());
        String answer=String.valueOf(one*two);
        amt.setText(answer);
        }
        catch(Exception e){
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_qtyKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int SelectedRow =jTable1.getSelectedRow();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void invKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invKeyTyped
        char c=evt.getKeyChar();
        if(!Character.isDigit(c) || c==KeyEvent.VK_BACKSPACE||c==KeyEvent.VK_DELETE){
         evt.consume();
         getToolkit().beep();
        }
         
    }//GEN-LAST:event_invKeyTyped

    private void wnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wnoKeyTyped
        char c=evt.getKeyChar();
        if(!Character.isDigit(c) || c==KeyEvent.VK_BACKSPACE||c==KeyEvent.VK_DELETE){
         evt.consume();
         getToolkit().beep();
        }
    }//GEN-LAST:event_wnoKeyTyped

    private void tblnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblnoKeyTyped
        char c=evt.getKeyChar();
        if(!Character.isDigit(c) || c==KeyEvent.VK_BACKSPACE||c==KeyEvent.VK_DELETE){
         evt.consume();
         getToolkit().beep();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblnoKeyTyped

    private void pplKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pplKeyTyped
        char c=evt.getKeyChar();
        if(!Character.isDigit(c) || c==KeyEvent.VK_BACKSPACE||c==KeyEvent.VK_DELETE){
         evt.consume();
         getToolkit().beep();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_pplKeyTyped

    private void pbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbtnActionPerformed

        if(wname.getText().isEmpty()||parc.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Entering all fields is mandatory");
        }
       else if(jTable1.getRowCount()==0){
    JOptionPane.showMessageDialog(null,"no Items added");
}
        
        else
        {
            save();
            
            billprint();
         try{         
                        
         billpreview.print();
         sendmail1();
         }
        catch (java.awt.print.PrinterException e){
        System.err.format("No printer found" ,e.getMessage());
        }
       payment pym=new payment();
         pym.setVisible(true);
         payment.tamtval.setText(tamt.getText());
         payment.tbno.setText(tblno.getText());
         payment.invval.setText(inv.getText());
      // clean();
         wno.setText("");
        wname.setText("");
      tblno.setText("");
        ppl.setText("");
        titem.setText("");
        tqty.setText("");
        tamt.setText("");
        ic.setText("");
        qty.setText("");
        iname.setText("");
        iprice.setText("");
        amt.setText("");
        billpreview.setText("");
        billtextar.setText("");
        buttonGroup1.clearSelection();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        while(model.getRowCount() >0){
            for(int i=0; i<model.getRowCount();i++){
                model.removeRow(i);
                id_auto();
            }
        }
 }
       
    }//GEN-LAST:event_pbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       buttonGroup1.clearSelection();
        wno.setText("");
        wname.setText("");
        tblno.setText("");
        ppl.setText("");
        titem.setText("");
        tqty.setText("");
        tamt.setText("");
        ic.setText("");
        qty.setText("");
        iname.setText("");
        iprice.setText("");
        amt.setText("");
         
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        while(model.getRowCount() >0){
            for(int i=0; i<model.getRowCount();i++){
                model.removeRow(i);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void wnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wnoKeyReleased
       char c=evt.getKeyChar();
       if(c==KeyEvent.VK_ENTER)
       {
       evt.consume();
       getToolkit().beep();
    }else
    {
    
       String a=wno.getText();
       
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=(Connection) DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/login","root","admin");
            Statement stmt=(Statement) conn.createStatement();
            String query1="select Wname from waiter where WID='"+a+"';";

            ResultSet rs1=stmt.executeQuery(query1);

            if(rs1.first())
            {
                wname.setText(rs1.getString("Wname"));
               this.setVisible(true);
           }
           else if(wno.getText().isEmpty())
       {
           JOptionPane.showMessageDialog(null, "please enter a valid waiter ID");
           wname.setText("");
           wno.setText("");
       }
            else
            {
                JOptionPane.showMessageDialog(this,"Waiter id does not match with the database");
                wname.setText("");
                wno.setText("");
            }
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }    
}
    }//GEN-LAST:event_wnoKeyReleased

    private void icKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_icKeyReleased
        try{
        int one=Integer.parseInt(qty.getText());
        int two=Integer.parseInt(iprice.getText());
        String answer=String.valueOf(one*two);
        amt.setText(answer);
        }
        catch(Exception e){
           
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_icKeyReleased

    private void amt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amt1ActionPerformed

    private void iname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iname1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        summaryrep.getObj().setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void signoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signoutActionPerformed
       logintoindulge.getObj().setVisible(true);
       this.setVisible(false);
       this.dispose();
       
    }//GEN-LAST:event_signoutActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        erasealldata.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void t1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
          try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
            String sql ="Select * from admin where password =?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,t1.getText());
           ResultSet rs;
            rs = ps.executeQuery();
            if(rs.next())
            {
               String sql1="truncate tblvalue";
               PreparedStatement ps1=conn.prepareStatement(sql1);
               ps1.executeQuery();
               String err="Erase Completed!";
               JOptionPane.showMessageDialog(null,"This program will automatically close.\nYou will have to again start the software",err,JOptionPane.INFORMATION_MESSAGE);    
               
               erasealldata.dispose();
               System.exit(0);
            }
            else if(t1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter password");    
            }
            else
            JOptionPane.showMessageDialog(null,"Erase Failed. Password  does not match");
            t1.setText("");
            

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,e);
        }  
        }
    }//GEN-LAST:event_t1KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       erasealldata.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
            String sql ="Select * from admin where password =?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,t1.getText());
           ResultSet rs;
            rs = ps.executeQuery();
            if(rs.next())
            {
               String sql1="truncate tblvalue";
               PreparedStatement ps1=conn.prepareStatement(sql1);
               ps1.executeQuery();
               String err="Erase Completed!";
               JOptionPane.showMessageDialog(null,"This program will automatically close.\nYou will have to again start the software",err,JOptionPane.INFORMATION_MESSAGE);    
               
               erasealldata.dispose();
               System.exit(0);
            }
            else if(t1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter password");    
            }
            else
            JOptionPane.showMessageDialog(null,"Erase Failed. Password  does not match");
            t1.setText("");
            

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,e);
        }
 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jPasswordField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField2KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
            String sql ="Select * from admin where password = ? ";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,jPasswordField2.getText());

            ResultSet rs;
            rs = ps.executeQuery();
            if(rs.next())
            {

                adminactmgmt m1=new adminactmgmt();
                     m1.setVisible(true);
                    this.setVisible(true);
                m1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                
                verifyadmin.dispose();
            }
            else if(jPasswordField2.getText().isEmpty())
            {
                String error="you did't enter ypur password  ";
                JOptionPane.showMessageDialog(null,error,"passwordfield empty",JOptionPane.ERROR_MESSAGE);
                jPasswordField2.setText("");
            }
            else
            JOptionPane.showMessageDialog(null,"passwrod is incorrect");
            jPasswordField2.setText("");

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,e);
        }
    }//GEN-LAST:event_jPasswordField2KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        verifyadmin.dispose();
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(jPasswordField2.getText().isEmpty())
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
                ps.setString(1,jPasswordField2.getText());
                ResultSet rs;
                rs = ps.executeQuery();
                if(rs.next())
                {
                     adminactmgmt m1=new adminactmgmt();
                     this.setVisible(true);
                    m1.setVisible(true);
                 m1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    verifyadmin.dispose();
                }
                else
                JOptionPane.showMessageDialog(null,"username & password does not match");
                jPasswordField2.setText("");
             }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null ,e);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
      verifywaiter.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void usermgmtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usermgmtKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
            String sql ="Select * from admin where password = ? ";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,usermgmt.getText());

            ResultSet rs;
            rs = ps.executeQuery();
            if(rs.next())
            {
                useractmgmt m1=new useractmgmt();
                this.setVisible(true);
                 m1.setVisible(true);
               m1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                verifyadminusermgmt.dispose();
            }
            else if(usermgmt.getText().isEmpty())
            {
                String error="you did't enter ypur password  ";
                JOptionPane.showMessageDialog(null,error,"passwordfield empty",JOptionPane.ERROR_MESSAGE);
                usermgmt.setText("");
            }
            else
            JOptionPane.showMessageDialog(null,"passwrod is incorrect");
            usermgmt.setText("");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,e);
        }
    }//GEN-LAST:event_usermgmtKeyPressed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        verifyadminusermgmt.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
       if(usermgmt.getText().isEmpty())
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
                ps.setString(1,usermgmt.getText());

                ResultSet rs;
                rs = ps.executeQuery();
                if(rs.next())
                {
                    useractmgmt m1=new useractmgmt();
                    this.setVisible(true);
                     m1.setVisible(true);
                    m1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    verifyadminusermgmt.dispose();
                }
                else
                JOptionPane.showMessageDialog(null,"username & password does not match");
                usermgmt.setText("");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null ,e);
            }
        } 
    }//GEN-LAST:event_loginActionPerformed

    private void databaseveriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_databaseveriKeyPressed
      if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn;
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
                String sql ="Select * from admin where password =?";
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1,databaseveri.getText());

                ResultSet rs;
                rs = ps.executeQuery();
                if(rs.next())
                {
                    itemdatabase m1=new itemdatabase();
                    this.setVisible(true);
                    m1.setVisible(true);
                    m1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    verifydatabaseadmin.dispose();
                }
            else if(databaseveri.getText().isEmpty())
            {
                String error="you did't enter ypur password  ";
                JOptionPane.showMessageDialog(null,error,"passwordfield empty",JOptionPane.ERROR_MESSAGE);
                databaseveri.setText("");
            }
            else
            JOptionPane.showMessageDialog(null,"passwrod is incorrect");
            databaseveri.setText("");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,e);
        } 
    }//GEN-LAST:event_databaseveriKeyPressed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        verifydatabaseadmin.dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void logggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logggActionPerformed
      if(databaseveri.getText().isEmpty())
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
                ps.setString(1,databaseveri.getText());

                ResultSet rs;
                rs = ps.executeQuery();
                if(rs.next())
                {
                    itemdatabase m1=new itemdatabase();
                    m1.setVisible(true);
                    this.setVisible(true);
                   // m1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                   verifydatabaseadmin.dispose();
                }
                else
                JOptionPane.showMessageDialog(null," password does not match");
                databaseveri.setText("");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null ,e);
            }
        } 
    }//GEN-LAST:event_logggActionPerformed

    private void jtextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
            String sql ="Select * from admin where password = ? ";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,jtext.getText());

            ResultSet rs;
            rs = ps.executeQuery();
            if(rs.next())
            {
                 waiteractmgmt m1=new waiteractmgmt();
                m1.setVisible(true);
                this.setVisible(true);
                m1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                verifywaiter.dispose();
            }
            else if(jtext.getText().isEmpty())
            {
                String error="you did't enter ypur password  ";
                JOptionPane.showMessageDialog(null,error,"passwordfield empty",JOptionPane.ERROR_MESSAGE);
                jtext.setText("");
            }
            else
            JOptionPane.showMessageDialog(null,"passwrod is incorrect");
            jtext.setText("");
             }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,e);
        }
    }//GEN-LAST:event_jtextKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
verifywaiter.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jbutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutActionPerformed
        if(jtext.getText().isEmpty())
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
                ps.setString(1,jtext.getText());

                ResultSet rs;
                rs = ps.executeQuery();
                if(rs.next())
                {
                    waiteractmgmt m1=new waiteractmgmt();
                     m1.setVisible(true);
                    this.setVisible(true);
                    m1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                   verifywaiter.dispose();
                }
                else
                JOptionPane.showMessageDialog(null,"username & password does not match");
                jtext.setText("");
                 }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null ,e);
            }
        }
    }//GEN-LAST:event_jbutActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    version.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(dupinvno.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Bill no. cannot be blank");
        }
        else{
        dupbillprint();
         try{         
         dupbilltextar.print();
         dupinvno.setText("");
        dupbillbody.setText("");
        dupbilltextar.setText("");
        dupinvno.setFocusable(true);
        DefaultTableModel model=(DefaultTableModel)jTable2dup.getModel();
        while(model.getRowCount() >0){
            for(int i=0; i<model.getRowCount();i++){
                model.removeRow(i);
            }
        }
         }
        catch (java.awt.print.PrinterException e){
        System.err.format("No printer found" ,e.getMessage());
        }}
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
      // clo();
       dupbill.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void dupinvnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dupinvnoKeyReleased
      
        String one=dupinvno.getText();
        char c=evt.getKeyChar();
        if(c==KeyEvent.VK_ENTER){
            evt.consume();
        getToolkit().beep();}
     else if(dupinvno.getText().length()>=4){
       try {
          Class.forName("com.mysql.jdbc.Driver");
         Connection conn;
                   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
        Statement st = conn.createStatement();
        String query = "SELECT iname,qty,rate,amt,total_amt from tblvalue where invoice_no='"+one+"'";
      ResultSet rs;
        rs = st.executeQuery(query);
     if(rs.isBeforeFirst())
     {       
         jTable2dup.setModel(DbUtils.resultSetToTableModel(rs)); 
         conn.close();
     }else{
        JOptionPane.showMessageDialog(null, "there are no such bill like '"+one+"'");
        dupinvno.setText("");
        evt.consume();
     }
}
      
   catch (Exception e) { 
        JOptionPane.showMessageDialog(null,"Got an exception!");
    }
      
    }//GEN-LAST:event_dupinvnoKeyReleased
    }
    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t1ActionPerformed

    private void dupinvnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dupinvnoKeyTyped
     char c=evt.getKeyChar();
        if(!Character.isDigit(c) || c==KeyEvent.VK_BACKSPACE||c==KeyEvent.VK_DELETE){
         evt.consume();
         getToolkit().beep();
        }
        
        if(dupinvno.getText().length() >= 5) {
        evt.consume();
       getToolkit().beep();
     }
     
    }//GEN-LAST:event_dupinvnoKeyTyped

    private void icFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_icFocusGained
     qty.setText("");
    }//GEN-LAST:event_icFocusGained

    private void erasealldataWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_erasealldataWindowClosing
        t1.setText("");
    }//GEN-LAST:event_erasealldataWindowClosing

    private void verifyadminWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_verifyadminWindowClosing
        jPasswordField2.setText("");
    }//GEN-LAST:event_verifyadminWindowClosing

    private void verifyadminusermgmtWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_verifyadminusermgmtWindowClosing
        usermgmt.setText("");
    }//GEN-LAST:event_verifyadminusermgmtWindowClosing

    private void verifydatabaseadminWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_verifydatabaseadminWindowClosing
       databaseveri.setText("");
    }//GEN-LAST:event_verifydatabaseadminWindowClosing

    private void verifywaiterWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_verifywaiterWindowClosing
        jtext.setText("");
    }//GEN-LAST:event_verifywaiterWindowClosing

    private void dupbillWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dupbillWindowClosing
        dupinvno.setText("");
    }//GEN-LAST:event_dupbillWindowClosing

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
         try {
        Desktop.getDesktop().browse(new URL("http://docs.google.com/forms/d/e/1FAIpQLSfocwAI3Mwud3XdqRO7rKKdpDh_kEQe7wYRJjc6oosLTP3JQw/viewform").toURI());
        } 
       catch (Exception e) {
       JOptionPane.showMessageDialog(null,e);
       }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void parcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parcelMouseClicked
       
    }//GEN-LAST:event_parcelMouseClicked

    private void inrestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inrestMouseClicked
       
    }//GEN-LAST:event_inrestMouseClicked

    private void inrestStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inrestStateChanged
    
    }//GEN-LAST:event_inrestStateChanged

    private void parcelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_parcelStateChanged
       
    }//GEN-LAST:event_parcelStateChanged

    private void parcelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_parcelItemStateChanged
        if(!parc.getText().isEmpty()){
           parc.setText("");
       
       }
       else{
          parc.setText("parcel");  
           tblno.setEnabled(false);
        ppl.setEnabled(false);
        tblno.setText("null");
        ppl.setText("null");
       }
      
    }//GEN-LAST:event_parcelItemStateChanged

    private void inrestItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inrestItemStateChanged
       if(!parc.getText().isEmpty()){
           parc.setText("");
       }
       else{
          parc.setText("on table");  
           tblno.setEnabled(true);
        ppl.setEnabled(true);
         tblno.setText("");
        ppl.setText("");
       }
       
    }//GEN-LAST:event_inrestItemStateChanged

    private void parcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_parcActionPerformed

    private void itemdbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemdbbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemdbbActionPerformed

    private void itemdbbKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemdbbKeyReleased
          String one=itemdbb.getText();
        try {
                   Class.forName("com.mysql.jdbc.Driver");
         Connection conn;
                   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","admin");
        Statement st = conn.createStatement();
        String query = "SELECT  icode as ITEM_CODE,iname as ITEM_NAME,iprice as ITEM_PRICE FROM menu WHERE iname LIKE '" + one + "%'";
      ResultSet rs;
        rs = st.executeQuery(query);
      itemData.setModel(DbUtils.resultSetToTableModel(rs)); 

    conn.close();

}
     catch (Exception e) { 
         JOptionPane.showMessageDialog(null,"Got an exception!");
       
    }  
    }//GEN-LAST:event_itemdbbKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(0);
        /*int option = JOptionPane.showOptionDialog(  
                    first.this,  
                    "Are you sure you want to quit?",  
                    "Exit", JOptionPane.YES_NO_OPTION,  
                    JOptionPane.WARNING_MESSAGE, null, null,  
                    null );  
            if( option == JOptionPane.YES_OPTION ) {  
                System.exit( 0 );  
            }*/
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
      logintoindulge.getObj().setVisible(true);
      this.dispose();
      this.setVisible(false);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyActionPerformed
    
   
        public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new first().setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRow;
    private javax.swing.JTextField amt;
    private javax.swing.JTextField amt1;
    private javax.swing.JTextArea billpreview;
    private javax.swing.JTextArea billtextar;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JLabel cashier1;
    private javax.swing.JPasswordField databaseveri;
    private javax.swing.JLabel date;
    private javax.swing.JLabel date1;
    private javax.swing.JButton delRow;
    private javax.swing.JDialog dupbill;
    private javax.swing.JTextArea dupbillbody;
    private javax.swing.JTextArea dupbilltextar;
    private javax.swing.JTextField dupinvno;
    private javax.swing.ButtonGroup dupreciept;
    private javax.swing.JDialog erasealldata;
    private javax.swing.JTextField ic;
    private javax.swing.JTextField iname;
    private javax.swing.JTextField iname1;
    private javax.swing.JRadioButton inrest;
    private javax.swing.JTextField inv;
    private javax.swing.JTextField iprice;
    private javax.swing.JTextField iprice1;
    private javax.swing.JTable itemData;
    private javax.swing.JTextField itemdbb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2dup;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbut;
    private javax.swing.JPasswordField jtext;
    private javax.swing.JButton loggg;
    private javax.swing.JButton login;
    private javax.swing.JTextField parc;
    private javax.swing.JRadioButton parcel;
    private javax.swing.JButton pbtn;
    private javax.swing.JTextField ppl;
    private javax.swing.JTextField qty;
    private javax.swing.JButton signout;
    private javax.swing.JPasswordField t1;
    public static javax.swing.JTextField tamt;
    public static javax.swing.JTextField tblno;
    private javax.swing.JLabel time;
    private javax.swing.JTextField titem;
    private javax.swing.JTextField tqty;
    private javax.swing.JPasswordField usermgmt;
    private javax.swing.JDialog verifyadmin;
    private javax.swing.JDialog verifyadminusermgmt;
    private javax.swing.JDialog verifydatabaseadmin;
    private javax.swing.JDialog verifywaiter;
    private javax.swing.JDialog version;
    private javax.swing.JLabel wname;
    private javax.swing.JTextField wno;
    // End of variables declaration//GEN-END:variables
}
