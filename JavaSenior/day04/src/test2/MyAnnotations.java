package test2;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author Chenyang
 * @create 2021-01-08-13:16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@Inherited
@Documented
public @interface MyAnnotations {
    MyAnnotation[] value();
}
