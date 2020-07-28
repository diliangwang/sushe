package control.student;

import DAO.BaseDao;
import beans.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentOp {
    public ArrayList<String> obj = new ArrayList();
    //增
    @Autowired
    public void AddStudents(Student add) throws  Exception{
        BaseDao bd = new BaseDao();
        obj.add(add.getStudentId());
        obj.add(add.getStudentNum());
        obj.add(add.getStudentName());
        obj.add(add.getStudentSex());
        obj.add(add.getStudentDomiId());
        String sql = "insert into students values(?,?,?,?,?)";
        bd.executeSQL(sql,obj);
    }
    //删
    public void Delete(Student del) throws Exception{
        BaseDao bd = new BaseDao();
        String sql = "delete from students where id = ? and name = ?";
        obj.add(del.getStudentNum());
        obj.add(del.getStudentName());
        bd.executeSQL(sql,obj);
    }
    //改
    public  void  Update(Student update) throws Exception{
        BaseDao bd = new BaseDao();
        String sql = "update students set id =?, domid = ? where num = ? and name = ?";
        obj.add(update.getStudentId());
        obj.add(update.getStudentDomiId());
        obj.add(update.getStudentNum());
        obj.add(update.getStudentName());
        bd.executeSQL(sql,obj);
    }
    //查
    public List<Student> Idselect(Integer StudentId) throws Exception{
        Connection conn = BaseDao.getConnection();
        Statement sta = conn.createStatement();
        String sql = "select * from students where id =" + StudentId;
        ResultSet rs = sta .executeQuery(sql);
        List<Student> student = new ArrayList<Student>();
        Student selectstudents = null;
        while(rs.next()){
            selectstudents = new Student();
            selectstudents.setStudentId(rs.getString("id").replaceAll(".*([';]+|(--)+).*", " "));
            selectstudents.setStudentNum(rs.getString("num").replaceAll(".*([';]+|(--)+).*", " "));
            selectstudents.setStudentName(rs.getString("name").replaceAll(".*([';]+|(--)+).*", " "));
            selectstudents.setStudentSex(rs.getString("sex").replaceAll(".*([';]+|(--)+).*", " "));
            selectstudents.setStudentDomiId(rs.getString("domid").replaceAll(".*([';]+|(--)+).*", " "));
            student.add(selectstudents);
        }
        return student;
    }

    public List<Student> Numselect(String StudentNum) throws Exception{
        Connection conn = BaseDao.getConnection();
        Statement sta = conn.createStatement();
        String sql = "select * from students  where num = "+ StudentNum;
        URLEncoder.encode(URLEncoder.encode(sql,"utf-8"));
        ResultSet rs = sta .executeQuery(sql);
        List<Student> student = new ArrayList<Student>();
        Student selectstudents = null;
        while(rs.next()){
            selectstudents = new Student();
            selectstudents.setStudentId(rs.getString("id"));
            selectstudents.setStudentNum(rs.getString("num"));
            selectstudents.setStudentName(rs.getString("name"));
            selectstudents.setStudentSex(rs.getString("sex"));
            selectstudents.setStudentDomiId(rs.getString("domid"));
            student.add(selectstudents);
        }
        return student;
    }
    public List<Student> Nameselect(String StudentName) throws Exception{

        Connection conn = BaseDao.getConnection();
        Statement sta = conn.createStatement();
        String sql = "select * from students where name = \'"+ StudentName+"\'";
        ResultSet rs = sta .executeQuery(sql);
        List<Student> student = new ArrayList<Student>();
        Student selectstudents = null;
        while(rs.next()){
            selectstudents = new Student();
            selectstudents.setStudentId(rs.getString("id"));
            selectstudents.setStudentNum(rs.getString("num"));
            selectstudents.setStudentName(rs.getString("name"));
            selectstudents.setStudentSex(rs.getString("sex"));
            selectstudents.setStudentDomiId(rs.getString("domid"));
            student.add(selectstudents);
        }
        return student;
    }
    public List<Student> DomiIdselect(String StudentDomiId) throws Exception{

        Connection conn = BaseDao.getConnection();
        Statement sta = conn.createStatement();
        String sql = "select * from students where domid = \'"+ StudentDomiId+"\'";
        ResultSet rs = sta .executeQuery(sql);
        List<Student> student = new ArrayList<Student>();
        Student selectstudents = null;
        while(rs.next()){
            selectstudents = new Student();
            selectstudents.setStudentId(rs.getString("id"));
            selectstudents.setStudentNum(rs.getString("num"));
            selectstudents.setStudentName(rs.getString("name"));
            selectstudents.setStudentSex(rs.getString("sex"));
            selectstudents.setStudentDomiId(rs.getString("domid"));
            student.add(selectstudents);
        }
        return student;
    }

    /*
    public List<Student> selectAll() throws Exception{
        Connection conn = BaseDao.getConnection();
        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery("select * from students order  by id desc limit 0,5");
        List<Student> student = new ArrayList<Student>();
        Student selectstudents  = null;
        while (rs.next()){
            selectstudents = new Student();
            selectstudents.setStudentId(rs.getString("id"));
            selectstudents.setStudentNum(rs.getString("num"));
            selectstudents.setStudentName(rs.getString("name"));
            selectstudents.setStudentSex(rs.getString("sex"));
            selectstudents.setStudentDomiId(rs.getString("domid"));
            student.add(selectstudents);
        }
        return student;
    }

     */
}
