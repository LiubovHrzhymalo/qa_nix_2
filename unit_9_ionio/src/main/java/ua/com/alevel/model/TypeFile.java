package ua.com.alevel.model;

public enum TypeFile {
    TXT("txt");

    private final String type;

    TypeFile(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
