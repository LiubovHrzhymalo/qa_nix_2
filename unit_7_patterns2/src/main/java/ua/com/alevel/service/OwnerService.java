package ua.com.alevel.service;
import org.springframework.stereotype.Service;
import ua.com.alevel.config.DaoFactory;
import ua.com.alevel.dao.AllDao;
import ua.com.alevel.dao.CrudDao;
import ua.com.alevel.entity.Owner;

import java.util.List;

@Service
public class OwnerService implements CrudService<Owner> {
    private final AllDao<Owner> ownerDao = DaoFactory.getInstance().getOwnerDao();

    @Override
    public void create(Owner owner) {
        ownerDao.create(owner);
    }

    @Override
    public void update(Owner owner) {
        ownerDao.update(owner);
    }

    @Override
    public void delete(String id) {
        ownerDao.delete(id);
    }

    @Override
    public Owner findById(String id) {
        return ownerDao.findById(id);
    }

    @Override
    public List<Owner> findAll() {
        return ownerDao.findAll();
    }
}
