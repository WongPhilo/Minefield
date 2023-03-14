package src.MVC;

import java.io.Serializable;
import java.util.Observable;

public class Model extends Observable implements Serializable {
    private String fileName;
    private Boolean unsavedChanges;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public void setUnsavedChanges(Boolean unsavedChanges) {
        this.unsavedChanges = unsavedChanges;
    }

    public void changed() {
        unsavedChanges = true;
        this.setChanged();
        this.notifyObservers();
    }
}