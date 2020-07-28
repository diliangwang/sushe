package control.student;

import beans.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StudentControl {
    @RequestMapping(value = "/add")
    public ModelAndView add(Student student) throws Exception{
        StudentOp add = new StudentOp();
        add.AddStudents(student);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("added");
        return mv;
    }
    @RequestMapping(value = "/update")
    public ModelAndView update(Student student) throws Exception{
        StudentOp update = new StudentOp();
        update.Update(student);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("updated");
        return mv;
    }
    @RequestMapping(value= "/del")
    public ModelAndView delete(Student student) throws  Exception{
        StudentOp del = new StudentOp();
        del.Delete(student);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("deled");
        return mv;
    }
    /*
    @RequestMapping(value = "/allSe")
    public ModelAndView all() throws Exception{
        StudentOp SelectAll = new StudentOp();
        List<Student> students = SelectAll.selectAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("selectall",students);
        mv.setViewName("allSe");
        return mv;
    }
     */
    @RequestMapping(value = "/idSe")
    public ModelAndView idSelect(Integer StudentId) throws Exception{
        StudentOp idselect = new StudentOp();
        List<Student> students = idselect.Idselect(StudentId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("StudentId",students);
        mv.setViewName("idSe");
        return mv;
    }
    @RequestMapping(value = "/numSe")
    public ModelAndView NumSelect(String StudentNum) throws  Exception{
        StudentOp numselect = new StudentOp();
        List<Student> students =  numselect.Numselect(StudentNum);
        ModelAndView mv = new ModelAndView();
        mv.addObject("StudentNum",students);
        mv.setViewName("numSe");
        return  mv;
    }
    @RequestMapping(value = "/nameSe")
    public ModelAndView NameSelect(String StudentName) throws Exception{
        StudentOp nameselect = new StudentOp();
        List<Student > students =  nameselect.Nameselect(StudentName);
        ModelAndView mv = new ModelAndView();
        mv.addObject("StudentName",students);
        mv.setViewName("nameSe");
        return  mv;
    }
    @RequestMapping(value = "/domiSe")
    public ModelAndView DomiIdselect(String StudentDomiId) throws  Exception{
        StudentOp domiIdselect = new StudentOp();
        List<Student> students = domiIdselect.DomiIdselect(StudentDomiId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("StudentDomiId",students);
        mv.setViewName("domiSe");
        return mv;
    }
}
