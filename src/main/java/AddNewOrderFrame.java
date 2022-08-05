import util.MyOptionPane;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Thu Aug 04 11:46:52 CST 2022
 */



/**
 * @author unknown
 */
public class AddNewOrderFrame extends JFrame {
    public AddNewOrderFrame() {
        initComponents();
    }

    public AddNewOrderFrame(String Number) {
        initComponents();
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
        if(quantity != null){
            if(surplus>=Integer.parseInt(quantity)){
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
                MyOptionPane.showMessageDialog(this, "输入数量错误！", "提示");
            }
        }


    }

    private void submitOrderMouseClicked(MouseEvent e) {
        // TODO add your code here
        /*surplus = surplus - Integer.parseInt(quantity);
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        String SQL = "update god_info set surplus=" + surplus + "where pno='" + pno + "' and gno='" + gno + "'";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
        String orderNum = getOrderNum();
        String detailedOrderNum = "";

    }

    /**
     * 生成订单号
     * 该订单号由当前时间（年月日精确到毫秒）和6位随机数组合而成
     * @return
     */
    private String getOrderNum(){
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        String before =  sdfTime.format(new Date()).replace("[[\\s-:punct:]]", "");

        Random r = new Random();
        int rand =  r.nextInt(900000)+100000;
        String after = String.valueOf(rand);
        return before+after;
    }

    /**
     * 生成订单号
     * 该订单号由当前时间（精确到毫秒）和4位随机数组合而成
     * @return
     */
    private String getDetailedOrderNum(){
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss:SS");
        String before =  sdfTime.format(new Date()).replace("[[\\s-:punct:]]", "");

        Random r = new Random();
        int rand =  r.nextInt(9000)+1000;
        String after = String.valueOf(rand);
        return before+after;
    }



    private void deleteProductMouseClicked(MouseEvent e) {
        // TODO add your code here
        int selectedrow = OrderTable.getSelectedRow();
        DefaultTableModel orderTableModel = (DefaultTableModel) OrderTable.getModel();
        orderTableModel.removeRow(selectedrow);
    }

    private void initComponents() {
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
                submitOrderMouseClicked(e);
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
