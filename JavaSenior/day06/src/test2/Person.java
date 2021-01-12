package test2;

import java.io.Serializable;

/**
 * @author Chenyang
 * @create 2021-01-12-15:47
 */
public class Person implements Serializable {

    //需要当前类提供一个全局常量
    public static final long serialVersionUID = 4345464575672L;
    private static String name;
    private transient int age;
    private Account acc;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Account acc) {
        this.name = name;
        this.age = age;
        this.acc = acc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", acc=" + acc +
                '}';
    }
}

class Account implements Serializable{
    public static final long serialVersionUID = 43454645756712L;
    private double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}