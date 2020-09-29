package com.seleniumgluecode;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.Pages.LoginPage;

import java.security.Key;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Test {


   private ChromeDriver driver = (ChromeDriver) Hooks.getDriver();

    private LoginPage  loginPage = new LoginPage(driver);

    @Given("^La pagina home Orangehrmlive$")
    public void la_pagina_home_Orangehrmlive() throws Throwable {
        WebElement nextPageLocator = driver.findElement(By.xpath("//img[@src='/webres_5ebd1457b45137.49759927/themes/default/images/login/logo.png']"));
        Assert.assertTrue("No es el mensaje esperado",nextPageLocator.isDisplayed());
    }

    @Given("^Registrar usuario y contraseña$")
    public void registrar_usuario_y_contraseña() throws Throwable {

        WebElement userLocator = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
        WebElement passLocator = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));

        userLocator.sendKeys("admin");
        passLocator.sendKeys("admin123");
    }

    @Given("^Hacer click sobre el boton login$")
    public void hacer_click_sobre_el_boton_login() throws Throwable {

        WebElement  btnLocator = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
        btnLocator.click();
    }

    @Then("^El la guiente pantallas dar click en la pestaña Recruiment$")
    public void el_la_guiente_pantallas_dar_click_en_la_pestaña_Recruiment() throws Throwable {


        WebElement recruimentLocator = driver.findElement(By.xpath("//img[@src='/webres_5ebd1457b45137.49759927/themes/default/images/logo.png']"));

        WebElement recluLocator = driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]"));

        Assert.assertTrue("Recruitment ",recruimentLocator.isDisplayed());

        if (recruimentLocator.isDisplayed()){

            recluLocator.click();

        }
        else{
            System.out.print("No ingreso a reclutamiento");
        }

    }

    @Then("^Dar click a la pestaña Candidates$")
    public void dar_click_a_la_pestaña_Candidates() throws Throwable {

        WebElement candidatosLocator = driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewCandidates\"]"));//pagina para buacar
        Assert.assertTrue("Candidates",candidatosLocator.isDisplayed());

        //comparacion de mensajes
        Assert.assertEquals("Candidates",candidatosLocator.getText());
    }

    @Given("^Ingresar trabajo$")
    public void ingresar_trabajo() throws Throwable {
        Select formcargosLocator = new Select(driver.findElement(By.xpath("//*[@id=\"candidateSearch_jobTitle\"]")));
        formcargosLocator.selectByVisibleText("CEO");
        formcargosLocator.getOptions();
    }

    //segundo Scenario
    @Given("^Ingresar Vacancy$")
    public void ingresar_Vacancy() throws Throwable {

        Select VacancyLocator = new Select(driver.findElement(By.xpath("//*[@id=\"candidateSearch_jobVacancy\"]")));
        VacancyLocator.selectByVisibleText("All");
        VacancyLocator.getOptions();
    }

    @Given("^Ingresar Hiring Manager$")
    public void ingresar_Hiring_Manager() throws Throwable {

        Select ManagerLocator = new Select(driver.findElement(By.xpath("//*[@id=\"candidateSearch_hiringManager\"]")));
        ManagerLocator.selectByVisibleText("All");
        ManagerLocator.getOptions();
    }

    @Given("^Ingresar Status$")
    public void ingresar_Status() throws Throwable {

        Select StatusLocator = new Select(driver.findElement(By.xpath("//*[@id=\"candidateSearch_status\"]")));
        StatusLocator.selectByVisibleText("Job Offered");
        StatusLocator.getOptions();
    }

    @Given("^Ingresar Candidate Name$")
    public void ingresar_Candidate_Name() throws Throwable {

        WebElement NameLocator = driver.findElement(By.xpath("//*[@id=\"candidateSearch_candidateName\"]"));
        NameLocator.sendKeys("Santiago");
    }

    @Given("^Ingresar Keywords$")
    public void ingresar_Keywords() throws Throwable {

        WebElement KeywordsLocator = driver.findElement(By.xpath("//*[@id=\"candidateSearch_keywords\"]"));
        KeywordsLocator.sendKeys("Todos los demas");
    }

    @Then("^Ingresar Date of ApplicationFrom$")
    public void ingress_Date_of_ApplicationFrom() throws Throwable {

        String dateTime = "06/01/2020";
        loginPage.setFechaNormal(dateTime);

        //String dateTimeTwo = "06/15/2020";
        //loginPage.setfechaGeneral(dateTimeTwo);
        ingress_Date_of_ApplicationTo();

    }

    //Fechas

    @Then("^Ingresar Date of ApplicationTo$")
    public void ingress_Date_of_ApplicationTo() throws Throwable {

        String dateTimeTwo = "06/15/2020";
        //String dateTimeTwo = "01072020";

        loginPage.setfechaGeneral(dateTimeTwo);

        method_of_Application();

    }


    @Then("^Method of Application$")
    public void method_of_Application() throws Throwable {
        Select CandidatesSearchLocator = new Select(driver.findElement(By.xpath("//*[@id=\"candidateSearch_modeOfApplication\"]")));
        CandidatesSearchLocator.selectByVisibleText("Online");
        CandidatesSearchLocator.getOptions();
    }

    @When("^Buscar Candidates$")
    public void buscar_Candidates() throws Throwable {
      WebElement BtnBusquedaLocator = driver.findElement(By.xpath("//*[@id=\"btnSrch\"]"));
        BtnBusquedaLocator.click();
    }

}
