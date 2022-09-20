package co.com.sofka.page.page;

import co.com.sofka.model.practiceform.PracticeFormModel;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static co.com.sofka.util.Number.CERO;
import static co.com.sofka.util.Number.UNO;

public class PracticeFormPageCases extends PracticeFormPage{

    private static final Logger LOGGER = Logger.getLogger(PracticeFormPageCases.class);

    private PracticeFormModel practiceFormModel;

    public PracticeFormModel getPracticeFormModel() {
        return practiceFormModel;
    }

    public void setPracticeFormModel(PracticeFormModel practiceFormModel) {
        this.practiceFormModel = practiceFormModel;
    }

    public PracticeFormPageCases(WebDriver driver, PracticeFormModel practiceFormModel) {
        super(driver);
        this.practiceFormModel = practiceFormModel;
    }

    public PracticeFormPageCases(WebDriver driver) {
        super(driver);
    }

    public void fillStudentForm(){
        fluentWait(firstName);
        scrollOn(firstName);
        clearOn(firstName);
        typeOn(firstName, practiceFormModel.getName());

        scrollOn(lastName);
        clearOn(lastName);
        typeOn(lastName, practiceFormModel.getLastName());

        //Genero
        switch (practiceFormModel.getGender()){
            case MALE:
                clickOn(genderMale);
                break;
            case FEMALE:
                clickOn(genderFemale);
                break;
            case OTHER:
                clickOn(genderOther);
                break;
            default:
                LOGGER.warn("No se ha suministrado un valor de género adecuado;" +
                        "por favor valide la generación de datos");
        }

        scrollOn(mobile);
        clearOn(mobile);
        typeOn(mobile, practiceFormModel.getMobile());

        scrollOn(submit);
        clickWithJseOn(submit);
    }

    public void fillAllFields() {
        scrollOn(firstName);
        clearOn(firstName);
        typeOn(firstName, practiceFormModel.getName());

        scrollOn(lastName);
        clearOn(lastName);
        typeOn(lastName, practiceFormModel.getLastName());

        scrollOn(userEmail);
        clearOn(userEmail);
        typeOn(userEmail, practiceFormModel.getEmail());

        //Genero
        switch (practiceFormModel.getGender()) {
            case MALE:
                clickOn(genderMale);
                break;
            case FEMALE:
                clickOn(genderFemale);
                break;
            case OTHER:
                clickOn(genderOther);
                break;
            default:
                LOGGER.warn("No se ha suministrado un valor de género adecuado;" +
                        "por favor valide la generación de datos");
        }

        scrollOn(mobile);
        clearOn(mobile);
        typeOn(mobile, practiceFormModel.getMobile());

        scrollOn(dateOfBirthInput);
        clearOn(dateOfBirthInput);
        clickOn(By.xpath("//option[text() = '" + practiceFormModel.getYear() + "' ]"));
        clickOn(By.xpath("//option[. = '" + practiceFormModel.getMonth() + "' ]"));
        clickOn(By.xpath("//div[contains(@aria-label,'" + practiceFormModel.getMonth() + " " + practiceFormModel.getDay() + "')" + " and contains(@aria-label,'" + practiceFormModel.getYear() + "')]"));

        scrollOn(subjects);
        //clickOn(subjects);
        LOGGER.info(practiceFormModel.getSubjects().get(CERO.getNumber()));
        typeOn(subjects, practiceFormModel.getSubjects().get(CERO.getNumber()));
        keysEnter(subjects);
        typeOn(subjects, practiceFormModel.getSubjects().get(UNO.getNumber()));
        keysEnter(subjects);

        switch (practiceFormModel.getHobbies()) {
            case SPORTS:
                clickWithJseOn(hobbiesSports);
                break;
            case READING:
                clickWithJseOn(hobbiesReading);
                break;
            case MUSIC:
                clickWithJseOn(hobbiesMusic);
                break;
            default:
                LOGGER.warn("No se ha suministrado un valor de género adecuado;" +
                        "por favor valide la generación de datos");
        }

        scrollOn(currentAddress);
        clearOn(currentAddress);
        typeOn(currentAddress, practiceFormModel.getCurrentAddress());

        scrollOn(state);
        typeOn(state, practiceFormModel.getState());
        keysEnter(state);

        fluentWait(city);
        scrollOn(city);
        typeOn(city, practiceFormModel.getCity());
        keysEnter(city);

        scrollOn(submit);
        clickWithJseOn(submit);
    }

    public List<String> isRegistrationDone(){
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(getText(assertionStudentFullName).trim());
        submitedFormResult.add(getText(assertionStudentGender).trim());
        submitedFormResult.add(getText(assertionStudentMobile).trim());
        return submitedFormResult;
    }

    public List<String> isRegistrationDoneAllFields(){
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(getText(assertionStudentFullName).trim());
        submitedFormResult.add(getText(assertionStudentEmail).trim());
        submitedFormResult.add(getText(assertionStudentGender).trim());
        submitedFormResult.add(getText(assertionStudentMobile).trim());
        submitedFormResult.add(getText(assertionStudentDateOfBirth).trim());
        submitedFormResult.add(getText(assertionStudentSubjects).trim());
        submitedFormResult.add(getText(assertionStudentHobbies).trim());
        submitedFormResult.add(getText(assertionStudentAddress).trim());
        submitedFormResult.add(getText(assertionStudentStateAndCity).trim());
        LOGGER.info(submitedFormResult);
        return submitedFormResult;
    }
}
