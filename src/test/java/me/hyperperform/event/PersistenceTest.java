package me.hyperperform.event;

import me.hyperperform.event.Git.GitPush;
import org.junit.*;

import javax.persistence.*;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by rohan on 2016/07/19.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceTestConfig.class)
public class PersistenceTest
{
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    private  GitPush g;

    @Before
    public void init()
    {
        System.out.println("-------------------------------------------------");
        System.out.println("Starting Persistence Test");
        System.out.println("-------------------------------------------------");

        entityManagerFactory = Persistence.createEntityManagerFactory("test");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
        g = new GitPush("baxterthehacker/public-repo", "2015-05-05 19:40:15.0", "baxterthehacker");

    }

    @Test
    public void jpaTest()
    {
        System.out.print("Starting JPA test ...");

		entityTransaction.begin();

		entityManager.persist(g);

		entityTransaction.commit();
    }

    @Test
    public void queryTest()
    {
        System.out.print("Starting QueryTest ...");
        entityTransaction.begin();

        entityManager.persist(g);

        entityTransaction.commit();

        Query query = entityManager.createQuery("FROM GitPush", GitPush.class);
        List<GitPush> result = query.getResultList();
        Assert.assertNotEquals(result.size(), 0);
        Assert.assertEquals(g.getRepository(), result.get(result.size()-1).getRepository());
        Assert.assertEquals(g.getDate(), result.get(result.size()-1).getDate());
        Assert.assertEquals(g.getUsername(), result.get(result.size()-1).getUsername());
    }

    @After
    public void closeManager()
    {
        entityManager.close();
        entityManagerFactory.close();
        System.out.println("\t\tSUCCESS");

    }
}
