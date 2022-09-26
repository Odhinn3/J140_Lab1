package repositories;

import models.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import MainPack.ApplicationProperties;

/**
 *
 * @author denis
 */
public class PersonRepositoryImpl implements PersonRepository{

    @Override
    public List<Person> getPersons() {
        List<Person> list = new ArrayList<>();
        try(Connection connection = getConnection();
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM person")){
            while(rs.next()){
                int id = rs.getInt(1);
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                String gender = rs.getString(4);
                LocalDate birthday = rs.getDate(5).toLocalDate();
                Person person = new Person(id, firstname, lastname, gender, birthday);
                list.add(person);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Person getPersonById(int id) {
        List<Person> list = new ArrayList<>();
        try(Connection connection = getConnection();
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM person WHERE id=" + id)){
            while(rs.next()){
                int personid = rs.getInt(1);
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                String gender = rs.getString(4);
                LocalDate birthday = rs.getDate(5).toLocalDate();
                Person person = new Person(personid, firstname, lastname, gender, birthday);
                list.add(person);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list.isEmpty() ? null : list.get(0);
    }
    
    //Метод создает соединение с БД
    private Connection getConnection() throws SQLException{
        String url = ApplicationProperties.get().getProperty("db.url");
        String dbUser = ApplicationProperties.get().getProperty("db.user");
        String dbPassword = ApplicationProperties.get().getProperty("db.password");
        return DriverManager.getConnection(url, dbUser, dbPassword);
    }
}
