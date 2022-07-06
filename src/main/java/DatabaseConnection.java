import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class DatabaseConnection {
    static Connection con = null;
    static Statement stmt = null;

    static String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=product;user=sa;password=gxu";
    public static Connection getConnection(){
        try {
            //因为没导包，我也不知道你为什么没有这个包，你导一下，我直接发给你
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
}
