import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sun Aug 21 19:50:46 CST 2022
 */



/**
 * @author unknown
 */
public class GDesi extends JFrame {
    public GDesi() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        comboBox1 = new JComboBox();
        textField1 = new JTextField();
        button4 = new JButton();
        comboBox2 = new JComboBox();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u4f9b\u5e94\u5546\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        contentPane.add(label1);
        label1.setBounds(20, 130, 80, 35);

        //---- label2 ----
        label2.setText("04");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
        contentPane.add(label2);
        label2.setBounds(95, 130, 80, 35);

        //---- label3 ----
        label3.setText("\u4f9b\u5e94\u5546\u540d\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        contentPane.add(label3);
        label3.setBounds(20, 185, 75, 25);

        //---- label4 ----
        label4.setText("\u5218\u51ef");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));
        contentPane.add(label4);
        label4.setBounds(90, 185, 75, 25);

        //---- label5 ----
        label5.setText("\u7535\u8bdd\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(20, 235), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("26262626");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 2f));
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(65, 235), label6.getPreferredSize()));

        //---- label7 ----
        label7.setText("\u5730\u5740\uff1a");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 2f));
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(20, 280), label7.getPreferredSize()));

        //---- label8 ----
        label8.setText("\u5357\u5b81");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 2f));
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(65, 280), label8.getPreferredSize()));

        //---- label9 ----
        label9.setText("\u4fe1\u8d37\u60c5\u51b5\uff1a");
        label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 2f));
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(20, 330), label9.getPreferredSize()));

        //---- label10 ----
        label10.setText("\u4f18");
        label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 2f));
        contentPane.add(label10);
        label10.setBounds(90, 330, 25, label10.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0\u4ea7\u54c1");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 3f));
        contentPane.add(button1);
        button1.setBounds(255, 30, 105, 35);

        //---- button2 ----
        button2.setText("\u4fee\u6539\u4ea7\u54c1");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 3f));
        contentPane.add(button2);
        button2.setBounds(395, 30, 105, 35);

        //---- button3 ----
        button3.setText("\u4e0b\u67b6\u4ea7\u54c1");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 3f));
        contentPane.add(button3);
        button3.setBounds(540, 30, 105, 35);
        contentPane.add(comboBox1);
        comboBox1.setBounds(195, 105, 145, 40);
        contentPane.add(textField1);
        textField1.setBounds(350, 110, 345, 35);

        //---- button4 ----
        button4.setText("\u67e5\u8be2");
        button4.setFont(button4.getFont().deriveFont(button4.getFont().getSize() + 3f));
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(710, 115), button4.getPreferredSize()));
        contentPane.add(comboBox2);
        comboBox2.setBounds(195, 150, 180, 40);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(185, 200, 635, 325);

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
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton button4;
    private JComboBox comboBox2;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
