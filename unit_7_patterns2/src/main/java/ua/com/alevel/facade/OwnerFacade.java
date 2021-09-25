package ua.com.alevel.facade;

import ua.com.alevel.dto.OwnerRequestDto;
import ua.com.alevel.dto.OwnerResponseDto;
import ua.com.alevel.entity.Owner;

import java.util.List;

public interface OwnerFacade {
    void create(OwnerRequestDto dto);
    void update(OwnerRequestDto dto, String id);
    void delete(String id);
    OwnerResponseDto findById(String id);
    List<OwnerResponseDto> findAll();
}
