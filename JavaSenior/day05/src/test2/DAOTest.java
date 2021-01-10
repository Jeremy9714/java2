package test2;

import org.junit.Test;

import java.util.List;

/**
 * @author Chenyang
 * @create 2021-01-10-21:28
 */
public class DAOTest {
    @Test
    public void test() {
        CustomerDAO cus = new CustomerDAO();
        cus.add(new Customer());
        List<Customer> list = cus.getList(1);
        cus.getValue();

        StudentDAO stu = new StudentDAO();
        Student student = stu.getIndex(1);
        stu.getValue();
    }
}
