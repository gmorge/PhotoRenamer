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
    private final StringProperty nameOfFile = new SimpleStringProperty();
    
    
    public String getNameOfFile() {
        return nameOfFile.get();
    }

    public void setNameOfFile(String value) {
        nameOfFile.set(value);
    }

    public StringProperty nameOfFileProperty() {
        return nameOfFile;
    }
      
    /**
     * Constructor
     *
     * @param f path of directory
     */   
    public FileFolderVM(FileFolder f) {
        
        model = f;
        nameOfFile.set(model.getFileName());
        
        model.addPropertyChangeListener(this);
        
        nameOfFile.addListener((o,old,newV) -> model.setFileName(newV));
           
        }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(FileFolder.PROP_FILENAME)) {
            nameOfFile.set(evt.getNewValue().toString());
        }
    }
}
    
    
    
    
   

    

    
    
       

