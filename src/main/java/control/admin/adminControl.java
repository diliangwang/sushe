package control.admin;


import DAO.CodeDatabase;
import DAO.ManagersDatabase;
import beans.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/home")
public class adminControl {
    @RequestMapping("/index")
    public String Index() {
        return "register";
    }

    @RequestMapping("/ValidateUser")
    public String DealData(Manager manager, HttpSession session) {
        System.out.print(manager);
        Boolean mark = (Boolean) session.getAttribute("mark");
        System.out.print(mark);
        if (mark) {
            ManagersDatabase md = new ManagersDatabase();
            Manager manager1 = new Manager();
            manager1 = md.searchSingle(manager.getAccount());
            if (manager1.getAccount() == null) {
                Boolean s = md.add(manager);
                if (s) {
                    return "registersuccess";
                } else {
                    return "registerfail";
                }
            } else {
                return "warnuser";
            }
        } else {
            return "register";
        }
    }

    @RequestMapping(value = "/ValidateCode")
    public String ValidateCode(@RequestParam("code") String code) {
        CodeDatabase cd = new CodeDatabase();
        Boolean s;
        s = cd.QueryCode(code);
        //System.out.println("cd创建成功");
        if (s == true) {
            return "codesuccess";
        } else {
            return "codefail";
        }
    }

    //添加用户
    @RequestMapping("/addUser")
    public String addUser(Manager manager) {
        ManagersDatabase md1 = new ManagersDatabase();
        Boolean s = md1.add(manager);
        if (s) {
            return "addsuccess";
        } else {
            return "addfail";
        }
    }

    //查询用户
    @RequestMapping("/queryUser")
    public ModelAndView showUpdate(String account) {
        ManagersDatabase md1 = new ManagersDatabase();
        Manager manager = md1.searchSingle(account);
        ModelAndView mv = new ModelAndView("queryresult");
        mv.addObject("manager", manager);
        return mv;
    }

    //修改用户信息
    @RequestMapping("/changeInfo")
    public String update(Manager manager) {
        System.out.print(manager);
        Manager manager1=new Manager();
        manager1=manager;
        ManagersDatabase md3=new ManagersDatabase();
        Boolean s=md3.update(manager1);
        if(s){
            return "redirect:/home/showAllInfo";
        }
        else{
            return "codefail";
        }

    }
    //删除用户
    @RequestMapping("/deleteUser")
    public String delete(String account){
        ManagersDatabase md4=new ManagersDatabase();
        Boolean s=md4.delete(account);
        if(s){
            return "deletesuccess";
        }
        else{
            return "deletefail";
        }
    }


    @RequestMapping("/showAllInfo")
    public ModelAndView search(){
        ManagersDatabase md2=new ManagersDatabase();
        List<Manager> list = md2.searchAll();
        ModelAndView mv = new ModelAndView("showinfo");
        mv.addObject("list",list);
        return mv;
    }
    @RequestMapping("/main")
    public String mainpage(){
        return "main";
    }
    @RequestMapping("/add")
    public String addpage(){
        return "add";
    }
    @RequestMapping("/change")
    public String changepage(){
        return "change";
    }
    @RequestMapping("/delete")
    public String deletepage(){
        return "delete";
    }
}
