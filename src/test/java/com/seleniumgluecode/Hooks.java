package com.seleniumgluecode;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    //variable de la clase no del objeto
    private static ChromeDriver driver;
    private static int numeroOFCase = 0;



    //metodo antes de cada escenario y genera una instancia del navegador para ir a la pagina de prueba
    @Before
    public  void SetUp(){
        numeroOFCase++;
        System.out.println("se esta ejecutando el caso numero: "+ numeroOFCase);
        System.setProperty("webdriver.chrome.driver","./src/test/resourses/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");//pagina para buacar
        driver.manage().window().maximize();
    }

    // cuando un escenario falla este metodo es para que tome los pantallasos del fallo
    //tambien cierra el navegador
    @After
    public void tearDown(Scenario scenario) {

        // driver.quit();//cerrar el driver
    }


    //metodo para el driver, y devuelve el driver
    public  static WebDriver getDriver(){
        return driver;
    }

}
