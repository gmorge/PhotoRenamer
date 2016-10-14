package viewmodel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Files;

/**
 *
 * @author gemorge
 */
public class FilesVM implements PropertyChangeListener {
    
    private final StringProperty initialPath = new SimpleStringProperty();
    
    private Files files;
    
    /**
    * Property of initialPath
    */
    public String getInitialPath() {return files.getInitialPath();}
    public void setInitialPath(String value) {files.setInitialPath(value);}
    public StringProperty initialPathProperty() {return initialPath;}

    public FilesVM() {
               
        System.out.println("Path de la VM : " +initialPath);
        files = new Files(null);
        
        initialPath.set(files.getInitialPath());
        files.addPropertyChangeListener(this);
        
        initialPath.addListener((o,old,newV) -> files.setInitialPath(newV));
        
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Files.PROP_INITIALPATH)) {
            initialPath.set(evt.getNewValue().toString());
        }
    }
    

    
}
