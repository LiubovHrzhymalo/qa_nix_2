package ua.com.alevel.model;

public enum TypeForFile {
    INPUT("input"), OUTPUT("output");

    private final String fileType;

    TypeForFile(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileType;
    }
}
