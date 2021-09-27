package ua.com.alevel.model;

public enum TypeFile {
    TXT("txt");

    private final String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
