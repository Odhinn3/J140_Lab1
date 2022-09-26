/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.time.LocalDate;

/**
 *
 * @author
 */
public class EducationTable {
    private String universityname;
    private LocalDate datefinish;
    private String city;

    public EducationTable(String universityname, LocalDate datefinish, String city) {
        this.universityname = universityname;
        this.datefinish = datefinish;
        this.city = city;

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
}
