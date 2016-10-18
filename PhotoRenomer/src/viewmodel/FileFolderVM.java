package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.FileFolder;

/**
 *
 * @author gemorge
 */
public class FileFolderVM {

    private FileFolder model;
    private final StringProperty name = new SimpleStringProperty();

    public FileFolderVM(FileFolder f) {
        model = f;
    }
    
    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public StringProperty nameProperty() {
        return name;
    }
    
       
}
