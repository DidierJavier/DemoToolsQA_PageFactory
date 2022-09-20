package co.com.sofka.util.months;

import java.util.ArrayList;
import java.util.List;

public class Months {

    private final ArrayList<String> monthsOfYear = new ArrayList<>();

    private ArrayList<String> addMonth() {
        this.monthsOfYear.add(Month.JANUARY.getValue());
        this.monthsOfYear.add(Month.FEBRUARY.getValue());
        this.monthsOfYear.add(Month.MARCH.getValue());
        this.monthsOfYear.add(Month.APRIL.getValue());
        this.monthsOfYear.add(Month.MAY.getValue());
        this.monthsOfYear.add(Month.JUNE.getValue());
        this.monthsOfYear.add(Month.JULY.getValue());
        this.monthsOfYear.add(Month.AUGUST.getValue());
        this.monthsOfYear.add(Month.SEPTEMBER.getValue());
        this.monthsOfYear.add(Month.OCTOBER.getValue());
        this.monthsOfYear.add(Month.NOVEMBER.getValue());
        this.monthsOfYear.add(Month.DECEMBER.getValue());
        return monthsOfYear;
    }
    public List<String> getMonthsYear() {
        return addMonth();
    }

}
