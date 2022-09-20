package co.com.sofka.util.hobbies;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class HobbieKind {

    private final ArrayList<Hobbies> listHobbies = new ArrayList<>();

    private List<Hobbies> addHobbie() {
        this.listHobbies.add(Hobbies.SPORTS);
        this.listHobbies.add(Hobbies.READING);
        this.listHobbies.add(Hobbies.MUSIC);
        return listHobbies;
    }

    public Hobbies getHobieSelected() {
        Faker faker = new Faker();
        Hobbies hobbie;
        hobbie = this.addHobbie().get(faker.number().numberBetween(0, 2));
        return hobbie;
    }
}
