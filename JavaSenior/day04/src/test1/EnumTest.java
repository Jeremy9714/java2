package test1;

/**
 * @author Chenyang
 * @create 2021-02-05-10:55
 */
public class EnumTest {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.setStatus(Status.BUSY);
        switch (e.getStatus()){
            case FREE:
                System.out.println("已添加至团队");
                break;
            case BUSY:
                throw new RuntimeException("该员工正忙");
            case VOCATION:
                throw new RuntimeException("该员工已离职");
        }
    }
}
class Employee{
    private Status status;

    public Employee(){this.status = Status.FREE;}

    public void setStatus(Status status){
        this.status = status;
    }
    public Status getStatus(){
        return status;
    }
}

enum Status{
    FREE,BUSY,VOCATION;
}
