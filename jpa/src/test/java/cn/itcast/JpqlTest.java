package cn.itcast;

import cn.itcast.domain.Customer;
import cn.itcast.utils.JPAUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpqlTest {
    @Test
    public void findAll(){
        EntityManager em = JPAUtil.getEntityManager();
        String sql="from Customer";
        Query query = em.createQuery(sql);
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);
        }
        em.close();
    }

    /*
    * 分页
    * */
    @Test
    public void fy(){
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务对象
        EntityTransaction transaction = em.getTransaction();
        //开启事务
        transaction.begin();
        String sql = "from Customer";
        Query query = em.createQuery(sql);
        query.setFirstResult(0);
        query.setMaxResults(2);
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);
        }
        //提交事务
        transaction.commit();
        //释放资源
        em.close();
    }

    /*
    * 倒叙
    * */
    @Test
    public void dx(){
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务对象
        EntityTransaction transaction = em.getTransaction();
        //开启事务
        transaction.begin();
        String sql = "from Customer order by custId desc";
        Query query = em.createQuery(sql);
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);
        }
        //提交事务
        transaction.commit();
        //释放资源
        em.close();
    }

    @Test
    public void tj(){
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务对象
        EntityTransaction transaction = em.getTransaction();
        //开启事务
        transaction.begin();
        String sql = "from Customer where custName like ?";
        Query query = em.createQuery(sql);
        query.setParameter(1,"传智播客%");
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);
        }

        //提交事务
        transaction.commit();
        //释放资源
        em.close();
    }

    @Test
    public void hs(){
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务对象
        EntityTransaction transaction = em.getTransaction();
        //开启事务
        transaction.begin();
        String sql = "select count(custId) from Customer";
        Query query = em.createQuery(sql);
        Object result = query.getSingleResult();
        System.out.println(result);
        //提交事务
        transaction.commit();
        //释放资源
        em.close();
    }
}
