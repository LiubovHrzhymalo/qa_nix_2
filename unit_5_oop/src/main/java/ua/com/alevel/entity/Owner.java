package ua.com.alevel.entity;

public class Owner {

    private String id;
    private String breedOfanimal;
    private int age;

    @Override
    public String toString() {
        return "Owner{" +
                "id='" + id + '\'' +
                ", breedOfanimal='" + breedOfanimal + '\'' +
                ", age=" + age +
                '}';
    }

    public String getBreedOfanimal() {
        return breedOfanimal;
    }

    public void setBreedOfanimal(String breedOfanimal) {
        this.breedOfanimal = breedOfanimal;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getNamePet() {

        return breedOfanimal;
    }

    public void setNamePet(String namePet) {

        this.breedOfanimal = namePet;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

}
