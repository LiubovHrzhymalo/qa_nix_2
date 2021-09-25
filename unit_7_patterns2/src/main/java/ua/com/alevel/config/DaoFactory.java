package ua.com.alevel.config;
import ua.com.alevel.dao.*;
import ua.com.alevel.util.ResourceUtil;

import java.util.Map;

public class DaoFactory {
    private static DaoFactory instance;
    private AllDao ownerDao;
    private AllDao petDao;
    private DaoType daoType;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public AllDao getOwnerDao() {
        if (daoType == null) {
            Map<String, String> map = ResourceUtil.getResource("application.properties");
            daoType = DaoType.init(map.get("dao.type"));
        }
        switch (daoType) {
//            case CSV: {
//                if (authorDao == null) {
//                    authorDao = new CsvAuthorDao();
//                }
//            }
//            break;
            case JSON: {
                if (ownerDao == null) {
                    ownerDao = new JsonOwnerDao();
                }
            }
            break;
        }
        return ownerDao;
    }

    public AllDao getPetDao() {
        if (daoType == null) {
            Map<String, String> map = ResourceUtil.getResource("application.properties");
            daoType = DaoType.init(map.get("dao.type"));
        }
        switch (daoType) {
//            case CSV: {
//                if (bookDao == null) {
//                    bookDao = new CsvBookDao();
//                }
//            }
//            break;
            case JSON: {
                if (petDao == null) {
                    petDao = new JsonPetDao();
                }
            }
            break;
        }
        return petDao;
    }
}
