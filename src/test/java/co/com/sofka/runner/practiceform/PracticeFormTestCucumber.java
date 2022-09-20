package co.com.sofka.runner.practiceform;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        //publish = true,
        features = {"src/test/resources/feature/practiceform/practiceForm.feature"},
        glue = {"co/com/sofka/stepdefinition/practiceform"},
        tags = "@Regresion",
        plugin = {"json:test/report/cucumber_report.json"}
)

public class PracticeFormTestCucumber {
    private static final Logger LOGGER = Logger.getLogger(PracticeFormTestCucumber.class);

    @AfterClass
    public static void finish(){
        try{
            LOGGER.info("Generando reporte");
            String[] cmd = {"cmd.exe", "/c", "npm run report"};
            Runtime.getRuntime().exec(cmd);
            LOGGER.info("Reporte generado satisfactoriamente");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
