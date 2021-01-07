package test4;

/**
 * @author Chenyang
 * @create 2021-01-07-17:42
 */
public class Goods implements Comparable {
    private int price;
    private String name;

    public Goods() {
    }

    public Goods(String name, int price) {
        this.price = price;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {
                return -this.name.compareTo(goods.name);
            }
        }
        throw new RuntimeException("类型不匹配");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

}
