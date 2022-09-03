import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Tue Jun 28 10:33:09 CST 2022
 */



/**
 * @author unknown
 */
public class OrderManage extends JFrame {
    public OrderManage() {
        initComponents();
    }

    public OrderManage(final String Number){
        initComponents();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                OrderwindowClosing(Number);
                dispose();
            }
        });
    }



    private void CheckMouseClicked(MouseEvent e) {
        // TODO add your code here
        int selectedRow = Ordertable.getSelectedRow();
        String Number = Ordertable.getValueAt(selectedRow, 0).toString().trim();
        new OrderDetailsDialog(this, true, Number).setVisible(true);
    }

    private void HandleMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void WithdrawMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void RefreshMouseClicked(MouseEvent e) {
        // TODO add your code here
        showOrderTable();
    }

    private void ResearchMouseClicked(MouseEvent e) {
        // TODO add your code here
        String text = textField1.getText();
        String SQL = null;
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        ResultSet result;
        if(OrderNum.isSelected())
        {
            SQL = "select * from Order_info where sno='" + text + "'";
        }
        else if(SupplyNum.isSelected())
        {
            SQL = "select * from Order_info where gno='" + text + "'";
        }
        else if(Address.isSelected())
        {
            SQL = "select * from Order_info where scity='" + text + "'";
        }
        else if(OrderDate.isSelected())
        {
            SQL = "select * from Order_info where sdrq ='" + text + "'";
        }
        else if(DeliveryDate.isSelected())
        {//
            SQL = "select * from Order_info where sjrq ='" + text + "'";
        }
        else if(Payment.isSelected())
        {
            SQL = "select * from Order_info where toprice ='" + text + "'";
        }
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            Ordertable = new JTable(buildOrderTableModel(result, -1));
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        Ordertable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        scrollPane.setViewportView(Ordertable);
    }

    //将日期型的时间转化成字符串
    public void DataTransform(String avg){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
    }

    private void RangeResearchMouseClicked(MouseEvent e) {

        // TODO add your code here
        String text = Rangelower.getText();
        String text1 = Rangeupper.getText();
        String SQL = null;
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        ResultSet result;
        if( RangeOrderDate.isSelected())
        {
            SQL = "select * from Order_info where sdrq<='" + text1 + "' and sdrq>='" + text + "'";
        }
        else if(RangeDeliveryDate.isSelected())
        {
            SQL = "select * from Order_info where sjrq<='" + text1 + "' and sjrq>='" + text + "'";
        }
        else if(RangePayment.isSelected())
        {
            SQL = "select * from Order_info where toprice<='" + text1 + "' and toprice>='" + text + "'";
        }
        else if(Rangecount.isSelected())
        {
            SQL = "select * from Order_info where snu<='" + text1 + "' and snu>='" + text + "'";
        }
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            Ordertable = new JTable(buildOrderTableModel(result, -1));
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        Ordertable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        scrollPane.setViewportView(Ordertable);
    }

    private void OrderwindowClosing(String UserNum) {
        new ManagerFrame(UserNum).setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        scrollPane = new JScrollPane();
        Ordertable = new JTable();
        Check = new JButton();
        Handle = new JButton();
        Withdraw = new JButton();
        label2 = new JLabel();
        OrderNum = new JRadioButton();
        Address = new JRadioButton();
        DeliveryDate = new JRadioButton();
        SupplyNum = new JRadioButton();
        OrderDate = new JRadioButton();
        Payment = new JRadioButton();
        textField1 = new JTextField();
        Research = new JButton();
        label3 = new JLabel();
        RangeOrderDate = new JRadioButton();
        RangePayment = new JRadioButton();
        RangeDeliveryDate = new JRadioButton();
        Rangecount = new JRadioButton();
        Rangelower = new JTextField();
        label4 = new JLabel();
        Rangeupper = new JTextField();
        RangeResearch = new JButton();
        Refresh = new JButton();
        OrderPanel = new JPanel(){
            @Override
            /**
             * 重写该方法以设置背景图片
             */
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
            }
        };
        //======== OrderPanel ========
        OrderPanel.setSize(1200, 590);



        //======== this ========
        setContentPane(OrderPanel);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("\u8ba2\u5355\u7ba1\u7406\u7cfb\u7edf");
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        //label1.setText("\u8ba2\u5355\u7ba1\u7406\u7cfb\u7edf");
        //label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 48));
        //label1.setHorizontalAlignment(SwingConstants.CENTER);
        //contentPane.add(label1);
        //label1.setBounds(70, 35, 435, 55);

        //======== scrollPane ========
        {
            showOrderTable();
        }

        contentPane.add(scrollPane);
        scrollPane.setBounds(0, 5, 825, 565);

        //---- Check ----
        Check.setText("\u67e5\u770b\u8ba2\u5355");
        Check.setFont(Check.getFont().deriveFont(Check.getFont().getSize() + 4f));
        Check.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CheckMouseClicked(e);
            }
        });
        contentPane.add(Check);
        Check.setBounds(840, 45, 140, 45);

        //---- Handle ----
        Handle.setText("\u5904\u7406\u8ba2\u5355");
        Handle.setFont(Handle.getFont().deriveFont(Handle.getFont().getSize() + 4f));
        Handle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                HandleMouseClicked(e);
            }
        });
        contentPane.add(Handle);
        Handle.setBounds(1005, 45, 140, 45);

        //---- Withdraw ----
        Withdraw.setText("\u64a4\u56de\u8ba2\u5355");
        Withdraw.setFont(Withdraw.getFont().deriveFont(Withdraw.getFont().getSize() + 4f));
        Withdraw.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                WithdrawMouseClicked(e);
            }
        });
        contentPane.add(Withdraw);
        Withdraw.setBounds(840, 115, 140, 45);

        //---- label2 ----
        label2.setText("\u9009\u62e9\u67e5\u8be2\u7c7b\u578b\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
        contentPane.add(label2);
        label2.setBounds(840, 200, 130, 25);

        //---- OrderNum ----
        OrderNum.setText("\u8ba2\u5355\u53f7");
        OrderNum.setFont(OrderNum.getFont().deriveFont(OrderNum.getFont().getSize() + 2f));
        contentPane.add(OrderNum);
        OrderNum.setBounds(845, 245, 140, 20);

        //---- Address ----
        Address.setText("\u6536\u8d27\u5730");
        Address.setFont(Address.getFont().deriveFont(Address.getFont().getSize() + 2f));
        contentPane.add(Address);
        Address.setBounds(845, 275, 140, 20);

        //---- DeliveryDate ----
        DeliveryDate.setText("\u4ea4\u8d27\u65e5\u671f");
        DeliveryDate.setFont(DeliveryDate.getFont().deriveFont(DeliveryDate.getFont().getSize() + 2f));
        contentPane.add(DeliveryDate);
        DeliveryDate.setBounds(845, 305, 140, 20);

        //---- SupplyNum ----
        SupplyNum.setText("\u4f9b\u5e94\u5546\u53f7");
        SupplyNum.setFont(SupplyNum.getFont().deriveFont(SupplyNum.getFont().getSize() + 2f));
        contentPane.add(SupplyNum);
        SupplyNum.setBounds(1005, 245, 140, 20);

        //---- OrderDate ----
        OrderDate.setText("\u8ba2\u8d27\u65e5\u671f");
        OrderDate.setFont(OrderDate.getFont().deriveFont(OrderDate.getFont().getSize() + 2f));
        OrderDate.setActionCommand("\u8ba2\u8d27\u65e5\u671f");
        contentPane.add(OrderDate);
        OrderDate.setBounds(1005, 275, 140, 20);

        //---- Payment ----
        Payment.setText("\u4ed8\u6b3e\u91d1\u989d");
        Payment.setFont(Payment.getFont().deriveFont(Payment.getFont().getSize() + 2f));
        contentPane.add(Payment);
        Payment.setBounds(1005, 305, 140, 20);
        contentPane.add(textField1);
        textField1.setBounds(850, 345, 175, 30);

        //---- Research ----
        Research.setText("\u67e5\u8be2");
        Research.setFont(Research.getFont().deriveFont(Research.getFont().getSize() + 2f));
        Research.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ResearchMouseClicked(e);
            }
        });
        contentPane.add(Research);
        Research.setBounds(new Rectangle(new Point(1040, 345), Research.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u9009\u62e9\u8303\u56f4\u7c7b\u578b\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        contentPane.add(label3);
        label3.setBounds(840, 400, 130, 25);

        //---- RangeOrderDate ----
        RangeOrderDate.setText("\u8ba2\u8d27\u65e5\u671f");
        RangeOrderDate.setFont(RangeOrderDate.getFont().deriveFont(RangeOrderDate.getFont().getSize() + 2f));
        contentPane.add(RangeOrderDate);
        RangeOrderDate.setBounds(845, 445, 140, 20);

        //---- RangePayment ----
        RangePayment.setText("\u4ed8\u6b3e\u91d1\u989d");
        RangePayment.setFont(RangePayment.getFont().deriveFont(RangePayment.getFont().getSize() + 2f));
        contentPane.add(RangePayment);
        RangePayment.setBounds(845, 475, 140, 20);

        //---- RangeDeliveryDate ----
        RangeDeliveryDate.setText("\u4ea4\u8d27\u65e5\u671f");
        RangeDeliveryDate.setFont(RangeDeliveryDate.getFont().deriveFont(RangeDeliveryDate.getFont().getSize() + 2f));
        contentPane.add(RangeDeliveryDate);
        RangeDeliveryDate.setBounds(1005, 445, 140, 20);

        //---- Rangecount ----
        Rangecount.setText("\u8ba2\u8d27\u9879\u6570");
        Rangecount.setFont(Rangecount.getFont().deriveFont(Rangecount.getFont().getSize() + 2f));
        contentPane.add(Rangecount);
        Rangecount.setBounds(1005, 475, 140, 20);
        contentPane.add(Rangelower);
        Rangelower.setBounds(835, 520, 105, 30);

        //---- label4 ----
        label4.setText("~");
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
        contentPane.add(label4);
        label4.setBounds(940, 525, 30, label4.getPreferredSize().height);
        contentPane.add(Rangeupper);
        Rangeupper.setBounds(970, 520, 105, 30);

        //---- RangeResearch ----
        RangeResearch.setText("\u67e5\u8be2");
        RangeResearch.setFont(RangeResearch.getFont().deriveFont(RangeResearch.getFont().getSize() + 2f));
        RangeResearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RangeResearchMouseClicked(e);
            }
        });
        contentPane.add(RangeResearch);
        RangeResearch.setBounds(new Rectangle(new Point(1085, 520), RangeResearch.getPreferredSize()));

        //---- Refresh ----
        Refresh.setText("\u5237\u65b0\u8ba2\u5355");
        Refresh.setFont(Refresh.getFont().deriveFont(Refresh.getFont().getSize() + 4f));
        Refresh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RefreshMouseClicked(e);
            }
        });
        contentPane.add(Refresh);
        Refresh.setBounds(1005, 115, 140, 45);

        ButtonGroup ResearchGroup = new ButtonGroup();
        ResearchGroup.add(Address);
        ResearchGroup.add(Payment);
        ResearchGroup.add(SupplyNum);
        ResearchGroup.add(OrderDate);
        ResearchGroup.add(OrderNum);
        ResearchGroup.add(DeliveryDate);
        OrderNum.setSelected(true);

        ButtonGroup RangeGroup = new ButtonGroup();
        RangeGroup.add(Rangecount);
        RangeGroup.add(RangePayment);
        RangeGroup.add(RangeOrderDate);
        RangeGroup.add(RangeDeliveryDate);
        RangeOrderDate.setSelected(true);

        setSize(1200, 620);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static DefaultTableModel buildOrderTableModel(ResultSet rs, int i) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        Vector columnNames = new Vector();

        int columnCount = metaData.getColumnCount();

        /*for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }*/
        columnNames.add("订单号");
        columnNames.add("供应商号");
        columnNames.add("订货项数");
        columnNames.add("订货日期");
        columnNames.add("交货日期");
        columnNames.add("付款金额");
        columnNames.add("发货地");
        columnNames.add("收货地");
        columnNames.add("顾客号");
