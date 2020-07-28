package control.dormitory;

import DAO.DormitoryDao;
import DAO.JDBCUtils;
import beans.Dormitory;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@Controller
public class dormitoryControl {

    private DormitoryDao dormitoryDao;

    public DormitoryDao getDormitoryDAO() {
        if(dormitoryDao==null){
            dormitoryDao=new DormitoryDao();
        }
        return dormitoryDao;
    }

    @RequestMapping("/dormitoryAdd")
    //增加寝室
    public ModelAndView DormitoryAdd(HttpServletRequest request){

        //获取提交过来的信息
        Map<String, String[]> paraMap = request.getParameterMap();
        Dormitory dormitory = new Dormitory();
        ModelAndView modelAndView=null;

        //将获取的信息传到bean对象中
        try {
            BeanUtils.populate(dormitory,paraMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


        System.out.println(dormitory.toString());

        if((getDormitoryDAO().findByNumAndSushe_id(dormitory)==null)){
            getDormitoryDAO().addDormitory(dormitory);
            Dormitory dbdormitory = getDormitoryDAO().findByNumAndSushe_id(dormitory);
            if(dbdormitory!=null){
                modelAndView = new ModelAndView();
                modelAndView.addObject("dormitory", dbdormitory);
                List<Dormitory> dormitoryList = getDormitoryDAO().allDormitory();
                request.getSession().setAttribute("dormitoryList",dormitoryList);
                modelAndView.setViewName("dormitoryInfo");
            }
        }else{
            //否则跳转到查询不到的页面
            modelAndView = new ModelAndView();
            modelAndView.setViewName("alreadyExistDm");
        }
        return modelAndView;
    }

    @RequestMapping("/dormitoryQuery")
    //查询寝室
    public ModelAndView DormitoryQuery(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //获取提交过来的信息
        Map<String, String[]> paraMap = request.getParameterMap();
        Dormitory dormitory = new Dormitory();
        ModelAndView modelAndView=null;

        //将获取的信息传到bean对象中
        try {
            BeanUtils.populate(dormitory,paraMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //在数据库进行查找是否存在该信息
        Dormitory dbdormitory = getDormitoryDAO().findByNum(dormitory.getNum());
        if(dbdormitory!=null){
            //如果数据库中存在，则显示该寝室的具体信息
            modelAndView = new ModelAndView();
            modelAndView.addObject("dormitory", dbdormitory);
            modelAndView.setViewName("dormitoryInfo");
        }else{
            //否则跳转到查询不到的页面
            modelAndView = new ModelAndView();
            modelAndView.setViewName("queryError");
        }
        return modelAndView;
    }


    @RequestMapping("findAllDormitory")
    //查询所有寝室信息
    public ModelAndView findAllDormitory(HttpServletRequest request){

        List<Dormitory> dormitoryList = getDormitoryDAO().allDormitory();

        System.out.println("宿舍id\t\t宿舍编号\t\t从属宿舍id");
        for (Dormitory dormitory:dormitoryList){
            System.out.println(dormitory.getId()+"\t\t"+dormitory.getNum()+"\t\t"+dormitory.getSushe_id());
        }

        ModelAndView modelAndView = new ModelAndView();
        request.getSession().setAttribute("dormitoryList",dormitoryList);
        modelAndView.setViewName("dormitoryInfo");
        return modelAndView;
    }


    @RequestMapping("/dormitoryDelete")
    //删除选定的寝室
    public ModelAndView deleteControl(HttpServletRequest request) {

        String num = request.getParameter("num");
//        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDateSource());
        ModelAndView modelAndView = new ModelAndView();



        getDormitoryDAO().deleteDormitoryByNum(num);
        List<Dormitory> dormitoryList = getDormitoryDAO().allDormitory();
        request.getSession().setAttribute("dormitoryList",dormitoryList);
/*        List<Dormitory> dormitoryList = getDormitoryDAO().allDormitory();
        request.getSession().setAttribute("dormitoryList",dormitoryList);*/

        modelAndView.setViewName("dormitoryInfo");
        return modelAndView;

    }

    @RequestMapping("/dormitoryRefresh")
    public ModelAndView refreshControl(HttpServletRequest request) {

        Dormitory dormitory = new Dormitory();
        ModelAndView modelAndView = new ModelAndView();
        Map<String, String[]> paraMap = request.getParameterMap();

        try {
            BeanUtils.populate(dormitory,paraMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //更新数据库信息
        getDormitoryDAO().refreshDormitory(dormitory);


        //信息修改完，刷新页面数据
        List<Dormitory> dormitoryList = getDormitoryDAO().allDormitory();
        request.getSession().setAttribute("dormitoryList",dormitoryList);
        modelAndView.setViewName("dormitoryInfo");

        return modelAndView;
    }
}
