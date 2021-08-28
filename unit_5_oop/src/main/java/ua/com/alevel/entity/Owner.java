package ua.com.alevel.entity;

public class Owner {
    private String id;
    private String pet;
    private String namePet;
    private int age;

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

//    public String getPet(String pet) {
//        return this.pet;
//    }

    public void setPet(String pet) {

        this.pet = pet;
    }

    public String getNamePet() {

        return namePet;
    }

    public void setNamePet(String namePet) {

        this.namePet = namePet;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }


    public String getPet() {
        return this.pet;
    }
}
