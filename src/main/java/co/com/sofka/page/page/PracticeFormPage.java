package co.com.sofka.page.page;

import co.com.sofka.page.common.CommonActionsOnPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeFormPage extends CommonActionsOnPages {

    //Entrada datos
    @CacheLookup
    @FindBy(id = "firstName")
    protected WebElement firstName;
    //protected By firstName = By.id("firstName");

    @CacheLookup
    @FindBy(id = "lastName")
    protected WebElement lastName;
    //protected By lastName = By.id("lastName");

    @CacheLookup
    @FindBy(id = "userEmail")
    protected WebElement userEmail;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Male']")
    protected WebElement genderMale;
    //protected By genderMale = By.xpath("//label[normalize-space()='Male']");

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Female']")
    protected WebElement genderFemale;
    //protected By genderFemale = By.xpath("//label[normalize-space()='Female']");

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Other']")
    protected WebElement genderOther;
    //protected By genderOther = By.id("//label[normalize-space()='Other']");

    @CacheLookup
    @FindBy(id = "userNumber")
    protected WebElement mobile;
    //protected By mobile = By.id("userNumber");

    @CacheLookup
    @FindBy(id = "submit")
    protected WebElement submit;
   // protected By submit = By.id("submit");

    @CacheLookup
    @FindBy(id="dateOfBirthInput")
    protected WebElement dateOfBirthInput;
    //protected final By dateOfBirthInput = By.id="dateOfBirthInput";
    @FindBy(id="subjectsInput")
    protected WebElement subjects;
    //protected final By subjects = By.id("subjectsContainer");

    @CacheLookup
    @FindBy(css="label[for='hobbies-checkbox-1']")
    protected WebElement hobbiesSports;
    //protected final By hobbiesSports = By.xpath("label[for='hobbies-checkbox-1']");

    @CacheLookup
    @FindBy(css="label[for='hobbies-checkbox-2']")
    protected WebElement hobbiesReading;
    //protected final By hobbiesReading = By.xpath("label[for='hobbies-checkbox-2']");

    @CacheLookup
    @FindBy(css="label[for='hobbies-checkbox-3']")
    protected WebElement hobbiesMusic;
    //protected final By hobbiesMusic = By.xpath("label[for='hobbies-checkbox-3']");

    protected final By selectFileToUpload = By.id("uploadPicture");

    @CacheLookup
    @FindBy(id="currentAddress")
    protected WebElement currentAddress;
    //protected final By currentAddress = By.id("currentAddress");


    @CacheLookup
    @FindBy(id="react-select-3-input")
    protected WebElement state;
    //protected final By state = By.id("react-select-3-input");

    @CacheLookup
    @FindBy(id="react-select-4-input")
    protected WebElement city;
    //protected final By city = By.id("react-select-4-input");


    //Para validaciones.////////////////////////////////////////////////////////////////////////////////////////////
    @CacheLookup
    @FindBy(xpath = "//table/tbody/tr[1]/td[2]")
    protected WebElement assertionStudentFullName;
    //protected final By assertionStudentFullName = By.xpath("//table/tbody/tr[1]/td[2]");

    @CacheLookup
    @FindBy(xpath = "//table/tbody/tr[2]/td[2]")
    protected WebElement assertionStudentEmail;
    //protected final By assertionStudentEmail = By.xpath("//table/tbody/tr[2]/td[2]");

    @CacheLookup
    @FindBy(xpath = "//table/tbody/tr[3]/td[2]")
    protected WebElement assertionStudentGender;
    //protected final By assertionStudentGender = By.xpath("//table/tbody/tr[3]/td[2]");

    @CacheLookup
    @FindBy(xpath = "//table/tbody/tr[4]/td[2]")
    protected WebElement assertionStudentMobile;
    //protected final By assertionStudentMobile = By.xpath("//table/tbody/tr[4]/td[2]");

    @CacheLookup
    @FindBy(xpath = "//table/tbody/tr[5]/td[2]")
    protected WebElement assertionStudentDateOfBirth;
    //protected final By assertionStudentDateOfBirth = By.xpath("//table/tbody/tr[5]/td[2]");

    @CacheLookup
    @FindBy(xpath = "//table/tbody/tr[6]/td[2]")
    protected WebElement assertionStudentSubjects;
    //protected final By assertionStudentSubjects = By.xpath("//table/tbody/tr[6]/td[2]");

    @CacheLookup
    @FindBy(xpath = "//table/tbody/tr[7]/td[2]")
    protected WebElement assertionStudentHobbies;
    //protected final By assertionStudentHobbies = By.xpath("//table/tbody/tr[7]/td[2]");

    @CacheLookup
    @FindBy(xpath = "//table/tbody/tr[8]/td[2]")
    protected WebElement assertionStudentPicture;
    //protected final By assertionStudentPicture = By.xpath("//table/tbody/tr[8]/td[2]");

    @CacheLookup
    @FindBy(xpath = "//table/tbody/tr[9]/td[2]")
    protected WebElement assertionStudentAddress;
    //protected final By assertionStudentAddress = By.xpath("//table/tbody/tr[9]/td[2]");

    @CacheLookup
    @FindBy(xpath = "//table/tbody/tr[10]/td[2]")
    protected WebElement assertionStudentStateAndCity;
    //protected final By assertionStudentStateAndCity = By.xpath("//table/tbody/tr[10]/td[2]");

    /*public PracticeFormPage(WebDriver driver) {
        super(driver);
    }*/
    public PracticeFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
