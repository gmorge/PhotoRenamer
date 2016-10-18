package viewmodel;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collections;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.FileFolder;
import model.Folder;

/**
 *
 * @author gemorge
 */
public class FolderVM implements PropertyChangeListener {
    
    private final StringProperty initialPath = new SimpleStringProperty();
    private Folder files;
    
    public FolderVM() {
               
        System.out.println("Path de la VM : " +initialPath);
        files = new Folder(null);
        
        initialPath.set(files.getInitialPath());
        
        files.addPropertyChangeListener(this);
        
        initialPath.addListener((o,old,newV) -> {
            files.setInitialPath(newV);
            files.listingFiles();
                });
        
    }
    
    /**
    * Property of initialPath
    */
    public String getInitialPath() {return files.getInitialPath();}
    public void setInitialPath(String value) {files.setInitialPath(value);}
    public StringProperty initialPathProperty() {return initialPath;}
    
    private ObservableList<FileFolderVM> fileListObs = FXCollections.observableArrayList();
    private final ListProperty<FileFolderVM> fileList = new SimpleListProperty<FileFolderVM>(fileListObs);

    public ObservableList getFileList() {
        return fileList.get();
    }

    public void setFileList(ObservableList value) {
        fileList.set(value);
    }

    public ListProperty fileListProperty() {
        return fileList;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Folder.PROP_INITIALPATH)) {
            initialPath.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals(Folder.PROP_FILESLIST)) {
            fileListObs.add(((IndexedPropertyChangeEvent)evt).getIndex(), new FileFolderVM((FileFolder)evt.getNewValue()));  
        }
    }

    
}
