package DAO;

import beans.Dormitory;
import beans.G_Admin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class G_AdminDao {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "12345678";

    //查询
    public G_Admin findByNumAndPwd(String num, String pwd) {
        Connection conn = null;
        Statement stmt = null;
        G_Admin g_admin = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql;
            //通过账号和密码查询管理员信息
            sql = "SELECT num,pwd,name,sex,control_dormitory FROM g_admin where num='" + num + "'and pwd='" + pwd + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                String dbname = rs.getString("name");
                String dbnum = rs.getString("num");
                String dbsex = rs.getString("sex");
                String dbControl_domitory = rs.getString("control_dormitory");

                // 输出数据
                g_admin = new G_Admin();
                g_admin.setName(dbname);
                g_admin.setNum(dbnum);
                g_admin.setControl_dormitory(dbControl_domitory);
                g_admin.setSex(dbsex);

                //显示g_admin信息
                System.out.println(g_admin.toString());
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return g_admin;
    }


    public G_Admin findByNum(String num) {

        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDateSource());
        G_Admin admin = new G_Admin();
        String sql = "select* from g_admin where num='" + num + "'";
        try {
            admin = (G_Admin) queryRunner.query(sql, new BeanListHandler<G_Admin>(G_Admin.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    public List<Dormitory> findByControl_Dm(String control_dormitory) {

        ArrayList<Dormitory> adminArrayList = new ArrayList<>();

        System.out.println("dao中："+control_dormitory);
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDateSource());
        String sql = "SELECT dormitory.id as id,dormitory.num as num,dormitory.sushe_id as sushe_id " +
                "FROM g_admin,dormitory,sushe " +
                "WHERE g_admin.control_dormitory='"+control_dormitory+"'and  g_admin.control_dormitory=sushe.num and sushe.id=dormitory.sushe_id";
        try {
            adminArrayList = (ArrayList<Dormitory>) queryRunner.query(sql, new BeanListHandler<Dormitory>(Dormitory.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminArrayList;
    }
}
/*    public List<G_Admin> allAdmin(){

        ArrayList<G_Admin> objects = new ArrayList<>();
//        String sql="select* from g_admin ";
        String sql="SELECT dormitory.num,dormitory.sushe_id,sushe.num as dormitory_num FROM `dormitory`,sushe where dormitory.sushe_id=sushe.id ";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDateSource());
        try {
            objects = (ArrayList<G_Admin>) queryRunner.query(sql, new BeanListHandler<G_Admin>(G_Admin.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objects;
    }*/