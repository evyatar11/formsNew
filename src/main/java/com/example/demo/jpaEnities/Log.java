package com.example.demo.jpaEnities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Logs")
public class Log {
    @Id
    @GeneratedValue
    private int id;

    private String username;

    private Date date;

    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Log() {
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", date=" + date +
                ", message='" + message + '\'' +
                '}';
    }
}
