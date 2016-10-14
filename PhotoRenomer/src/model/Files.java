package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author gemorge
 */
public class Files {
    
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    private String initialPath = "";
    public static final String PROP_INITIALPATH = "initialPath";
   
    public int filecount = 0;
    
    
/**
 * Constructor
 * @param initialPath path of directory
 */
    public Files(String initialPath) {
        
        System.out.println("Path du modele : " + initialPath);
           
        if (initialPath != null) {
        File file = new File(initialPath);
        File[] files = file.listFiles(new FilenameFilter() {
        public boolean accept(File file, String name) {
        return name.toLowerCase().endsWith(".jpg");    
        }});
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                    System.out.println("  Fichier: " + files[i].getName());
                    this.filecount++;
                }
            }
        //else
        }
        System.out.println("Nombres de fichiers " + filecount);
    }
        
    
    /**
     * Get the value of initialPath
     *
     * @return the value of initialPath
     */
    public String getInitialPath() {
        return initialPath;
    }

    /**
     * Set the value of initialPath
     *
     * @param initialPath new value of initialPath
     */
    public void setInitialPath(String initialPath) {
        System.out.println("Path du modele : " +initialPath);
        String oldInitialPath = this.initialPath;
        this.initialPath = initialPath;
        propertyChangeSupport.firePropertyChange(PROP_INITIALPATH, oldInitialPath, initialPath);
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
