package ua.com.alevel.service;

import org.springframework.stereotype.Service;
import ua.com.alevel.config.DaoFactory;
import ua.com.alevel.dao.CrudDao;
import ua.com.alevel.entity.Owner;
import ua.com.alevel.entity.Pet;

import java.util.List;

@Service

public class PetService implements CrudService<Pet> {
    private final CrudDao<Pet> petDao = DaoFactory.getInstance().getPetDao();
    private final CrudDao<Owner> ownerDao = DaoFactory.getInstance().getOwnerDao();

    @Override
    public void create(Pet pet) {
        petDao.create(pet);
        List<String> petIds = pet.getOwnerIds();
        for (String ownerId : ownerIds) {
            ownerDao.link(ownerId, pet.getId());
        }
    }

    @Override
    public void update(Pet pet) {
        petDao.update(pet);
    }

    @Override
    public void delete(String id) {
        Pet current = findById(id);
        List<String> ownerIds = current.getOwnerIds();
        for (String ownerId : ownerIds) {
            ownerDao.unlink(ownerId, id);
        }
        petDao.delete(id);
    }

    @Override
    public Pet findById(String id) {
        return petDao.findById(id);
    }

    @Override
    public List<Pet> findAll() {
        return petDao.findAll();
    }

}
