package com.kamil.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name = "client")
public class Client{
    private int id;
    private String name;
    private String surname;
    private String middlename;
    private Date birthDate;
    private float passportId;

    public Client (){
    }

    public Client (String name, String surname, String middlename, Date birthDate, float passportId) {
        super();
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.birthDate = birthDate;
        this.passportId = passportId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, insertable = true, updatable = true, length = 40)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "middlename", nullable = false, insertable = true, updatable = true, length = 40)
    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false, insertable = true, updatable = true)
    public java.util.Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "passport_id", nullable = false, insertable = true, updatable = true)
    public float getPassportId() {
        return passportId;
    }

    public void setPassportId(float passportId) {
        this.passportId = passportId;
    }


    @Override
    public String toString() {
        return  "{id:'"+ id + "'" +
                ", name:'" + name + "'" +
                ", surname:'" + surname + "'" +
                ", middlename:'" + middlename + "'" +
                ", birthDate:'" + new SimpleDateFormat("dd.MM.yyyy").format(birthDate) + "'" +
                ", passportId:'" + String.format("%.6f", passportId) + "'" +
                '}';
    }
}
