import util.MyOptionPane;
import util.Res;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Mon Jun 27 14:19:59 CST 2022
 */

/**
 * @author unknown
 */
public class CustomerFrame extends JFrame implements Res {
    public CustomerFrame(String UserNum) {
        initComponents(UserNum);
    }

    private void modifyMouseClicked(String Number) {
        // TODO add your code here
        ModifyImformation(Number);
    }

    private void AddMouseClicked(String Number) {
        // TODO add your code here
        new AddNewOrderFrame(Number).setVisible(true);
        dispose();
    }

    private void DeleteMouseClicked(String Number) {
        // TODO add your code here
        int row = table1.getSelectedRow();
        String sno = table1.getValueAt(row, 0).toString().trim();
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        ResultSet result = null;
        String SQL = "delete from order_details where sno='" + sno + "'\n"
                + "delete from order_info where sno='" + sno + "'";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            SQL = "select * from order_info where cno='" + Number + "'";
            result = stmt.executeQuery(SQL);
            table1 = new JTable(buildTableModel(result, -1, 0));
            scrollPane1.setViewportView(table1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void AlterMouseClicked(String Number) {
        // TODO add your code here
        editRow = table1.getSelectedRow();
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        ResultSet result = null;
        String SQL = "select * from order_info where cno='" + Number + "'";
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            table1 = new JTable(buildTableModel(result, editRow, 0));
            table1.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
            scrollPane1.setViewportView(table1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        alterComfirm.setVisible(true);
        alterConcel.setVisible(true);
        Alter.setVisible(false);
    }

    /**
     * 实现用户根据不同类型的查询功能
     * @param Number    用户号
     */
    private void SearchMouseClicked(String Number) {
        // TODO add your code here
        int selected = comboBox1.getSelectedIndex();
        String Text = InputText.getText();
        String SQL = "select * from order_info where cno='" + Number + "' and ";
        switch (selected){
            case 0:
                SQL += "sno='" + Text + "'";
                break;
            case 1:
                SQL += "gno='" + Text + "'";
                break;
            case 2:
                SQL += "snu='" + Text + "'";
                break;
            case 3:
                SQL += "sdrq='" + Text + "'";
                break;
            case 4:
                SQL += "toprice=" + Text ;
                break;
        }
//        System.out.println(SQL + "\t" + selected);
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        ResultSet result = null;
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            table1 = new JTable(buildTableModel(result, -1, 0));
            scrollPane1.setViewportView(table1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void comboBox2itemChanged(ItemEvent e, String Number) {
        if(e.getStateChange() == ItemEvent.SELECTED){
            //e.getItem():获取当前选中的项名称
//            System.out.println(e.getItem());
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = null;
            ResultSet result = null;
            String SQL = "select * from order_info where cno='" + Number + "'";
            try {
                stmt = con.createStatement();
                result = stmt.executeQuery(SQL);
                table1 = new JTable(buildTableModel(result, -1, 0));
                scrollPane1.setViewportView(table1);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void ConfirmMouseClicked(String Number) {
        // TODO add your code here
        Container contentPane = getContentPane();
        contentPane.remove(UserNumText);
        contentPane.remove(UserNameText);
        contentPane.remove(AddressText);
        contentPane.remove(CreditText);
        contentPane.remove(PhoneNumberText);
        contentPane.remove(Confirm);
        contentPane.remove(Cancel);
        contentPane.add(modify);
        contentPane.repaint();
        UserName.setText(UserNameText.getText());
        PhoneNumber.setText(PhoneNumberText.getText());
        Address.setText(AddressText.getText());

        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        String SQL = "update customer_info set cna='" + UserNameText.getText() + "'"
                + ", cad='" + AddressText.getText() + "'" + ", cte='" + PhoneNumberText.getText() + "'"
                + "where cno='" + Number + "'";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            System.out.println("资料修改成功了！！！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void CancelMouseClicked(MouseEvent e) {
        // TODO add your code here
        Container contentPane = getContentPane();
        contentPane.remove(UserNumText);
        contentPane.remove(UserNameText);
        contentPane.remove(AddressText);
        contentPane.remove(CreditText);
        contentPane.remove(PhoneNumberText);
        contentPane.remove(Confirm);
        contentPane.remove(Cancel);
        contentPane.add(modify);
        contentPane.repaint();
    }

    private void logoutMouseClicked(MouseEvent e) {
        // TODO add your code here
        if(MyOptionPane.showConfirmDialog(this, "提示", "你确认要退出登录？", "确认", "取消")){
            dispose();
            new LoginFrame().setVisible(true);
        }
    }

    private void alterComfirmMouseClicked(String Number){
        String sno = table1.getValueAt(editRow, 0).toString().trim();
        String gno = table1.getValueAt(editRow, 1).toString().trim();
        String snu = table1.getValueAt(editRow, 2).toString().trim();
        String sdrq =  table1.getValueAt(editRow, 3).toString().trim();
        String sjrq = table1.getValueAt(editRow, 4).toString().trim();
        String toprice = table1.getValueAt(editRow, 5).toString().trim();
        String fcity = table1.getValueAt(editRow, 6).toString().trim();
        String scity = table1.getValueAt(editRow, 7).toString().trim();
        String cno = table1.getValueAt(editRow, 8).toString().trim();

        String SQL = "update order_info set gno='" + gno + "', snu='" + snu + "', sdrq='" + sdrq + "', sjrq ='"
                + sjrq + "', toprice='" + Integer.parseInt(toprice) + "', fcity='" + fcity + "', scity='"
                + scity + "' where sno='" + sno + "'";
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        ResultSet result = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            SQL = "select * from order_info where cno='" + Number + "'";
            result = stmt.executeQuery(SQL);
            table1 = new JTable(buildTableModel(result, -1, 0));
            table1.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
            scrollPane1.setViewportView(table1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        alterComfirm.setVisible(false);
        alterConcel.setVisible(false);
        Alter.setVisible(true);
    }

    private void alterConcelMouseClicked(String Number){
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        ResultSet result = null;
        String SQL = "select * from order_info where cno='" + Number + "'";
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            table1 = new JTable(buildTableModel(result, -1, 0));
            table1.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
            scrollPane1.setViewportView(table1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        alterComfirm.setVisible(false);
        alterConcel.setVisible(false);
        Alter.setVisible(true);
    }

    private void initComponents(String Number) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        UserNum = new JLabel();
        UserName = new JLabel();
        PhoneNumber = new JLabel();
        Address = new JLabel();
        Credit = new JLabel();
        modify = new JButton();
        comboBox1 = new JComboBox();
        scrollPane1 = new JScrollPane();
        Add = new JButton();
        Delete = new JButton();
        Alter = new JButton();
        comboBox2 = new JComboBox();
        InputText = new JTextField();
        Search = new JButton();
        logout = new JButton();
        alterComfirm = new JButton();
        alterConcel = new JButton();
        CostomerPanel = new JPanel(){
            @Override
            /**
             * 重写该方法以设置背景图片
             */
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
//                g.drawImage(CostomerBackground,0, 0, CostomerBackground.getWidth(), CostomerBackground.getHeight(), null);
            }
        };

        Connection con = DatabaseConnection.getConnection();
        ResultSet result = null;
        Statement stmt= null;
        String SQL = "select * from customer_info where cno=" + "'" + Number + "'";
        String cno = null, cna = null, cad = null, cte = null, cco = null;
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            if(result.next()){
                cno = result.getString("cno").trim();
                cna = result.getString("cna").trim();
                cad = result.getString("cad").trim();
                cte = result.getString("cte").trim();
                cco = result.getString("cco");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //======== this ========
        setContentPane(CostomerPanel);
        setTitle("\u7528\u6237\u8ba2\u5355\u7ba1\u7406\u7cfb\u7edf");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(label1);
        label1.setBounds(60, 30, 70, 80);

        //---- label2 ----
        label2.setText("\u7528\u6237\u53f7\uff1a");
        label2.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(label2);
        label2.setBounds(15, 135, 55, 25);

        //---- label3 ----
        label3.setText("\u7528\u6237\u540d\uff1a");
        label3.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(label3);
        label3.setBounds(15, 175, 55, 25);

        //---- label4 ----
        label4.setText("\u7535\u8bdd\uff1a");
        label4.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(label4);
        label4.setBounds(15, 215, 55, 25);

        //---- label5 ----
        label5.setText("\u5730\u5740\uff1a");
        label5.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(label5);
        label5.setBounds(15, 255, 55, 25);

        //---- label6 ----
        label6.setText("\u4fe1\u8d37\u60c5\u51b5\uff1a");
        label6.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(label6);
        label6.setBounds(15, 295, 70, 25);

        //---- UserNum ----
        UserNum.setText(cno);
        UserNum.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(UserNum);
        UserNum.setBounds(70, 135, 135, 25);

        //---- UserName ----
        UserName.setText(cna);
        UserName.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(UserName);
        UserName.setBounds(70, 175, 135, 25);

        //---- PhoneNumber ----
        PhoneNumber.setText(cte);
        PhoneNumber.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(PhoneNumber);
        PhoneNumber.setBounds(70, 215, 135, 25);

        //---- Address ----
        Address.setText(cad);
        Address.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(Address);
        Address.setBounds(70, 255, 135, 25);

        //---- Credit ----
        Credit.setText(cco);
        Credit.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(Credit);
        Credit.setBounds(85, 295, 135, 25);

        //---- modify ----
        modify.setText("\u4fee\u6539\u8d44\u6599");
        modify.setFont(modify.getFont().deriveFont(modify.getFont().getSize() + 4f));
        modify.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modifyMouseClicked(Number);
            }
        });
        contentPane.add(modify);
        modify.setBounds(15, 345, 145, 30);
        modify.setContentAreaFilled(false);


        //======== scrollPane1 ========
        {
            SQL = "select * from order_info where cno='" + Number + "'";
            try {
                result = stmt.executeQuery(SQL);
                table1 = new JTable(buildTableModel(result, -1, 0));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            scrollPane1.setViewportView(table1);
        }

        contentPane.add(scrollPane1);
        scrollPane1.setBounds(220, 145, 765, 435);

        //---- Add ----
        Add.setText("\u6dfb\u52a0\u8ba2\u5355");
        Add.setFont(Add.getFont().deriveFont(Add.getFont().getSize() + 4f));
        Add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddMouseClicked(Number);
            }
        });
        contentPane.add(Add);
        Add.setBounds(230, 20, 135, 35);
        Add.setContentAreaFilled(false);

        //---- Delete ----
        Delete.setText("\u5220\u9664\u8ba2\u5355");
        Delete.setFont(Delete.getFont().deriveFont(Delete.getFont().getSize() + 4f));
        Delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DeleteMouseClicked(Number);
            }
        });
        contentPane.add(Delete);
        Delete.setBounds(400, 20, 135, 35);
        Delete.setContentAreaFilled(false);

        //---- Alter ----
        Alter.setText("\u4fee\u6539\u8ba2\u5355");
        Alter.setFont(Alter.getFont().deriveFont(Alter.getFont().getSize() + 4f));
        Alter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AlterMouseClicked(Number);
            }
        });
        contentPane.add(Alter);
        Alter.setBounds(570, 20, 135, 35);
        Alter.setContentAreaFilled(false);

