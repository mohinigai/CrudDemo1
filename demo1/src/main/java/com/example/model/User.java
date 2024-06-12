package com.example.model;

import jakarta.persistence.*;
@Entity
@Table(name = "user_details")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
       @Column(name = "user_id")
        private Long userId;
        @Column(name = "user_name")
        private String Name;
       @Column(name="user_age")
        private String userAge;
        @Column(name ="about")
        private String about;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}