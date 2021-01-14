package test2;

import java.io.Serializable;

/**
 * @author Chenyang
 * @create 2021-01-14-19:02
 */
public class Creature<T> implements Serializable {
    private static final long serialVersionUID = 1235345L;

    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物进食");
    }


}
