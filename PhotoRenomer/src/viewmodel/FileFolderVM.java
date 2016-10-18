package viewmodel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.FileFolder;

/**
 *
 * @author gemorge
 */
public class FileFolderVM implements PropertyChangeListener {

    private final FileFolder model;
    
    /**
    * Property of name
    */
    private final StringProperty listOfFiles = new SimpleStringProperty();
        public String getListOfFiles() {return listOfFiles.get();}
        public void setListOfFiles(String value) {listOfFiles.set(value);}
        public StringProperty listOfFilesProperty() {return listOfFiles;}
        
    /**
     * Constructor
     *
     * @param f path of directory
     */   
    public FileFolderVM(FileFolder f) {
        
        model = f;
        
        listOfFiles.set(model.getListOfFiles());
        
        model.addPropertyChangeListener(this);
        
        listOfFiles.addListener((o,old,newV) -> listOfFiles.setValue(newV));
           
        }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(FileFolder.PROP_LISTOFFILES)) {
            listOfFiles.set(evt.getNewValue().toString());
        }
    }
}
    
    
    
    
   

    

    
    
       

