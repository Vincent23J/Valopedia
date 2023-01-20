package com.si51.valopedia.models;

import java.util.ArrayList;
import java.util.List;

public class ValorantData {
    private int count;
    private String next, previous;
    private List<ValorantModel> results;


    public ValorantData(){this.results = new ArrayList<>();}
    public int getCount(){return count;}
    public String getNext(){return next;}
    public String getPrevious(){return previous;}
    public List<ValorantModel> getResults() {return results;}

}
