/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author denis
 */
public class Education {
    private Integer id;
    private String universityname;
    private LocalDate datefinish;
    private String city;
    private Person person;

    public Education(Integer id, String universityname, LocalDate datefinish, String city, Person person) {
        this.id = id;
        this.universityname = universityname;
        this.datefinish = datefinish;
        this.city = city;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniversityname() {
        return universityname;
    }

    public void setUniversityname(String universityname) {
        this.universityname = universityname;
    }

    public LocalDate getDatefinish() {
        return datefinish;
    }

    public void setDatefinish(LocalDate datefinish) {
        this.datefinish = datefinish;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Education{" + "id=" + id + ", universityname=" + universityname + ", datefinish=" + datefinish + ", city=" + city + ", person=" + person + '}';
    }
}
