import javafx.beans.binding.ObjectExpression;
import javafx.scene.control.RadioButton;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/*
 * Created by JFormDesigner on Mon Jun 27 23:05:44 CST 2022
 */
/**
 * @author unknown
 */
public class ProductManage extends JFrame {
    public ProductManage() {
        initComponents();//在界面添加各个组件，并为它们注册监听器
    }

    public ProductManage(String UserNum)
    {
        initComponents();
        addWindowListener(new WindowAdapter() {//在窗口添加一个Windows事件消息，在关闭窗口的时候可以正常的退出
            @Override
            public void windowClosing(WindowEvent e) {



                ProductwindowClosing(UserNum);
                dispose();
            }
        });
    }

    private void ProductwindowClosing(String UserNum) {
        // TODO add your code here
        new ManagerFrame(UserNum).setVisible(true);
        dispose();
    }

    private void AddMouseClicked(MouseEvent e) {
        // TODO add your code here
        int rowcount = Producttable.getRowCount();
        showProductImformation(rowcount);
        DefaultTableModel model = (DefaultTableModel) Producttable.getModel();
        model.insertRow(rowcount, new Object[]{null, null, null, null, null, null, null});
        Add.setVisible(false);
        AddConfirm.setVisible(true);
        AddCancel.setVisible(true);
    }

    private void AlterMouseClicked(MouseEvent e) {
        // TODO add your code here
        editRow = Producttable.getSelectedRow();
        showProductImformation(editRow, 0);
        Alter.setVisible(false);
        AlterConfirm.setVisible(true);
        AlterCancel.setVisible(true);
    }

    private void DeleteMouseClicked(MouseEvent e) {
        // TODO add your code here
        int row = Producttable.getSelectedRow();
        String pno = Producttable.getValueAt(row, 0).toString().trim();
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        String SQL = "delete from product_info where pno='" + pno + "'";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        showProductImformation(-1);
    }

    private void RefreshMouseClicked(MouseEvent e) {
        // TODO add your code here
        showProductImformation(-1);
    }

    private void ResearchMouseClicked(MouseEvent e) {
        // TODO add your code here
        String text = textField1.getText();
        String SQL = null;
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        ResultSet result;
        ProductNum.isSelected();
        if( ProductNum.isSelected())
        {
            SQL = "select P.pno, P.pna, G.gno, G.gna, P.pwe, God.price, God.surplus from product_info P, g_info G, god_info God where P.pno=God.pno and G.gno=God.gno and P.pno='" + text + "'";
        }
        else if(SupplyNum.isSelected())
        {
            SQL = "select P.pno, P.pna, G.gno, G.gna, P.pwe, God.price, God.surplus from product_info P, g_info G, god_info God where P.pno=God.pno and G.gno=God.gno and G.gno ='" + text + "'";
        }
        else if(ProductName.isSelected())
        {
            SQL = "select P.pno, P.pna, G.gno, G.gna, P.pwe, God.price, God.surplus from product_info P, g_info G, god_info God where P.pno=God.pno and G.gno=God.gno and P.pna ='" + text + "'";
        }
        else if(SupplyName.isSelected())
        {
            SQL = "select P.pno, P.pna, G.gno, G.gna, P.pwe, God.price, God.surplus from product_info P, g_info G, god_info God where P.pno=God.pno and G.gno=God.gno and G.gna ='" + text + "'";
        }
        else if(ProductPrice.isSelected())
        {
            SQL = "select P.pno, P.pna, G.gno, G.gna, P.pwe, God.price, God.surplus from product_info P, g_info G, god_info God where P.pno=God.pno and G.gno=God.gno and P.pwe =" + Integer.valueOf(text);
        }
        else if(ProductWeight.isSelected())
        {
            SQL = "select P.pno, P.pna, G.gno, G.gna, P.pwe, God.price, God.surplus from product_info P, g_info G, god_info God where P.pno=God.pno and G.gno=God.gno and God.price =" + Integer.valueOf(text);
        }
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            Producttable = new JTable(buildProductTableModel(result, -1));
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        Producttable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        scrollPane.setViewportView(Producttable);
    }

