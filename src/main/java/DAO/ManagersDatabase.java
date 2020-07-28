package DAO;


import beans.Manager;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class ManagersDatabase {
    //获取链接
    public Connection getConnection() throws  SQLException, ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
        String user="root";
        String pwd="12345678";
        String driver="com.mysql.cj.jdbc.Driver";
        Class.forName(driver);
        Connection conn=DriverManager.getConnection(url,user,pwd);
        return conn;
    }
    //关闭所有链接
    public void closeAll(Connection conn, Statement state, ResultSet resultSet ){
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
    //展示所有信息
    public List<Manager> searchAll() {

        List<Manager> list = new ArrayList<>();

        Connection conn = null;
        Statement state = null;
        ResultSet resultSet = null;
        try {
            //加载驱动
            conn = getConnection();
            state = conn.createStatement();
            resultSet = state.executeQuery("select * from managers");
            while (resultSet.next()) {
                Manager manager = new Manager();
                manager.setAccount(resultSet.getString(1));
                manager.setName(resultSet.getString(2));
                manager.setSex(resultSet.getString(3));
                manager.setPassword(resultSet.getString(4));
                manager.setMpid(resultSet.getString(5));
                manager.setMpnum(resultSet.getString(6));
                list.add(manager);
            }
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn,state,resultSet);
        }
        return list;
    }
    //查询
    public Manager searchSingle(String account){
        Connection conn = null;
        Statement state = null;
        ResultSet resultSet = null;
        Manager manager = new Manager();
        try {
            //加载驱动
            conn = getConnection();
            state = conn.createStatement();
            resultSet = state.executeQuery("select * from managers WHERE account="+account);
            while (resultSet.next()) {
                manager.setAccount(resultSet.getString(1));
                manager.setName(resultSet.getString(2));
                manager.setSex(resultSet.getString(3));
                manager.setPassword(resultSet.getString(4));
                manager.setMpid(resultSet.getString(5));
                manager.setMpnum(resultSet.getString(6));
            }
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn,state,resultSet);
        }
        return manager;
    }


    //添加成员
    public boolean add(Manager emp){
        Connection conn = null;
        Statement state = null;
        int resultSet = 0;
        try {
            //加载驱动
            conn = getConnection();
            state = conn.createStatement();
            String sqlInsert = "insert into MANAGERS(account, name,sex,password,mpid,mpnum) values ('"+emp.getAccount()+"','"+emp.getName()+"','"+emp.getSex()+"','"+emp.getPassword()+"','"+emp.getMpid()+"','"+emp.getMpnum()+"')";
            resultSet = state.executeUpdate(sqlInsert);
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn,state,null);
        }
        return resultSet > 0;
    }

    //判断是否修改成功
    public boolean update(Manager manager){
        Connection conn = null;
        Statement state = null;
        String a=manager.getAccount();
        String n=manager.getName();
        String s=manager.getSex();
        String p=manager.getPassword();
        String id=manager.getMpid();
        String num=manager.getMpnum();
        int resultSet = 0;
        try {
            //加载驱动
            conn = getConnection();
            state=conn.createStatement();
            String sqlAlter = "update managers set account='"+a+"',name='"+n+"',sex='"+s+"',password='"+p+"',mpid='"+id+"',mpnum='"+num+"' where account='"+a+"'";
            //tate = conn.prepareStatement(sqlAlter);
            /*state.setString(1,emp.getAccount());
            state.setString(2,emp.getName());
            state.setString(3,emp.getSex());
            state.setString(4,emp.getPassword());
            state.setString(5,emp.getMpid());
            state.setString(6,emp.getMpnum());
            state.setString(7,emp.getAccount());*/
            //assert state != null;
            resultSet = state.executeUpdate(sqlAlter);
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn,state,null);
        }
        return resultSet > 0;
    }
    //删除成员
    public boolean delete(String account) {

        Connection conn = null;
        Statement state=null;
        int resultSet = 0;
        try {
            //加载驱动
            conn = getConnection();
            String sqlAlter = "delete from managers where account='"+account+"'";
            state = conn.createStatement();
            //state.setString(1,account);
            resultSet = state.executeUpdate(sqlAlter);
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn,state,null);
        }
        return resultSet > 0;

    }
}