//        columnNames.add("订单状态");

        Vector data = new Vector();

        while (rs.next()) {
            Vector vector = new Vector();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                try{
                    vector.add(rs.getString(columnIndex).trim());
                }catch (Exception e){
                    vector.add(null);
                }
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }

    public static void main(String[] args) {
        new OrderManage().setVisible(true);
    }

    private void showOrderTable(){
        Connection con = DatabaseConnection.getConnection();
        ResultSet result = null;
        Statement stmt = null;
        String SQL = "select * from order_info";
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            Ordertable = new JTable(buildOrderTableModel(result, -1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        scrollPane.setViewportView(Ordertable);
    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JScrollPane scrollPane;
    private JTable Ordertable;
    private JButton Check;
    private JButton Handle;
    private JButton Withdraw;
    private JLabel label2;
    private JRadioButton OrderNum;
    private JRadioButton Address;
    private JRadioButton DeliveryDate;
    private JRadioButton SupplyNum;
    private JRadioButton OrderDate;
    private JRadioButton Payment;
    private JTextField textField1;
    private JButton Research;
    private JLabel label3;
    private JRadioButton RangeOrderDate;
    private JRadioButton RangePayment;
    private JRadioButton RangeDeliveryDate;
    private JRadioButton Rangecount;
    private JTextField Rangelower;
    private JLabel label4;
    private JTextField Rangeupper;
    private JButton RangeResearch;
    private JButton Refresh;
    private JPanel OrderPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
