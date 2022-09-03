import util.MyOptionPane;
import util.Res;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Result;
/*
 * Created by JFormDesigner on Thu Aug 04 11:46:52 CST 2022
 */



/**
 * @author unknown
 */
public class AddNewOrderFrame<preparedstatement> extends JFrame {
    public AddNewOrderFrame() {
//        initComponents();
    }

    public AddNewOrderFrame(final String Number) {
        initComponents(Number);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new CustomerFrame(Number).setVisible(true);
            }
        });
    }

    private void addNewProductMouseClicked(MouseEvent e) {
        // TODO add your code here
        int selectRow = ProductTable.getSelectedRow();
        String quantity = "";
        while(quantity.isEmpty()){
            quantity = MyOptionPane.showInputDialog(this, "提示","请输入你要订购的数量：");
            if(quantity == null){
                break;
            }
        }
        String pno = ProductTable.getValueAt(selectRow, 0).toString().trim();
        String pna = ProductTable.getValueAt(selectRow, 1).toString().trim();
        String gno = ProductTable.getValueAt(selectRow, 2).toString().trim();
        String gna = ProductTable.getValueAt(selectRow, 3).toString().trim();
        int price = Integer.parseInt(ProductTable.getValueAt(selectRow, 4).toString().trim());
        int surplus = Integer.parseInt(ProductTable.getValueAt(selectRow, 5).toString().trim());
        int row = CheckingContain(pno);
        int boughtcount = 0;
        if(row != -1)
            boughtcount = Integer.parseInt(OrderTable.getValueAt(row,4).toString().trim());
        if(quantity != null){
            if(surplus>=Integer.parseInt(quantity)+boughtcount){
                DefaultTableModel orderTableModel = (DefaultTableModel) OrderTable.getModel();
                if(row == -1){
                    orderTableModel.insertRow(OrderTable.getRowCount(), new Object[]{pno, pna, gno, gna, Integer.parseInt(quantity), Integer.parseInt(quantity)*price});
                }
                else{
                    int total = Integer.parseInt(orderTableModel.getValueAt(row, 4).toString().trim()) + Integer.parseInt(quantity);
                    orderTableModel.setValueAt(total, row, 4);
                    orderTableModel.setValueAt(total*price, row, 5);
                }
            }
            else{
                MyOptionPane.showMessageDialog(this, "该产品余量不足，请重新填写！", "提示");
            }
        }


    }

    private void submitOrderMouseClicked(String Number) {
        // TODO add your code here
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd");  //2022 08 18
        int tableRow = OrderTable.getRowCount();
        int totalMoney = 0;
        //这里有个Hash表，分不同供应商用的，
        HashMap<String, String> map = new HashMap<String, String>();
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        String getAddr = MyOptionPane.showInputDialog(this,"", "请输入收货地址：");


        for (int i = 0; i < tableRow; i++) {
            totalMoney += Integer.parseInt(OrderTable.getValueAt(i, 5).toString().trim());
            String gno = OrderTable.getValueAt(i, 2).toString().trim();
            if(map.get(gno) == null){
                String orderNum = getOrderNum();
                map.put(gno, orderNum);
                String SQL = null;
                ResultSet result = null;
                String city = null;
                SQL = "select * from g_info where gno='" + gno + "'";
                try {
                    stmt = con.createStatement();
                    result = stmt.executeQuery(SQL);
                    result.next();
                    city = result.getString("city").trim();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                SQL = "insert into order_info values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
//                SQL = "insert into order_info values('" + orderNum + "', '" + gno + "', '" + tableRow + "', '" + sdfTime.format(new Date())
//                            + "', '" + "交货日期" + "','" + totalMoney + "', '" + "发货地" + "', '" + "收货地" + "', '" + Number + "')";
                try {
                    stmt = con.createStatement();
                    PreparedStatement ps = con.prepareStatement(SQL);
                    ps.setString(1, orderNum);
                    ps.setString(2, gno);
                    ps.setString(3, "0");
                    ps.setDate(4, new java.sql.Date(new Date().getTime()));
                    ps.setDate(5, new java.sql.Date(new Date(new Date().getTime() + 3 * 24 * 60 * 60 * 1000L).getTime()));
                    ps.setInt(6, 0);
                    ps.setString(7, city);
                    ps.setString(8, getAddr);
                    ps.setString(9, Number);
                    ps.executeUpdate();
//                    stmt.executeUpdate(SQL);
//                    System.out.println("插入数据： " +  SQL);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        String detailedOrderNum = "";
        for (int i = 0; i < tableRow; i++) {
            detailedOrderNum = getDetailedOrderNum();   //订单细则号
//            System.out.println(detailedOrderNum);
            String pno = OrderTable.getValueAt(i, 0).toString().trim();
            String gno = OrderTable.getValueAt(i, 2).toString().trim();
            String orderNum = map.get(gno);
            int ssnu = Integer.parseInt(OrderTable.getValueAt(i, 4).toString().trim());
            String SQL = "insert into order_details values ('" + detailedOrderNum + "', '" + pno + "', " + ssnu + ", '" + orderNum + "')";
            try {
                stmt = con.createStatement();
                stmt.executeUpdate(SQL);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            updateSurplus(pno, gno, ssnu);
            updateorder(orderNum, Integer.parseInt(OrderTable.getValueAt(i, 5).toString().trim()));
        }

        MyOptionPane.showMessageDialog(this, "总付款金额为：" + totalMoney, "请支付！");
        dispose();
        new CustomerFrame(Number).setVisible(true);


    }

    private void updateorder(String orderNum, int totalMoney){
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        ResultSet result = null;
        String SQL = "select * from order_info where sno='" + orderNum + "'";
        int snu = 0;
        int toprice = 0;
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            result.next();
            snu = Integer.parseInt(result.getString("snu").trim());
            toprice = Integer.parseInt(result.getString("toprice").trim());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        snu++;
        toprice += totalMoney;
        SQL = "update order_info set snu='" + Integer.toString(snu) + "', toprice=" + toprice + " where sno ='" + orderNum + "'";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     *
     */
    private void updateSurplus(String pno, String gno, int quantity){
        String SQL = "select * from god_info where gno='" + gno + "' and pno='" + pno + "'";
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        ResultSet result = null;
        int surplus = 0;
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            result.next();
            surplus = Integer.parseInt(result.getString("surplus").trim());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        SQL = "update god_info set surplus=" + (surplus - quantity) + " where gno='" + gno + "' and pno='" + pno + "'";
        try {
            stmt.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 生成订单号
     * 该订单号由当前时间（年月日精确到毫秒（毫秒有三位））和3位随机数组合而成
     * @return
     */
    private String getOrderNum(){
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String before = sdfTime.format(new Date());

        Random r = new Random();
        int rand = r.nextInt(900) + 100;
        String after = Integer.toString(rand);
        return before+after;
    }

    /**
     * 生成详细订单号
     * 该详细订单号由当前时间（精确到毫秒（毫秒有三位））和4位随机数组合而成
     * @return
     */
    private String getDetailedOrderNum(){
        SimpleDateFormat sdfTime = new SimpleDateFormat("HHmmssSS");
        String before =  sdfTime.format(new Date());

        Random r = new Random();
        int rand =  r.nextInt(9000)+1000;
        String after = Integer.toString(rand);
        return before+after;
    }



    private void deleteProductMouseClicked(MouseEvent e) {
        // TODO add your code here
        int selectedrow = OrderTable.getSelectedRow();
        DefaultTableModel orderTableModel = (DefaultTableModel) OrderTable.getModel();
        orderTableModel.removeRow(selectedrow);
    }

    private void initComponents(final String Number) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ProductTablescrollPane = new JScrollPane();
        OrderTableScrollPane = new JScrollPane();
        label1 = new JLabel();
        label2 = new JLabel();
        addNewProduct = new JButton();
        submitOrder = new JButton();
        deleteProduct = new JButton();

        //======== this ========
        setTitle("\u4ea7\u54c1\u8ba2\u8d2d");
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== ProductTablescrollPane ========
        {
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = null;
            ResultSet result = null;
            String SQL = "select P.pno, P.pna, G.gno ,G.gna, God.price, God.surplus from g_info G, god_info God, product_info P where P.pno=God.pno and G.gno=God.gno";
            try {
                stmt = con.createStatement();
                result = stmt.executeQuery(SQL);
                ProductTable = new JTable(buildTableModel(result));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            ProductTablescrollPane.setViewportView(ProductTable);
        }
        contentPane.add(ProductTablescrollPane);
        ProductTablescrollPane.setBounds(5, 50, 450, 580);

        //======== OrderTableScrollPane ========
        {
            try {
                OrderTable = new JTable(buildOrderModel(null));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            OrderTableScrollPane.setViewportView(OrderTable);
        }
        contentPane.add(OrderTableScrollPane);
        OrderTableScrollPane.setBounds(545, 50, 450, 580);

        //---- label1 ----
        label1.setText("\u4ea7\u54c1");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label1);
        label1.setBounds(185, 0, 90, 45);

        //---- label2 ----
        label2.setText("\u8ba2\u5355");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label2);
        label2.setBounds(725, 0, 90, 45);

        //---- addNewProduct ----
        addNewProduct.setText("\u52a0\u5165\u8ba2\u5355");
        addNewProduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addNewProductMouseClicked(e);
            }
        });
        contentPane.add(addNewProduct);
        addNewProduct.setBounds(165, 655, 130, addNewProduct.getPreferredSize().height);

        //---- submitOrder ----
        submitOrder.setText("\u63d0\u4ea4\u8ba2\u5355");
        submitOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                submitOrderMouseClicked(Number);
            }
        });
        contentPane.add(submitOrder);
        submitOrder.setBounds(625, 655, 130, 30);

        //---- deleteProduct ----
        deleteProduct.setText("\u5220\u9664");
        deleteProduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteProductMouseClicked(e);
            }
        });
        contentPane.add(deleteProduct);
        deleteProduct.setBounds(790, 655, 130, 30);

        setSize(1015, 750);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane ProductTablescrollPane;
    private JTable ProductTable;
    private JScrollPane OrderTableScrollPane;
    private JTable OrderTable;
    private JLabel label1;
    private JLabel label2;
    private JButton addNewProduct;
    private JButton submitOrder;
    private JButton deleteProduct;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        new AddNewOrderFrame().setVisible(true);
    }

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        Vector columnNames = new Vector();

        int columnCount = metaData.getColumnCount();

        /*for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }*/
        columnNames.add("产品号");
        columnNames.add("产品名");
        columnNames.add("供应商号");
        columnNames.add("供应商名");
        columnNames.add("单价");
        columnNames.add("余量");

        Vector data = new Vector();

        while (rs.next()) {
            Vector vector = new Vector();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                try{
                    vector.add(rs.getString(columnIndex).trim());
                }
                catch (Exception e){
                    vector.add(null);
                }
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public static DefaultTableModel buildOrderModel(ResultSet rs) throws SQLException {

        Vector columnNames = new Vector();

        int columnCount = 5;

        /*for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }*/
        columnNames.add("产品号");
        columnNames.add("产品名");
        columnNames.add("供应商名");
        columnNames.add("供应商名");
        columnNames.add("数量");
        columnNames.add("总计");

        Vector data = new Vector();

        return new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    private int CheckingContain(String Number){
        int max = OrderTable.getRowCount();
        for(int i=0; i<max; i++){
            if(Number.equals(OrderTable.getValueAt(i,0).toString().trim())){
                return i;
            }
        }
        return -1;
    }
}
