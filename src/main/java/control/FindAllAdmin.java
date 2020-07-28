package control;

import DAO.G_AdminDao;
import DAO.susheAndDmDao;
import beans.G_Admin;
import beans.susheAndDm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import beans.susheAndDm;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class FindAllAdmin {

    private susheAndDmDao susheAndDmDao;

    public susheAndDmDao getAdminDao(){
        if(susheAndDmDao==null){
            susheAndDmDao = new susheAndDmDao();
        }
        return susheAndDmDao;
    }

    @RequestMapping("/testFindAll")
    public ModelAndView findAll(HttpServletRequest request){
        List<susheAndDm> adminList=getAdminDao().allAdmin();
        ModelAndView modelAndView = new ModelAndView();
//        System.out.println("账号：\t姓名：\t性别\t管理宿舍\t");
        System.out.println("寝室编号：\t所属宿舍id\t所属宿舍编号");
        for(susheAndDm susheAndDm1:adminList){
//            System.out.println(susheAndDmDao.+"\t\t"+g_admin.getName()+"\t\t"+g_admin.getSex()+"\t\t"+g_admin.getControl_dormitory());
            System.out.println(susheAndDm1.getDnum()+"\t\t"+susheAndDm1.getId()+"\t\t"+susheAndDm1.getSnum());
        }
        request.getSession().setAttribute("adminList",adminList);
        modelAndView.setViewName("AllAdminInfo");
        return modelAndView;
    }

}
