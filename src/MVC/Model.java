package src.MVC;

import mvc.Bean;
public class Model extends Bean {
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
        firePropertyChange(fileName, false, true);
    }
}