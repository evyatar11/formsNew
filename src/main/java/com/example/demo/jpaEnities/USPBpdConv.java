package com.example.demo.jpaEnities;


import javax.persistence.*;

@Entity
@Table(name = "USPBpdConv")
public class USPBpdConv {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    private double minScore;


    private double maxScore;


    private double updatedRating;

    private double pdScore;

    public USPBpdConv() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMinscore() {
        return minScore;
    }

    public void setMinscore(double minscore) {
        this.minScore = minscore;
    }

    public double getMaxscore() {
        return maxScore;
    }

    public void setMaxscore(double maxscore) {
        this.maxScore = maxscore;
    }

    public double getUpdatedRating() {
        return updatedRating;
    }

    public void setUpdatedRating(double updatedRating) {
        this.updatedRating = updatedRating;
    }

    public double getPdScore() {
        return pdScore;
    }

    public void setPdScore(double pdScore) {
        this.pdScore = pdScore;
    }

    @Override
    public String toString() {
        return "USPBpdConv{" +
                "id=" + id +
                ", minscore=" + minScore +
                ", maxscore=" + maxScore +
                ", updatedRating=" + updatedRating +
                ", pdScore=" + pdScore +
                '}';
    }
}
