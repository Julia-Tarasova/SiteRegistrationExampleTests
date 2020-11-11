package org.example.test;

import org.example.ConfProperties;
import org.example.pages.EmailValidationRegistrationPage;
import org.example.pages.PersonalInfoRegistrationPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PasswordTest {

    public static EmailValidationRegistrationPage emailValidationRegistrationPage;
    public static PersonalInfoRegistrationPage personalInfoRegistrationPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("signinpage"));

        emailValidationRegistrationPage = new EmailValidationRegistrationPage(driver);
        personalInfoRegistrationPage = new PersonalInfoRegistrationPage(driver);
    }

    @Test
    public void passwordTest() {
        emailValidationRegistrationPage.inputEmail("mnbv@def.com");
        emailValidationRegistrationPage.clickCreateAnAccountButton();
        personalInfoRegistrationPage.setFirstName("Ana");
        personalInfoRegistrationPage.setLastName("Berg");
        personalInfoRegistrationPage.setPassword("1234");
        personalInfoRegistrationPage.setAddress("Msk, Red Square");
        personalInfoRegistrationPage.setCity("Moscow");
        personalInfoRegistrationPage.setZip("12345");
        personalInfoRegistrationPage.setPhone("7123456890");
        personalInfoRegistrationPage.setState("California");
        personalInfoRegistrationPage.registrationButtonClick();
        String errorText = personalInfoRegistrationPage.getErrorText();
        Assert.assertEquals("passwd", errorText);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
