package test1;

/**
 * 接口的私有方法
 * @author Chenyang
 * @create 2021-01-17-17:38
 */
public interface MyInterface {
    void abstractMethod();

    static void staticMethod(){
        System.out.println("接口的静态方法");
    }

    default void defaultMethod(){
        System.out.println("接口中的默认方法");
        privateMethod();
    }

    //JDK9允许接口中定义私有方法
    private void privateMethod(){
        System.out.println("接口中的私有方法");
    }
}
