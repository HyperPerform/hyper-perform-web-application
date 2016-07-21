package me.hyperperform.event.Git;

import me.hyperperform.event.Event;

import java.sql.Timestamp;

/**
 * Hyper-perform
 * Group: CodusMaximus
 * Date: 2016/07/05
 * Feature: Github
 */

public interface IGitEvent extends Event
{

	public void setDate(Timestamp timestamp);
	public void setRepoName(String name);
	public void setUser(String user);
}