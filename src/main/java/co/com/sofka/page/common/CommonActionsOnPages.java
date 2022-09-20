package co.com.sofka.page.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static co.com.sofka.util.Number.*;

public class CommonActionsOnPages {

    private static final Logger LOGGER = Logger.getLogger(CommonActionsOnPages.class);

    private WebDriver driver;

    //Constructor
    public CommonActionsOnPages(WebDriver driver) {
        try {
            if (driver == null) {
                LOGGER.warn("El driver es nulo.");
            }
            this.driver = driver;

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Funcionalidades Genéricas

    protected void clearOn(By locator){
        driver.findElement(locator).clear();
    }

    protected void clearOn(WebElement webElement){
        webElement.clear();
    }

    protected void clickOn(By locator){
        driver.findElement(locator).click();
    }

    protected void clickOn(WebElement webElement){
        webElement.click();
    }

    protected void typeOn(By locator, CharSequence... keysToSend){
        driver.findElement(locator).sendKeys(keysToSend);
    }

    protected void typeOn(WebElement webElement, CharSequence... keysToSend){
        webElement.sendKeys(keysToSend);
    }



    protected void keysEnter(By locator){driver.findElement(locator).sendKeys(Keys.ENTER);}

    protected void keysEnter(WebElement webElement){webElement.sendKeys(Keys.ENTER);}




    protected void scrollOn(By locator){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    protected void scrollOn(WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    protected void clickWithJseOn(By locator){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", driver.findElement(locator));
    }

    protected void clickWithJseOn(WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", webElement);
    }

    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }

    protected String getText(WebElement webElement){
        return webElement.getText();
    }

    protected void dropDown(By locator, String selectString){
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(selectString);
    }

    protected void dropDown(WebElement webElement, String selectString){
        Select select = new Select(webElement);
        select.selectByVisibleText(selectString);
    }

    protected void implicitWaitNotRecomended(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DIEZ.getNumber()));
    }

    protected void explicitWaitForElementToBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DIEZ.getNumber()));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void explicitWaitForElementToBeClickable(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DIEZ.getNumber()));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void explicitWaitForElementToBeSelected(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DIEZ.getNumber()));
        wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

    protected void explicitWaitForElementToBeSelected(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DIEZ.getNumber()));
        wait.until(ExpectedConditions.elementToBeSelected(webElement));
    }

    protected void explicitWaitForElementVisibilityOf(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DIEZ.getNumber()));
        wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

    protected void explicitWaitForElementVisibilityOf(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DIEZ.getNumber()));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void explicitWaitForPresenceElementLocatedBy(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DIEZ.getNumber()));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void explicitWaitForPresenceElementLocated(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DIEZ.getNumber()));
        wait.until(ExpectedConditions.presenceOfElementLocated((By) webElement));
    }

    protected void fluentWait(By locator){
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(CINCO.getNumber()));
        wait.pollingEvery(Duration.ofMillis(DOSCIENTOSCINCUENTA.getNumber()));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void fluentWait(WebElement webElement){
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(5));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