        //---- comboBox1 ----
        comboBox2.setFont(comboBox2.getFont().deriveFont(comboBox2.getFont().getSize() + 4f));
        contentPane.add(comboBox2);
        comboBox2.setBounds(220, 110, 240, comboBox2.getPreferredSize().height);
        comboBox2.addItem("全部订单");
        comboBox2.addItem("未完成订单");
        comboBox2.addItem("已完成订单");
        comboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                comboBox2itemChanged(e, Number);
            }
        });

        //---- comboBox2 ----
        comboBox1.setFont(comboBox1.getFont().deriveFont(comboBox1.getFont().getSize() + 4f));
        contentPane.add(comboBox1);
        comboBox1.setBounds(220, 75, 130, comboBox2.getPreferredSize().height);
        contentPane.add(InputText);
        comboBox1.setOpaque(false);
        comboBox1.addItem("订单号");
        comboBox1.addItem("供应商号");
        comboBox1.addItem("订货项数");
        comboBox1.addItem("订货日期");
        comboBox1.addItem("付款金额");

        //---- InputText ----
        InputText.setBounds(360, 75, 455, comboBox2.getPreferredSize().height);
        InputText.setOpaque(false);

        //---- Search ----
        Search.setText("\u67e5\u8be2");
        Search.setFont(Search.getFont().deriveFont(Search.getFont().getSize() + 4f));
        Search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SearchMouseClicked(Number);
            }
        });
        contentPane.add(Search);
        Search.setBounds(new Rectangle(new Point(845, 75), Search.getPreferredSize()));
        Search.setContentAreaFilled(false);

        //---- logout ----
        logout.setText("退出登录");
        logout.setFont(logout.getFont().deriveFont(logout.getFont().getSize() + 4f));
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logoutMouseClicked(e);
            }
        });
        contentPane.add(logout);
        logout.setBounds(30, 510, 175, 50);
        logout.setContentAreaFilled(false);

        //---- alterComfirm ----
        alterComfirm.setText("\u786e\u8ba4");
        alterComfirm.setFont(alterComfirm.getFont().deriveFont(alterComfirm.getFont().getSize()));
        alterComfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                alterComfirmMouseClicked(Number);
            }
        });
        contentPane.add(alterComfirm);
        alterComfirm.setVisible(false);
        alterComfirm.setBounds(570, 20, 65, 35);

        //---- alterConcel ----
        alterConcel.setText("\u53d6\u6d88");
        alterConcel.setFont(alterConcel.getFont().deriveFont(alterConcel.getFont().getSize()));
        alterConcel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                alterConcelMouseClicked(Number);
            }
        });
        contentPane.add(alterConcel);
        alterConcel.setVisible(false);
        alterConcel.setBounds(640, 20, 65, 35);

        setSize(1000, 620);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel UserNum;
    private JLabel UserName;
    private JLabel PhoneNumber;
    private JLabel Address;
    private JLabel Credit;
    private JButton modify;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton Add;
    private JButton Delete;
    private JButton Alter;
    private JButton Confirm;
    private JButton Cancel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField InputText;
    private JButton Search;
    private JPanel CostomerPanel;
    private JTextField UserNumText;
    private JTextField UserNameText;
    private JTextField PhoneNumberText;
    private JTextField AddressText;
    private JTextField CreditText;
    private JButton logout;
    private JButton alterComfirm;
    private JButton alterConcel;
    private int editRow;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void ModifyImformation(String Number){

        UserNumText = new JTextField();
        UserNameText = new JTextField();
        PhoneNumberText = new JTextField();
        AddressText = new JTextField();
        CreditText = new JTextField();
        Confirm = new JButton();
        Cancel = new JButton();

        Container contentPane = getContentPane();
        //---- UserName ----
        UserNameText.setText(UserName.getText());
        UserNameText.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(UserNameText);
        UserNameText.setBounds(70, 175, 135, 25);

        //---- PhoneNumber ----
        PhoneNumberText.setText(PhoneNumber.getText());
        PhoneNumberText.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(PhoneNumberText);
        PhoneNumberText.setBounds(70, 215, 135, 25);

        //---- Address ----
        AddressText.setText(Address.getText());
        AddressText.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(AddressText);
        AddressText.setBounds(70, 255, 135, 25);

        /*//---- Credit ----
        CreditText.setText(Credit.getText());
        CreditText.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(CreditText);
        CreditText.setBounds(85, 295, 120, 25);*/

        contentPane.remove(modify);
        contentPane.repaint();

        //---- Confirm ----
        Confirm.setText("确认");
        Confirm.setFont(Confirm.getFont().deriveFont(Confirm.getFont().getSize() + 4f));
        Confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ConfirmMouseClicked(Number);
            }
        });
        contentPane.add(Confirm);
        Confirm.setBounds(15, 345, 70, 30);
        Confirm.setContentAreaFilled(false);
        //---- Cancel ----
        Cancel.setText("取消");
        Cancel.setFont(Cancel.getFont().deriveFont(Cancel.getFont().getSize() + 4f));
        Cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CancelMouseClicked(e);
            }
        });
        contentPane.add(Cancel);
        Cancel.setBounds(100, 345, 70, 30);
        Cancel.setContentAreaFilled(false);
    }


    public static DefaultTableModel buildTableModel(ResultSet rs, int er, int unec) throws SQLException {

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
                if(row == er && column != unec && column != 8){
                    return true;
                }
                else
                    return false;
            }
        };
    }

}
