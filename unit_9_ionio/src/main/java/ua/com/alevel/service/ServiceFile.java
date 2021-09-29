package ua.com.alevel.service;

import ua.com.alevel.model.FileModel;

public interface ServiceFile {

    void create(FileModel fileModel);
    String read(String fileName);
    String getOutput(String input);


}
