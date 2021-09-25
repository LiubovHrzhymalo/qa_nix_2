package ua.com.alevel.dto;
import java.util.ArrayList;
import java.util.List;

public class PetRequestDto {
    private String namePet;
    private String breedOfAnimal;
    private List<String> ownerIds = new ArrayList<>();

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public String getBreedOfAnimal() {
        return breedOfAnimal;
    }

    public void setBreedOfAnimal(String breedOfAnimal) {
        this.breedOfAnimal = breedOfAnimal;
    }

    public List<String> getOwnerIds() {
        return ownerIds;
    }

    public void setOwnerIds(List<String> ownerIds) {
        this.ownerIds = ownerIds;
    }
}
