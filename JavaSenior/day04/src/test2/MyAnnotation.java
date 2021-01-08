package test2;

/**
 * 自定义注解
 * @author Chenyang
 * @create 2021-01-08-10:27
 */
public @interface MyAnnotation {
    //给注解的成员变量指定初始值
    String value() default "hello";
}
