package me.hyperperform.event;

import java.sql.Timestamp;

public abstract class Event
{
   protected Timestamp time = null;

   public abstract void setDate(Timestamp time);
}