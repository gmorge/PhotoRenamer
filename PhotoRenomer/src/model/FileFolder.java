package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author gemorge
 */
public class FileFolder {
    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private String fileName;
    public static final String PROP_FILENAME = "fileName";
    
    /**
     * Constructor
     *
     * @param name path of directory
     */
    public FileFolder(String name) {
        setFileName(name);
    }

    /**
     * Get the value of fileName
     *
     * @return the value of fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Set the value of fileName
     *
     * @param fileName new value of fileName
     */
    public void setFileName(String fileName) {
        String oldFileName = this.fileName;
        this.fileName = fileName;
        propertyChangeSupport.firePropertyChange(PROP_FILENAME, null, fileName);
    }

    
    

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
    
}
