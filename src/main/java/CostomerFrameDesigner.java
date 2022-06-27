import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Jun 27 14:19:59 CST 2022
 */

//只是给设计界面用的而已，真正的界面代码在CostomerFrame


/**
 * @author unknown
 */
public class CostomerFrameDesigner extends JFrame {
    public CostomerFrameDesigner() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        panel = new JPanel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
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
        textField1 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setTitle("\u7528\u6237\u8ba2\u5355\u7ba1\u7406\u7cfb\u7edf");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel ========
        {
            panel.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
            border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax. swing .border . TitledBorder. CENTER
            ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069al\u006fg", java .awt . Font
            . BOLD ,12 ) ,java . awt. Color .red ) ,panel. getBorder () ) ); panel. addPropertyChangeListener(
            new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062or\u0064er"
            .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
            panel.setLayout(null);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel.getComponentCount(); i++) {
                    Rectangle bounds = panel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel.setMinimumSize(preferredSize);
                panel.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel);
        panel.setBounds(new Rectangle(new Point(0, 0), panel.getPreferredSize()));
        contentPane.add(label11);
        label11.setBounds(60, 30, 70, 80);

        //---- label12 ----
        label12.setText("\u7528\u6237\u53f7\uff1a");
        contentPane.add(label12);
        label12.setBounds(15, 135, 55, 25);

        //---- label13 ----
        label13.setText("\u7528\u6237\u540d\uff1a");
        contentPane.add(label13);
        label13.setBounds(15, 175, 55, 25);

        //---- label14 ----
        label14.setText("\u7535\u8bdd\uff1a");
        contentPane.add(label14);
        label14.setBounds(15, 215, 55, 25);

        //---- label15 ----
        label15.setText("\u5730\u5740\uff1a");
        contentPane.add(label15);
        label15.setBounds(15, 255, 55, 25);

        //---- label16 ----
        label16.setText("\u4fe1\u8d37\u60c5\u51b5\uff1a");
        contentPane.add(label16);
        label16.setBounds(15, 295, 70, 25);

        //---- UserNum ----
        UserNum.setText("123456");
        contentPane.add(UserNum);
        UserNum.setBounds(70, 135, 135, 25);

        //---- UserName ----
        UserName.setText("\u5c0f\u6797");
        contentPane.add(UserName);
        UserName.setBounds(70, 175, 135, 25);

        //---- PhoneNumber ----
        PhoneNumber.setText("189xxxxxxxx");
        contentPane.add(PhoneNumber);
        PhoneNumber.setBounds(70, 215, 135, 25);

        //---- Address ----
        Address.setText("\u5e7f\u897f\u5927\u5b66");
        contentPane.add(Address);
        Address.setBounds(70, 255, 135, 25);

        //---- Credit ----
        Credit.setText("\u4f18");
        contentPane.add(Credit);
        Credit.setBounds(85, 295, 135, 25);

        //---- modify ----
        modify.setText("\u4fee\u6539\u8d44\u6599");
        contentPane.add(modify);
        modify.setBounds(15, 345, 145, 30);
        contentPane.add(comboBox1);
        comboBox1.setBounds(220, 115, 240, comboBox1.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(220, 145, 530, 425);

        //---- Add ----
        Add.setText("\u6dfb\u52a0\u8ba2\u5355");
        contentPane.add(Add);
        Add.setBounds(230, 20, 135, 35);

        //---- Delete ----
        Delete.setText("\u5220\u9664\u8ba2\u5355");
        contentPane.add(Delete);
        Delete.setBounds(400, 20, 135, 35);

        //---- Alter ----
        Alter.setText("\u4fee\u6539\u8ba2\u5355");
        contentPane.add(Alter);
        Alter.setBounds(570, 20, 135, 35);
        contentPane.add(comboBox2);
        comboBox2.setBounds(new Rectangle(new Point(220, 75), comboBox2.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(310, 75, 345, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("text");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(665, 75), button1.getPreferredSize()));

        {
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
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel panel;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
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
    private JComboBox comboBox2;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
