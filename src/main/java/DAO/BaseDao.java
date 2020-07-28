package DAO;


import java.sql.*;
import java.util.ArrayList;

public class BaseDao {
    static String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
    static String user = "root";
    static String passwd = "12345678";
    static {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, passwd);
    }
    public static void  closeAll(Connection conn, Statement stam, ResultSet rs) throws SQLException {
        if(rs!=null){
            rs.close();
        }
        if(stam!=null){
            stam.close();
        }
        if(conn!=null){
            conn.close();
        }
    }
    public int executeSQL(String preparedSql, ArrayList<String> param) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement presta = null;
        try {
            conn = getConnection();
            presta = conn.prepareStatement(preparedSql);
            if (param != null) {
                for (int i = 0; i < param.size(); i++) {
                    presta.setString(i + 1, param.get(i));
                }
            }
            presta.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                BaseDao.closeAll(conn,presta,null);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return 0;
    }
}
