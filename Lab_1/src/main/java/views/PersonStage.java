
package views;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import models.Person;
import repositories.*;

/**
 *
 * @author
 */
public class PersonStage{
    
    private Stage stage;
    private PersonRepository personRepository;
    private EducationRepository educationRepository;
    
    public PersonStage(){
        personRepository = new PersonRepositoryImpl();
        educationRepository = new EducationRepositoryImpl();
    }
    
    public void show(){
        stage = new Stage();
        VBox root = new VBox();
        
        List<PersonTable> personTableList = new PersonRepositoryImpl().getPersons().stream().map(person -> {
            int numberOfEducation = educationRepository.getEducationByPersonId(person.getId()).size();
            return new PersonTable(person.getId(), 
                    person.getFirstname(), 
                    person.getLastname(), 
                    person.getGender(), 
                    person.getBirthday(), 
                    numberOfEducation);
        }).collect(Collectors.toList());
        
        ObservableList<PersonTable> observableList = FXCollections.observableArrayList(personTableList);
        TableView<PersonTable> table = new TableView<PersonTable>(observableList);
        
        TableColumn<PersonTable, Integer> idColumn = new TableColumn<>("Идентификатор");
        idColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("id"));
        table.getColumns().add(idColumn);
        
        TableColumn<PersonTable, String> firstNameColumn = new TableColumn<>("Имя");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("firstname"));
        table.getColumns().add(firstNameColumn);
        
        TableColumn<PersonTable, String> lastnameColumn = new TableColumn<>("Фамилия");
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("lastname"));
        table.getColumns().add(lastnameColumn);
        
        TableColumn<PersonTable, String> genderColumn = new TableColumn<>("Пол");
        genderColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("gender"));
        table.getColumns().add(genderColumn);
        
        TableColumn<PersonTable, LocalDate> birthdayColumn = new TableColumn<>("Дата рождения");
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, LocalDate>("birthday"));
        table.getColumns().add(birthdayColumn);
        
        TableColumn<PersonTable, Integer> numberofeducationsColumn = new TableColumn<>("кол-во дипломов");
        numberofeducationsColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("numberofeducations"));
        table.getColumns().add(numberofeducationsColumn);
        
        table.setOnMouseClicked(e->{
            if(e.getClickCount()==2){
                PersonTable personTable = table.getSelectionModel().getSelectedItem();
                Person person = personRepository.getPersonById(personTable.getId());
                EducationStage educationStage = new EducationStage(person);
                educationStage.show();
            }
        });
        
        root.getChildren().add(table);
        Scene scene = new Scene(root, 300, 250);
        
        stage.setTitle("Persons");
        stage.setScene(scene);
        stage.show();
    }
}
