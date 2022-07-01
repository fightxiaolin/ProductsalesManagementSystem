import sun.net.ConnectionResetException;
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

    private void AddMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void DeleteMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void AlterMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void SearchMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void ConfirmMouseClicked(String Number) {
        // TODO add your code here
        ConfirmModify(Number);
    }

    private void CancelMouseClicked(MouseEvent e) {
        // TODO add your code here
        CancelModify();
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
        CostomerPanel = new JPanel(){
            @Override
            /**
             * 重写该方法以设置背景图片
             */
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(CostomerBackground,0, 0, CostomerBackground.getWidth(), CostomerBackground.getHeight(), null);
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
                cno = result.getString("cno");
                cna = result.getString("cna");
                cad = result.getString("cad");
                cte = result.getString("cte");
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

        //---- comboBox1 ----
        comboBox1.setFont(comboBox1.getFont().deriveFont(comboBox1.getFont().getSize() + 4f));
        contentPane.add(comboBox1);
        comboBox1.setBounds(220, 110, 240, comboBox1.getPreferredSize().height);
        comboBox1.addItem("全部订单");
        comboBox1.addItem("未完成订单");
        comboBox1.addItem("已完成订单");


        //======== scrollPane1 ========
        {
            SQL = "select * from order_info where cno='" + Number + "'";
            try {
                result = stmt.executeQuery(SQL);
                table1 = new JTable(DatabaseConnection.buildTableModel(result));
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
                AddMouseClicked(e);
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
                DeleteMouseClicked(e);
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
                AlterMouseClicked(e);
            }
        });
        contentPane.add(Alter);
        Alter.setBounds(570, 20, 135, 35);
        Alter.setContentAreaFilled(false);

        //---- comboBox2 ----
        comboBox2.setFont(comboBox2.getFont().deriveFont(comboBox2.getFont().getSize() + 4f));
        contentPane.add(comboBox2);
        comboBox2.setBounds(220, 75, 130, comboBox2.getPreferredSize().height);
        contentPane.add(InputText);
        comboBox2.setOpaque(false);
        comboBox2.addItem("订单号");
        comboBox2.addItem("供应商号");
        comboBox2.addItem("订货项数");
        comboBox2.addItem("订货日期");
        comboBox2.addItem("付款金额");

        //---- InputText ----
        InputText.setBounds(360, 75, 455, comboBox2.getPreferredSize().height);
        InputText.setOpaque(false);

        //---- Search ----
        Search.setText("\u67e5\u8be2");
        Search.setFont(Search.getFont().deriveFont(Search.getFont().getSize() + 4f));
        Search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SearchMouseClicked(e);
            }
        });
        contentPane.add(Search);
        Search.setBounds(new Rectangle(new Point(845, 75), Search.getPreferredSize()));
        Search.setContentAreaFilled(false);

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
    private JComboBox comboBox1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton Add;
    private JButton Delete;
    private JButton Alter;
    private JButton Confirm;
    private JButton Cancel;
    private JComboBox comboBox2;
    private JTextField InputText;
    private JButton Search;
    private JPanel CostomerPanel;
    private JTextField UserNumText;
    private JTextField UserNameText;
    private JTextField PhoneNumberText;
    private JTextField AddressText;
    private JTextField CreditText;
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
        /*//---- UserNum ----
        UserNumText.setText(UserNum.getText());
        UserNumText.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(UserNumText);
        UserNumText.setBounds(70, 135, 135, 25);*/

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

    private void ConfirmModify(String Number){
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

    private void CancelModify(){
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


}
