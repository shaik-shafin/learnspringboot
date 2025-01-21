package com.shaik.acknowledge.jpa.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_age")
    private Integer userAge;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Integer getUserId() { return userId; }

    public void setUserId(Integer userId) { this.userId = userId; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public Integer getUserAge() { return userAge; }

    public void setUserAge(Integer userAge) { this.userAge = userAge;}

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
