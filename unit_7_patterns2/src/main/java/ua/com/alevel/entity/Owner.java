package ua.com.alevel.entity;

import java.util.ArrayList;
import java.util.List;

public class Owner extends BaseEntity {
    private String firstName;
    private String lastName;
    private boolean isVisible;
    private List<String> petIds = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getIsVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public List<String> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<String> petIds) {
        this.petIds = petIds;
    }


}
