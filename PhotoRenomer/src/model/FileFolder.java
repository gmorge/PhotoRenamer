package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author gemorge
 */
public class FileFolder {
    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private String name;
    public static final String PROP_NAME = "name";
    
    public FileFolder(String name) {
        
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        propertyChangeSupport.firePropertyChange(PROP_NAME, oldName, name);
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
