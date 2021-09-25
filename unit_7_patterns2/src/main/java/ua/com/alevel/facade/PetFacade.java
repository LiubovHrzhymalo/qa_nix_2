package ua.com.alevel.facade;

import ua.com.alevel.dto.PetRequestDto;
import ua.com.alevel.dto.PetResponseDto;

import java.util.List;

public interface PetFacade {
    void create(PetRequestDto dto);
    void update(PetRequestDto dto, String id);
    void delete(String id);
    PetResponseDto findById(String id);
    List<PetResponseDto> findAll();
}
