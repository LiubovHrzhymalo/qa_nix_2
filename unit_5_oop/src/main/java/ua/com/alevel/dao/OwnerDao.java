package ua.com.alevel.dao;

import ua.com.alevel.db.PetDB;
import ua.com.alevel.entity.Owner;

import java.util.List;

public class OwnerDao {
    private PetDB db = new PetDB();

    public void creat(Owner owner) {
        db.creat(owner);
    }

    public void update(Owner owner) {
        db.update(owner);
    }

    public void delete(String id) {
        db.delete(id);
    }

    public Owner findById(String id) {
        return db.findById(id);
    }

    public Owner[] findAll(){
        return db.findAll();
    }


}
