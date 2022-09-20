package co.com.sofka.util.subjects;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

import static co.com.sofka.util.Number.CERO;
import static co.com.sofka.util.Number.DIEZ;

public class Subjects {
    private final ArrayList<String> subjectsListOne = new ArrayList<>();

    private List<String> addSubjectOne() {
        this.subjectsListOne.add(Subject.ACCOUNTING.getValue());
        this.subjectsListOne.add(Subject.ARTS.getValue());
        this.subjectsListOne.add(Subject.BIOLOGY.getValue());
        this.subjectsListOne.add(Subject.CHEMISTRY.getValue());
        this.subjectsListOne.add(Subject.COMMERCE.getValue());
        this.subjectsListOne.add(Subject.ECONOMICS.getValue());
        this.subjectsListOne.add(Subject.ENGLISH.getValue());
        this.subjectsListOne.add(Subject.HINDI.getValue());
        this.subjectsListOne.add(Subject.HISTORY.getValue());
        this.subjectsListOne.add(Subject.MATH.getValue());
        this.subjectsListOne.add(Subject.PHYSICS.getValue());
        return subjectsListOne;
        }

    public List<String> getSubjectsRandom() {
        Faker faker = new Faker();
        List<String> subjectsList = addSubjectOne();
        List<String> subject = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            subject.add(subjectsList.get(faker.number().numberBetween(CERO.getNumber(), DIEZ.getNumber())));
        }
        return subject;
    }


}
