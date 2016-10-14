package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author gemorge
 */
public class PhotoRenamer extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Window.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("PhotoRenamer");
        stage.setScene(scene);
        stage.show();
        
        stage.setMinHeight(440);
        stage.setMinWidth(420);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
