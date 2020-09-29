package com.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

//1 primero se coloca donde busca los escenarios de pruebas
@CucumberOptions(
        features = "src/test/java/com/features",//ruta de donde encuentra los features
        glue = ("com/seleniumgluecode"),//implementacion de los ecesenarios de prueba
        plugin = {"json:test/report/cucumber_report.json"},// para ver los reportes
        snippets = SnippetType.CAMELCASE// lenguaje de los casos
)

public class Testrunner {
}
