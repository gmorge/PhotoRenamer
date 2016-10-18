package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author gemorge
 */
public class FileFolder {
    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private String listOfFiles;
    public static final String PROP_LISTOFFILES = "listOfFiles";
    
    /**
     * Constructor
     *
     * @param name path of directory
     */
    public FileFolder(String name) {
        
    }

    /**
     * Get the value of listOfFiles
     *
     * @return the value of listOfFiles
     */
    public String getListOfFiles() {
        return listOfFiles;
    }

    /**
     * Set the value of listOfFiles
     *
     * @param listOfFiles new value of listOfFiles
     */
    public void setListOfFiles(String listOfFiles) {
        String oldName = this.listOfFiles;
        this.listOfFiles = listOfFiles;
        propertyChangeSupport.firePropertyChange(PROP_LISTOFFILES, oldName, listOfFiles);
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
