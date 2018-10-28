package cn.itcast.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory exf;
    static {
       exf = Persistence.createEntityManagerFactory("myJpa");
    }
    public static EntityManager getEntityManager(){
        return exf.createEntityManager();
    }
}
