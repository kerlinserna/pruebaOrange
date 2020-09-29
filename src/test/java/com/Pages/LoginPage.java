package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.List;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver browserDriver)
    {
        driver = browserDriver;

        //el esperar que carge la pagina (wait)

        wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
    }

    public void setUser(String User)
    {
        WebElement userLocator = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));

        userLocator.sendKeys(User);

    }

    public void setPassword(String password)
    {
        WebElement passLocator = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));

        passLocator.sendKeys(password);

    }

    public void clickSingInButton()
    {
        WebElement  btnLocator = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
        btnLocator.click();
    }

    public void setfechaGeneral(String fecha) throws InterruptedException {
        //Buscar el control datepicker
        WebElement dateBox = driver.findElement(By.xpath("//*[@id=\"candidateSearch_fromDate\"]"));

        //llenar la fecha (dd/mm/aaaa) sin delimiter (/)
        dateBox.click();

        //Botón para desplazarse a la siguiente en el calendario
        WebElement nextLink = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]"));

        //Botón para hacer clic en el centro del encabezado del calendario
        WebElement mesLink = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]"));
        WebElement añoLink = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]"));

        //botón para mover el mes anterior en el calendario
        WebElement previousLink = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span"));

        //Particionar el datetime para obtener solo la parte de la fecha
        String date_dd_MM_yyyy[] = (fecha.split(" ")[0]).split("/");

        //Obtener la diferencia de año entre el año actual y el año a establecer en el Calendario
        int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
        añoLink.click();
        if (yearDiff != 0) {

            //Si se tiene que mover a el proximo año
            if (yearDiff > 0) {
                for (int i = 0; i < yearDiff; i++) {
                    System.out.println("Year Diff->" + i);
                    nextLink.click();
                }
            }

            //Si tienes que moverte al año anterior
            else if (yearDiff < 0) {
                for (int i = 0; i < (yearDiff * (-1)); i++) {
                    System.out.println("Year Diff->" + i);
                    previousLink.click();
                }
            }
        }
        Thread.sleep(1000);


        //Obtener todos los meses de calendario para seleccionar uno correcto
        List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']//table//tbody//tr//td[not(contains(@class,'ui-datepicker-other-month ui-datepicker-unselectable ui-state-disabled'))]"));
        list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1]) - 1).click();
        Thread.sleep(1000);

        //obtener todas las fechas del calendario para seleccionar una correcta
        List<WebElement> list_AllDateToBook = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']//table//tbody//tr//td[not(contains(@class,'ui-datepicker-other-month ui-datepicker-unselectable ui-state-disabled'))]"));
        list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0]) - 1).click();

    }

    public void setFechaNormal(String fechaNormal) throws InterruptedException {
        //Buscar el control datepicker
        //WebElement dateBox = driver.findElement(By.xpath("//*[@id=\"candidateSearch_fromDate\"]"));
        WebElement dateBox = driver.findElement(By.xpath("//*[@id=\"candidateSearch_toDate\"]"));

        //llenar la fecha (dd/mm/aaaa) sin delimiter (/)
        dateBox.sendKeys(fechaNormal);
    }


}
