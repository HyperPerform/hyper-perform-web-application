package me.hyperperform.event.Travis;

import me.hyperperform.event.Event;

import java.sql.Timestamp;

/**
 * Created by rohan on 2016/08/03.
 */
public class TravisEvent implements Event {

    private int id;
    private String commiter;
    private String branch;
    private String repo;
    private String status;
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
