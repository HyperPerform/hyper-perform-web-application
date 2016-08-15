package me.hyperperform.reporting.response;

/**
 * Created by rohan on 2016/08/10.
 */
public class GetSummaryResponse {

    private long Github;
    private double travis;
    private int issuesOpened;
    private int issuesClosed;

    public long getGithub() {
        return Github;
    }

    public void setGithub(long github) {
        Github = github;
    }

    public double getTravis() {
        return travis;
    }

    public void setTravis(double travis) {
        this.travis = travis;
    }

    public int getIssuesOpened() {
        return issuesOpened;
    }

    public void setIssuesOpened(int issuesOpened) {
        this.issuesOpened = issuesOpened;
    }

    public int getIssuesClosed() {
        return issuesClosed;
    }

    public void setIssuesClosed(int issuesClosed) {
        this.issuesClosed = issuesClosed;
    }
}
