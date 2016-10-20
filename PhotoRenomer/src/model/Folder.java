package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author gemorge
 */
public final class Folder {

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private String initialPath = "";
    public static final String PROP_INITIALPATH = "initialPath";

    private List<model.FileFolder> filesList;
    public static final String PROP_FILESLIST = "filesList";

    public int fileCount = 0;
    public String fileCountS = "0";
    public static final String PROP_FILECOUNTS = "fileCountS";

    /**
     * Constructor
     *
     * @param initialPath path of directory
     */
    public Folder(String initialPath) {
        setInitialPath(initialPath);
        filesList = new ArrayList<>();
        setFileCountS(fileCountS);
    }
    
    public void listingFiles () {
        
        if (initialPath != null) {
            File file = new File(initialPath);
            File[] files = file.listFiles((File file1, String name) -> name.toLowerCase().endsWith(".jpg"));
            if (files != null) {
                for (File file1 : files) {
                    FileFolder tmp = new FileFolder(file1.getName());
                    filesList.add(tmp);
                    propertyChangeSupport.fireIndexedPropertyChange(PROP_FILESLIST, filesList.indexOf(tmp), null, tmp);
                    this.fileCount++;
                }
            }
        }
        fileCountS = Integer.toString(fileCount);
        setFileCountS(fileCountS);
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
     * Get the value of fileCountS
     *
     * @return the value of fileCountS
     */
    public String getFileCountS() {
        return fileCountS;
    }

    /**
     * Set the value of filesList
     *
     * @param fileCountS new value of fileCountS
     */
    public void setFileCountS(String fileCountS) {
        String oldFileCountS = this.fileCountS;
        this.fileCountS = fileCountS;
        propertyChangeSupport.firePropertyChange(PROP_FILECOUNTS, oldFileCountS, fileCountS);
    }
    
    /**
     * Add PropertyChangeListener.
     *
     * @param listener add Listner
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener remove listner
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
