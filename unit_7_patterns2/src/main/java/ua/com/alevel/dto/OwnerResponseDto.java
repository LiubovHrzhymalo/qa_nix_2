package ua.com.alevel.dto;
import ua.com.alevel.entity.Owner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OwnerResponseDto {
    private String id;
    private String firstName;
    private String lastName;
    private List<String> petIds = new ArrayList<>();

    public OwnerResponseDto(Owner owner) {
        this.id = owner.getId();
        this.firstName = owner.getFirstName();
        this.lastName = owner.getLastName();
        this.petIds = owner.getPetIds();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getPetIds() {
        return petIds;
    }
}
