package com.example.demo.jpaEnities;

import javax.persistence.*;

@Entity
@Table(name = "LgdParameters")
public class BussinessUnit {

    @Id
    @Column(name="id")
    private int id;
    @Column(name="BaseLGD")
    private int BaseLGD;
    @Column(name="MinLGD")
    private int MinLGD;
    @Column(name="BusinessLine")
    private String BusinessLine;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBaseLGD() {
        return BaseLGD;
    }

    public void setBaseLGD(int baseLGD) {
        BaseLGD = baseLGD;
    }

    public int getMinLGD() {
        return MinLGD;
    }

    public void setMinLGD(int minLGD) {
        MinLGD = minLGD;
    }

    public String getBusinessLine() {
        return BusinessLine;
    }

    public void setBusinessLine(String businessLine) {
        BusinessLine = businessLine;
    }

    public BussinessUnit() {
    }

    @Override
    public String toString() {
        return "BussinessUnit{" +
                "id=" + id +
                ", BaseLGD=" + BaseLGD +
                ", MinLGD=" + MinLGD +
                ", BusinessLine='" + BusinessLine + '\'' +
                '}';
    }
}
