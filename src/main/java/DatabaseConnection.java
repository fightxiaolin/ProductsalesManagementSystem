import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class DatabaseConnection {
    static Connection con = null;
    static Statement stmt = null;

    static String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=ProductsalesDatabase;user=xiaolin;password=123456";
    public static Connection getConnection(){
        try {
            //建立数据库连接
//            System.out.println("尝试建立数据库连接~~~");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
//            System.out.println("建立数据库成功~~~");
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

    public static DefaultTableModel buildProductTableModel(ResultSet rs, int er) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();
        Vector columnNames = new Vector();

        int columnCount = metaData.getColumnCount();
        columnNames.add("产品号");
        columnNames.add("产品名");
        columnNames.add("产品描述");
        columnNames.add("产品重量");

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

    public static DefaultTableModel buildProductTableModel(ResultSet rs, int er, int ec) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();
        Vector columnNames = new Vector();

        int columnCount = metaData.getColumnCount();
        columnNames.add("产品号");
        columnNames.add("产品名");
        columnNames.add("产品描述");
        columnNames.add("产品重量");

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
                if(row == er && column != ec){
                    return true;
                }
                else
                    return false;
            }
        };
    }
}
