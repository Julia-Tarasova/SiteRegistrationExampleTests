package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmailValidationRegistrationPage {

    public WebDriver driver;

    public EmailValidationRegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'email_create')]")
    private WebElement emailTextInput;

    @FindBy(xpath = "//*[contains(@id, 'SubmitCreate')]")
    private WebElement createAnAccountButton;

    public void inputEmail(String email) {
        emailTextInput.sendKeys(email);
    }

    public void clickCreateAnAccountButton() {
        createAnAccountButton.click();
    }

    public List<WebElement> getErrorText() {
        return driver.findElements(By.xpath("//*[contains(@class, 'alert alert-danger')]//li"));
    }

}
