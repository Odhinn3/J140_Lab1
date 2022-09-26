
package views;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author denis
 */
public class PersonTable {
    private Integer id;
    private String firstname;
    private String lastname;
    private String gender;
    private LocalDate birthday;
    private Integer numberofeducations;

    public PersonTable(Integer id, String firstname, String lastname, String gender, LocalDate birthday, Integer numberofeducations) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.birthday = birthday;
        this.numberofeducations = numberofeducations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getNumberofeducations() {
        return numberofeducations;
    }

    public void setNumberofeducations(Integer numberofeducations) {
        this.numberofeducations = numberofeducations;
    }
    
    
}
