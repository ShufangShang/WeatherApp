package com.tts.weatherapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ZipCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String zipCode;

    @Override
    public String toString() {
        return "ZipCode [id=" + id + ", zipCode=" + zipCode + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public ZipCode()
    {

    }

    public ZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }
    
}

