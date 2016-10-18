package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import java.io.File;
import javafx.scene.control.ListCell;
import launcher.PhotoRenamer;
import viewmodel.FileFolderVM;
import viewmodel.FolderVM;

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
    private ListView<FileFolderVM> lvFiles;
    
    private FolderVM filesVM;
    
    public void initialize() {
        

        filesVM = new FolderVM();
        tfPath.textProperty().bind(filesVM.initialPathProperty());
        lvFiles.itemsProperty().bind(filesVM.fileListProperty());
        setCellFactory();
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

    private void setCellFactory() {
        lvFiles.setCellFactory(param -> new ListCell<FileFolderVM>() {
            @Override
            protected void updateItem(FileFolderVM item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty) {
                    textProperty().bind(item.nameProperty());
                } else {
                    textProperty().unbind();
                    setText("");
                }
            }
        });
    }
        
    
}
