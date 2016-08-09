package com.ivart.helptodecide.data.solution;

/**
 * Created by Ivan on 8/8/2016.
 */

public class Solution {

    String solutionName;

    int id;

    public Solution(){}

    public Solution(String solutionName) {
        this.solutionName = solutionName;
    }

    public String getSolutionName() {
        return solutionName;
    }

    public void setSolutionName(String solutionName) {
        this.solutionName = solutionName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
