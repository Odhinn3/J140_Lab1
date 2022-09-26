/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories;

import java.util.List;
import models.Education;
import models.Person;

/**
 *
 * @author
 */
public interface EducationRepository {
    List<Education> getEducationByPersonId(int personId);
}
