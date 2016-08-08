package com.ivart.helptodecide;

/**
 * Created by Ivan on 8/8/2016.
 */

public class Solution {
    int id;
    String solutionName;

    public Solution(){}

    public Solution(String solutionName) {
        this.solutionName = solutionName;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSolutionName() {
        return solutionName;
    }

    public void setSolutionName(String solutionName) {
        this.solutionName = solutionName;
    }
}
