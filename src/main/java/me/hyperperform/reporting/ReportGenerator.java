package me.hyperperform.reporting;

import me.hyperperform.event.Travis.TravisEvent;
import me.hyperperform.reporting.request.*;
import me.hyperperform.reporting.response.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.util.ArrayList;
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
        GetSummaryResponse getSummaryResponse = new GetSummaryResponse();

//        Query q = entityManager.createQuery("SELECT a FROM GitPush a WHERE (timestamp BETWEEN :startDate AND :endDate) AND (username=:uname)").setParameter("startDate", getSummaryRequest.getStartDate()).setParameter("endDate", getSummaryRequest.getEndDate()).setParameter("uname", getSummaryRequest.getName());

        /*---------------------------Github-----------------------------*/
        Query q = entityManager.createQuery("SELECT sum(a.commitSize) FROM GitPush a WHERE (timestamp BETWEEN :startDate AND :endDate) AND (username=:uname)").setParameter("startDate", getSummaryRequest.getStartDate()).setParameter("endDate", getSummaryRequest.getEndDate()).setParameter("uname", getSummaryRequest.getName());
        getSummaryResponse.setGithub((Long)q.getSingleResult());
        /*--------------------------------------------------------------*/


        /*----------------------------Trvis-----------------------------*/
        q = entityManager.createQuery("SELECT COUNT(a.status) FROM TravisEvent a WHERE (timestamp BETWEEN :startDate AND :endDate) AND (commiter=:uname) AND (status LIKE 'Passed')").setParameter("startDate", getSummaryRequest.getStartDate()).setParameter("endDate", getSummaryRequest.getEndDate()).setParameter("uname", getSummaryRequest.getName());
        long passed = (Long)q.getSingleResult();

        q = entityManager.createQuery("SELECT COUNT(a.status) FROM TravisEvent a WHERE (timestamp BETWEEN :startDate AND :endDate) AND (commiter=:uname) AND (status LIKE 'Failed')").setParameter("startDate", getSummaryRequest.getStartDate()).setParameter("endDate", getSummaryRequest.getEndDate()).setParameter("uname", getSummaryRequest.getName());
        long failed = (Long)q.getSingleResult();

        double successRate = ((double)passed/(double)(passed+failed)) * 100.0;
        int roundTmp = (int)(successRate*100.0);
        successRate = roundTmp/100.0;

        getSummaryResponse.setTravis(successRate);
        /*--------------------------------------------------------------*/


        return getSummaryResponse;
    }

    public GetTravisResponse getTravisDetails(GetTravisRequest getTravisRequest)
    {
        GetTravisResponse getTravisResponse = new GetTravisResponse();
        Query q = entityManager.createQuery("SELECT a FROM TravisEvent a WHERE (timestamp BETWEEN :startDate AND :endDate) AND (commiter=:uname)").setParameter("startDate", getTravisRequest.getStartDate()).setParameter("endDate", getTravisRequest.getEndDate()).setParameter("uname", getTravisRequest.getName());

        List<TravisEvent> result = q.getResultList();

        ArrayList<String> repos = new ArrayList<String>();
        ArrayList<ArrayList<TravisEvent>> data = new ArrayList<ArrayList<TravisEvent>>();

        for (int k = 0; k < result.size(); k++)
        {
            TravisEvent curr = result.get(k);

            if (repos.indexOf(curr.getRepo()) == -1)
            {
                repos.add(curr.getRepo());
                data.add(new ArrayList<TravisEvent>());
            }

            data.get(repos.indexOf(curr.getRepo())).add(curr);
        }

        getTravisResponse.setSize(data.size());
        getTravisResponse.setData(data);

        return getTravisResponse;
    }
}
