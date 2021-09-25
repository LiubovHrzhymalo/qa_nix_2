package ua.com.alevel.dao;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.apache.commons.io.FileUtils;
import ua.com.alevel.config.FileType;
import ua.com.alevel.entity.Owner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class JsonOwnerDao extends OwnerDao implements AllDao<Owner>, FileIO{
    @Override
    public void create(Owner owner) {
        loadEntity();
        createOwner(owner);
        storeEntity();
    }

    @Override
    public void update(Owner owner) {
        loadEntity();
        updateOwner(owner);
        storeEntity();
    }

    @Override
    public void delete(String id) {
        loadEntity();
        deleteOwner(id);
        storeEntity();
    }

    @Override
    public Owner findById(String id) {
        loadEntity();
        return findOwnerById(id);
    }

    @Override
    public List<Owner> findAll() {
        loadEntity();
        return findAllOwners();
    }

    @Override
    public boolean existPet(String ownerId, String petId) {
        loadEntity();
        return existPet(ownerId, petId);
    }

    @Override
    public void link(String ownerId, String petId) {
        loadEntity();
        linkPet(ownerId, petId);
        storeEntity();
    }

    @Override

    public void unlink(String ownerId, String petId) {
        loadEntity();
        unlinkPet(ownerId, petId);
        storeEntity();
    }

    @Override
    public void loadEntity() {
        super.owners.clear();
        try {
            String ownersOut = FileUtils.readFileToString(new File(FileType.OWNERS_JSON_TYPE.getPath()), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            super.owners = objectMapper.readValue(ownersOut, new TypeReference<List<Owner>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeEntity() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()))
                .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, type, jsonSerializationContext) -> new JsonPrimitive(date.getTime()))
                .create();
        String ownerOut = gson.toJson(owners);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileType.OWNERS_JSON_TYPE.getPath()))) {
            writer.append(ownerOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
