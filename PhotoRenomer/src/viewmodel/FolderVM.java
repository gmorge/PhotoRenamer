package viewmodel;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
    
    private Folder files;
       
    /**
    * Property of initialPath
    */
    private final StringProperty initialPath = new SimpleStringProperty();
        public String getInitialPath() {return files.getInitialPath();}
        public void setInitialPath(String value) {files.setInitialPath(value);}
        public StringProperty initialPathProperty() {return initialPath;}
        
    /**
    * Property of fileCountS
    */
    private final StringProperty fileCountS = new SimpleStringProperty();
        public String getFileCountS() {return files.getFileCountS();}
        public void setFileCountS(String value) {files.setFileCountS(value);}
        public StringProperty fileCountSProperty() {return fileCountS;}
        
    /**
    * Property of fileList
    */
    private final ObservableList<FileFolderVM> fileListObs = FXCollections.observableArrayList();
        private final ListProperty<FileFolderVM> fileList = new SimpleListProperty<>(fileListObs);
        public ObservableList getFileList() {return fileList.get();}
        public void setFileList(ObservableList value) {fileList.set(value);}
        public ListProperty fileListProperty() {return fileList;}   
      
    /**
     * Constructor
     *
     */     
    public FolderVM() {
               
        files = new Folder(null);
        
        initialPath.set(files.getInitialPath());
        fileCountS.set(files.getFileCountS());
        
        files.addPropertyChangeListener(this);
        
        initialPath.addListener((o,old,newV) -> {
            files.setInitialPath(newV);
            files.listingFiles();});
        
        fileCountS.addListener((o,old,newV) -> files.setFileCountS(newV));  
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Folder.PROP_INITIALPATH)) {
            initialPath.set(evt.getNewValue().toString());
        }
        if (evt.getPropertyName().equals(Folder.PROP_FILESLIST)) {
            fileListObs.add(((IndexedPropertyChangeEvent)evt).getIndex(), new FileFolderVM((FileFolder)evt.getNewValue()));  
        }
        if (evt.getPropertyName().equals(Folder.PROP_FILECOUNTS)) {
            fileCountS.set(evt.getNewValue().toString());
        }
    }
    
}
