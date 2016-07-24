package me.hyperperform.event;

import me.hyperperform.event.Git.GitPush;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by rohan on 2016/07/19.
 */
public class PersistenceTest
{
    @Ignore
    @Test
    public void jpaTest()
    {
        System.out.println("-------------------------------------------------");
        System.out.println("Starting JPA test");
        System.out.println("-------------------------------------------------");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

		GitPush g = new GitPush("baxterthehacker/public-repo", "2015-05-05 19:40:15.0", "baxterthehacker");

		entityTransaction.begin();

		entityManager.persist(g);

		entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
        System.out.println("-------------------   END  -------------------");
    }
}
