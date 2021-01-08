package test2;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * 自定义注解
 * @author Chenyang
 * @create 2021-01-08-10:27
 */
//元注解Retention用于指定被修饰的注解的生命周期(RetentionPolicy.(SOURCE/CLASS/RUNTIME))
@Retention(RetentionPolicy.RUNTIME)
//元注解Target用于指定被修饰的注解能用于修饰哪些程序元素
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE, TYPE_PARAMETER, TYPE_USE})
//元注解Documented用于指定被修饰的注解将被javadoc工具提取成文档(必须设置Retention值为RUNTIME)
@Documented
//元注解Inherited修饰的注解将具有继承性，如果某个类使用了被Inherited修饰的注解，则其子类将自动具有该注解
@Inherited
//可重复注解
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
    //给注解的成员变量指定初始值
    String value() default "hello";
}
