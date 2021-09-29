package ua.com.alevel.model;

public class ModelForFile {
    private String fileContent;
    private TypeForFile fileType;
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public TypeForFile getFileType() {
        return fileType;
    }

    public void setFileType(TypeForFile fileType) {
        this.fileType = fileType;
    }
}
