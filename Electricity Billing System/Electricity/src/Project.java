import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener{
    String meter;
    Project(String meter, String person){
        super("Electricity Billing System");
        this.meter = meter;

        setSize(720,720);

        /* Adding background image */
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("customer-bg.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1900, 950,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        add(l1);

        // create menu bar

        JMenuBar mb  = new JMenuBar();

        /* First Column */

        JMenu masterMenu = new JMenu("masterMenu");
        JMenuItem newCustomerMenu = new JMenuItem("New Customer");
        JMenuItem customerDetailsMenu = new JMenuItem("Customer Details");
        JMenuItem depositDetailsMenu = new JMenuItem("Deposit Details");
        JMenuItem billDetailsMenu = new JMenuItem("Calculate Bill");
        masterMenu.setForeground(Color.BLUE);


        /* ---- Customer Details ---- */
        newCustomerMenu.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        newCustomerMenu.setIcon(new ImageIcon(image1));
        newCustomerMenu.setMnemonic('D');
        newCustomerMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        newCustomerMenu.setBackground(Color.WHITE);

        /* ---- Meter Details ---- */
        customerDetailsMenu.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        customerDetailsMenu.setIcon(new ImageIcon(image2));
        customerDetailsMenu.setMnemonic('M');
        customerDetailsMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        customerDetailsMenu.setBackground(Color.WHITE);

        /* ---- Deposit Details  ----- */
        depositDetailsMenu.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        depositDetailsMenu.setIcon(new ImageIcon(image3));
        depositDetailsMenu.setMnemonic('N');
        depositDetailsMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        depositDetailsMenu.setBackground(Color.WHITE);

        billDetailsMenu.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon5.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        billDetailsMenu.setIcon(new ImageIcon(image5));
        billDetailsMenu.setMnemonic('B');
        billDetailsMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        billDetailsMenu.setBackground(Color.WHITE);


        newCustomerMenu.addActionListener(this);
        customerDetailsMenu.addActionListener(this);
        depositDetailsMenu.addActionListener(this);
        billDetailsMenu.addActionListener(this);

        /* Second Column */
        JMenu info = new JMenu("Information");
        JMenuItem info1 = new JMenuItem("Update Information");
        JMenuItem info2 = new JMenuItem("View Information");

        info.setForeground(Color.RED);

        /* ---- Pay Bill ---- */
        info1.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon41 = new ImageIcon(ClassLoader.getSystemResource("icon4.png"));
        Image image41 = icon41.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        info1.setIcon(new ImageIcon(image41));
        info1.setMnemonic('P');
        info1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        info1.setBackground(Color.WHITE);

        /* ---- Last Bill ----*/
        info2.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon42 = new ImageIcon(ClassLoader.getSystemResource("icon6.png"));
        Image image42 = icon42.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        info2.setIcon(new ImageIcon(image42));
        info2.setMnemonic('L');
        info2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        info2.setBackground(Color.WHITE);

        info1.addActionListener(this);
        info2.addActionListener(this);

        JMenu user = new JMenu("User");
        JMenuItem userBillMenuItem = new JMenuItem("Pay Bill");

        JMenuItem userBilldetailsMenuItem = new JMenuItem("Bill Details");
        user.setForeground(Color.RED);

        /* ---- Pay Bill ---- */
        userBillMenuItem.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon4.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        userBillMenuItem.setIcon(new ImageIcon(image4));
        userBillMenuItem.setMnemonic('P');
        userBillMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        userBillMenuItem.setBackground(Color.WHITE);

        /* ---- Last Bill ----*/
        userBilldetailsMenuItem.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        userBilldetailsMenuItem.setIcon(new ImageIcon(image6));
        userBilldetailsMenuItem.setMnemonic('L');
        userBilldetailsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        userBilldetailsMenuItem.setBackground(Color.WHITE);

        userBillMenuItem.addActionListener(this);
        userBilldetailsMenuItem.addActionListener(this);

        JMenu report = new JMenu("Report");
        JMenuItem generateBillItem = new JMenuItem("Generate Bill");
        report.setForeground(Color.BLUE);

        /* ---- Report ---- */
        generateBillItem.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon7.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        generateBillItem.setIcon(new ImageIcon(image7));
        generateBillItem.setMnemonic('R');
        generateBillItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        generateBillItem.setBackground(Color.WHITE);

        generateBillItem.addActionListener(this);

        JMenu utility = new JMenu("Utility");
        JMenuItem notepadMenuItem = new JMenuItem("Notepad");
        JMenuItem calculatorMenuItem = new JMenuItem("Calculator");
        //JMenuItem webMenuItem = new JMenuItem("Web Browser");
        utility.setForeground(Color.RED);

        /* ---- Calender ---- */
        notepadMenuItem.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon12.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        notepadMenuItem.setIcon(new ImageIcon(image8));
        notepadMenuItem.setMnemonic('C');
        notepadMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        notepadMenuItem.setBackground(Color.WHITE);

        /* ---- Calculator ---- */
        calculatorMenuItem.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon9.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        calculatorMenuItem.setIcon(new ImageIcon(image9));
        calculatorMenuItem.setMnemonic('X');
        calculatorMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        calculatorMenuItem.setBackground(Color.WHITE);

        /* ---- Web Browser ---- */
//        webMenuItem.setFont(new Font("monospaced",Font.PLAIN,12));
//        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon10.png"));
//        Image image10 = icon10.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
//        webMenuItem.setIcon(new ImageIcon(image10));
//        webMenuItem.setMnemonic('W');
//        webMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
//        webMenuItem.setBackground(Color.WHITE);


        notepadMenuItem.addActionListener(this);
        calculatorMenuItem.addActionListener(this);
        //webMenuItem.addActionListener(this);

        JMenu exit = new JMenu("Logout");
        JMenuItem ex = new JMenuItem("Logout");
        exit.setForeground(Color.BLUE);

        /* ---- Exit ---- */
        ex.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon11.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ex.setIcon(new ImageIcon(image11));
        ex.setMnemonic('Z');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        ex.setBackground(Color.WHITE);

        ex.addActionListener(this);

        masterMenu.add(newCustomerMenu);
        masterMenu.add(customerDetailsMenu);
        masterMenu.add(depositDetailsMenu);
        masterMenu.add(billDetailsMenu);

        info.add(info1);
        info.add(info2);

        user.add(userBillMenuItem);
        user.add(userBilldetailsMenuItem);

        report.add(generateBillItem);

        utility.add(notepadMenuItem);
        utility.add(calculatorMenuItem);
        //utility.add(webMenuItem);

        exit.add(ex);

        if(person.equals("Admin")){
            mb.add(masterMenu);
        }else{
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        mb.add(utility);
        mb.add(exit);

        setJMenuBar(mb);

        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
    }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Customer Details")){
            new CustomerDetails().setVisible(true);

        }else if(msg.equals("New Customer")){
            new NewCustomer().setVisible(true);

        }else if(msg.equals("Calculate Bill")){
            new CalculateBill().setVisible(true);

        }else if(msg.equals("Pay Bill")){
            new PayBill(meter).setVisible(true);

        }else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Logout")){
            this.setVisible(false);
            new Login().setVisible(true);
        }else if(msg.equals("Generate Bill")){
            new GenerateBill(meter).setVisible(true);

        }else if(msg.equals("Deposit Details")){
            new DepositDetails().setVisible(true);
        }else if(msg.equals("View Information")){
            new ViewInformation(meter).setVisible(true);
        }else if(msg.equals("Update Information")){
            new UpdateInformation(meter).setVisible(true);
        }else if(msg.equals("Bill Details")){
            new BillDetails(meter).setVisible(true);
        }


    }


    public static void main(String[] args){
        new Project("", "").setVisible(true);
    }

}