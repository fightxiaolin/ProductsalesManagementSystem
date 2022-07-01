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

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

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
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }
}
