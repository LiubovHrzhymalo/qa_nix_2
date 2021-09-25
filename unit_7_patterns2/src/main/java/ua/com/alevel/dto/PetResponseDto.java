package ua.com.alevel.dto;

import ua.com.alevel.entity.Pet;
import java.util.ArrayList;
import java.util.List;

public class PetResponseDto {
    private String id;
    private String namePet;
    private String breedOfAnimal;
    private List<String> ownerIds = new ArrayList<>();

    public PetResponseDto(Pet pet) {
        this.id = pet.getId();
        this.namePet = pet.getNamePet();
        this.breedOfAnimal = pet.getBreedOfAnimal();
        this.ownerIds = pet.getOwnerIds();
    }

    public String getId() {
        return id;
    }

    public String getNamePet() {
        return namePet;
    }

    public String getBreedOfAnimal() {
        return breedOfAnimal;
    }

    public List<String> getOwnerIds() {
        return ownerIds;
    }
}
