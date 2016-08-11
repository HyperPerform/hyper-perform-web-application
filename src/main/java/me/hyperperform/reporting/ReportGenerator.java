package me.hyperperform.reporting;

import me.hyperperform.event.Git.GitPush;
import me.hyperperform.reporting.request.*;
import me.hyperperform.reporting.response.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.util.List;

/**
 * Created by rohan on 2016/08/10.
 */

public class ReportGenerator
{
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    @PostConstruct
    private void initConnection()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("PostgreJPA");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @PreDestroy
    private void disconnect()
    {
        entityManager.close();
        entityManagerFactory.close();
    }

    public ReportGenerator() {
    }

    public GetSummaryResponse getSummary(GetSummaryRequest getSummaryRequest)
    {
        Query q = entityManager.createQuery("SELECT a FROM GitPush a WHERE (timestamp BETWEEN :startDate AND :endDate) AND (username=:uname)").setParameter("startDate", getSummaryRequest.getStartDate()).setParameter("endDate", getSummaryRequest.getEndDate()).setParameter("uname", getSummaryRequest.getName());
        List<GitPush> result = q.getResultList();

//        System.out.println("-------------------------------------------------");
//        for (int k = 0; k < result.size(); k++)
//            System.out.println(result.get(k) + "\n");
//        System.out.println("-------------------------------------------------");

        return null;
    }
}
