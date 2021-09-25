package ua.com.alevel.dao;
import ua.com.alevel.entity.Owner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public abstract class OwnerDao {
    protected List<Owner> owners = new ArrayList<>();

    protected void createOwner(Owner owner) {
        owner.setId(generateId());
        owner.setVisible(true);
        owners.add(owner);
    }

    protected void updateOwner(Owner owner) {
        if (existById(owner.getId())) {
            Owner current = findOwnerById(owner.getId());
            current.setId(owner.getId());
            current.setFirstName(owner.getFirstName());
            current.setLastName(owner.getLastName());

        }
    }

    protected boolean existPet(String ownerId, String petId) {
        Owner current = owners.stream().filter(owner -> owner.getId().equals(ownerId)).findFirst().get();
        return current.getPetIds().stream().anyMatch(id -> id.equals(petId));
    }

    protected void linkPet(String ownerId, String petId) {
        Owner current = owners.stream().filter(owner -> owner.getId().equals(ownerId)).findFirst().get();
        List<String> petIds = current.getPetIds();
        petIds.add(petId);
    }

    protected void unlinkPet(String ownerId, String petId) {
        Owner current = owners.stream().filter(owner -> owner.getId().equals(ownerId)).findFirst().get();
        List<String> petIds = current.getPetIds();
        petIds.removeIf(id -> id.equals(petId));
    }

    protected void deleteOwner(String id) {
        if (existById(id)) {
            Owner current = findOwnerById(id);
            current.setVisible(false);
        }
    }

    protected Owner findOwnerById(String id) {
        return findAllOwners().stream().filter(owner -> owner.getId().equals(id)).findFirst().get();
    }

    protected List<Owner> findAllOwners() {
        return owners.stream().filter(Owner::getIsVisible).collect(Collectors.toList());
    }

    private static List<Owner> visibleOwners(List<Owner> owners) {
        List<Owner> collect = owners.stream().filter(Owner::getIsVisible).collect(Collectors.toList());
        return collect;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (existById(id)) {
            return generateId();
        }
        return id;
    }

    private boolean existById(String id) {

        return owners.stream().anyMatch(owner -> owner.getId().equals(id));
    }
}
