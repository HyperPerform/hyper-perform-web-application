package me.hyperperform.reporting.response;

import me.hyperperform.event.Travis.TravisEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohan on 2016/08/13.
 */
public class GetTravisResponse
{
    private int size;
    private ArrayList<ArrayList<TravisEvent>> data;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<ArrayList<TravisEvent>> getData() {
        return data;
    }

    public void setData(ArrayList<ArrayList<TravisEvent>> data) {
        this.data = data;
    }
}
