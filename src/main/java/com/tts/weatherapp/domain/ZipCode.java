package com.tts.weatherapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import org.hibernate.annotations.Table;
import javax.persistence.*;


@Entity
@Table(name = "ZIP_CODE")
public class ZipCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="ZIPCODE")
    private String zipCode;

    @Override
    public String toString() {
        return "ZipCode [id=" + id + ", zipCode=" + zipCode + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

