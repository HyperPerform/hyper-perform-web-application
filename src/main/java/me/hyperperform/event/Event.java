package me.hyperperform.event;

import java.sql.Timestamp;

public abstract class Event
{
   public Timestamp time = null;

   public abstract void setDate(String time);
}