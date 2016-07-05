package me.hyperperform.event.Git;

import me.hyperperform.event.Event;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public abstract class GitEvent extends Event
{

	String repoName = null;
	String user = null;

	public GitEvent() {}
	public abstract void CreatePushEvent(String repoName, String date, String user);
	public abstract void setRepoName(String name);

	public abstract void setUser(String user);

	public void setDate(String timestamp)
	{
		DateFormat formatter;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try
		{
			date = (Date) formatter.parse(timestamp);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

		Timestamp timeStampDate = new Timestamp(date.getTime());

		time = timeStampDate;
	}

}