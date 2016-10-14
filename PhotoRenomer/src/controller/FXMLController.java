package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.swing.JFileChooser;
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
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
           path = chooser.getSelectedFile().toString();
        }
        
    
    System.out.println("Path du Controller : " +path);
    filesVM.setInitialPath(path);
    
    
    }
   
        
    
}
