package DAO;

import java.sql.*;

public class CodeDatabase {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
        String user="root";
        String pwd="12345678";
        String driver="com.mysql.cj.jdbc.Driver";
        Class.forName(driver);
        Connection conn= DriverManager.getConnection(url,user,pwd);
        if(conn!=null) {
            //System.out.print("lianjie");
        }
        return conn;
    }
    public void closeAll(Connection conn, Statement state, ResultSet resultSet ) {
        try {

            if (conn != null) {
                conn.close();
            }
            if (state != null) {
                state.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Boolean QueryCode(String code){
        Connection conn = null;
        Statement state = null;
        ResultSet resultSet = null;
        String code1=null;
        try {
            //加载驱动
            conn = getConnection();
            state = conn.createStatement();
            resultSet = state.executeQuery("select* from codes WHERE code="+code);
            while (resultSet.next()) {
                code1=resultSet.getString("code");
                //System.out.print((code1));
            }
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn,state,resultSet);
        }
        if(code1==null){
            return false;
        }
        else {
            return true;
        }
    }
}