    private void RangeResearchMouseClicked(MouseEvent e) {
        // TODO add your code here
        String text1 = Rangelower.getText();
        String text2 = Rangeupper.getText();
        String SQL = null;
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        ResultSet result;
        ProductNum.isSelected();
        if( RangePrice.isSelected())
        {
            SQL = "select P.pno, P.pna, G.gno, G.gna, P.pwe, God.price, God.surplus from product_info P, g_info G, god_info God where P.pno=God.pno and G.gno=God.gno and God.price>='" + text1 + "'and God.price<='" + text2 + "'";
        }
        else if(RangeWeight.isSelected())
        {
            SQL = "select P.pno, P.pna, G.gno, G.gna, P.pwe, God.price, God.surplus from product_info P, g_info G, god_info God where P.pno=God.pno and G.gno=God.gno and P.pwe>='" + text1 + "'and P.pwe<='" + text2 + "'";
        }
        else if(RangeSurplus.isSelected())
        {
            SQL = "select P.pno, P.pna, G.gno, G.gna, P.pwe, God.price, God.surplus from product_info P, g_info G, god_info God where P.pno=God.pno and G.gno=God.gno and God.surplus>='" + text1 + "'and God.surplus<='" + text2 + "'";
        }


        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            Producttable = new JTable(buildProductTableModel(result, -1));
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        Producttable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        scrollPane.setViewportView(Producttable);
    }

    private void AddConfirmMouseClicked(MouseEvent e) {
        // TODO add your code here
        int row = Producttable.getRowCount() - 1;
        String  pno = Producttable.getValueAt(row, 0).toString().trim();
        String  pna = Producttable.getValueAt(row, 1).toString().trim();
        String  gno = Producttable.getValueAt(row, 2).toString().trim();
        String  gna = Producttable.getValueAt(row, 3).toString().trim();
        String  pwe = Producttable.getValueAt(row, 4).toString().trim();
        String  price = Producttable.getValueAt(row, 5).toString().trim();
        String  surplus = Producttable.getValueAt(row, 6).toString().trim();
        String SQL = "insert into product_info(pno, pna, pwe) values('" + pno + "', '" + pna + "', "+ Integer.valueOf(pwe) + ");\n"
                + "insert into g_info(gno, gna) values('" + gno + "', '" + gna + "');\n"
                + "insert into god_info values('" + gno + "', '" + pno + "', " + Integer.valueOf(price) + "," + Integer.valueOf(surplus) + ")";

        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        showProductImformation(-1);
        AddConfirm.setVisible(false);
        AddCancel.setVisible(false);
        Add.setVisible(true);
    }

    private void AddCancelMouseClicked(MouseEvent e) {
        // TODO add your code here
        showProductImformation(-1);
        AddConfirm.setVisible(false);
        AddCancel.setVisible(false);
        Add.setVisible(true);
    }

    private void AlterConfirmMouseClicked(MouseEvent e) {
        // TODO add your code here
        String pno = Producttable.getValueAt(editRow, 0).toString().trim();
        String pna = Producttable.getValueAt(editRow, 1).toString().trim();
        String gno = Producttable.getValueAt(editRow, 2).toString().trim();
        String gna =  Producttable.getValueAt(editRow, 3).toString().trim();
        String pwe = Producttable.getValueAt(editRow, 4).toString().trim();
        String price = Producttable.getValueAt(editRow, 5).toString().trim();
        String surplus = Producttable.getValueAt(editRow, 6).toString().trim();

        String SQL = "update product_info set pna='" + pna + "', pwe=" + Integer.valueOf(pwe) + " where pno='" + pno + "'\n"
                + "update g_info set gna='" + gna + "' where gno='" + gno + "'\n"
                + "update god_info set price=" + Integer.valueOf(price) + ", surplus=" + Integer.valueOf(surplus) + "where pno='" + pno +"' and gno='" + gno + "'";
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        showProductImformation(-1);
        AlterConfirm.setVisible(false);
        AlterCancel.setVisible(false);
        Alter.setVisible(true);
    }

