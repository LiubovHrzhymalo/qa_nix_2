package ua.com.alevel.Controller;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.ExtensionType;
import ua.com.alevel.model.TypeFile;
import ua.com.alevel.model.FileModel;
import ua.com.alevel.service.ServiceFile;
import ua.com.alevel.service.ServiceFileImpl;

public class ControllerFile {
    public void run() {
        ServiceFile service = new ServiceFileImpl();
        String input = service.read("input.txt");
        FileModel file = new FileModel();
        file.setNameFile("output");
        file.setExtensionType(ExtensionType.TXT);
        file.setContentFile(service.getOutput(input));
        service.create(file);
    }
}
