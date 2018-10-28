package cn.itcast;

import cn.itcast.domain.Customer;
import cn.itcast.utils.JPAUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaTest {
    @Test
    public void save(){
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务对象
        EntityTransaction transaction = em.getTransaction();
        //开启事务
        transaction.begin();
        Customer customer = new Customer();
        customer.setCustName("黑马");
        customer.setCustAddress("郑州");
        //保存
        em.persist(customer);
        //提交事务
        transaction.commit();
        //释放资源
        em.close();
    }

    @Test
    public void findById(){
        EntityManager em = JPAUtil.getEntityManager();
        Customer customer = em.find(Customer.class, 1l);
        System.out.println(customer);
        em.close();
    }

    @Test
    public void delete(){
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务对象
        EntityTransaction transaction = em.getTransaction();
        //开启事务
        transaction.begin();
        Customer customer = em.find(Customer.class, 1l);
        em.remove(customer);
        //提交事务
        transaction.commit();
        //释放资源
        em.close();
    }

    @Test
    public void update(){
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务对象
        EntityTransaction transaction = em.getTransaction();
        //开启事务
        transaction.begin();
        Customer customer= em.find(Customer.class, 2l);
        customer.setCustAddress("北京");
        customer.setCustName("黑马");
        em.merge(customer);
        //提交事务
        transaction.commit();
        //释放资源
        em.close();
    }
}
