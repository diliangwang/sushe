package beans;

public class G_Admin {
    //设置学号
    private String num;
    private String sex;
    private String name;
    private String pwd;
    //管理的寝室
    private String control_dormitory;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getControl_dormitory() {
        return control_dormitory;
    }

    public void setControl_dormitory(String control_dormitory) {
        this.control_dormitory = control_dormitory;
    }

    @Override
    public String toString() {
        return "姓名:" + name + "<br>账号:" + num + "<br>性别:" + sex + "<br>管理宿舍:" + control_dormitory;
    }
}
