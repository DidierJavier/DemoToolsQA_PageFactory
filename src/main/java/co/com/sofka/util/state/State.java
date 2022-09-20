package co.com.sofka.util.state;

import com.github.javafaker.Faker;

import java.util.ArrayList;

import static co.com.sofka.util.Number.CERO;
import static co.com.sofka.util.Number.TRES;

public class State {
    private final ArrayList<String> stateList = new ArrayList<>();

    private void addState() {
        this.stateList.add("NCR");
        this.stateList.add("Haryana");
        this.stateList.add("Rajasthan");
        this.stateList.add("Uttar Pradesh");
    }

    public String getOneStateOfList() {
        addState();
        Faker faker = new Faker();
        return this.stateList.get(faker.number().numberBetween(CERO.getNumber(), TRES.getNumber()));
    }
}
