/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Person;
import repositories.EducationRepositoryImpl;

/**
 *
 * @author user
 */
public class EducationStage {
    private Stage stage;
    private Person person;
    
    public EducationStage(Person person){
        this.person = person;
    }
    
    public void show(){
        stage = new Stage();
        VBox root = new VBox();
        
        List<EducationTable> educationTableList = new EducationRepositoryImpl().getEducationByPersonId(person.getId()).stream().map(education -> {
            return new EducationTable(education.getUniversityname(), education.getDatefinish(), education.getCity());
        }).collect(Collectors.toList());
        
        ObservableList<EducationTable> observableList = FXCollections.observableArrayList(educationTableList);
        TableView<EducationTable> table = new TableView<EducationTable>(observableList);
        
        TableColumn<EducationTable, String> universitynameColumn = new TableColumn<>("Название университета");
        universitynameColumn.setCellValueFactory(new PropertyValueFactory<EducationTable, String>("universityname"));
        table.getColumns().add(universitynameColumn);
        
        TableColumn<EducationTable, LocalDate> datefinishColumn = new TableColumn<>("Дата окончания");
        datefinishColumn.setCellValueFactory(new PropertyValueFactory<EducationTable, LocalDate>("datefinish"));
        table.getColumns().add(datefinishColumn);
        
        TableColumn<EducationTable, String> cityColumn = new TableColumn<>("Город");
        cityColumn.setCellValueFactory(new PropertyValueFactory<EducationTable, String>("city"));
        table.getColumns().add(cityColumn);
        
        
        
        root.getChildren().add(table);
        Scene scene = new Scene(root, 300, 250);
        
        stage.setTitle(person.getLastname() + " " + person.getFirstname());
        stage.setScene(scene);
        stage.show();
    }
}
