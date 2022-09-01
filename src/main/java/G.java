import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Sun Aug 21 19:50:46 CST 2022
 */



/**
 * @author unknown
 */
public class G extends JFrame {
    public G(String Number) {
        initComponents(Number);
    }
    private void addProductMouseClicked(String Number) {
        // TODO add your code here
        int rowcount = productTable.getRowCount();
        showProductImformation(Number, rowcount);
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        model.insertRow(rowcount, new Object[]{null, null, null, null, null, null, null});
        addProduct.setVisible(false);
        addConfirm.setVisible(true);
        addCancel.setVisible(true);
    }

    private void alterProductMouseClicked(String Number) {
        // TODO add your code here
        editRow = productTable.getSelectedRow();
        showProductImformation(Number, editRow);
        alterProduct.setVisible(false);
        alterConfirm.setVisible(true);
        alterCancel.setVisible(true);
    }

    private void deleteProductMouseClicked(String Number) {
        // TODO add your code here
        int row = productTable.getSelectedRow();
        String pno = productTable.getValueAt(row, 0).toString().trim();
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        String SQL = "delete from god_info where pno='" + pno + "';\n"
                    +"delete from product_info where pno='" + pno + "'";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        showProductImformation(Number, -1);
    }

    private void researchMouseClicked(String Number) {
        // TODO add your code here
        int selected = typeBox.getSelectedIndex();
        String Text = researchInput.getText();
        String SQL = "select P.pno, P.pna, G.gno, G.gna, P.pwe, God.price, God.surplus from product_info P,g_info G, god_info God " +
                "where P.pno=God.pno and G.gno=God.gno and God.gno='" + Number + "' and ";
        switch (selected){
            case 0:
                SQL += "P.pno='" + Text + "'";
                break;
            case 1:
                SQL += "P.pna='" + Text + "'";
                break;
            case 2:
                SQL += "G.gno='" + Text + "'";
                break;
            case 3:
                SQL += "G.gna='" + Text + "'";
                break;
            case 4:
                SQL += "P.pwe=" + Text;
                break;
            case 5:
                SQL += "God.price=" + Text;
                break;
            case 6:
                SQL += "God.surplus=" + Text;
                break;
        }
//        System.out.println(SQL + "\t" + selected);
        Connection con = DatabaseConnection.getConnection();
        ResultSet result = null;
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            productTable = new JTable(buildProductTableModel(result, -1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void addConfirmMouseClicked(String Number) {
        // TODO add your code here
        // TODO add your code here
        int row = productTable.getRowCount() - 1;
        String  pno = productTable.getValueAt(row, 0).toString().trim();
        String  pna = productTable.getValueAt(row, 1).toString().trim();
        String  gno = productTable.getValueAt(row, 2).toString().trim();
        String  gna = productTable.getValueAt(row, 3).toString().trim();
        String  pwe = productTable.getValueAt(row, 4).toString().trim();
        String  price = productTable.getValueAt(row, 5).toString().trim();
        String  surplus = productTable.getValueAt(row, 6).toString().trim();
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
        showProductImformation(Number, -1);
        addConfirm.setVisible(false);
        addCancel.setVisible(false);
        addProduct.setVisible(true);
    }

    private void addConcelMouseClicked(String Number) {
        // TODO add your code here
        // TODO add your code here
        showProductImformation(Number, -1);
        addConfirm.setVisible(false);
        addCancel.setVisible(false);
        addProduct.setVisible(true);
    }

    private void alterConfirmMouseClicked(String Number) {
        // TODO add your code here
        // TODO add your code here
        String pno = productTable.getValueAt(editRow, 0).toString().trim();
        String pna = productTable.getValueAt(editRow, 1).toString().trim();
        String gno = productTable.getValueAt(editRow, 2).toString().trim();
        String gna =  productTable.getValueAt(editRow, 3).toString().trim();
        String pwe = productTable.getValueAt(editRow, 4).toString().trim();
        String price = productTable.getValueAt(editRow, 5).toString().trim();
        String surplus = productTable.getValueAt(editRow, 6).toString().trim();

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
        showProductImformation(Number, -1);
        alterConfirm.setVisible(false);
        alterCancel.setVisible(false);
        alterProduct.setVisible(true);
    }

    private void alterConcelMouseClicked(String Number) {
        // TODO add your code here
        showProductImformation(Number, -1);
        alterProduct.setVisible(true);
        alterConfirm.setVisible(false);
        alterCancel.setVisible(false);
    }

    private void initComponents(final String Number) {
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
        researchInput = new JTextField();
        research = new JButton();
        productPane = new JScrollPane();
        productTable = new JTable();
        addConfirm = new JButton();
        addCancel = new JButton();
        alterConfirm = new JButton();
        alterCancel = new JButton();

        Connection con = DatabaseConnection.getConnection();
        ResultSet result = null;
        Statement stmt= null;
        String SQL = "select * from customer_info where cno=" + "'" + Number + "'";
        String cno = null, cna = null, cad = null, cte = null;
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            result.next();
            cno = result.getString("cno").trim();
            cna = result.getString("cna").trim();
            cad = result.getString("cad").trim();
            cte = result.getString("cte").trim();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new LoginFrame().setVisible(true);
                dispose();
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u4f9b\u5e94\u5546\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        contentPane.add(label1);
        label1.setBounds(20, 130, 80, 35);

        //---- userNum ----
        userNum.setText(cno);
        userNum.setFont(userNum.getFont().deriveFont(userNum.getFont().getSize() + 2f));
        contentPane.add(userNum);
        userNum.setBounds(95, 130, 80, 35);

        //---- label3 ----
        label3.setText("\u4f9b\u5e94\u5546\u540d\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        contentPane.add(label3);
        label3.setBounds(20, 185, 75, 25);

        //---- userName ----
        userName.setText(cna);
        userName.setFont(userName.getFont().deriveFont(userName.getFont().getSize() + 2f));
        contentPane.add(userName);
        userName.setBounds(90, 185, 75, 25);

        //---- label5 ----
        label5.setText("\u7535\u8bdd\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(20, 235), label5.getPreferredSize()));

        //---- phoneNumber ----
        phoneNumber.setText(cte);
        phoneNumber.setFont(phoneNumber.getFont().deriveFont(phoneNumber.getFont().getSize() + 2f));
        contentPane.add(phoneNumber);
        phoneNumber.setBounds(new Rectangle(new Point(65, 235), phoneNumber.getPreferredSize()));

        //---- label7 ----
        label7.setText("\u5730\u5740\uff1a");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 2f));
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(20, 280), label7.getPreferredSize()));

        //---- address ----
        address.setText(cad);
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
                addProductMouseClicked(Number);
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
                alterProductMouseClicked(Number);
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
                deleteProductMouseClicked(Number);
            }
        });
        contentPane.add(deleteProduct);
        deleteProduct.setBounds(540, 30, 105, 35);
        contentPane.add(typeBox);
        typeBox.setBounds(195, 105, 145, 40);
        typeBox.addItem("产品号");
        typeBox.addItem("产品名");
        typeBox.addItem("供应商号");
        typeBox.addItem("供应商名");
        typeBox.addItem("产品重量");
        typeBox.addItem("单价");
        typeBox.addItem("余量");
        contentPane.add(researchInput);
        researchInput.setBounds(350, 110, 345, 35);

        //---- research ----
        research.setText("\u67e5\u8be2");
        research.setFont(research.getFont().deriveFont(research.getFont().getSize() + 3f));
        research.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                researchMouseClicked(Number);
            }
        });
        contentPane.add(research);
        research.setBounds(new Rectangle(new Point(710, 115), research.getPreferredSize()));

        //======== productPane ========
        {
            showProductImformation(Number, -1);
        }
        contentPane.add(productPane);
        productPane.setBounds(185, 160, 635, 365);

        //---- addConfirm ----
        addConfirm.setText("\u786e\u8ba4");
        addConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addConfirmMouseClicked(Number);
            }
        });
        addConfirm.setVisible(false);
        contentPane.add(addConfirm);
        addConfirm.setBounds(250, 30, 55, 35);

        //---- addConcel ----
        addCancel.setText("\u53d6\u6d88");
        addCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addConcelMouseClicked(Number);
            }
        });
        addCancel.setVisible(false);
        contentPane.add(addCancel);
        addCancel.setBounds(310, 30, 55, 35);

        //---- alterConfrim ----
        alterConfirm.setText("\u786e\u8ba4");
        alterConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                alterConfirmMouseClicked(Number);
            }
        });
        alterConfirm.setVisible(false);
        contentPane.add(alterConfirm);
        alterConfirm.setBounds(390, 30, 55, 35);

        //---- alterConcel ----
        alterCancel.setText("\u53d6\u6d88");
        alterCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                alterConcelMouseClicked(Number);
            }
        });
        alterCancel.setVisible(false);
        contentPane.add(alterCancel);
        alterCancel.setBounds(450, 30, 55, 35);

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
    private JTextField researchInput;
    private JButton research;
    private JScrollPane productPane;
    private JTable productTable;
    private JButton addConfirm;
    private JButton addCancel;
    private JButton alterConfirm;
    private JButton alterCancel;
    private int editRow;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    /**
     * 显示product_info表中的数据导JTable中，其中editrow行可进行编辑，如果参数editrow为-1即不可编辑
     */
    private void showProductImformation(String Number, int editrow){
        Connection con = DatabaseConnection.getConnection();
        ResultSet result = null;
        Statement stmt = null;
        String SQL = "select * from productmanage " +
                "where gno='" + Number + "'";
        try {
            stmt = con.createStatement();
            result = stmt.executeQuery(SQL);
            productTable = new JTable(buildProductTableModel(result, editrow));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        productTable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        productPane.setViewportView(productTable);
    }


    /**
     *根据查询结果ResultSet生成一个product_info表的默认Table模型DefaultTableModel，其中仅er行可进行编辑
     * @param rs    SQL语句查询结果
     * @param er    可进行编辑行
     * @return
     * @throws SQLException
     */
    public static DefaultTableModel buildProductTableModel(ResultSet rs, final int er) throws SQLException {

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
                if(row==er && column!=0 && column!=1 && column!=2 && column!=3){
                    return true;
                }
                else
                    return false;
            }
        };
    }
}
