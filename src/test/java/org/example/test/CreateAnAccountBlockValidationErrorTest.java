package org.example.test;

import org.example.ConfProperties;
import org.example.pages.EmailValidationRegistrationPage;
import org.example.testContent.EmailArray;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Collection;
import java.util.List;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class CreateAnAccountBlockValidationErrorTest {

    public static EmailValidationRegistrationPage emailValidationRegistrationPage;
    public static WebDriver driver;



    @Before
    public void setup() {
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

    }

    @Parameterized.Parameter(0)
    public String email;
    @Parameterized.Parameter(1)
    public String resultError;

    @Parameterized.Parameters(name = "run test email {0}")
    public static Collection ParamsMethod()
    {
        return EmailArray.emailArray();
    }

    @Test
    public void createAnAccountBlockValidationErrorTest(){
        emailValidationRegistrationPage.inputEmail(email);
        emailValidationRegistrationPage.clickCreateAnAccountButton();
        List<WebElement> errorText = emailValidationRegistrationPage.getErrorText();
        Assert.assertTrue(!errorText.isEmpty());
        Assert.assertEquals(resultError, errorText.get(0).getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
