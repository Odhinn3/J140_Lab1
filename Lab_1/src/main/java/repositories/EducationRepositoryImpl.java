/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import MainPack.ApplicationProperties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.Education;
import models.Person;

/**
 *
 * @author 
 */
public class EducationRepositoryImpl implements EducationRepository {
    
    private PersonRepository personRepository;

    public EducationRepositoryImpl() {
        personRepository = new PersonRepositoryImpl();
    }

    @Override
    public List<Education> getEducationByPersonId(int personId) {
        Person person = personRepository.getPersonById(personId);
        List<Education> list = new ArrayList<>();
        if(person!=null){
            try(Connection connection = getConnection();
                    Statement stm = connection.createStatement();
                    ResultSet rs = stm.executeQuery("SELECT * FROM education WHERE personid=" + personId)){
                while(rs.next()){
                    int id = rs.getInt(1);
                    String universityname = rs.getString(2);
                    LocalDate datefinish = rs.getDate(3).toLocalDate();
                    String city = rs.getString(4);
                    Education education = new Education(id, universityname, datefinish, city, person);
                    list.add(education);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return list;
    }
    
    private Connection getConnection() throws SQLException{
        String url = ApplicationProperties.get().getProperty("db.url");
        String dbUser = ApplicationProperties.get().getProperty("db.user");
        String dbPassword = ApplicationProperties.get().getProperty("db.password");
        return DriverManager.getConnection(url, dbUser, dbPassword);
    }
    
}
