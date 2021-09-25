package ua.com.alevel.facade;

import org.springframework.stereotype.Service;
import ua.com.alevel.dto.PetRequestDto;
import ua.com.alevel.dto.PetResponseDto;
import ua.com.alevel.entity.Pet;
import ua.com.alevel.service.PetService;

import java.util.ArrayList;
import java.util.List;

@Service

public class PetFacadeImpl implements PetFacade {
    private final PetService petService;

    public PetFacadeImpl(PetService petService) {
        this.petService = petService;
    }

    @Override
    public void create(PetRequestDto dto) {
        createOrUpdate(dto, null);
    }

    @Override
    public void update(PetRequestDto dto, String id) {
        createOrUpdate(dto, id);
    }

    @Override
    public void delete(String id) {
        petService.delete(id);
    }

    @Override
    public PetResponseDto findById(String id) {
        return new PetResponseDto(petService.findById(id));
    }

    @Override
    public List<PetResponseDto> findAll() {
        List<Pet> pets = petService.findAll();
        List<PetResponseDto> dtoList = new ArrayList<>();
        for (Pet pet : pets) {
            dtoList.add(new PetResponseDto(pet));
        }
        return dtoList;
    }

    public void createOrUpdate(PetRequestDto dto, String id) {
        Pet pet = new Pet();
        pet.setNamePet(dto.getNamePet());
        pet.setBreedOfAnimal(dto.getBreedOfAnimal());
        pet.setOwnerIds(dto.getOwnerIds());
        if (id == null) {
            petService.create(pet);
        } else {
            pet.setId(id);
            petService.update(pet);
        }
    }


}
