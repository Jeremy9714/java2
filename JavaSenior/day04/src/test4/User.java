package test4;

import java.util.Objects;

/**
 * @author Chenyang
 * @create 2021-01-09-12:32
 */
public class User implements Comparable {
    private int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("调用equals()");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    //自然排序
    //按照姓名从大到小排序，年龄从小到大排序
    public int compareTo(Object o) {
        if (o instanceof User) {
            User user = (User) o;
            int res = -this.name.compareTo(user.name);
            if (res != 0) {
                return res;
            } else {
                return Integer.compare(this.age, user.age);
            }

        } else throw new RuntimeException("类型不匹配");
    }
}
