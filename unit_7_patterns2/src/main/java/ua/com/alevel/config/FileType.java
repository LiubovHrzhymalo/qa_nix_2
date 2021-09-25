package ua.com.alevel.config;

public enum FileType {
    OWNERS_JSON_TYPE("owners.json"),
//    AUTHORS_CSV_TYPE("authors.csv"),
    PETS_JSON_TYPE("pets.json");
//    BOOKS_CSV_TYPE("books.csv");

    private final String path;

    FileType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
