package com.ivart.helptodecide;

/**
 * Created by Ivan on 8/8/2016.
 */

public class SolutionDescription {
    long id;
    String solutionDescription;
    int square;
    float priority;

    public SolutionDescription(long id, String solutionDescription, int square, float priority) {
        this.id = id;
        this.solutionDescription = solutionDescription;
        this.square = square;
        this.priority = priority;
    }

    public float getPriority() {
        return priority;
    }

    public void setPriority(float priority) {
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSolutionDescription() {
        return solutionDescription;
    }

    public void setSolutionDescription(String solutionDescription) {
        this.solutionDescription = solutionDescription;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }
}
