package co.com.sofka.stepdefinition.practiceform;

import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.page.PracticeFormPageCases;
import co.com.sofka.runner.practiceform.PracticeFormTestCucumber;
import co.com.sofka.setup.SetupWebUI;
import co.com.sofka.util.Number;
import co.com.sofka.util.city.City;
import co.com.sofka.util.gender.GenderKind;
import co.com.sofka.util.hobbies.HobbieKind;
import co.com.sofka.util.months.Months;
import co.com.sofka.util.state.State;
import co.com.sofka.util.subjects.Subjects;
import com.github.javafaker.Faker;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static co.com.sofka.util.Number.*;
import static com.google.common.base.StandardSystemProperty.USER_DIR;


public class PracticeFormTestCucumberStepDefinition extends SetupWebUI {

    private static final Logger LOGGER = Logger.getLogger(PracticeFormTestCucumberStepDefinition.class);
    PracticeFormPageCases practiceFormPageCases;


    @Dado("que el empleado administrativo se encuentra en la página web de los ingresos de estudiantes")
    public void queElEmpleadoAdministrativoSeEncuentraEnLaPaginaWebDeLosIngresosDeEstudiantes() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            LOGGER.info("Configuración del navegador lista.");
        }catch (Exception e){
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }
    }

    //Escenario: Ingreso de un estudiante con los campos obligatorios.
    @Cuando("el empleado administrativo ingresa los campos obligatorios y confirma la acción")
    public void elEmpleadoAdministrativoIngresaLosCamposObligatoriosYConfirmaLaAccion() {
        try{
            practiceFormPageCases = new PracticeFormPageCases(driver, practiceForm());
            practiceFormPageCases.fillStudentForm();
        }catch (Exception e){
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Entonces("el sistema deberá mostrar por pantalla el registro del estudiante ingresado.")
    public void elSistemaDeberaMostrarPorPantallaElRegistroDelEstudianteIngresado() {
        Assertions.assertEquals(forSubmitedForm(), practiceFormPageCases.isRegistrationDone());
        quiteDriver();
    }

    //Escenario: Ingreso de un estudiante con todos los campos.
    @Cuando("el empleado administrativo ingresa valores a todos los campos obligatorios y confirma la acción")
    public void elEmpleadoAdministrativoIngresaValoresATodosLosCamposObligatoriosYConfirmaLaAccion() {
        try{
            practiceFormPageCases = new PracticeFormPageCases(driver, practiceForm());
            practiceFormPageCases.fillAllFields();
        }catch (Exception e){
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }
    }
    @Entonces("el sistema deberá mostrar por pantalla el registro del estudiante ingresado con todos sus campos.")
    public void elSistemaDeberaMostrarPorPantallaElRegistroDelEstudianteIngresadoConTodosSusCampos() {
        Assertions.assertEquals(forSubmitedFormAllFields(), practiceFormPageCases.isRegistrationDoneAllFields());
        quiteDriver();
    }


    //Funciones privadas
    private PracticeFormModel practiceForm(){
        PracticeFormModel practiceFormModel = new PracticeFormModel();
        Faker faker = new Faker();
        Months months = new Months();
        Subjects subjects = new Subjects();
        GenderKind genderKind = new GenderKind();
        HobbieKind hobbieKind = new HobbieKind();
        State state = new State();
        City city = new City();
        practiceFormModel.setName(faker.name().firstName());
        practiceFormModel.setLastName(faker.name().lastName());
        practiceFormModel.setEmail(faker.internet().emailAddress());
        practiceFormModel.setGender(genderKind.getGenderSelected());
        practiceFormModel.setMobile(faker.number().digits(DIEZ.getNumber()));
        practiceFormModel.setDay(String.valueOf(faker.number().numberBetween(UNO.getNumber(), VEINTIOCHO.getNumber())));
        practiceFormModel.setMonth(months.getMonthsYear().get(faker.number().numberBetween(CERO.getNumber(), ONCE.getNumber())));
        practiceFormModel.setYear(String.valueOf(faker.number().numberBetween(MILNOVECIENTOSCUARENTA.getNumber(), DOSMILVEINTIDOS.getNumber())));
        practiceFormModel.setSubjects(new ArrayList<>(subjects.getSubjectsRandom()));
        practiceFormModel.setHobbies(hobbieKind.getHobieSelected());
        practiceFormModel.setPicture(USER_DIR.value() + "\\src\\test\\resources\\images\\practiceform\\happy.png");
        practiceFormModel.setCurrentAddress(faker.address().fullAddress());
        practiceFormModel.setState(state.getOneStateOfList());

        practiceFormModel.setCity(city.getCitySelected(practiceFormModel.getState()));

        return practiceFormModel;
    }

    private List<String> forSubmitedForm() {
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(this.practiceFormPageCases.getPracticeFormModel().getName() + " " + this.practiceFormPageCases.getPracticeFormModel().getLastName());
        submitedFormResult.add(this.practiceFormPageCases.getPracticeFormModel().getGender().getValue());
        submitedFormResult.add(this.practiceFormPageCases.getPracticeFormModel().getMobile());
        return submitedFormResult;
    }

    private List<String> forSubmitedFormAllFields() {
        List<String> submitedFormResultAllFields = new ArrayList<>();
        submitedFormResultAllFields.add(this.practiceFormPageCases.getPracticeFormModel().getName() + " " + this.practiceFormPageCases.getPracticeFormModel().getLastName());
        submitedFormResultAllFields.add(this.practiceFormPageCases.getPracticeFormModel().getEmail());
        submitedFormResultAllFields.add(this.practiceFormPageCases.getPracticeFormModel().getGender().getValue());
        submitedFormResultAllFields.add(this.practiceFormPageCases.getPracticeFormModel().getMobile());
        if(Integer.parseInt(this.practiceFormPageCases.getPracticeFormModel().getDay()) < DIEZ.getNumber()){
            this.practiceFormPageCases.getPracticeFormModel().setDay(CERO.getNumber() + this.practiceFormPageCases.getPracticeFormModel().getDay());
        }
        submitedFormResultAllFields.add(this.practiceFormPageCases.getPracticeFormModel().getDay() + " " + this.practiceFormPageCases.getPracticeFormModel().getMonth() + "," + this.practiceFormPageCases.getPracticeFormModel().getYear());

        submitedFormResultAllFields.add(this.practiceFormPageCases.getPracticeFormModel().getSubjects().get(CERO.getNumber()) + ", " + this.practiceFormPageCases.getPracticeFormModel().getSubjects().get(UNO.getNumber()));
        submitedFormResultAllFields.add(this.practiceFormPageCases.getPracticeFormModel().getHobbies().getValue());
        submitedFormResultAllFields.add(this.practiceFormPageCases.getPracticeFormModel().getCurrentAddress());
        submitedFormResultAllFields.add(this.practiceFormPageCases.getPracticeFormModel().getState() + " " + this.practiceFormPageCases.getPracticeFormModel().getCity());
        LOGGER.info(submitedFormResultAllFields);
        return submitedFormResultAllFields;
    }
}
