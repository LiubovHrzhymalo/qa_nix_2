package ua.com.alevel.model;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.ExtensionType;
import com.sun.xml.internal.ws.api.model.ExceptionType;

public class FileModel {
    private String contentFile;
    private String nameFile;
    private ExceptionType type;

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getContentFile() {
        return contentFile;
    }

    public void setContentFile(String contentFile) {
        this.contentFile = contentFile;
    }

    public ExtensionType getExtensionType() {
        return extensionType;
    }

    public void setExtensionType(ExtensionType extensionType) {
        this.extensionType = extensionType;
    }
}
