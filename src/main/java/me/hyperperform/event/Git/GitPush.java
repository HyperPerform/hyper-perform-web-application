package me.hyperperform.event.Git;

import me.hyperperform.event.Event;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    public void CreatePushEvent(String repo, String date, String user)
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

    public void setDate(String timestamp)
    {
        super.setDate(timestamp);
    }

    public void setUser(String userName)
    {
        user = userName;
    }

 
}
