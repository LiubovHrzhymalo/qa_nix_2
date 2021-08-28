package ua.com.alevel.db;

import ua.com.alevel.entity.Owner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PetDB {
    private List<Owner> pets = new ArrayList<>();

    public void creat(Owner owner) {
        owner.setId(generateId());
        pets.add(owner);
    }

    public void update(Owner owner) {
        Owner current = pets.stream().filter(o -> o.getId().equals(owner.getId())).findFirst().get();
//        current.setPet(owner.getPet());
        current.setPet(owner.getPet());
        current.setNamePet(owner.getNamePet());
        current.setAge(owner.getAge());
    }

    public void delete(String id) {
        pets.removeIf(owner -> owner.getId().equals(id));
    }

    public Owner findById(String id) {
        return pets.stream().filter(o -> o.getId().equals(id)).findFirst().get();
    }

    public List<Owner> findAll() {
        return pets;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (pets.stream().anyMatch(owner -> owner.getId().equals(id))) {
            return generateId();

        }
        return id;
    }
}

