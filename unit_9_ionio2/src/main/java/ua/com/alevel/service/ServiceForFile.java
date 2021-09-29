package ua.com.alevel.service;


import ua.com.alevel.model.ModelForFile;

public interface ServiceForFile {

    void create(ModelForFile modelForFile);

    void delete(String file);

    String read(String fileName);
}
