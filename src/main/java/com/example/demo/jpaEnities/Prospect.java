package com.example.demo.jpaEnities;

import javax.persistence.*;


@Entity
@Table(name = "Prospects")
public class Prospect {

    @Id
    @GeneratedValue
    private Long id;

    private String prospectName;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private User user;

    public Prospect() {
    }

    public String getProspectName() {
        return prospectName;
    }

    public void setProspectName(String prospectName) {
        this.prospectName = prospectName;
    }

    // Commented out because of an infinity loop bug when unCommented - //TODO investigate why ini loop happens
//    public User getUser() {
//        return user;
//    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Prospect{" +
                "id=" + id +
                ", prospectName='" + prospectName + '\'' +
                ", user=" + user +
                '}';
    }
}
