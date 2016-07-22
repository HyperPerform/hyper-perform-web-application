package me.hyperperform.event;

import me.hyperperform.event.Git.GitPush;
import org.junit.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rohan on 2016/07/19.
 */
public class PersistenceTest
{
//    @Ignore

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

        // Travis won't build otherwise
        //entityTransaction.begin();entityManager.persist(g);entityTransaction.commit();
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

//        System.out.println("ID\t Repository\t\t\t Timestamp\t\t Username");

//        for(int i = 0; i < result.size(); i++)
//        {
//            GitPush tmp = result.get(i);
//            System.out.print(tmp.getId());
//            System.out.print("\t" + tmp.getRepository());
//            System.out.print("\t" + tmp.getDate());
//            System.out.print("\t" + tmp.getUsername());
//            System.out.println();
//        }

    }

    @After
    public void closeManager()
    {
        entityManager.close();
        entityManagerFactory.close();
        System.out.println("\t\tSUCCESS");

    }
}
