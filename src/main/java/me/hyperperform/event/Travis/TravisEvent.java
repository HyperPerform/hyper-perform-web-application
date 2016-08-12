package me.hyperperform.event.Travis;

import me.hyperperform.event.Event;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by rohan on 2016/08/03.
 */
@Entity
@Table(name = "\"TravisEvent\"")
public class TravisEvent implements Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "commiter")
    private String commiter;

    @Column(name = "branch")
    private String branch;

    @Column(name = "repo")
    private String repo;

    @Column(name = "status")
    private String status;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    public TravisEvent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommiter() {
        return commiter;
    }

    public void setCommiter(String commiter) {
        this.commiter = commiter;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp.toString();
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = Timestamp.valueOf(timestamp);
    }

    public String toString()
    {
        String s = "";

        s += "Commiter: " + commiter + "\n";
        s += "Repo: " + repo + "\n";
        s += "Branch: " + branch + "\n";
        s += "Status: " + status + "\n";
        s += "Timestamp: " + timestamp + "\n";

        return s;
    }
}
