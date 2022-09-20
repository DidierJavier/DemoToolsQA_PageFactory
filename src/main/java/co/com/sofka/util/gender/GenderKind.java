package co.com.sofka.util.gender;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class GenderKind {
    private final ArrayList<Gender> listGender = new ArrayList<>();

    private List<Gender> addGender() {
        this.listGender.add(Gender.FEMALE);
        this.listGender.add(Gender.MALE);
        this.listGender.add(Gender.OTHER);
        return listGender;
    }

    public Gender getGenderSelected() {
        Faker faker = new Faker();
        Gender gender;
        gender = this.addGender().get(faker.number().numberBetween(0, 2));
        return gender;
    }
}
