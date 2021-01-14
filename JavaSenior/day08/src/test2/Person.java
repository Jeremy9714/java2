package test2;

/**
 * @author Chenyang
 * @create 2021-01-14-11:43
 */

@MyAnnotation
public class Person extends Creature<String> implements Comparable<String>, MyInterface {
    private String name;
    int age;
    public int id;

    public Person() {
    }

    @MyAnnotation(value = "hi")
    private Person(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国籍时" + nation);
        return nation;
    }

    public String display(String interests, int age) throws NullPointerException, ClassCastException {
        return interests + age;
    }

    @Override
    public void info() {
        System.out.println("这是一个人");
    }
}
