package ua.com.alevel.dao;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.apache.commons.io.FileUtils;
import ua.com.alevel.config.FileType;
import ua.com.alevel.entity.Pet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class JsonPetDao extends PetDao implements AllDao<Pet>, FileIO{
    @Override
    public void create(Pet pet) {
        loadEntity();
        createPet(pet);
        storeEntity();
    }

    @Override
    public void update(Pet pet) {
        loadEntity();
        updatePet(pet);
        storeEntity();
    }

    @Override
    public void delete(String id) {
        loadEntity();
        deletePet(id);
        storeEntity();
    }

    @Override
    public Pet findById(String id) {
        loadEntity();
        return findPetById(id);
    }

    @Override
    public List<Pet> findAll() {
        loadEntity();
        return findAllPets();
    }

    @Override
    public void link(String ownerId, String petId) {
        loadEntity();
        linkOwner(ownerId, petId);
        storeEntity();
    }

    @Override
    public void unlink(String ownerId, String petId) {
        loadEntity();
        unlinkOwner(ownerId, petId);
        storeEntity();
    }

    @Override
    public void loadEntity() {
        super.pets.clear();
        try {
            String petsOut = FileUtils.readFileToString(new File(FileType.PETS_JSON_TYPE.getPath()), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            super.pets = objectMapper.readValue(petsOut, new TypeReference<List<Pet>>()  { });
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
        String petOut = gson.toJson(pets);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FileType.PETS_JSON_TYPE.getPath()))) {
            writer.append(petOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
