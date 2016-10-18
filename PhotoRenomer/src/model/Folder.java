package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author gemorge
 */
public class Folder {

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private String initialPath = "";
    public static final String PROP_INITIALPATH = "initialPath";

    private List<model.FileFolder> filesList;
    public static final String PROP_FILESLIST = "filesList";

    public int filecount = 0;

    /**
     * Constructor
     *
     * @param initialPath path of directory
     */
    public Folder(String initialPath) {
        setInitialPath(initialPath);
        filesList = new ArrayList<>();
    }
    
    public void listingFiles () {

        System.out.println("Path du modele : " + initialPath);

        if (initialPath != null) {
            File file = new File(initialPath);
            File[] files = file.listFiles(new FilenameFilter() {
                public boolean accept(File file, String name) {
                    return name.toLowerCase().endsWith(".jpg");
                }
            });
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    System.out.println("  Fichier: " + files[i].getName());
                    FileFolder tmp = new FileFolder(files[i].getName());
                    filesList.add(tmp);
                    propertyChangeSupport.fireIndexedPropertyChange(PROP_FILESLIST, filesList.indexOf(tmp), null, tmp);
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
        System.out.println("Path du modele : " + initialPath);
        String oldInitialPath = this.initialPath;
        this.initialPath = initialPath;
        propertyChangeSupport.firePropertyChange(PROP_INITIALPATH, oldInitialPath, initialPath);
    }
    
     /**
     * Get the value of filesList
     *
     * @return the value of filesList
     */
    public List<FileFolder> getFilesList() {
        return Collections.unmodifiableList(filesList);
    }

    /**
     * Set the value of filesList
     *
     * @param filesList new value of filesList
     */
    public void setFilesList(List<FileFolder> filesList) {
        List<FileFolder> oldFilesList = this.filesList;
        this.filesList = filesList;
        propertyChangeSupport.firePropertyChange(PROP_FILESLIST, oldFilesList, filesList);
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
