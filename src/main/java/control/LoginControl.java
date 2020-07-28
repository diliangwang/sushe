package control;

import DAO.DormitoryDao;
import DAO.G_AdminDao;
import beans.Dormitory;
import beans.G_Admin;
import control.dormitory.dormitoryControl;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class LoginControl {

    private G_AdminDao g_adminDao;

    public G_AdminDao getG_AdminDao(){
        if (g_adminDao==null){
            g_adminDao = new G_AdminDao();
        }
        return g_adminDao;
    }

    @RequestMapping("/G_AdminLogin")
    public ModelAndView G_AdminLogin(HttpServletRequest request){

        Map<String,String[]> paraMap=request.getParameterMap();
        G_Admin g_admin = new G_Admin();
        ModelAndView modelAndView = null;
        dormitoryControl dormitoryControl = new dormitoryControl();
        List<Dormitory> dormitoryList =dormitoryControl.getDormitoryDAO().allDormitory();

        try {
            BeanUtils.populate(g_admin,paraMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        G_Admin dbG_admin= getG_AdminDao().findByNumAndPwd(g_admin.getNum(),g_admin.getPwd());
        if (dbG_admin!=null){
            modelAndView = new ModelAndView();
            request.getSession().setAttribute("g_admin",dbG_admin);
            modelAndView.addObject("g_admin", dbG_admin);
            modelAndView.setViewName("g_adminSuccess");
        }else {
            modelAndView = new ModelAndView();
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @RequestMapping("/findByControl_Dm")
    public ModelAndView findByControl_Dm(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {

        ModelAndView modelAndView = new ModelAndView();
        String control_dormitory = request.getParameter("control_dormitory");
        List<Dormitory> dormitoryList = getG_AdminDao().findByControl_Dm(control_dormitory);
        System.out.println("宿舍id\t\t宿舍编号\t\t从属宿舍id");
        for (Dormitory dormitory:dormitoryList){
            System.out.println(dormitory.getId()+"\t\t"+dormitory.getNum()+"\t\t"+dormitory.getSushe_id());
        }
        request.getSession().setAttribute("dormitoryList",dormitoryList);
        modelAndView.setViewName("dormitoryInfo");

        return modelAndView;
    }

/*
    public ModelAndView findByNum(HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView();
        String num = request.getParameter("num");

        G_Admin dbg_admin = getG_AdminDao().findByNum(num);
        if (dbg_admin != null) {
            request.getSession().setAttribute();
        }
    }
*/


}
