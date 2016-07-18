package me.hyperperform.event.Git;

import me.hyperperform.event.Event;

import java.sql.Timestamp;

/**
 * Hyper-perform
 * Group: CodusMaximus
 * Date: 2016/07/05
 * Feature: Github
 */

public abstract class GitEvent extends Event
{

	protected String repoName = null;
	protected String user = null;

	public GitEvent() {}
	public abstract void CreatePushEvent(String repoName, String date, String user);
	public abstract void setRepoName(String name);

	public abstract void setUser(String user);

	public void setDate(Timestamp timestamp)
	{
		time = timestamp;
	}

	public Timestamp getDate()
	{
		return time;
	}

}