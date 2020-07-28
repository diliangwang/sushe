package control.sushe;


import beans.dorm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;

@Controller
public class susheControl {
    @RequestMapping(value="/addMethod",method = RequestMethod.POST)
    public String add(dorm d) throws SQLException {
        System.out.println("addMethod被调用了一次......");

        Connection conn = null;
        PreparedStatement pstmt = null;// 预处理
        String url = "jdbc:MySQL://localhost:3306/test?serverTimezone=Asia/Shanghai "; //指向数据库
        String username = "root";  //数据库用户名
        String password = "12345678";  //数据库用户密码
        String sql= "insert into dorm values(?,?,?)";/// 插入数据
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //加载数据库驱动
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
                System.out.println("增加连接成功！");
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,d.getId());
                pstmt.setString(2,d.getName());
                pstmt.setString(3,d.getAddress());
                pstmt.executeUpdate();//执行增加
                System.out.println("增加成功");
            } else {
                System.out.println("增加连接失败！");
            }
        }
        catch(Exception e){
            System.out.println("增加连接异常！");
        }
        finally {
            try {
                if(pstmt!=null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if(conn!=null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return("sushePage");
    }

    @RequestMapping(value="/deleteMethod",method = RequestMethod.POST)
    public String delete(int i)throws SQLException{
        System.out.println("deleteMethod被调用了一次......");

        Connection conn = null;
        PreparedStatement pstmt = null;// 预处理
        String url = "jdbc:MySQL://localhost:3306/test?serverTimezone=Asia/Shanghai "; //指向数据库
        String username = "root";  //数据库用户名
        String password = "12345678";  //数据库用户密码
        String sql= "delete from dorm where id=?";// 删除数据
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //加载数据库驱动
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
                System.out.println("删除连接成功！");
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,i);
                pstmt.executeUpdate();  //执行删除
                System.out.println("删除成功");
            } else {
                System.out.println("删除连接失败！");
            }
        }
        catch(Exception e){
            System.out.println("删除连接异常！");
        }
        finally {
            try {
                if(pstmt!=null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if(conn!=null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "sushePage";
    }

    @RequestMapping(value="/queryMethod",method = RequestMethod.POST)
    public ModelAndView query(int i)throws SQLException{
        System.out.println("queryMethod被调用了一次......");

        ModelAndView mv=new ModelAndView();
        dorm d=new dorm();

        Connection conn = null;
        PreparedStatement pstmt = null;// 预处理
        ResultSet rs = null;
        String url = "jdbc:MySQL://localhost:3306/test?serverTimezone=Asia/Shanghai "; //指向数据库
        String username = "root";  //数据库用户名
        String password = "12345678";  //数据库用户密码
        String sql= "select * from dorm where id=?";// 查询数据
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //加载数据库驱动
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
                System.out.println("查询连接成功！");
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,i);
                rs=pstmt.executeQuery();
                while(rs.next()){
                    d.setId(rs.getInt("id"));
                    d.setName(rs.getString("name"));
                    d.setAddress(rs.getString("address"));
                }
                mv.addObject("result",d);
                mv.setViewName("sushePage");
                System.out.println("查询成功");
            } else {
                System.out.println("查询连接失败！");
            }
        }

        catch(Exception e){
            System.out.println("查询连接异常！");
        }
        finally {
            try {
                if(rs!=null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if(pstmt!=null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if(conn!=null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return mv;
    }

    @RequestMapping(value="/updateMethod",method = RequestMethod.POST)
    public String update(dorm d) throws SQLException {
        System.out.println("updateMethod被调用了一次......");

        Connection conn = null;
        PreparedStatement pstmt = null;// 预处理
        String url = "jdbc:MySQL://localhost:3306/test?serverTimezone=Asia/Shanghai "; //指向数据库
        String username = "root";  //数据库用户名
        String password = "12345678";  //数据库用户密码
        String sql= "update dorm set name=?,address=? where id=?";/// 更新数据
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //加载数据库驱动
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
                System.out.println("更新连接成功！");
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,d.getName());
                pstmt.setString(2,d.getAddress());
                pstmt.setInt(3,d.getId());
                pstmt.executeUpdate();//执行更新
                System.out.println("更新成功");
            } else {
                System.out.println("更新连接失败！");
            }
        }
        catch(Exception e){
            System.out.println("更新连接异常！");
        }
        finally {
            try {
                if(pstmt!=null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if(conn!=null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return("sushePage");
    }
}
