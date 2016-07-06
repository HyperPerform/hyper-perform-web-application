package me.hyperperform.event.Git;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Hyper-perform
 * Group: CodusMaximus
 * Date: 2016/07/02
 * Feature: Github
 */

@Entity
@Table
public class GitPush extends GitEvent
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public GitPush()
    {
    }

    public void CreatePushEvent(String repo, Timestamp date, String user)
    {
        setRepoName(repo);
        setDate(date);
        setUser(user);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setRepoName(String name)
    {
        repoName = name;
    }

    public void setDate(Timestamp timestamp)
    {
        super.setDate(timestamp);
    }

    public void setUser(String userName)
    {
        user = userName;
    }

 
}
