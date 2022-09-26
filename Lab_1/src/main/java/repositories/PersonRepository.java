/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import models.Education;
import models.Person;
import java.util.List;

/**
 *
 * @author 
 */
public interface PersonRepository {
    
    List<Person> getPersons();
    Person getPersonById(int id);
}