    private void AlterCancelMouseClicked(MouseEvent e) {
        // TODO add your code here
        showProductImformation(-1);
        Alter.setVisible(true);
        AlterConfirm.setVisible(false);
        AlterCancel.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        Title = new JLabel();
        scrollPane = new JScrollPane();
        Producttable = new JTable();
        Add = new JButton();
        Alter = new JButton();
        Delete = new JButton();
        Refresh = new JButton();
        label2 = new JLabel();
        ProductNum = new JRadioButton();
        ProductName = new JRadioButton();
        ProductPrice = new JRadioButton();
        SupplyNum = new JRadioButton();
        SupplyName = new JRadioButton();
        ProductWeight = new JRadioButton();
        textField1 = new JTextField();
        Research = new JButton();
        label3 = new JLabel();
        RangePrice = new JRadioButton();
        RangeSurplus = new JRadioButton();
        RangeWeight = new JRadioButton();
        RangeAnother = new JRadioButton();
        Rangelower = new JTextField();
        label4 = new JLabel();
        Rangeupper = new JTextField();
        RangeResearch = new JButton();
        AddConfirm = new JButton();
        AddCancel = new JButton();
        AlterCancel = new JButton();
        AlterConfirm = new JButton();
        ProductPanel = new JPanel(){
            @Override
            /**
             * 重写该方法以设置背景图片
             */
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };

        //======== this ========
        setContentPane(ProductPanel);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- Title ----
        Title.setText("\u4ea7\u54c1\u7ba1\u7406\u7cfb\u7edf");
        Title.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 30));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(Title);
        Title.setBounds(90, 30, 435, 55);

        showProductImformation(-1);

        contentPane.add(scrollPane);
        scrollPane.setBounds(5, 140, 610, 445);

        //---- Add ----
        Add.setText("\u6dfb\u52a0\u4ea7\u54c1");
        Add.setFont(Add.getFont().deriveFont(Add.getFont().getSize() + 4f));
        Add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddMouseClicked(e);
            }
        });
        contentPane.add(Add);
        Add.setBounds(665, 40, 140, 45);

        //---- Alter ----
        Alter.setText("\u4fee\u6539\u4ea7\u54c1");
        Alter.setFont(Alter.getFont().deriveFont(Alter.getFont().getSize() + 4f));
        Alter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AlterMouseClicked(e);
            }
        });
        contentPane.add(Alter);
        Alter.setBounds(830, 40, 140, 45);

        //---- Delete ----
        Delete.setText("\u5220\u9664\u4ea7\u54c1");
        Delete.setFont(Delete.getFont().deriveFont(Delete.getFont().getSize() + 4f));
        Delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DeleteMouseClicked(e);
            }
        });
        contentPane.add(Delete);
        Delete.setBounds(665, 110, 140, 45);

        //---- Refresh ----
        Refresh.setText("\u5237\u65b0\u4ea7\u54c1");
        Refresh.setFont(Refresh.getFont().deriveFont(Refresh.getFont().getSize() + 4f));
        Refresh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RefreshMouseClicked(e);
            }
        });
        contentPane.add(Refresh);
        Refresh.setBounds(830, 110, 140, 45);

        //---- label2 ----
        label2.setText("\u9009\u62e9\u67e5\u8be2\u7c7b\u578b\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
        contentPane.add(label2);
        label2.setBounds(665, 195, 130, 25);

        //---- ProductNum ----
        ProductNum.setText("\u4ea7\u54c1\u53f7");
        ProductNum.setFont(ProductNum.getFont().deriveFont(ProductNum.getFont().getSize() + 2f));
        contentPane.add(ProductNum);
        ProductNum.setBounds(670, 240, 140, 20);

        //---- ProductName ----
        ProductName.setText("\u4ea7\u54c1\u540d");
        ProductName.setFont(ProductName.getFont().deriveFont(ProductName.getFont().getSize() + 2f));
        contentPane.add(ProductName);
        ProductName.setBounds(670, 270, 140, 20);

        //---- ProductPrice ----
        ProductPrice.setText("\u5355\u4ef7");
        ProductPrice.setFont(ProductPrice.getFont().deriveFont(ProductPrice.getFont().getSize() + 2f));
        contentPane.add(ProductPrice);
        ProductPrice.setBounds(670, 300, 140, 20);

        //---- SupplyNum ----
        SupplyNum.setText("\u4f9b\u5e94\u5546\u53f7");
        SupplyNum.setFont(SupplyNum.getFont().deriveFont(SupplyNum.getFont().getSize() + 2f));
        contentPane.add(SupplyNum);
        SupplyNum.setBounds(830, 240, 140, 20);

        //---- SupplyName ----
        SupplyName.setText("\u4f9b\u5e94\u5546\u540d");
        SupplyName.setFont(SupplyName.getFont().deriveFont(SupplyName.getFont().getSize() + 2f));
        contentPane.add(SupplyName);
        SupplyName.setBounds(830, 270, 140, 20);

        //---- ProductWeight ----
        ProductWeight.setText("\u91cd\u91cf");
        ProductWeight.setFont(ProductWeight.getFont().deriveFont(ProductWeight.getFont().getSize() + 2f));
        contentPane.add(ProductWeight);
        ProductWeight.setBounds(830, 300, 140, 20);
        contentPane.add(textField1);
        textField1.setBounds(675, 340, 175, 30);

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
        Research.setBounds(new Rectangle(new Point(865, 340), Research.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u9009\u62e9\u8303\u56f4\u7c7b\u578b\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        contentPane.add(label3);
        label3.setBounds(665, 395, 130, 25);

        //---- RangePrice ----
        RangePrice.setText("\u5355\u4ef7");
        RangePrice.setFont(RangePrice.getFont().deriveFont(RangePrice.getFont().getSize() + 2f));
        contentPane.add(RangePrice);
        RangePrice.setBounds(670, 440, 140, 20);

        //---- RangeSurplus ----
        RangeSurplus.setText("\u4f59\u91cf");
        RangeSurplus.setFont(RangeSurplus.getFont().deriveFont(RangeSurplus.getFont().getSize() + 2f));
        contentPane.add(RangeSurplus);
        RangeSurplus.setBounds(670, 470, 140, 20);

        //---- RangeWeight ----
        RangeWeight.setText("\u91cd\u91cf");
        RangeWeight.setFont(RangeWeight.getFont().deriveFont(RangeWeight.getFont().getSize() + 2f));
        contentPane.add(RangeWeight);
        RangeWeight.setBounds(830, 440, 140, 20);

        //---- RangeAnother ----
        RangeAnother.setText("\u5176\u5b83");
        RangeAnother.setFont(RangeAnother.getFont().deriveFont(RangeAnother.getFont().getSize() + 2f));
        contentPane.add(RangeAnother);
        RangeAnother.setBounds(830, 470, 140, 20);
        contentPane.add(Rangelower);
        Rangelower.setBounds(660, 515, 105, 30);

        //---- label4 ----
        label4.setText("~");
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
        contentPane.add(label4);
        label4.setBounds(765, 520, 30, label4.getPreferredSize().height);
        contentPane.add(Rangeupper);
        Rangeupper.setBounds(795, 515, 105, 30);

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
        RangeResearch.setBounds(new Rectangle(new Point(910, 515), RangeResearch.getPreferredSize()));

        //---- AddConfirm ----
        AddConfirm.setText("\u786e\u8ba4");
        AddConfirm.setFont(AddConfirm.getFont().deriveFont(AddConfirm.getFont().getSize()));
        AddConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddConfirmMouseClicked(e);
            }
        });
        contentPane.add(AddConfirm);
        AddConfirm.setBounds(665, 40, 60, 45);

        AddConfirm.setVisible(false);

        //---- AddCancel ----
        AddCancel.setText("\u53d6\u6d88");
        AddCancel.setFont(AddCancel.getFont().deriveFont(AddCancel.getFont().getSize()));
        AddCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddCancelMouseClicked(e);
            }
        });
        contentPane.add(AddCancel);
        AddCancel.setBounds(745, 40, 60, 45);
        AddCancel.setVisible(false);

        //---- AlterCancel ----
        AlterCancel.setText("\u53d6\u6d88");
        AlterCancel.setFont(AlterCancel.getFont().deriveFont(AlterCancel.getFont().getSize()));
        AlterCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AlterCancelMouseClicked(e);
            }
        });
        contentPane.add(AlterCancel);
        AlterCancel.setBounds(910, 40, 60, 45);
        AlterCancel.setVisible(false);

        //---- AlterConfirm ----
        AlterConfirm.setText("\u786e\u8ba4");
        AlterConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AlterConfirmMouseClicked(e);
            }
        });
        contentPane.add(AlterConfirm);
        AlterConfirm.setBounds(830, 40, 60, 45);
        AlterConfirm.setVisible(false);

        ButtonGroup ResearchGroup = new ButtonGroup();
        ResearchGroup.add(ProductName);
        ResearchGroup.add(ProductNum);
        ResearchGroup.add(SupplyNum);
        ResearchGroup.add(ProductPrice);
        ResearchGroup.add(ProductWeight);
        ResearchGroup.add(SupplyName);
        ProductNum.setSelected(true);
        ResearchGroup.getSelection();

        ButtonGroup RangeGroup = new ButtonGroup();
        RangeGroup.add(RangeAnother);
        RangeGroup.add(RangePrice);
        RangeGroup.add(RangeWeight);
        RangeGroup.add(RangeSurplus);
        RangePrice.setSelected(true);

        setSize(1000,620);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel Title;
    private JScrollPane scrollPane;
    private JTable Producttable;
    private JButton Add;
    private JButton Alter;
    private JButton Delete;
    private JButton Refresh;
    private JLabel label2;
    private JRadioButton ProductNum;
    private JRadioButton ProductName;
    private JRadioButton ProductPrice;
    private JRadioButton SupplyNum;
    private JRadioButton SupplyName;
    private JRadioButton ProductWeight;
    private JTextField textField1;
    private JButton Research;
    private JLabel label3;
    private JRadioButton RangePrice;
    private JRadioButton RangeSurplus;
    private JRadioButton RangeWeight;
    private JRadioButton RangeAnother;
    private JTextField Rangelower;
    private JLabel label4;
    private JTextField Rangeupper;
    private JButton RangeResearch;
    private JPanel ProductPanel;
    private JButton AddConfirm;
    private JButton AddCancel;
    private JButton AlterCancel;
    private JButton AlterConfirm;
    private int editRow;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    /**
     * 显示product_info表中的数据导JTable中，其中editrow行可进行编辑，如果参数editrow为-1即不可编辑
     */
    private void showProductImformation(int editrow){
        Connection con = DatabaseConnection.getConnection();
        ResultSet result = null;
        Statement stmt = null;
        String SQL = "select P.pno, P.pna, G.gno, G.gna, P.pwe, God.price, God.surplus from product_info P,g_info G, god_info God where P.pno=God.pno and G.gno=God.gno";
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            Producttable = new JTable(buildProductTableModel(result, editrow));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Producttable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        scrollPane.setViewportView(Producttable);
    }

    /**
     * 在JTable中显示product_info表中的数据，其中editrow行可进行编辑，uneditcol列不可进行编辑
     * @param editrow   可进行编辑行
     * @param uneditcol 不可进行编辑列
     */
    private void showProductImformation(int editrow, int uneditcol){
        Connection con = DatabaseConnection.getConnection();
        ResultSet result = null;
        Statement stmt = null;
        String SQL = "select P.pno, P.pna, G.gno, G.gna, P.pwe, God.price, God.surplus from product_info P,g_info G, god_info God " +
                "where P.pno=God.pno and G.gno=God.gno";
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            Producttable = new JTable(buildProductTableModel(result, editrow, uneditcol));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Producttable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        scrollPane.setViewportView(Producttable);
    }


    /**
     *根据查询结果ResultSet生成一个product_info表的默认Table模型DefaultTableModel，其中仅er行可进行编辑
     * @param rs    SQL语句查询结果
     * @param er    可进行编辑行
     * @return
     * @throws SQLException
     */
    public static DefaultTableModel buildProductTableModel(ResultSet rs, int er) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();
        Vector columnNames = new Vector();

        int columnCount = metaData.getColumnCount();
        columnNames.add("产品号");
        columnNames.add("产品名");
        columnNames.add("供应商号");
        columnNames.add("供应商名");
        columnNames.add("产品重量");
        columnNames.add("单价");
        columnNames.add("余量");

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
        return new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(row == er){
                    return true;
                }
                else
                    return false;
            }
        };
    }

    /**
     * 根据查询结果ResultSet生成一个product_info表的默认Table模型DefaultTableModel，其中仅er行可进行编辑，且unec列不可进行编辑
     * @param rs    SQL语句的查询结果
     * @param er    可进行编辑行editrow
     * @param unec  不可进行编辑列uneditcolumn
     * @return
     * @throws SQLException
     */
    public static DefaultTableModel buildProductTableModel(ResultSet rs, int er, int unec) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();
        Vector columnNames = new Vector();

        int columnCount = metaData.getColumnCount();
        columnNames.add("产品号");
        columnNames.add("产品名");
        columnNames.add("供应商号");
        columnNames.add("供应商名");
        columnNames.add("产品重量");
        columnNames.add("单价");
        columnNames.add("余量");

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
        return new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(row == er && column != unec){
                    return true;
                }
                else
                    return false;
            }
        };
    }
}
