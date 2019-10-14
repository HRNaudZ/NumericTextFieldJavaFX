import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author LightFox
 */
public class NumericTextFieldDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TextField tfld = new TextField();
        
        tfld
              .textProperty()
              .addListener((ObservableValue<? extends String> observable, String oldValue, String newValue)->{
                  //if(!newValue.matches("\\d*"))
                      tfld.setText(newValue.replaceAll("[^\\d]", ""));
              });
        
        StackPane root = new StackPane();
        root.getChildren().add(tfld);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Numeric TextField");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
