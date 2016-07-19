package me.hyperperform.event.Git;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Hyper-perform
 * Group: CodusMaximus
 * Date: 2016/07/02
 * Feature: Github
 */

@Entity(name = "\"GitPush\"")
@Table
public class GitPush implements IGitEvent
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "repository")
    String repoName;

    @Column(name = "username")
    String user;

    @Column(name = "timestamp")
    Timestamp date;
    
    public GitPush(String repoName, String date, String user)
    {
        setRepoName(repoName);
        setDate(Timestamp.valueOf(date));
        setUser(user);
    }

    public GitPush()
    {
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
       date = timestamp;
    }

    public void setUser(String userName)
    {
        user = userName;
    }

    public String toString()
    {
        String s = "";

        s += "Repo Name: " + repoName + "\n";
        s += "Date: " + getDate() + "\n";
        s += "Pusher: " + user;

        return s;
    }

    public Timestamp getDate()
    {
        return date;
    }
}
