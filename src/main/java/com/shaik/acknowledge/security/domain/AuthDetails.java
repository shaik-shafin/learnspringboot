package com.shaik.acknowledge.security.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;

import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;

@Entity
@Table(name = "auth_details")
@Cache(usage = NONSTRICT_READ_WRITE)
public class AuthDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authId;

    @Column(name = "auth_name")
    private String authName;

    @Column(name = "auth_password")
    private String authPassword;

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthPassword() {
        return authPassword;
    }

    public void setAuthPassword(String authPassword) {
        this.authPassword = authPassword;
    }
}
