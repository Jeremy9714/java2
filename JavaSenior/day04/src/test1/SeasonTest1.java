package test1;

/**
 * 使用enum关键字来定义枚举类
 *
 * @author Chenyang
 * @create 2021-01-07-21:57
 */

interface Info {
    void show();
}

public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);
        //toString()
        System.out.println(Season1.class.getSuperclass());

        //values()
        Season1[] values = Season1.values();
        for (Season1 s : values) {
            System.out.println(s);
        }
        System.out.println();

        Thread.State[] values1 = Thread.State.values();
        for (Thread.State s : values1) {
            System.out.println(s);
        }

        //valueOf()
        Season1 autumn = Season1.valueOf("AUTUMN");
        System.out.println(autumn);

        //实现接口
        summer.show();
        autumn.show();
    }

}

enum Season1 implements Info {
    //提供当前枚举类的对象，多个对象之间用都好隔开，末尾对象用";"结束
    //让枚举类中的对象分别去实现接口中的抽象方法
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("夏天在哪里");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天在哪里");
        }
    },
    WINTER("冬天", "冬暖花开") {
        @Override
        public void show() {
            System.out.println("冬天在哪里");
        }
    };

    //声明对象的属性: private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //私有化类的构造器，并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }

//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}

