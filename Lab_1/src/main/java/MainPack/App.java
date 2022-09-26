
package MainPack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import views.PersonStage;
import views.PersonStage;

/**
 *
 * @author
 */
public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        Button btn = new Button();
        btn.setText("View persons");
        btn.setOnAction((ActionEvent) -> {
            new PersonStage().show();
        });
        
        textArea.setOnKeyPressed(e->{
            if(e.getCode().equals(KeyCode.ENTER))
                textArea.appendText("Pressed button Enter");
        });
        
        VBox root = new VBox();
        root.getChildren().addAll(textArea, btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
