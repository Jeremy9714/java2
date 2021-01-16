package test1;

import org.junit.Test;

/**
 * 静态代理举例
 * @author Chenyang
 * @create 2021-01-15-16:05
 */
interface ClothFactory{
    void createCloth();
    int setPrice(int price);
}

class ProxyClothFactory implements ClothFactory{
    private NikeClothFactory nike;

    public ProxyClothFactory(NikeClothFactory nike) {
        this.nike = nike;
    }

    @Override
    public void createCloth() {
        System.out.println("Proxy");
        nike.createCloth();
        System.out.println("finished");
    }

    @Override
    public int setPrice(int price) {
        System.out.println("Proxy");
        nike.setPrice(12);
        System.out.println("finished");
        return price;
    }
}

class NikeClothFactory implements ClothFactory{

    @Override
    public void createCloth() {
        System.out.println("Nike");
    }

    @Override
    public int setPrice(int price) {
        System.out.println("nike price");
        return price;
    }
}
public class StaticProxyTest {
    //静态代理
    @Test
    public void test(){
        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory proxy = new ProxyClothFactory(nike);
        proxy.createCloth();
    }

    public static void main(String[] args) {
        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory proxyInstance = (ClothFactory) ProxyFactory.getInstance(nike);
        proxyInstance.createCloth();
        int price = proxyInstance.setPrice(100);
        System.out.println(price);
    }
}
