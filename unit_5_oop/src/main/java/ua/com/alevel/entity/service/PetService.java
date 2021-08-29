package ua.com.alevel.entity.service;

import ua.com.alevel.dao.OwnerDao;
import ua.com.alevel.entity.Owner;

public class PetService {
    private OwnerDao dao = new OwnerDao();
    public void creat(Owner owner) {
        dao.creat(owner);
    }

    public void update(Owner owner) {
        dao.update(owner);
    }

    public void delete(String id) {
        dao.delete(id);
    }

    public Owner findById(String id) {
        return dao.findById(id);
    }

    public Owner[] findAll(){
        return dao.findAll();
    }


}
