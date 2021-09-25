package ua.com.alevel.dao;

import ua.com.alevel.entity.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class PetDao {
    protected List<Pet> pets = new ArrayList<>();

    OwnerDao ownerDao = new CsvOwnerDao();

    protected void createPet(Pet pet) {
        pet.setId(generateId());
        pets.add(pet);
    }

    protected void updatePet(Pet pet) {
        if (existById(pet.getId())) {
            Pet current = findPetById(pet.getId());
            current.setId(pet.getId());
            current.setNamePet(pet.getNamePet());
            current.setBreedOfAnimal(pet.getBreedOfAnimal());
            current.setOwnerIds(pet.getOwnerIds());
        }
    }

    protected void linkOwner(String ownerId, String petId) {
        Pet current = pets.stream().filter(pet -> pet.getId().equals(petId)).findFirst().get();
        List<String> ownerIds = current.getOwnerIds();
        ownerIds.add(ownerId);
    }

    protected void unlinkOwner(String ownerId, String petId) {
        Pet current = pets.stream().filter(pet -> pet.getId().equals(petId)).findFirst().get();
        List<String> ownerIds = current.getOwnerIds();
        ownerIds.removeIf(id -> id.equals(ownerId));
    }

    protected void deletePet(String id) {
        pets.removeIf(pet -> pet.getId().equals(id));
    }

    protected Pet findPetById(String id) {
        return pets.stream().filter(pet -> pet.getId().equals(id)).findFirst().get();
    }

    protected List<Pet> findAllPets() {
        return pets;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (existById(id)) {
            return generateId();
        }
        return id;
    }

    private boolean existById(String id) {
        return pets.stream().anyMatch(pet -> pet.getId().equals(id));
    }

}
