package beans;

public class Manager {

    private String account;
    private String name;
    private String password;
    private String sex;
    //园区，例如松林，香樟
    private String mpid;
    //楼层，例如松一，松二
    private String mpnum;

    public String getMpnum() {
        return mpnum;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", mpid='" + mpid + '\'' +
                ", mpnum='" + mpnum + '\'' +
                '}';
    }

    public void setMpnum(String mpnum) {
        this.mpnum = mpnum;
    }


    public String getMpid() {
        return mpid;
    }

    public void setMpid(String mpid) {
        this.mpid = mpid;
    }

}
