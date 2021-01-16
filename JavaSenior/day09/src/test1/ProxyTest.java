package test1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author Chenyang
 * @create 2021-01-16-10:58
 */

//接口
interface Human {
    String getBelief();

    void eat(String food);
}
//被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "超人的信仰";
    }

    @Override
    public void eat(String food) {
        System.out.println("超人吃" + food);
    }
}
//动态代理类
class ProxyFactory {

    //获取代理类对象
    public static Object getInstance(Object obj) {//obj即为被代理类的对象
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(obj);
        //Proxy.newProxyInstance(ClassLoader,Interface[], InvocationGandler)
        //参数一:被代理类对象的类的加载器
        //参数二:被代理类实现的接口
        //参数三:InvocationHandler接口的实现类对象
        Object o = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myInvocationHandler);
        return o;
    }

}

class MyInvocationHandler implements InvocationHandler {
    private Object obj;//需要使用被代理类的对象进行赋值

    //被代理类对象赋值
    public void bind(Object obj) {
        this.obj = obj;
    }

    //当通过代理类对象调用方法时，就会自动的调用如下的invoke()方法
    //将被代理类要执行的方法的功能声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //proxy即为代理类对象
        //method即为代理类对象调用的方法，也是被代理类对象要调用的方法
        //args即为被调用的方法的参数列表

        HumanUtil humanUtil = new HumanUtil();
        //AOP
        humanUtil.method1();

        Object returnValue = method.invoke(obj, args);

        humanUtil.method2();
        //上述方法的返回值就作为当前类中invoke()方法的返回值
        return returnValue;
    }
}
//AOP
class HumanUtil{
    public void method1(){
        System.out.println("代码块1");
    }

    public void method2(){
        System.out.println("代码块2");
    }
}
public class ProxyTest {
    public static void main(String[] args) {
        Human superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getInstance(superMan);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("水果");
    }
}
