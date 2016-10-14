package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import java.io.File;
import launcher.PhotoRenamer;
import viewmodel.FilesVM;

/**
 *
 * @author gemorge
 */
public class FXMLController {
    
    @FXML
    private TextField tfPath;
    
    @FXML
    private TextField tfName;
    
    @FXML
    private TextField tfIndex;
    
    @FXML
    private CheckBox cbIndex;
    
    @FXML
    private CheckBox cbExt;
    
    @FXML
    private ListView lvFiles;
    
    private FilesVM filesVM;
    
    public void initialize() {
        

        filesVM = new FilesVM();
        tfPath.textProperty().bind(filesVM.initialPathProperty());
    }
    
    
    public void Browse(ActionEvent e) {
        String path = null;
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("PhotoRenamer");
        File result = chooser.showDialog(PhotoRenamer.getStage());
        path = result.getAbsolutePath();
             
        System.out.println("Path du Controller : " +path);
        filesVM.setInitialPath(path);
    
    }
       
        
    
}
