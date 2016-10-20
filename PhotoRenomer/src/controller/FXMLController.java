package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import java.io.File;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import launcher.PhotoRenamer;
import viewmodel.FileFolderVM;
import viewmodel.FolderVM;
import viewmodel.ModderVM;

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
    private Label lFileCount;
       
    @FXML
    private ListView<FileFolderVM> lvFiles;
    
    private FolderVM folderVM;
    private ModderVM modderVM;
    
    public void initialize() {
        folderVM = new FolderVM();
        modderVM = new ModderVM();
        binding();
        setCellFactory();
        listenListChange();
    }
    
    
    public void Browse(ActionEvent e) {
        String path = null;
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("PhotoRenamer");
        File result = chooser.showDialog(PhotoRenamer.getStage());
        path = result.getAbsolutePath();
        folderVM.setInitialPath(path);
    
    }
    
    private void binding() {
        tfPath.textProperty().bind(folderVM.initialPathProperty());
        lvFiles.itemsProperty().bind(folderVM.fileListProperty());
        lFileCount.textProperty().bind(folderVM.fileCountSProperty());
    }

    private void setCellFactory() {
        lvFiles.setCellFactory(param -> new ListCell<FileFolderVM>() {
            @Override
            protected void updateItem(FileFolderVM item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty) {
                    textProperty().bind(item.nameOfFileProperty());
                } else {
                    textProperty().unbind();
                    setText("");
                }
            }
        });
    }
     
    private void listenListChange() {
        
    }
    
}
