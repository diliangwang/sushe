package DAO;

import beans.Dormitory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Dormitory")
public class DormitoryDao {

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //数据库名：Dormitory，表名：dormitory；有id和bianhaoz字段
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "12345678";

    //通过寝室编号查询寝室信息
    public Dormitory findByNum(String num){
        Connection conn = null;
        Statement stmt = null;
        Dormitory dormitory=null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql;
            //在寝室表中查询是否存在该寝室编号的寝室
            sql = "SELECT sushe_id,num FROM dormitory where num='"+num+"'";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int dbsushe_Id = rs.getInt("sushe_id");
                String dbnum = rs.getString("num");

                // 输出数据
                dormitory = new Dormitory();
                dormitory.setNum(dbnum);
                dormitory.setSushe_id(dbsushe_Id);

                //显示dormitory信息
                System.out.println(dormitory.toString());
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return dormitory;
    }

    public Dormitory findByNumAndSushe_id(Dormitory dormitory){
        Connection conn = null;
        Statement stmt = null;
        Dormitory dormitory1=null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql;
            //在寝室表中查询是否存在该寝室编号的寝室
            sql = "SELECT sushe_id,num FROM dormitory where num='"+dormitory.getNum()+"'and sushe_id='"+dormitory.getSushe_id()+"'";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int dbsushe_Id = rs.getInt("sushe_id");
                String dbnum = rs.getString("num");

                // 输出数据
                dormitory1 = new Dormitory();
                dormitory1.setNum(dbnum);
                dormitory1.setSushe_id(dbsushe_Id);

                //显示dormitory信息
                System.out.println(dormitory1.toString());
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return dormitory1;
    }

    //增加寝室
    public void addDormitory(Dormitory dormitory) {

        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDateSource());
        String sql= "INSERT INTO dormitory(num,sushe_id) VALUES(?,?)";
        try {
            queryRunner.update(sql,dormitory.getNum(),dormitory.getSushe_id());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




        /*ConnectionPool connectionPool = new ConnectionPool();
        Connection conn = null;
        try {
            conn = connectionPool.getConnection();
            Statement stmt = null;
            stmt = conn.createStatement();
            String sql = "INSERT INTO dormitory(num,sushe_id) VALUES('" + dormitory.getNum()+ "','" + dormitory.getSushe_id() +"')";
            stmt.executeUpdate(sql);
            // 完成后关闭
            stmt.close();
            connectionPool.close(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
    }


    //查找所有寝室信息
    public List<Dormitory> allDormitory(){

        ArrayList<Dormitory> objects =new ArrayList<>();
        String sql = "SELECT * FROM dormitory";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDateSource());
        try {
            objects = (ArrayList<Dormitory>) queryRunner.query(sql, new BeanListHandler<Dormitory>(Dormitory.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objects;
    }


    //删除寝室
    public void deleteDormitoryByNum(String num) {
        Connection conn = null;
        try {
            ConnectionPool connectionPool = new ConnectionPool();
            conn = connectionPool.getConnection();

            QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDateSource());
            String sql = "delete from dormitory where num=?";
            try {
                queryRunner.update(sql, num);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改寝室信息
    public void refreshDormitory(Dormitory dormitory){

        String sql;
        sql="update dormitory set num='"+dormitory.getNum()+"',sushe_id='"+dormitory.getSushe_id()+"'where id='"+dormitory.getId()+"'";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDateSource());

        try {
            queryRunner.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}