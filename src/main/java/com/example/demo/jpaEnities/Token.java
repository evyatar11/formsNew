package com.example.demo.jpaEnities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UserToken")
public class Token {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="token")
    private String token;

    @Column(name="expirationDate")
    private Date expirationDate;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "Users_id")
    private User user;

    public Token() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", expirationDate=" + expirationDate +
                ", user=" + user +
                '}';
    }
}
