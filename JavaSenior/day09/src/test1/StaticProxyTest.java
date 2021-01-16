package test1;

import org.junit.Test;

/**
 * 静态代理举例
 * @author Chenyang
 * @create 2021-01-15-16:05
 */
interface ClothFactory{
    void createCloth();
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
}

class NikeClothFactory implements ClothFactory{

    @Override
    public void createCloth() {
        System.out.println("Nike");
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
}
