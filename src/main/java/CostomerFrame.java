import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Jun 27 14:19:59 CST 2022
 */



/**
 * @author unknown
 */
public class CostomerFrame extends JFrame {
    public CostomerFrame() {
        initComponents();
    }

    private void modifyMouseClicked(MouseEvent e) {
        // TODO add your code here
        ModifyImformation();
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

    private void ConfirmMouseClicked(MouseEvent e) {
        // TODO add your code here
        ConfirmModify();
    }

    private void CancelMouseClicked(MouseEvent e) {
        // TODO add your code here
        CancelModify();
    }

    private void initComponents() {
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
        table1 = new JTable();
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
            }
        };

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
        UserNum.setText("123456");
        UserNum.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(UserNum);
        UserNum.setBounds(70, 135, 135, 25);

        //---- UserName ----
        UserName.setText("\u5c0f\u6797");
        UserName.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(UserName);
        UserName.setBounds(70, 175, 135, 25);

        //---- PhoneNumber ----
        PhoneNumber.setText("189xxxxxxxx");
        PhoneNumber.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(PhoneNumber);
        PhoneNumber.setBounds(70, 215, 135, 25);

        //---- Address ----
        Address.setText("\u5e7f\u897f\u5927\u5b66");
        Address.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(Address);
        Address.setBounds(70, 255, 135, 25);

        //---- Credit ----
        Credit.setText("\u4f18");
        Credit.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(Credit);
        Credit.setBounds(85, 295, 135, 25);

        //---- modify ----
        modify.setText("\u4fee\u6539\u8d44\u6599");
        modify.setFont(modify.getFont().deriveFont(modify.getFont().getSize() + 4f));
        modify.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modifyMouseClicked(e);
            }
        });
        contentPane.add(modify);
        modify.setBounds(15, 345, 145, 30);

        //---- comboBox1 ----
        comboBox1.setFont(comboBox1.getFont().deriveFont(comboBox1.getFont().getSize() + 4f));
        contentPane.add(comboBox1);
        comboBox1.setBounds(220, 110, 240, comboBox1.getPreferredSize().height);

        //======== scrollPane1 ========
        {
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

        //---- comboBox2 ----
        comboBox2.setFont(comboBox2.getFont().deriveFont(comboBox2.getFont().getSize() + 4f));
        contentPane.add(comboBox2);
        comboBox2.setBounds(220, 75, 130, comboBox2.getPreferredSize().height);
        contentPane.add(InputText);
        InputText.setBounds(360, 75, 455, comboBox2.getPreferredSize().height);

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

        setSize(1000, 620);
        /*{
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();*/
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

    private void ModifyImformation(){

        UserNumText = new JTextField();
        UserNameText = new JTextField();
        PhoneNumberText = new JTextField();
        AddressText = new JTextField();
        CreditText = new JTextField();
        Confirm = new JButton();
        Cancel = new JButton();


        Container contentPane = getContentPane();
        //---- UserNum ----
        UserNumText.setText(UserNum.getText());
        UserNumText.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(UserNumText);
        UserNumText.setBounds(70, 135, 135, 25);

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

        //---- Credit ----
        CreditText.setText(Credit.getText());
        CreditText.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
        contentPane.add(CreditText);
        CreditText.setBounds(85, 295, 120, 25);

        contentPane.remove(modify);
        contentPane.repaint();

        //---- Confirm ----
        Confirm.setText("确认");
        Confirm.setFont(Confirm.getFont().deriveFont(Confirm.getFont().getSize() + 4f));
        Confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ConfirmMouseClicked(e);
            }
        });
        contentPane.add(Confirm);
        Confirm.setBounds(15, 345, 70, 30);
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
    }

    private void ConfirmModify(){
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
        UserNum.setText(UserNumText.getText());
        UserName.setText(UserNameText.getText());
        PhoneNumber.setText(PhoneNumberText.getText());
        Address.setText(AddressText.getText());
        Credit.setText(CreditText.getText());
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

    public static void main(String[] args) {
        new CostomerFrame().setVisible(true);
    }
}