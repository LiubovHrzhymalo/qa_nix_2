package ua.com.alevel.db;

import ua.com.alevel.entity.Owner;

import java.util.Arrays;
import java.util.UUID;

public class PetDB {
    private Owner[] owners = new Owner[10];

    public void creat(Owner owner) {
        owner.setId(generateId());
        Owner[] owArray = new Owner[owners.length];
        for (int i = 0; i < owners.length; i++) {
            owArray[i] = owners[i];
        }

        owners = new Owner[owners.length + 1];
        for (int i = 0; i < owArray.length; i++) {
            owners[i] = owArray[i];
        }
        owners[owners.length - 1] = owner;
    }

    public void update(Owner owner) {
        Owner current = Arrays.stream(owners).filter(o -> o.getId().equals(owner.getId())).findFirst().get();
        current.setBreedOfanimal(owner.getBreedOfanimal());
        current.setAge(owner.getAge());
    }

    public void delete(String id) {
        if (id != null) {
            int indexOfId = -1;

            for (int i = 0; i < indexOfId; i++){
                if (owners[i].getId().equals(id)){
                    indexOfId=1;
                    break;
                }
            }
            if (indexOfId>-1){
                Owner[] newArray=new Owner[owners.length-1];
                for (int i=0; i<indexOfId; i++){
                    newArray[i]=owners[i];
                }
                for (int i=indexOfId+1; i<owners.length;i++){
                    newArray[i-1]=owners[i];
                }
                owners=newArray;
            }
        }
    }

    public Owner findById(String id) {
        return Arrays.stream(owners).filter(o -> o.getId().equals(id)).findFirst().get();
    }

    public Owner[] findAll(){
        return Arrays.copyOf(owners,owners.length);
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (Arrays.stream(owners).anyMatch(owner -> owner.getId().equals(id))) {
            return generateId();

        }
        return id;
    }
}

