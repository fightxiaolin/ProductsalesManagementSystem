import java.awt.*;
import java.awt.event.*;
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

    private void addProductMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void alterProductMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void deleteProductMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void researchMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void addConfrimMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void addConcelMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void alterConfrimMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void alterConcelMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        userNum = new JLabel();
        label3 = new JLabel();
        userName = new JLabel();
        label5 = new JLabel();
        phoneNumber = new JLabel();
        label7 = new JLabel();
        address = new JLabel();
        label9 = new JLabel();
        credit = new JLabel();
        addProduct = new JButton();
        alterProduct = new JButton();
        deleteProduct = new JButton();
        typeBox = new JComboBox();
        radioButton1 = new JRadioButton();
        researchInput = new JTextField();
        research = new JButton();
        productPane = new JScrollPane();
        productTable = new JTable();
        addConfrim = new JButton();
        addConcel = new JButton();
        alterConfrim = new JButton();
        alterConcel = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u4f9b\u5e94\u5546\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        contentPane.add(label1);
        label1.setBounds(20, 130, 80, 35);

        //---- userNum ----
        userNum.setText("04");
        userNum.setFont(userNum.getFont().deriveFont(userNum.getFont().getSize() + 2f));
        contentPane.add(userNum);
        userNum.setBounds(95, 130, 80, 35);

        //---- label3 ----
        label3.setText("\u4f9b\u5e94\u5546\u540d\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        contentPane.add(label3);
        label3.setBounds(20, 185, 75, 25);

        //---- userName ----
        userName.setText("\u5218\u51ef");
        userName.setFont(userName.getFont().deriveFont(userName.getFont().getSize() + 2f));
        contentPane.add(userName);
        userName.setBounds(90, 185, 75, 25);

        //---- label5 ----
        label5.setText("\u7535\u8bdd\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(20, 235), label5.getPreferredSize()));

        //---- phoneNumber ----
        phoneNumber.setText("26262626");
        phoneNumber.setFont(phoneNumber.getFont().deriveFont(phoneNumber.getFont().getSize() + 2f));
        contentPane.add(phoneNumber);
        phoneNumber.setBounds(new Rectangle(new Point(65, 235), phoneNumber.getPreferredSize()));

        //---- label7 ----
        label7.setText("\u5730\u5740\uff1a");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 2f));
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(20, 280), label7.getPreferredSize()));

        //---- address ----
        address.setText("\u5357\u5b81");
        address.setFont(address.getFont().deriveFont(address.getFont().getSize() + 2f));
        contentPane.add(address);
        address.setBounds(new Rectangle(new Point(65, 280), address.getPreferredSize()));

        //---- label9 ----
        label9.setText("\u4fe1\u8d37\u60c5\u51b5\uff1a");
        label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 2f));
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(20, 330), label9.getPreferredSize()));

        //---- credit ----
        credit.setText("\u4f18");
        credit.setFont(credit.getFont().deriveFont(credit.getFont().getSize() + 2f));
        contentPane.add(credit);
        credit.setBounds(90, 330, 25, credit.getPreferredSize().height);

        //---- addProduct ----
        addProduct.setText("\u6dfb\u52a0\u4ea7\u54c1");
        addProduct.setFont(addProduct.getFont().deriveFont(addProduct.getFont().getSize() + 3f));
        addProduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addProductMouseClicked(e);
            }
        });
        contentPane.add(addProduct);
        addProduct.setBounds(255, 30, 105, 35);

        //---- alterProduct ----
        alterProduct.setText("\u4fee\u6539\u4ea7\u54c1");
        alterProduct.setFont(alterProduct.getFont().deriveFont(alterProduct.getFont().getSize() + 3f));
        alterProduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                alterProductMouseClicked(e);
            }
        });
        contentPane.add(alterProduct);
        alterProduct.setBounds(395, 30, 105, 35);

        //---- deleteProduct ----
        deleteProduct.setText("\u4e0b\u67b6\u4ea7\u54c1");
        deleteProduct.setFont(deleteProduct.getFont().deriveFont(deleteProduct.getFont().getSize() + 3f));
        deleteProduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteProductMouseClicked(e);
            }
        });
        contentPane.add(deleteProduct);
        deleteProduct.setBounds(540, 30, 105, 35);
        contentPane.add(typeBox);
        typeBox.setBounds(195, 105, 145, 40);

        //---- radioButton1 ----
        radioButton1.setText("text");
        contentPane.add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(0, 530), radioButton1.getPreferredSize()));
        contentPane.add(researchInput);
        researchInput.setBounds(350, 110, 345, 35);

        //---- research ----
        research.setText("\u67e5\u8be2");
        research.setFont(research.getFont().deriveFont(research.getFont().getSize() + 3f));
        research.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                researchMouseClicked(e);
            }
        });
        contentPane.add(research);
        research.setBounds(new Rectangle(new Point(710, 115), research.getPreferredSize()));

        //======== productPane ========
        {
            productPane.setViewportView(productTable);
        }
        contentPane.add(productPane);
        productPane.setBounds(185, 160, 635, 365);

        //---- addConfrim ----
        addConfrim.setText("\u786e\u8ba4");
        addConfrim.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addConfrimMouseClicked(e);
            }
        });
        contentPane.add(addConfrim);
        addConfrim.setBounds(250, 30, 55, 35);

        //---- addConcel ----
        addConcel.setText("\u53d6\u6d88");
        addConcel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addConcelMouseClicked(e);
            }
        });
        contentPane.add(addConcel);
        addConcel.setBounds(310, 30, 55, 35);

        //---- alterConfrim ----
        alterConfrim.setText("\u786e\u8ba4");
        alterConfrim.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                alterConfrimMouseClicked(e);
            }
        });
        contentPane.add(alterConfrim);
        alterConfrim.setBounds(390, 30, 55, 35);

        //---- alterConcel ----
        alterConcel.setText("\u53d6\u6d88");
        alterConcel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                alterConcelMouseClicked(e);
            }
        });
        contentPane.add(alterConcel);
        alterConcel.setBounds(450, 30, 55, 35);

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
    private JLabel label1;
    private JLabel userNum;
    private JLabel label3;
    private JLabel userName;
    private JLabel label5;
    private JLabel phoneNumber;
    private JLabel label7;
    private JLabel address;
    private JLabel label9;
    private JLabel credit;
    private JButton addProduct;
    private JButton alterProduct;
    private JButton deleteProduct;
    private JComboBox typeBox;
    private JRadioButton radioButton1;
    private JTextField researchInput;
    private JButton research;
    private JScrollPane productPane;
    private JTable productTable;
    private JButton addConfrim;
    private JButton addConcel;
    private JButton alterConfrim;
    private JButton alterConcel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
