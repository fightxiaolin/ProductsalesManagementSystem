import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Jun 27 23:05:44 CST 2022
 */
/**
 * @author unknown
 */
public class ProductManageDesigner extends JFrame {
    public ProductManageDesigner() {
        initComponents();
    }

    private void AddMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void AlterMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void DeleteMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void RefreshMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void ResearchMouseClicked(MouseEvent e) {
        // TODO add your code here
        //这个是类型查询的监听器触发方法


    }

    private void RangeResearchMouseClicked(MouseEvent e) {
        // TODO add your code here，范围监听器的触发方法
    }

    private void AddConfirmMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void AddCancelMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void AlterCancelMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void AlterConfirmMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void ProductNumMouseClicked(MouseEvent e) {
        // TODO add your code here

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

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 48));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- Title ----
        Title.setText("\u4ea7\u54c1\u7ba1\u7406\u7cfb\u7edf");
        Title.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 48));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(Title);
        Title.setBounds(90, 30, 435, 55);

        //======== scrollPane ========
        {
            scrollPane.setViewportView(Producttable);
        }
        contentPane.add(scrollPane);
        scrollPane.setBounds(5, 110, 620, 475);

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
        ProductNum.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ProductNumMouseClicked(e);
            }
        });
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
                ResearchMouseClicked(e);
                ResearchMouseClicked(e);
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
        AddConfirm.setFont(AddConfirm.getFont().deriveFont(AddConfirm.getFont().getSize() + 4f));
        AddConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddConfirmMouseClicked(e);
            }
        });
        contentPane.add(AddConfirm);
        AddConfirm.setBounds(665, 40, 60, 45);

        //---- AddCancel ----
        AddCancel.setText("\u53d6\u6d88");
        AddCancel.setFont(AddCancel.getFont().deriveFont(AddCancel.getFont().getSize() + 4f));
        AddCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddCancelMouseClicked(e);
            }
        });
        contentPane.add(AddCancel);
        AddCancel.setBounds(745, 40, 60, 45);

        //---- AlterCancel ----
        AlterCancel.setText("\u53d6\u6d88");
        AlterCancel.setFont(AlterCancel.getFont().deriveFont(AlterCancel.getFont().getSize() + 4f));
        AlterCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddCancelMouseClicked(e);
                AlterCancelMouseClicked(e);
            }
        });
        contentPane.add(AlterCancel);
        AlterCancel.setBounds(910, 40, 60, 45);

        //---- AlterConfirm ----
        AlterConfirm.setText("\u786e\u8ba4");
        AlterConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddCancelMouseClicked(e);
                AlterConfirmMouseClicked(e);
            }
        });
        contentPane.add(AlterConfirm);
        AlterConfirm.setBounds(830, 40, 60, 45);

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
    private JButton AddConfirm;
    private JButton AddCancel;
    private JButton AlterCancel;
    private JButton AlterConfirm;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
