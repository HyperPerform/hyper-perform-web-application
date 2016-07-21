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
@Table(name = "\"GitPush\"")
public class GitPush implements IGitEvent
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "repository")
    String repository;

    @Column(name = "username")
    String username;

    @Column(name = "timestamp")
    Timestamp timestamp;
    
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
        repository = name;
    }

    public void setDate(Timestamp timestamp)
    {
        this.timestamp = timestamp;
    }

    public void setUser(String userName)
    {
        username = userName;
    }

    public Timestamp getDate()
    {
        return timestamp;
    }

    public String toString()
    {
        String s = "";

        s += "Repo Name: " + repository + "\n";
        s += "Date: " + getDate() + "\n";
        s += "Pusher: " + username;

        return s;
    }


}
