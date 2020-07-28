package beans;

public class Dormitory {

    //寝室编号
    private  int id;
    private String num;
    private int sushe_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getSushe_id() {
        return sushe_id;
    }

    public void setSushe_id(int sushe_id) {
        this.sushe_id = sushe_id;
    }

    @Override
    public String toString() {
        return "寝室的编号:" + num + "\n寝室所属的宿舍id编号：" + sushe_id;
    }
}
