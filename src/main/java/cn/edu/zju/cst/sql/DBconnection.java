package cn.edu.zju.cst.sql;

/**
 * Created by jolivan on 2017/10/28.
 */
import java.sql.*;

public class DBconnection {
    private final String DBDRIVER = "com.mysql.jdbc.Driver";
    private final String DBURL = "jdbc:mysql://47.94.231.41:3306";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private Connection conn=null;
    public DBconnection()
    {
        try
        {
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e)
        {
            // TODO Auto-generated catch block
            System.out.println("加载驱动失败");
        }

    }

    public Connection getConnection()
    {
        return this.conn;
    }

    public void close()
    {
        if(this.conn!=null)
        {
            try
            {
                this.conn.close();
            } catch (SQLException e)
            {
                // TODO Auto-generated catch block
                System.out.println("数据库连接关闭失败");
            }
        }
    }
}
