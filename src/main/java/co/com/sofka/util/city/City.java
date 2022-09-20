package co.com.sofka.util.city;

import co.com.sofka.model.practiceform.PracticeFormModel;
import com.github.javafaker.Faker;

import java.util.ArrayList;

import static co.com.sofka.util.Number.*;
import static co.com.sofka.util.state.StateEnum.*;

public class City {

    Faker faker = new Faker();

    private final ArrayList<String> citysNCR = new ArrayList<>();

    private final ArrayList<String> citysUttarPradesh = new ArrayList<>();

    private final ArrayList<String> citysHaryana = new ArrayList<>();

    private final ArrayList<String> citysRajasthan = new ArrayList<>();

    private void addCityNCR() {
        this.citysNCR.add("Delhi");
        this.citysNCR.add("Gurgaon");
        this.citysNCR.add("Noida");
    }

    public String getOneCityOfNCR() {
        addCityNCR();
        return this.citysNCR.get(faker.number().numberBetween(CERO.getNumber(), DOS.getNumber()));
    }

    private void addCityUttarPradesh() {
        this.citysUttarPradesh.add("Agra");
        this.citysUttarPradesh.add("Lucknow");
        this.citysUttarPradesh.add("Merrut");
    }

    public String getOneCityOfUttarPradesh() {
        addCityUttarPradesh();
        return this.citysUttarPradesh.get(faker.number().numberBetween(CERO.getNumber(), DOS.getNumber()));
    }

    private void addCityHaryana() {
        this.citysHaryana.add("Karnal");
        this.citysHaryana.add("Panipat");
    }

    public String getOneCityOfHaryana() {
        addCityHaryana();
        return this.citysHaryana.get(faker.number().numberBetween(CERO.getNumber(), UNO.getNumber()));
    }

    private void addCityRajasthan() {
        this.citysRajasthan.add("Jaipur");
        this.citysRajasthan.add("Panipat");
    }

    public String getOneCityOfRajashtan() {
        addCityRajasthan();
        return this.citysRajasthan.get(faker.number().numberBetween(CERO.getNumber(), UNO.getNumber()));
    }

    public String getCitySelected(String state){
        String city = "";
        if (state == NCR.getStateEnum()){ city = getOneCityOfNCR();}
        if (state == UTTAR_PRADESH.getStateEnum()){ city = getOneCityOfUttarPradesh();}
        if (state == HARYANA.getStateEnum()){ city = getOneCityOfHaryana();}
        if (state == RAJASHTHAN.getStateEnum()){ city = getOneCityOfRajashtan();}
        return city;
    }

}
