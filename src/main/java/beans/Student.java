package beans;

public class Student {

    private String StudentId;
    private String StudentNum;
    private String StudentName;
    private String StudentSex;
    private String  StudentDomiId;
    public static final int PAGE_SIZE = 5;


    public String getStudentId(){

        return StudentId;
    }
    public String getStudentNum(){
        return StudentNum;
    }
    public String getStudentName(){
        return StudentName;
    }
    public  String getStudentSex(){
        return StudentSex;
    }
    public String getStudentDomiId(){
        return StudentDomiId;
    }
    public void setStudentId(String StudentId){
        this.StudentId = StudentId;
    }
    public void setStudentNum(String StudentNum){
        this.StudentNum = StudentNum;
    }
    public void setStudentName(String StudentName){
        this.StudentName = StudentName;
    }
    public void setStudentSex(String StudentSex){
        this.StudentSex = StudentSex;
    }
    public void setStudentDomiId(String StudentDomiId){
        this.StudentDomiId = StudentDomiId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentId=" + StudentId +
                ", StudentNum='" + StudentNum + '\'' +
                ", StudentName='" + StudentName + '\'' +
                ", StudentSex='" + StudentSex + '\'' +
                ", StudentDomiId='" + StudentDomiId + '\'' +
                '}';
    }
}
