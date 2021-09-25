package ua.com.alevel.facade;
import org.springframework.stereotype.Service;
import ua.com.alevel.dto.OwnerRequestDto;
import ua.com.alevel.dto.OwnerResponseDto;
import ua.com.alevel.entity.Owner;
import ua.com.alevel.service.OwnerService;

import java.util.ArrayList;
import java.util.List;

@Service

public class OwnerFacadeImpl implements OwnerFacade{
    private final OwnerService ownerService;

    public OwnerFacadeImpl(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    public void create(OwnerRequestDto dto) {
        createOrUpdate(dto, null);
    }

    @Override
    public void update(OwnerRequestDto dto, String id) {
        createOrUpdate(dto, id);
    }

    @Override
    public void delete(String id) {
        ownerService.delete(id);
    }

    @Override
    public OwnerResponseDto findById(String id) {
        return new OwnerResponseDto(ownerService.findById(id));
    }

    @Override
    public List<OwnerResponseDto> findAll() {
        List<Owner> owners = ownerService.findAll();
        List<OwnerResponseDto> dtoList = new ArrayList<>();
        for (Owner owner : owners) {
            dtoList.add(new OwnerResponseDto(owner));
        }
        return dtoList;
    }

    private void createOrUpdate(OwnerRequestDto dto, String id) {
        Owner owner = new Owner();
        owner.setFirstName(dto.getFirstName());
        owner.setLastName(dto.getLastName());
        if (id == null) {
            ownerService.create(owner);
        } else {
            owner.setId(id);
            ownerService.update(owner);
        }
    }
}
